package org.basedata.word.pro.build.dao.mapper;

import java.sql.SQLException;
import java.util.List;

import org.basedata.word.pro.build.pojo.SchemaColumns;

public interface ISchemaColumnsMapper{

    /**
     * 
     * 查询数据库中的表字段信息
     * @param tableSchema
     * @return
     * @throws SQLException
     */
    public List<SchemaColumns> queryColumns(SchemaColumns schemaColumns) throws SQLException;
}
