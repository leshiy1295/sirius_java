package inheritance;

public abstract class Animal { // абстрактный класс
    public boolean flag = false;
    private int weight; // приватное поле

    public Animal(int weight) { // конструктор класса
        this.weight = weight; // обращение через ключевое слово this - ссылку на текущий экземпляр класса
    }

    public boolean isDangerous() { // публичный метод
        return isPredator() || getWeight() > 15; // этот метод использует абстрактный метод - в потомках он будет вызван корректно
    }

    protected int getWeight() { // защищённый метод - он будет доступен наследникам и в пределах этого же пакета, но не будет доступен снаружи
        return weight; // подобные функции называются геттерами
    }

    abstract boolean isPredator(); // абстрактный метод - не имеет реализации. Должен быть реализован в классах-потомках. Их принято указывать снизу
}

