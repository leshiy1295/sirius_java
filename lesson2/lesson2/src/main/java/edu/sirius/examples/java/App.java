package edu.sirius.examples.java;

import generics.GenericExample;
import inheritance.InheritanceExample;
import object.ObjectMethodsExample;
import specialClasses.Outer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        InheritanceExample.run();

        Outer outer = new Outer(); // отдельное создание объекта внешнего класса
        outer.anonymous(); // вызов функции, создающей анонимный объект
        Outer.Inner inner = outer.inner; // получение ссылки на внутренний объект внешнего класса
        inner.localMethod(); // вызов метода внутреннего класса
        Outer.StaticInner staticInner = new Outer.StaticInner(); // создание объекта внутреннего статического класса
        System.out.println(staticInner.c++);
        System.out.println(new Outer.StaticInner().c++); // каждый раз создаётся новый объект

        ObjectMethodsExample.run();
        GenericExample.run(); // для вызова статических методов не нужно инстанцировать класс типом
    }
}
