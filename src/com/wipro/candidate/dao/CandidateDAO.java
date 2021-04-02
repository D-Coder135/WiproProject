package com.wipro.candidate.dao;

import com.wipro.candidate.bean.CandidateBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidateDAO {

    public static final String INSERT_QUERY = "Insert Into CANDIDATE_TBL (ID, Name, M1, M2, M3, Result, Grade)" +
            "Values (?, ?, ?, ?, ?, ?, ?)";

    public String addCandidate(Connection connection, CandidateBean candidateBean) {
        String id = candidateBean.getId();
        String name = candidateBean.getName();
        int m1 = candidateBean.getM1();
        int m2 = candidateBean.getM2();
        int m3 = candidateBean.getM3();
        String result = candidateBean.getResult();
        String grade = candidateBean.getGrade();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
        } catch (SQLException exception) {
            System.err.println("Exception Occured!");
            return "FALSE";
        }
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, m1);
        preparedStatement.setInt(4, m2);
        preparedStatement.setInt(5, m3);
        preparedStatement.setString(6, result);
        preparedStatement.setString(7, grade);
        preparedStatement.executeUpdate();
        return "TRUE";
    }
}
