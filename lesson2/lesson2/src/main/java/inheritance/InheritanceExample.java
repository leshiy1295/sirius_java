package inheritance;

public class InheritanceExample {
    public static void run() {

        // Animal animal == new Animal(); // абстрактные классы инстанцировать нельзя

        Elephant elephant = new Elephant(); // создаём объект
        boolean isDangerous = elephant.isDangerous(); // эта функция публичная и была наследована - будет использована реализация в базовом классе
        if (elephant.canJump()) { // вызов метода интерфейса - он доступен, так как все методы интерфейса публичные
            jump(elephant); // передача объекта, реализующего интерфейс, в функцию, принимающую ссылку на интерфейс
        }

        //  Jumpable jumpable = new Jumpable();
        Jumpable secondElephant; // ссылки на интерфейс инициализируюстся null по умолчанию, как и обычные объекты
        secondElephant = new Elephant(); // ссылкам на интерфейс можно присваивать объекты реализующих их классов
        // boolean isSecondElephantDangerous = secondElephant.isDangerous(); // несмотря на то, что в объекте этот метод есть, он не виден через ссылку на интерфейс
        if (secondElephant.canJump()) { // вызов метода интерфейса у реального объекта через ссылку на интерфейс
            jump(secondElephant); // передача объекта через ссылку на интерфейс в функцию, принимающую ссылку на интерфейс
        }
    }

    public static void jump(Jumpable object) { // метод принимает ссылку на интерфейс
        // Animal animal = object; // Jumpable object может и не быть Animal
        // Elephant el = object; // хоть Elephant и реализует Jumpable, но не факт, то Jumpable является Elephant
        // boolean isDangerous = object.isDangerous(); // такого метода в интерфейсе нет
        if (object.canJump()) { // вызов метода интерфейса у объекта, переданного через ссылку на интерфейс
            System.out.println("jumped");
        }
    }
}
