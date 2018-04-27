package com.mo.test.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
    /**
     * 主键，自增长，步长＝1
     */
    private Long id;

    /**
     * 外键，关联到tx_order.id
     */
    private Long orderId;

    /**
     * 商户唯一标示符，从商户系统中获取商户信息
     */
    private String merchantId;

    /**
     * 商户名称，从商户系统获取
     */
    private String merchantName;

    /**
     * 产品id，从产品系统中获取产品信息
     */
    private String productId;

    /**
     * 产品名称，从产品系统中获取
     */
    private String productName;

    /**
     * 品牌id，从商品库获取
     */
    private String brandId;

    /**
     * 名牌名称，从商品库获取
     */
    private String brandName;

    /**
     * 商品圖片路徑
     */
    private String imgUrl;

    /**
     * 商品类型，从商品库获取，（买券类型：3.购买券，4.抵用券）
     */
    private Integer orderItemType;

    /**
     * 商品单位id，从商品库获取
     */
    private String unitId;

    /**
     * 商品单位名称，从商品库获取
     */
    private String unitName;

    /**
     * 商品单价，从定价库获取
     */
    private BigDecimal unitPrice;

    /**
     * 商品销售价格，从定价系统获取
     */
    private BigDecimal salePrice;

    /**
     * 分摊到商品已付金额
     */
    private BigDecimal paidAmount;

    /**
     * (真实售价*数量-此商品b端总促销)/（订单总商品售价-b端订单总促销金额）
     */
    private BigDecimal shareRate;

    /**
     * 单项商品购买总价
     */
    private BigDecimal totalAmount;

    /**
     * 库存id，从商品库获取
     */
    private String inventoryId;

    /**
     * 购买数量
     */
    private BigDecimal quantity;

    /**
     * 真实数量（= 总数量 - 已退数量）
     */
    private BigDecimal realQuantity;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 
     */
    private Boolean deleteFlag;

    /**
     * 价签码(龙果提供)sku_id
     */
    private String signedCode;

    /**
     * 型号（龙果）
     */
    private String model;

    /**
     * 规格（龙果）没有就反斜杠
     */
    private String size;

    /**
     * 规格单位（龙果）
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
     * 系列编码，龙果提供
     */
    private String serialCode;

    /**
     * 系列名称，龙果提供
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
     * 颜色
     */
    private String color;

    /**
     * 颜色编码
     */
    private String colorRgb;

    /**
     * oms价签码
     */
    private String omsPriceTagCode;

    /**
     * 商品sku
     */
    private String sku;

    /**
     * 是否是服务费 0：不是，1：是
     */
    private Boolean isService;

    /**
     * 原单商品id
     */
    private Long referenceItemId;

    /**
     * 评价状态
     */
    private Integer reviewStatus;

    /**
     * 评价时间
     */
    private Date reviewDate;

    /**
     * 对应评价系统的评价id
     */
    private String reviewId;

    /**
     * 商品类型：0店铺商品；1：自采商品
     */
    private Boolean goodsType;

    /**
     * 纯线上销售：0否；1：是
     */
    private Boolean saleChannel;

    /**
     * 计价单位是否显示：0否；1：是
     */
    private Boolean unitIsShow;

    /**
     * 主键，自增长，步长＝1
     * @return id 主键，自增长，步长＝1
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键，自增长，步长＝1
     * @param id 主键，自增长，步长＝1
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 外键，关联到tx_order.id
     * @return order_id 外键，关联到tx_order.id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 外键，关联到tx_order.id
     * @param orderId 外键，关联到tx_order.id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 商户唯一标示符，从商户系统中获取商户信息
     * @return merchant_id 商户唯一标示符，从商户系统中获取商户信息
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * 商户唯一标示符，从商户系统中获取商户信息
     * @param merchantId 商户唯一标示符，从商户系统中获取商户信息
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    /**
     * 商户名称，从商户系统获取
     * @return merchant_name 商户名称，从商户系统获取
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 商户名称，从商户系统获取
     * @param merchantName 商户名称，从商户系统获取
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * 产品id，从产品系统中获取产品信息
     * @return product_id 产品id，从产品系统中获取产品信息
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 产品id，从产品系统中获取产品信息
     * @param productId 产品id，从产品系统中获取产品信息
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * 产品名称，从产品系统中获取
     * @return product_name 产品名称，从产品系统中获取
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 产品名称，从产品系统中获取
     * @param productName 产品名称，从产品系统中获取
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 品牌id，从商品库获取
     * @return brand_id 品牌id，从商品库获取
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * 品牌id，从商品库获取
     * @param brandId 品牌id，从商品库获取
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    /**
     * 名牌名称，从商品库获取
     * @return brand_name 名牌名称，从商品库获取
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 名牌名称，从商品库获取
     * @param brandName 名牌名称，从商品库获取
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 商品圖片路徑
     * @return img_url 商品圖片路徑
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 商品圖片路徑
     * @param imgUrl 商品圖片路徑
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 商品类型，从商品库获取，（买券类型：3.购买券，4.抵用券）
     * @return order_item_type 商品类型，从商品库获取，（买券类型：3.购买券，4.抵用券）
     */
    public Integer getOrderItemType() {
        return orderItemType;
    }

    /**
     * 商品类型，从商品库获取，（买券类型：3.购买券，4.抵用券）
     * @param orderItemType 商品类型，从商品库获取，（买券类型：3.购买券，4.抵用券）
     */
    public void setOrderItemType(Integer orderItemType) {
        this.orderItemType = orderItemType;
    }

    /**
     * 商品单位id，从商品库获取
     * @return unit_id 商品单位id，从商品库获取
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * 商品单位id，从商品库获取
     * @param unitId 商品单位id，从商品库获取
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    /**
     * 商品单位名称，从商品库获取
     * @return unit_name 商品单位名称，从商品库获取
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 商品单位名称，从商品库获取
     * @param unitName 商品单位名称，从商品库获取
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    /**
     * 商品单价，从定价库获取
     * @return unit_price 商品单价，从定价库获取
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * 商品单价，从定价库获取
     * @param unitPrice 商品单价，从定价库获取
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 商品销售价格，从定价系统获取
     * @return sale_price 商品销售价格，从定价系统获取
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     * 商品销售价格，从定价系统获取
     * @param salePrice 商品销售价格，从定价系统获取
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * 分摊到商品已付金额
     * @return paid_amount 分摊到商品已付金额
     */
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    /**
     * 分摊到商品已付金额
     * @param paidAmount 分摊到商品已付金额
     */
    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * (真实售价*数量-此商品b端总促销)/（订单总商品售价-b端订单总促销金额）
     * @return share_rate (真实售价*数量-此商品b端总促销)/（订单总商品售价-b端订单总促销金额）
     */
    public BigDecimal getShareRate() {
        return shareRate;
    }

    /**
     * (真实售价*数量-此商品b端总促销)/（订单总商品售价-b端订单总促销金额）
     * @param shareRate (真实售价*数量-此商品b端总促销)/（订单总商品售价-b端订单总促销金额）
     */
    public void setShareRate(BigDecimal shareRate) {
        this.shareRate = shareRate;
    }

    /**
     * 单项商品购买总价
     * @return total_amount 单项商品购买总价
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 单项商品购买总价
     * @param totalAmount 单项商品购买总价
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 库存id，从商品库获取
     * @return inventory_id 库存id，从商品库获取
     */
    public String getInventoryId() {
        return inventoryId;
    }

    /**
     * 库存id，从商品库获取
     * @param inventoryId 库存id，从商品库获取
     */
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId == null ? null : inventoryId.trim();
    }

    /**
     * 购买数量
     * @return quantity 购买数量
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * 购买数量
     * @param quantity 购买数量
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * 真实数量（= 总数量 - 已退数量）
     * @return real_quantity 真实数量（= 总数量 - 已退数量）
     */
    public BigDecimal getRealQuantity() {
        return realQuantity;
    }

    /**
     * 真实数量（= 总数量 - 已退数量）
     * @param realQuantity 真实数量（= 总数量 - 已退数量）
     */
    public void setRealQuantity(BigDecimal realQuantity) {
        this.realQuantity = realQuantity;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     * @return delete_flag 
     */
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 
     * @param deleteFlag 
     */
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 价签码(龙果提供)sku_id
     * @return signed_code 价签码(龙果提供)sku_id
     */
    public String getSignedCode() {
        return signedCode;
    }

    /**
     * 价签码(龙果提供)sku_id
     * @param signedCode 价签码(龙果提供)sku_id
     */
    public void setSignedCode(String signedCode) {
        this.signedCode = signedCode == null ? null : signedCode.trim();
    }

    /**
     * 型号（龙果）
     * @return model 型号（龙果）
     */
    public String getModel() {
        return model;
    }

    /**
     * 型号（龙果）
     * @param model 型号（龙果）
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 规格（龙果）没有就反斜杠
     * @return size 规格（龙果）没有就反斜杠
     */
    public String getSize() {
        return size;
    }

    /**
     * 规格（龙果）没有就反斜杠
     * @param size 规格（龙果）没有就反斜杠
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * 规格单位（龙果）
     * @return size_unit 规格单位（龙果）
     */
    public String getSizeUnit() {
        return sizeUnit;
    }

    /**
     * 规格单位（龙果）
     * @param sizeUnit 规格单位（龙果）
     */
    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit == null ? null : sizeUnit.trim();
    }

    /**
     * 折扣率
     * @return discount_rate 折扣率
     */
    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    /**
     * 折扣率
     * @param discountRate 折扣率
     */
    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * 1：明码实价，2：明码议价
     * @return is_blatantly 1：明码实价，2：明码议价
     */
    public Boolean getIsBlatantly() {
        return isBlatantly;
    }

    /**
     * 1：明码实价，2：明码议价
     * @param isBlatantly 1：明码实价，2：明码议价
     */
    public void setIsBlatantly(Boolean isBlatantly) {
        this.isBlatantly = isBlatantly;
    }

    /**
     * 系列编码，龙果提供
     * @return serial_code 系列编码，龙果提供
     */
    public String getSerialCode() {
        return serialCode;
    }

    /**
     * 系列编码，龙果提供
     * @param serialCode 系列编码，龙果提供
     */
    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode == null ? null : serialCode.trim();
    }

    /**
     * 系列名称，龙果提供
     * @return serial_name 系列名称，龙果提供
     */
    public String getSerialName() {
        return serialName;
    }

    /**
     * 系列名称，龙果提供
     * @param serialName 系列名称，龙果提供
     */
    public void setSerialName(String serialName) {
        this.serialName = serialName == null ? null : serialName.trim();
    }

    /**
     * 商品描述说明
     * @return description 商品描述说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 商品描述说明
     * @param description 商品描述说明
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 是否可退
     * @return can_refund 是否可退
     */
    public Boolean getCanRefund() {
        return canRefund;
    }

    /**
     * 是否可退
     * @param canRefund 是否可退
     */
    public void setCanRefund(Boolean canRefund) {
        this.canRefund = canRefund;
    }

    /**
     * 颜色
     * @return color 颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 颜色
     * @param color 颜色
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    /**
     * 颜色编码
     * @return color_rgb 颜色编码
     */
    public String getColorRgb() {
        return colorRgb;
    }

    /**
     * 颜色编码
     * @param colorRgb 颜色编码
     */
    public void setColorRgb(String colorRgb) {
        this.colorRgb = colorRgb == null ? null : colorRgb.trim();
    }

    /**
     * oms价签码
     * @return oms_price_tag_code oms价签码
     */
    public String getOmsPriceTagCode() {
        return omsPriceTagCode;
    }

    /**
     * oms价签码
     * @param omsPriceTagCode oms价签码
     */
    public void setOmsPriceTagCode(String omsPriceTagCode) {
        this.omsPriceTagCode = omsPriceTagCode == null ? null : omsPriceTagCode.trim();
    }

    /**
     * 商品sku
     * @return sku 商品sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * 商品sku
     * @param sku 商品sku
     */
    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    /**
     * 是否是服务费 0：不是，1：是
     * @return is_service 是否是服务费 0：不是，1：是
     */
    public Boolean getIsService() {
        return isService;
    }

    /**
     * 是否是服务费 0：不是，1：是
     * @param isService 是否是服务费 0：不是，1：是
     */
    public void setIsService(Boolean isService) {
        this.isService = isService;
    }

    /**
     * 原单商品id
     * @return reference_item_id 原单商品id
     */
    public Long getReferenceItemId() {
        return referenceItemId;
    }

    /**
     * 原单商品id
     * @param referenceItemId 原单商品id
     */
    public void setReferenceItemId(Long referenceItemId) {
        this.referenceItemId = referenceItemId;
    }

    /**
     * 评价状态
     * @return review_status 评价状态
     */
    public Integer getReviewStatus() {
        return reviewStatus;
    }

    /**
     * 评价状态
     * @param reviewStatus 评价状态
     */
    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    /**
     * 评价时间
     * @return review_date 评价时间
     */
    public Date getReviewDate() {
        return reviewDate;
    }

    /**
     * 评价时间
     * @param reviewDate 评价时间
     */
    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    /**
     * 对应评价系统的评价id
     * @return review_id 对应评价系统的评价id
     */
    public String getReviewId() {
        return reviewId;
    }

    /**
     * 对应评价系统的评价id
     * @param reviewId 对应评价系统的评价id
     */
    public void setReviewId(String reviewId) {
        this.reviewId = reviewId == null ? null : reviewId.trim();
    }

    /**
     * 商品类型：0店铺商品；1：自采商品
     * @return goods_type 商品类型：0店铺商品；1：自采商品
     */
    public Boolean getGoodsType() {
        return goodsType;
    }

    /**
     * 商品类型：0店铺商品；1：自采商品
     * @param goodsType 商品类型：0店铺商品；1：自采商品
     */
    public void setGoodsType(Boolean goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * 纯线上销售：0否；1：是
     * @return sale_channel 纯线上销售：0否；1：是
     */
    public Boolean getSaleChannel() {
        return saleChannel;
    }

    /**
     * 纯线上销售：0否；1：是
     * @param saleChannel 纯线上销售：0否；1：是
     */
    public void setSaleChannel(Boolean saleChannel) {
        this.saleChannel = saleChannel;
    }

    /**
     * 计价单位是否显示：0否；1：是
     * @return unit_is_show 计价单位是否显示：0否；1：是
     */
    public Boolean getUnitIsShow() {
        return unitIsShow;
    }

    /**
     * 计价单位是否显示：0否；1：是
     * @param unitIsShow 计价单位是否显示：0否；1：是
     */
    public void setUnitIsShow(Boolean unitIsShow) {
        this.unitIsShow = unitIsShow;
    }
}