package com.zht.service.impl;

import com.zht.dao.iGuideDao;
import com.zht.dao.iProductDao;
import com.zht.domain.Guide;
import com.zht.service.iGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuideServiceimpl implements iGuideService {

    @Autowired
    private iGuideDao guideDao;

    @Override
    public List<Guide> findAll() throws Exception {
        return guideDao.findAll();
    }
}
