import jdk.nashorn.internal.codegen.types.Type;

import java.util.HashMap;

public class IOC {

    /**
     *  This is experimental - IOC-Container doesn't inject dependencies yet.
     */

    private static final IOC instance = new IOC(new HashMap<>());

    public IOC(HashMap<Type, Object> injectables) {
        this.injectables = injectables;
    }

    private final HashMap<Type, Object> injectables;

    public static IOC instance() {
        return instance;
    }

    @SuppressWarnings("unchecked cast")
    public <T> T resolveObject(Class<? extends T> type) throws ClassNotFoundException {

        if (!canResolve(type)) throw new ClassNotFoundException("cannot create class");
        return (T) injectables.get(Type.typeFor(type)); // cast is checked by logic
    }

    public <T> void setClassObject(T object) {

        injectables.put(Type.typeFor(object.getClass()), object);
    }

    public boolean canResolve(Class resolveType){
        return injectables.keySet().contains(Type.typeFor(resolveType));
    }
}
