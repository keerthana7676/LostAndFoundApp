# Lost & Found Android App

## Overview

This is a simple Lost & Found Android application that allows users to report lost or found items within a community. The app stores item reports locally using SQLite database and provides features to add, view, and filter items based on their type (Lost or Found).

---

## Features

- Add lost or found items with details such as item name, location, description, and contact information.
- Store items locally using SQLite database.
- View all reported items in a list.
- Filter items by type (Lost or Found).
- Items are displayed in reverse chronological order (most recent first).

---

## Technology Stack

- **Android SDK**
- **Java**
- **SQLite** for local data storage
- XML for UI layouts

---

## Database Schema

The app uses a SQLite database named `LostFound.db` with a single table `lost_items` having the following columns:

| Column      | Type    | Description                           |
|-------------|---------|---------------------------------------|
| id          | INTEGER | Primary key, auto-incremented         |
| item_name   | TEXT    | Name of the lost/found item           |
| location    | TEXT    | Location where the item was lost/found |
| description | TEXT    | Additional details about the item     |
| contact     | TEXT    | Contact information of reporter       |
| item_type   | TEXT    | Specifies if item is "Lost" or "Found"|

---

## Usage

1. Launch the app.
2. Use the form to add details about a lost or found item.
3. Items are saved in the local SQLite database.
4. Navigate to the list screen to view all items or filter by Lost/Found.
5. Contact the person who reported the item using the contact details provided.

---

## Screenshots

| Add Lost/Found Item | View Lost Item List | View Found Item List|
|------------------|------------------|------------------|
|  ![Homescreen](https://github.com/user-attachments/assets/a601efa0-5844-4a9f-8a6a-b5ecd42c1b81)  | ![ViewLostItems](https://github.com/user-attachments/assets/8cdf9d7d-c976-4441-9211-f33df925314b) | ![ViewFoundItems](https://github.com/user-attachments/assets/fac3ae73-57a1-4c46-9561-e32322e6e35d)|


---

## How to Run

- Import the project into **Android Studio**.
- Build and run on an emulator or physical Android device.
- The database is automatically created on first launch.
- The app UI and functionality are implemented in **Java** with **XML layouts**.

---

## Notes

- Database version is set to `2`. If you update the schema, increment this version to trigger database upgrades.
- Current upgrade logic **drops** and recreates the table (data loss). Add migration logic for production use.

---

## Future Enhancements

- Sync data with a remote database or Firebase.
- Add user authentication.
- Notify users when similar lost/found items are added.
- Improve UI with animations and material components.
- Support image uploads for item reports.

---

## Author

**Keerthana N**
