package com.nuc.exam.web;

import com.nuc.exam.entity.*;
import com.nuc.exam.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AnswearService answearService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ExamService examService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private FillquestionService fillquestionService;
    @Autowired
    private JudgequestionService judgequestionService;
    @Autowired
    private MultiquestionService multiquestionService;
    @Autowired
    private ProgramquestionService programquestionService;

    @RequestMapping(value = "/to_login", method = RequestMethod.GET)
    public String to_login() {
        return "student/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(String studentNumber, String studentPassword, HttpSession httpSession) {
        Student student = studentService.login(studentNumber, studentPassword);
        if (student == null) {
            return false;
        } else {
            httpSession.setAttribute("student",student);
            return true;
        }
    }
    @RequestMapping(value = "to_student", method=RequestMethod.GET)
    public String to_student(HttpSession httpSession, ModelAndView modelAndView, Map<String,Object> map){
        Student student = (Student) httpSession.getAttribute("student");
        List<Course> courseList = courseService.selectCourseByClassName(student.getStudentClassName());
        map.put("courseList",courseList);
        modelAndView.addObject("student",student);
        return "student/student";
    }

    @RequestMapping(value = "to_test",method = RequestMethod.GET)
    public String to_test(HttpSession httpSession,Map<String,Object> map){
        Student student = (Student) httpSession.getAttribute("student");
        List<Exam> examList = examService.selectByClassName(student.getStudentClassName());
        Map<Exam,Integer> map1=new HashMap<>();
        for(Exam exam:examList){
            if(exam.getExamStatus()!=1){
                examList.remove(exam);
            } else{
                String a = exam.getExamContext().substring(1,exam.getExamContext().length()-1);
                String []b =a.split(",");
                int []number=new int[b.length];
                for(int i=0;i<number.length;i++){
                    number[i]=Integer.parseInt(b[i]);
                    map1.put(exam,number[i]);
                }
            }
        }
        map.put("map1",map1);
        map.put("examList",examList);
        return "student/student_exam_list";
    }
    @RequestMapping(value = "/{examId}/test",method = RequestMethod.GET)
    public String test(@PathVariable Integer examId,Map<String,Object> map,HttpSession httpSession){
        int fillquestionnumber=0;
        int multiquestionnumber=0;
        int judgequestionnumber=0;
        int programquestionnumber=0;
        int fillscore=0;
        int multiscore=0;
        int judgescore=0;
        int programscore=0;
        Exam exam=examService.selectExam(examId);
        Student student = (Student) httpSession.getAttribute("student");
        String questionContext=exam.getExamContext();
        String context=questionContext.substring(1,questionContext.length()-1);
        String[] str=context.split(",");
        int []number=new int[str.length];
        for(int i=0;i<number.length;i++){
            number[i]=Integer.parseInt(str[i]);
            if(number[i]<20000){
                multiscore+=multiquestionService.selectById(number[i]).getScore();
                multiquestionnumber++;
            }else if(number[i]<30000){
                fillscore+=fillquestionService.selectById(number[i]).getScore();
                fillquestionnumber++;
            }else if (number[i]<40000){
                judgescore+=judgequestionService.selectById(number[i]).getScore();
                judgequestionnumber++;
            }else{
                programscore+=programquestionService.selectById(number[i]).getScore();
                programquestionnumber++;
            }
        }
        httpSession.setAttribute("questionId",number);
        map.put("multiquestionnumber",multiquestionnumber);
        map.put("multiscore",multiscore);
        map.put("fillquestionnumber",fillquestionnumber);
        map.put("fillscore",fillscore);
        map.put("judgequestionnumber",judgequestionnumber);
        map.put("judgescore",judgescore);
        map.put("programquestionnumber",programquestionnumber);
        map.put("programscore",programscore);
        map.put("exam",exam);
        map.put("student",student);
        return "student/student_exam_detail";
    }
    @RequestMapping(value = "/{examId}/exam",method = RequestMethod.GET)
    public String exam(@PathVariable Integer examId,HttpSession httpSession,Map<String,Object> map){
        Student student = (Student) httpSession.getAttribute("student");
        int []number= (int[]) httpSession.getAttribute("questionId");
        int sum=0;
        Exam exam= examService.selectExam(examId);
        List<Multiquestion> multiquestionList=new ArrayList<Multiquestion>();
        List<Fillquestion> fillquestionList=new ArrayList<Fillquestion>();
        List<Judgequestion> judgequestionList=new ArrayList<Judgequestion>();
        List<Programquestion> programquestionList=new ArrayList<Programquestion>();
        for(int i=0;i<number.length;i++){
            if(number[i]<20000){
                multiquestionList.add(multiquestionService.selectById(number[i]));
                sum+=multiquestionService.selectById(number[i]).getScore();
            }else if(number[i]<30000){
                fillquestionList.add(fillquestionService.selectById(number[i]));
                sum+=fillquestionService.selectById(number[i]).getScore();
            }else if(number[i]<40000){
                judgequestionList.add(judgequestionService.selectById(number[i]));
                sum+=judgequestionService.selectById(number[i]).getScore();
            }else{
                programquestionList.add(programquestionService.selectById(number[i]));
                sum+=programquestionService.selectById(number[i]).getScore();
            }
        }
        if(gradeService.selectByStudentNumberAndExamId(examId,student.getStudentNumber())!=null){
            Grade grade=gradeService.selectByStudentNumberAndExamId(examId,student.getStudentNumber());
            Date date1=grade.getGradeExamTime();
            Date date=new Date();
            long time1=date.getTime()-date1.getTime();
            time1=time1/1000;
            long time=Integer.parseInt(exam.getExamTime())*60-time1;
            if(time<=0){
                return null;//考试时间结束
            }else{
                map.put("time",time);
            }
        }else{
            Date date = new Date();
            Grade grade=new Grade();
            grade.setGradeStudentNumber(student.getStudentNumber());
            grade.setGradeExamId(examId);
            grade.setGradeClass(student.getStudentClass());
            grade.setGradeClassName(student.getStudentClassName());
            grade.setGradeExamTime(date);
            gradeService.addGrade(grade);
            map.put("time",Integer.parseInt(exam.getExamTime())*60);
        }
        httpSession.setAttribute("exam",exam);
        map.put("exam",exam);
        map.put("sum",sum);
        map.put("multiquestionList",multiquestionList);
        map.put("fillquestionList",fillquestionList);
        map.put("judgequestionList",judgequestionList);
        map.put("programquestionList",programquestionList);
        map.put("number",number.length);
        return "student/student_exam";
    }
    @RequestMapping(value = "submit_answer",method = RequestMethod.POST)
    @ResponseBody
    public boolean submit_answer(String []multiAnswer,String []fillAnswer,String []judgeAnswer,String []programAnswer,HttpSession httpSession){
        Student student= (Student) httpSession.getAttribute("student");
        Exam exam = (Exam) httpSession.getAttribute("exam");
        if(multiAnswer==null){
            System.out.println("Hello world");
        }else{
            for(int i=0;i<multiAnswer.length;i++){
                String a=multiAnswer[i];
                String []number=a.split(":");
                int questionId=Integer.parseInt(number[0]);
                String answer=number[1];
                Answear answear=new Answear();
                answear.setStudentNumber(student.getStudentNumber());
                answear.setQuestionId(questionId);
                answear.setExamId(exam.getExamId());
                answear.setAnswear(answer);
                answearService.insertAnswear(answear);
            }
        }
        if(fillAnswer==null){
            System.out.println("Hello world");
        }else{
            for(int i=0;i<fillAnswer.length;i++){
                String a=fillAnswer[i];
                String []number=a.split(":");
                int questionId=Integer.parseInt(number[0]);
                String answer=number[1];
                Answear answear=new Answear();
                answear.setStudentNumber(student.getStudentNumber());
                answear.setQuestionId(questionId);
                answear.setExamId(exam.getExamId());
                answear.setAnswear(answer);
                answearService.insertAnswear(answear);
            }
        }
        if(judgeAnswer==null){
            System.out.println("Hello world");
        }else{
            for(int i=0;i<judgeAnswer.length;i++){
                String a=judgeAnswer[i];
                String []number=a.split(":");
                int questionId=Integer.parseInt(number[0]);
                String answer=number[1];
                Answear answear=new Answear();
                answear.setStudentNumber(student.getStudentNumber());
                answear.setQuestionId(questionId);
                answear.setExamId(exam.getExamId());
                answear.setAnswear(answer);
                answearService.insertAnswear(answear);
            }
        }
        if(programAnswer==null){
            System.out.println("Hello world");
        }else{
            for(int i=0;i<programAnswer.length;i++){
                String a=programAnswer[i];
                String []number=a.split(":");
                int questionId=Integer.parseInt(number[0]);
                String answer=number[1];
                Answear answear=new Answear();
                answear.setStudentNumber(student.getStudentNumber());
                answear.setQuestionId(questionId);
                answear.setExamId(exam.getExamId());
                answear.setAnswear(answer);
                answearService.insertAnswear(answear);
            }
        }
        exam.setExamStatus(2);
        examService.updateExam(exam);
        return true;
    }
    @RequestMapping(value = "to_history",method = RequestMethod.GET)
    public String to_history(HttpSession httpSession,Map<String,Object> map){
        Student student = (Student) httpSession.getAttribute("student");
        List<Grade> gradeList = gradeService.selectByStudentNumber(student.getStudentNumber());
        map.put("gradeList",gradeList);
        return "student/student_history";
    }
    @RequestMapping(value = "to_self",method = RequestMethod.GET)
    public String to_self(HttpSession httpSession,Map<String,Object> map){
        Student student = (Student) httpSession.getAttribute("student");
        System.out.println(student.toString());
        map.put("student",student);
        return "student/student_self";
    }
    @RequestMapping(value = "self",method = RequestMethod.GET)
    @ResponseBody
    public boolean self(Student student,HttpSession session){
        Student student1 = (Student) session.getAttribute("student");
        student.setStudentNumber(student1.getStudentNumber());
        studentService.updateStudent(student);
        student = studentService.login(student.getStudentNumber(),student.getStudentPassword());
        session.removeAttribute("student");
        session.setAttribute("student",student);
        return true;
    }

    @RequestMapping(value = "/student")
    @ResponseBody
    public Student student(HttpSession httpSession) {
            return (Student) httpSession.getAttribute("student");
    }


    @RequestMapping(value = "logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("student");
        return "redirect:to_login";
    }
}
