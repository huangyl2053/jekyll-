package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 領収印欄表示区分のテストクラスです。
 *
 * @author LDNS
 */
public class RyoshuinranHyojiKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        RyoshuinranHyojiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        RyoshuinranHyojiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_口座振替_を印字するを返す() {
        assertThat(RyoshuinranHyojiKubun.toValue(new RString("1")), is(RyoshuinranHyojiKubun.口座振替を印字する));
    }

    @Test
    public void 引数に2を指定した場合_toValueは__を印字するを返す() {
        assertThat(RyoshuinranHyojiKubun.toValue(new RString("2")), is(RyoshuinranHyojiKubun.空白を印字する));
    }

    @Test
    public void _口座振替_を印字するを指定した場合_getコードは_1を返す() {
        assertThat(RyoshuinranHyojiKubun.口座振替を印字する.getコード(), is(new RString("1")));
    }

    @Test
    public void __を印字するを指定した場合_getコードは_2を返す() {
        assertThat(RyoshuinranHyojiKubun.空白を印字する.getコード(), is(new RString("2")));
    }

    @Test
    public void _口座振替_を印字するを指定した場合_get名称は_口座振替を印字するを返す() {
        assertThat(RyoshuinranHyojiKubun.口座振替を印字する.get名称(), is(new RString("「口座振替」を印字する")));
    }

    @Test
    public void __を印字するを指定した場合_get名称は_空白を印字するを返す() {
        assertThat(RyoshuinranHyojiKubun.空白を印字する.get名称(), is(new RString("「　　　　」を印字する")));
    }

}
