package com.nuc.exam.dao;

import com.nuc.exam.entity.Fillquestion;
import com.nuc.exam.entity.Multiquestion;
import org.apache.poi.common.usermodel.Fill;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("fillquestionDao")
public interface FillquestionDao {

    public int insertFillquestion(Fillquestion fillquestion);

    public int updateFillquestion(Fillquestion fillquestion);

    public int deleteFillquestion(Integer questionId);

    public List<Fillquestion> selectFillquestion(String questionChapter);

    public Fillquestion selectById(Integer questionId);

    public void InputExcel(Map<String,Object> ginsenMap);

    List<Fillquestion> getAll();

    public  List<Fillquestion> findByPage(HashMap<String, Object> hashMap);

    public int selectCount();

}
