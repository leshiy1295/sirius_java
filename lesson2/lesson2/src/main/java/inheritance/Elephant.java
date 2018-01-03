package inheritance;

public class Elephant extends Animal implements Jumpable, Movable { // этот класс наследуется от Animal и реализует интерфейсы Jumpable и Movable
    private boolean canJump = false; // в нём могут быть введены новые поля и методы

    public Elephant() { // может быть переопределён конструктор
        super(200); // тут вызывается конструктор базового класса
    }

    boolean isPredator() { // определение абстрактного метода родителя
        return false;
    }

    public boolean canJump() { // реализация метода интерфейса
        new Object().equals(new Object());
        new Object().hashCode();
        return canJump;
    }

    public boolean canMove() {
        return true;
    }
}
