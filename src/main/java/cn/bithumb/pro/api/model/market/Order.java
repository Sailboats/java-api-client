package cn.bithumb.pro.api.model.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @className: Order
 * @description:
 * @author: noodle.cao
 * @date: 2021/11/2
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    private String cancelQuantity;
    private String dealPrice;
    private String dealQuantity;
    private String dealVolume;
    private String fee;
    private String feeType;
    private String oId;
    private String price;
    private String quantity;
    private String side;
    private String status;
    private String symbol;
    private long time;
    private String type;
    public void setCancelQuantity(String cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }
    public String getCancelQuantity() {
        return cancelQuantity;
    }

    public void setDealPrice(String dealPrice) {
        this.dealPrice = dealPrice;
    }
    public String getDealPrice() {
        return dealPrice;
    }

    public void setDealQuantity(String dealQuantity) {
        this.dealQuantity = dealQuantity;
    }
    public String getDealQuantity() {
        return dealQuantity;
    }

    public void setDealVolume(String dealVolume) {
        this.dealVolume = dealVolume;
    }
    public String getDealVolume() {
        return dealVolume;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
    public String getFee() {
        return fee;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }
    public String getFeeType() {
        return feeType;
    }

    public void setOId(String oId) {
        this.oId = oId;
    }
    public String getOId() {
        return oId;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getQuantity() {
        return quantity;
    }

    public void setSide(String side) {
        this.side = side;
    }
    public String getSide() {
        return side;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setTime(long time) {
        this.time = time;
    }
    public long getTime() {
        return time;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
