package jp.co.ndensan.reams.db.dbe.entity.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;

public class NinteichosaIraiRirekiNoTypeHandler extends BaseTypeHandler<NinteichosaIraiRirekiNo> {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, NinteichosaIraiRirekiNo parameter, JdbcType jdbcType) throws SQLException {
    }

    @Override
    public NinteichosaIraiRirekiNo getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new NinteichosaIraiRirekiNo(getResultInteger(rs.getInt(columnName)));
    }

    @Override
    public NinteichosaIraiRirekiNo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new NinteichosaIraiRirekiNo(getResultInteger(rs.getInt(columnIndex)));
    }

    @Override
    public NinteichosaIraiRirekiNo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new NinteichosaIraiRirekiNo(getResultInteger(cs.getInt(columnIndex)));
    }

    private Integer getResultInteger(Integer result) {
        return result == null ? 0 : result;
    }
// </editor-fold>
}
