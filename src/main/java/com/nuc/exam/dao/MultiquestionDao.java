package com.nuc.exam.dao;

import com.nuc.exam.entity.Judgequestion;
import com.nuc.exam.entity.Multiquestion;
import com.nuc.exam.entity.Student;
import com.nuc.exam.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("multiquestionDao")
public interface MultiquestionDao {

    public int insertMultiquestion( Multiquestion multiquestion);

    public int updateMultiquestion(Multiquestion multiquestion);

    public int deleteMultiquestion(Integer questionId);

    public List<Multiquestion> selectMultiquestion(String questionChapter);

    public Multiquestion selectById(Integer questionId);

    public void InputExcel(Map<String,Object> ginsenMap);

    List<Multiquestion> getAll();

    public  List<Multiquestion> findByPage(HashMap<String, Object> hashMap);

    public int selectCount();
}
