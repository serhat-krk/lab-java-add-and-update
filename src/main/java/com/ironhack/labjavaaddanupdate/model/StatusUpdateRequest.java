package com.ironhack.labjavaaddanupdate.model;

import com.ironhack.labjavaaddanupdate.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusUpdateRequest {
    private StatusEnum status;
}
