package com.Appointment.Appointment.Dto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAppointmentDto {
    private Long id;

    private Long patientId;

    private String doctorName;

    private String doctorSpeciality;

    private String appointmentReason;

    private String appointmentDateAndTime;

    private  String appointmentCreatedTime;
}
