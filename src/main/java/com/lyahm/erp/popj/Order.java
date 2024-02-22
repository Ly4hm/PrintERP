package com.lyahm.erp.popj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
  private long orderId;
  private String company;
  private String contactPerson;
  private String customerContractNumber;
  private LocalDateTime orderDate;
  private LocalDateTime latestDeliveryDate;
  private String productName;
  private String deliveryInfo;
  private String filePath;
  private String notes;
  private double sum;
}
