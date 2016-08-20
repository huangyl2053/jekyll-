package jp.co.ndensan.reams.db.dbz.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 主治医医療機関コードのTypeHandlerです。
 *
 * @reamsid_L DBZ-9999-010 sunhaidi
 */
public class ShujiiIryokikanCodeTypeHandler extends BaseTypeHandler<ShujiiIryokikanCode> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ShujiiIryokikanCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ShujiiIryokikanCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new ShujiiIryokikanCode(getResultRString(rs.getString(columnName)));
    }

    @Override
    public ShujiiIryokikanCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new ShujiiIryokikanCode(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public ShujiiIryokikanCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new ShujiiIryokikanCode(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }

// </editor-fold>
}
