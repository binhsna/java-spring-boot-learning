package com.binhnc.student_management.controller;


import com.binhnc.student_management.entity.Subject;
import com.binhnc.student_management.serivce.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService service;

    @GetMapping("/subject")
    public String showSubjectList(Model model) {
        List<Subject> list = service.findAll();
        model.addAttribute("listSubject", list);
        return "subject_index";
    }

    @GetMapping("/subject/new")
    public String showNewForm(Model model) {
        model.addAttribute("subject", new Subject());
        model.addAttribute("pageTitle", "Thêm mới môn học");
        return "subject_form";
    }

    @GetMapping("/subject/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Subject subject = service.findById(id).get();
            model.addAttribute("subject", subject);
            model.addAttribute("pageTitle", "Sửa thông tin môn học ID: " + id + "");
            return "subject_form";
        } catch (Exception e) {
            ra.addFlashAttribute("error_message", e.getMessage());
            return "redirect:/subject";
        }
    }

    @PostMapping("/subject/save")
    public String saveSubject(Subject subject, RedirectAttributes ra) {
        service.save(subject);
        ra.addFlashAttribute("success_message", "Lưu thông tin thành công");
        return "redirect:/subject";
    }

    @GetMapping("/subject/delete/{id}")
    public String deleteSubject(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            service.deleteById(id);
            ra.addFlashAttribute("success_message", "Xóa môn học thành công");
        } catch (Exception e) {
            ra.addFlashAttribute("error_message", e.getMessage());
        }
        return "redirect:/subject";
    }
}
