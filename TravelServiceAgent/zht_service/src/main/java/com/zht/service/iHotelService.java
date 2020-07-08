package com.zht.service;

import com.zht.domain.Hotel;

import java.util.List;

public interface iHotelService {

    List<Hotel> findAll() throws Exception;

}
