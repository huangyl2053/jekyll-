package jp.co.ndensan.reams.db.dbe.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業者番号のTypeHandlerです。
 *
 * @author n8178 城間篤人
 */
public class JigyoshaNoTypeHandler extends BaseTypeHandler<JigyoshaNo> {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JigyoshaNo parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public JigyoshaNo getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new JigyoshaNo(getResultRString(rs.getString(columnName)));
    }

    @Override
    public JigyoshaNo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new JigyoshaNo(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public JigyoshaNo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new JigyoshaNo(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }
// </editor-fold>
}
