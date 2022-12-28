package com.raisetech.lecture10.service;

import com.raisetech.lecture10.entity.IdRecord;
import com.raisetech.lecture10.entity.MedicalRecord;
import com.raisetech.lecture10.request.DiseaseRequest;
import com.raisetech.lecture10.request.MedicalRecordRequest;
import com.raisetech.lecture10.response.DiseaseResponse;

import java.util.List;

public interface MedicalRecordService {
	List<MedicalRecord> findAll();
	List<DiseaseResponse> findByDisease(DiseaseRequest disease);
	int postMedicalRecord(IdRecord request);
	void patchMedicalRecord(int id, MedicalRecordRequest request);
	void deleteMedicalRecord(int id);
}
