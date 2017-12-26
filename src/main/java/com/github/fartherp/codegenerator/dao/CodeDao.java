/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.dao;

import com.github.fartherp.codegenerator.vo.CodeVo;
import com.github.fartherp.codegenerator.vo.TableName;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/3/27.
 */
public interface CodeDao {

    /**
     * 查询表名
     * @param codeVo codeVo
     * @return 表名称MAP列表
     */
    List<TableName> selectTableName(CodeVo codeVo);
}
