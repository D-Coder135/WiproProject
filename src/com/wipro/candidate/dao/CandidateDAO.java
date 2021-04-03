package com.wipro.candidate.dao;

import com.wipro.candidate.bean.CandidateBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidateDAO {

    public static final String INSERT_QUERY = "Insert Into CANDIDATE_TBL (ID, Name, M1, M2, M3, Result, Grade)" +
            "Values (?, ?, ?, ?, ?, ?, ?)";
    public static final String READ_QUERY_1 = "SELECT * FROM CANDIDATE_TBL WHERE Result = 'PASS';";
    public static final String READ_QUERY_2 = "SELECT * FROM CANDIDATE_TBL WHERE Result = 'FAIL';";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "Name";
    public static final String M1_COLUMN = "M1";
    public static final String M2_COLUMN = "M2";
    public static final String M3_COLUMN = "M3";
    public static final String RESULT_COLUMN = "Result";
    public static final String GRADE_COLUMN = "Grade";
    public static final String ID = "id";
    public static final String NAME = "Name";
    public static final String M_1 = "M1";
    public static final String M_2 = "M2";
    public static final String M_3 = "M3";
    public static final String RESULT = "Result";
    public static final String GRADE = "Grade";

    public String addCandidate(Connection connection, CandidateBean candidateBean) {
        String id = candidateBean.getId();
        String name = candidateBean.getName();
        int m1 = candidateBean.getM1();
        int m2 = candidateBean.getM2();
        int m3 = candidateBean.getM3();
        String result = candidateBean.getResult();
        String grade = candidateBean.getGrade();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, m1);
            preparedStatement.setInt(4, m2);
            preparedStatement.setInt(5, m3);
            preparedStatement.setString(6, result);
            preparedStatement.setString(7, grade);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("Exception Occured!");
            return "FALSE";
        }
        return "TRUE";
    }

    public ArrayList<CandidateBean> getByResult(String criteria, Connection connection) {
        ArrayList<CandidateBean> arrayList = new ArrayList<>();
        if (criteria.equalsIgnoreCase("PASS")) {
            try {
                PreparedStatement readStatement = connection.prepareStatement(READ_QUERY_1);
                ResultSet resultSet = readStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString(ID_COLUMN);
                    String name = resultSet.getString(NAME_COLUMN);
                    int m1 = resultSet.getInt(M1_COLUMN);
                    int m2 = resultSet.getInt(M2_COLUMN);
                    int m3 = resultSet.getInt(M3_COLUMN);
                    String result = resultSet.getString(RESULT_COLUMN);
                    String grade = resultSet.getString(GRADE_COLUMN);
                    CandidateBean candidateBean = new CandidateBean(id, name, m1, m2, m3, result, grade);
                    arrayList.add(candidateBean);
                }
            } catch (SQLException exception) {
                System.err.println("Exception Occured!");
                return null;
            }
        } else if (criteria.equalsIgnoreCase("FAIl")) {
            try {
                PreparedStatement readStatement = connection.prepareStatement(READ_QUERY_2);
                ResultSet resultSet = readStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString(ID);
                    String name = resultSet.getString(NAME);
                    int m1 = resultSet.getInt(M_1);
                    int m2 = resultSet.getInt(M_2);
                    int m3 = resultSet.getInt(M_3);
                    String result = resultSet.getString(RESULT);
                    String grade = resultSet.getString(GRADE);
                    CandidateBean candidateBean = new CandidateBean(id, name, m1, m2, m3, result, grade);
                }
            } catch (SQLException exception) {
                System.err.println("Exception Occured!");
                return null;
            }
        }
        return arrayList;
    }
}
