package codegen;

import org.omg.Dynamic.Parameter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CodeGenerationExample {
    public static void run() {
        try {
            Class clazz = Test.class;
            Test test = (Test) clazz.newInstance();

            clazz.getConstructors();

            // вызвать метод по имени у заданного объекта
            Method method = clazz.getMethod("foo");
            System.out.println(method.toString());
            method.invoke(test);

            // установить поле по имени у заданного объекта
            Field field0 = clazz.getDeclaredField("field");
            field0.setAccessible(true);
            field0.set(test, 100);
            System.out.println(test);

            // вывод названия пакета
            Package pack = clazz.getPackage();
            System.out.println("package " + pack.getName() + ";");

            // начало декларации класса с модификаторов
            int modifiers = clazz.getModifiers();
            System.out.println(getModifiers(modifiers));

            // вывод названия класса
            System.out.print("class " + clazz.getSimpleName() + " ");

            // вывод названия родительского класса
            System.out.print("extends " + clazz.getSuperclass().getSimpleName() + " ");

            // вывод интерфейсов, которые класс реализует
            Class[] interfaces = clazz.getInterfaces();
            for (int i = 0, size = interfaces.length; i < size; ++i) {
                System.out.print(i == 0 ? "implements " : ", ");
                System.out.print(interfaces[i].getSimpleName());
            }
            System.out.println(" {");

            // вывод полей класса
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("\t" + getModifiers(field.getModifiers()) + getType(field.getType()) + " " + field.getName() + ";");
            }

            // вывод конструкторов класса
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor c : constructors) {
                System.out.print("\t" + getModifiers(c.getModifiers()) + clazz.getSimpleName() + "(");
                System.out.print(getParameters(c.getParameterTypes()));
                System.out.println(") { }");
            }

            // вывод методов класса
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m : methods) {
                // получение аннотаций
                Annotation[] annotations = m.getAnnotations();
                System.out.print("\t");
                for (Annotation a : annotations) {
                    System.out.print("@" + a.annotationType().getSimpleName() + " ");
                }
                System.out.println();
                System.out.print("\t" + getModifiers(m.getModifiers()) + getType(m.getReturnType()) + " " + m.getName() + "(");
                System.out.print(getParameters(m.getParameterTypes()));
                System.out.println(") { }");
            }
            System.out.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getModifiers(int mod) {
        String modifiers = "";
        if (Modifier.isPublic(mod)) {
            modifiers += "public ";
        }
        if (Modifier.isProtected(mod)) {
            modifiers += "protected ";
        }
        if (Modifier.isPrivate(mod)) {
            modifiers += "private ";
        }
        if (Modifier.isStatic(mod)) {
            modifiers += "static ";
        }
        if (Modifier.isAbstract(mod)) {
            modifiers += "abstract ";
        }
        return modifiers;
    }

    private static String getType(Class clazz) {
        String type = clazz.isArray() ? clazz.getComponentType().getSimpleName() : clazz.getSimpleName();
        if (clazz.isArray()) {
            type += "[]";
        }
        return type;
    }

    private static String getParameters(Class[] params) {
        StringBuilder param = new StringBuilder();
        for (int i = 0; i < params.length; ++i) {
            param.append(params[i].getSimpleName());
            if (i != params.length - 1) {
                param.append(", ");
            }
        }
        return param.toString();
    }
}
