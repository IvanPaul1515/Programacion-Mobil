## **Tarea2 ----> My First App**
**Descripción:**
Crear una interfaz con componente simple, con la idea de que el usuario se comience a familiarizar con esta tecnología.
Se creará una vista principal, donde se deba introducir un nombre, un apellido, genero, fecha de nacimiento, responder si le gusta programar, y cuales lenguajes le gusta.

- Objetivo: Que el estudiante sea capaz de diseñar e implementar una vista con componentes simples, tales como: Button, Text view, Plan view, Sppiner, Radio button y Check box.

- Diseño: EL diseño de la aplicación debe quedar muy similar a las siguientes imágenes

- Comportamiento: El usuario deberá realizar las siguientes acciones:

1. Introducir un nombre.
2. Introducir un apellido.
3. Seleccionar un género.
4. Establecer una fecha de nacimiento.
5. Seleccionar si le gusta programar, y cuales lenguajes.
6. Al presionar el botón enviar, la información debe ser mostrada en una segunda vista, como se muestra en la figura 2.
7. Al presionar el botón limpiar, deberá limpiar todos los campos, establecer el género en el índice 0, y la opción de le gusta programar a Si.

- **Validaciones:**

- Los campos nombre, apellido, y género, son obligatorio. En caso de que no tenga datos, debe mostrarle un mensaje al usuario.
- La fecha de nacimiento debe ser con componente DatePicker.
- Si la opción de le gusta programar esta activa, debe haber seleccionado al menos un lenguaje.
- Si la opción de le gusta programar esta inactiva, no puede seleccionar ningún lenguaje.
- Todo esto debe ser validado al presionar el botón enviar.

## Tarea3 ----> Lista de Tareas

**Objetivo:**

El objetivo de esta tarea es que los estudiantes practiquen la implementación de listas de elementos en una aplicación Android utilizando tanto ListView como RecyclerView. Además, se espera que los estudiantes comprendan las diferencias entre ambos enfoques y las ventajas de usar RecyclerView.

**Descripción de la Tarea:**

Los estudiantes deben crear una aplicación de lista de tareas que permita a los usuarios agregar, ver y eliminar tareas pendientes. La aplicación debe tener dos pestañas: una para usar ListView y otra para usar RecyclerView. Los usuarios deben poder alternar entre estas dos vistas y experimentar las diferencias en la experiencia del usuario.

**Requisitos Mínimos:**

**Pestañas:**
- La aplicación debe tener dos pestañas claramente identificadas: una para ListView y otra para RecyclerView.

**ListView:**
- En la pestaña de ListView, los estudiantes deben implementar una lista de tareas utilizando un ListView.
- Los usuarios deben poder agregar nuevas tareas ingresando un texto y presionando un botón "Agregar".
- Cada tarea en la lista debe mostrar su nombre y una opción para eliminarla.
- Cuando se hace clic en una tarea, debe mostrarse un cuadro de diálogo de confirmación para eliminarla.

**RecyclerView:**
- En la pestaña de RecyclerView, los estudiantes deben implementar una lista de tareas utilizando un RecyclerView.
- La lista debe ser actualizable y permitir agregar y eliminar tareas de la misma manera que en la pestaña de ListView.
- Utilice RecyclerView para mostrar la lista de tareas de manera eficiente.
- El RecyclerView debe tener una imagen en cada elemento del mismo.

**Funcionalidad Adicional (opcional):**
- Los estudiantes pueden agregar funcionalidades adicionales según su creatividad, como la capacidad de marcar tareas como completadas o editar el nombre de una tarea existente.

## **Tarea4 ----> Lista de Tareas con ViewModel**
**Descripción:**

Crear una aplicación de lista de tareas simple utilizando ViewModel, LiveData y Room en Android. La aplicación permitirá a los usuarios agregar, eliminar y marcar como completadas las tareas.

**Requisitos:**

  **Interfaz de Usuario (UI)**
- Crear una actividad principal con una lista de tareas.
- Agregar un botón "Agregar tarea" en la parte inferior de la pantalla.
- Al hacer clic en "Agregar tarea", se debe abrir una nueva actividad, fragmento o diálogo para ingresar una nueva tarea. Al darle a salvar debe volver a la vista principal y mostrar la lista de tarea actualizada.
- Cada tarea debe mostrar su nombre y un botón para marcarla como completada.
- Las tareas completadas deben mostrarse de manera diferente en la lista (por ejemplo, tachadas o con un icono).

**ViewModel**
- Implementar un ViewModel para gestionar los datos de la lista de tareas.
- El ViewModel debe contener métodos para agregar tareas, obtener la lista de tareas y marcar tareas como completadas.
- Room Database
- Configurar una base de datos Room para almacenar las tareas.
- Definir una entidad para las tareas con al menos los campos "id", "nombre" y "completada".
- Crear un DAO (Data Access Object) para realizar operaciones en la base de datos, como insertar, eliminar y actualizar tareas.

**LiveData**
- Utilizar LiveData para observar los cambios en la lista de tareas en tiempo real.
- Actualizar la UI automáticamente cuando se agreguen o eliminen tareas.
- Funcionalidad de Eliminación
- Permitir a los usuarios eliminar tareas al deslizarlas, pop up menu o al hacer clic en un botón de eliminar.



