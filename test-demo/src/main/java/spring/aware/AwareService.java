package spring.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author 章辉勇
 * @创建时间 2018年10月27日
 * @描述: spring Aware 测试类
 **/

/**
 * ①实现BeanNameAware、ResourceLoaderAware接口，获得Bean名称和资源加载的服务。
 */
@Component
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;


    /**
     * ②实现ResourceLoaderAware 需重写 setResourceLoader。
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    /**
     * ③实现BeanNameAware 需重写 setBeanName方法。
     */
    @Override
    public void setBeanName(String name) {

        this.beanName = name;
    }


    public void outputResult() {
        System.out.println("bean的名称为：" + beanName);
        Resource resource = loader.getResource("classpath:spring/aware/test.txt");
        try {
            System.out.println("ResourceLocader加載的内容為：" + IOUtils.toString(resource.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
