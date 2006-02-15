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
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-8-12
 *
 */

/**
 * @author <b>彭雪</b>
 *
 * 描述 ： 
 * 创建时间：2005-8-12
 */
public class DbEditor extends GraphicalEditorWithPalette {

    public DbEditor(){
        // 这是必须的
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
        // 硬编码生成一个数据库模型
        Schema schema = new Schema();
        
        this.getGraphicalViewer().setContents(schema);
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
     */
    protected void configureGraphicalViewer() {
        // 这里需要调用基类的方法
        super.configureGraphicalViewer();
        GraphicalViewer viewer = this.getGraphicalViewer();
        
        // 设置根EditPart
        viewer.setRootEditPart(new FreeformGraphicalRootEditPart());
        
        // 设置工厂
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
