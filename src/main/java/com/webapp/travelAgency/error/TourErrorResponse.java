package com.webapp.travelAgency.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourErrorResponse {

    private int idStatus;
    private String message;
    private Long timestamp;
}
