package jp.co.ndensan.reams.db.dbb.entity.typehandlers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 特別徴収義務者コードのTypeHandlerクラスです。
 *
 * @reamsid_L DBB-1830-050 liuyang
 */
public class TokubetsuChoshuGimushaCodeTypeHandler
        extends BaseTypeHandler<TokubetsuChoshuGimushaCode> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, TokubetsuChoshuGimushaCode parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getColumnValue().toString());
    }

    @Override
    public TokubetsuChoshuGimushaCode getNullableResult(ResultSet r, String c)
            throws SQLException {
        return r.getString(c) == null ? null : new TokubetsuChoshuGimushaCode(new RString(r.getString(c)));
    }

    @Override
    public TokubetsuChoshuGimushaCode getNullableResult(ResultSet r, int c)
            throws SQLException {
        return r.getString(c) == null ? null : new TokubetsuChoshuGimushaCode(new RString(r.getString(c)));
    }

    @Override
    public TokubetsuChoshuGimushaCode getNullableResult(CallableStatement r, int c)
            throws SQLException {
        return r.getString(c) == null ? null : new TokubetsuChoshuGimushaCode(new RString(r.getString(c)));
    }
}
