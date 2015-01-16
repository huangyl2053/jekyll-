package jp.co.ndensan.reams.db.dbz.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class ShichosonCodeTypeHandler extends BaseTypeHandler<ShichosonCode> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ShichosonCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ShichosonCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new ShichosonCode(getResultRString(rs.getString(columnName)));
    }

    @Override
    public ShichosonCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new ShichosonCode(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public ShichosonCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new ShichosonCode(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }

// </editor-fold>
}
