package jp.co.ndensan.reams.db.dbc.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.HokenKyufuRitsu;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.math.BigDecimal;

public class HokenKyufuRitsuTypeHandler extends BaseTypeHandler<HokenKyufuRitsu> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, HokenKyufuRitsu parameter, JdbcType jdbcType) throws SQLException {
        ps.setBigDecimal(i, parameter == null ? null : parameter.getColumnValue().getBigDecimal());
    }

    @Override
    public HokenKyufuRitsu getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new HokenKyufuRitsu(getResultDecimal(rs.getBigDecimal(columnName)));
    }

    @Override
    public HokenKyufuRitsu getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new HokenKyufuRitsu(getResultDecimal(rs.getBigDecimal(columnIndex)));
    }

    @Override
    public HokenKyufuRitsu getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new HokenKyufuRitsu(getResultDecimal(cs.getBigDecimal(columnIndex)));
    }

    private Decimal getResultDecimal(BigDecimal result) {
        return result == null ? null : new Decimal(result.toString());
    }

// </editor-fold>
}
