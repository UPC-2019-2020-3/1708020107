package com.zht.service;

import com.zht.domain.Traveller;

import java.util.List;

public interface iTravellerService {

    public List<Traveller> findAll() throws Exception;

    void save(Traveller traveller) throws Exception;

    void deleteTravellerById(int travellerId) throws Exception;
}
