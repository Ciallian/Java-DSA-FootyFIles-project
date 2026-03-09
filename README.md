# 🎲 Farkle Game - Full Stack Web Application

A modern, full-stack web application for the classic Farkle dice game, built with React frontend and Java Spring Boot backend. This project demonstrates clean architecture, RESTful API design, and seamless frontend-backend communication.

## 📋 Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Frontend Architecture](#frontend-architecture)
- [Backend Architecture](#backend-architecture)
- [Frontend-Backend Communication](#frontend-backend-communication)
- [API Documentation](#api-documentation)
- [Getting Started](#getting-started)
- [Development Workflow](#development-workflow)
- [Deployment](#deployment)
- [Contributing](#contributing)
- [Conventional Commits](#conventional-commits)

## 🎯 Overview

Farkle is a classic dice game where players roll dice to score points based on specific combinations. This implementation provides:

- **Real-time multiplayer support** (planned)
- **Responsive web interface** with modern UI/UX
- **RESTful API** for game state management
- **Scalable architecture** for future enhancements
- **Cross-platform compatibility** (web, mobile-responsive)

## 🏗️ Architecture

### High-Level Architecture

```
┌─────────────────┐    HTTP/REST    ┌─────────────────┐
│   React Frontend │ ◄─────────────► │  Spring Boot    │
│   (Port 3000)   │                 │   Backend       │
│                 │                 │  (Port 8080)    │
│  - UI Components│                 │                 │
│  - State Mgmt   │                 │  - Controllers  │
│  - API Calls    │                 │  - Services     │
│  - User Input   │                 │  - Models       │
└─────────────────┘                 └─────────────────┘
```

### Communication Flow

1. **User Interaction** → React Component
2. **API Call** → Axios HTTP Request
3. **Proxy** → React Dev Server (localhost:3000 → localhost:8080)
4. **Backend Processing** → Spring Boot Controller → Service
5. **Response** → JSON Data
6. **UI Update** → React State Update → Re-render

## 🛠️ Tech Stack

### Frontend
- **React 18.2.0** - UI library
- **Axios 1.6.0** - HTTP client
- **CSS3** - Styling with modern features
- **JavaScript ES6+** - Modern JavaScript features

### Backend
- **Java 17** - Programming language
- **Spring Boot 3.2.0** - Application framework
- **Spring Web** - REST API support
- **Spring Data JPA** - Data persistence
- **H2 Database** - In-memory database (development)
- **Maven** - Build tool

### Development Tools
- **Maven Daemon (mvnd)** - Faster Maven builds
- **React Scripts** - Development server
- **Git** - Version control
- **Docker** - Containerization (optional)

## 📁 Project Structure

```
Farkle/
├── 📁 backend/                          # Java Spring Boot API
│   ├── 📁 src/main/java/com/farkle/
│   │   ├── 🎯 FarkleApplication.java    # Main Spring Boot class
│   │   ├── 📁 controller/               # REST API Controllers
│   │   │   ├── 🎮 GameController.java  # Game API endpoints
│   │   │   └── 🔢 CounterController.java # Demo counter endpoints
│   │   ├── 📁 model/                    # Data Models
│   │   │   ├── 🎲 Game.java            # Game state model
│   │   │   └── 👤 Player.java          # Player model
│   │   └── 📁 service/                  # Business Logic
│   │       └── 🎯 GameService.java      # Game logic service
│   ├── 📄 pom.xml                       # Maven dependencies
│   └── 📁 target/                       # Compiled classes
├── 📁 frontend/                         # React Application
│   ├── 📁 public/
│   │   └── 📄 index.html                # HTML template
│   ├── 📁 src/
│   │   ├── 📁 components/               # React Components
│   │   │   ├── 🔢 Counter.js           # Counter demo component
│   │   │   └── 🎨 Counter.css          # Counter styles
│   │   ├── 📁 services/                 # API Services
│   │   │   └── 🌐 gameService.js       # API communication
│   │   ├── 🎯 App.js                    # Main App component
│   │   ├── 🎨 App.css                   # App styles
│   │   ├── 📄 index.js                  # React entry point
│   │   └── 🎨 index.css                 # Global styles
│   ├── 📄 package.json                  # NPM dependencies
│   └── 📁 node_modules/                 # NPM packages
├── 📄 docker-compose.yml                # Docker configuration
├── 📄 .gitignore                        # Git ignore rules
├── 📄 SETUP.md                          # Detailed setup guide
└── 📄 README.md                         # This file
```

## 🎨 Frontend Architecture

### Component Hierarchy

```
App
├── Header (Game Title)
├── Counter (Demo Component)
│   ├── CounterDisplay
│   ├── CounterButtons
│   └── CounterInfo
└── GameLogicInfo
```

### Key Frontend Concepts

#### 1. **Component-Based Architecture**
- **Functional Components** with React Hooks
- **Props** for data flow between components
- **State Management** using `useState` and `useEffect`
- **Event Handling** for user interactions

#### 2. **API Communication**
```javascript
// Example API call pattern
const fetchData = async () => {
  try {
    setLoading(true);
    const response = await axios.get('/api/endpoint');
    setData(response.data);
  } catch (error) {
    setError('Failed to fetch data');
  } finally {
    setLoading(false);
  }
};
```

#### 3. **Styling Approach**
- **CSS Modules** for component-specific styles
- **Responsive Design** with CSS Grid and Flexbox
- **Modern CSS Features** (backdrop-filter, gradients, animations)
- **Glassmorphism Design** for modern UI aesthetics

#### 4. **State Management Pattern**
```javascript
const [state, setState] = useState(initialValue);
const [loading, setLoading] = useState(false);
const [error, setError] = useState(null);
```

## ⚙️ Backend Architecture

### Layered Architecture

```
┌─────────────────┐
│   Controllers   │ ← REST API Layer
├─────────────────┤
│    Services     │ ← Business Logic Layer
├─────────────────┤
│     Models      │ ← Data Layer
└─────────────────┘
```

### Key Backend Concepts

#### 1. **RESTful API Design**
- **GET** `/api/counter` - Retrieve current value
- **POST** `/api/counter/increment` - Increment counter
- **POST** `/api/counter/reset` - Reset counter
- **JSON** request/response format
- **HTTP Status Codes** for proper error handling

#### 2. **Spring Boot Annotations**
```java
@RestController          // Marks class as REST controller
@RequestMapping("/api")  // Base URL mapping
@CrossOrigin            // CORS configuration
@Autowired             // Dependency injection
@Service              // Marks class as service
```

#### 3. **Dependency Injection**
- **Constructor Injection** for services
- **Spring Context** manages object lifecycle
- **Loose Coupling** between components

#### 4. **Error Handling**
- **Global Exception Handling** (planned)
- **HTTP Status Codes** (200, 404, 500)
- **JSON Error Responses**

## 🔄 Frontend-Backend Communication

### Request Flow

1. **User Action** (button click)
2. **React Event Handler** triggers
3. **Axios HTTP Request** to `/api/endpoint`
4. **React Dev Server Proxy** forwards to `localhost:8080`
5. **Spring Boot Controller** receives request
6. **Service Layer** processes business logic
7. **JSON Response** sent back
8. **React State Update** triggers re-render

### Proxy Configuration

```json
// frontend/package.json
{
  "proxy": "http://localhost:8080"
}
```

This allows frontend to call `/api/counter` which gets proxied to `http://localhost:8080/api/counter`.

### CORS Configuration

```java
@CrossOrigin(origins = "http://localhost:3000")
```

Allows React app (port 3000) to communicate with Spring Boot (port 8080).

## 📚 API Documentation

### Counter API (Demo)

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| GET | `/api/counter` | Get current counter value | None | `{ "value": 5 }` |
| POST | `/api/counter/increment` | Increment counter by 1 | None | `{ "value": 6 }` |
| POST | `/api/counter/reset` | Reset counter to 0 | None | `{ "value": 0 }` |

### Game API (Planned)

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| POST | `/api/game/create` | Create new game | `["Player1", "Player2"]` | `Game` object |
| GET | `/api/game/{id}` | Get game state | None | `Game` object |
| POST | `/api/game/{id}/roll` | Roll dice | None | `Game` object |
| POST | `/api/game/{id}/score` | Score roll | `[1,2,3,4,5,6]` | `Game` object |

## 🚀 Getting Started

### Prerequisites

- **Java 17+** - [Download](https://adoptium.net/)
- **Node.js 16+** - [Download](https://nodejs.org/)
- **Maven or mvnd** - [Download](https://maven.apache.org/)
- **Git** - [Download](https://git-scm.com/)

### Quick Start

#### 1. Clone Repository
```bash
git clone <repository-url>
cd Farkle
```

#### 2. Start Backend
```bash
cd backend
mvnd spring-boot:run
# Wait for: "Tomcat started on port 8080"
```

#### 3. Start Frontend (New Terminal)
```bash
cd frontend
npm install
npm start
# Opens http://localhost:3000
```

#### 4. Test Application
- Open http://localhost:3000
- Click "Increment" button
- Verify counter increases
- Test "Reset" and "Refresh" buttons

### Detailed Setup

See [SETUP.md](SETUP.md) for comprehensive setup instructions.

## 🔧 Development Workflow

### Backend Development

1. **Make Changes** to Java files in `backend/src/main/java/`
2. **Auto-restart** (Spring Boot DevTools)
3. **Test API** using Postman or curl
4. **Check Logs** in terminal

### Frontend Development

1. **Make Changes** to React components
2. **Hot Reload** (React Dev Server)
3. **Browser Updates** automatically
4. **Check Console** for errors

### Full-Stack Testing

1. **Backend Running** on port 8080
2. **Frontend Running** on port 3000
3. **API Calls** work through proxy
4. **Real-time Updates** in browser

## 🚀 Deployment

### Development
- Backend: `mvnd spring-boot:run`
- Frontend: `npm start`

### Production Build
```bash
# Backend
cd backend
mvnd clean package
java -jar target/farkle-backend-1.0.0.jar

# Frontend
cd frontend
npm run build
# Serve build/ directory
```

### Docker Deployment
```bash
docker-compose up --build
```

## 🤝 Contributing

### Git Workflow

1. **Fork** the repository
2. **Create Feature Branch**: `git checkout -b feature/amazing-feature`
3. **Commit Changes**: `git commit -m "feat: add amazing feature"`
4. **Push Branch**: `git push origin feature/amazing-feature`
5. **Create Pull Request`

### Code Standards

- **Java**: Follow Spring Boot conventions
- **JavaScript**: Use ES6+ features, functional components
- **CSS**: Use modern CSS, responsive design
- **Commits**: Follow conventional commit format

## 📝 Conventional Commits

This project follows the [Conventional Commits](https://www.conventionalcommits.org/) specification for commit messages.

### Type Prefixes
- `feat:` - A new feature
- `fix:` - A bug fix
- `docs:` - Documentation only changes
- `style:` - Changes that do not affect the meaning of the code
- `refactor:` - A code change that neither fixes a bug nor adds a feature
- `perf:` - A code change that improves performance
- `test:` - Adding missing tests or correcting existing tests
- `build:` - Changes that affect the build system or external dependencies
- `ci:` - Changes to our CI configuration files and scripts
- `chore:` - Other changes that don't modify src or test files
- `revert:` - Reverts a previous commit

### Examples
```
feat: add user authentication system
fix: resolve memory leak in data processing
docs: update API documentation
style: format code according to project standards
refactor: simplify user validation logic
perf: optimize database queries
test: add unit tests for payment module
build: update webpack configuration
ci: add automated testing pipeline
chore: update dependencies
revert: revert "feat: add new dashboard"
```

### Breaking Changes
Use `!` after the type/scope to indicate a breaking change:
```
feat!: remove deprecated API endpoints
fix!: change default behavior of user creation
```

### Scope (Optional)
You can optionally specify a scope after the type:
```
feat(auth): add OAuth2 integration
fix(ui): correct button alignment issue
docs(api): update endpoint documentation
```

## 🎯 Future Enhancements

### Planned Features
- **Real-time Multiplayer** with WebSockets
- **User Authentication** and profiles
- **Game History** and statistics
- **Mobile App** with React Native
- **Advanced Scoring** rules and animations
- **Tournament Mode** with brackets
- **AI Players** for single-player mode

### Technical Improvements
- **Database Integration** (PostgreSQL)
- **Caching Layer** (Redis)
- **API Rate Limiting**
- **Comprehensive Testing** (Unit, Integration, E2E)
- **CI/CD Pipeline**
- **Monitoring and Logging**

## 📞 Support

- **Issues**: Create GitHub issues for bugs or feature requests
- **Discussions**: Use GitHub Discussions for questions
- **Documentation**: Check SETUP.md for detailed instructions

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

**Happy Coding! 🎲✨**

*Built with ❤️ using React and Spring Boot*#   J a v a - D S A - F o o t y F I l e s - p r o j e c t  
 