package com.cth.dao;

import com.cth.entity.Exam;
import com.cth.myUtil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDao {
    JDBCUtil jdbc = new JDBCUtil();
    Connection con = jdbc.getConnection();
    PreparedStatement ps=null;
    ResultSet rs=null;
    public int addQuestion(Exam exam){
        String sql="insert into exam(title,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";
        int i=0;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,exam.getTitle());
            ps.setString(2,exam.getOptionA());
            ps.setString(3,exam.getOptionB());
            ps.setString(4,exam.getOptionC());
            ps.setString(5,exam.getOptionD());
            ps.setString(6,exam.getAnswer());
            i = ps.executeUpdate();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            jdbc.close(con,ps,null);
        }
        return i;
    }
    public Exam queryQuestion(Integer questionId){
        String sql="select * from exam where questionId=?";
        Exam exam=null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,questionId);
            rs = ps.executeQuery();
            while (rs.next())
            {
                int qId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                exam = new Exam(qId, title, optionA, optionB, optionC, optionD, answer);

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            jdbc.close(con,ps,rs);
        }
        return exam;
    }

    public List questionAuto(){
        String sql="select * from exam order by RAND() LIMIT 0,3";
        List list = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                int questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Exam exam = new Exam(questionId, title, optionA, optionB, optionC, optionD, answer);
                list.add(exam);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
  
    public List queryQuestion(){
        List list = new ArrayList();
        String sql="select * from exam ";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                int questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Exam exam = new Exam(questionId, title, optionA, optionB, optionC, optionD, answer);
                list.add(exam);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            jdbc.close(con,ps,rs);
        }
        return list;
    }

    public int deleteQuestion(Integer questionId){
        String sql="delete from exam where questionId=?";
        int i = 0;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,questionId);
            i = ps.executeUpdate();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            jdbc.close(con,ps,rs);
        }
        return i;
    }

}
