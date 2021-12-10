package com.wedding.invitation.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuestBookDTO {
    private String cmtName;
    private String cmtPwd;
    private String cmtMsg;

    @Builder
    public GuestBookDTO(String cmtName, String cmtPwd, String cmtMsg) {
        this.cmtName = cmtName;
        this.cmtPwd = cmtPwd;
        this.cmtMsg = cmtMsg;
    }
}
