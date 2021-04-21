package Prenda.Categoria;

import Prenda.Categoria.TipoDePrenda.TipoDeParteInferior;

import java.util.Objects;

public class ParteInferior implements Categoria{
    TipoDeParteInferior tipoDeParteInferior;

    public ParteInferior(TipoDeParteInferior tipoDeParteInferior){
        this.tipoDeParteInferior = Objects.requireNonNull(tipoDeParteInferior,"Debe seleccionar el tipo de parte inferior de la prenda");
    }
}
