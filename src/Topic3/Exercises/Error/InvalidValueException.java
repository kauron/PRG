package Topic3.Exercises.Error;

import java.util.InputMismatchException;

public class InvalidValueException extends InputMismatchException {
    public InvalidValueException (String message){
        super(message);
    }
}