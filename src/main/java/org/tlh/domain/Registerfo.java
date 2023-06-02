package org.tlh.domain;

import lombok.Data;

@Data
public class Registerfo {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String salt;
    private String password;
    private Integer age;
    private Integer state;
    private Long department_id;
    private Logininfo logininfo;
    private Long logininfo_id;
    private Shop shop;
    private  Long shop_id;
}
