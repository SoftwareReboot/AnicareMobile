# AnicareMobile# 🐾 Anicare Backend API

Anicare is a Spring Boot backend project for managing users, pets, and veterinary appointments.  
This is the **User-side MVP** version, where users can register, manage pets, and book appointments.

---

## 🚀 Features
- 👤 **User Management**  
  - Register new users  
  - Update & view user profiles  
  - Delete accounts  

- 🐶 **Pet Management**  
  - Add pets linked to users  
  - View, update, and delete pets  
  - Get all pets of a user  

- 📅 **Appointment Management**  
  - Book appointments with vets (linked to pets & users)  
  - View all appointments for a user, pet, or vet  
  - Update or cancel appointments
---

## ⚡ API Endpoints (MVP)

### Users
- `POST /api/users` → Register user  
- `GET /api/users` → Get all users  
- `GET /api/users/{id}` → Get user by ID  
- `PUT /api/users/{id}` → Update user  
- `DELETE /api/users/{id}` → Delete user  

### Pets
- `POST /api/pets` → Add pet  
- `GET /api/pets` → Get all pets  
- `GET /api/pets/{id}` → Get pet by ID  
- `PUT /api/pets/{id}` → Update pet  
- `DELETE /api/pets/{id}` → Delete pet  
- `GET /api/users/{userId}/pets` → Get pets of a user  

### Appointments
- `POST /api/pets/{petId}/appointments` → Create appointment  
- `GET /api/pets/{petId}/appointments` → Get appointments by pet  
- `GET /api/vets/{vetId}/appointments` → Get appointments by vet  
- `GET /api/appointments/{id}` → Get appointment by ID  
- `PUT /api/appointments/{id}` → Update appointment  
- `DELETE /api/appointments/{id}` → Cancel appointment  

---
