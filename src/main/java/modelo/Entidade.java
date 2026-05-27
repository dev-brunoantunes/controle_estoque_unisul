package modelo;

public abstract class Entidade {

    private int id;

    public Entidade() {
    }

    public Entidade(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
