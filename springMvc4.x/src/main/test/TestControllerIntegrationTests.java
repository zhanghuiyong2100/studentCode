import com.springmvc4.config.JsMvcConfig;
import com.springmvc4.config.MyMvcConfig;
import com.springmvc4.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author 章辉勇
 * @创建时间 2018年11月05日
 * @描述: springMVC測試用力
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class, JsMvcConfig.class})
/**
 * ① @WebAppConfiguration注解在类上，用来声明加载的ApplicationContext是一个WebApplicationContext。它的属性指定的是Web资源的位置，默认为src/main/webapp,本例修改为src/main/resource。
 * */
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegrationTests {
    /**
     * ② MockMvc模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()进行初始化。
     */
    private MockMvc mockMvc;

    /**
     * ③ 可以在测试用例中注入Spring的Bean。
     */
    @Autowired
    private DemoService demoService;
    /**
     * ④ 可注入WebApplicationContext。
     */
    @Autowired
    WebApplicationContext wac;
    /**
     * ⑤ 可注入模拟的http session，此处仅作演示，没有使用。
     */
    @Autowired
    MockHttpSession session;
    /**
     * ⑥ 可注入模拟的http request，此处仅作演示，没有使用。
     */
    @Autowired
    MockHttpServletRequest request;

    /**
     * ⑦ @Before 在测试开始前进行的初始化工作。
     */
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testNormalController() throws Exception {
        /**
         * ⑧ 模拟向/normal进行get请求。
         * */
        mockMvc.perform(get("/normal"))
                //⑨ 预期控制返回状态为200.
                .andExpect(status().isOk())
                //⑩ 预期view的名称为page。
                .andExpect(view().name("page"))
                //11 预期页面转向的真正路径为/WEB-INF/classes/views/page.jsp。
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))
                //12 预期model里面的值是demoService.saySomething()返回值hello。
                .andExpect(model().attribute("msg", demoService.saySomething()));
    }

    @Test
    public void testRestController() throws Exception {
        //13.模拟向/testRest进行get请求。
        mockMvc.perform(get("/testRest"))
                .andExpect(status().isOk())
                //14 预期返回值的媒体类型是text/plain;charset=UTF-8。
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                //15 预期返回值的内容为demoService.saySomething()返回值hello。
                .andExpect(content().string(demoService.saySomething()));
    }


}
