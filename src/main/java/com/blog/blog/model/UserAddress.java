package com.blog.blog.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class UserAddress {
  private String zipCode;
  private String state;
  private String city;
  private String street;
}
