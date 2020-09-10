package com.lian.group.ServiceImpl;

import com.lian.group.Entity.Formula;
import com.lian.group.Repository.FormulaRepository;
import com.lian.group.Service.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// if forge @Service annotation, u will get compile error said u can't find this Bean
@Service
public class FormulaServiceImpl implements FormulaService {
    @Autowired
    private FormulaRepository formulaRepository;

    //--- Research
    @Override
    public Formula findOne(Integer id) throws Exception {
        Formula formula = formulaRepository.findFormulaById(id);
        if (formula == null) {
            throw new Exception("No such a formula with id==>" + id);
        }

        return formula;
    }

    @Override
    public List<Formula> findAll() {
        List<Formula> list = formulaRepository.findAll();
        return list;
    }


    @Override
    public List<Formula> findByCostCode(Integer costCode) throws Exception {
        List<Formula> list = formulaRepository.findAllByCostCode(costCode);

        if (list == null) {
            throw new Exception("No such a formula with costCode==>" + costCode);
        }
        return list;
    }

    @Override
    public List<Formula> findByItemId(Integer itemId) throws Exception {
        List<Formula> list = formulaRepository.findAllByItemId(itemId);

        if (list == null) {
            throw new Exception("No such a formula with itemId==>" + itemId);
        }
        return list;
    }

    @Override
    public List<Formula> findByEditable(boolean editable) throws Exception {
        List<Formula> list = formulaRepository.findAllByEditable(editable);

        if (list == null) {
            throw new Exception("No such a formula with editable==>" + editable);
        }
        return list;
    }

    //--- Delete
    @Override
    public void deleteOne(Integer id) throws Exception {
        Formula formula = formulaRepository.findFormulaById(id);
        if (formula == null) {
            throw new Exception("No such a formula with id==>" + id);
        }
        formulaRepository.deleteById(id);
        return;
    }

    //--- Create
    @Override
    public void addOne(Integer costCode, Integer itemId, boolean editable) {
        Formula newForm = new Formula(costCode, itemId, editable);
        formulaRepository.saveAndFlush(newForm);
    }

    //--- Update
    @Override
    public void updateCostCode(Integer id, Integer costCode) throws Exception {
        Formula formula = formulaRepository.findFormulaById(id);
        if (formula == null) {
            throw new Exception("No such a formula with id==>" + id);
        }
        formula.setCostCode(costCode);
        formulaRepository.saveAndFlush(formula);
    }


    @Override
    public void updateItemId(Integer id, Integer itemId) throws Exception {
        Formula formula = formulaRepository.findFormulaById(id);
        if (formula == null) {
            throw new Exception("No such a formula with id==>" + id);
        }
        formula.setItemId(itemId);
        formulaRepository.saveAndFlush(formula);
    }

    @Override
    public void updateEditable(Integer id, boolean editable) throws Exception {
        Formula formula = formulaRepository.findFormulaById(id);
        if (formula == null) {
            throw new Exception("No such a formula with id==>" + id);
        }
        formula.setEditable(editable);
        formulaRepository.saveAndFlush(formula);
    }

}
