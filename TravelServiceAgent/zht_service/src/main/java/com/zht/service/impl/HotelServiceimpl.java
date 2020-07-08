package com.zht.service.impl;

import com.zht.dao.iHotelDao;
import com.zht.domain.Hotel;
import com.zht.service.iHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceimpl implements iHotelService {

    @Autowired
    private iHotelDao hotelDao;

    @Override
    public List<Hotel> findAll() throws Exception {
        return hotelDao.findAll();
    }
}
