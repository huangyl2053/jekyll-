package jp.co.ndensan.reams.db.dbx.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class ShoKisaiHokenshaNoTypeHandler extends BaseTypeHandler<ShoKisaiHokenshaNo> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ShoKisaiHokenshaNo parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ShoKisaiHokenshaNo getNullableResult(ResultSet r, String c) throws SQLException {
        return r.getString(c) == null ? null : new ShoKisaiHokenshaNo(new RString(r.getString(c)));
    }

    @Override
    public ShoKisaiHokenshaNo getNullableResult(ResultSet r, int c) throws SQLException {
        return r.getString(c) == null ? null : new ShoKisaiHokenshaNo(new RString(r.getString(c)));
    }

    @Override
    public ShoKisaiHokenshaNo getNullableResult(CallableStatement r, int c) throws SQLException {
        return r.getString(c) == null ? null : new ShoKisaiHokenshaNo(new RString(r.getString(c)));
    }

// </editor-fold>
}
