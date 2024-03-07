package org.example.architcturejee1.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.architcturejee1.bean.Patinet;
import org.example.architcturejee1.dao.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Pageable;
import java.util.List;

@Controller
public class PatentControlleur {
    @Autowired
    private PatientDao patientDao;
    @GetMapping(path = "/index")
    public String patients(Model model, @RequestParam(name="page",defaultValue = "0") int page
            ,@RequestParam(name="size",defaultValue = "5") int size){
        Page<Patinet> patinets=  patientDao.findAll(PageRequest.of(page, size));
        model.addAttribute("listpatients",patinets.getContent());
        model.addAttribute("pages",new int[patinets.getTotalPages()]);
        model.addAttribute("currentPages",page);
        return  "patients.html";
    }

    @GetMapping("/delete")

    public String delete(@RequestParam("id") Long id) {
        patientDao.deleteById(id);
        return "redirect:/index";
    }
    @ResponseBody
    @GetMapping("/all")
    public List<Patinet> listPatient(){
        return patientDao.findAll();
    }



}
