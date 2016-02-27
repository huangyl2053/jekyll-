package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishukeiyaku;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 住宅改修契約のテストクラスです。
 *
 * @author LDNS
 */
public class JutakuKaishuKeiyakuKubunTest extends DbcTestBase {

    @Test
    public void 引数にtrueを指定した場合_toValueは_契約有りを返す() {
        assertThat(JutakuKaishuKeiyakuKubun.toValue(true), is(JutakuKaishuKeiyakuKubun.契約有り));
    }

    @Test
    public void 引数にfalseを指定した場合_toValueは_契約無しを返す() {
        assertThat(JutakuKaishuKeiyakuKubun.toValue(false), is(JutakuKaishuKeiyakuKubun.契約無し));
    }

    @Test
    public void 契約有りを指定した場合_getコードは_trueを返す() {
        assertThat(JutakuKaishuKeiyakuKubun.契約有り.getコード(), is(true));
    }

    @Test
    public void 契約無しを指定した場合_getコードは_falseを返す() {
        assertThat(JutakuKaishuKeiyakuKubun.契約無し.getコード(), is(false));
    }

    @Test
    public void 契約有りを指定した場合_get名称は_契約有りを返す() {
        assertThat(JutakuKaishuKeiyakuKubun.契約有り.get名称(), is(new RString("契約有り")));
    }

    @Test
    public void 契約無しを指定した場合_get名称は_契約無しを返す() {
        assertThat(JutakuKaishuKeiyakuKubun.契約無し.get名称(), is(new RString("契約無し")));
    }

}
