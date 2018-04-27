package com.mo.test.entity;


import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 *
 * @author jhonelee
 */
public class Order {

    private Long id;
    /**
     * 渠道代码
     */
    private Long channel;

    /**
     * 平台代码
     */
    private Long plantform;

    /**
     * 客户端代码
     */
    private Long client;

    /**
     * 订单序列号
     */
    private String serialNumber;

    /**
     * 原销售单号
     */
    private String originalOrder;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 订单状态
     */
    private Integer orderStatus;


    /**
     * 商场id
     */
    private String marketId;

    /**
     * 商场名称
     */
    private String marketName;


    /**
     * 店铺ID
     */
    private String shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 促销总金额
     */
    private BigDecimal promotionTotalAmount;


    /**
     * 抹零金额
     */
    private BigDecimal exceptedChangeAmount;

    /**
     * 应付金额
     */
    private BigDecimal payableAmount;

    /**
     * 服务费金额
     */
    private BigDecimal serviceAmount;

    private BigDecimal refundedAmount;

    /**
     * 本次付款金额（促销计算）
     */
    private BigDecimal thisPayAmountForProm;

    /**
     * 创建用户id
     */
    private String createUserId;

    /**
     * 创建用户名称
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private Date createDate;


    /**
     * 最后更新者id
     */
    private String lastUpdateUserId;

    /**
     * 最后更新者名称
     */
    private String lastUpdateUserName;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 区域id
     */
    private Long areaId;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 购买人id
     */
    private String purchaserId;

    /**
     * 购买人名称
     */
    private String purchaserName;

    /**
     * 收货人id
     */
    private String receiverId;

    /**
     * 收货人名称
     */
    private String receiverName;


    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 送货地址
     */
    private String address;

    /**
     * 运费
     */
    private BigDecimal carriage;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Boolean deleteFlag;

    private Long referenceId;

    /**
     * 关联原订单
     */
    private Order referenceOrder;

    /**
     * 是否可以退款
     */
    private Boolean canRefund;


    /**
     * 合同号
     */
    private String contractNumber;


    /**
     * 系列编码
     */
    private String serialCode;

    /**
     * 系列名称
     */
    private String serialName;


    /**
     * 首付金额
     */
    private BigDecimal firstPayment;

    /**
     * 已付金额
     */
    private BigDecimal paidAmount;

    /**
     * 约定送货日期yyyy-mm-dd
     */
    private Date agreedDeliveryDate;

    /**
     * 实际送货日期
     */
    private Date realDeliverDate;

    /**
     * 经销商id
     */
    private String dealerId;
    /**
     * 经销商名称
     */
    private String dealerName;

    /**
     * 确认收货日期
     */
    private Date realReceivedDate;

    /**
     * 省id
     */
    private String provinceId;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 市id
     */
    private String cityId;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 区id
     */
    private String districtId;

    /**
     * 区名称
     */
    private String districtName;


    /**
     * 是否阶段订单
     */
    private Boolean isStage;


    /**
     * 收货人手机号
     */
    private String receiverMobile;


    /**
     * 结算时间
     */
    private Date settlementDate;

    /**
     * 结算金额
     */
    private BigDecimal settlementAmount;


    private Date planedSettlementDate;

    private Integer afterSale;

    /**
     * 计算促销金额时生成的流水号
     */
    private String calcSerialNo;

    /**
     * 本次支付金额
     */
    private BigDecimal thisPayAmount;

    /**
     * oms商场uuid
     */
    private String omsUuid;

    /**
     * 是否通过购物车购买
     */
    private Boolean isByCart;

    /**
     * 评价时间
     */
    private Date reviewDate;

    /**
     * 评价id
     */
    private String reviewId;

    /**
     * 商品总价
     */
    private BigDecimal orderItemTotalAmount;

    private boolean isAdditionReview;   //是否可追评

    /**
     * 扩展订单类型状态
     */
    private Integer extendStatus;

    /**
     * 扩展订单类型
     */
    private Integer extendType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    public Long getPlantform() {
        return plantform;
    }

    public void setPlantform(Long plantform) {
        this.plantform = plantform;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOriginalOrder() {
        return originalOrder;
    }

    public void setOriginalOrder(String originalOrder) {
        this.originalOrder = originalOrder;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPromotionTotalAmount() {
        return promotionTotalAmount;
    }

    public void setPromotionTotalAmount(BigDecimal promotionTotalAmount) {
        this.promotionTotalAmount = promotionTotalAmount;
    }

    public BigDecimal getExceptedChangeAmount() {
        return exceptedChangeAmount;
    }

    public void setExceptedChangeAmount(BigDecimal exceptedChangeAmount) {
        this.exceptedChangeAmount = exceptedChangeAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(BigDecimal serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public BigDecimal getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(BigDecimal refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public BigDecimal getThisPayAmountForProm() {
        return thisPayAmountForProm;
    }

    public void setThisPayAmountForProm(BigDecimal thisPayAmountForProm) {
        this.thisPayAmountForProm = thisPayAmountForProm;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getLastUpdateUserName() {
        return lastUpdateUserName;
    }

    public void setLastUpdateUserName(String lastUpdateUserName) {
        this.lastUpdateUserName = lastUpdateUserName;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(String purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getCarriage() {
        return carriage;
    }

    public void setCarriage(BigDecimal carriage) {
        this.carriage = carriage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public Order getReferenceOrder() {
        return referenceOrder;
    }

    public void setReferenceOrder(Order referenceOrder) {
        this.referenceOrder = referenceOrder;
    }

    public Boolean getCanRefund() {
        return canRefund;
    }

    public void setCanRefund(Boolean canRefund) {
        this.canRefund = canRefund;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    public BigDecimal getFirstPayment() {
        return firstPayment;
    }

    public void setFirstPayment(BigDecimal firstPayment) {
        this.firstPayment = firstPayment;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Date getAgreedDeliveryDate() {
        return agreedDeliveryDate;
    }

    public void setAgreedDeliveryDate(Date agreedDeliveryDate) {
        this.agreedDeliveryDate = agreedDeliveryDate;
    }

    public Date getRealDeliverDate() {
        return realDeliverDate;
    }

    public void setRealDeliverDate(Date realDeliverDate) {
        this.realDeliverDate = realDeliverDate;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public Date getRealReceivedDate() {
        return realReceivedDate;
    }

    public void setRealReceivedDate(Date realReceivedDate) {
        this.realReceivedDate = realReceivedDate;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Boolean getStage() {
        return isStage;
    }

    public void setStage(Boolean stage) {
        isStage = stage;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public BigDecimal getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(BigDecimal settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public Date getPlanedSettlementDate() {
        return planedSettlementDate;
    }

    public void setPlanedSettlementDate(Date planedSettlementDate) {
        this.planedSettlementDate = planedSettlementDate;
    }

    public Integer getAfterSale() {
        return afterSale;
    }

    public void setAfterSale(Integer afterSale) {
        this.afterSale = afterSale;
    }

    public String getCalcSerialNo() {
        return calcSerialNo;
    }

    public void setCalcSerialNo(String calcSerialNo) {
        this.calcSerialNo = calcSerialNo;
    }

    public BigDecimal getThisPayAmount() {
        return thisPayAmount;
    }

    public void setThisPayAmount(BigDecimal thisPayAmount) {
        this.thisPayAmount = thisPayAmount;
    }

    public String getOmsUuid() {
        return omsUuid;
    }

    public void setOmsUuid(String omsUuid) {
        this.omsUuid = omsUuid;
    }

    public Boolean getByCart() {
        return isByCart;
    }

    public void setByCart(Boolean byCart) {
        isByCart = byCart;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public BigDecimal getOrderItemTotalAmount() {
        return orderItemTotalAmount;
    }

    public void setOrderItemTotalAmount(BigDecimal orderItemTotalAmount) {
        this.orderItemTotalAmount = orderItemTotalAmount;
    }

    public boolean isAdditionReview() {
        return isAdditionReview;
    }

    public void setAdditionReview(boolean additionReview) {
        isAdditionReview = additionReview;
    }

    public Integer getExtendStatus() {
        return extendStatus;
    }

    public void setExtendStatus(Integer extendStatus) {
        this.extendStatus = extendStatus;
    }

    public Integer getExtendType() {
        return extendType;
    }

    public void setExtendType(Integer extendType) {
        this.extendType = extendType;
    }
}

