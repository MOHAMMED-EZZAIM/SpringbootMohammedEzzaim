package org.example.architcturejee1.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.architcturejee1.bean.Patinet;
import org.example.architcturejee1.dao.PatientDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class PatentControlleur {
    private PatientDao patientDao;
    @GetMapping(path = "/index")
    public String patients(){
        return  "patients.html";
    }

}
