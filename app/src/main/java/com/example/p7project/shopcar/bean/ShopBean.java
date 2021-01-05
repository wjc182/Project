package com.example.p7project.shopcar.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[{"id":1702,"user_id":5,"session_id":"1","goods_id":1127025,"goods_sn":"1127025","product_id":179,"goods_name":"女式蝶边真丝内裤","market_price":39,"retail_price":39,"number":8,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/b2fe79c872a8a7f647264b5e51bcc802.png"}],"cartTotal":{"goodsCount":8,"goodsAmount":312,"checkedGoodsCount":8,"checkedGoodsAmount":312}}
     */

    @SerializedName("errno")
    private int errno;
    @SerializedName("errmsg")
    private String errmsg;
    /**
     * cartList : [{"id":1702,"user_id":5,"session_id":"1","goods_id":1127025,"goods_sn":"1127025","product_id":179,"goods_name":"女式蝶边真丝内裤","market_price":39,"retail_price":39,"number":8,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/b2fe79c872a8a7f647264b5e51bcc802.png"}]
     * cartTotal : {"goodsCount":8,"goodsAmount":312,"checkedGoodsCount":8,"checkedGoodsAmount":312}
     */

    @SerializedName("data")
    private DataDTO data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * goodsCount : 8
         * goodsAmount : 312
         * checkedGoodsCount : 8
         * checkedGoodsAmount : 312
         */

        @SerializedName("cartTotal")
        private CartTotalDTO cartTotal;
        /**
         * id : 1702
         * user_id : 5
         * session_id : 1
         * goods_id : 1127025
         * goods_sn : 1127025
         * product_id : 179
         * goods_name : 女式蝶边真丝内裤
         * market_price : 39
         * retail_price : 39
         * number : 8
         * goods_specifition_name_value :
         * goods_specifition_ids :
         * checked : 1
         * list_pic_url : http://yanxuan.nosdn.127.net/b2fe79c872a8a7f647264b5e51bcc802.png
         */

        @SerializedName("cartList")
        private List<CartListDTO> cartList;

        public CartTotalDTO getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalDTO cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<CartListDTO> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListDTO> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalDTO {
            @SerializedName("goodsCount")
            private int goodsCount;
            @SerializedName("goodsAmount")
            private int goodsAmount;
            @SerializedName("checkedGoodsCount")
            private int checkedGoodsCount;
            @SerializedName("checkedGoodsAmount")
            private int checkedGoodsAmount;

            public int getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(int goodsCount) {
                this.goodsCount = goodsCount;
            }

            public int getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(int goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public int getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(int checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public int getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(int checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }

        public static class CartListDTO {

            private boolean shopCheck;

            public boolean isShopCheck() {
                return shopCheck;
            }

            public void setShopCheck(boolean shopCheck) {
                this.shopCheck = shopCheck;
            }

            @SerializedName("id")
            private int id;
            @SerializedName("user_id")
            private int userId;
            @SerializedName("session_id")
            private String sessionId;
            @SerializedName("goods_id")
            private int goodsId;
            @SerializedName("goods_sn")
            private String goodsSn;
            @SerializedName("product_id")
            private int productId;
            @SerializedName("goods_name")
            private String goodsName;
            @SerializedName("market_price")
            private int marketPrice;
            @SerializedName("retail_price")
            private int retailPrice;
            @SerializedName("number")
            private int number;
            @SerializedName("goods_specifition_name_value")
            private String goodsSpecifitionNameValue;
            @SerializedName("goods_specifition_ids")
            private String goodsSpecifitionIds;
            @SerializedName("checked")
            private int checked;
            @SerializedName("list_pic_url")
            private String listPicUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getSessionId() {
                return sessionId;
            }

            public void setSessionId(String sessionId) {
                this.sessionId = sessionId;
            }

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsSn() {
                return goodsSn;
            }

            public void setGoodsSn(String goodsSn) {
                this.goodsSn = goodsSn;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public int getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(int marketPrice) {
                this.marketPrice = marketPrice;
            }

            public int getRetailPrice() {
                return retailPrice;
            }

            public void setRetailPrice(int retailPrice) {
                this.retailPrice = retailPrice;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getGoodsSpecifitionNameValue() {
                return goodsSpecifitionNameValue;
            }

            public void setGoodsSpecifitionNameValue(String goodsSpecifitionNameValue) {
                this.goodsSpecifitionNameValue = goodsSpecifitionNameValue;
            }

            public String getGoodsSpecifitionIds() {
                return goodsSpecifitionIds;
            }

            public void setGoodsSpecifitionIds(String goodsSpecifitionIds) {
                this.goodsSpecifitionIds = goodsSpecifitionIds;
            }

            public int getChecked() {
                return checked;
            }

            public void setChecked(int checked) {
                this.checked = checked;
            }

            public String getListPicUrl() {
                return listPicUrl;
            }

            public void setListPicUrl(String listPicUrl) {
                this.listPicUrl = listPicUrl;
            }
        }
    }
}
