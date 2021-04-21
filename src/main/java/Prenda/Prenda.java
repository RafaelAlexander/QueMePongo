package Prenda;

import Prenda.Categoria.Categoria;

import java.util.Objects;

public class Prenda {
    Categoria categoria;
    ComposicionPrenda composicionPrenda;
    Color primario;
    Color secundario;

    public Prenda(Categoria categoria, ComposicionPrenda composicionPrenda, Color primario, Color secundario) {
        this.categoria = Objects.requireNonNull(categoria, "Debe indicar la categoria");
        this.composicionPrenda = Objects.requireNonNull(composicionPrenda, "Debe indicar la composion de la prenda");
        this.primario = Objects.requireNonNull(primario, "Debe indicar el color primario");
        this.secundario = secundario;
    }
}
