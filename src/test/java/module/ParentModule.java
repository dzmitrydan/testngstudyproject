package module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import model.CounterOrdinary;
import model.Counter;

public class ParentModule extends AbstractModule {

    public ParentModule() {
    }

    @Override
    protected void configure() {
        bind(Counter.class).to(CounterOrdinary.class).in(Scopes.SINGLETON);
    }
}
