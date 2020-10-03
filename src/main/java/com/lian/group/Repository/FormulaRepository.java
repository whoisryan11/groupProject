package com.lian.group.Repository;

import com.lian.group.Entity.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormulaRepository extends JpaRepository<Formula,Integer> {
    Formula findFormulaById(Integer formulaId);
    List<Formula> findAll();
    void deleteById(Integer integer);
    List<Formula> findAllByCostCode(String costCode);
    List<Formula> findAllByItemId(Integer itemId);
    List<Formula>  findAllByEditable(boolean editable);
}
