package jp.co.ndensan.reams.db.dbc.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class ServiceShuruiCodeTypeHandler extends BaseTypeHandler<ServiceShuruiCode> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ServiceShuruiCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ServiceShuruiCode getNullableResult(ResultSet r, String c) throws SQLException {
        return r.getString(c) == null ? null : new ServiceShuruiCode(new RString(r.getString(c)));
    }

    @Override
    public ServiceShuruiCode getNullableResult(ResultSet r, int c) throws SQLException {
        return r.getString(c) == null ? null : new ServiceShuruiCode(new RString(r.getString(c)));
    }

    @Override
    public ServiceShuruiCode getNullableResult(CallableStatement r, int c) throws SQLException {
        return r.getString(c) == null ? null : new ServiceShuruiCode(new RString(r.getString(c)));
    }

// </editor-fold>
}
