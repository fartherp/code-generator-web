/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.service.general;

import com.github.fartherp.framework.common.util.MapUtils;
import com.github.fartherp.framework.core.kv.handler.DefaultKvHandler;
import com.github.fartherp.framework.core.kv.handler.KvHandler;
import com.github.fartherp.framework.core.kv.service.KvService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/1/29
 */
@Service("kvHandlerConfig")
public class KvHandlerConfig {
    @Resource(name = "kvService")
    KvService kvService;

    public void addHandler(KvHandler handler) {
        kvService.addHandler(handler);
    }

    @PostConstruct
    void setup() {
        addHandler(new GeneratorTypeHandler(1, "", "desc", "name", MapUtils.<String, Object>build().get(),
                DefaultKvHandler.ALL, false));
    }
}
