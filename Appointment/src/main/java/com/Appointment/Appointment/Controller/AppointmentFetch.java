package com.Appointment.Appointment.Controller;

import com.Appointment.Appointment.Dto.GetAppointmentDetailsDto;
import com.Appointment.Appointment.Entity.Appointment;
import com.Appointment.Appointment.Service.AppointmentServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AppointmentFetch {
    private AppointmentServiceI appointmentServiceI;

    @GetMapping("/get/appointments")
    public List<GetAppointmentDetailsDto> getAllAppointment(){
           return  appointmentServiceI.fetchAllAppointment();
    }
}
