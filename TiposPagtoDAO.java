import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoPagamentoDAO {
    private Connection conexao;

    public TipoPagamentoDAO() {
        try {
            conexao = ConexaoBD.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para adicionar um novo tipo de pagamento
    public void adicionarTipoPagamento(TipoPagamento tipoPagamento) {
        String sql = "INSERT INTO TIPO_PAGTO (COD_PAGTO, DESC_PAGTO) VALUES (?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, tipoPagamento.getCodPagto());
            stmt.setString(2, tipoPagamento.getDescPagto());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um tipo de pagamento existente
    public void atualizarTipoPagamento(TipoPagamento tipoPagamento) {
        String sql = "UPDATE TIPO_PAGTO SET DESC_PAGTO=? WHERE COD_PAGTO=?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tipoPagamento.getDescPagto());
            stmt.setInt(2, tipoPagamento.getCodPagto());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um tipo de pagamento existente
    public void excluirTipoPagamento(int codPagto) {
        String sql = "DELETE FROM TIPO_PAGTO WHERE COD_PAGTO=?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codPagto);

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para recuperar um tipo de pagamento pelo código
    public TipoPagamento recuperarTipoPagamento(int codPagto) {
        TipoPagamento tipoPagamento = null;
        String sql = "SELECT * FROM TIPO_PAGTO WHERE COD_PAGTO=?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codPagto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tipoPagamento = new TipoPagamento();
                tipoPagamento.setCodPagto(rs.getInt("COD_PAGTO"));
                tipoPagamento.setDescPagto(rs.getString("DESC_PAGTO"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipoPagamento;
    }
}
