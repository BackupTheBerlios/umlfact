/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-13
 *
 */
package com.uxteam.reload.databasecreator.model.command;


import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;

import com.uxteam.reload.databasecreator.model.Table;

/**
 * @author <b>��ѩ</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-13
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
     * @return ���� request.
     */
    public ChangeBoundsRequest getRequest() {
        return request;
    }
    /**
     * @param request ���� request 
     */
    public void setRequest(ChangeBoundsRequest request) {
        this.request = request;
    }
    /**
     * @return ���� model.
     */
    public Table getModel() {
        return model;
    }
    /**
     * @param model ���� model 
     */
    public void setModel(Table model) {
        this.model = model;
    }
}
