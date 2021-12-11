package com.wedding.invitation.dto;

import com.wedding.invitation.domain.GuestBook;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class GuestBookDTO {
    private String cmtName;
    private String cmtPwd;
    private String cmtMsg;
    private String createdDate;

    @Builder
    public GuestBookDTO(GuestBook guestBook) {
        this.cmtName = guestBook.getCmtName();
        this.cmtPwd = guestBook.getCmtPwd();
        this.cmtMsg = guestBook.getCmtMsg();
        this.createdDate = guestBook.getCreatedDate().format(DateTimeFormatter.ISO_DATE);
    }
}
