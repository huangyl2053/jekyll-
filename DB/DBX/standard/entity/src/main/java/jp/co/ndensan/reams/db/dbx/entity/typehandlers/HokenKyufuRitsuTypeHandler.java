package jp.co.ndensan.reams.db.dbx.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class HokenKyufuRitsuTypeHandler extends BaseTypeHandler<HokenKyufuRitsu> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, HokenKyufuRitsu parameter, JdbcType jdbcType) throws SQLException {
        ps.setBigDecimal(i, parameter == null ? null : parameter.getColumnValue().getBigDecimal());
    }

    @Override
    public HokenKyufuRitsu getNullableResult(ResultSet r, String c) throws SQLException {
        return r.getBigDecimal(c) == null ? null : new HokenKyufuRitsu(new Decimal(r.getBigDecimal(c).toString()));
    }

    @Override
    public HokenKyufuRitsu getNullableResult(ResultSet r, int c) throws SQLException {
        return r.getBigDecimal(c) == null ? null : new HokenKyufuRitsu(new Decimal(r.getBigDecimal(c).toString()));
    }

    @Override
    public HokenKyufuRitsu getNullableResult(CallableStatement r, int c) throws SQLException {
        return r.getBigDecimal(c) == null ? null : new HokenKyufuRitsu(new Decimal(r.getBigDecimal(c).toString()));
    }

// </editor-fold>
}
