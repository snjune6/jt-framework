package com.link.jk.jkframework.service;

import com.link.jk.jkframework.dto.SiteDto;
import com.link.jk.jkframework.mapper.SiteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SiteService {

    @Resource
    private SiteMapper siteMapper;

    public SiteDto selectSiteList() {
        return siteMapper.selectSiteList();
    }

	public void updateSite(SiteDto siteDto) {
		siteMapper.updateSite(siteDto);
	}
}
