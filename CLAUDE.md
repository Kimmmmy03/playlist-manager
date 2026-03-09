# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

A **Playlist Manager** — a BlueJ Java project demonstrating a doubly linked list data structure. Users can add, display, and remove songs via a console menu.

## Build & Run

This is a BlueJ project (no build tool like Maven/Gradle). To compile and run from the command line:

```bash
javac *.java
java Main
```

## Architecture

Four classes, no packages — all in the default package:

- **Song** — Data class holding `title` and `artist`.
- **Node** — Doubly linked list node wrapping a `Song` (has `next`/`prev` pointers).
- **Playlist** — Doubly linked list of `Node`s (`head`/`tail`). Operations: `addSong` (append to tail), `removeSong` (by title, case-insensitive), `displayPlaylist` (traverse head to tail).
- **Main** — Console UI with a `Scanner`-driven menu loop (add, display, remove, exit).
