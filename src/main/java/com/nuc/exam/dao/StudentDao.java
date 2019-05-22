package com.nuc.exam.dao;

import com.nuc.exam.entity.Multiquestion;
import com.nuc.exam.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("studentDao")
public interface StudentDao {
    /**
     * 登录
     * @param studentNumber
     * @return
     */
    public Student queryStudent(@Param("studentNumber") String studentNumber,@Param("studentPassword") String studentPassword);

    /**
     * 注册
     * @param student
     * @return
     */
    public int registerStudent(Student student);

    /**
     * 修改密码
     * @param student
     * @return
     */
    public int updateStudentPassword(Student student);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    public int updateStudent(Student student);

    /**
     * 通过学生ID查询
     * @param studentId
     * @return
     */
    public Student selectByStudentId(Integer studentId);

    /**
     * 通过学生ID删除
     * @param studentId
     */
    public void  deleteByStudentId(Integer studentId);

    /**
     * 通过班号查询班级同学
     * @param studentClass
     * @return
     */
    public List<Student> queryStudentByClass(String studentClass);

    /**
     * 通过专业名查询班级同学
     * @param studentClassName
     * @return
     */
    public List<Student> queryStudentByClassName(String studentClassName);

    /**
     * 通过execl将学生信息导入学生表
     * @param ginsenMap
     */
    public void InputExcel(Map<String,Object> ginsenMap);

    /**
     * 查询学生总数
     * @return
     */
    public int selectCount();

    /**
     * 通过execl将学生表信息导出
     * @return
     */
    public List<Student> getAll();

    /**
     * 分页
     * @param hashMap
     * @return
     */
    public List<Student> findByPage(HashMap<String,Object> hashMap);


}
