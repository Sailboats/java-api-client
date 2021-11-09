package cn.bithumb.pro.api.test;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.BithumbProApiWebSocketClient;
import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.TopicEnum;
import cn.bithumb.pro.api.model.BaseWebSocketResponse;
import cn.bithumb.pro.api.model.market.Order;
import cn.bithumb.pro.api.model.market.Trade;
import cn.bithumb.pro.api.service.ResponseListener;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestWebSocket {

    public static void main(String[] args) throws Exception {

        String topic = TopicEnum.CONTRACT_PRICE.name();
//        webSocketClient.subscribe(Collections.singletonList(topic));
        String apiKey = "49ef245abb8614d499b7e09fbcf3a822";
        String secretKey = "87b88e11a15560ddd8efb282b2760b9206d617497629af4efaf12dab9f3c6baa";
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiWebSocketClient webSocketClient = factory.newWebSocketClient();

        BithumbProApiRestClient bithumbProApiRestClient = factory.newRestClient();


        String path="/message/realtime";
        long timeStamp = System.currentTimeMillis();

        String signatureString=path + timeStamp + apiKey;

        String apiSignature = HMACSHA256(signatureString,secretKey);
        webSocketClient.authKey(apiKey, timeStamp, apiSignature);
//        String symbol = "QTUM-USDT";
//        String topics = String.format("%s:%s", TopicEnum.TRADE, symbol);
//        webSocketClient.subscribe(Collections.singletonList(topics));
//        webSocketClient.onTrades(TopicEnum.TRADE.name(), (ResponseListener<BaseWebSocketResponse<List<Trade>>>) msg -> {
//            List<Trade> trades = msg.getData();
//            trades = trades.stream().filter(Objects::nonNull).filter(i -> symbol.equals(i.getSymbol())).collect(Collectors.toList());
//            System.out.println("Trade: " + JsonUtil.objToJson(trades));
//        });

        String symbol = "QTUM-USDT";
        String topics = String.format("%s:%s", TopicEnum.ORDER, symbol);
        webSocketClient.subscribe(Collections.singletonList(topics));
        webSocketClient.onOrder(TopicEnum.ORDER.name(), (ResponseListener<BaseWebSocketResponse<Order>>) msg -> {
            Order order = msg.getData();
            System.out.println("Trade: " + JsonUtil.objToJson(order));
        });


//        System.out.println(HMACSHA256("123456","654321"));
    }

    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");

        sha256_HMAC.init(secret_key);

        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));

        StringBuilder sb = new StringBuilder();

        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));

        }

        return sb.toString();

    }
}
