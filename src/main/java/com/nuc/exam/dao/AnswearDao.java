package com.nuc.exam.dao;

import com.nuc.exam.entity.Answear;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("answearDao")
public interface AnswearDao {

    public int insertAnswear(Answear answear);//插入答案

    public int updateAnswear(Answear answear);//提供答案|更新答案

    public int updateScore(Answear answear);//判分
    //查询该考生的这次考试的答案
    public List<Answear> selectAnswear(@Param("examId") Integer examId, @Param("studentNumber") String studentNumber);
    //查询该考生的成绩
    public int selectScore(@Param("examId") Integer examId,@Param("studentNumber") String studentNumber);

}
