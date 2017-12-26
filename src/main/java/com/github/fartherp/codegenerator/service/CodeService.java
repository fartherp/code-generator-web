/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.service;

import com.github.fartherp.codegenerator.vo.CodeVo;
import com.github.fartherp.codegenerator.vo.TableName;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/3/27.
 */
public interface CodeService {

    /**
     * Select table name.
     *
     * @param codeVo codeVo
     * @return the map of tableName
     */
    List<TableName> selectTableName(CodeVo codeVo);
}
