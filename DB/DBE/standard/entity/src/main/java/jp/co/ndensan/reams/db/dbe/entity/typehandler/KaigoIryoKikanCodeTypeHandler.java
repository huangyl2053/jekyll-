package jp.co.ndensan.reams.db.dbe.entity.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護医療機関コードのタイプハンドラです。
 *
 * @author n8178 城間篤人
 */
public class KaigoIryoKikanCodeTypeHandler extends BaseTypeHandler<KaigoIryoKikanCode> {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, KaigoIryoKikanCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public KaigoIryoKikanCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new KaigoIryoKikanCode(getResultRString(rs.getString(columnName)));
    }

    @Override
    public KaigoIryoKikanCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new KaigoIryoKikanCode(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public KaigoIryoKikanCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new KaigoIryoKikanCode(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }
// </editor-fold>
}
