package com.Appointment.Appointment.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private Long patientId;

    private String doctorName;

    private String doctorSpeciality;

    private String appointmentReason;

    private String appointmentDateAndTime;

    private  String appointmentCreatedTime;

}
