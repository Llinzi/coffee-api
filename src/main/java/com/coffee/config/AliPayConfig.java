package com.coffee.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName : AliPayConfig
 * @Description : 支付宝支付
 * @Author : 王显成
 * @Date: 2020-05-11 23:02
 */
public class AliPayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101100662499";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCp4uk1+ClzrVstXB8GNs2EVIlKnVsXCcYsK+vOJ3NMX1zeAtGkKfPOS9bc3/szstq8CgIOEXsT8MS7IWaJp1u236TFp7QB14Pw4nlnGmicy0tjIKX6ZqyWT1wiG08QA75OXyFEfq6Pq0/pZhpLL5Yn1KjypXBSf9LREcMYPQNrGB7212HnRYZTRl7SrL/5Nw0/4HymaPAy3BeidAE1Us9IIbGvnoMwQj29WRGhKicwTyrd9Y9gAjd6R6QekrJtU7CLLEfQm7ZbvFtzo5W5YD4G6IAPDfsADQ0YI4eVSPJJAfDIIfVLBZ2iWBZQQwS175azvwTYEDA9rQRKx4wbqYS3AgMBAAECggEAFo4OwmCROE9yxIHviIasIH6Mv8BGgLeGfQTTyMoKD8C1drBPHwmG2gPNogOGuWVsjvyRK0b83TfhFqsnju0OSyhEGw3Z40i2truKvLqP2wlOl/mUr7sD/OzKYajYhVrJ4GPW6d4b1O08rdMleIf32o/sYlK+p+VamvFNwqEPHB+eacdKocGcpxFqZpJYg4XTaDYcg9Y+dpdIfFpQLnH6+4Wq1LdlQS3WH/koGXYZhj6LJGhiTVhy6nbdWUAQaSnAaf1FkTzUl0O6KuyiyK/cmlnhroUEGA9+EgdkMHHBjlFyMwNBPBLXeMyXfCQd4eq/8HKxqwUQ2eNDeR5ye2u0IQKBgQD6HmAW5uqFrHd5JgXNE9/ezmdiuI+HA0aDN/iUHpWj8oDdoDvN0RzpuBy5HbfMqcCkwL1YkBwcQfvS6mDtUugIRP6cnrpARO8xnqyoLBHcZOluQcGjo2CrNf0HRDkQJQLDKGZZoTvhaDJ6vcpEv4LQ9QPfnIkd3tF8NbNWX1WUpwKBgQCt4ZDoShvo8mukroroP7572efS74EExhW1u3UGnpM7AGc9QvSc0R+kDbr5ujHriTts0A9TgaTXQgMIbOhfS/ZVz+ldNjkz1AEcGiQocfRIcP6gkxxOgPZ2filCrr41SORNAO3xELun0aNv1GNynIW5+HAszWjFX/FaHTOk7MfBcQKBgH8oDiXWg4gt5BddMznNTtURDhJsTduP2LtBK0jyO5U75jPGEGFUXGSdy0x5RUXxTxTzP8/Ug9YB3aqeqWQ97+S0XtT1BS9DXG9XgeOFdBcd3mbFW1J77ttb+SVGk9QXXM4mrdIHXE/+DxvDfR9yVWkyByQZisP60XlaO7A/i1ylAoGBAKhNLn9ITB97lak+sIEAQhWK4xKOc+j0+kp++VTA5G01hLgNOMsYt3GJQLM6/9qlZ/l4oX0IfU9FO75J+9lRo0uIBK8OLuv1hmV3AAyN0A7WH/+4pKtvtB8ZGkLK9JyKwz+taKHuulRDW9iAUQm8asuIprsWzxRMO0YoAbbe4LJhAoGAbxKxkTyp8GKhbIEP1ZJQ+7wMvW6i7fRw3FO9PJQ933NauulTIwP4N4BI1Da5OfmGrUj9vzShJSggcl4E49qXCo/+UgsBSt3V10AWnkMxNmNh0dS2wE+H3xy7jBFoF4SXDactVIjEWSMacTMXgTLMk9Jg1zWc4wAdpXjnOyNHeqU=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj8qz11DjMrP1fDjPAPp/jQU/JtW6Rm53cXJFe5e+xTU2gnPzmaW9wRXSajvUij+gEg2Gvsm7NOg2dWDNnF3tGOXvBYYcVRsBWmPdCnTCJghK11M5OAKzBOyvEbQsxTpg5Wmi6Isc56dQwjZj5lI+Iw1tplLLO7kEgc7susarXbg36xVzHHARPkSsJoEGh0mXsNIyfWrNl1ap4gmgPDLy7F+QAXFxwyvTV0XHsOkZmCNF7//PXsN14MJdZLCmzMB7AJvb9DPXHxm69nbCC+60YvsQjQtu6dtE63/EfUWnDkg2YHU6ZbZzZyJ41pQtxKMCMvgXrC+2QsYl5bKQ4KrOqQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:9001/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:9001/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
