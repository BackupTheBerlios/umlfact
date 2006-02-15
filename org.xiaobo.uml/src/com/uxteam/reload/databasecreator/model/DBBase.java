/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-12
 *
 */
package com.uxteam.reload.databasecreator.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author <b>Dart</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-12
 */
public class DBBase {
    
    public static final String PRO_FIGURE = "__figure__property";
    
    public static final String PRO_CHILD = "__child__property";
    
    public static final String PRO_CONNECTION_IN = "__connection__in";
    
    public static final String PRO_CONNECTION_OUT = "__connection__out";
    
     protected PropertyChangeSupport support = new PropertyChangeSupport(this);
     protected DBBase parent;
     protected List children;
    /**
     * @return ���� parent.
     */
    public DBBase getParent() {
        return parent;
    }
    /**
     * @param parent ���� parent 
     */
    public void setParent(DBBase parent) {
        this.parent = parent;
    }
    /**
     * @return ���� children.
     */
    public List getChildren() {
        if(children == null) children = new ArrayList();
        return children;
    }
    /**
     * @param children ���� children 
     */
    public void setChildren(List children) {
        this.children = children;
    }
    
    public void addChild(DBBase child){
       addChild(-1,child);
    }
    
    public void addChild(int index , DBBase child){
        if(index == -1){
        getChildren().add(child);
        }else{
            getChildren().add(index,child);
        }
        child.setParent(this);
        this.fireChildenChange(child);
    }
    
    public void removeChild(DBBase child){
        child.setParent(null);
        getChildren().remove(child);
        this.fireChildenChange(child);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener l){
        support.addPropertyChangeListener(l);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener l){
        support.removePropertyChangeListener(l);
    }
    
    public void fireFigurePropertyChange(Object old,Object now){
        support.firePropertyChange(PRO_FIGURE,old,now);
    }
    
    public void fireChildenChange(DBBase child){
        support.firePropertyChange(PRO_CHILD,null,child);
    }
}
