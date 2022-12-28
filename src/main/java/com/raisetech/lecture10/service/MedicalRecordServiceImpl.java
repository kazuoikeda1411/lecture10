package com.raisetech.lecture10.service;

import com.raisetech.lecture10.entity.IdRecord;
import com.raisetech.lecture10.entity.MedicalRecord;
import com.raisetech.lecture10.exeption.BadRequestException;
import com.raisetech.lecture10.exeption.BatchUpdateException;
import com.raisetech.lecture10.exeption.ResourceNotFoundException;
import com.raisetech.lecture10.mapper.MedicalRecordMapper;
import com.raisetech.lecture10.request.DiseaseRequest;
import com.raisetech.lecture10.request.MedicalRecordRequest;
import com.raisetech.lecture10.response.DiseaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements com.raisetech.lecture10.service.MedicalRecordService {
	private final MedicalRecordMapper medicalRecordMapper;
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
	public int postMedicalRecord(IdRecord request) {
		if ((request.getMedicalCondition().equals("症状あり")) || (request.getMedicalCondition().equals("症状なし"))) {
			return this.medicalRecordMapper.postMedicalRecord(request);
		} else {
			throw new BadRequestException("medicalCondition is wrong request");
		}
	}
	@Override
	public void patchMedicalRecord(int id, MedicalRecordRequest request) {
		if ((!request.medicalCondition().equals("症状あり")) && (!request.medicalCondition().equals("症状なし"))) {
			throw new BadRequestException("medicalCondition is wrong request");
		}
		if (!medicalRecordMapper.patchMedicalRecord(id, request)) {
			throw new BatchUpdateException("patient unsuccessfully updated");
		}
	}
	@Override
	public void deleteMedicalRecord(int id) {
		if (!medicalRecordMapper.deleteMedicalRecord(id)) {
			throw new BatchUpdateException("patient unsuccessfully deleted");
		}
	}
}
