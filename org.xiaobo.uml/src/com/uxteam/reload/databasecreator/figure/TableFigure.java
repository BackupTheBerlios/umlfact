/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
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
 * @author <b>��ѩ </b>
 * 
 * ���� �� ����ʱ�䣺2005-8-12
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

        // Colum Figure����
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
        // ��Table Label��Column Container�����һ��
        tableLayout.setSpacing(4);

        tableLayout.setVertical(true);

        // ����һ��߾࣬��ÿ���
        this.setBorder(new MarginBorder(8, 8, 8, 8));

        // ���ݱ����Toolbar����
        this.setLayoutManager(tableLayout);
        // ����Column Figure������Ҳ��ToolbarLayout
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
        // ͨ��GraphicsUtil���ƽ�������
        Point plusPoint = new Point(getLocation().x ,getLocation().y );
        Dimension plusDimension = new Dimension(getBounds().getSize().width,20);
        GraphicsUtil.paintPlusArea(graphics,plusPoint,plusDimension);
        // �õ�Figure��Bounds
        Rectangle bounds = getBounds();

        // ������Χ����һ�����Σ���Ⱥ͸߶���΢Сһ�㣬�Ա���ȫ����ʾ
        graphics.drawRectangle(new Rectangle(bounds.x, bounds.y,
                bounds.width - 1, bounds.height - 1));

        // �����ֺ�ContainerFigure֮�仭һ����
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
        // �ڻ���֮ǰ�Ȱ�labelҪ��ʾ�ı������ú���
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
     * @return ���� containerFigure.
     */
    public Figure getContainerFigure() {
        return containerFigure;
    }

    /**
     * @param containerFigure
     *            ���� containerFigure
     */
    public void setContainerFigure(Figure containerFigure) {
        this.containerFigure = containerFigure;
    }
}