package org.rxtudelft.marbleui.view.diagram.marble;

import org.rxtudelft.marbleui.diagram.MarbleModel;
import org.rxtudelft.marbleui.diagram.ObservableModel;
import org.rxtudelft.marbleui.view.diagram.MarbleDiagramView;
import org.rxtudelft.marbleui.view.diagram.hybrid.ChildObservableView;
import org.rxtudelft.marbleui.view.diagram.observable.BaseObservableView;
import org.rxtudelft.marbleui.view.viewModel.InputObservableViewModel;

/**
 * Created by ferdy on 6/25/14.
 */
public class ComplexObservableView extends BaseObservableView {

    public ComplexObservableView(ObservableModel model, double w, double h, double r) {
        super(model, w, h, r);
    }

    @Override
    public MarbleView getMarbleView(MarbleModel m, double t, double w, double h) {
        ChildObservableView childObservableView = new ChildObservableView((ObservableModel) m, getWidth() - t, h, getRadius(), 20, t);
        new InputObservableViewModel<>(childObservableView);

        childObservableView.getModel().getChangeObs().subscribe(a -> {
//            MarbleDiagramView.model.calcOutput();
        });

        return childObservableView;
    }

    @Override
    public void redraw() {
        this.clear();
        this.getModel().getMarbles().forEach((k, v) -> {
            this.placeMarble(k, v);
        });

        this.getMarbles().forEach(child -> {
            if(child instanceof ChildObservableView) {
                ((ChildObservableView)child).redraw();
            }
        });
    }
}
