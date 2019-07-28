package com.leaf.Care.dto.common;

/**
 * @author : rusiru on 7/28/19.
 */
public class JwtResponseDTO {

    private final String jwttoken;

    public JwtResponseDTO(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getJwttoken() {
        return jwttoken;
    }
}
