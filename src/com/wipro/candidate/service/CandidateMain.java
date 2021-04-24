package com.wipro.candidate.service;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.dao.CandidateDAO;
import com.wipro.candidate.util.WrongDataException;

public class CandidateMain {
    public static void main(String[] args) {

    }

    public String addCandidate(CandidateBean candidateBean) {
        String result = "";
        String grade = "";
        String finalResponse = "";
        try {
            if (exceptionConditions(candidateBean)) {
                throw new WrongDataException();
            }
            CandidateDAO candidateDAO = new CandidateDAO();
            String candidateID = candidateDAO.generateCandidateID(candidateBean.getName());
            candidateBean.setId(candidateID);
            if (candidateBean.getM1() + candidateBean.getM2() + candidateBean.getM3() >= 240) {
                result = "PASS";
                grade = "Distinction";
            } else if (candidateBean.getM1() + candidateBean.getM2() + candidateBean.getM3() >= 180 && candidateBean.getM1() + candidateBean.getM2() + candidateBean.getM3() < 240) {
                result = "PASS";
                grade = "First class";
            } else if (candidateBean.getM1() + candidateBean.getM2() + candidateBean.getM3() >= 150 && candidateBean.getM1() + candidateBean.getM2() + candidateBean.getM3() < 180) {
                result = "PASS";
                grade = "Second class";
            } else if (candidateBean.getM1() + candidateBean.getM2() + candidateBean.getM3() >= 105 && candidateBean.getM1() + candidateBean.getM2() + candidateBean.getM3() < 150) {
                result = "PASS";
                grade = "Third class";
            } else {
                result = "FAIL";
                grade = "NO grade";
            }
            candidateBean.setResult(result);
        } catch (WrongDataException exception) {
            return exception.toString();
        }
        return null;
    }

    private boolean exceptionConditions(CandidateBean candidateBean) {
        return candidateBean == null || candidateBean.getName().isEmpty() || candidateBean.getName().length() < 2 ||
                candidateBean.getM1() < 0 || candidateBean.getM1() > 100 || candidateBean.getM2() < 0 ||
                candidateBean.getM2() > 100 || candidateBean.getM3() < 0 || candidateBean.getM3() > 100;
    }
}
