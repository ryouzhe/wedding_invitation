package com.wedding.invitation.controller;

import com.wedding.invitation.domain.GuestBook;
import com.wedding.invitation.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final GuestBookService guestBookService;

    @GetMapping("/")
    public String Home(Model model) {
        List<GuestBook> MsgList = guestBookService.findGuestBookList();
        if(!MsgList.isEmpty()) model.addAttribute("MsgList", MsgList);

        return "index";
    }

    @PostMapping("/msgSave")
    public String MessageSave(GuestBook guestBook) {
        GuestBook Message = new GuestBook();
        Message.setCmtName(guestBook.getCmtName());
        Message.setCmtPwd(guestBook.getCmtPwd());
        Message.setCmtMsg(guestBook.getCmtMsg());

        guestBookService.MsgSave(Message);
        return "redirect:/";
    }
}
