# ASCII Dungeon Crawler (Java)

A simple backend for a text-based dungeon crawler in Java. The game features randomly generated dungeon rooms, monsters, and a basic combat engine. The project is designed with separation between backend logic (entities, combat, dungeon generation) and potential frontend interfaces (console, GUI, or web).

## Features

### Random Dungeon Generation:
 * Rooms are randomly generated with unique descriptions for each run.

### Monster System:

 * Monsters have stats: health, attack, strength, defence

 * Each monster has ASCII artwork for display

 * MonsterFactory allows easy addition of new monsters

### Player System:

 * Player entity with health, attack, strength, defence

 * Methods for taking damage and checking alive status

### Combat Engine:

 * Turn-based combat between player and monster

 * Hit chance and damage calculation based on attack, strength, and defence

 * Flexible design for adding new player abilities and monster attacks