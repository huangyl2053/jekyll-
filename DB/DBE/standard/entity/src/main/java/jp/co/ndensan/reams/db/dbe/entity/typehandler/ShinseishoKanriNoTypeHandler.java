package jp.co.ndensan.reams.db.dbe.entity.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請書管理番号のTypeHandlerです。
 *
 * @author n8178 城間篤人
 */
public class ShinseishoKanriNoTypeHandler extends BaseTypeHandler<ShinseishoKanriNo> {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ShinseishoKanriNo parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public ShinseishoKanriNo getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new ShinseishoKanriNo(getResultRString(rs.getString(columnName)));
    }

    @Override
    public ShinseishoKanriNo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new ShinseishoKanriNo(getResultRString(rs.getString(columnIndex)));
    }

    @Override
    public ShinseishoKanriNo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new ShinseishoKanriNo(getResultRString(cs.getString(columnIndex)));
    }

    private RString getResultRString(String result) {
        return result == null ? null : new RString(result);
    }
// </editor-fold>
}
