package org.rxtudelft.marbleui.viewModel;

import javafx.beans.value.ObservableValue;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.rxtudelft.marbleui.diagram.ObservableModel;
import org.rxtudelft.marbleui.diagram.initOperator.SimpleMarbleModel;
import org.rxtudelft.marbleui.node.NodeObservable;
import rx.Observable;
import rx.observables.JavaFxObservable;

import java.util.OptionalDouble;

/**
 * Created by ferdy on 5/28/14.
 */
public class ObservableViewModel extends ViewModel<SimpleMarbleModel> {
    //LSP Violation! view/model are covariantly overloaded. Does it matter with abstract classes?
    public ObservableViewModel(Observable<SimpleMarbleModel> state, NodeObservable view, Iterable<ObservableValue<?>> watch, ObservableModel<SimpleMarbleModel> model) {
        super(Observable.<SimpleMarbleModel>from(model), view, watch, model);

        JavaFxObservable.fromNodeEvents(view, MouseEvent.MOUSE_MOVED)
                .subscribe(e -> {
                    view.ghostProperty().set(OptionalDouble.of(e.getX()));
                });

        JavaFxObservable.fromNodeEvents(view, MouseEvent.MOUSE_CLICKED)
                .subscribe(e -> {
                    model.add(new SimpleMarbleModel(e.getX(), 5, Color.DARKORCHID));
                });

        this.getState().subscribe(e -> {
            view.marblesProperty().add(e);
        });
    }

    @Override
    public void updateModel() {

    }
}