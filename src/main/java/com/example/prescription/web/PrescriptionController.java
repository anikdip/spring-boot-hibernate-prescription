package com.example.prescription.web;

import com.example.prescription.model.Prescription;
import com.example.prescription.service.PrescriptionService;
import com.example.prescription.web.dto.PrescriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionService prescriptionService;

    @GetMapping
    public String showPrescriptionForm(Model model) {
        return "addPrescription";
    }

    @ModelAttribute("pres")
    public PrescriptionDto prescriptionDto() {
        return new PrescriptionDto();
    }

    @PostMapping
    public String insertPrescription(@ModelAttribute("pres") @Valid PrescriptionDto prescriptionDto,
                                      BindingResult result){

        try {

            if (result.hasErrors()) {
                return "addPrescription";
            }

            prescriptionService.save(prescriptionDto);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/prescription?success";
    }

    @GetMapping("/prescriptionList")
    public String prescriptionList(Model model){
        return "prescriptionList";
    }

    @PostMapping("/search")
    public String searchResult(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate, Model model){
        try {
            model.addAttribute("prescriptionList", prescriptionService.searchByDate(fromDate, toDate));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "prescriptionList";
    }

    @GetMapping("/editPrescription/{id}")
    public String editPrescription(@PathVariable("id") long id, Model model){
        try {
            Prescription prescription = prescriptionService.getPrescriptionById(id);

            model.addAttribute("pres", prescription);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "editPrescription";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("pres") @Valid PrescriptionDto prescriptionDto,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editPrescription";
        }

        prescriptionService.save(prescriptionDto, id);
        return "redirect:/prescription/prescriptionList?updateSuccess";
    }

    @GetMapping("/delete/{id}")
    public String deletePrescription(@PathVariable("id") long id, Model model) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        prescriptionService.deletePrescription(prescription);
        return "redirect:/prescription/prescriptionList?delete";
    }
}
