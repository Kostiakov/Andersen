package proxycglib;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.*;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface Cached {

}
