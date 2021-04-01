package com.wipro.candidate.dao;

import com.wipro.candidate.bean.CandidateBean;

public class CandidateDAO {

    public static final String INSERT_QUERY = "Insert Into CANDIDATE_TBL (ID, Name, M1, M2, M3, Result, Grade)" +
            "Values (?, ?, ?, ?, ?, ?, ?)";

    public String addCandidate(CandidateBean candidateBean) {
        String id = candidateBean.getId();
        String name = candidateBean.getName();
        int m1 = candidateBean.getM1();
        return "TRUE";
    }
}
