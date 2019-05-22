package com.nuc.exam.web;

import com.nuc.exam.entity.*;
import com.nuc.exam.service.*;
import com.nuc.exam.util.OutputExcel;
import com.nuc.exam.util.PageBean;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private FillquestionService fillquestionService;
    @Autowired
    private JudgequestionService judgequestionService;
    @Autowired
    private MultiquestionService multiquestionService;
    @Autowired
    private ProgramquestionService programquestionService;

    private static final Logger log=Logger.getLogger(String.valueOf(AdminController.class));

    @RequestMapping(value = "to_login",method = RequestMethod.GET)
    public String to_login(){
        return "admin/login";
    }

    /**
     * 管理员登录
     * @param loginName
     * @param password
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(value = "loginName",required = false) String loginName,
                        @RequestParam(value = "password",required = false) String password, HttpSession httpSession,Map<String,Object> map){
        Admin admin=adminService.login(loginName,password);
        if(admin==null){
            return "admin/login";
        }else{
            if(admin.getAdminPassword().equals(password)){
                httpSession.setAttribute("admin",admin);
                map.put("admin",admin);
                return "admin/index";
            }else{
                return "admin/login";
            }
        }
    }
    /**
     * 修改密码
     * @param adminPassword
     */
    @RequestMapping(value = "/update_password",method = RequestMethod.POST)
    @ResponseBody
    public boolean update_passsword(String adminPassword,HttpSession httpSession){
        Admin admin= (Admin) httpSession.getAttribute("admin");
        httpSession.removeAttribute("admin");
        String adminName=admin.getAdminName();
        if(adminService.updatePassword(adminName,adminPassword)){
            admin.setAdminPassword(adminPassword);
            httpSession.setAttribute("admin",admin);
            return true;
        }else{
            return false;
        }
    }
    @RequestMapping(value = "/updateStudent",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateStudent(Student student,HttpSession httpSession){
        int studentId= (int) httpSession.getAttribute("studentId");
        student.setStudentId(studentId);
        httpSession.removeAttribute("studentId");
        if(studentService.update(student)!=0){
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping(value = "/to_manage_student",method = RequestMethod.GET)
    public String to_manage_student(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage, Map<String,Object> map,HttpSession httpSession){
        Admin admin= (Admin) httpSession.getAttribute("admin");
        List<Student> studentList=studentService.findByPage(currentPage).getList();
        PageBean<Student> pageBean=studentService.findByPage(currentPage);
        map.put("admin",admin);
        map.put("pageBean",pageBean);
        map.put("studentList",studentList);
        return "admin/manage_student";
    }
    @RequestMapping(value = "/to_edit_student",method = RequestMethod.GET)
    public String to_edit_student( Integer studentId,Map<String,Object> map,HttpSession httpSession){
        Student student = studentService.selectByStudentId(studentId);
        httpSession.setAttribute("studentId",studentId);
        map.put("student",student);
        return "admin/edit_student";
    }

    @RequestMapping(value = "/remove_student",method = RequestMethod.GET)
    public String remove_student(@RequestParam("studentId") Integer studentId){
        studentService.deleteByStudentId(studentId);
        return "redirect:to_manage_student";
    }
    @RequestMapping(value = "/insertStudent",method = RequestMethod.POST)
    @ResponseBody
    public boolean insertStudent(Student student){
        int number=studentService.reigster(student);
        if(number==0){
            return false;
        }else {
            return true;
        }
    }
    /**
     * 教师管理
     * @param currentPage
     * @param map
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/to_manage_teacher",method = RequestMethod.GET)
    public String to_manage_teacher(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage, Map<String,Object> map,HttpSession httpSession){
        Admin admin= (Admin) httpSession.getAttribute("admin");
        List<Teacher> teacherList=teacherService.findByPage(currentPage).getList();
        PageBean<Teacher> pageBean=teacherService.findByPage(currentPage);
        map.put("admin",admin);
        map.put("pageBean",pageBean);
        map.put("teacherList",teacherList);
        return "admin/manage_teacher";
    }
    @RequestMapping(value = "/to_edit_teacher",method = RequestMethod.GET)
    public String to_edit_teacher( Integer teacherId,Map<String,Object> map,HttpSession httpSession){
        Teacher teacher=teacherService.selectById(teacherId);
        httpSession.setAttribute("teacherId",teacherId);
        map.put("teacher",teacher);
        return "admin/edit_teacher";
    }
    @RequestMapping(value = "/updateTeacher",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateTeacher(Teacher teacher,HttpSession httpSession){
        int teacherId= (int) httpSession.getAttribute("teacherId");
        teacher.setTeacherId(teacherId);
        httpSession.removeAttribute("teacherId");
        if(teacherService.update(teacher)!=0){
            return true;
        }else{
            return false;
        }
    }
    @RequestMapping(value = "/remove_teacher",method = RequestMethod.GET)
    public String remove_teacher(@RequestParam("teacherId") Integer teacherId){
        teacherService.deleteByTeacherId(teacherId);
        return "redirect:to_manage_teacher";
    }
    @RequestMapping(value = "/insertTeacher",method = RequestMethod.POST)
    @ResponseBody
    public boolean insertTeacher(Teacher teacher){
        int number=teacherService.register(teacher);
        if(number==0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 选择题管理
     * @param currentPage
     * @param map
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/to_manage_multi_question",method = RequestMethod.GET)
    public String to_manage_multi_question(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage, Map<String,Object> map,HttpSession httpSession){
        Admin admin= (Admin) httpSession.getAttribute("admin");
        List<Multiquestion> multiquestionList=multiquestionService.findByPage(currentPage).getList();
        PageBean<Multiquestion> pageBean=multiquestionService.findByPage(currentPage);
        map.put("admin",admin);
        map.put("pageBean",pageBean);
        map.put("multi_questionList",multiquestionList);
        return "admin/manage_multiquestion";
    }
    @RequestMapping(value = "/to_edit_multi_question",method = RequestMethod.GET)
    public String to_edit_multi_question( Integer questionId,Map<String,Object> map,HttpSession httpSession){
        Multiquestion multiquestion=multiquestionService.selectById(questionId);
        httpSession.setAttribute("questionId",questionId);
        map.put("multiquestion",multiquestion);
        return "admin/edit_multiquestion";
    }
    @RequestMapping(value = "/updateMulti_question",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateMulti_question(Multiquestion multiquestion,HttpSession httpSession){
        int questionId= (int) httpSession.getAttribute("questionId");
        multiquestion.setQuestionId(questionId);
        httpSession.removeAttribute("questionId");
        if(multiquestionService.updateMultiquestion(multiquestion)!=0){
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping(value = "/remove_multi_question",method = RequestMethod.GET)
    public String remove_multi_question(@RequestParam("questionId") Integer questionId){
        multiquestionService.deleteMultiquestion(questionId);
        return "redirect:to_manage_multi_question";
    }
    @RequestMapping(value = "/insertMulti_question",method = RequestMethod.POST)
    @ResponseBody
    public boolean insertMulti_question(Multiquestion multiquestion){
        int number=multiquestionService.addMultiquestion(multiquestion);
        if(number==0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 填空题管理
     * @param currentPage
     * @param map
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/to_fill_multi_question",method = RequestMethod.GET)
    public String to_manage_fill_question(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage, Map<String,Object> map,HttpSession httpSession){
        Admin admin= (Admin) httpSession.getAttribute("admin");
        List<Fillquestion> fillquestionList=fillquestionService.findByPage(currentPage).getList();
        PageBean<Fillquestion> pageBean=fillquestionService.findByPage(currentPage);
        map.put("admin",admin);
        map.put("pageBean",pageBean);
        map.put("fill_questionList",fillquestionList);
        return "admin/manage_fillquestion";
    }
    /**
     * 个人信息
     * @param httpSession
     * @param map
     * @return
     */
    @RequestMapping(value = "/to_index",method = RequestMethod.GET)
    public String to_index(HttpSession httpSession,Map<String,Object> map){
        Admin admin= (Admin) httpSession.getAttribute("admin");
        map.put("admin",admin);
        return "admin/index";
    }

    /**
     * 通过查询班号查询学生信息
     * @param studentClass
     * @return
     */
    @RequestMapping(value = "/selectByClass",method = RequestMethod.POST)
    @ResponseBody
    public List<Student> selectByClass(String studentClass){
        List<Student> studentList=studentService.queryStudentByClass(studentClass);
        System.out.println(studentList.toString());
        return studentList;
    }



    /**
     * 通过查询专业名查询学生信息
     * @param studentClassName
     * @return
     */
    @RequestMapping(value = "/selectByClassName",method = RequestMethod.POST)
    @ResponseBody
    public List<Student> selectByClassName(String studentClassName){
        List<Student> studentList=studentService.queryStudentByClassName(studentClassName);
        System.out.println(studentList.toString());
        return studentList;
    }
    @RequestMapping(value = "/selectAllTeacher",method =RequestMethod.POST)
    @ResponseBody
    public List<Teacher> selectAllTeacher(){
        List<Teacher> teacherList=teacherService.selectAll();
        System.out.println(teacherList.toString());
        return teacherList;
    }

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload(){
        return "admin/upload";
    }
    @RequestMapping(value = "/input_Student_Excel",method = RequestMethod.POST)
    @ResponseBody
    public String input_Student_Excel(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String flag="02";
        if(!file.isEmpty()){
            try{
                String originalFilename=file.getOriginalFilename();
                log.info("文件名:"+originalFilename);
                InputStream is = file.getInputStream();
                flag=studentService.InputExcel(is,originalFilename);
            } catch (IOException e) {
                flag="03";
                e.printStackTrace();
            }
        }
        return flag;
    }
    @RequestMapping(value = "/output_Student_Excel",produces = "application/form-data;charset=utf-8")
    public String output_Student_Excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html,charset=utf-8");
        List<Student> list=studentService.OutputExcel();
        String message= OutputExcel.OutStudentExcel(request,response,list);
        if(message.equals("fail")){
            ServletOutputStream out=response.getOutputStream();
            message="导出失败,请重试";
            String s="<!DOCTYPE HTML><html><head><script>alert('" + message + "');</script></head><body></body></html>";
            out.print(s);
        }
        return null;
    }
    @RequestMapping(value = "/input_Multi_Excel",method = RequestMethod.POST)
    @ResponseBody
    public String input_Multi_Excel(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String flag="02";
        if(!file.isEmpty()){
            try{
                String originalFilename=file.getOriginalFilename();
                log.info("文件名:"+originalFilename);
                InputStream is = file.getInputStream();
                flag=multiquestionService.InputExcel(is,originalFilename);
            } catch (IOException e) {
                flag="03";
                e.printStackTrace();
            }
        }
        return flag;
    }

    @RequestMapping(value = "/output_Multi_Excel",produces = "application/form-data;charset=utf-8")
    public String output_Multi_Excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("导出:"+"Hello world");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html,charset=utf-8");
        List<Multiquestion> list=multiquestionService.OutputExcel();
        String message= OutputExcel.OutMultiquestionExcel(request,response,list);
        if(message.equals("fail")){
            ServletOutputStream out=response.getOutputStream();
            message="导出失败,请重试";
            String s="<!DOCTYPE HTML><html><head><script>alert('" + message + "');</script></head><body></body></html>";
            out.print(s);
        }
        return null;
    }

    @RequestMapping(value = "/input_Judge_Excel",method = RequestMethod.POST)
    @ResponseBody
    public String input_Judge_Excel(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String flag="02";
        if(!file.isEmpty()){
            try{
                String originalFilename=file.getOriginalFilename();
                log.info("文件名:"+originalFilename);
                InputStream is = file.getInputStream();
                flag=judgequestionService.InputExcel(is,originalFilename);
            } catch (IOException e) {
                flag="03";
                e.printStackTrace();
            }
        }
        return flag;
    }
    @RequestMapping(value = "/output_Judge_Excel",produces = "application/form-data;charset=utf-8")
    public String output_Judge_Excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html,charset=utf-8");
        List<Judgequestion> list=judgequestionService.OutputExcel();
        String message= OutputExcel.OutJudgequestionExcel(request,response,list);
        if(message.equals("fail")){
            ServletOutputStream out=response.getOutputStream();
            message="导出失败,请重试";
            String s="<!DOCTYPE HTML><html><head><script>alert('" + message + "');</script></head><body></body></html>";
            out.print(s);
        }
        return null;
    }
    @RequestMapping(value = "/input_Fill_Excel",method = RequestMethod.POST)
    @ResponseBody
    public String input_Fill_Excel(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String flag="02";
        if(!file.isEmpty()){
            try{
                String originalFilename=file.getOriginalFilename();
                log.info("文件名:"+originalFilename);
                InputStream is = file.getInputStream();
                flag=fillquestionService.InputExcel(is,originalFilename);
            } catch (IOException e) {
                flag="03";
                e.printStackTrace();
            }
        }
        return flag;
    }
    @RequestMapping(value = "/output_Fill_Excel",produces = "application/form-data;charset=utf-8")
    public String output_Fill_Excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html,charset=utf-8");
        List<Fillquestion> list=fillquestionService.OutputExcel();
        String message= OutputExcel.OutFillquestionExcel(request,response,list);
        if(message.equals("fail")){
            ServletOutputStream out=response.getOutputStream();
            message="导出失败,请重试";
            String s="<!DOCTYPE HTML><html><head><script>alert('" + message + "');</script></head><body></body></html>";
            out.print(s);
        }
        return null;
    }
    @RequestMapping(value = "/input_Program_Excel",method = RequestMethod.POST)
    @ResponseBody
    public String input_Program_Excel(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String flag="02";
        if(!file.isEmpty()){
            try{
                String originalFilename=file.getOriginalFilename();
                log.info("文件名:"+originalFilename);
                InputStream is = file.getInputStream();
                flag=programquestionService.InputExcel(is,originalFilename);
            } catch (IOException e) {
                flag="03";
                e.printStackTrace();
            }
        }
        return flag;
    }
    @RequestMapping(value = "/output_Program_Excel",produces = "application/form-data;charset=utf-8")
    public String output_Program_Excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html,charset=utf-8");
        List<Programquestion> list=programquestionService.OutputExcel();
        String message= OutputExcel.OutProgramquestionExcel(request,response,list);
        if(message.equals("fail")){
            ServletOutputStream out=response.getOutputStream();
            message="导出失败,请重试";
            String s="<!DOCTYPE HTML><html><head><script>alert('" + message + "');</script></head><body></body></html>";
            out.print(s);
        }
        return null;
    }





}
