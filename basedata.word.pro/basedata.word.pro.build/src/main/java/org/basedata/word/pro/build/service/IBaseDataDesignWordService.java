package org.basedata.word.pro.build.service;

import java.sql.SQLException;
import java.util.List;

import org.basedata.word.pro.build.pojo.SchemaColumns;
import org.basedata.word.pro.build.pojo.SchemaTables;

public interface IBaseDataDesignWordService {

    /**
     * 查询数据库中的表信息
     * @param tableSchema
     * @return
     * @throws Exception
     */
    public List<SchemaTables> queryTables(SchemaTables tableSchema) throws Exception;
    
    /**
     * 
     * 查询数据库中的表字段信息
     * @param tableSchema
     * @return
     * @throws SQLException
     */
    public List<SchemaColumns> queryColumns(SchemaColumns schemaColumns) throws Exception;
}
