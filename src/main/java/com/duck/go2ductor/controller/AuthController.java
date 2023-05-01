package com.duck.go2ductor.controller;


import com.duck.go2ductor.dao.ApiResponse;
import com.duck.go2ductor.dao.FileUploadResponse;
import com.duck.go2ductor.dao.JwtResponse;
import com.duck.go2ductor.dao.LoginRequest;
import com.duck.go2ductor.entity.Patient;
import com.duck.go2ductor.entity.Physician;
import com.duck.go2ductor.file.FileUploadUtil;
import com.duck.go2ductor.security.JwtTokenUtil;
import com.duck.go2ductor.service.PatientService;
import com.duck.go2ductor.service.PhysicianService;
import com.duck.go2ductor.service.impl.PatientDetailsServiceImpl;
import com.duck.go2ductor.service.impl.PhysicianDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private Environment env;

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
		try {
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
		}catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
					new ApiResponse(false, "Invalid username or password")
			);
		}

	}

	@PostMapping("/patient/login")
	public ResponseEntity<?> patientLogin(@RequestBody LoginRequest loginRequest) {
		try {
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
		}catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
					new ApiResponse(false, "Invalid username or password")
			);
		}
	}
	@PostMapping(path = "/physician/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> physicianRegister(@RequestPart(value = "image", required = true) MultipartFile image,
											   @RequestParam String username,
											   @RequestParam String password,
											   @RequestParam String firstname,
											   @RequestParam String lastname,
											   @RequestParam String card_id) throws IOException {

			Physician physician = new Physician();
			physician.setUsername(username);
			physician.setPassword(password);
			physician.setFirst_name(firstname);
			physician.setLast_name(lastname);
			physician.setId_card(card_id);
			if (image.isEmpty()) {
				physician.setImage(null);
			}else {
				String uploadDir = env.getProperty("spring.servlet.multipart.location");
				byte[] bytes = image.getBytes();
				String fileName = StringUtils.cleanPath(image.getOriginalFilename());
				Path path = Paths.get(uploadDir + "/" + fileName);
				Files.write(path, bytes);
				physician.setImage(fileName);
			}
			physicianService.addPhysician(physician);
			return ResponseEntity.ok("Physician registration success!");
	}

	@PostMapping(path = "/patient/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> patientRegister(@RequestPart(value = "image", required = true) MultipartFile image,
											   @RequestParam String username,
											   @RequestParam String password,
											   @RequestParam String firstname,
											   @RequestParam String lastname,
											   @RequestParam String card_id) throws IOException {
		String uploadDir = env.getProperty("spring.servlet.multipart.location");
		String fileName = StringUtils.cleanPath(image.getOriginalFilename());
		Path path = Paths.get(uploadDir + "/" + fileName);
		Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		Patient patient = new Patient();
		patient.setUsername(username);
		patient.setPassword(password);
		patient.setFirst_name(firstname);
		patient.setLast_name(lastname);
		patient.setId_card(card_id);
		patient.setImage(uploadDir + "/" + fileName);
		patientService.addPatient(patient);
		return ResponseEntity.ok("Physician registration success!");
	}

}