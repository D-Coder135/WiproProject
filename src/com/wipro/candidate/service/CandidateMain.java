package com.wipro.candidate.service;

import com.wipro.candidate.bean.CandidateBean;
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
