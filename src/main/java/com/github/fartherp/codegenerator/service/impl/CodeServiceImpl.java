/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.service.impl;

import com.github.fartherp.codegenerator.dao.CodeDao;
import com.github.fartherp.codegenerator.service.CodeService;
import com.github.fartherp.codegenerator.vo.CodeVo;
import com.github.fartherp.codegenerator.vo.TableName;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/3/27.
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {

    @Resource(name = "codeDao")
    private CodeDao codeDao;

    public List<TableName> selectTableName(CodeVo codeVo) {
        return codeDao.selectTableName(codeVo);
    }
}
