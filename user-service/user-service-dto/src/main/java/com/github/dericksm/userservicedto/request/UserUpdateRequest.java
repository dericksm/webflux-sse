package com.github.dericksm.userservicedto.request;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {

    @NotBlank
    private String name;
}
