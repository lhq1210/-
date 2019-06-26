package create;

import com.ln.pojo.CrmCustomer;
import com.ln.pojo.CrmUser;

public class BeanUtilCreate {

    public static void main(String[] args) throws Exception {
        BeanUtilCreate beanUtilCreate = new BeanUtilCreate();
        BeanUtils beanUtils = new BeanUtils();


        beanUtils.setAuthorName("lhq");//作者
        beanUtils.setTableName("crm_customer");//表名
        beanUtils.setTableDes("客户记录");//表信息
        beanUtilCreate.beanTool(beanUtils, CrmUser.class);// 运行生产后，需要刷新工程

    }

    /**
     * 根据bean生成相应的文件
     *
     * @param beanUtils
     * @param c
     * @throws Exception
     */
    public void beanTool(BeanUtils beanUtils, Class c) throws Exception {

        beanUtils.createBeanControl(c);
        beanUtils.createBeanService(c);
        beanUtils.createBeanServiceImpl(c);
        beanUtils.createBeanMapper(c);
        beanUtils.createBeanXml(c);

    }
}
