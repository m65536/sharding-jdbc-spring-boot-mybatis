package com.mo.test.entity;

public class OrderItem {
    /**
     * 
     */
    private Long orderItemId;

    /**
     * 
     */
    private Long orderId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     * @return order_item_id 
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * 
     * @param orderItemId 
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * 
     * @return order_id 
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 
     * @param orderId 
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 
     * @return user_id 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}