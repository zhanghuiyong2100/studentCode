package senSorsTest;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import com.sensorsdata.analytics.javasdk.exceptions.InvalidArgumentException;

import java.io.IOException;
import java.util.*;

/**
 * @author 章辉勇
 * @创建时间 2018年10月09日
 * @描述: 神策数据事件追踪
 **/

public class Test01 {

    public static void main(String[] args) {
        System.out.println("====>埋点开始");

        // 从神策分析获取的数据接收的 URL
        //final String SA_SERVER_URL = "D:/data/sa/access.log";
        final String SA_SERVER_URL = "123.207.169.177";
        // 使用 Debug 模式，并且导入 Debug 模式下所发送的数据
        final boolean SA_WRITE_DATA = true;

        // 使用 DebugConsumer 初始化 SensorsAnalytics
//        final SensorsAnalytics sa = new SensorsAnalytics(
//                new SensorsAnalytics.DebugConsumer(SA_SERVER_URL, SA_WRITE_DATA));

        SensorsAnalytics sa = null;
        
        try {
            sa = new SensorsAnalytics(
                    new SensorsAnalytics.ConcurrentLoggingConsumer("D:/data/sa/access.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 用户的 Distinct Id
        String distinctId = "ABCDEF123456789";

        // 用户浏览商品
        {
            Map<String, Object> properties = new HashMap<String, Object>();
            // '$time' 属性是系统预置属性，表示事件发生的时间，如果不填入该属性，则默认使用系统当前时间
            properties.put("$time", new Date());
            // '$ip' 属性是系统预置属性，如果服务端中能获取用户 IP 地址，并填入该属性，神策分析会自动根据 IP 地址解析用户的省份、城市信息
            properties.put("$ip", "123.123.123.123");
            // 商品 ID
            properties.put("ProductId", "123456");
            // 商品类别
            properties.put("ProductCatalog", "Laptop Computer");
            // 是否加入收藏夹，Boolean 类型的属性
            properties.put("isAddedToFav", true);

            // 记录用户浏览商品事件
            try {
                sa.track(distinctId, true, "ViewProduct", properties);
            } catch (InvalidArgumentException e) {
                e.printStackTrace();
            }
        }

        // 用户订单付款
        {
            // 订单中的商品 ID 列表
            List<String> productIdList = new ArrayList<String>();
            productIdList.add("123456");
            productIdList.add("234567");
            productIdList.add("345678");

            Map<String, Object> properties = new HashMap<String, Object>();

            properties.put("$ip", "123.123.123.123");
            // 订单 ID
            properties.put("OrderId", "abcdefg");
            // 商品 ID 列表，List<String> 类型的属性
            properties.put("ProductIdList", productIdList);
            // 订单金额
            properties.put("OrderPaid", 12.10);

            // 记录用户订单付款事件
            try {
                sa.track(distinctId, true, "PaidOrder", properties);
            } catch (InvalidArgumentException e) {
                e.printStackTrace();
            }
        }
        // 刷新一下，让埋点数据落到指定目录文件中
        sa.flush();
        // 程序结束前，停止神策分析 SDK 所有服务
        sa.shutdown();

        System.out.println("====>埋点结束");
    }
}
