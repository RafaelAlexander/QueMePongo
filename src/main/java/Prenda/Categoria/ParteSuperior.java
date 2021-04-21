package Prenda.Categoria;

import Prenda.Categoria.TipoDePrenda.TipoDeParteSuperior;

import java.util.Objects;

public class ParteSuperior implements Categoria{
    TipoDeParteSuperior tipoDeParteSuperior;

    public ParteSuperior(TipoDeParteSuperior tipoDeParteSuperior){
        this.tipoDeParteSuperior = Objects.requireNonNull(tipoDeParteSuperior,"Debe elegir el tipo de la parte superior");
    }
}
