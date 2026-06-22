package com.Appointment.Appointment.Controller;

import com.Appointment.Appointment.Dto.GetAppointmentDto;
import com.Appointment.Appointment.Dto.MakeAppointmentDto;
import com.Appointment.Appointment.Exception.ResourceNotFoundException;
import com.Appointment.Appointment.Service.AppointmentServiceI;
import jakarta.validation.Valid;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class InternalServicesController {

    private AppointmentServiceI appointmentServiceI;

    @PostMapping("/internal/create/appointment")
    public Boolean createAppointment(@Valid @RequestBody MakeAppointmentDto input, @RequestParam  Long patientId) throws InterruptedException {

         Boolean isCreated = appointmentServiceI.createAppointment(input,patientId);
         if(!isCreated){
             throw  new InternalServerErrorException("The is server " +
                     "issue appointment cant be made please try again later");
         }
         return true;
    }
    @GetMapping("get/appointment")
    public List<GetAppointmentDto> getAppointment(@RequestParam Long id){
            return  appointmentServiceI.getAppointmentDetails(id);
    }
}
