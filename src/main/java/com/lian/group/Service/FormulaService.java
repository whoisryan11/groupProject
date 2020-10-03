package com.lian.group.Service;

import com.lian.group.Entity.Formula;
import com.lian.group.Security.CreateFormulaRequest;

import java.util.List;

public interface FormulaService {
    Formula findOne(Integer id) throws Exception;

    List<Formula> findAll();

    List<Formula> findByCostCode(String costCode) throws Exception;

    List<Formula> findByItemId(Integer itemID) throws Exception;

    List<Formula> findByEditable(boolean editable) throws Exception;

    void deleteOne(Integer id) throws Exception;

    void addOne(String costCode, Integer itemID, boolean editable);

    void updateCostCode(Integer id, String costCode) throws Exception;

    void updateItemId(Integer id, Integer itemID) throws Exception;

    void updateEditable(Integer id, boolean editable) throws Exception;

    void createFormula(Integer projectId, CreateFormulaRequest request);

}
