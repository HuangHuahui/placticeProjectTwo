package org.basedata.word.pro.build.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.basedata.word.pro.build.dao.mapper.ISchemaColumnsMapper;
import org.basedata.word.pro.build.dao.mapper.ISchemaTablesMapper;
import org.basedata.word.pro.build.pojo.SchemaColumns;
import org.basedata.word.pro.build.pojo.SchemaTables;
import org.basedata.word.pro.build.service.IBaseDataDesignWordService;
import org.springframework.stereotype.Service;

@Service
public class BaseDataDesignWordServiceImpl implements IBaseDataDesignWordService{
    
    @Resource
    private ISchemaTablesMapper iSchemaTablesMapper;
    @Resource
    private ISchemaColumnsMapper iSchemaColumnsMapper;

    @Override
    public List<SchemaTables> queryTables(SchemaTables tableSchema) throws Exception {
        return this.iSchemaTablesMapper.queryTables(tableSchema);
    }

    @Override
    public List<SchemaColumns> queryColumns(SchemaColumns schemaColumns) throws Exception {
        return this.iSchemaColumnsMapper.queryColumns(schemaColumns);
    }

}
