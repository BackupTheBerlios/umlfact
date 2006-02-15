/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-8-13
 *
 */
package com.uxteam.reload.databasecreator.model.command;


import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;

import com.uxteam.reload.databasecreator.model.Table;

/**
 * @author <b>彭雪</b>
 *
 * 描述 ： 
 * 创建时间：2005-8-13
 */
public class TableMoveCommand extends Command {

    private ChangeBoundsRequest request;
    
    private Table model;
    /* (non-Javadoc)
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute() {
      Point old = getModel().getLocation();
      int x = request.getMoveDelta().x;
      int y = request.getMoveDelta().y;
      
      getModel().setLocation(new Point(old.x+x,old.y+y));
    }
 
    /**
     * @return 返回 request.
     */
    public ChangeBoundsRequest getRequest() {
        return request;
    }
    /**
     * @param request 设置 request 
     */
    public void setRequest(ChangeBoundsRequest request) {
        this.request = request;
    }
    /**
     * @return 返回 model.
     */
    public Table getModel() {
        return model;
    }
    /**
     * @param model 设置 model 
     */
    public void setModel(Table model) {
        this.model = model;
    }
}
