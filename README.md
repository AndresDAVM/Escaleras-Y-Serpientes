# Serpientes y Escaleras — Java

Juego de mesa clásico "Serpientes y Escaleras" para 2 a 4 jugadores, implementado en Java con interfaz gráfica (Swing), desarrollado como proyecto académico — Universidad Libre.

## Autores
- Andrés Felipe Fonseca Ardila
- Andrés Felipe Mambuscay Reyes

## Descripción general
El sistema simula una partida de Serpientes y Escaleras sobre un tablero de 100 casillas. Cada jugador lanza un dado por turnos y avanza su ficha; si cae en la cabeza de una serpiente retrocede hasta su cola, y si cae en el inicio de una escalera avanza hasta su final. Gana el primer jugador en llegar exactamente a la casilla 100.

## Componentes técnicos
- **Lenguaje:** Java 17
- **Gestor de dependencias / build:** Maven
- **Interfaz gráfica:** Java Swing
- **Control de versiones:** Git / GitHub
- **Modelado UML:** Visual Paradigm
- **Prototipos de interfaz:** Figma
- **Pruebas:** JUnit 5

## Arquitectura
El proyecto sigue el patrón **MVC (Modelo - Vista - Controlador)**:
- `modelo/`: lógica del juego (Tablero, Jugador, Dado, Serpiente, Escalera, Partida)
- `vista/`: interfaz gráfica en Swing (VentanaPrincipal, PanelTablero, PanelControles)
- `controlador/`: conecta la vista con el modelo (ControladorJuego)

## Documentación
- [Requerimientos](docs/requerimientos.md)
- [Diagrama de clases](docs/diagrama_clases.png)
- Prototipos de interfaz: `docs/mockups/`

## Estado del proyecto
🔵 En desarrollo — Avance 1: requerimientos, vista general y diagrama de clases.

## Cómo ejecutar
\```bash
mvn clean install
mvn exec:java -Dexec.mainClass="co.unilibre.edu.serpientesyescaleras.Main"
\```