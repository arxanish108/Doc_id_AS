package com.generateToken.generateToken.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.dto.ClinicDto;
import com.generateToken.generateToken.entities.Clinic;
import com.generateToken.generateToken.services.AppointmentService;
import com.generateToken.generateToken.services.ClinicService;
import com.generateToken.generateToken.util.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/clinic")
@CrossOrigin("http://localhost:3000")
public class ClinicController {
  @Autowired
  private ClinicService clinicService;
  @Autowired
  private AppointmentService appointmentService;

  private String extractTokenFromRequest(HttpServletRequest request) {
    // Try to extract token from Authorization header
    String authorizationHeader = request.getHeader("Authorization");
    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      return authorizationHeader.substring(7); // Skip "Bearer "
    }

    // If not found in Authorization header, try to extract from query parameter
    String tokenFromQueryParam = request.getParameter("token");
    if (tokenFromQueryParam != null) {
      return tokenFromQueryParam;
    }

    // If not found in query parameter, try to extract from cookies
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if ("token".equals(cookie.getName())) {
          return cookie.getValue();
        }
      }
    }

    // If not found in cookies, try to extract from request body (assuming it's a
    // POST request)
    // This part depends on your application's specific request structure
    // For simplicity, we'll assume a form parameter named "token"
    String tokenFromBody = request.getParameter("token");
    if (tokenFromBody != null) {
      return tokenFromBody;
    }

    // If token is not found in any location, return null
    return null;
  }

  @PostMapping("/add")
  public ResponseEntity<?> addClinicsToDoctor(HttpServletRequest httpServletRequest, @RequestBody ClinicDto clinicDto) {
    String token = extractTokenFromRequest(httpServletRequest);
    String userEmail = JwtUtil.getEmailFromToken(token);
    ClinicDto clinicDto1 = clinicService.addClinic(userEmail, clinicDto);
    if (clinicDto1 == null) {
      return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(clinicDto1, HttpStatus.CREATED);
  }

  @GetMapping("/get")
  public ResponseEntity<Clinic> getClinicById(@RequestParam String cliName) {
    System.out.println("anish");
    Optional<Clinic> clinic = clinicService.getClinicByClinicName(cliName);
    if (clinic.isPresent()) {
      return ResponseEntity.ok(clinic.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/delete/{doctor_id}/{id}")
  public ResponseEntity<?> deleteClinic(@PathVariable Long doctor_id, @PathVariable Long id) {
    System.out.println("hello");
    String str = clinicService.deleteClinic(doctor_id, id);
    return new ResponseEntity<>(str, HttpStatus.OK);
  }

  @PutMapping("update/{id}")
  public ResponseEntity<Object> updateClinic(@PathVariable Long id, @RequestBody ClinicDto updatedClinicDto) {
    try {
      ClinicDto updatedClinic = clinicService.updateClinic(id, updatedClinicDto);
      return new ResponseEntity<>(updatedClinic, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("getApt")
  public ResponseEntity<?> getAppointments(@RequestParam Long clinicId) {
    System.out.println("anish");
    List<AppointmentDTOs> appointmentDTOsList = clinicService.getAppointments(clinicId);
    if (!appointmentDTOsList.isEmpty()) {
      return ResponseEntity.ok(appointmentDTOsList);
    } else {
      return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("betweenDate")
  public List<AppointmentDTOs> getAppointmentBetweenDate(
      @RequestParam Long clinicId,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

    return clinicService.getAppointmentBetweenDate(clinicId, startDate, endDate);

  }

  @GetMapping("/getAll")
  public List<Clinic> getAllClinics() {
    return clinicService.getAllClinics();
  }

  @GetMapping("/amount")
  public ResponseEntity<Double> findAmountForClinicInDateRange(
      @RequestParam Long clinicId,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

    Double amount = clinicService.findAmountForClinicInDateRange(clinicId, startDate, endDate);

    if (amount != null) {
      return ResponseEntity.ok(amount);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{appointmentId}")
  public String deleteAppointment(@PathVariable Long appointmentId) {
    String str = clinicService.deleteAppointment(appointmentId);
    return str;
  }

}
