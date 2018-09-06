package pe.joedayz.cofaco.enums;

public enum TipoDocumentoEnum {

    FACTURA  ("01"),
    BOLETA_VENTA("03"),
    NOTA_CREDITO   ("07"),
    NOTA_DEBITO ("08"),
    RETENCIONES ("20");

    private final String value;

    TipoDocumentoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
