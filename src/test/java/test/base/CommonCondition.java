package test.base;

import com.google.inject.Inject;
import com.google.inject.Injector;
import model.Counter;

public class CommonCondition {

    @Inject
    public Injector injector;

    public Counter counter;
}
