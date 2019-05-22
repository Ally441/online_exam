package com.nuc.exam.web;

import com.nuc.exam.service.StudentService;
import com.nuc.exam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @RequestMapping(value = "/to_login",method = RequestMethod.GET)
    public String to_login(){
        return "teacher/login";
    }
}
