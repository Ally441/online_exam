package com.nuc.exam.service;

import com.nuc.exam.entity.Answear;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AnswearService {

    public int insertAnswear(Answear answear);

    public int submitAnswear(Answear answear);

    public int giveScore(Answear answear);

    public List<Answear> selectAnswear(Integer examId,String studentNumber);

    public int selectScore(Integer examId,String studentNumber);

}
