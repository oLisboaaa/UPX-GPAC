import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciadorDePedidos {

    private static final String URL = "jdbc:mysql://localhost:3306/upxii";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexão estabelecida com sucesso!");

            // Adicionar lógica de manipulação de pedidos e contas aqui.

            // Exemplo de inserir uma conta no banco de dados
            Conta conta = new Conta(1, "Maria", 123456789);
            inserirConta(connection, conta);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void inserirConta(Connection connection, Conta conta) throws SQLException {
        String sql = "INSERT INTO contas (id, nome, telefone) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, conta.getNumero());
            statement.setString(2, conta.getNome());
            statement.setInt(3, conta.getTelefone());
            statement.executeUpdate();
            System.out.println("Conta inserida com sucesso!");
        }
    }
}
