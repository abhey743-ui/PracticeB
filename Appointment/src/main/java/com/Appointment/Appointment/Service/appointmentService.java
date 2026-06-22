package com.Appointment.Appointment.Service;

import com.Appointment.Appointment.Dto.GetAppointmentDetailsDto;
import com.Appointment.Appointment.Dto.GetAppointmentDto;
import com.Appointment.Appointment.Dto.MakeAppointmentDto;
import com.Appointment.Appointment.Entity.Appointment;
import com.Appointment.Appointment.Repository.AppointmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class appointmentService implements AppointmentServiceI {

   private AppointmentRepo appointmentRepo;

   @Transactional
   @Override
   public Boolean createAppointment(MakeAppointmentDto makeAppointmentDto, Long patientId) throws InterruptedException {
       Thread.sleep(15000);
       Appointment appointment = Appointment.builder()
               .appointmentCreatedTime(makeAppointmentDto.getAppointmentCreatedTime())
               .appointmentDateAndTime(makeAppointmentDto.getAppointmentDateAndTime())
               .doctorName(makeAppointmentDto.getDoctorName())
               .doctorSpeciality(makeAppointmentDto.getDoctorSpeciality())
               .patientId(patientId)
               .build();

            appointmentRepo.save(appointment);
            return true;
   }
    @Override
    @Transactional
    public List<GetAppointmentDetailsDto> fetchAllAppointment() {

        List<Appointment> appointments = appointmentRepo.findAll();
        List<GetAppointmentDetailsDto> result = new ArrayList<>();

        for (Appointment a : appointments) {

            GetAppointmentDetailsDto app = GetAppointmentDetailsDto.builder()
                    .doctorName(a.getDoctorName())
                    .doctorSpeciality(a.getDoctorSpeciality())
                    .appointmentReason(a.getAppointmentReason())
                    .appointmentDateAndTime(a.getAppointmentDateAndTime())
                    .appointmentCreatedTime(a.getAppointmentCreatedTime())
                    .patientId(a.getPatientId())
                    .build();

            result.add(app);
        }

        return result;
    }

    @Override
    public List<GetAppointmentDto> getAppointmentDetails(Long patientId){

              List<Appointment>  appointment = appointmentRepo.findByPatientId(patientId);
              List<GetAppointmentDto> getAppointmentDtoList = new ArrayList<>();

              for(Appointment i : appointment){
                      GetAppointmentDto getAppointmentDto =   GetAppointmentDto.builder()
                                .appointmentCreatedTime(i.getAppointmentCreatedTime())
                                .appointmentReason(i.getAppointmentCreatedTime())
                                .doctorSpeciality(i.getDoctorSpeciality())
                                .appointmentDateAndTime(i.getAppointmentDateAndTime())
                                .patientId(i.getPatientId())
                                .id(i.getId())
                                .build();

                      getAppointmentDtoList.add(getAppointmentDto);
              }
              return getAppointmentDtoList;
    }
}
