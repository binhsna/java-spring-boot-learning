package com.binhnc.student_management.controller;


import com.binhnc.student_management.entity.Classes;
import com.binhnc.student_management.entity.Subject;
import com.binhnc.student_management.repository.ClassRepository;
import com.binhnc.student_management.serivce.ClassService;
import com.binhnc.student_management.serivce.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassService service;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/class")
    public String showClassList(Model model) {
        List<Classes> listClass = service.findAll();
        model.addAttribute("listClass", listClass);
        return "class_index";
    }

    @GetMapping("/class/new")
    public String showNewForm(Model model) {
        List<Subject> listSubject = subjectService.findAll();
        model.addAttribute("allSubjects", listSubject);
        model.addAttribute("myclass", new Classes());
        model.addAttribute("pageTitle", "Thêm mới lớp học");
        return "class_form";
    }

    @GetMapping("/class/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Classes c = service.findById(id).get();
            model.addAttribute("myclass", c);

            // Lấy danh sách môn học đã được chọn trước đó
//            List<Subject> selectedSubjects = c.getRl_class_subject();

            List<Subject> listSubject = new ArrayList<>();
            for (Object[] o : classRepository.listSubject()) {
                Subject subject = new Subject();
                subject.setId(Long.parseLong(String.valueOf(o[0])));
                subject.setName(String.valueOf(o[1]));

//                // Đánh dấu các môn học đã được chọn trước đó
//                if (selectedSubjects.contains(subject)) {
//                    subject.setSelected(true);
//                } else {
//                    subject.setSelected(false);
//                }
                listSubject.add(subject);
            }
            model.addAttribute("allSubjects", listSubject);
            model.addAttribute("pageTitle", "Sửa thông tin lớp học ID: " + id + "");
            return "class_form";
        } catch (Exception e) {
            ra.addFlashAttribute("error_message", e.getMessage());
            return "redirect:/class";
        }
    }

    @PostMapping("/class/save")
    public String saveClass(Classes c, RedirectAttributes ra) {
        service.save(c);
        ra.addFlashAttribute("success_message", "Lưu thông tin thành công");
        return "redirect:/class";
    }

    @GetMapping("/class/delete/{id}")
    public String deleteClass(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            service.deleteById(id);
            ra.addFlashAttribute("success_message", "Xóa lớp thành công");
        } catch (Exception e) {
            ra.addFlashAttribute("error_message", e.getMessage());
        }
        return "redirect:/class";
    }
}
