// Import Statements
import java.io.Serializable;

/*
HeaderFile is a Java class that implements the Serializable interface.
This means instances of this class can be serialized and deserialized,
making them suitable for transmission over a network.

*/
public class HeaderFile implements Serializable {
    private String methodName;
    private Class<?>[] parameterTypes;

    // Constructor
    public HeaderFile(String methodName, Class<?>[] parameterTypes) {
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
    }

    // Represents the name of the method to be invoked on the remote object.
    public String getMethodName() {
        return methodName;
    }

    // Represents an array of Class objects, each of which describes the type of a parameter of the method.
    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }
}
