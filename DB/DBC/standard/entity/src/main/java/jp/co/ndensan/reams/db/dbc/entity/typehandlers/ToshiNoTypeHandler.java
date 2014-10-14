package jp.co.ndensan.reams.db.dbc.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class ToshiNoTypeHandler extends BaseTypeHandler<ToshiNo> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ToshiNo parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ToshiNo getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new ToshiNo(getResultRString(rs.getString(columnName)));
    }

    @Override
    public ToshiNo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new ToshiNo(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public ToshiNo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new ToshiNo(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }

// </editor-fold>
}
