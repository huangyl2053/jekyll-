package jp.co.ndensan.reams.db.dbe.entity.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ChosainBangoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class ChosainBangoCodeTypeHandler extends BaseTypeHandler<ChosainBangoCode> {
// <editor-fold defaultstate="collapsed" desc="Generated Code">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ChosainBangoCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ChosainBangoCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new ChosainBangoCode(getResultRString(rs.getString(columnName)));
    }

    @Override
    public ChosainBangoCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new ChosainBangoCode(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public ChosainBangoCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new ChosainBangoCode(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }

// </editor-fold>
}
