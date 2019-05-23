package com.michal.mywykop.dao;

import java.util.List;

import com.michal.mywykop.model.Discovery;

public interface DiscoveryDao extends GenericDAO<Discovery, Long>{

    List<Discovery> getAll();

}