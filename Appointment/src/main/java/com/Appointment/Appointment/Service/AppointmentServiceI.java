package com.Appointment.Appointment.Service;

import com.Appointment.Appointment.Dto.GetAppointmentDetailsDto;
import com.Appointment.Appointment.Dto.GetAppointmentDto;
import com.Appointment.Appointment.Dto.MakeAppointmentDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppointmentServiceI {
    @Transactional
    Boolean createAppointment(MakeAppointmentDto makeAppointmentDto, Long patientId) throws InterruptedException;

    List<GetAppointmentDetailsDto> fetchAllAppointment();

    List<GetAppointmentDto> getAppointmentDetails(Long patientId);
}
