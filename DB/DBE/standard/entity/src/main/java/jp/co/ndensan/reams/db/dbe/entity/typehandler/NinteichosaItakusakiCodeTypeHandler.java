package jp.co.ndensan.reams.db.dbe.entity.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItakusakiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class NinteichosaItakusakiCodeTypeHandler extends BaseTypeHandler<NinteichosaItakusakiCode> {
// <editor-fold defaultstate="collapsed" desc="Generated Code">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, NinteichosaItakusakiCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public NinteichosaItakusakiCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new NinteichosaItakusakiCode(getResultRString(rs.getString(columnName)));
    }

    @Override
    public NinteichosaItakusakiCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new NinteichosaItakusakiCode(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public NinteichosaItakusakiCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new NinteichosaItakusakiCode(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }

// </editor-fold>
}
