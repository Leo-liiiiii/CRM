package com.ujiuye.auth.service;

import com.ujiuye.auth.bean.Sources;

/**
 * @author 朱峰
 * @create 2020-07-13 10:54
 */
public interface SourcesService {
    Sources getRootSources();

    boolean addSources(Sources sources);
}
