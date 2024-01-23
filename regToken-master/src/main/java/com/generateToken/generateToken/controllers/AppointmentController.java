package com.generateToken.generateToken.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generateToken.generateToken.dto.AppointmentDTOs;
import com.generateToken.generateToken.entities.Appointment;
import com.generateToken.generateToken.services.AppointmentService;
import com.generateToken.generateToken.util.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/appointment")
@CrossOrigin("http://localhost:3000")
public class AppointmentController {

  @Autowired
  private AppointmentService appointmentService;

  @PostMapping("/book1")
  public AppointmentDTOs bookAppointment(HttpServletRequest httpServletRequest,
      @RequestParam Long clinicId,
      @RequestBody AppointmentDTOs appointmentPatient) {
    String token = extractTokenFromRequest(httpServletRequest);
    String email = JwtUtil.getEmailFromToken(token);

    return appointmentService.bookAppointment(email, clinicId, appointmentPatient);
  }

  @GetMapping("/getByNumber")
  public ResponseEntity<List<Appointment>> getPatientByAadhar(@RequestParam String aadharCardNumber) {

    List<Appointment> patient = appointmentService.getByAadhar(aadharCardNumber);

    if (patient != null) {
      return ResponseEntity.ok(patient);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/getByAbhaNumber")
  public ResponseEntity<List<Appointment>> getPatientByAbhaNumber(@RequestParam String abhaNumber) {

    List<Appointment> patient = appointmentService.getByAbhaNumber(abhaNumber);

    if (patient != null) {
      return ResponseEntity.ok(patient);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

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

}
