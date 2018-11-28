package org.basedata.word.pro.build.utils;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.basedata.word.pro.build.Application;
import org.basedata.word.pro.build.pojo.SchemaColumns;
import org.basedata.word.pro.build.pojo.SchemaTables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.rtf.RtfWriter2;

/** 
 * 创建word文档 步骤: 
 * 1,建立文档 
 * 2,创建一个书写器 
 * 3,打开文档 
 * 4,向文档中写入数据 
 * 5,关闭文档 
 */
@Service
public class DateToWordUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateToWordUtil.class);
    
    /**
     * @param args 
     * @throws Exception 
     */
    public void toWord(List<SchemaTables> schemaTableList) throws Exception {
        // 创建word文档,并设置纸张的大小
        Document document = new Document(PageSize.A4);
        try {
            // 创建word文档
            RtfWriter2.getInstance(document, new FileOutputStream("E:/word5.doc"));
            document.open();// 设置文档标题
            Paragraph ph = new Paragraph();
            Font f = new Font();
            Paragraph p = new Paragraph("数据库表设计文档", new Font(Font.NORMAL, 24,Font.BOLDITALIC, new Color(0, 0, 0)));
            p.setAlignment(1);
            document.add(p);
            ph.setFont(f);/* * 创建表格 通过查询出来的表遍历 */
            
            for (int i = 0; i < schemaTableList.size(); i++) {
                SchemaTables schemaTables = schemaTableList.get(i);
                // 表名
//                String table_name = (String) listAll.get(i).get("table_name");
                String tableName = schemaTables.getTableName();
                // 表说明
//                String table_comment = (String) listAll.get(i).get("table_comment");
                String tableComment = schemaTables.getTableComment();
//                String sql = "SHOW FULL FIELDS FROM xmsa_trace." + table_name+ " ";
                logger.info("开始处理第{}张表，表名：{}:{}",(i+1),tableName,tableComment);
                
                //获取某张表的所有字段说明
                //List<Map<String,Object>> list = businessSupplierService.listMap(sql);
//                List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
                
                
                //创建有6列的表格
                Table table = new Table(6);
                document.add(new Paragraph(""));
                table.setBorderWidth(1);
                // table.setBorderColor(Color.BLACK);
                table.setPadding(0);
                table.setSpacing(0);
                
                /*
                * 添加表头的元素，并设置表头背景的颜色
                */
//                Color chade = new Color(176, 196, 222);
                Color chade = new Color(156, 194, 229);
                Cell cell = new Cell("序号");// 单元格
                cell.setBackgroundColor(chade);
                cell.setVerticalAlignment(Cell.ALIGN_CENTER);
                cell.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                cell.setHeader(true);
                // cell.setColspan(3);//设置表格为三列
                // cell.setRowspan(3);//设置表格为三行
                table.addCell(cell);
                
                cell = new Cell("字段名");// 单元格
                cell.setBackgroundColor(chade);
                cell.setVerticalAlignment(Cell.ALIGN_CENTER);
                cell.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                table.addCell(cell);
                
                cell = new Cell("类型");// 单元格
                cell.setBackgroundColor(chade);
                cell.setVerticalAlignment(Cell.ALIGN_CENTER);
                cell.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                table.addCell(cell);
                
                cell = new Cell("默认值");// 单元格
                cell.setVerticalAlignment(Cell.ALIGN_CENTER);
                cell.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                
                cell = new Cell("是否可为空");// 单元格
                cell.setVerticalAlignment(Cell.ALIGN_CENTER);
                cell.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                
                cell = new Cell("字段说明");// 单元格
                cell.setVerticalAlignment(Cell.ALIGN_CENTER);
                cell.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                
                table.endHeaders();// 表头结束
                
                Paragraph para = new Paragraph("该单元居中");
                //设置该段落为居中显示
                para.setAlignment(1);
                
                List<SchemaColumns> columnList = schemaTables.getColumnList();
                // 表格的主体，
                for (int k = 0; k < columnList.size(); k++) {
                    SchemaColumns columns = columnList.get(k);
                    //获取某表每个字段的详细说明
                    String Field = columns.getColumnName();
                    String Type = columns.getColumnType();
                    String isNull = columns.getIsNullable();
                    if("YES".equals(isNull)){
                        isNull = "是";
                    }else{
                        isNull = "否";
                    }
                    String defaultVal = columns.getColumnDefault();
                    String Comment = columns.getColumnComment();
                    
//                    PdfPCell cell2 = new PdfPCell();
                    Cell cell2 = new Cell((k + 1) + "");
                    cell2.setVerticalAlignment(Cell.ALIGN_CENTER);
                    cell2.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                    table.addCell(cell2);
                    
                    cell2 = new Cell(Field);
                    cell2.setVerticalAlignment(Cell.ALIGN_CENTER);
                    cell2.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                    table.addCell(cell2);
                    
                    cell2 = new Cell(Type);
                    cell2.setVerticalAlignment(Cell.ALIGN_CENTER);
                    cell2.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                    table.addCell(cell2);
                    
                    cell2 = new Cell(defaultVal);
                    cell2.setVerticalAlignment(Cell.ALIGN_CENTER);
                    cell2.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                    table.addCell(cell2);
                    
                    cell2 = new Cell(isNull);
                    cell2.setVerticalAlignment(Cell.ALIGN_CENTER);
                    cell2.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                    table.addCell(cell2);
                    
                    cell2 = new Cell(Comment);
                    cell2.setVerticalAlignment(Cell.ALIGN_CENTER);
                    cell2.setHorizontalAlignment(Cell.ALIGN_CENTER); 
                    table.addCell(cell2);
                }
                
              //构建表说明
//                String all = "" + (i + 1) + " 表名：" + tableName + " "+ tableComment + "";
                if(tableComment == null || "".equals(tableComment)){
                    tableComment = tableName;
                }
                String tableCommentShow = "描述："+tableComment;
                String tableNameShow = "表名："+tableName;
                String tableFieldShow = "字段说明";
                
                Paragraph pheae = new Paragraph(tableComment);
                Paragraph pheae1 = new Paragraph(tableCommentShow);
                Paragraph pheae2 = new Paragraph(tableNameShow);
                Paragraph pheae3 = new Paragraph(tableFieldShow);
                //写入表说明
                document.add(pheae);
                document.add(pheae1);
                document.add(pheae2);
                document.add(pheae3);
                //生成表格
                document.add(table);
            }
            
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    
    }
//    public void toWord(List<Map<String,Object>> listAll) throws Exception {
//        // 创建word文档,并设置纸张的大小
//        Document document = new Document(PageSize.A4);
//
//        try {
//            // 创建word文档
//            RtfWriter2.getInstance(document, new FileOutputStream("E:/word5.doc"));
//
//            document.open();// 设置文档标题
//            Paragraph ph = new Paragraph();
//            Font f = new Font();
//            Paragraph p = new Paragraph("数据库表设计文档", new Font(Font.NORMAL, 24,Font.BOLDITALIC, new Color(0, 0, 0)));
//            p.setAlignment(1);
//            document.add(p);
//            ph.setFont(f);/* * 创建表格 通过查询出来的表遍历 */
//            
//            for (int i = 0; i < listAll.size(); i++) {
//                // 表名
//                String table_name = (String) listAll.get(i).get("table_name");
//                // 表说明
//                String table_comment = (String) listAll.get(i).get("table_comment");
//                String sql = "SHOW FULL FIELDS FROM xmsa_trace." + table_name+ " ";
//                
//                //获取某张表的所有字段说明
//                //List<Map<String,Object>> list = businessSupplierService.listMap(sql);
//                List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//                
//                //构建表说明
//                String all = "" + (i + 1) + " 表名：" + table_name + " "+ table_comment + "";
//                
//                //创建有6列的表格
//                Table table = new Table(6);
//                document.add(new Paragraph(""));
//                table.setBorderWidth(1);
//                // table.setBorderColor(Color.BLACK);
//                table.setPadding(0);
//                table.setSpacing(0);
//                
//                /*
//                * 添加表头的元素，并设置表头背景的颜色
//                */
//                Color chade = new Color(176, 196, 222);
//                Cell cell = new Cell("序号");// 单元格
//                cell.setBackgroundColor(chade);
//                
//                cell.setHeader(true);
//                // cell.setColspan(3);//设置表格为三列
//                // cell.setRowspan(3);//设置表格为三行
//                table.addCell(cell);
//                
//                cell = new Cell("字段名");// 单元格
//                cell.setBackgroundColor(chade);
//                table.addCell(cell);
//                
//                cell = new Cell("类型");// 单元格
//                cell.setBackgroundColor(chade);
//                table.addCell(cell);
//                
//                cell = new Cell("是否为空");// 单元格
//                cell.setBackgroundColor(chade);
//                table.addCell(cell);
//                
//                cell = new Cell("主键");// 单元格
//                cell.setBackgroundColor(chade);
//                table.addCell(cell);
//                
//                cell = new Cell("字段说明");// 单元格
//                cell.setBackgroundColor(chade);
//                table.addCell(cell);
//                
//                table.endHeaders();// 表头结束
//                
//                // 表格的主体，
//                for (int k = 0; k < list.size(); k++) {
//                    //获取某表每个字段的详细说明
//                    String Field = (String) list.get(k).get("Field");
//                    String Type = (String) list.get(k).get("Type");
//                    String Null = (String) list.get(k).get("Null");
//                    String Key = (String) list.get(k).get("Key");
//                    String Comment = (String) list.get(k).get("Comment");
//                    
//                    table.addCell((k + 1) + "");
//                    table.addCell(Field);
//                    table.addCell(Type);
//                    table.addCell(Null);
//                    table.addCell(Key);
//                    table.addCell(Comment);
//                }
//                
//                Paragraph pheae = new Paragraph(all);
//                //写入表说明
//                document.add(pheae);
//                //生成表格
//                document.add(table);
//            }
//            
//            document.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    
//    }

}
