package com.raisetech.lecture10.service;

import com.raisetech.lecture10.entity.MedicalRecord;
import com.raisetech.lecture10.exeption.BadRequestException;
import com.raisetech.lecture10.exeption.BatchUpdateException;
import com.raisetech.lecture10.exeption.ResourceNotFoundException;
import com.raisetech.lecture10.mapper.MedicalRecordMapper;
import com.raisetech.lecture10.request.DiseaseRequest;
import com.raisetech.lecture10.request.MedicalRecordRequest;
import com.raisetech.lecture10.response.DiseaseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements com.raisetech.lecture10.service.MedicalRecordService {
	private final MedicalRecordMapper medicalRecordMapper;
	public MedicalRecordServiceImpl(MedicalRecordMapper medicalRecordMapper) {
		this.medicalRecordMapper = medicalRecordMapper;
	}
	@Override
	public List<MedicalRecord> findAll() {
		return medicalRecordMapper.findAll();
	}
	@Override
	public List<DiseaseResponse> findByDisease(DiseaseRequest disease) {
		if (this.medicalRecordMapper.findByDisease(disease.getDisease()).isEmpty()) {
			throw new ResourceNotFoundException("resource not found");
		} else {
			return this.medicalRecordMapper.findByDisease(disease.getDisease());
		}
	}
	@Override
	public void postMedicalRecord(MedicalRecordRequest request) {
		if ((request.medical_condition().equals("症状あり")) || (request.medical_condition().equals("症状なし"))) {
			medicalRecordMapper.postMedicalRecord(request);
		} else {
			throw new BadRequestException("medical_condition is wrong request");
		}
	}
	@Override
	public void patchMedicalRecord(MedicalRecordRequest request) {
		if ((!request.medical_condition().equals("症状あり")) && (!request.medical_condition().equals("症状なし"))) {
			throw new BadRequestException("medical_condition is wrong request");
		} else if (!medicalRecordMapper.patchMedicalRecord(request)) {
			throw new BatchUpdateException("patient unsuccessfully updated");
		} else {
			medicalRecordMapper.patchMedicalRecord(request);
		}
	}
	@Override
	public void deleteMedicalRecord(MedicalRecordRequest request) {
		if (!medicalRecordMapper.deleteMedicalRecord(request)) {
			throw new BatchUpdateException("patient unsuccessfully deleted");
		} else {
			medicalRecordMapper.deleteMedicalRecord(request);
		}
	}
}
