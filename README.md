# Conversor de Monedas

![Java Version](https://img.shields.io/badge/Java-17.0.10-orange) ![Status](https://img.shields.io/badge/Status-Terminado-brightgreen)

Una aplicación de línea de comandos (CLI) eficiente para realizar conversiones de divisas, conectándose directamente a tasas de cambio del API.

## Descripción

Este proyecto permite a los usuarios convertir montos entre diferentes divisas internacionales. A diferencia de las calculadoras estáticas, este programa obtiene los datos en tiempo real mediante **ExchangeRate-API**, garantizando que las conversiones sean precisas.

El sistema cuenta con un menú interactivo y un historial de operaciones para llevar un registro de las consultas realizadas durante la sesión.

## Estado del Proyecto

**Terminado:** El proyecto cumple con todas sus funcionalidades principales y está listo para su uso inmediato.

## Configuración de la API (Importante)

**¡El proyecto está listo para usar!**
La aplicación incluye una **API Key por defecto** configurada para que puedas probar el programa sin necesidad de registrarte.

Sin embargo, si experimentas problemas de conexión o deseas usar tu propia cuenta (por límites de cuota), puedes cambiarla fácilmente:

1.  Navega al paquete: `Data`
2.  Abre la clase: `API`
3.  Busca la variable de la clave y reemplázala con tu propia API Key de [ExchangeRate-API](https://www.exchangerate-api.com/).

## Requisitos e Instalación

Para ejecutar este proyecto necesitas:

* **Java JDK:** Versión 17.0.10 o superior.
* **Librería Gson:** Versión 2.13.2 (para el manejo de JSON).
* **Conexión a Internet.**

### Pasos para ejecutar
1. Clona el repositorio.
2. Agrega el archivo `.jar` de Gson a las librerías/dependencias de tu proyecto.
3. Compila y ejecuta la clase principal.

## Uso

Al ejecutar la aplicación, verás un menú interactivo con 3 opciones:

1. **Hacer una conversión:** Elige entre 12 divisas diferentes (MXN, USD, EUR, etc.), ingresa tu monto y obtén el resultado al instante.
   
2. **Mostrar el historial:** Visualiza una lista de todas las conversiones que has realizado desde que abriste el programa. Si es tu primera vez, te invitará a probar el conversor.

3. **Salir:** Cierra la aplicación.

### Ejemplo Visual
```text
===========================================
           CONVERSOR DE MONEDAS
===========================================

--- Qué deseas realizar? -----

1) Usar el conversor
2) Ver el historial de conversiones
3) Salir

Opción: 1

 - Elija la base a convertir:

1) Dolar (USD)
2) Pesos mexicanos (MXN)
3) Pesos argentinos (ARS)
4) Pesos colombianos (COP)
5) Reales brasileños (BRL)
6) Euro (EUR)
7) Yen japonés (JPY)
8) Libra esterlina (GBP)
9) Yuan chino (CNY)
10) Franco Suizo (CHF)
11) Dolar canadiense (CAD)
12) Dolar australiano (AUD)

Opcion a elegir: 2
Elija la el monto de la base a convertir: $1500

- Elija el objetivo a convertir (excepto el numero 2):

1) Dolar (USD)
2) Pesos mexicanos (MXN)
3) Pesos argentinos (ARS)
4) Pesos colombianos (COP)
5) Reales brasileños (BRL)
6) Euro (EUR)
7) Yen japonés (JPY)
8) Libra esterlina (GBP)
9) Yuan chino (CNY)
10) Franco Suizo (CHF)
11) Dolar canadiense (CAD)
12) Dolar australiano (AUD)

Opcion a elegir: 1

Espere un momento...

-----------------------------------------------------
Cambiaste $1500.0(MXN) a $83.235(USD). El dia 2025-12-20
-----------------------------------------------------

--- Qué deseas realizar? -----

1) Usar el conversor
2) Ver el historial de conversiones
3) Salir

Opción: 
