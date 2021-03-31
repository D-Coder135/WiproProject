package com.wipro.candidate.bean;

import com.wipro.candidate.util.DBUtil;

import java.sql.Connection;

public class CandidateBean {
    public static void main(String[] args) {
        Connection connection = DBUtil.getDBConn();
        System.out.println(connection);
    }
}
