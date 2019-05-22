package com.nuc.exam.service.impl;

import com.nuc.exam.dao.AnswearDao;
import com.nuc.exam.entity.Answear;
import com.nuc.exam.service.AnswearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("answearService")
public class AnswearServiceImpl implements AnswearService {
    @Autowired
    private AnswearDao answearDao;

    @Override
    public int insertAnswear(Answear answear) {
        return answearDao.insertAnswear(answear);
    }

    @Override
    public int submitAnswear(Answear answear) {
        return answearDao.updateAnswear(answear);
    }

    @Override
    public int giveScore(Answear answear) {
        return answearDao.updateScore(answear);
    }

    @Override
    public List<Answear> selectAnswear(Integer examId, String studentNumber) {
        return answearDao.selectAnswear(examId,studentNumber);
    }

    @Override
    public int selectScore(Integer examId, String studentNumber) {
        return answearDao.selectScore(examId,studentNumber);
    }

}
