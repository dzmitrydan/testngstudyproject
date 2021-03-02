package service;

public class ParameterBuilderForReflection {

    public static Class[] createParamsTypes(String[] array) {
        Class[] types = new Class[array.length];
        for (int i = 0; i < array.length; i++) {
            types[i] = array[i].getClass();
        }
        return types;
    }
}
