package com.nuc.exam.dao;

import com.nuc.exam.entity.Grade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("gradeDao")
public interface GradeDao {

    public int insertGrade(Grade grade);

    public int updateGrade(Grade grade);

    public int deleteGrade(Grade grade);

    public Grade selectByStudentNumberAndExamId(@Param("gradeExamId") Integer gradeExamId,@Param("gradeStudentNumber") String gradeStudentNumber);

    public List<Grade> selectByClassAndExam(@Param("gradeExamId") Integer gradeExamId, @Param("gradeClass")String gradeClass );

    public List<Grade> selectByStudentNumber(String gradeStudentNumber);


}
