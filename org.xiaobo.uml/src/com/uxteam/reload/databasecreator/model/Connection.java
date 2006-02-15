/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-1
 *
 */
package com.uxteam.reload.databasecreator.model;

/**
 * @author <b>��ѩ</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-1
 */
public class Connection extends DBBase {
    private DBBase source;
    private DBBase target;
    
    public Connection(DBBase source,DBBase target){
        this.source = source;
        this.target = target;
        ((Column)source).addOut(this);
        ((Column) target).addIncome(this);
    }
    /**
     * @return ���� out.
     */
    public DBBase getSource() {
        return source;
    }
    /**
     * @param source ���� out 
     */
    public void setSource(DBBase source) {
        this.source = source;
    }
    /**
     * @return ���� in.
     */
    public DBBase getTarget() {
        return target;
    }
    /**
     * @param target ���� in 
     */
    public void setTarget(DBBase target) {
        this.target = target;
    }
}
