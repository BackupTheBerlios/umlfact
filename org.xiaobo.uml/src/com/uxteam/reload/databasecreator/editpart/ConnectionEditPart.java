/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-1
 *
 */
package com.uxteam.reload.databasecreator.editpart;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

/**
 * @author <b>��ѩ</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-1
 */
public class ConnectionEditPart extends AbstractConnectionEditPart {

    protected IFigure createFigure() {
        PolylineConnection conn = new PolylineConnection();
        conn.setConnectionRouter(new BendpointConnectionRouter());
        conn.setTargetDecoration(new PolygonDecoration());
        return conn;
    }
    /* (non-Javadoc)
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
    }

}
