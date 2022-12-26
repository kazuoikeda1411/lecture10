package com.raisetech.lecture10.controller;

import com.raisetech.lecture10.request.DiseaseRequest;
import com.raisetech.lecture10.request.MedicalRecordRequest;
import com.raisetech.lecture10.response.DiseaseResponse;
import com.raisetech.lecture10.response.MedicalRecordResponse;
import com.raisetech.lecture10.service.MedicalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@RestController
public class MedicalRecordController {
	private final MedicalRecordService medicalRecordService;
	public MedicalRecordController(MedicalRecordService medicalRecordService) {
		this.medicalRecordService = medicalRecordService;
	}

	@GetMapping("/medicalRecords")
	public List<MedicalRecordResponse> getMedicalRecord() {
		return medicalRecordService.findAll().stream().map(MedicalRecordResponse::new).toList();
	}
	@GetMapping("/patients")
	public List<String> getPatients(DiseaseRequest disease) {
		return medicalRecordService.findByDisease(disease).stream().map(DiseaseResponse::name).collect(toList());
	}
	@PostMapping("/medicalRecord")
	public ResponseEntity postMedicalRecord(@RequestBody MedicalRecordRequest request) {
		medicalRecordService.postMedicalRecord(request);
		return ResponseEntity.ok(Map.of("id", request.id(), "message", "patient successfully created"));
	}
	@PatchMapping("/medicalRecord")
	public ResponseEntity patchMedicalRecord(@RequestBody MedicalRecordRequest request) {
		medicalRecordService.patchMedicalRecord(request);
		return ResponseEntity.ok(Map.of("id", request.id(), "message", "patient successfully updated"));
	}
	@DeleteMapping("/medicalRecord")
	public ResponseEntity deleteMedicalRecord(@RequestBody MedicalRecordRequest request) {
		medicalRecordService.deleteMedicalRecord(request);
		return ResponseEntity.ok(Map.of("id", request.id(), "message", "patient successfully deleted"));
	}
}
