# Spring Boot Docker Compose Demo

Dieses Projekt demonstriert die Verwendung von Docker Compose für Spring Boot Development basierend auf dem Technical Guide.

## Prerequisites

- Docker Desktop
- Java 21
- Maven 3.9+

## Quick Start

1. Environment-Variablen einrichten:
```bash
cp .env.example .env
```

2. Alle Services starten:
```bash
docker-compose up --build
```

3. API testen:
```bash
curl http://localhost:8080/api/users
```

## Verfügbare Commands
```bash
# Services starten
docker-compose up

# Services im Hintergrund starten
docker-compose up -d

# Services stoppen
docker-compose down

# Services neu bauen
docker-compose up --build

# Logs anzeigen
docker-compose logs -f

# Einzelnen Service neu starten
docker-compose restart postgres

# Alles löschen (inkl. Volumes)
docker-compose down -v
```

## Tests ausführen
```bash
./mvnw test
```

## Debugging

Die Applikation ist auf Port 5005 für Remote Debugging erreichbar.

IntelliJ IDEA:
1. Run → Edit Configurations
2. Add → Remote JVM Debug
3. Host: localhost, Port: 5005

## Datenbank Zugriff
```bash
# PostgreSQL Shell
docker-compose exec postgres psql -U springuser -d springapp

# Redis CLI
docker-compose exec redis redis-cli
```

## API Endpoints

- `GET /api/users` - Alle User
- `GET /api/users/{id}` - User by ID
- `GET /api/users/username/{username}` - User by Username
- `POST /api/users` - User erstellen

## Troubleshooting

### Port bereits belegt
```bash
# Prozess finden
lsof -i :8080
# Oder anderen Port verwenden
```

### Container startet nicht
```bash
docker-compose logs app
```

### Datenbank-Connection Fehler
```bash
docker-compose ps
docker-compose exec app ping postgres
```

## Projektstruktur
```
.
├── docker-compose.yml          # Docker Services Konfiguration
├── Dockerfile.dev              # Development Dockerfile
├── .env.example                # Environment Variablen Template
├── init-scripts/               # PostgreSQL Init Scripts
│   └── init.sql
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/example/demo/
    │   │       ├── entity/
    │   │       ├── repository/
    │   │       └── controller/
    │   └── resources/
    │       ├── application.yml
    │       ├── application-docker.yml
    │       └── db/migration/
    └── test/
        ├── java/
        └── resources/
```
