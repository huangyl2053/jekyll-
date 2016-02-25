package jp.co.ndensan.reams.db.dbx.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class JigyoshaNoTypeHandler extends BaseTypeHandler<JigyoshaNo> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JigyoshaNo parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public JigyoshaNo getNullableResult(ResultSet r, String c) throws SQLException {
        return r.getString(c) == null ? null : new JigyoshaNo(new RString(r.getString(c)));
    }

    @Override
    public JigyoshaNo getNullableResult(ResultSet r, int c) throws SQLException {
        return r.getString(c) == null ? null : new JigyoshaNo(new RString(r.getString(c)));
    }

    @Override
    public JigyoshaNo getNullableResult(CallableStatement r, int c) throws SQLException {
        return r.getString(c) == null ? null : new JigyoshaNo(new RString(r.getString(c)));
    }

// </editor-fold>
}
