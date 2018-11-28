package org.basedata.word.pro.build.dao.mapper;

import java.sql.SQLException;
import java.util.List;

import org.basedata.word.pro.build.pojo.SchemaTables;

public interface ISchemaTablesMapper{

    /**
     * 
     * 查询数据库中的表信息
     * @param tableSchema
     * @return
     * @throws SQLException
     */
    public List<SchemaTables> queryTables(SchemaTables schemaTables) throws SQLException;
}
