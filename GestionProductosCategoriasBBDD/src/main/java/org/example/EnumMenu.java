package org.example;

public enum EnumMenu {

    CREAR_TABLAS(1, "Crear tablas (productos y categorias)"),
    CREAR_NUEVA_CATEGORIA(2, "Añadir nueva categoria"),
    CREAR_NUEVO_PRODUCTO(3, "Añadir nuevo producto"),
    ELIMINAR_PRODUCTO(4, "Eliminar un producto"),
    EXPORTAR_CSV(5, "Exportar a CSV"),
    SALIR(6, "Salir");

    private final int codigo;
    private final String descripcion;

    EnumMenu(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para obtener una opción del enum a partir de su código.
     *
     * @param codigo El código numérico de la opción.
     * @return La opción correspondiente al código, o null si no hay coincidencia.
     */
    public static EnumMenu desdeCodigo(int codigo) {
        for (EnumMenu opcion : values()) {
            if (opcion.getCodigo() == codigo) {
                return opcion; // Retornar la opción correspondiente
            }
        }
        return null; // Si el código no coincide con ninguna opción
    }

    /**
     * Método para mostrar las opciones del menú en la consola.
     *
     * Este método imprime todas las opciones disponibles junto con sus códigos
     * en la consola para que el usuario pueda seleccionar una.
     */
    public static void mostrarOpcionesMenu() {
        for (EnumMenu opcion : EnumMenu.values()) {
            System.out.println(opcion.getCodigo() + ". " + opcion.getDescripcion()); // Imprimir cada opción
        }
    }
}
