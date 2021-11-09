package cn.bithumb.pro.api.test;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.JsonUtil;

public class TestRest {

    public static void main(String[] args) {
        BithumbProApiClientFactory factory = new BithumbProApiClientFactory("49ef245abb8614d499b7e09fbcf3a822", "87b88e11a15560ddd8efb282b2760b9206d617497629af4efaf12dab9f3c6baa");
        BithumbProApiRestClient restClient = factory.newRestClient();
//        String symbol = "BTC-USDT";
//        System.out.println(JsonUtil.objToJson(restClient.ticker(symbol)));
//        System.out.println(JsonUtil.objToJson(restClient.orderBook(symbol)));
        System.out.println(JsonUtil.objToJson(restClient.assets(null, "spot")));
    }
}
