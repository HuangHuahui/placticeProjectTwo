package org.basedata.word.pro.build.api;

import java.util.List;

import javax.annotation.Resource;

import org.basedata.word.pro.build.pojo.SchemaTables;
import org.basedata.word.pro.build.service.IBaseDataDesignWordService;
import org.basedata.word.pro.build.utils.DateToWordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @Copyright:   Copyright(c) 2018 hhh  Co. Ltd. All Rights Reserved.
 * @Description: TODO(数据库设计文档)
 * @Version:     1.0
 * @author : hhh
 * @date:   2018年11月23日
 */
@Api(value="数据库设计文档",tags="basedatadesignword",description="数据库设计文档",basePath="/mvc/basedatadesignword")
@RestController
@RequestMapping(value="/mvc/basedatadesignword")
public class BaseDataDesignWordController {

    private static final Logger logger = LoggerFactory.getLogger(BaseDataDesignWordController.class);
    
    @Resource
    private IBaseDataDesignWordService iBaseDataDesignWordService;
    
    @Resource
    private DateToWordUtil dateToWordUtil;
    
    @ApiOperation(value="查询数据库中的表信息")
    @RequestMapping(value="/queryTables", method=RequestMethod.POST)
    public Object queryTables(SchemaTables schemaTables){
        
        List<SchemaTables> schemaList = null;
        try {
            if(schemaTables == null){
                return null;
            }
            if(schemaTables.getTableSchema() == null 
                    || "".equals(schemaTables.getTableSchema())){
                schemaTables.setTableSchema("test");
            }
            if(schemaTables.getTableType() == null 
                    || "".equals(schemaTables.getTableType())){
                schemaTables.setTableType("BASE TABLE");
            }
            logger.info("queryTables 处理数据库：{}",schemaTables);
            schemaList = this.iBaseDataDesignWordService.queryTables(schemaTables);
            this.dateToWordUtil.toWord(schemaList);
            
        } catch (Exception e) {
            logger.error("queryTables Error:{}", e);
        } 
        return schemaList;
    }
    
}
