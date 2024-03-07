package org.example.architcturejee1.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.architcturejee1.bean.Patinet;
import org.example.architcturejee1.dao.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class PatentControlleur {
    @Autowired
    private PatientDao patientDao;
    @GetMapping(path = "/index")
    public String patients(Model model){
        List<Patinet> patinets=patientDao.findAll();
        model.addAttribute("listpatients",patinets);
        return  "patients.html";
    }
}
