package com.wedding.invitation.controller;

import com.wedding.invitation.domain.GuestBook;
import com.wedding.invitation.dto.GuestBookDTO;
import com.wedding.invitation.service.GuestBookService;
import com.wedding.invitation.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final GuestBookService guestBookService;
    private final HomeService homeService;

    @GetMapping("/")
    public String Home(Model model) {
        List<GuestBookDTO> MsgList = guestBookService.findGuestBookList();
        if (!MsgList.isEmpty()) model.addAttribute("MsgList", MsgList);

        List<String> photoList = homeService.PhotoList();
        model.addAttribute("PhotoList", photoList);

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

    @GetMapping("/photoCard/{photoNum}")
    public String PhotoCard(@PathVariable int photoNum, Model model) {
        model.addAttribute("photoNum", photoNum);

        List<String> photoList = homeService.PhotoList();
        model.addAttribute("PhotoList", photoList);
        return "photoBox";
    }

    @PostMapping("/pwdCheck/{id}")
    @ResponseBody
    public Boolean MessagePwdCheck(@RequestBody String pwd, @PathVariable Long id) {
        GuestBook Message = guestBookService.findGuestBook(id);
        if(Message.getCmtPwd().equals(pwd))
            return true;
        else
            return false;
    }

    @GetMapping("/msgDelete/{id}/{pwd}")
    public String MessageDelete(@PathVariable Long id, @PathVariable String pwd) {
        GuestBook Message = guestBookService.findGuestBook(id);
        guestBookService.MsgDelete(Message);
        return "redirect:/";
    }
}
