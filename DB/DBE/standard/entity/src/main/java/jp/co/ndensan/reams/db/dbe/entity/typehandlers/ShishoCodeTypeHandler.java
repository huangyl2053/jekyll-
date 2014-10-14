package jp.co.ndensan.reams.db.dbe.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShishoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class ShishoCodeTypeHandler extends BaseTypeHandler<ShishoCode> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ShishoCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ShishoCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new ShishoCode(getResultRString(rs.getString(columnName)));
    }

    @Override
    public ShishoCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new ShishoCode(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public ShishoCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new ShishoCode(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }

// </editor-fold>
}
