package com.duck.go2ductor.controller;


import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.JwtResponse;
import com.duck.go2ductor.dao.LoginRequest;
import com.duck.go2ductor.entity.Patient;
import com.duck.go2ductor.entity.Physician;
import com.duck.go2ductor.security.JwtTokenUtil;
import com.duck.go2ductor.service.PatientService;
import com.duck.go2ductor.service.PhysicianService;
import com.duck.go2ductor.service.impl.PatientDetailsServiceImpl;
import com.duck.go2ductor.service.impl.PhysicianDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private PhysicianDetailsServiceImpl physicianDetailsService;

	@Autowired
	private PatientDetailsServiceImpl patientDetailsService;
	@Autowired
	private PhysicianService physicianService;
	@Autowired
	private PatientService patientService;

	@PostMapping("/physician/login")
	public ResponseEntity<?> physicianLogin(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(),
						loginRequest.getPassword(),
						physicianDetailsService.loadUserByUsername(loginRequest.getUsername()).getAuthorities()
				)
		);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenUtil.generateToken(authentication);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping("/patient/login")
	public ResponseEntity<?> patientLogin(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(),
						loginRequest.getPassword(),
						patientDetailsService.loadUserByUsername(loginRequest.getUsername()).getAuthorities()
				)
		);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenUtil.generateToken(authentication);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping("/physician/register")
	public ResponseEntity<?> physicianRegister(@RequestBody Physician physician) {
		return ResponseEntity.ok(physicianService.addPhysician(physician));
	}

	@PostMapping("/patient/register")
	public ResponseEntity<?> patientRegister(@RequestBody Patient patient) {
		patientService.addPatient(patient);

		return ResponseEntity.ok(new ApiResponse(true, "Patient registered successfully"));
	}
}