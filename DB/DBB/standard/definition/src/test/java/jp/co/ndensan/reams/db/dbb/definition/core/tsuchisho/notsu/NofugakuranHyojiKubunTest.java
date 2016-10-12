package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 納付額欄表示区分のテストクラスです。
 *
 * @author LDNS
 */
public class NofugakuranHyojiKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NofugakuranHyojiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NofugakuranHyojiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_口座振替_を印字するを返す() {
        assertThat(NofugakuranHyojiKubun.toValue(new RString("1")), is(NofugakuranHyojiKubun.口座振替を印字する));
    }

    @Test
    public void 引数に2を指定した場合_toValueは__を印字するを返す() {
        assertThat(NofugakuranHyojiKubun.toValue(new RString("2")), is(NofugakuranHyojiKubun.空白を印字する));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_星印_を印字するを返す() {
        assertThat(NofugakuranHyojiKubun.toValue(new RString("3")), is(NofugakuranHyojiKubun.マスクを印字する
        ));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_金額出力を返す() {
        assertThat(NofugakuranHyojiKubun.toValue(new RString("4")), is(NofugakuranHyojiKubun.金額出力));
    }

    @Test
    public void _口座振替_を印字するを指定した場合_getコードは_1を返す() {
        assertThat(NofugakuranHyojiKubun.口座振替を印字する.getコード(), is(new RString("1")));
    }

    @Test
    public void __を印字するを指定した場合_getコードは_2を返す() {
        assertThat(NofugakuranHyojiKubun.空白を印字する.getコード(), is(new RString("2")));
    }

    @Test
    public void _星印_を印字するを指定した場合_getコードは_3を返す() {
        assertThat(NofugakuranHyojiKubun.マスクを印字する.getコード(), is(new RString("3"))
        );
    }

    @Test
    public void 金額出力を指定した場合_getコードは_4を返す() {
        assertThat(NofugakuranHyojiKubun.金額出力.getコード(), is(new RString("4")));
    }

    @Test
    public void _口座振替_を印字するを指定した場合_get名称は_口座振替を印字するを返す() {
        assertThat(NofugakuranHyojiKubun.口座振替を印字する.get名称(), is(new RString("「口座振替」を印字する")));
    }

    @Test
    public void __を印字するを指定した場合_get名称は_空白を印字するを返す() {
        assertThat(NofugakuranHyojiKubun.空白を印字する.get名称(), is(new RString("「　　　　」を印字する")));
    }

    @Test
    public void _星印_を印字するを指定した場合_get名称は_マスクを印字するを返す() {
        assertThat(NofugakuranHyojiKubun.マスクを印字する.get名称(), is(new RString("「＊＊＊＊」を印字する"))
        );
    }

    @Test
    public void 金額出力を指定した場合_get名称は_金額出力を返す() {
        assertThat(NofugakuranHyojiKubun.金額出力.get名称(), is(new RString("金額出力")));
    }

}
