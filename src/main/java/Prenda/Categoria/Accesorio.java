package Prenda.Categoria;

import Prenda.Categoria.TipoDePrenda.TipoDeAccesorio;

import java.util.Objects;

public class Accesorio implements Categoria {
    TipoDeAccesorio tipoDeAccesorio;

    public Accesorio(TipoDeAccesorio tipoDeAccesorio) {
        this.tipoDeAccesorio = Objects.requireNonNull(tipoDeAccesorio, "Debe seleccionar el tipo de prenda en la categoria");
    }
}
