package org.tlh.domain;

import lombok.Data;

@Data
public class Course {
    private Long id;
    private String sn;
    private String name;
    private String teacher;
    private Integer classification;
    private Integer state;
}