# Magician Manager
Simple GUI software for the management/analysis of a pokemon card collection. 
Supports 4 types of cards:
- Pokémon cards
- Energy cards
- Item cards
- Supporter cards
Each card has its own attributes and power calculation.
## Project Structure
```
src/
├── domain/              # Domain model (Card and subclasses)
│   ├── Card
│   ├── PokemonCard
│   ├── EnergyCard
│   ├── ItemCard
│   └── SupporterCard
│
├── gui/                 # Swing user interface
│   ├── Menu
│   ├── EditorPanel (interface)
│   ├── EditorPanel implementations
│   └── DropdownCardSelection
│
├── factory/             # Factory pattern implementations
│   ├── CardFactory
│   └── EditorPanelFactory
│
├── strategy/            # Sorting strategies
│   ├── SortingStrategy
│   ├── SortByNameStrategy
│   ├── SortByPowerStrategy
│   └── SortByRarityStrategy
│
├── visitor/             # Visitor pattern (saving system)
│   ├── CardVisitor
│   └── SaveVisitor
│
├── logic/               # Application control layer
│   ├── App
│   ├── AppSystem
│   └── AppSystemImpl
│
└── data/                # Persistent storage
    ├── Sobres.txt      # Saved card data
    └── images/         # Card images
```
## How to Run:

### 1. Requirements
- Java JDK 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans) or terminal

---

### 2. Compile and Run

#### Using an IDE (recommended)
1. Import the project as a Java project
2. Ensure `src` is marked as the source folder
3. Run the `App` class located in logic.App;
---

### Using Terminal


#### Linux/Macos:
```
cd path/to/Taller-4/
mkdir -p bin
find src -name "*.java" > sources.txt
javac -d bin @sources.txt
java -cp bin logic.App
```
#### Windows (Powershell):
```
cd path/to/Taller-4/
mkdir bin
dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt
java -cp bin logic.App
```
## IMPORTANT:
Images must be stored in the data/ folder with the same name as the card.
If no image is found, a default image is used.
