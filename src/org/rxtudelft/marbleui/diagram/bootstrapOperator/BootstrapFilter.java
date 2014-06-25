package org.rxtudelft.marbleui.diagram.bootstrapOperator;

import org.rxtudelft.marbleui.diagram.SimpleMarbleModel;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.TestScheduler;

/**
 * Created by ferdy on 5/16/14.
 */
public class BootstrapFilter extends BootstrapOperator1<SimpleMarbleModel, SimpleMarbleModel> {

    private Func1<SimpleMarbleModel, Boolean> filter;

    public BootstrapFilter(Func1<SimpleMarbleModel, Boolean> filter) {
        super("Filter");
        this.filter = filter;
    }

    @Override
    public Observable< SimpleMarbleModel> call1(TestScheduler s, Observable<SimpleMarbleModel> toFilter) {
        return toFilter.filter(filter);
    }
}
