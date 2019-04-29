package com.example.prescription.web;

import com.example.prescription.model.Prescription;
import com.example.prescription.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    @Autowired
    PrescriptionService prescriptionService;
    @RequestMapping(value = "/prescription", method = RequestMethod.GET, produces = "application/json")
    public List<Prescription> listAllPrescription() {
        List<Prescription> prescriptions = prescriptionService.getAll();
        if (prescriptions.isEmpty()) {
            return null;
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return prescriptions;
    }
}
