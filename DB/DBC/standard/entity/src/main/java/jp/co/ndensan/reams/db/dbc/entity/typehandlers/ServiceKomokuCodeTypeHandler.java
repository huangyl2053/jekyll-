package jp.co.ndensan.reams.db.dbc.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class ServiceKomokuCodeTypeHandler extends BaseTypeHandler<ServiceKomokuCode> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ServiceKomokuCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ServiceKomokuCode getNullableResult(ResultSet r, String c) throws SQLException {
        return r.getString(c) == null ? null : new ServiceKomokuCode(new RString(r.getString(c)));
    }

    @Override
    public ServiceKomokuCode getNullableResult(ResultSet r, int c) throws SQLException {
        return r.getString(c) == null ? null : new ServiceKomokuCode(new RString(r.getString(c)));
    }

    @Override
    public ServiceKomokuCode getNullableResult(CallableStatement r, int c) throws SQLException {
        return r.getString(c) == null ? null : new ServiceKomokuCode(new RString(r.getString(c)));
    }

// </editor-fold>
}
