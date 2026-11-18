# 🐍🪜 Serpientes y Escaleras — Java

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![Maven](https://img.shields.io/badge/Build-Maven-blue?logo=apachemaven)
![JUnit](https://img.shields.io/badge/Tests-JUnit%205-25A162?logo=junit5)
![Estado](https://img.shields.io/badge/Estado-En%20desarrollo-blue)

Juego de mesa clásico **Serpientes y Escaleras** para 2 a 4 jugadores, implementado en Java con interfaz gráfica (Swing), desarrollado como proyecto académico — Universidad Libre.

---

## 📋 Contenido

- [Descripción general](#-descripción-general)
- [Componentes técnicos](#-componentes-técnicos)
- [Arquitectura](#-arquitectura)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Cómo ejecutar](#-cómo-ejecutar)
- [Pruebas](#-pruebas)
- [Documentación](#-documentación)
- [Autores](#-autores)

---

## 🎮 Descripción general

El sistema simula una partida de Serpientes y Escaleras sobre un tablero de 100 casillas. Cada jugador lanza un dado por turnos y avanza su ficha con una animación casilla por casilla; si cae en la cabeza de una serpiente retrocede hasta su cola, y si cae en el inicio de una escalera avanza hasta su final. Gana el primer jugador en llegar exactamente a la casilla 100.

**Características principales:**
- Menú de configuración inicial (2 a 4 jugadores, nombres personalizados)
- Tablero gráfico con numeración en zigzag y serpientes/escaleras dibujadas
- Animación de movimiento ficha por ficha
- Dado visual con puntos (como un dado real)
- Registro de mensajes de cada turno
- Detección automática del ganador

## 🛠 Componentes técnicos

| Componente | Tecnología |
|---|---|
| Lenguaje | Java 17 |
| Build / dependencias | Maven |
| Interfaz gráfica | Java Swing |
| Control de versiones | Git / GitHub |
| Modelado UML | Visual Paradigm |
| Prototipos de interfaz | Figma |
| Pruebas | JUnit 5 |

## 🏗 Arquitectura

El proyecto sigue el patrón **MVC (Modelo - Vista - Controlador)**:

- **`modelo/`** — lógica del juego: `Tablero`, `Jugador`, `Dado`, `Serpiente`, `Escalera`, `Partida`, `EstadoPartida`
- **`vista/`** — interfaz gráfica en Swing: `VentanaPrincipal`, `PanelConfiguracion`, `PanelJuego`, `PanelTablero`, `PanelControles`, `PanelDado`
- **`controlador/`** — conecta la vista con el modelo: `ControladorConfiguracion`, `ControladorJuego`

## 📁 Estructura del proyecto

```
src/
├── main/java/co/unilibre/edu/serpientesyescaleras/
│   ├── modelo/
│   ├── vista/
│   ├── controlador/
│   └── Main.java
└── test/java/co/unilibre/edu/serpientesyescaleras/
    └── modelo/
docs/
├── requerimientos.md
├── diagrama_clases.png
└── mockups/
```

## ▶️ Cómo ejecutar

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="co.unilibre.edu.serpientesyescaleras.Main"
```

También puedes ejecutar `Main.java` directamente desde IntelliJ (clic derecho → Run).

## ✅ Pruebas

El paquete `modelo` cuenta con pruebas unitarias (JUnit 5) que cubren el dado, los jugadores, el tablero (movimiento, serpientes y escaleras) y la partida (turnos y condición de victoria).

```bash
mvn test
```

Detalle completo en la [página de Pruebas Unitarias](../../wiki/Pruebas-Unitarias) de la Wiki.

## 📚 Documentación

- [Requerimientos](docs/requerimientos.md) · también en [Wiki](../../wiki/Requerimientos)
- [Diagrama de clases](docs/diagrama_clases.png) · también en [Wiki](../../wiki/Diagrama-de-Clases)
- [Pruebas Unitarias](../../wiki/Pruebas-Unitarias)
- Prototipos de interfaz: `docs/mockups/` y [Figma]([pega-aquí-tu-link-de-figma](https://www.figma.com/design/YdbpRlw0iWz5WB3BuVxiUd/Serpientes-Y-Escaleras-Prototipos?node-id=0-1&t=9dKyjs81UGXwQbKK-1))

## 👥 Autores

- Andrés Felipe Fonseca Ardila
- Andrés Felipe Mambuscay Reyes

---

🔵 **Estado del proyecto:** en desarrollo — avance 2: lógica del juego, interfaz gráfica funcional, animaciones y pruebas unitarias completas.
