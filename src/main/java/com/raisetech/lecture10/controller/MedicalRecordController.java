package com.raisetech.lecture10.controller;

import com.raisetech.lecture10.entity.IdRecord;
import com.raisetech.lecture10.request.DiseaseRequest;
import com.raisetech.lecture10.request.MedicalRecordRequest;
import com.raisetech.lecture10.response.DiseaseResponse;
import com.raisetech.lecture10.response.MedicalRecordResponse;
import com.raisetech.lecture10.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class MedicalRecordController {
	private final MedicalRecordService medicalRecordService;
	@GetMapping("/medicalRecords")
	public List<MedicalRecordResponse> getMedicalRecord() {
		return medicalRecordService.findAll().stream().map(MedicalRecordResponse::new).toList();
	}
	@GetMapping("/patients")
	public List<String> getPatients(DiseaseRequest disease) {
		return medicalRecordService.findByDisease(disease).stream().map(DiseaseResponse::name).collect(toList());
	}
	@PostMapping("/medicalRecords")
	public ResponseEntity postMedicalRecord(@RequestBody IdRecord request) {
		medicalRecordService.postMedicalRecord(request);
		return ResponseEntity.ok(Map.of("id", request.getId(), "message", "patient successfully created"));
	}
	@PatchMapping("/medicalRecords/{id}")
	public ResponseEntity patchMedicalRecord(@PathVariable("id") int id, @RequestBody MedicalRecordRequest request, UriComponentsBuilder uriBuilder) {
		URI url = uriBuilder.path("/medicalRecords/" + id).build().toUri();
		medicalRecordService.patchMedicalRecord(id, request);
		return ResponseEntity.created(url).body(Map.of("id", id, "message", "patient successfully updated"));
	}
	@DeleteMapping("/medicalRecords/{id}")
	public ResponseEntity deleteMedicalRecord(@PathVariable("id") int id, UriComponentsBuilder uriBuilder) {
		URI url = uriBuilder.path("/medicalRecords/" + id).build().toUri();
		medicalRecordService.deleteMedicalRecord(id);
		return ResponseEntity.created(url).body(Map.of("id", id, "message", "patient successfully deleted"));
	}
}
