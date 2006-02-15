/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
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
 * @author <b>��ѩ</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-12
 */
public class Column extends DBBase implements IPropertySource{
    public static final String ID_NAME = "__id__columnname";
    
    public static final String ID_TYPE = "__id__type";
    
    public static final String ID_NULLABLE = "__id__type";
    
    public static final String ID_ISPK = "__id__ispk";
    
    protected List outs = new ArrayList();
    
    protected List incomes = new ArrayList();
     /** �ֶ��� */
     protected String columnName = "unnamed";
     
     /** �Ƿ���Ϊ�� */
     protected boolean nullable = true;
     
     /** �ֶ����� */
     protected String columnType = "VRCHARS";
     
     /** �ֶγ��� */
     protected int columnSize = 0;
     
     protected IPropertyDescriptor[] descriptors = new IPropertyDescriptor[]{
             new TextPropertyDescriptor(ID_NAME,"Name")
     };
     
    /**
     * @return ���� columnName.
     */
    public String getColumnName() {
        return columnName;
    }
    /**
     * @param columnName ���� columnName 
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    /**
     * @return ���� nullable.
     */
    public boolean isNullable() {
        return nullable;
    }
    /**
     * @param nullable ���� nullable 
     */
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }
    /**
     * @return ���� columnType.
     */
    public String getColumnType() {
        return columnType;
    }
    /**
     * @param columnType ���� columnType 
     */
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    /**
     * @return ���� columnSize.
     */
    public int getColumnSize() {
        return columnSize;
    }
    /**
     * @param columnSize ���� columnSize 
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
     * @return ���� outs.
     */
    public List getOuts() {
        return outs;
    }
    /**
     * @param outs ���� outs 
     */
    public void setOuts(List outs) {
        this.outs = outs;
    }
    /**
     * @return ���� comins.
     */
    public List getIncomes() {
        return incomes;
    }
    /**
     * @param incomes ���� comins 
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
