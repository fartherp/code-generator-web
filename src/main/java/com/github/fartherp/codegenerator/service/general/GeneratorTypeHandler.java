/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.service.general;

import com.github.fartherp.codegenerator.api.Generator;
import com.github.fartherp.codegenerator.factory.GeneratorFactory;
import com.github.fartherp.framework.common.extension.ExtensionLoader;
import com.github.fartherp.framework.core.kv.handler.DefaultKvHandler;
import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/9/2
 */
public class GeneratorTypeHandler extends DefaultKvHandler {

    public GeneratorTypeHandler(Integer name, String tableName, String keyField, String valueField,
                                Map<String, Object> extraFields, int sqFlag, boolean daoExecuteFlag) {
        super(name, tableName, keyField, valueField, extraFields, sqFlag, daoExecuteFlag, 2);
    }

    protected void setupTemplates() {
        this.fn = new Function<Map<String, Object>, List<Map<String, Object>>>() {
            public List<Map<String, Object>> apply(Map<String, Object> input) {
                List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
                Set<String> set = ExtensionLoader.getExtensionLoader(Generator.class, GeneratorFactory.PATH).getSupportedExtensions();
                for (String s : set) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("name", s);
                    map.put("desc", s);
                    result.add(map);
                }
                return result;
            }
        };
    }
}
