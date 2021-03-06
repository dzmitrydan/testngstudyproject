package model;

import java.util.Arrays;

public class TestData {
    private String testClassName;
    private String methodName;
    private String[] methodParameters;

    public String getTestClassName() {
        return testClassName;
    }

    public void setTestClassName(String testClassName) {
        this.testClassName = testClassName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String[] getMethodParameters() {
        return methodParameters;
    }

    public void setMethodParameters(String[] methodParameters) {
        this.methodParameters = methodParameters;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " (" + hashCode() + ")"
                + ": testClassName = " + testClassName
                + "; methodName = " + methodName
                + "; methodParameters = " + Arrays.toString(methodParameters);
    }
}
