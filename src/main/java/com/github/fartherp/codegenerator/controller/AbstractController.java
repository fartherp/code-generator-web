/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/4/4
 */
public abstract class AbstractController {
    /**
     * 统一初始化页面
     * @return
     */
    @RequestMapping(value = "/{model}")
    public ModelAndView init(@PathVariable String model) {
        RequestMapping r = this.getClass().getAnnotation(RequestMapping.class);
        return new ModelAndView(r.value()[0] + "/" + model);
    }
}
