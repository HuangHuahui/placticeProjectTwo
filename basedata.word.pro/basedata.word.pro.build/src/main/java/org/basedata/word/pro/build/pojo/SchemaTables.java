package org.basedata.word.pro.build.pojo;

import java.util.List;

public class SchemaTables {

    private String tableSchema;
    private String tableName;
    private String tableType;
    private String tableComment;
    
    private List<SchemaColumns> columnList;
    
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
    public String getTableType() {
        return tableType;
    }
    public void setTableType(String tableType) {
        this.tableType = tableType;
    }
    public String getTableComment() {
        return tableComment;
    }
    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }
    public List<SchemaColumns> getColumnList() {
        return columnList;
    }
    public void setColumnList(List<SchemaColumns> columnList) {
        this.columnList = columnList;
    }

}
