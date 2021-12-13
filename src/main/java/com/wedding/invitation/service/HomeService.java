package com.wedding.invitation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    public List<String> PhotoList () {
        List<String> photoArr = new ArrayList<>();
        String fileName = "";

        for(int i=1; i<7; i++){
            fileName = "photo_" + i + ".jpg";
            photoArr.add(fileName);
        }

        return photoArr;
    }
}
