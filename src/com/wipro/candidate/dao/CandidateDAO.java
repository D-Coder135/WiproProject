package com.wipro.candidate.dao;

import com.wipro.candidate.bean.CandidateBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidateDAO {

    public static final String INSERT_QUERY = "Insert Into CANDIDATE_TBL (ID, Name, M1, M2, M3, Result, Grade)" +
            "Values (?, ?, ?, ?, ?, ?, ?)";

    public static final String READ_QUERY_1 = "SELECT * FROM CANDIDATE_TBL WHERE Result = 'PASS';";

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
        try {
            preparedStatement.setString(1, id);
        } catch (SQLException exception) {
            System.err.println("Exception Occured!");
            return "FALSE";
        }
        try {
            preparedStatement.setString(2, name);
        } catch (SQLException exception) {
            System.err.println("Exception Occured!");
            return "FALSE";
        }
        try {
            preparedStatement.setInt(3, m1);
        } catch (SQLException exception) {
            System.err.println("Exception Occured!");
            return "FALSE";
        }
        try {
            preparedStatement.setInt(4, m2);
        } catch (SQLException exception) {
            System.err.println("Exception Occured!");
            return "FALSE";
        }
        try {
            preparedStatement.setInt(5, m3);
        } catch (SQLException throwables) {
            System.err.println("Exception Occured!");
            return "FALSE";
        }
        try {
            preparedStatement.setString(6, result);
        } catch (SQLException exception) {
            System.err.println("Exception Occured!");
            return "FALSE";
        }
        try {
            preparedStatement.setString(7, grade);
        } catch (SQLException exception) {
            System.err.println("Exception Occured!");
            return "FALSE";
        }
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("Exception Occured!");
            return "FALSE";
        }
        return "TRUE";
    }

    public ArrayList<CandidateBean> getByResult(String criteria, Connection connection) {
        ArrayList<CandidateBean> arrayList = new ArrayList<>();
        CandidateBean candidateBean = new CandidateBean();
        criteria = candidateBean.getResult();
        if (criteria.equals("PASS")) {
            try {
                PreparedStatement readStatement = connection.prepareStatement(READ_QUERY_1);
            } catch (SQLException exception) {
                System.err.println("Exception Occured!");
                return null;
            }

        }
        return arrayList;
    }
}
