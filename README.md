# Proyecto de Agenda de gestión de contactos

## Descripción General
Este proyecto es una aplicación de escritorio, que simula en su apariencia y en aspectos de su comportamiento, una app móvil. Sirve para la gestión de contactos. Permite al usuario añadir, buscar, actualizar, eliminar y exportar contactos, así como gestionar contactos favoritos.
![Alt text](Capturas/Captura$%7B%7D.png)

## Estructura del Proyecto
El proyecto se organiza en los siguientes paquetes y clases principales:

### Paquete `modelo`
- `Contacto`: Define la estructura y métodos para un contacto individual.
- `ListaContactos`: Gestiona una lista de contactos y una lista de contactos favoritos.

### Paquete `controlador`
- `Controlador`: Centraliza la lógica de interacción entre la vista y el modelo.
- `ControladorAdd`: Gestiona la adición de nuevos contactos.
- `ControladorBuscar`: Maneja la funcionalidad de búsqueda de contactos.
- `ControladorDelete`: Encargado de la eliminación de contactos.
- `ControladorExportar`: Permite exportar la lista de contactos a un archivo CSV.
- `ControladorFav`: Gestiona la visualización y manejo de los contactos favoritos.
- `ControladorUpdate`: Responsable de actualizar la información de los contactos.

### Paquete `vista`
- `Add`: Interfaz gráfica para añadir nuevos contactos.
- `Buscar`: Interfaz gráfica para buscar contactos.
- `Favoritos`: Interfaz gráfica para mostrar los contactos favoritos.
- `Update`: Interfaz gráfica para actualizar contactos.
- `VistaPrincipal`: Interfaz gráfica principal del programa.

## Funcionalidades
- **Añadir Contactos**: Permite ingresar nuevos contactos con nombre, teléfono y opción de favorito.
- **Buscar Contactos**: Funcionalidad para buscar contactos por nombre o teléfono.
- **Actualizar Contactos**: Permite modificar la información de los contactos existentes.
- **Eliminar Contactos**: Elimina contactos seleccionados de la lista.
- **Gestionar Favoritos**: Permite ver y gestionar una lista separada de contactos favoritos.
- **Exportar Contactos**: Exporta la lista de contactos a un archivo CSV.

## Interacción de Componentes
- **Controladores**: Sirven como intermediarios entre las vistas y el modelo, manejando la lógica de interacción.
- **Vistas**: Proporcionan la interfaz gráfica para interactuar con el usuario.
- **Modelo**: Contiene la lógica de negocio y la representación de los datos (contactos).

## Funcionamiento

Como nota preliminar, indicamos que en la navegación por la aplicación, para acercarnos más al uso de una app móvil, se ha desactivado el cierre de las distintas pantallas (a excepción) de la `VistaPrincipal`, que se cierra normalmente, y se ha activado un botón `Volver`.

### Inicio de la Aplicación
Al iniciar la aplicación, se presenta la `VistaPrincipal`, que es la interfaz principal donde se visualizan los contactos.
![Alt text](Capturas/Captura$%7B%7D.png)
### Añadir un Nuevo Contacto
1. **Abrir la Ventana de Añadir**: Haz clic en el botón "Añadir" en la `VistaPrincipal`.
![Alt text](<Capturas/Captura${} (3).png>)
2. **Ingresar Datos**: Rellena los campos de nombre, apellido y teléfono.
   - Si no completamos algún campo, nos devuleve un mensaje emerjente en que se indica que debe ser completado.
![Alt text](<Capturas/Captura${} (4).png>)  
![Alt text](<Capturas/Captura${} (5).png>)
![Alt text](<Capturas/Captura${} (6).png>)
3. **Seleccionar Favorito**: Marca la opción "Añadir a Favoritos" si deseas que el contacto sea favorito.
4. **Guardar Contacto**: Haz clic en el botón "Añadir" para guardar el contacto en la lista.
![Alt text](<Capturas/Captura${} (7).png>)
![Alt text](<Capturas/Captura${} (8).png>)

### Buscar Contactos
1. **Abrir la Ventana de Búsqueda**: Haz clic en el botón de búsqueda (icono de lupa) en la `VistaPrincipal`.
![Alt text](<Capturas/Captura${} (9).png>)
2. **Ingresar Criterios de Búsqueda**: Puedes buscar por nombre o teléfono.
   - Si no completamos ningún campo para la búsqueda,nos devuleve un mensaje emerjente en que se indica que debe ser completado.
![Alt text](<Capturas/Captura${} (0).png>)
   - Basta con ingresar una cadena parcial en uno u otro cuadro de búsqueda y darle a `Buscar` para que aparezcan los resultados compatibles.
![Alt text](<Capturas/Captura${} (10).png>)
3. **Realizar Búsqueda**: Haz clic en "Buscar" para filtrar los contactos según los criterios ingresados.
   - Automáticamente se limpian el cuadro de búsqueda empleado.
![Alt text](<Capturas/Captura${} (11).png>)
   - Si no coincide con ningún contacto devuelve un mensaje informativo.
![Alt text](<Capturas/Captura${} (16).png>)

### Editar un Contacto
1. **Seleccionar Contacto**: En la `VistaPrincipal`, selecciona el contacto que deseas actualizar.
   - Si no seleccionamos ningún contacto aparece un mensaje emergente de aviso.
![Alt text](<Capturas/Captura${} (17).png>)
2. **Abrir Ventana de Actualización**: Haz clic en el botón "Editar".
   - Aparecen los datos ya completados para su edición.
![Alt text](<Capturas/Captura${} (18).png>)
3. **Modificar Datos**: Cambia el nombre, apellido, teléfono y/o estado de favorito.
![Alt text](<Capturas/Captura${} (19).png>)
4. **Guardar Cambios**: Haz clic en "Actualizar" para guardar los cambios.
![Alt text](<Capturas/Captura${} (20).png>)
![Alt text](<Capturas/Captura${} (21).png>)

### Eliminar un Contacto
1. **Seleccionar Contacto**: En la `VistaPrincipal`, selecciona el contacto que deseas eliminar.
   - Si no seleccionamos ningún contacto aparece un mensaje emergente de aviso.
2. **Eliminar Contacto**: Haz clic en el botón "Eliminar" y confirma la acción en el mensaje emergente.
   - Se elimina también de favoritos.
![Alt text](<Capturas/Captura${} (22).png>)
![Alt text](<Capturas/Captura${} (23).png>)

### Gestionar Favoritos
1. **Abrir la Ventana de Favoritos**: Haz clic en el botón "Favoritos".
2. **Visualizar Favoritos**: Se mostrarán solo los contactos marcados como favoritos.
3. **Gestión Favoritos**: Automáticamente se irán actualizando los cambios.

### Exportar Contactos
1. **Iniciar Exportación**: En la `VistaPrincipal`, haz clic en el botón "Exportar".
   - Aparece un panel que solicita confirmación. Tanto si optamos por confirmar como por denegar, aparecerá un mensaje de confirmación.
![Alt text](<Capturas/Captura${} (24).png>)
![Alt text](<Capturas/Captura${} (25).png>)
![Alt text](<Capturas/Captura${} (26).png>)
![Alt text](<Capturas/Captura${} (28).png>)
2. **Confirmar Acción**: Confirma la acción para exportar la lista de contactos actualizada a un archivo CSV en la carpeta del proyecto.

### Cerrar la Aplicación
Para cerrar la aplicación, simplemente cierra la ventana principal.

## Instalación y Ejecución
Para ejecutar la aplicación, asegúrate de tener instalado Java y luego ejecuta el archivo `AndrésAvendaño_Actividad2_Agenda`.

---
