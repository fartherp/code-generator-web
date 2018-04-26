/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.codegenerator.vo;

import com.github.fartherp.framework.database.mybatis.plugin.page.BaseVo;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/6/1.
 */
public class CodeVo extends BaseVo {
    /**
     * the database url
     */
    private String url;

    /**
     * the database user
     */
    private String user;

    /**
     * the database password
     */
    private String password;

    /**
     * the projectName
     */
    private String projectName;

    /**
     * the classpath
     */
    private String classpath;

    /**
     * the transaction type 1:XML,2:annotation
     */
    private Integer transactionType;

    private String transactionName;

    private Integer isColumnNameDelimited;

    private String tableNames;

    private String generatorType;

    /**
     * Getter for property 'url'.
     *
     * @return Value for property 'url'.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter for property 'url'.
     *
     * @param url Value to set for property 'url'.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter for property 'user'.
     *
     * @return Value for property 'user'.
     */
    public String getUser() {
        return user;
    }

    /**
     * Setter for property 'user'.
     *
     * @param user Value to set for property 'user'.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Getter for property 'password'.
     *
     * @return Value for property 'password'.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for property 'password'.
     *
     * @param password Value to set for property 'password'.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for property 'projectName'.
     *
     * @return Value for property 'projectName'.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Setter for property 'projectName'.
     *
     * @param projectName Value to set for property 'projectName'.
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Getter for property 'classpath'.
     *
     * @return Value for property 'classpath'.
     */
    public String getClasspath() {
        return classpath;
    }

    /**
     * Setter for property 'classpath'.
     *
     * @param classpath Value to set for property 'classpath'.
     */
    public void setClasspath(String classpath) {
        this.classpath = classpath;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public Integer getIsColumnNameDelimited() {
        return isColumnNameDelimited;
    }

    public void setIsColumnNameDelimited(Integer isColumnNameDelimited) {
        this.isColumnNameDelimited = isColumnNameDelimited;
    }

    public String getTableNames() {
        return tableNames;
    }

    public void setTableNames(String tableNames) {
        this.tableNames = tableNames;
    }

    public String getGeneratorType() {
        return generatorType;
    }

    public void setGeneratorType(String generatorType) {
        this.generatorType = generatorType;
    }
}
