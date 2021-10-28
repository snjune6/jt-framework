package com.link.jk.jkframework.mapper;

import com.link.jk.jkframework.dto.SiteDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SiteMapper {

	SiteDto selectSiteList();

	void updateSite(SiteDto siteDto);
}
