package com.binhnc.student_management.controller;


import com.binhnc.student_management.entity.Classes;
import com.binhnc.student_management.entity.Student;
import com.binhnc.student_management.serivce.ClassService;
import com.binhnc.student_management.serivce.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;
    @Autowired
    private ClassService classService;

    @GetMapping("/student")
    public String showClassList(Model model) {
        List<Student> list = service.findAll();
        model.addAttribute("listStudent", list);
        return "student_index";
    }

    @GetMapping("/student/new")
    public String showNewForm(Model model) {
        List<Classes> listClass = classService.findAll();
        model.addAttribute("classList", listClass);
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Thêm mới sinh viên");
        return "student_form";
    }

    @GetMapping("/student/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Student student = service.findById(id).get();
            model.addAttribute("student", student);
            model.addAttribute("pageTitle", "Sửa thông tin sinh viên ID: " + id + "");
            return "class_form";
        } catch (Exception e) {
            ra.addFlashAttribute("error_message", e.getMessage());
            return "redirect:/student";
        }
    }

    @PostMapping("/student/save")
    public String saveStudent(Student student, RedirectAttributes ra) {
        service.save(student);
        ra.addFlashAttribute("success_message", "Lưu thông tin thành công");
        return "redirect:/student";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteClass(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            service.deleteById(id);
            ra.addFlashAttribute("success_message", "Xóa sinh viên thành công");
        } catch (Exception e) {
            ra.addFlashAttribute("error_message", e.getMessage());
        }
        return "redirect:/class";
    }
}
