package net.csjava.logistics.DTO;

import lombok.Data;

@Data
public class MailingQueryDTO {
    private String keyword;
    private Integer page;
    private Integer pagesize;
    private Integer mailType;
}
