/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-12
 *
 */
package com.uxteam.reload.databasecreator.model;



import org.eclipse.draw2d.geometry.Point;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.uxteam.reload.databasecreator.ui.PointPropertySource;

/**
 * @author <b>��ѩ</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-12
 */
public class Table extends DBBase implements IPropertySource{
    
    public static final String ID_NAME = "__id__name";
    
    public static final String ID_LOCATION = "__id__point";
    
    protected Point location = new Point(0,0);
    
    protected String tableName = "unnamed";
    
    protected IPropertyDescriptor[] descriptors = new IPropertyDescriptor[]{
            new TextPropertyDescriptor(ID_NAME,"Name"),
            new PropertyDescriptor(ID_LOCATION,"Location")
    };
    /**
     * @return ���� location.
     */
    public Point getLocation() {
        return location;
    }
    /**
     * @param location ���� location 
     */
    public void setLocation(Point location) {
        Point old = this.location;
        this.location = location;
        this.fireFigurePropertyChange(old,this.location);
    }
    /**
     * @return ���� tableName.
     */
    public String getTableName() {
        return tableName;
    }
    /**
     * @param tableName ���� tableName 
     */
    public void setTableName(String tableName) {
        String old = this.tableName;
        this.tableName = tableName;
        this.fireFigurePropertyChange(old,this.tableName);
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
        return this.descriptors;
    }
    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
     */
    public Object getPropertyValue(Object id) {
        if(id.equals(ID_NAME)) return this.getTableName();
        if(id.equals(ID_LOCATION)) return new PointPropertySource(this.getLocation());
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
        if(id.equals(ID_NAME)) setTableName((String)value);
        if(id.equals(ID_LOCATION)) this.setLocation((Point)value);
    }
}
