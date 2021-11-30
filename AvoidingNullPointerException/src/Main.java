import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        ErrorMessage operationResult = null;
        ErrorMessage operationResult2 = new ErrorMessage();
        operationResult2.setErrorCode("400");
        // if(ObjectUtils.allNotNull(operationResult, operationResult.getErrorCode())) System.out.println("NPE");

        if (isNull(() -> Arrays.asList(operationResult, operationResult.getErrorCode(), operationResult.getMessage().getName()))) {
            System.out.println("Null -> " + operationResult);
        }

        if (isNonNull(() -> Arrays.asList(operationResult2, operationResult2.getErrorCode()))) {
            System.out.println("Non Null -> " + operationResult2);
        }
    }

    public static boolean isNull(Supplier<List<Object>> supplier) {
        try {
            if (supplier == null) return true;
            for (Object o : supplier.get()) {
                if (Objects.isNull(o)) return true;
            }
        } catch (@SuppressWarnings("unused") NullPointerException ignored) {
            System.err.println("NullPointerException");
            return true;
        }
        return false;
    }

    public static boolean isNonNull(Supplier<List<Object>> supplier) {
        return !isNull(supplier);
    }
}

class ErrorMessage {
    String errorMessage;
    String errorCode;
    Message message;

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", message=" + message +
                '}';
    }
}

class Message {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                '}';
    }
}