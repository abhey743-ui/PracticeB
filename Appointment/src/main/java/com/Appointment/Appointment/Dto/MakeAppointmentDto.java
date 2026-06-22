package com.Appointment.Appointment.Dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakeAppointmentDto {
     @NotBlank(message = "doctor name cannot be blank")
     private String doctorName;
    @NotBlank(message = "doctor speciality  cannot be blank")
     private String doctorSpeciality;

    @NotBlank(message = "Appointment reason cannot be blank")
     private String appointmentReason;

    @NotBlank(message = "Appointment date and time cannot be blank")
     private String appointmentDateAndTime;

    @NotBlank(message = "Appointment created time cannot be blank")
     private  String appointmentCreatedTime;

}
