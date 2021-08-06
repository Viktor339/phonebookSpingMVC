package app.controller;


import app.DAO.DirectoryDAO;
import app.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/directory")
public class ListController {

    public final DirectoryDAO directoryDAO;

    @Autowired
    public ListController(DirectoryDAO directoryDAO) {
        this.directoryDAO = directoryDAO;
    }

    @GetMapping()
    public String showDirectory(Model model) {
        model.addAttribute("directory", directoryDAO.showDirectory());
        return "directory";
    }

    @GetMapping("/{id}")
    public String getNotationByUserId(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", directoryDAO.getNotationByUserId(id));
        return "personData";
    }

    @GetMapping("/new")
    public String newNotation(Model model) {
        model.addAttribute(new Person());
        return "new";
    }

    @PostMapping
    public String addNewNotation(@ModelAttribute("person") @Valid Person person,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "new";
        }
        directoryDAO.addNewNotation(person);
        return "redirect:/directory";
    }

    @DeleteMapping("/{id}")
    public String deleteNotation(@PathVariable("id") int id){
        directoryDAO.deleteNotation(id);
        return "redirect:/directory";
    }

    @GetMapping("/{id}/edit")
        public String editNotation(Model model,@PathVariable("id")int id){
            model.addAttribute("person",directoryDAO.getNotationByUserId(id));
            return "edit";
    }

    @PatchMapping("/{id}")
    public String updateNotation(@ModelAttribute("person") @Valid Person person,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        directoryDAO.updateNotation(person);
        return "redirect:/directory";
    }
}
