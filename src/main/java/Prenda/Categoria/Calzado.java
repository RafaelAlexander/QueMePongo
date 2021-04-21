package Prenda.Categoria;

import Prenda.Categoria.TipoDePrenda.TipoDeCalzado;

import java.util.Objects;

public class Calzado implements Categoria {
    TipoDeCalzado tipoDeCalzado;

    public Calzado(TipoDeCalzado tipoDeCalzado) {
        this.tipoDeCalzado = Objects.requireNonNull(tipoDeCalzado,"Debe seleccionar el tipo de calzado");
    }
}
