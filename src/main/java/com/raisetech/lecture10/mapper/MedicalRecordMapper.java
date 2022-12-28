package com.raisetech.lecture10.mapper;

import com.raisetech.lecture10.entity.IdRecord;
import com.raisetech.lecture10.entity.MedicalRecord;
import com.raisetech.lecture10.request.MedicalRecordRequest;
import com.raisetech.lecture10.response.DiseaseResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MedicalRecordMapper {
	List<MedicalRecord> findAll();
	List<DiseaseResponse> findByDisease(String disease);
	int postMedicalRecord(IdRecord request);
	boolean patchMedicalRecord(@Param("id") int id, @Param("request") MedicalRecordRequest request);
	boolean deleteMedicalRecord(int id);
}
