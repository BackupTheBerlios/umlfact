/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-8-12
 *
 */
package com.uxteam.reload.databasecreator.figure;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

import com.uxteam.reload.databasecreator.graphics.util.GraphicsUtil;
import com.uxteam.reload.databasecreator.model.Table;
import com.uxteam.reload.databasecreator.resource.ImageProvider;

/**
 * @author <b>彭雪 </b>
 * 
 * 描述 ： 创建时间：2005-8-12
 */
public class TableFigure extends Figure {

    private Table model;

    Figure containerFigure = null;

    private Label tableNameLabel = null;

    public TableFigure(Table model) {
        super();
        this.model = model;

        tableNameLabel = new Label();
        tableNameLabel.setText(model.getTableName());
        FontData fd = new FontData();

        fd.setHeight(10);
        fd.setName("Arial");
        fd.setStyle(SWT.BOLD);

        tableNameLabel.setFont(new Font(null, fd));
        tableNameLabel.setIcon(ImageProvider.TABLE_ICON.createImage());
        tableNameLabel.setLabelAlignment(PositionConstants.MIDDLE);

        // Colum Figure容器
        containerFigure = new Figure() {
            protected void paintFigure(Graphics g) {
                super.paintFigure(g);
                //                g.setBackgroundColor(ColorConstants.red);
                //                g.fillRectangle(getBounds());
            }

            public Dimension getPreferredSize(int wHint, int hHint) {
                Dimension dimension = super.getPreferredSize(wHint, hHint);

                int w = Math.max(dimension.width, wHint);
                int h = Math.max(dimension.height, 30);

                return new Dimension(w, h);
            }
        };

        ToolbarLayout tableLayout = new ToolbarLayout();
        // 让Table Label和Column Container距离大一点
        tableLayout.setSpacing(4);

        tableLayout.setVertical(true);

        // 留出一点边距，会好看点
        this.setBorder(new MarginBorder(8, 8, 8, 8));

        // 数据表格是Toolbar布局
        this.setLayoutManager(tableLayout);
        // 承载Column Figure的容器也是ToolbarLayout
        ToolbarLayout containerLayout = new ToolbarLayout();
        containerLayout.setMinorAlignment(ToolbarLayout.ALIGN_BOTTOMRIGHT);
        containerFigure.setLayoutManager(containerLayout);
        this.add(tableNameLabel);
        this.add(containerFigure);
        this.setOpaque(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    protected void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);
        graphics.setForegroundColor(ColorConstants.gray);
        // 通过GraphicsUtil绘制渐变区域
        Point plusPoint = new Point(getLocation().x ,getLocation().y );
        Dimension plusDimension = new Dimension(getBounds().getSize().width,20);
        GraphicsUtil.paintPlusArea(graphics,plusPoint,plusDimension);
        // 得到Figure的Bounds
        Rectangle bounds = getBounds();

        // 在它周围绘制一个矩形，宽度和高度稍微小一点，以便能全部显示
        graphics.drawRectangle(new Rectangle(bounds.x, bounds.y,
                bounds.width - 1, bounds.height - 1));

        // 在名字和ContainerFigure之间画一条线
        int y = getBounds().y + getBorder().getInsets(this).bottom
                + this.tableNameLabel.getSize().height;
        graphics.drawLine(getBounds().x, y, getBounds().x + getBounds().width,
                y);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.draw2d.IFigure#paint(org.eclipse.draw2d.Graphics)
     */
    public void paint(Graphics graphics) {
        // 在绘制之前先把label要显示的表名设置好先
        this.tableNameLabel.setText(model.getTableName());
        super.paint(graphics);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.draw2d.IFigure#getPreferredSize(int, int)
     */
    public Dimension getPreferredSize(int wHint, int hHint) {
        // TODO Auto-generated method stub
        return super.getPreferredSize(wHint, hHint);
    }

    /**
     * @return 返回 containerFigure.
     */
    public Figure getContainerFigure() {
        return containerFigure;
    }

    /**
     * @param containerFigure
     *            设置 containerFigure
     */
    public void setContainerFigure(Figure containerFigure) {
        this.containerFigure = containerFigure;
    }
}