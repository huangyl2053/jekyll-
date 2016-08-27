package jp.co.ndensan.reams.db.dbz.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 主治医コードのTypeHandlerです。
 *
 * @reamsid_L DBZ-9999-010 sunhaidi
 */
public class ShujiiCodeTypeHandler extends BaseTypeHandler<ShujiiCode> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ShujiiCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ShujiiCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new ShujiiCode(getResultRString(rs.getString(columnName)));
    }

    @Override
    public ShujiiCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new ShujiiCode(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public ShujiiCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new ShujiiCode(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }

// </editor-fold>
}
