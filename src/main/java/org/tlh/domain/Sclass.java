package org.tlh.domain;

import lombok.Data;

@Data
public class Sclass {
    private Long id;
    private String name;
    private Long size;
    private String monitor;   //班长
    private String instructor;   //辅导员

}
