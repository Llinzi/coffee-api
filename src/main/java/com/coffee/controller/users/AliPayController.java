package com.coffee.controller.users;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.coffee.config.AliPayConfig;
import com.coffee.entity.BizContent;
import com.coffee.entity.SyServiceProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : AlipayController
 * @Description : 支付控制器
 * @Author : 王显成
 * @Date: 2020-05-12 00:40
 */
@Api(value = "AliPayController",tags = "支付控制器")
@RestController
@RequestMapping(value = "/pay")
public class AliPayController {

    @ApiOperation(value = "支付功能",httpMethod = "POST")
    @RequestMapping(value = "/aliPay")
    public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Float amount, String orderMsg, String orderNo)
            throws ServletException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
                AliPayConfig.app_id, AliPayConfig.merchant_private_key, "json", AliPayConfig.charset,
                AliPayConfig.alipay_public_key, AliPayConfig.sign_type); // 获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
        alipayRequest.setReturnUrl("http://localhost:63342/admin-view/frontPage/shop_cart.html");//回调地址
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");// 在公共参数中设置回跳和通知地址
        BizContent bizContent = new BizContent();
        //订单编号
        bizContent.setOut_trade_no(orderNo);
        //订单金额
        bizContent.setTotal_amount(amount);
        //订单名称
        bizContent.setSubject(orderMsg);
        bizContent.setProduct_code("FAST_INSTANT_TRADE_PAY");

        SyServiceProvider syServiceProvider = new SyServiceProvider();
        syServiceProvider.setSys_service_provider_id("2088511833207846");
        bizContent.setExtend_params(syServiceProvider);
        String bizCt = JSON.toJSONString(bizContent);

//		alipayRequest.setBizContent("{" + "    \"out_trade_no\":\"2015201607090346\","
//				+ "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + "    \"total_amount\":" + amount + ","
//				+ "    \"subject\":\"" + orderMsg + "\"," + "    \"body\":\"Iphone6 16G\","
//				+ "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","
//				+ "    \"extend_params\":{" + "    \"sys_service_provider_id\":\"2088511833207846\"" + "    }" + "  }");// 填充业务参数
        String form = "";
        alipayRequest.setBizContent(bizCt);
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + AliPayConfig.charset);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }
}
