package com.github.dericksm.userservicedto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private BigDecimal balance;
}
