package org.basedata.word.pro.build.pojo;

public class SchemaColumns {

    private String tableSchema;
    private String tableName;
    private String columnName; 
    private String columnComment; 
    private String columnType;
    private String columnDefault; 
    private String isNullable;
    
    public String getTableSchema() {
        return tableSchema;
    }
    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getColumnComment() {
        return columnComment;
    }
    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
    public String getColumnType() {
        return columnType;
    }
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    public String getColumnDefault() {
        return columnDefault;
    }
    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }
    public String getIsNullable() {
        return isNullable;
    }
    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

}
