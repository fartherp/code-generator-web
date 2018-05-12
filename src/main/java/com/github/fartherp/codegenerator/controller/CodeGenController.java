/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.controller;

import com.github.fartherp.codegenerator.api.Generator;
import com.github.fartherp.codegenerator.config.CodeGenContext;
import com.github.fartherp.codegenerator.factory.GeneratorFactory;
import com.github.fartherp.codegenerator.service.CodeService;
import com.github.fartherp.codegenerator.vo.CodeVo;
import com.github.fartherp.codegenerator.vo.TableName;
import com.github.fartherp.framework.compress.CommonCompress;
import com.github.fartherp.framework.compress.zip.ZIP;
import com.github.fartherp.framework.core.util.JsonResp;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/6/1.
 */
@Controller
@RequestMapping(value = "/code")
public class CodeGenController extends AbstractController {

    @Resource
    CodeService codeService;

    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value = "/selectTableName")
    public String selectTableName(CodeVo vo) {
        if (StringUtils.isBlank(vo.getUrl())) {
            vo.setRows(new ArrayList());
            return JsonResp.asData(vo).toJson();
        }
        List<TableName> list = codeService.selectTableName(vo);
        vo.setRows(list);
        return JsonResp.asData(vo).toJson();
    }

    @RequestMapping(value = "/download")
    public void download(CodeVo codeVo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        CodeGenContext context = new CodeGenContext();
        BeanUtils.copyProperties(codeVo, context);

        context.setDatabaseByUrl(codeVo.getUrl());
        String [] tableNames = codeVo.getTableNames().split(",");
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, tableNames);
        context.setTableNameList(list);
        Generator generator = GeneratorFactory.getGenerator(context);
        generator.generate();

        CommonCompress compress = new ZIP();
        String fileName;
        if (1 == context.getIfGenProject()) {
            fileName = "代码";
        } else {
            fileName = "项目";
        }
        compress.response(request, response, fileName);
        compress.source(context.getOut());
        compress.compress();
        FileUtils.deleteDirectory(new File(context.getOut()));
    }
}
