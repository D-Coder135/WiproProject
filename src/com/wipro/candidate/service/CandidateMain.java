package com.wipro.candidate.service;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.dao.CandidateDAO;
import com.wipro.candidate.util.DBUtil;
import com.wipro.candidate.util.WrongDataException;

import java.util.ArrayList;

public class CandidateMain {
    public static void main(String[] args) {

    }

    public String addCandidate(CandidateBean canBean) {
        String result = "";
        String grade = "";
        String finalResponse = "";
        try {
            if (exceptionConditions(canBean)) {
                throw new WrongDataException();
            }
            CandidateDAO candidateDAO = new CandidateDAO();
            String candidateID = candidateDAO.generateCandidateID(canBean.getName());
            canBean.setId(candidateID);
            if (canBean.getM1() + canBean.getM2() + canBean.getM3() >= 240) {
                result = "PASS";
                grade = "Distinction";
            } else if (canBean.getM1() + canBean.getM2() + canBean.getM3() >= 180 && canBean.getM1() + canBean.getM2() + canBean.getM3() < 240) {
                result = "PASS";
                grade = "First class";
            } else if (canBean.getM1() + canBean.getM2() + canBean.getM3() >= 150 && canBean.getM1() + canBean.getM2() + canBean.getM3() < 180) {
                result = "PASS";
                grade = "Second class";
            } else if (canBean.getM1() + canBean.getM2() + canBean.getM3() >= 105 && canBean.getM1() + canBean.getM2() + canBean.getM3() < 150) {
                result = "PASS";
                grade = "Third class";
            } else {
                result = "FAIL";
                grade = "NO grade";
            }
            canBean.setResult(result);
            canBean.setGrade(grade);
            String response = candidateDAO.addCandidate(DBUtil.getConnection(), canBean);
            if (response.equals("SUCCESS")) {
                finalResponse = String.format("%s: %s", candidateID, result);
            } else {
                finalResponse = "Error";
            }
        } catch (WrongDataException exception) {
            return exception.toString();
        }
        return finalResponse;
    }

    public ArrayList<CandidateBean> displayAll(String criteria) {
        ArrayList<CandidateBean> candidateLists = new ArrayList<>();
        CandidateDAO candidateDAO = new CandidateDAO();
        try {
            if (!criteria.equals("PASS") && !criteria.equals("FAIL") && !criteria.equals("ALL")) {
                throw new WrongDataException();
            }
            candidateLists = candidateDAO.getByResult(criteria, DBUtil.getConnection());
        } catch (WrongDataException exception) {
            return null;
        }
        return candidateLists;
    }

    private boolean exceptionConditions(CandidateBean candidateBean) {
        return candidateBean == null || candidateBean.getName().isEmpty() || candidateBean.getName().length() < 2 ||
                candidateBean.getM1() < 0 || candidateBean.getM1() > 100 || candidateBean.getM2() < 0 ||
                candidateBean.getM2() > 100 || candidateBean.getM3() < 0 || candidateBean.getM3() > 100;
    }
}
