package com.springboot.hello.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.net.InetAddress;

@Data
@NoArgsConstructor
public class Server implements Serializable {
    /**
     * ip
     */
    private InetAddress ip;

    public Server(InetAddress ip) {
        this.ip = ip;
    }

}
