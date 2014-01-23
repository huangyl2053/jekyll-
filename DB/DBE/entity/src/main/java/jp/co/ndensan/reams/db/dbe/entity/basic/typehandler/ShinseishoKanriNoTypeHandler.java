package jp.co.ndensan.reams.db.dbe.entity.basic.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public class ShinseishoKanriNoTypeHandler extends BaseTypeHandler<ShinseishoKanriNo> {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ShinseishoKanriNo parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getColumnValue().toString());
    }

    @Override
    public ShinseishoKanriNo getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new ShinseishoKanriNo(new RString(rs.getString(columnName)));
    }

    @Override
    public ShinseishoKanriNo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new ShinseishoKanriNo(new RString(rs.getString(columnIndex)));
    }

    @Override
    public ShinseishoKanriNo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new ShinseishoKanriNo(new RString(cs.getString(columnIndex)));
    }
// </editor-fold>
}
