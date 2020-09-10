package com.lian.group.Service;

import com.lian.group.Entity.Formula;

import java.util.List;

public interface FormulaService {
    Formula findOne(Integer id) throws Exception;

    List<Formula> findAll();

    List<Formula> findByCostCode(Integer costCode) throws Exception;

    List<Formula> findByItemId(Integer itemID) throws Exception;

    List<Formula> findByEditable(boolean editable) throws Exception;

    void deleteOne(Integer id) throws Exception;

    void addOne(Integer costCode, Integer itemID, boolean editable);

    void updateCostCode(Integer id, Integer costCode) throws Exception;

    void updateItemId(Integer id, Integer itemID) throws Exception;

    void updateEditable(Integer id, boolean editable) throws Exception;
}
