package dao;

import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conn;

 
    public ClienteDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/meu_banco", "meu_usuario", "minha_senha");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, cpf, email, telefone, salario, carro_desejado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setDouble(5, cliente.getSalario());
            stmt.setString(6, cliente.getCarroDesejado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setSalario(rs.getDouble("salario"));
                cliente.setCarroDesejado(rs.getString("carro_desejado"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }


}
