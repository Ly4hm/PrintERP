package com.lyahm.erp.popj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Suborder {
  private long suborderId;
  private long orderId;
  private long paperType;
  private String specification;
  private long craft;
  private long quantity;
  private double unitPrice;
  private double amount;
  private long orderStatus;
}

// TODO: 枚举类型维护