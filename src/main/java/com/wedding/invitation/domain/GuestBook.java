package com.wedding.invitation.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class GuestBook extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 10, nullable = false)
    private String cmtName;
    @Column(length = 16, nullable = false)
    private String cmtPwd;
    @Column(length = 300, nullable = false)
    private String cmtMsg;

}
