package com.generateToken.generateToken.dto;

import java.util.List;

import com.generateToken.generateToken.entities.DoctorInterface;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private List<String> specialization;
    private List<String> degree;
    private int experience;
    private List<String> research_journal;
    private List<String> citations;
    private String contact;
    private String licenceNumber;
    @Column(unique = true)
    private String email;
    private String password;
    private List<ClinicDto> clinicDtoList;
    private List<String> achievements;

    @Transient
    private List<DoctorInterface> docIntr;

    // public byte[] getProfileImage() {
    // return profileImage;
    // }
    //
    // public void setProfileImage(byte[] profileImage) {
    // this.profileImage = profileImage;
    // }

}
