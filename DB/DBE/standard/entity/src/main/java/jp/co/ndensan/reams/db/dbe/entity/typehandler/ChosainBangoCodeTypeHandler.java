package jp.co.ndensan.reams.db.dbe.entity.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosainBangoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class ChosainBangoCodeTypeHandler extends BaseTypeHandler<NinteichosainBangoCode> {
// <editor-fold defaultstate="collapsed" desc="Generated Code">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, NinteichosainBangoCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public NinteichosainBangoCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new NinteichosainBangoCode(getResultRString(rs.getString(columnName)));
    }

    @Override
    public NinteichosainBangoCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new NinteichosainBangoCode(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public NinteichosainBangoCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new NinteichosainBangoCode(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }

// </editor-fold>
}
