package com.webapp.travelAgency.externalapi.model.myip;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyIp {
    private String ip;
    private String country;
    private String cc;

    @Override
    public String toString() {
        return "MyIp{" +
                "ip='" + ip + '\'' +
                ", country='" + country + '\'' +
                ", cc='" + cc + '\'' +
                '}';
    }
}
