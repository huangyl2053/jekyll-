package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 事業者区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class JigyoshaKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JigyoshaKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JigyoshaKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_医科を返す() {
        assertThat(JigyoshaKubun.toValue(new RString("1")), is(JigyoshaKubun.医科));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_歯科を返す() {
        assertThat(JigyoshaKubun.toValue(new RString("3")), is(JigyoshaKubun.歯科));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_薬局を返す() {
        assertThat(JigyoshaKubun.toValue(new RString("4")), is(JigyoshaKubun.薬局));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_老人保健施設を返す() {
        assertThat(JigyoshaKubun.toValue(new RString("5")), is(JigyoshaKubun.老人保健施設));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_訪問看護ステーションを返す() {
        assertThat(JigyoshaKubun.toValue(new RString("6")), is(JigyoshaKubun.訪問看護ステーション));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_介護保険事業所を返す() {
        assertThat(JigyoshaKubun.toValue(new RString("7")), is(JigyoshaKubun.介護保険事業所));
    }

    @Test
    public void 引数に8を指定した場合_toValueは_基準該当事業所を返す() {
        assertThat(JigyoshaKubun.toValue(new RString("8")), is(JigyoshaKubun.基準該当事業所));
    }

    @Test
    public void 医科を指定した場合_getコードは_1を返す() {
        assertThat(JigyoshaKubun.医科.getコード(), is(new RString("1")));
    }

    @Test
    public void 歯科を指定した場合_getコードは_3を返す() {
        assertThat(JigyoshaKubun.歯科.getコード(), is(new RString("3")));
    }

    @Test
    public void 薬局を指定した場合_getコードは_4を返す() {
        assertThat(JigyoshaKubun.薬局.getコード(), is(new RString("4")));
    }

    @Test
    public void 老人保健施設を指定した場合_getコードは_5を返す() {
        assertThat(JigyoshaKubun.老人保健施設.getコード(), is(new RString("5")));
    }

    @Test
    public void 訪問看護ステーションを指定した場合_getコードは_6を返す() {
        assertThat(JigyoshaKubun.訪問看護ステーション.getコード(), is(new RString("6")));
    }

    @Test
    public void 介護保険事業所を指定した場合_getコードは_7を返す() {
        assertThat(JigyoshaKubun.介護保険事業所.getコード(), is(new RString("7")));
    }

    @Test
    public void 基準該当事業所を指定した場合_getコードは_8を返す() {
        assertThat(JigyoshaKubun.基準該当事業所.getコード(), is(new RString("8")));
    }

    @Test
    public void 医科を指定した場合_get名称は_医科を返す() {
        assertThat(JigyoshaKubun.医科.get名称(), is(new RString("医科")));
    }

    @Test
    public void 歯科を指定した場合_get名称は_歯科を返す() {
        assertThat(JigyoshaKubun.歯科.get名称(), is(new RString("歯科")));
    }

    @Test
    public void 薬局を指定した場合_get名称は_薬局を返す() {
        assertThat(JigyoshaKubun.薬局.get名称(), is(new RString("薬局")));
    }

    @Test
    public void 老人保健施設を指定した場合_get名称は_老人保健施設を返す() {
        assertThat(JigyoshaKubun.老人保健施設.get名称(), is(new RString("老人保健施設")));
    }

    @Test
    public void 訪問看護ステーションを指定した場合_get名称は_訪問看護ステーションを返す() {
        assertThat(JigyoshaKubun.訪問看護ステーション.get名称(), is(new RString("訪問看護ステーション")));
    }

    @Test
    public void 介護保険事業所を指定した場合_get名称は_介護保険事業所を返す() {
        assertThat(JigyoshaKubun.介護保険事業所.get名称(), is(new RString("介護保険事業所")));
    }

    @Test
    public void 基準該当事業所を指定した場合_get名称は_基準該当事業所を返す() {
        assertThat(JigyoshaKubun.基準該当事業所.get名称(), is(new RString("基準該当事業所")));
    }

}
