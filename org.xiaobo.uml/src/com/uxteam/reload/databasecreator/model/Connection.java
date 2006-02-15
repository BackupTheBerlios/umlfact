/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-8-1
 *
 */
package com.uxteam.reload.databasecreator.model;

/**
 * @author <b>彭雪</b>
 *
 * 描述 ： 
 * 创建时间：2005-8-1
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
     * @return 返回 out.
     */
    public DBBase getSource() {
        return source;
    }
    /**
     * @param source 设置 out 
     */
    public void setSource(DBBase source) {
        this.source = source;
    }
    /**
     * @return 返回 in.
     */
    public DBBase getTarget() {
        return target;
    }
    /**
     * @param target 设置 in 
     */
    public void setTarget(DBBase target) {
        this.target = target;
    }
}
