tx_attachment
tx_cancel_payment_log
tx_config
tx_customer_service
tx_customer_service_status_version
tx_item_attributes
tx_item_commission
tx_item_payment
tx_item_promotion
tx_operation_history
tx_order
tx_order_addition
tx_order_deliver_info
tx_order_distribute
tx_order_extend
tx_order_item
tx_order_reviewed
tx_order_status_version
tx_order_worker
tx_parking_fees
tx_pay_error_log
tx_payment_line
tx_payment_line_detail
tx_promotion
tx_promotion_job
tx_rabbitmq_push_log
tx_refund_bill
tx_return_detail
tx_return_info
tx_serial_number






ALTER table  tx_attachment                                               RENAME                                      tx_attachment_0                           ;
ALTER table  tx_cancel_payment_log                                               RENAME                              tx_cancel_payment_log_0                                   ;
ALTER table  tx_config                                               RENAME                                          tx_config_0                       ;
ALTER table  tx_customer_service                                               RENAME                                tx_customer_service_0                                 ;
ALTER table  tx_customer_service_status_version                                               RENAME                 tx_customer_service_status_version_0                                                ;
ALTER table  tx_item_attributes                                               RENAME                                 tx_item_attributes_0                                ;
ALTER table  tx_item_commission                                               RENAME                                 tx_item_commission_0                                ;
ALTER table  tx_item_payment                                               RENAME                                    tx_item_payment_0                             ;
ALTER table  tx_item_promotion                                               RENAME                                  tx_item_promotion_0                               ;
ALTER table  tx_operation_history                                               RENAME                               tx_operation_history_0                                  ;
ALTER table  tx_order                                               RENAME                                           tx_order_0                      ;
ALTER table  tx_order_addition                                               RENAME                                  tx_order_addition_0                               ;
ALTER table  tx_order_deliver_info                                               RENAME                              tx_order_deliver_info_0                                   ;
ALTER table  tx_order_distribute                                               RENAME                                tx_order_distribute_0                                 ;
ALTER table  tx_order_extend                                               RENAME                                    tx_order_extend_0                             ;
ALTER table  tx_order_item                                               RENAME                                      tx_order_item_0                           ;
ALTER table  tx_order_reviewed                                               RENAME                                  tx_order_reviewed_0                               ;
ALTER table  tx_order_status_version                                               RENAME                            tx_order_status_version_0                                     ;
ALTER table  tx_order_worker                                               RENAME                                    tx_order_worker_0                             ;
ALTER table  tx_parking_fees                                               RENAME                                    tx_parking_fees_0                             ;
ALTER table  tx_pay_error_log                                               RENAME                                   tx_pay_error_log_0                              ;
ALTER table  tx_payment_line                                               RENAME                                    tx_payment_line_0                             ;
ALTER table  tx_payment_line_detail                                               RENAME                             tx_payment_line_detail_0                                    ;
ALTER table  tx_promotion                                               RENAME                                       tx_promotion_0                          ;
ALTER table  tx_promotion_job                                               RENAME                                   tx_promotion_job_0                              ;
ALTER table  tx_rabbitmq_push_log                                               RENAME                               tx_rabbitmq_push_log_0                                  ;
ALTER table  tx_refund_bill                                               RENAME                                     tx_refund_bill_0                            ;
ALTER table  tx_return_detail                                               RENAME                                   tx_return_detail_0                              ;
ALTER table  tx_return_info                                               RENAME                                     tx_return_info_0                            ;
ALTER table  tx_serial_number                                               RENAME                                   tx_serial_number_0                              ;












ALTER table  tx_attachment                                               RENAME                                      tx_attachment_1                           ;
ALTER table  tx_cancel_payment_log                                               RENAME                              tx_cancel_payment_log_1                                   ;
ALTER table  tx_config                                               RENAME                                          tx_config_1                       ;
ALTER table  tx_customer_service                                               RENAME                                tx_customer_service_1                                 ;
ALTER table  tx_customer_service_status_version                                               RENAME                 tx_customer_service_status_version_1                                                ;
ALTER table  tx_item_attributes                                               RENAME                                 tx_item_attributes_1                                ;
ALTER table  tx_item_commission                                               RENAME                                 tx_item_commission_1                                ;
ALTER table  tx_item_payment                                               RENAME                                    tx_item_payment_1                             ;
ALTER table  tx_item_promotion                                               RENAME                                  tx_item_promotion_1                               ;
ALTER table  tx_operation_history                                               RENAME                               tx_operation_history_1                                  ;
ALTER table  tx_order                                               RENAME                                           tx_order_1                      ;
ALTER table  tx_order_addition                                               RENAME                                  tx_order_addition_1                               ;
ALTER table  tx_order_deliver_info                                               RENAME                              tx_order_deliver_info_1                                   ;
ALTER table  tx_order_distribute                                               RENAME                                tx_order_distribute_1                                 ;
ALTER table  tx_order_extend                                               RENAME                                    tx_order_extend_1                             ;
ALTER table  tx_order_item                                               RENAME                                      tx_order_item_1                           ;
ALTER table  tx_order_reviewed                                               RENAME                                  tx_order_reviewed_1                               ;
ALTER table  tx_order_status_version                                               RENAME                            tx_order_status_version_1                                     ;
ALTER table  tx_order_worker                                               RENAME                                    tx_order_worker_1                             ;
ALTER table  tx_parking_fees                                               RENAME                                    tx_parking_fees_1                             ;
ALTER table  tx_pay_error_log                                               RENAME                                   tx_pay_error_log_1                              ;
ALTER table  tx_payment_line                                               RENAME                                    tx_payment_line_1                             ;
ALTER table  tx_payment_line_detail                                               RENAME                             tx_payment_line_detail_1                                    ;
ALTER table  tx_promotion                                               RENAME                                       tx_promotion_1                          ;
ALTER table  tx_promotion_job                                               RENAME                                   tx_promotion_job_1                              ;
ALTER table  tx_rabbitmq_push_log                                               RENAME                               tx_rabbitmq_push_log_1                                  ;
ALTER table  tx_refund_bill                                               RENAME                                     tx_refund_bill_1                            ;
ALTER table  tx_return_detail                                               RENAME                                   tx_return_detail_1                              ;
ALTER table  tx_return_info                                               RENAME                                     tx_return_info_1                            ;
ALTER table  tx_serial_number                                               RENAME                                   tx_serial_number_1                              ;

























ALTER table  tx_customer_service    RENAME      tx_customer_service_0         ;
ALTER table  tx_item_payment    RENAME          tx_item_payment_0      ;
ALTER table  tx_item_promotion    RENAME        tx_item_promotion_0       ;
ALTER table  tx_operation_history    RENAME     tx_operation_history_0          ;
ALTER table  tx_order    RENAME                 tx_order_0       ;
ALTER table  tx_order_addition    RENAME        tx_order_addition_0       ;
ALTER table  tx_order_extend    RENAME          tx_order_extend_0     ;
ALTER table  tx_order_item    RENAME            tx_order_item_0   ;
ALTER table  tx_order_reviewed    RENAME        tx_order_reviewed_0       ;
ALTER table  tx_order_status_version    RENAME     tx_order_status_version_0          ;
ALTER table  tx_order_worker    RENAME          tx_order_worker_0     ;
ALTER table  tx_payment_line    RENAME          tx_payment_line_0     ;
ALTER table  tx_payment_line_detail    RENAME     tx_payment_line_detail_0          ;
ALTER table  tx_promotion    RENAME             tx_promotion_0  ;
ALTER table  tx_promotion_job    RENAME         tx_promotion_job_0      ;
ALTER table  tx_refund_bill    RENAME           tx_refund_bill_0    ;
ALTER table  tx_attachment    RENAME            tx_attachment_0   ;
















ALTER table  tx_customer_service    RENAME      tx_customer_service_1         ;
ALTER table  tx_item_payment    RENAME          tx_item_payment_1      ;
ALTER table  tx_item_promotion    RENAME        tx_item_promotion_1       ;
ALTER table  tx_operation_history    RENAME     tx_operation_history_1          ;
ALTER table  tx_order    RENAME                 tx_order_1       ;
ALTER table  tx_order_addition    RENAME        tx_order_addition_1       ;
ALTER table  tx_order_extend    RENAME          tx_order_extend_1     ;
ALTER table  tx_order_item    RENAME            tx_order_item_1   ;
ALTER table  tx_order_reviewed    RENAME        tx_order_reviewed_1      ;
ALTER table  tx_order_status_version    RENAME     tx_order_status_version_1          ;
ALTER table  tx_order_worker    RENAME          tx_order_worker_1     ;
ALTER table  tx_payment_line    RENAME          tx_payment_line_1     ;
ALTER table  tx_payment_line_detail    RENAME     tx_payment_line_detail_1          ;
ALTER table  tx_promotion    RENAME             tx_promotion_1  ;
ALTER table  tx_promotion_job    RENAME         tx_promotion_job_1      ;
ALTER table  tx_refund_bill    RENAME           tx_refund_bill_1    ;
ALTER table  tx_attachment    RENAME            tx_attachment_1   ;