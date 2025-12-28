# Java Data Structures & Algorithms (From Scratch) ☕

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Complexity](https://img.shields.io/badge/Complexity-O(log%20n)-red?style=for-the-badge)
![UBA](https://img.shields.io/badge/Institution-FCEN%20UBA-lightgrey?style=for-the-badge)

## 📋 Descripción General
Colección de estructuras de datos fundamentales implementadas **desde cero** (sin utilizar la Java Collections Framework como `java.util.List` o `java.util.Set`).

Este proyecto fue desarrollado como parte de la formación en **Algoritmos y Estructuras de Datos II** en la Facultad de Ciencias Exactas y Naturales de la **Universidad de Buenos Aires (UBA)**.

El objetivo principal de estas implementaciones es demostrar el dominio sobre:
* **Gestión de Memoria:** Manejo manual de nodos, referencias y punteros (`prev`, `next`, `parent`).
* **Complejidad Temporal:** Diseño de algoritmos que respetan cotas estrictas de Big-O.
* **Diseño de Software:** Uso de **Generics**, **Patrón Iterador** e Interfaces.

---

## 🛠️ Estructuras Implementadas

### 1. Sistema Híbrido con Handles (Optimización)
> **Ubicación:** `/Handles-Optimization`

Implementación avanzada que combina un **Árbol Binario de Búsqueda (ABB)** con una **Lista Enlazada** utilizando el concepto de *"Handles"* (punteros inteligentes o referencias directas).

* **Problema:** Un sistema de pedidos (`SistemaPedidos`) que requiere acceso eficiente por doble criterio: orden de llegada (cola) e identificador único (búsqueda).
* **Solución Técnica:**
    * Modificación del ABB para retornar un `Handle` al insertar un elemento.
    * El `Handle` permite acceso y eliminación en **$O(1)$** sin necesidad de volver a buscar el nodo en el árbol.
    * Los identificadores asumen una distribución aleatoria, garantizando un balanceo promedio de **$O(\log n)$**.

### 2. Árbol Binario de Búsqueda (BST)
> **Ubicación:** `/Binary-Search-Tree` (Basado en Taller 4)

Implementación de un **Conjunto (Set)** genérico utilizando nodos enlazados dinámicamente.

* **Lógica:** Estructura recursiva donde cada nodo mantiene la invariante de orden: `izq < actual < der`.
* **Features:**
    * Soporte para cualquier tipo de dato `Comparable<T>`.
    * Operaciones de conjunto: `insertar`, `pertenece`, `eliminar`, `minimo`, `maximo`.
    * Implementación de un `Iterador<T>` para recorrer la estructura in-order.

### 3. Lista Doblemente Enlazada
> **Ubicación:** `/Doubly-Linked-List` (Basado en Taller 3)

Estructura lineal dinámica donde cada nodo mantiene referencias explícitas a su antecesor y sucesor.

* **Diseño:** Implementa la interfaz `Secuencia<T>`.
* **Features:**
    * Punteros a `first` y `last` para inserciones eficientes al principio y al final.
    * **Iterador Bidireccional:** Permite recorrer la lista con `siguiente()` y `anterior()`.
    * Operaciones posicionales: `obtener(i)`, `eliminar(i)`, `modificarPosicion(i)`.

---

## 📂 Organización del Repositorio

Cada carpeta contiene el código fuente (`src`), los tests unitarios correspondientes y la documentación de la consigna original.

```bash
├── Handles-Optimization/  # Taller 5: Handles & SistemaPedidos
│   ├── src/main/java/     # Código: ABB.java, SistemaPedidos.java, Handle.java
│   └── enunciado_5.pdf    # Consigna
│
├── Binary-Search-Tree/    # Taller 4: Conjunto sobre ABB
│   ├── src/main/java/     # Código: ABB.java, Conjunto.java
│   └── enunciado_4.pdf    # Consigna
│
└── Doubly-Linked-List/    # Taller 3: Lista Doblemente Enlazada
    ├── src/main/java/     # Código: ListaEnlazada.java, Secuencia.java
    └── enunciado_3.pdf    # Consigna
