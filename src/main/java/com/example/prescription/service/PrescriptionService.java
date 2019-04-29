package com.example.prescription.service;

import com.example.prescription.model.Prescription;
import com.example.prescription.repository.PrescriptionRepository;
import com.example.prescription.web.dto.PrescriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription save(PrescriptionDto prescriptionDto){
        Prescription prescription = new Prescription();
        prescription.setDate(prescriptionDto.getDate());
        prescription.setName(prescriptionDto.getName());
        prescription.setAge(prescriptionDto.getAge());
        prescription.setGender(prescriptionDto.getGender());
        prescription.setDiagnosis(prescriptionDto.getDiagnosis());
        prescription.setMedicines(prescriptionDto.getMedicines());
        prescription.setNext_visit_date(prescriptionDto.getNext_visit_date());

        return prescriptionRepository.save(prescription);
    }

    public Prescription save(PrescriptionDto prescriptionDto, long id){
        Prescription prescription = new Prescription();
        prescription.setId(id);
        prescription.setDate(prescriptionDto.getDate());
        prescription.setName(prescriptionDto.getName());
        prescription.setAge(prescriptionDto.getAge());
        prescription.setGender(prescriptionDto.getGender());
        prescription.setDiagnosis(prescriptionDto.getDiagnosis());
        prescription.setMedicines(prescriptionDto.getMedicines());
        prescription.setNext_visit_date(prescriptionDto.getNext_visit_date());

        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> searchByDate(String fromDate, String toDate){
        return prescriptionRepository.findByDate(fromDate, toDate);
    }

    public Prescription getPrescriptionById(long id){
        return prescriptionRepository.findOne(id);
    }

    public void deletePrescription(Prescription prescription){
        prescriptionRepository.delete(prescription);
    }

    public List<Prescription> getAll(){ return prescriptionRepository.findAll(); }
}
