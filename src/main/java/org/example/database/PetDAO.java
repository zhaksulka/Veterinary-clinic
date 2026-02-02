package database;

import model.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

    public void insertPet(Pet pet) {
        String sql = "INSERT INTO pets (name, species, age, owner_name) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getSpecies());
            stmt.setInt(3, pet.getAge());
            stmt.setString(4, pet.getOwnerName());

            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Pet inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllPets() {
        String sql = "SELECT * FROM pets";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n--- ALL PETS ---");
            while (rs.next()) {
                Pet pet = extractPet(rs);
                System.out.println(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updatePet(Pet pet) {
        String sql = "UPDATE pets SET name = ?, species = ?, age = ?, owner_name = ? WHERE pet_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getSpecies());
            stmt.setInt(3, pet.getAge());
            stmt.setString(4, pet.getOwnerName());
            stmt.setInt(5, pet.getPetId());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Pet updated successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletePet(int petId) {
        String sql = "DELETE FROM pets WHERE pet_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, petId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Pet deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Pet getPetById(int petId) {
        String sql = "SELECT * FROM pets WHERE pet_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, petId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return extractPet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // --- SEARCH METHODS ---
    public List<Pet> searchByName(String name) {
        return searchByColumn("name", name);
    }

    public List<Pet> searchBySpecies(String species) {
        return searchByColumn("species", species);
    }

    public List<Pet> searchByOwnerName(String owner) {
        return searchByColumn("owner_name", owner);
    }

    public List<Pet> searchByAgeRange(int minAge, int maxAge) {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE age BETWEEN ? AND ? ORDER BY age DESC";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, minAge);
            stmt.setInt(2, maxAge);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) pets.add(extractPet(rs));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    public List<Pet> searchByMinAge(int minAge) {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE age >= ? ORDER BY age DESC";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, minAge);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) pets.add(extractPet(rs));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // --- HELPER ---
    private List<Pet> searchByColumn(String column, String value) {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE " + column + " ILIKE ? ORDER BY name";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, "%" + value + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) pets.add(extractPet(rs));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    private Pet extractPet(ResultSet rs) throws SQLException {
        return new Pet(
                rs.getInt("pet_id"),
                rs.getString("name"),
                rs.getString("species"),
                rs.getInt("age"),
                rs.getString("owner_name")
        );
    }
}
