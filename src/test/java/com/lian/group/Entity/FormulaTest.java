package com.lian.group.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormulaTest {

    @Test
    void getId() {
        Integer id = 1;
        Formula formula = new Formula();
        formula.setId(1);
        assert (formula.getId().equals(id));
    }

    @Test
    void setId() {
        Integer id = 1;
        Formula formula = new Formula();
        formula.setId(1);
        assert (formula.getId().equals(id));
    }

    @Test
    void getCostCode() {
        Integer costCode = 11;
        Formula formula = new Formula();
        formula.setCostCode(11);
        assert (formula.getCostCode().equals(costCode));
    }

    @Test
    void setCostCode() {
        Integer costCode = 11;
        Formula formula = new Formula();
        formula.setCostCode(11);
        assert (formula.getCostCode().equals(costCode));
    }

    @Test
    void getItemId() {
        Integer itemID = 11;
        Formula formula = new Formula();
        formula.setItemId(11);
        assert (formula.getItemId().equals(itemID));
    }

    @Test
    void setItemId() {
        Integer itemID = 11;
        Formula formula = new Formula();
        formula.setItemId(11);
        assert (formula.getItemId().equals(itemID));
    }

    @Test
    void isEditable() {
        boolean edit = true;
        Formula formula = new Formula();
        formula.setEditable(true);
        assert (formula.isEditable()==true);
    }

    @Test
    void setEditable() {
        boolean edit = true;
        Formula formula = new Formula();
        formula.setEditable(true);
        assert (formula.isEditable()==edit);
    }

    @Test
    void getProject() {
        Formula formula = new Formula();
        Project project = new Project();
        formula.setProject(project);
        assert (formula.getProject().equals(project));
    }

    @Test
    void setProject() {
        Formula formula = new Formula();
        Project project = new Project();
        formula.setProject(project);
        assert (formula.getProject().equals(project));
    }
}