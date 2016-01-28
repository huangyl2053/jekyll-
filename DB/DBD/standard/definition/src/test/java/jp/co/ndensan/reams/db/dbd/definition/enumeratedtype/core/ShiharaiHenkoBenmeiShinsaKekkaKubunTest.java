package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法変更弁明審査結果区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShiharaiHenkoBenmeiShinsaKekkaKubunTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHenkoBenmeiShinsaKekkaKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHenkoBenmeiShinsaKekkaKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_申請受理を返す() {
        assertThat(ShiharaiHenkoBenmeiShinsaKekkaKubun.toValue(new RString("1")), is(ShiharaiHenkoBenmeiShinsaKekkaKubun.申請受理));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_申請却下を返す() {
        assertThat(ShiharaiHenkoBenmeiShinsaKekkaKubun.toValue(new RString("2")), is(ShiharaiHenkoBenmeiShinsaKekkaKubun.申請却下));
    }

    @Test
    public void 申請受理を指定した場合_getコードは_1を返す() {
        assertThat(ShiharaiHenkoBenmeiShinsaKekkaKubun.申請受理.getコード(), is(new RString("1")));
    }

    @Test
    public void 申請却下を指定した場合_getコードは_2を返す() {
        assertThat(ShiharaiHenkoBenmeiShinsaKekkaKubun.申請却下.getコード(), is(new RString("2")));
    }

    @Test
    public void 申請受理を指定した場合_get名称は_申請受理を返す() {
        assertThat(ShiharaiHenkoBenmeiShinsaKekkaKubun.申請受理.get名称(), is(new RString("申請受理")));
    }

    @Test
    public void 申請却下を指定した場合_get名称は_申請却下を返す() {
        assertThat(ShiharaiHenkoBenmeiShinsaKekkaKubun.申請却下.get名称(), is(new RString("申請却下")));
    }

}
