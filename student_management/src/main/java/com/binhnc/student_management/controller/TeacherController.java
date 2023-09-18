package com.binhnc.student_management.controller;


import com.binhnc.student_management.entity.Subject;
import com.binhnc.student_management.entity.Teacher;
import com.binhnc.student_management.serivce.SubjectService;
import com.binhnc.student_management.serivce.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService service;
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/teacher")
    public String showTeacherList(Model model) {
        List<Teacher> list = service.findAll();
        model.addAttribute("listTeacher", list);
        return "teacher_index";
    }

    @GetMapping("/teacher/new")
    public String showNewForm(Model model) {
        List<Subject> listSubject = subjectService.findAll();
        model.addAttribute("allSubjects", listSubject);
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("pageTitle", "Thêm mới giáo viên");
        return "teacher_form";
    }

    @GetMapping("/teacher/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Teacher t = service.findById(id).get();
            model.addAttribute("teacher", t);
            List<Subject> listSubject = subjectService.findAll();
            model.addAttribute("allSubjects", listSubject);
            model.addAttribute("pageTitle", "Sửa thông tin giáo viên ID: " + id + "");
            return "teacher_form";
        } catch (Exception e) {
            ra.addFlashAttribute("error_message", e.getMessage());
            return "redirect:/teacher";
        }
    }

    @PostMapping("/teacher/save")
    public String saveTeacher(Teacher t, RedirectAttributes ra) {
        service.save(t);
        ra.addFlashAttribute("success_message", "Lưu thông tin thành công");
        return "redirect:/teacher";
    }

    @GetMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            service.deleteById(id);
            ra.addFlashAttribute("success_message", "Xóa giáo viên thành công");
        } catch (Exception e) {
            ra.addFlashAttribute("error_message", e.getMessage());
        }
        return "redirect:/teacher";
    }
}
