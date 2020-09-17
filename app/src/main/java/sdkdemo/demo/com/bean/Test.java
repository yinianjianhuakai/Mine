package sdkdemo.demo.com.bean;

import java.util.List;

/**
 * Created by  sjx  on 2020/8/27
 */
public class Test {

    /**
     * code : 0
     * data : [{"cardCashBackPrice":0,"cardDailyKnotsListByOrderList":[{"costPrice":140,"count":12,"no":1,"oilType":"92#","realPrice":126,"stationRealPrice":0,"type":128},{"costPrice":10,"count":1,"no":5,"oilType":"-10#","realPrice":9.5,"stationRealPrice":0,"type":128}],"cardSumDiscountPrice":0,"cardSumPrice":135.5,"dailyKnotsListByCardList":[{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":2},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":16},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":8192}],"dailyKnotsListByCardRefundList":[{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":8},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":32},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":16384}],"dailyKnotsListByOrderRefundList":[{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":4}],"dailyKnotsListByRefulList":[{"cardTotalPrice":0,"name":"张盼盼","offlineCashBackSumPrice":0,"offlineRealSumPrice":0,"oilCostPrice":150.1,"oilRealPrice":0.1,"refulID":2672},{"cardTotalPrice":0,"name":"任锐","offlineCashBackSumPrice":0,"offlineRealSumPrice":100,"oilCostPrice":0,"oilRealPrice":0,"refulID":2437},{"cardTotalPrice":0,"name":"未知","offlineCashBackSumPrice":0,"offlineRealSumPrice":2000,"oilCostPrice":0,"oilRealPrice":0,"refulID":0}],"dailyKnotsListPayTypeDataList":[{"costPrice":0.1,"count":9,"oilType":"","realPrice":0.1,"stationRealPrice":0,"type":1024},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":2048},{"costPrice":150,"count":13,"oilType":"","realPrice":135.5,"stationRealPrice":0,"type":256},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":512},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":32768}],"dieselDailyKnotsOilLiterNumList":[{"costPrice":10.05,"oilLiterNum":0,"oilType":"-10#"},{"costPrice":0.01,"oilLiterNum":0,"oilType":"0#"},{"costPrice":10.06,"oilLiterNum":0,"oilType":"合计"}],"discountPrice":14.51,"equityAwardSum":0,"gasoDailyKnotsOilLiterNumList":[{"costPrice":140.04,"oilLiterNum":18.04,"oilType":"92#"},{"costPrice":140.04,"oilLiterNum":18.04,"oilType":"合计"}],"groupCardCashBackPrice":0,"groupCardSumPrice":0,"leagueCardDiscountPrice":0,"memRankDiscountPrice":6,"officeEndDate":"2020-08-27 16:06:05","officeStartDate":"2020-08-25 16:26:19","offlineRealSumPrice":0,"offlineRechargeCashBackPrice":0,"offlineRechargePrice":2100,"oilCostSumPrice":150.1,"oilPaySumDiscountPrice":14.51,"oilRealSumPrice":0.1,"oilStationRealSumPrice":0.1,"onlineRealSum":0.1,"orderCount":22,"orderSumPrice":0.1,"platTakePrice":0,"promotionsDiscountPrice":0,"realCardSumPrice":0,"realGroupCardSumPrice":0,"rechargeCardDiscountPrice":0,"showCardType":false,"showGroupCardType":true,"specialCarDiscountPrice":0,"stationTakePrice":0,"wXAndAliPayDailyKnotsListByOrderList":[{"costPrice":0.04,"count":3,"no":1,"oilType":"92#","realPrice":0.04,"stationRealPrice":0,"type":64},{"costPrice":0.01,"count":1,"no":4,"oilType":"0#","realPrice":0.01,"stationRealPrice":0,"type":64},{"costPrice":0.05,"count":5,"no":5,"oilType":"-10#","realPrice":0.05,"stationRealPrice":0,"type":64}]}]
     * message :
     */

    private int code;
    private String         message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cardCashBackPrice : 0
         * cardDailyKnotsListByOrderList : [{"costPrice":140,"count":12,"no":1,"oilType":"92#","realPrice":126,"stationRealPrice":0,"type":128},{"costPrice":10,"count":1,"no":5,"oilType":"-10#","realPrice":9.5,"stationRealPrice":0,"type":128}]
         * cardSumDiscountPrice : 0
         * cardSumPrice : 135.5
         * dailyKnotsListByCardList : [{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":2},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":16},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":8192}]
         * dailyKnotsListByCardRefundList : [{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":8},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":32},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":16384}]
         * dailyKnotsListByOrderRefundList : [{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":4}]
         * dailyKnotsListByRefulList : [{"cardTotalPrice":0,"name":"张盼盼","offlineCashBackSumPrice":0,"offlineRealSumPrice":0,"oilCostPrice":150.1,"oilRealPrice":0.1,"refulID":2672},{"cardTotalPrice":0,"name":"任锐","offlineCashBackSumPrice":0,"offlineRealSumPrice":100,"oilCostPrice":0,"oilRealPrice":0,"refulID":2437},{"cardTotalPrice":0,"name":"未知","offlineCashBackSumPrice":0,"offlineRealSumPrice":2000,"oilCostPrice":0,"oilRealPrice":0,"refulID":0}]
         * dailyKnotsListPayTypeDataList : [{"costPrice":0.1,"count":9,"oilType":"","realPrice":0.1,"stationRealPrice":0,"type":1024},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":2048},{"costPrice":150,"count":13,"oilType":"","realPrice":135.5,"stationRealPrice":0,"type":256},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":512},{"costPrice":0,"count":0,"oilType":"","realPrice":0,"stationRealPrice":0,"type":32768}]
         * dieselDailyKnotsOilLiterNumList : [{"costPrice":10.05,"oilLiterNum":0,"oilType":"-10#"},{"costPrice":0.01,"oilLiterNum":0,"oilType":"0#"},{"costPrice":10.06,"oilLiterNum":0,"oilType":"合计"}]
         * discountPrice : 14.51
         * equityAwardSum : 0
         * gasoDailyKnotsOilLiterNumList : [{"costPrice":140.04,"oilLiterNum":18.04,"oilType":"92#"},{"costPrice":140.04,"oilLiterNum":18.04,"oilType":"合计"}]
         * groupCardCashBackPrice : 0
         * groupCardSumPrice : 0
         * leagueCardDiscountPrice : 0
         * memRankDiscountPrice : 6
         * officeEndDate : 2020-08-27 16:06:05
         * officeStartDate : 2020-08-25 16:26:19
         * offlineRealSumPrice : 0
         * offlineRechargeCashBackPrice : 0
         * offlineRechargePrice : 2100
         * oilCostSumPrice : 150.1
         * oilPaySumDiscountPrice : 14.51
         * oilRealSumPrice : 0.1
         * oilStationRealSumPrice : 0.1
         * onlineRealSum : 0.1
         * orderCount : 22
         * orderSumPrice : 0.1
         * platTakePrice : 0
         * promotionsDiscountPrice : 0
         * realCardSumPrice : 0
         * realGroupCardSumPrice : 0
         * rechargeCardDiscountPrice : 0
         * showCardType : false
         * showGroupCardType : true
         * specialCarDiscountPrice : 0
         * stationTakePrice : 0
         * wXAndAliPayDailyKnotsListByOrderList : [{"costPrice":0.04,"count":3,"no":1,"oilType":"92#","realPrice":0.04,"stationRealPrice":0,"type":64},{"costPrice":0.01,"count":1,"no":4,"oilType":"0#","realPrice":0.01,"stationRealPrice":0,"type":64},{"costPrice":0.05,"count":5,"no":5,"oilType":"-10#","realPrice":0.05,"stationRealPrice":0,"type":64}]
         */

        private int cardCashBackPrice;
        private int                                            cardSumDiscountPrice;
        private double                                         cardSumPrice;
        private double                                         discountPrice;
        private int                                            equityAwardSum;
        private int                                            groupCardCashBackPrice;
        private int                                            groupCardSumPrice;
        private int                                            leagueCardDiscountPrice;
        private int                                            memRankDiscountPrice;
        private String                                         officeEndDate;
        private String                                         officeStartDate;
        private int                                            offlineRealSumPrice;
        private int                                            offlineRechargeCashBackPrice;
        private int                                            offlineRechargePrice;
        private double                                         oilCostSumPrice;
        private double                                         oilPaySumDiscountPrice;
        private double                                         oilRealSumPrice;
        private double                                         oilStationRealSumPrice;
        private double                                         onlineRealSum;
        private int                                            orderCount;
        private double                                         orderSumPrice;
        private int                                            platTakePrice;
        private int                                            promotionsDiscountPrice;
        private int                                            realCardSumPrice;
        private int                                            realGroupCardSumPrice;
        private int                                            rechargeCardDiscountPrice;
        private boolean                                        showCardType;
        private boolean                                        showGroupCardType;
        private int                                            specialCarDiscountPrice;
        private int                                            stationTakePrice;
        private List<CardDailyKnotsListByOrderListBean>        cardDailyKnotsListByOrderList;
        private List<DailyKnotsListByCardListBean>             dailyKnotsListByCardList;
        private List<DailyKnotsListByCardRefundListBean>       dailyKnotsListByCardRefundList;
        private List<DailyKnotsListByOrderRefundListBean>      dailyKnotsListByOrderRefundList;
        private List<DailyKnotsListByRefulListBean>            dailyKnotsListByRefulList;
        private List<DailyKnotsListPayTypeDataListBean>        dailyKnotsListPayTypeDataList;
        private List<DieselDailyKnotsOilLiterNumListBean>      dieselDailyKnotsOilLiterNumList;
        private List<GasoDailyKnotsOilLiterNumListBean>        gasoDailyKnotsOilLiterNumList;
        private List<WXAndAliPayDailyKnotsListByOrderListBean> wXAndAliPayDailyKnotsListByOrderList;

        public int getCardCashBackPrice() {
            return cardCashBackPrice;
        }

        public void setCardCashBackPrice(int cardCashBackPrice) {
            this.cardCashBackPrice = cardCashBackPrice;
        }

        public int getCardSumDiscountPrice() {
            return cardSumDiscountPrice;
        }

        public void setCardSumDiscountPrice(int cardSumDiscountPrice) {
            this.cardSumDiscountPrice = cardSumDiscountPrice;
        }

        public double getCardSumPrice() {
            return cardSumPrice;
        }

        public void setCardSumPrice(double cardSumPrice) {
            this.cardSumPrice = cardSumPrice;
        }

        public double getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(double discountPrice) {
            this.discountPrice = discountPrice;
        }

        public int getEquityAwardSum() {
            return equityAwardSum;
        }

        public void setEquityAwardSum(int equityAwardSum) {
            this.equityAwardSum = equityAwardSum;
        }

        public int getGroupCardCashBackPrice() {
            return groupCardCashBackPrice;
        }

        public void setGroupCardCashBackPrice(int groupCardCashBackPrice) {
            this.groupCardCashBackPrice = groupCardCashBackPrice;
        }

        public int getGroupCardSumPrice() {
            return groupCardSumPrice;
        }

        public void setGroupCardSumPrice(int groupCardSumPrice) {
            this.groupCardSumPrice = groupCardSumPrice;
        }

        public int getLeagueCardDiscountPrice() {
            return leagueCardDiscountPrice;
        }

        public void setLeagueCardDiscountPrice(int leagueCardDiscountPrice) {
            this.leagueCardDiscountPrice = leagueCardDiscountPrice;
        }

        public int getMemRankDiscountPrice() {
            return memRankDiscountPrice;
        }

        public void setMemRankDiscountPrice(int memRankDiscountPrice) {
            this.memRankDiscountPrice = memRankDiscountPrice;
        }

        public String getOfficeEndDate() {
            return officeEndDate;
        }

        public void setOfficeEndDate(String officeEndDate) {
            this.officeEndDate = officeEndDate;
        }

        public String getOfficeStartDate() {
            return officeStartDate;
        }

        public void setOfficeStartDate(String officeStartDate) {
            this.officeStartDate = officeStartDate;
        }

        public int getOfflineRealSumPrice() {
            return offlineRealSumPrice;
        }

        public void setOfflineRealSumPrice(int offlineRealSumPrice) {
            this.offlineRealSumPrice = offlineRealSumPrice;
        }

        public int getOfflineRechargeCashBackPrice() {
            return offlineRechargeCashBackPrice;
        }

        public void setOfflineRechargeCashBackPrice(int offlineRechargeCashBackPrice) {
            this.offlineRechargeCashBackPrice = offlineRechargeCashBackPrice;
        }

        public int getOfflineRechargePrice() {
            return offlineRechargePrice;
        }

        public void setOfflineRechargePrice(int offlineRechargePrice) {
            this.offlineRechargePrice = offlineRechargePrice;
        }

        public double getOilCostSumPrice() {
            return oilCostSumPrice;
        }

        public void setOilCostSumPrice(double oilCostSumPrice) {
            this.oilCostSumPrice = oilCostSumPrice;
        }

        public double getOilPaySumDiscountPrice() {
            return oilPaySumDiscountPrice;
        }

        public void setOilPaySumDiscountPrice(double oilPaySumDiscountPrice) {
            this.oilPaySumDiscountPrice = oilPaySumDiscountPrice;
        }

        public double getOilRealSumPrice() {
            return oilRealSumPrice;
        }

        public void setOilRealSumPrice(double oilRealSumPrice) {
            this.oilRealSumPrice = oilRealSumPrice;
        }

        public double getOilStationRealSumPrice() {
            return oilStationRealSumPrice;
        }

        public void setOilStationRealSumPrice(double oilStationRealSumPrice) {
            this.oilStationRealSumPrice = oilStationRealSumPrice;
        }

        public double getOnlineRealSum() {
            return onlineRealSum;
        }

        public void setOnlineRealSum(double onlineRealSum) {
            this.onlineRealSum = onlineRealSum;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public double getOrderSumPrice() {
            return orderSumPrice;
        }

        public void setOrderSumPrice(double orderSumPrice) {
            this.orderSumPrice = orderSumPrice;
        }

        public int getPlatTakePrice() {
            return platTakePrice;
        }

        public void setPlatTakePrice(int platTakePrice) {
            this.platTakePrice = platTakePrice;
        }

        public int getPromotionsDiscountPrice() {
            return promotionsDiscountPrice;
        }

        public void setPromotionsDiscountPrice(int promotionsDiscountPrice) {
            this.promotionsDiscountPrice = promotionsDiscountPrice;
        }

        public int getRealCardSumPrice() {
            return realCardSumPrice;
        }

        public void setRealCardSumPrice(int realCardSumPrice) {
            this.realCardSumPrice = realCardSumPrice;
        }

        public int getRealGroupCardSumPrice() {
            return realGroupCardSumPrice;
        }

        public void setRealGroupCardSumPrice(int realGroupCardSumPrice) {
            this.realGroupCardSumPrice = realGroupCardSumPrice;
        }

        public int getRechargeCardDiscountPrice() {
            return rechargeCardDiscountPrice;
        }

        public void setRechargeCardDiscountPrice(int rechargeCardDiscountPrice) {
            this.rechargeCardDiscountPrice = rechargeCardDiscountPrice;
        }

        public boolean isShowCardType() {
            return showCardType;
        }

        public void setShowCardType(boolean showCardType) {
            this.showCardType = showCardType;
        }

        public boolean isShowGroupCardType() {
            return showGroupCardType;
        }

        public void setShowGroupCardType(boolean showGroupCardType) {
            this.showGroupCardType = showGroupCardType;
        }

        public int getSpecialCarDiscountPrice() {
            return specialCarDiscountPrice;
        }

        public void setSpecialCarDiscountPrice(int specialCarDiscountPrice) {
            this.specialCarDiscountPrice = specialCarDiscountPrice;
        }

        public int getStationTakePrice() {
            return stationTakePrice;
        }

        public void setStationTakePrice(int stationTakePrice) {
            this.stationTakePrice = stationTakePrice;
        }

        public List<CardDailyKnotsListByOrderListBean> getCardDailyKnotsListByOrderList() {
            return cardDailyKnotsListByOrderList;
        }

        public void setCardDailyKnotsListByOrderList(List<CardDailyKnotsListByOrderListBean> cardDailyKnotsListByOrderList) {
            this.cardDailyKnotsListByOrderList = cardDailyKnotsListByOrderList;
        }

        public List<DailyKnotsListByCardListBean> getDailyKnotsListByCardList() {
            return dailyKnotsListByCardList;
        }

        public void setDailyKnotsListByCardList(List<DailyKnotsListByCardListBean> dailyKnotsListByCardList) {
            this.dailyKnotsListByCardList = dailyKnotsListByCardList;
        }

        public List<DailyKnotsListByCardRefundListBean> getDailyKnotsListByCardRefundList() {
            return dailyKnotsListByCardRefundList;
        }

        public void setDailyKnotsListByCardRefundList(List<DailyKnotsListByCardRefundListBean> dailyKnotsListByCardRefundList) {
            this.dailyKnotsListByCardRefundList = dailyKnotsListByCardRefundList;
        }

        public List<DailyKnotsListByOrderRefundListBean> getDailyKnotsListByOrderRefundList() {
            return dailyKnotsListByOrderRefundList;
        }

        public void setDailyKnotsListByOrderRefundList(List<DailyKnotsListByOrderRefundListBean> dailyKnotsListByOrderRefundList) {
            this.dailyKnotsListByOrderRefundList = dailyKnotsListByOrderRefundList;
        }

        public List<DailyKnotsListByRefulListBean> getDailyKnotsListByRefulList() {
            return dailyKnotsListByRefulList;
        }

        public void setDailyKnotsListByRefulList(List<DailyKnotsListByRefulListBean> dailyKnotsListByRefulList) {
            this.dailyKnotsListByRefulList = dailyKnotsListByRefulList;
        }

        public List<DailyKnotsListPayTypeDataListBean> getDailyKnotsListPayTypeDataList() {
            return dailyKnotsListPayTypeDataList;
        }

        public void setDailyKnotsListPayTypeDataList(List<DailyKnotsListPayTypeDataListBean> dailyKnotsListPayTypeDataList) {
            this.dailyKnotsListPayTypeDataList = dailyKnotsListPayTypeDataList;
        }

        public List<DieselDailyKnotsOilLiterNumListBean> getDieselDailyKnotsOilLiterNumList() {
            return dieselDailyKnotsOilLiterNumList;
        }

        public void setDieselDailyKnotsOilLiterNumList(List<DieselDailyKnotsOilLiterNumListBean> dieselDailyKnotsOilLiterNumList) {
            this.dieselDailyKnotsOilLiterNumList = dieselDailyKnotsOilLiterNumList;
        }

        public List<GasoDailyKnotsOilLiterNumListBean> getGasoDailyKnotsOilLiterNumList() {
            return gasoDailyKnotsOilLiterNumList;
        }

        public void setGasoDailyKnotsOilLiterNumList(List<GasoDailyKnotsOilLiterNumListBean> gasoDailyKnotsOilLiterNumList) {
            this.gasoDailyKnotsOilLiterNumList = gasoDailyKnotsOilLiterNumList;
        }

        public List<WXAndAliPayDailyKnotsListByOrderListBean> getWXAndAliPayDailyKnotsListByOrderList() {
            return wXAndAliPayDailyKnotsListByOrderList;
        }

        public void setWXAndAliPayDailyKnotsListByOrderList(List<WXAndAliPayDailyKnotsListByOrderListBean> wXAndAliPayDailyKnotsListByOrderList) {
            this.wXAndAliPayDailyKnotsListByOrderList = wXAndAliPayDailyKnotsListByOrderList;
        }

        public static class CardDailyKnotsListByOrderListBean {
            /**
             * costPrice : 140
             * count : 12
             * no : 1
             * oilType : 92#
             * realPrice : 126
             * stationRealPrice : 0
             * type : 128
             */

            private int costPrice;
            private int    count;
            private int    no;
            private String oilType;
            private int    realPrice;
            private int    stationRealPrice;
            private int    type;

            public int getCostPrice() {
                return costPrice;
            }

            public void setCostPrice(int costPrice) {
                this.costPrice = costPrice;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public int getRealPrice() {
                return realPrice;
            }

            public void setRealPrice(int realPrice) {
                this.realPrice = realPrice;
            }

            public int getStationRealPrice() {
                return stationRealPrice;
            }

            public void setStationRealPrice(int stationRealPrice) {
                this.stationRealPrice = stationRealPrice;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class DailyKnotsListByCardListBean {
            /**
             * costPrice : 0
             * count : 0
             * oilType :
             * realPrice : 0
             * stationRealPrice : 0
             * type : 2
             */

            private int costPrice;
            private int    count;
            private String oilType;
            private int    realPrice;
            private int    stationRealPrice;
            private int    type;

            public int getCostPrice() {
                return costPrice;
            }

            public void setCostPrice(int costPrice) {
                this.costPrice = costPrice;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public int getRealPrice() {
                return realPrice;
            }

            public void setRealPrice(int realPrice) {
                this.realPrice = realPrice;
            }

            public int getStationRealPrice() {
                return stationRealPrice;
            }

            public void setStationRealPrice(int stationRealPrice) {
                this.stationRealPrice = stationRealPrice;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class DailyKnotsListByCardRefundListBean {
            /**
             * costPrice : 0
             * count : 0
             * oilType :
             * realPrice : 0
             * stationRealPrice : 0
             * type : 8
             */

            private int costPrice;
            private int    count;
            private String oilType;
            private int    realPrice;
            private int    stationRealPrice;
            private int    type;

            public int getCostPrice() {
                return costPrice;
            }

            public void setCostPrice(int costPrice) {
                this.costPrice = costPrice;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public int getRealPrice() {
                return realPrice;
            }

            public void setRealPrice(int realPrice) {
                this.realPrice = realPrice;
            }

            public int getStationRealPrice() {
                return stationRealPrice;
            }

            public void setStationRealPrice(int stationRealPrice) {
                this.stationRealPrice = stationRealPrice;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class DailyKnotsListByOrderRefundListBean {
            /**
             * costPrice : 0
             * count : 0
             * oilType :
             * realPrice : 0
             * stationRealPrice : 0
             * type : 4
             */

            private int costPrice;
            private int    count;
            private String oilType;
            private int    realPrice;
            private int    stationRealPrice;
            private int    type;

            public int getCostPrice() {
                return costPrice;
            }

            public void setCostPrice(int costPrice) {
                this.costPrice = costPrice;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public int getRealPrice() {
                return realPrice;
            }

            public void setRealPrice(int realPrice) {
                this.realPrice = realPrice;
            }

            public int getStationRealPrice() {
                return stationRealPrice;
            }

            public void setStationRealPrice(int stationRealPrice) {
                this.stationRealPrice = stationRealPrice;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class DailyKnotsListByRefulListBean {
            /**
             * cardTotalPrice : 0
             * name : 张盼盼
             * offlineCashBackSumPrice : 0
             * offlineRealSumPrice : 0
             * oilCostPrice : 150.1
             * oilRealPrice : 0.1
             * refulID : 2672
             */

            private int cardTotalPrice;
            private String name;
            private int    offlineCashBackSumPrice;
            private int    offlineRealSumPrice;
            private double oilCostPrice;
            private double oilRealPrice;
            private int    refulID;

            public int getCardTotalPrice() {
                return cardTotalPrice;
            }

            public void setCardTotalPrice(int cardTotalPrice) {
                this.cardTotalPrice = cardTotalPrice;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getOfflineCashBackSumPrice() {
                return offlineCashBackSumPrice;
            }

            public void setOfflineCashBackSumPrice(int offlineCashBackSumPrice) {
                this.offlineCashBackSumPrice = offlineCashBackSumPrice;
            }

            public int getOfflineRealSumPrice() {
                return offlineRealSumPrice;
            }

            public void setOfflineRealSumPrice(int offlineRealSumPrice) {
                this.offlineRealSumPrice = offlineRealSumPrice;
            }

            public double getOilCostPrice() {
                return oilCostPrice;
            }

            public void setOilCostPrice(double oilCostPrice) {
                this.oilCostPrice = oilCostPrice;
            }

            public double getOilRealPrice() {
                return oilRealPrice;
            }

            public void setOilRealPrice(double oilRealPrice) {
                this.oilRealPrice = oilRealPrice;
            }

            public int getRefulID() {
                return refulID;
            }

            public void setRefulID(int refulID) {
                this.refulID = refulID;
            }
        }

        public static class DailyKnotsListPayTypeDataListBean {
            /**
             * costPrice : 0.1
             * count : 9
             * oilType :
             * realPrice : 0.1
             * stationRealPrice : 0
             * type : 1024
             */

            private double costPrice;
            private int    count;
            private String oilType;
            private double realPrice;
            private int    stationRealPrice;
            private int    type;

            public double getCostPrice() {
                return costPrice;
            }

            public void setCostPrice(double costPrice) {
                this.costPrice = costPrice;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public double getRealPrice() {
                return realPrice;
            }

            public void setRealPrice(double realPrice) {
                this.realPrice = realPrice;
            }

            public int getStationRealPrice() {
                return stationRealPrice;
            }

            public void setStationRealPrice(int stationRealPrice) {
                this.stationRealPrice = stationRealPrice;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class DieselDailyKnotsOilLiterNumListBean {
            /**
             * costPrice : 10.05
             * oilLiterNum : 0
             * oilType : -10#
             */

            private double costPrice;
            private int    oilLiterNum;
            private String oilType;

            public double getCostPrice() {
                return costPrice;
            }

            public void setCostPrice(double costPrice) {
                this.costPrice = costPrice;
            }

            public int getOilLiterNum() {
                return oilLiterNum;
            }

            public void setOilLiterNum(int oilLiterNum) {
                this.oilLiterNum = oilLiterNum;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }
        }

        public static class GasoDailyKnotsOilLiterNumListBean {
            /**
             * costPrice : 140.04
             * oilLiterNum : 18.04
             * oilType : 92#
             */

            private double costPrice;
            private double oilLiterNum;
            private String oilType;

            public double getCostPrice() {
                return costPrice;
            }

            public void setCostPrice(double costPrice) {
                this.costPrice = costPrice;
            }

            public double getOilLiterNum() {
                return oilLiterNum;
            }

            public void setOilLiterNum(double oilLiterNum) {
                this.oilLiterNum = oilLiterNum;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }
        }

        public static class WXAndAliPayDailyKnotsListByOrderListBean {
            /**
             * costPrice : 0.04
             * count : 3
             * no : 1
             * oilType : 92#
             * realPrice : 0.04
             * stationRealPrice : 0
             * type : 64
             */

            private double costPrice;
            private int    count;
            private int    no;
            private String oilType;
            private double realPrice;
            private int    stationRealPrice;
            private int    type;

            public double getCostPrice() {
                return costPrice;
            }

            public void setCostPrice(double costPrice) {
                this.costPrice = costPrice;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public double getRealPrice() {
                return realPrice;
            }

            public void setRealPrice(double realPrice) {
                this.realPrice = realPrice;
            }

            public int getStationRealPrice() {
                return stationRealPrice;
            }

            public void setStationRealPrice(int stationRealPrice) {
                this.stationRealPrice = stationRealPrice;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
