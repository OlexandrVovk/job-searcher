package com.webapp.store.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestDto {
    private String jobTitle;
    private String url;
    private String company;
}
