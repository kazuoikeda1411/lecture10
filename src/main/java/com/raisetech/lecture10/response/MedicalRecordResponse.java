package com.raisetech.lecture10.response;

import com.raisetech.lecture10.entity.MedicalRecord;

public class MedicalRecordResponse {
	private final int id;
	private final String name;
	private final String disease;
	private final String medical_condition;
	public MedicalRecordResponse(MedicalRecord medicalRecord) {
		this.id = medicalRecord.id();
		this.name = medicalRecord.name();
		this.disease = medicalRecord.disease();
		this.medical_condition = medicalRecord.medical_condition();
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
	public String getMedical_condition() {
		return medical_condition;
	}
}
