package com.lian.group.Service;

import com.lian.group.Entity.Formula;

import java.util.List;

public interface FormulaService {
    Formula findOne(Integer ID) throws Exception;
    List<Formula> findAll();
}
