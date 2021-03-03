package test.base;

import com.google.inject.Guice;
import com.google.inject.Injector;
import model.Counter;
import module.ParentModule;


public abstract class TestCommonCondition {

    private Injector injector = Guice.createInjector(new ParentModule());
    public Counter counter = injector.getInstance(Counter.class);
}
