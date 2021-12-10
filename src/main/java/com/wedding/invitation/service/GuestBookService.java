package com.wedding.invitation.service;

import com.wedding.invitation.domain.GuestBook;
import com.wedding.invitation.repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;

    /* 축하메시지 저장 */
    @Transactional
    public void MsgSave(GuestBook guestBook) {
        guestBookRepository.save(guestBook);
    }

    /* 축하메시지 리스트 조회 */
    public List<GuestBook> findGuestBookList() {
        return guestBookRepository.findAll();
    }

    /* 축하메시지 수정 위한 단건 조회 */
    public GuestBook findGuestBook(Long guestBookId) {
        return guestBookRepository.findOne(guestBookId);
    }
}
