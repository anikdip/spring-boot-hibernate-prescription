package com.example.prescription.web.dto;

import javax.validation.constraints.NotEmpty;

public class PrescriptionDto {
    @NotEmpty
    private String date;
    @NotEmpty
    private String name;
    @NotEmpty
    private String age;
    @NotEmpty
    private String gender;
    private String diagnosis;
    private String medicines;
    private String next_visit_date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getNext_visit_date() {
        return next_visit_date;
    }

    public void setNext_visit_date(String next_visit_date) {
        this.next_visit_date = next_visit_date;
    }
}
