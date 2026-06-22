package com.Appointment.Appointment.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class GetAppointmentDetailsDto {

    private String doctorName;
    private String doctorSpeciality;

    private String appointmentReason;

    private String appointmentDateAndTime;

    private  String appointmentCreatedTime;

    private Long patientId;
}
