package com.lian.group.Security;

public class InsertFormulaColumnRequest {
    private String field;
    private String type;
    private String formula;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public InsertFormulaColumnRequest(){

    }

    public InsertFormulaColumnRequest(String field, String type, String formula) {
        this.field = field;
        this.type = type;
        this.formula = formula;
    }
}
