package object;

public class GoodUser {
    private int id;
    private String name;

    public GoodUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (!(other instanceof GoodUser)) return false;

        GoodUser otherUser = (GoodUser)other;
        return id == otherUser.id && (name == null && otherUser.name == null || name != null && name.equals(otherUser.name));
    }
}
