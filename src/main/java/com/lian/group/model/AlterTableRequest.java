package com.lian.group.model;

public class AlterTableRequest {
   public String columnName;
   public String columnType;

    @Override
    public String toString() {
        return "AlterTableRequest{" +
                "columnName='" + columnName + '\'' +
                ", columnType='" + columnType + '\'' +
                '}';
    }

    public AlterTableRequest(String columnName, String columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnType() {
        return columnType;
    }
}
