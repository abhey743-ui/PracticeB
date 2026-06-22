package com.Appointment.Appointment.Repository;

import com.Appointment.Appointment.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo  extends JpaRepository<Appointment,Long> {
    List<Appointment> findByPatientId(Long patientId);

    List<Appointment> findAllByPatientId(Long patientId);
}
