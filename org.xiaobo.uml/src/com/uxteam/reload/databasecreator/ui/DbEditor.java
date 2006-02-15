package com.uxteam.reload.databasecreator.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;

import com.uxteam.reload.databasecreator.editpart.DBEditPartFactory;
import com.uxteam.reload.databasecreator.model.Schema;
import com.uxteam.reload.databasecreator.palette.PaletteFactory;
/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-12
 *
 */

/**
 * @author <b>��ѩ</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-12
 */
public class DbEditor extends GraphicalEditorWithPalette {

    public DbEditor(){
        // ���Ǳ����
        this.setEditDomain(new DefaultEditDomain(this));
    }
    /* (non-Javadoc)
     * @see org.eclipse.gef.ui.parts.GraphicalEditorWithPalette#getPaletteRoot()
     */
    protected PaletteRoot getPaletteRoot() {
        return PaletteFactory.INSTANCE().createPaletteRoot();
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#initializeGraphicalViewer()
     */
    protected void initializeGraphicalViewer() {
        // Ӳ��������һ�����ݿ�ģ��
        Schema schema = new Schema();
        
        this.getGraphicalViewer().setContents(schema);
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
     */
    protected void configureGraphicalViewer() {
        // ������Ҫ���û���ķ���
        super.configureGraphicalViewer();
        GraphicalViewer viewer = this.getGraphicalViewer();
        
        // ���ø�EditPart
        viewer.setRootEditPart(new FreeformGraphicalRootEditPart());
        
        // ���ù���
        viewer.setEditPartFactory(new DBEditPartFactory());
    }
    /* (non-Javadoc)
     * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
     */
    public void doSave(IProgressMonitor monitor) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.part.EditorPart#doSaveAs()
     */
    public void doSaveAs() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.part.EditorPart#isDirty()
     */
    public boolean isDirty() {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
     */
    public boolean isSaveAsAllowed() {
        // TODO Auto-generated method stub
        return false;
    }
}
