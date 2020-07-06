package com.zht.service.impl;

import com.zht.dao.iProductDao;
import com.zht.dao.iTravellerDao;
import com.zht.domain.Traveller;
import com.zht.service.iProductService;
import com.zht.service.iTravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class TravellerServiceimpl implements iTravellerService {

    @Autowired
    private iTravellerDao travellerDao;

    @Override
    public List<Traveller> findAll() throws Exception {
        return travellerDao.findAll();
    }

    @Override
    public void save(Traveller traveller) throws Exception {
        travellerDao.save(traveller);
    }

    @Override
    public void deleteTravellerById(int travellerId) throws Exception {
        travellerDao.deleteTravellerById(travellerId);
    }
}
