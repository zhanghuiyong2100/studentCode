package senSorsTest;

import com.alibaba.fastjson.JSONObject;
import com.sensorsdata.analytics.javasdk.SensorsAnalytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 章辉勇
 * @创建时间 2018年10月09日
 * @描述: 微信下单成功埋点
 **/

public class TestWeiXin {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("埋点测试开始");
        try {
            /**
             1 初始化 SDK
             建议采用 ConcurrentLoggingConsumer + LogAgent 的方式进行数据采集，这样采集的好处是：
             数据实时导入 + 本地日志备份。 ConcurrentLoggingConsumer 配置方式如下:
             */
            final SensorsAnalytics sa = new SensorsAnalytics(
                    new SensorsAnalytics.ConcurrentLoggingConsumer("E:/data/sa/access.log"));
            /**  2 自定义事件追踪   */
            // 用户的 oppenId
            String bindingAccount = "zhang12345 ";
                // 用户微信下单成功数据
                {
                    Map<String, Object> properties = new HashMap<String, Object>();
                    //预置属性;神策 SDK 自动采集的字段
                    //orderNumber	订单号
                    properties.put("orderNumber", "");
                    //waybillNumber	运单号
                    properties.put("waybillNumber", "");
                    //reviceMoneyAmount	运费估计
                    properties.put("reviceMoneyAmount", "");
                    //contactProvince	寄出省
                    properties.put("contactProvince", "");
                    //contactCity	寄出市
                    properties.put("contactCity", "");
                    //contactArea	寄出区
                    properties.put("contactArea", "");
                    //receiverCustProvince	收件省
                    properties.put("receiverCustProvince", "");
                    //receiverCustCity	收件市
                    properties.put("receiverCustCity", "");
                    //receiverCustArea	收件区
                    properties.put("receiverCustArea", "");
                    System.out.println("查看数据1"+JSONObject.toJSON(properties));
                    properties.put("receiverCustArea", "改变");
                    System.out.println("查看数据"+JSONObject.toJSON(properties));

                    // 记录事件
                    List<Object> objects = new ArrayList<>();
                    sa.track(bindingAccount, true, "wechatCreateOrderrviceSuccess", properties);
                }
            // 刷新一下，让埋点数据落到指定目录文件中
            sa.flush();
            // 程序结束前，停止神策分析 SDK 所有服务
            sa.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        long endTime = System.currentTimeMillis();
        System.out.println("埋点测试结束,耗时:"+(endTime-startTime)+"毫秒");
    }
}
