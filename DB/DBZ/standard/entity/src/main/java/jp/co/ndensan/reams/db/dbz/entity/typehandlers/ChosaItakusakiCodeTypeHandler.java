package jp.co.ndensan.reams.db.dbz.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class ChosaItakusakiCodeTypeHandler extends BaseTypeHandler<ChosaItakusakiCode> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ChosaItakusakiCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ChosaItakusakiCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new ChosaItakusakiCode(getResultRString(rs.getString(columnName)));
    }

    @Override
    public ChosaItakusakiCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new ChosaItakusakiCode(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public ChosaItakusakiCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new ChosaItakusakiCode(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }

// </editor-fold>
}
