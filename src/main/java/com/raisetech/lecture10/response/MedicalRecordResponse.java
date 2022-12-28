package com.raisetech.lecture10.response;

import com.raisetech.lecture10.entity.MedicalRecord;

public class MedicalRecordResponse {
	private final int id;
	private final String name;
	private final String disease;
	private final String medicalCondition;
	public MedicalRecordResponse(MedicalRecord medicalRecord) {
		this.id = medicalRecord.id();
		this.name = medicalRecord.name();
		this.disease = medicalRecord.disease();
		this.medicalCondition = medicalRecord.medicalCondition();
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDisease() {
		return disease;
	}
	public String getMedicalCondition() {
		return medicalCondition;
	}
}
