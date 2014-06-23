package org.rxtudelft.marbleui.diagram;

import javafx.scene.Node;
import org.rxtudelft.marbleui.diagram.bootstrapOperator.NGonMarbleModel;
import org.rxtudelft.marbleui.view.diagram.NGonMarbleView;
import org.rxtudelft.marbleui.view.diagram.ObservableView;
import org.rxtudelft.marbleui.view.diagram.SimpleMarbleView;

/**
 * Created by ferdy on 6/21/14.
 */
public class SimpleObservableView extends ObservableView {

    public SimpleObservableView(double width, double height) {
        super(width, height);
    }

    @Override
    protected SimpleMarbleView getMarbleView(Long t, MarbleModel m) {
        NGonMarbleModel sm = (NGonMarbleModel) m;
        NGonMarbleView nm = new NGonMarbleView((NGonMarbleModel) m, getR());
        nm.getP().setFill(sm.getColor());

        return nm;
    }
}
