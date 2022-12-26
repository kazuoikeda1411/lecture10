package com.raisetech.lecture10.service;

import com.raisetech.lecture10.entity.MedicalRecord;
import com.raisetech.lecture10.request.DiseaseRequest;
import com.raisetech.lecture10.request.MedicalRecordRequest;
import com.raisetech.lecture10.response.DiseaseResponse;

import java.util.List;

public interface MedicalRecordService {
	List<MedicalRecord> findAll();
	List<DiseaseResponse> findByDisease(DiseaseRequest disease);
	void postMedicalRecord(MedicalRecordRequest request);
	void patchMedicalRecord(MedicalRecordRequest request);
	void deleteMedicalRecord(MedicalRecordRequest request);
}
