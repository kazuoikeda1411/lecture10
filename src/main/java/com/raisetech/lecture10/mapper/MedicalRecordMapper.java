package com.raisetech.lecture10.mapper;

import com.raisetech.lecture10.entity.MedicalRecord;
import com.raisetech.lecture10.request.MedicalRecordRequest;
import com.raisetech.lecture10.response.DiseaseResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MedicalRecordMapper {
	List<MedicalRecord> findAll();
	List<DiseaseResponse> findByDisease(String disease);
	void postMedicalRecord(MedicalRecordRequest request);

	boolean patchMedicalRecord(MedicalRecordRequest request);
	boolean deleteMedicalRecord(MedicalRecordRequest request);
}
