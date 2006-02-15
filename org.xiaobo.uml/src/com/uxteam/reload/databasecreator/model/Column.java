/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-8-12
 *
 */
package com.uxteam.reload.databasecreator.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

/**
 * @author <b>彭雪</b>
 *
 * 描述 ： 
 * 创建时间：2005-8-12
 */
public class Column extends DBBase implements IPropertySource{
    public static final String ID_NAME = "__id__columnname";
    
    public static final String ID_TYPE = "__id__type";
    
    public static final String ID_NULLABLE = "__id__type";
    
    public static final String ID_ISPK = "__id__ispk";
    
    protected List outs = new ArrayList();
    
    protected List incomes = new ArrayList();
     /** 字段名 */
     protected String columnName = "unnamed";
     
     /** 是否能为空 */
     protected boolean nullable = true;
     
     /** 字段类型 */
     protected String columnType = "VRCHARS";
     
     /** 字段长度 */
     protected int columnSize = 0;
     
     protected IPropertyDescriptor[] descriptors = new IPropertyDescriptor[]{
             new TextPropertyDescriptor(ID_NAME,"Name")
     };
     
    /**
     * @return 返回 columnName.
     */
    public String getColumnName() {
        return columnName;
    }
    /**
     * @param columnName 设置 columnName 
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    /**
     * @return 返回 nullable.
     */
    public boolean isNullable() {
        return nullable;
    }
    /**
     * @param nullable 设置 nullable 
     */
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }
    /**
     * @return 返回 columnType.
     */
    public String getColumnType() {
        return columnType;
    }
    /**
     * @param columnType 设置 columnType 
     */
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    /**
     * @return 返回 columnSize.
     */
    public int getColumnSize() {
        return columnSize;
    }
    /**
     * @param columnSize 设置 columnSize 
     */
    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }
    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
     */
    public Object getEditableValue() {
        return null;
    }
    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
     */
    public IPropertyDescriptor[] getPropertyDescriptors() {
        return descriptors;
    }
    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
     */
    public Object getPropertyValue(Object id) {
       if(id.equals(ID_NAME)) return this.getColumnName();
        return null;
    }
    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(java.lang.Object)
     */
    public boolean isPropertySet(Object id) {
        return true;
    }
    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(java.lang.Object)
     */
    public void resetPropertyValue(Object id) {
    }
    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object, java.lang.Object)
     */
    public void setPropertyValue(Object id, Object value) {
        if(id.equals(ID_NAME)) setColumnName((String)value);
    }
    
    
    public void fireConnectionChange(String type){
        support.firePropertyChange(type,new Object(),null);
    }
    /**
     * @return 返回 outs.
     */
    public List getOuts() {
        return outs;
    }
    /**
     * @param outs 设置 outs 
     */
    public void setOuts(List outs) {
        this.outs = outs;
    }
    /**
     * @return 返回 comins.
     */
    public List getIncomes() {
        return incomes;
    }
    /**
     * @param incomes 设置 comins 
     */
    public void setIncomes(List incomes) {
        this.incomes = incomes;
    }
    
    public void addOut(Connection out){
        getOuts().add(out);
        this.fireConnectionChange(PRO_CONNECTION_OUT);
    }
    
    public void addIncome(Connection in){
        getIncomes().add(in);
        this.fireConnectionChange(PRO_CONNECTION_IN);
    }
}
