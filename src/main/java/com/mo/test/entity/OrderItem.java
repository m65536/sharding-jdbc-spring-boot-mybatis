package com.mo.test.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 *
 * @author john.lee
 */
public class OrderItem {


    private Long id;
    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单
     */
    private Order order;

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 产品id
     */
    private String productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 商品图片
     */
    private String imgUrl;

    /**
     * 品牌id
     */
    private String brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 单位id
     */
    private String unitId;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 售价
     */
    private BigDecimal salePrice;

    /**
     * 库存id
     */
    private String inventoryId;

    /**
     * 购买数量
     */
    private BigDecimal quantity;

    /**
     * 有效剩余数量 = 总购买数量 - 已退数量
     */
    private BigDecimal realQuantity;

    /**
     * 购买总价
     */
    private BigDecimal totalAmount;

    private BigDecimal paidAmount;

    /**
     * 分摊比例
     */
    private BigDecimal shareRate;

    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 是否删除
     */
    private Boolean deleteFlag;

    /**
     * 价签码
     */
    private String signedCode;

    /**
     * 型号
     */
    private String model;

    /**
     * 规格
     */
    private String size;

    /**
     * 规格单位
     */
    private String sizeUnit;

    /**
     * 折扣率
     */
    private BigDecimal discountRate;

    /**
     * 1：明码实价，2：明码议价
     */
    private Boolean isBlatantly;

    /**
     * 系列编码
     */
    private String serialCode;

    /**
     * 系列名称
     */
    private String serialName;

    /**
     * 商品描述说明
     */
    private String description;

    /**
     * 是否可退
     */
    private Boolean canRefund;

    /**
     * oms价签码
     */
    private String omsPriceTagCode;

    /**
     * 颜色
     */
    private String color;

    /**
     * 颜色编码
     */
    private String colorRgb;

    /**
     * 商品sku
     */
    private String sku;

    /**
     * 库存数量
     */
    private Integer inventory;

    /**
     * 是否是服务费
     */
    private Boolean isService;

    /**
     * 原单商品id
     */
    private Long referenceItemId;


    /**
     * 评价时间
     */
    private Date reviewDate;

    /**
     * 评价id
     */
    private String reviewId;

    /**
     * 商品类型：0店铺商品；1：自采商品
     */
    private Integer goodsType;

    /**
     * 纯线上销售：0否；1：是
     */
    private Integer saleChannel;

    //是否买过的爆款商品：true：是，false：否（改单用）
    private Boolean purchased;

    /**
     * 是否爆款（B端判断店铺折扣率）
     */
    private Boolean hotItem;

    /**
     * 是否显示计价单位（C端）
     */
    private Boolean unitIsShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(BigDecimal realQuantity) {
        this.realQuantity = realQuantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getShareRate() {
        return shareRate;
    }

    public void setShareRate(BigDecimal shareRate) {
        this.shareRate = shareRate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getSignedCode() {
        return signedCode;
    }

    public void setSignedCode(String signedCode) {
        this.signedCode = signedCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public Boolean getBlatantly() {
        return isBlatantly;
    }

    public void setBlatantly(Boolean blatantly) {
        isBlatantly = blatantly;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCanRefund() {
        return canRefund;
    }

    public void setCanRefund(Boolean canRefund) {
        this.canRefund = canRefund;
    }

    public String getOmsPriceTagCode() {
        return omsPriceTagCode;
    }

    public void setOmsPriceTagCode(String omsPriceTagCode) {
        this.omsPriceTagCode = omsPriceTagCode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorRgb() {
        return colorRgb;
    }

    public void setColorRgb(String colorRgb) {
        this.colorRgb = colorRgb;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Boolean getService() {
        return isService;
    }

    public void setService(Boolean service) {
        isService = service;
    }

    public Long getReferenceItemId() {
        return referenceItemId;
    }

    public void setReferenceItemId(Long referenceItemId) {
        this.referenceItemId = referenceItemId;
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

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getSaleChannel() {
        return saleChannel;
    }

    public void setSaleChannel(Integer saleChannel) {
        this.saleChannel = saleChannel;
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }

    public Boolean getHotItem() {
        return hotItem;
    }

    public void setHotItem(Boolean hotItem) {
        this.hotItem = hotItem;
    }

    public Boolean getUnitIsShow() {
        return unitIsShow;
    }

    public void setUnitIsShow(Boolean unitIsShow) {
        this.unitIsShow = unitIsShow;
    }
}
