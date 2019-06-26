package create;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;

import com.cyrj.common.util.DateUtil;
import com.cyrj.common.util.FieldMeta;
import com.ln.pojo.CrmUser;

/**
 * 基础CRUD文件生成类
 *
 * @author wzz
 * @version 创建时间：2019/5/20 15:17:50
 */
public class BeanUtils {

    private static final String RT_1 = "\r\n";
    private static final String RT_2 = "\r\n\r\n";
    private static final String BLANK_1 = " ";
    private static final String BLANK_4 = "    ";
    private static final String BLANK_8 = "        ";
    private static final String BLANK_12 = "            ";
    private static final String BLANK_16 = "                ";
    private static final String ANNOTATION_AUTHOR_PARAMTER = "@author ";
    public static final String ANNOTATION_AUTHOR_NAME = "@name";
    private static final String ANNOTATION_AUTHOR = "@author @name";
    private static final String ANNOTATION_DATE = "@version 创建时间：";
    private static final String ANNOTATION = "/**\r\n * \r\n * @author @name\r\n * @version 创建时间：" + getDate() + "\r\n" + " " + "*/" + "\r\n";
    private String authorName = "";
    private String tableName = "";
    private String tableDes = "";

    public BeanUtils() {
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableDes() {
        return this.tableDes;
    }

    public void setTableDes(String tableDes) {
        this.tableDes = tableDes;
    }

    public void createBeanMapper(Class c) throws Exception {
        String cName = c.getName();
        String daoUrl = this.getPackageNameToUrl(cName) + ".mapper";
        String daoPath = daoUrl.replace(".", "/");
        String fileName = System.getProperty("user.dir") + "/src/main/java/" + daoPath + "/" + this.getLastChar(cName) + "Mapper.java";
        File f = new File(fileName);
        if (f.exists()) {
            System.out.println("文件名：" + f.getAbsolutePath());
            System.out.println("文件大小：" + f.length());
            System.out.println("文件已存在，不能再创建。");
        } else {
            f.getParentFile().mkdirs();

            try {
                f.createNewFile();
            } catch (IOException var9) {
                var9.printStackTrace();
            }

            StringBuffer buffer = new StringBuffer();
            buffer.append("package ").append(daoUrl);
            buffer.append(";").append("\r\n\r\n");
            buffer.append("import com.cyrj.common.mapper.BaseMapper;").append("\r\n");
            buffer.append("import ").append(cName).append(";").append("\r\n");
            buffer.append("\r\n\r\n").append(ANNOTATION.replace("@name", this.authorName));
            buffer.append("public interface ").append(this.getLastChar(cName));
            buffer.append("Mapper extends BaseMapper<").append(this.getLastChar(cName));
            buffer.append("> {");
            buffer.append("\r\n").append("}");
            FileWriter fw = new FileWriter(f);
            fw.write(buffer.toString());
            fw.flush();
            fw.close();
            this.showInfo(fileName);
        }
    }

    public void createBeanServiceImpl(Class c) throws Exception {
        String cName = c.getName();
        String beanName = this.getLastChar(cName);
        String daoUrl = this.getPackageNameToUrl(cName) + ".service.impl";
        String daoPath = daoUrl.replace(".", "/");
        String fileName = System.getProperty("user.dir") + "/src/main/java/" + daoPath + "/" + this.getLastChar(cName) + "ServiceImpl.java";
        File f = new File(fileName);
        if (f.exists()) {
            System.out.println("文件名：" + f.getAbsolutePath());
            System.out.println("文件大小：" + f.length());
            System.out.println("文件已存在，不能再创建。");
        } else {
            f.getParentFile().mkdirs();

            try {
                f.createNewFile();
            } catch (IOException var10) {
                var10.printStackTrace();
            }

            StringBuffer buffer = new StringBuffer();
            buffer.append("package ").append(daoUrl);
            buffer.append(";").append("\r\n\r\n");
            buffer.append("import org.springframework.beans.factory.annotation.Autowired;").append("\r\n");
            buffer.append("import org.springframework.stereotype.Service;").append("\r\n");
            buffer.append("import com.cyrj.common.service.impl.BaseServiceImpl;").append("\r\n");
            buffer.append("import ").append(this.getPackageNameToUrl(cName)).append(".mapper.");
            buffer.append(beanName).append("Mapper;").append("\r\n");
            buffer.append("import ").append(this.getPackageNameToUrl(cName)).append(".service.");
            buffer.append(beanName).append("Service;").append("\r\n");
            buffer.append("import ").append(cName).append(";").append("\r\n");
            buffer.append("\r\n\r\n").append(ANNOTATION.replace("@name", this.authorName));
            buffer.append("@Service(\"").append(this.getLowercaseChar(beanName)).append("Service\")");
            buffer.append("\r\n");
            buffer.append("public class ").append(this.getLastChar(cName));
            buffer.append("ServiceImpl extends BaseServiceImpl<").append(this.getLastChar(cName));
            buffer.append("> implements ").append(this.getLastChar(cName)).append("Service {");
            buffer.append("\r\n\r\n").append("    ").append("@Autowired");
            buffer.append("\r\n").append("    ").append(beanName);
            buffer.append("Mapper ").append(this.getLowercaseChar(beanName)).append("Mapper;");
            buffer.append("\r\n").append("}");
            FileWriter fw = new FileWriter(f);
            fw.write(buffer.toString());
            fw.flush();
            fw.close();
            this.showInfo(fileName);
        }
    }

    public void createBeanService(Class c) throws Exception {
        String cName = c.getName();
        String daoUrl = this.getPackageNameToUrl(cName) + ".service";
        String daoPath = daoUrl.replace(".", "/");
        String fileName = System.getProperty("user.dir") + "/src/main/java/" + daoPath + "/" + this.getLastChar(cName) + "Service.java";
        File f = new File(fileName);
        if (f.exists()) {
            System.out.println("文件名：" + f.getAbsolutePath());
            System.out.println("文件大小：" + f.length());
            System.out.println("文件已存在，不能再创建。");
        } else {
            f.getParentFile().mkdirs();

            try {
                f.createNewFile();
            } catch (IOException var9) {
                var9.printStackTrace();
            }

            StringBuffer buffer = new StringBuffer();
            buffer.append("package ").append(daoUrl);
            buffer.append(";").append("\r\n\r\n");
            buffer.append("import com.cyrj.common.service.BaseService;").append("\r\n");
            buffer.append("import ").append(cName).append(";").append("\r\n");
            buffer.append("\r\n\r\n").append(ANNOTATION.replace("@name", this.authorName));
            buffer.append("public interface ").append(this.getLastChar(cName));
            buffer.append("Service extends BaseService<").append(this.getLastChar(cName));
            buffer.append("> {");
            buffer.append("\r\n").append("}");
            FileWriter fw = new FileWriter(f);
            fw.write(buffer.toString());
            fw.flush();
            fw.close();
            this.showInfo(fileName);
        }
    }

    public void createBeanControl(Class c) throws Exception {
        String cName = c.getName();
        String beanName = this.getLastChar(cName);
        String lowName = this.getLowercaseChar(beanName);
        String moduleName = this.getModuleName(cName);
        String daoUrl = this.getPackageNameToUrl(cName) + ".control";
        String daoPath = daoUrl.replace(".", "/");
        String jspPath = this.getPackageName(cName).replace(".", "/");
        jspPath = jspPath.substring(4);
        String fileName = System.getProperty("user.dir") + "/src/main/java/" + daoPath + "/" + this.getLastChar(cName) + "Controller.java";
        File f = new File(fileName);
        if (f.exists()) {
            System.out.println("文件名：" + f.getAbsolutePath());
            System.out.println("文件大小：" + f.length());
            System.out.println("文件已存在，不能再创建。");
        } else {
            f.getParentFile().mkdirs();

            try {
                f.createNewFile();
            } catch (IOException var13) {
                var13.printStackTrace();
            }

            StringBuffer buffer = new StringBuffer();
            buffer.append("package ").append(daoUrl);
            buffer.append(";").append("\r\n\r\n");
            buffer.append("import java.io.UnsupportedEncodingException;").append("\r\n");
            buffer.append("import java.security.NoSuchAlgorithmException;").append("\r\n");
            buffer.append("import java.util.List;").append("\r\n");
            buffer.append("import java.util.Map;").append("\r\n");
            buffer.append("import java.util.HashMap;").append("\r\n");
            buffer.append("import javax.servlet.http.HttpServletRequest;").append("\r\n\r\n");
            buffer.append("import org.springframework.beans.factory.annotation.Autowired;").append("\r\n");
            buffer.append("import org.springframework.web.bind.annotation.PathVariable;").append("\r\n");
            buffer.append("import org.springframework.web.bind.annotation.RequestBody;").append("\r\n");
            buffer.append("import org.springframework.web.bind.annotation.RequestMapping;").append("\r\n");
            buffer.append("import org.springframework.web.bind.annotation.RequestMethod;").append("\r\n");
            buffer.append("import org.springframework.web.bind.annotation.RequestParam;").append("\r\n");
            buffer.append("import org.springframework.web.bind.annotation.RestController;").append("\r\n");
            buffer.append("import io.swagger.annotations.Api;").append("\r\n");
            buffer.append("import io.swagger.annotations.ApiOperation;").append("\r\n");
            buffer.append("import io.swagger.annotations.ApiParam;").append("\r\n\r\n");
            buffer.append("import com.cyrj.common.constant.ValidationMessge;").append("\r\n");
            buffer.append("import com.cyrj.common.control.BaseController;").append("\r\n");
            buffer.append("import com.cyrj.common.util.Response;").append("\r\n");
            buffer.append("import com.cyrj.common.util.IgnoreSecurity;").append("\r\n");
            buffer.append("import com.github.pagehelper.PageInfo;").append("\r\n");
            buffer.append("import ").append(this.getPackageNameToUrl(cName)).append(".service.");
            buffer.append(beanName).append("Service;").append("\r\n");
            buffer.append("import ").append(cName).append(";").append("\r\n");
            buffer.append("\r\n\r\n").append(ANNOTATION.replace("@name", this.authorName));
            buffer.append("@RestController").append("\r\n");
            buffer.append("@RequestMapping(value = \"/api/").append(moduleName).append("/").append(lowName).append("\")").append("\r\n");
            buffer.append("@Api(description = \"").append(this.tableDes).append("接口\")").append("\r\n");
            buffer.append("public class ").append(beanName);
            buffer.append("Controller extends BaseController{");
            buffer.append("\r\n\r\n").append("    ").append("@Autowired");
            buffer.append("\r\n").append("    ").append(beanName);
            buffer.append("Service ").append(lowName).append("Service;");
            buffer.append("\r\n\r\n").append("    ").append("@ApiOperation(value = \"查找").append(this.tableDes).append("列表\")");
            buffer.append("\r\n").append("    ").append("@IgnoreSecurity(val = false)");
            buffer.append("\r\n").append("    ").append("@RequestMapping(value = \"/list\", method = RequestMethod.GET)");
            buffer.append("\r\n").append("    ").append("public Response list(HttpServletRequest request,");
            buffer.append("@ApiParam(value = \"关键字\", required = false) @RequestParam(required = false, value = \"keyword\") String keyword) {");
            buffer.append("\r\n").append("        ").append("Map map = new HashMap();");
            buffer.append("\r\n").append("        ").append("map.put(\"keyword\", keyword);");
            buffer.append("\r\n").append("        ").append("map.put(\"tenantId\", getTenantId(request));");
            buffer.append("\r\n").append("        ").append("List<Map> list = ").append(lowName).append("Service.findListByMap(map);");
            buffer.append("\r\n").append("        ").append("Response response = new Response();");
            buffer.append("\r\n").append("        ").append("return response.success(list);");
            buffer.append("\r\n").append("    ").append("}");
            buffer.append("\r\n\r\n").append("    ").append("@ApiOperation(value = \"查找").append(this.tableDes).append("列表(分页)\")");
            buffer.append("\r\n").append("    ").append("@IgnoreSecurity(val = false)");
            buffer.append("\r\n").append("    ").append("@RequestMapping(value = \"/page\", method = RequestMethod.GET)");
            buffer.append("\r\n").append("    ").append("public Response page(HttpServletRequest request,");
            buffer.append("@ApiParam(value = \"页码\", required = true) @RequestParam(required = true, value = \"pageNum\") Integer pageNum,");
            buffer.append("@ApiParam(value = \"每页显示数量\", required = true) @RequestParam(required = true, value = \"pageSize\") Integer pageSize,");
            buffer.append("@ApiParam(value = \"关键字\", required = false) @RequestParam(required = false, value = \"keyword\") String keyword) {");
            buffer.append("\r\n").append("        ").append("Map map = new HashMap();");
            buffer.append("\r\n").append("        ").append("map.put(\"keyword\", keyword);");
            buffer.append("\r\n").append("        ").append("map.put(\"tenantId\", getTenantId(request));");
            buffer.append("\r\n").append("        ").append("PageInfo<Map> page = ").append(lowName).append("Service.findListPageByMap(map,pageNum,pageSize);");
            buffer.append("\r\n").append("        ").append("Response response = new Response();");
            buffer.append("\r\n").append("        ").append("return response.success(page);");
            buffer.append("\r\n").append("    ").append("}");
            buffer.append("\r\n\r\n").append("    ").append("@ApiOperation(value = \"根据Id查找").append(this.tableDes).append("\")");
            buffer.append("\r\n").append("    ").append(" @IgnoreSecurity(val = false)");
            buffer.append("\r\n").append("    ").append("@RequestMapping(value = \"/{id}\", method = RequestMethod.GET)");
            buffer.append("\r\n").append("    ").append("public Response get(HttpServletRequest request,");
            buffer.append("@ApiParam(value = \"id\", required = true) @PathVariable(required = true, value = \"id\") Integer id){");
            buffer.append("\r\n").append("        ").append(beanName).append(" ").append(lowName).append(" = new ").append(beanName).append("();");
            buffer.append("\r\n").append("        ").append(lowName).append(".setId(id);");
            buffer.append("\r\n").append("        ").append("return getResult(").append(lowName).append("Service.getMapById(").append(lowName).append("));");
            buffer.append("\r\n").append("    ").append("}");
            buffer.append("\r\n\r\n").append("    ").append("@ApiOperation(value =\"新增").append(this.tableDes).append("\")");
            buffer.append("\r\n").append("    ").append("@IgnoreSecurity(val = false)");
            buffer.append("\r\n").append("    ").append("@RequestMapping(method = RequestMethod.POST)");
            buffer.append("\r\n").append("    ").append("public Response save(HttpServletRequest request,");
            buffer.append("@RequestBody ").append(beanName).append(" ").append(lowName).append(") throws UnsupportedEncodingException, NoSuchAlgorithmException {");
            buffer.append("\r\n").append("        ").append(lowName).append(".setCreater(getEmployeeName(request));");
            buffer.append("\r\n").append("        ").append(lowName).append(".setCreaterId(getEmployeeId(request));");
            buffer.append("\r\n").append("        ").append(lowName).append(".setModify(").append(lowName).append(".getCreater());");
            buffer.append("\r\n").append("        ").append(lowName).append(".setModifyId(").append(lowName).append(".getCreaterId());");
            buffer.append("\r\n").append("        ").append(lowName).append(".setTenantId(getTenantId(request));");
            buffer.append("\r\n").append("        ").append("return getResult(").append(lowName).append("Service.add(").append(lowName).append("));");
            buffer.append("\r\n").append("    ").append("}");
            buffer.append("\r\n\r\n").append("    ").append("@ApiOperation(value = \"修改").append(this.tableDes).append("\")");
            buffer.append("\r\n").append("    ").append("@IgnoreSecurity(val = false)");
            buffer.append("\r\n").append("    ").append("@RequestMapping(value = \"/update\",method = RequestMethod.POST)");
            buffer.append("\r\n").append("    ").append("public Response update(HttpServletRequest request,");
            buffer.append("@RequestBody ").append(beanName).append(" ").append(lowName).append("Form) throws UnsupportedEncodingException, NoSuchAlgorithmException {");
            buffer.append("\r\n").append("        ").append("if(").append(lowName).append("Form.getId() <= 0)");
            buffer.append("\r\n").append("        ").append("{");
            buffer.append("\r\n").append("            ").append("return getResultError(ValidationMessge.ID_RRROR);");
            buffer.append("\r\n").append("        ").append("}");
            buffer.append("\r\n").append("        ").append(beanName).append(" ").append(lowName).append(" = new ").append(beanName).append("();");
            buffer.append("\r\n").append("        ").append(lowName).append(".setId(").append(lowName).append("Form.getId());");
            buffer.append("\r\n").append("        ").append(lowName).append(" = ").append(lowName).append("Service.getById(").append(lowName).append(");");
            buffer.append("\r\n").append("        ").append("if(").append(lowName).append(" == null)");
            buffer.append("\r\n").append("        ").append("{");
            buffer.append("\r\n").append("            ").append("return getResultError(ValidationMessge.QUERY_ERROR);");
            buffer.append("\r\n").append("        ").append("}");
            buffer.append("\r\n").append("        ").append(lowName).append(".setModify(getEmployeeName(request));");
            buffer.append("\r\n").append("        ").append(lowName).append(".setModifyId(getEmployeeId(request));");
            buffer.append("\r\n").append("        ").append("return getResult(").append(lowName).append("Service.update(").append(lowName).append("));");
            buffer.append("\r\n\r\n").append("    ").append("}");
            buffer.append("\r\n\r\n").append("    ").append("@ApiOperation(value = \"删除").append(this.tableDes).append("\")");
            buffer.append("\r\n").append("    ").append("@IgnoreSecurity(val = false)");
            buffer.append("\r\n").append("    ").append("@RequestMapping(method = RequestMethod.DELETE)");
            buffer.append("\r\n").append("    ").append("public Response delete(HttpServletRequest request,");
            buffer.append("@ApiParam(value = \"ids\", required = true) @RequestParam(required = true, value = \"ids\") Integer ids){");
            buffer.append("\r\n").append("        ").append("Map map = new HashMap();");
            buffer.append("\r\n").append("        ").append("map.put(\"ids\", ids);");
            buffer.append("\r\n").append("        ").append("map.put(\"modify\", getEmployeeName(request));");
            buffer.append("\r\n").append("        ").append("map.put(\"modifyId\", getEmployeeId(request));");
            buffer.append("\r\n").append("        ").append("return getResult(").append(lowName).append("Service.delete(map));");
            buffer.append("\r\n").append("    ").append("}");
            buffer.append("\r\n").append("}");
            FileWriter fw = new FileWriter(f);
            fw.write(buffer.toString());
            fw.flush();
            fw.close();
            this.showInfo(fileName);
        }
    }

    public void createBeanXml(Class c) throws Exception {
        String cName = c.getName();
        String beanName = this.getLastChar(cName);
        String moduleName = this.getModuleName(cName);
        String packageName = this.getPackageNameToUrl(cName);
        //String fileName = System.getProperty("user.dir") + "/src/main/resources/mapper/" + moduleName + "/" + this.getLastChar(cName) + "Mapper.xml";
        String fileName = System.getProperty("user.dir") + "/src/main/resources/mapper/" + this.getLastChar(cName) + "Mapper.xml";
        File f = new File(fileName);
        if (f.exists()) {
            System.out.println("文件名：" + f.getAbsolutePath());
            System.out.println("文件大小：" + f.length());
            System.out.println("文件已存在，不能再创建。");
        } else {
            f.getParentFile().mkdirs();

            try {
                f.createNewFile();
            } catch (IOException var14) {
                var14.printStackTrace();
            }

            String[] args = this.fingByArg(c);
            StringBuffer buffer = new StringBuffer();
            buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            buffer.append("\r\n").append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
            buffer.append("\r\n").append("<mapper namespace=\"").append(packageName).append(".mapper.").append(beanName).append("Mapper\">");
            buffer.append("\r\n\r\n").append("    ").append(" <resultMap id=\"").append(beanName);
            buffer.append("Map\" type=\"").append(cName).append("\">");
            buffer.append("\r\n").append("        ").append("<id property=\"id\" column=\"id\"/>");
            String[] var10 = args;
            int var11 = args.length;

            for (int var12 = 0; var12 < var11; ++var12) {
                String arg = var10[var12];
                if (!arg.equals("id")) {
                    buffer.append("\r\n").append("        ").append("<result property=\"").append(arg);
                    buffer.append("\" column=\"").append(arg).append("\"/>");
                }
            }

            buffer.append("\r\n").append("    ").append("</resultMap>");
            buffer.append("\r\n\r\n").append("    ").append(" <sql id=\"Base_Column_List\">");
            buffer.append("\r\n").append("        ");

            int i;
            for (i = 0; i < args.length; ++i) {
                buffer.append(args[i]);
                if (i < args.length - 1) {
                    buffer.append(",");
                }
            }

            buffer.append("\r\n").append("    ").append(" </sql>");
            buffer.append("\r\n\r\n").append("    ").append("<select id=\"getById\" resultMap=\"");
            buffer.append(beanName).append("Map\" parameterType=\"").append(cName).append("\">");
            buffer.append("\r\n").append("        ").append("select ");
            buffer.append("\r\n").append("        ").append("<include refid=\"Base_Column_List\"/>");
            buffer.append("\r\n").append("        ").append("from ").append(this.tableName).append(" a ");
            buffer.append("\r\n").append("        ").append("where id = #{id} and delflag = #{delflag}");
            buffer.append("\r\n").append("    ").append("</select>");
            buffer.append("\r\n\r\n").append("    ").append("<select id=\"findListByMap\" resultMap=\"");
            buffer.append(beanName).append("Map\" parameterType=\"java.util.Map\">");
            buffer.append("\r\n").append("        ").append("select ");
            buffer.append("\r\n").append("        ").append("<include refid=\"Base_Column_List\"/>");
            buffer.append("\r\n").append("        ").append("from ").append(this.tableName).append(" a ");
            buffer.append("\r\n").append("        ").append("<where>");
            buffer.append("\r\n").append("            ").append("<if test=\"delflag != null\">");
            buffer.append("\r\n").append("                ").append("and a.delflag = #{delflag}");
            buffer.append("\r\n").append("            ").append("</if>");
            buffer.append("\r\n").append("            ").append("<if test=\"tenantId != null\">");
            buffer.append("\r\n").append("                ").append("and a.tenantId = #{tenantId}");
            buffer.append("\r\n").append("            ").append("</if>");
            buffer.append("\r\n").append("            ").append("<if test=\"keyword != null\">");
            buffer.append("\r\n").append("                ").append("and a.name like concat('%', #{keyword}, '%')");
            buffer.append("\r\n").append("            ").append("</if>");
            buffer.append("\r\n").append("        ").append("</where>");
            buffer.append("\r\n").append("    ").append("</select>");
            buffer.append("\r\n\r\n").append("    ").append("<insert id=\"add\" useGeneratedKeys=\"true\" keyProperty=\"id\">");
            buffer.append("\r\n").append("        ").append("insert into ").append(this.tableName);
            buffer.append("\r\n").append("            ").append("(");

            for (i = 0; i < args.length; ++i) {
                if (!args[i].equals("id")) {
                    buffer.append(args[i]);
                    if (i < args.length - 1) {
                        buffer.append(",");
                    }
                }
            }

            buffer.append("\r\n").append("            ").append(")");
            buffer.append("\r\n").append("        ").append("values");
            buffer.append("\r\n").append("            ").append("(");

            for (i = 0; i < args.length; ++i) {
                if (!args[i].equals("id")) {
                    buffer.append("#{").append(args[i]).append("}");
                    if (i < args.length - 1) {
                        buffer.append(",");
                    }
                }
            }

            buffer.append("\r\n").append("            ").append(")");
            buffer.append("\r\n").append("    ").append("</insert>");
            buffer.append("\r\n\r\n").append("    ").append("<update id=\"update\" parameterType=\"");
            buffer.append(cName).append("\">");
            buffer.append("\r\n").append("        ").append("update ").append(this.tableName);
            buffer.append("\r\n").append("        ").append("<set>");
            for (i = 0; i < args.length; ++i) {
                if (!args[i].equals("id")) {
                    buffer.append("\r\n").append("          ").append("<if test=\"").append(args[i]).append(" != null\">");
                    buffer.append("\r\n").append("            ").append(args[i]).append(" = ");
                    buffer.append("#{").append(args[i]).append("}");
                    if (i < args.length - 1) {
                        buffer.append(",");
                    }
                    buffer.append("\r\n").append("          ").append("</if>");
                }
            }
            buffer.append("\r\n").append("        ").append("</set>");
            buffer.append("\r\n").append("        ").append(" WHERE id = #{id}");
            buffer.append("\r\n").append("    ").append("</update>");
            buffer.append("\r\n\r\n").append("    ").append("<update id=\"delete\" parameterType=\"java.util.Map\">");
            buffer.append("\r\n").append("        ").append("update ").append(this.tableName);
            buffer.append("\r\n").append("        ").append("<set>");
            buffer.append("\r\n").append("        ").append("<if test=\"delflag != null\">");
            buffer.append("\r\n").append("            ").append("delflag = #{delflag},");
            buffer.append("\r\n").append("        ").append("</if>");
            buffer.append("\r\n").append("        ").append("<if test=\"modifyId != null\">");
            buffer.append("\r\n").append("            ").append("modifyId = #{modifyId},");
            buffer.append("\r\n").append("        ").append("</if>");
            buffer.append("\r\n").append("        ").append("<if test=\"modifyTime != null\">");
            buffer.append("\r\n").append("            ").append("modifyTime = #{modifyTime}");
            buffer.append("\r\n").append("        ").append("</if>");
            buffer.append("\r\n").append("        ").append("</set>");
            buffer.append("\r\n").append("        ").append(" WHERE id in (${ids})");
            buffer.append("\r\n").append("    ").append("</update>");
            buffer.append("\r\n\r\n").append("</mapper>");
            FileWriter fw = new FileWriter(f);
            fw.write(buffer.toString());
            fw.flush();
            fw.close();
            this.showInfo(fileName);
        }
    }

    public String getPackageName(String str) {
        if (str != null && str.length() > 0) {
            int dot = str.lastIndexOf(46);
            if (dot > -1 && dot < str.length() - 1) {
                return str.substring(0, str.length() - (str.length() - dot) - 5);
            }
        }

        return str;
    }

    public String getPackageNameToUrl(String str) {
        if (str != null && str.length() > 0) {
            int dot = str.lastIndexOf(46);
            if (dot > -1 && dot < str.length() - 1) {
                return str.substring(0, str.length() - (str.length() - dot) - 5);
            }
        }

        return str;
    }

    public String getModuleName(String str) {
        if (str != null && str.length() > 0) {
            String[] dot = str.split("\\.");
            str = dot[2];
        }

        return str;
    }

    public String getLastChar(String str) {
        if (str != null && str.length() > 0) {
            int dot = str.lastIndexOf(46);
            if (dot > -1 && dot < str.length() - 1) {
                return str.substring(dot + 1);
            }
        }

        return str;
    }

    public String getLowercaseChar(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public void showInfo(String info) {
        System.out.println("创建文件：" + info + "成功！");
    }

    public static String getDate() {
        return DateUtil.formatyyyy_MM_dd_HH_mm_ss(new Date());
    }

    public String[] fingByArg(Class c) throws Exception {
        Field[] fields = c.getDeclaredFields();
        String[] rs = new String[fields.length];
        int i = 0;
        Field[] var5 = fields;
        int var6 = fields.length;

        for (int var7 = 0; var7 < var6; ++var7) {
            Field f = var5[var7];
            rs[i] = f.getName();
            ++i;
        }

        return rs;
    }

    public String[] fingByArgs(Class c) throws Exception {
        Field[] fields = c.getDeclaredFields();
        String[] rs = new String[fields.length];
        int i = 0;
        Field[] var5 = fields;
        int var6 = fields.length;

        for (int var7 = 0; var7 < var6; ++var7) {
            Field f = var5[var7];
            if (f.getName().toLowerCase().indexOf("id") == -1) {
                FieldMeta meta = (FieldMeta) f.getAnnotation(FieldMeta.class);
                if (meta != null) {
                    f.setAccessible(true);
                    rs[i] = f.getName() + "_" + meta.name();
                    ++i;
                }
            }
        }

        return rs;
    }
}
