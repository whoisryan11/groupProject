package com.lian.group.Repository;

import com.lian.group.Entity.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormulaRepository extends JpaRepository<Formula,Integer> {
    Formula findFormulaById(Integer formulaID);
    List<Formula> findAll();
}
