package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface CreatedBy {
    String author();
    String date();
}

@CreatedBy(author = "Alexey Khalaydzhi", date = "08.01.2018")
public class AnnotationsExample {
    @CreatedBy(author = "Alexey Khalaydzhi", date = "08.01.2018")
    public static void run() {
        Class myClass = AnnotationsExample.class;
        try {
            Method method = myClass.getMethod("run");
            CreatedBy annotationC = (CreatedBy) myClass.getAnnotation(CreatedBy.class);
            CreatedBy annotationM = (CreatedBy) method.getAnnotation(CreatedBy.class);

            System.out.println("Author of the class: " + annotationC.author());
            System.out.println("Date of writing the class: " + annotationC.date());
            System.out.println("Author of the method: " + annotationM.author());
            System.out.println("Date of writing the method: " + annotationM.date());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
