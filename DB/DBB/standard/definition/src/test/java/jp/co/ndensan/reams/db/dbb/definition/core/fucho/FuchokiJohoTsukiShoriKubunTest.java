package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 普徴期情報月処理区分のテストクラスです。
 *
 * @author LDNS
 */
public class FuchokiJohoTsukiShoriKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        FuchokiJohoTsukiShoriKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        FuchokiJohoTsukiShoriKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_なしを返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.toValue(new RString("0")), is(FuchokiJohoTsukiShoriKubun.なし));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_普徴仮算定を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.toValue(new RString("1")), is(FuchokiJohoTsukiShoriKubun.普徴仮算定));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_普徴仮算定異動を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.toValue(new RString("2")), is(FuchokiJohoTsukiShoriKubun.普徴仮算定異動));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_特徴仮算定異動を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.toValue(new RString("3")), is(FuchokiJohoTsukiShoriKubun.特徴仮算定異動));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_本算定を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.toValue(new RString("4")), is(FuchokiJohoTsukiShoriKubun.本算定));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_本算定異動を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.toValue(new RString("5")), is(FuchokiJohoTsukiShoriKubun.本算定異動));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_随時を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.toValue(new RString("6")), is(FuchokiJohoTsukiShoriKubun.随時));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_現年随時を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.toValue(new RString("7")), is(FuchokiJohoTsukiShoriKubun.現年随時));
    }

    @Test
    public void なしを指定した場合_getコードは_0を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.なし.getコード(), is(new RString("0")));
    }

    @Test
    public void 普徴仮算定を指定した場合_getコードは_1を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.普徴仮算定.getコード(), is(new RString("1")));
    }

    @Test
    public void 普徴仮算定異動を指定した場合_getコードは_2を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.普徴仮算定異動.getコード(), is(new RString("2")));
    }

    @Test
    public void 特徴仮算定異動を指定した場合_getコードは_3を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.特徴仮算定異動.getコード(), is(new RString("3")));
    }

    @Test
    public void 本算定を指定した場合_getコードは_4を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.本算定.getコード(), is(new RString("4")));
    }

    @Test
    public void 本算定異動を指定した場合_getコードは_5を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.本算定異動.getコード(), is(new RString("5")));
    }

    @Test
    public void 随時を指定した場合_getコードは_6を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.随時.getコード(), is(new RString("6")));
    }

    @Test
    public void 現年随時を指定した場合_getコードは_7を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.現年随時.getコード(), is(new RString("7")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.なし.get名称(), is(new RString("なし")));
    }

    @Test
    public void 普徴仮算定を指定した場合_get名称は_普徴仮算定を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.普徴仮算定.get名称(), is(new RString("普徴仮算定")));
    }

    @Test
    public void 普徴仮算定異動を指定した場合_get名称は_普徴仮算定異動を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.普徴仮算定異動.get名称(), is(new RString("普徴仮算定異動")));
    }

    @Test
    public void 特徴仮算定異動を指定した場合_get名称は_特徴仮算定異動を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.特徴仮算定異動.get名称(), is(new RString("特徴仮算定異動")));
    }

    @Test
    public void 本算定を指定した場合_get名称は_本算定を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.本算定.get名称(), is(new RString("本算定")));
    }

    @Test
    public void 本算定異動を指定した場合_get名称は_本算定異動を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.本算定異動.get名称(), is(new RString("本算定異動")));
    }

    @Test
    public void 随時を指定した場合_get名称は_随時を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.随時.get名称(), is(new RString("随時")));
    }

    @Test
    public void 現年随時を指定した場合_get名称は_現年随時を返す() {
        assertThat(FuchokiJohoTsukiShoriKubun.現年随時.get名称(), is(new RString("現年随時")));
    }

}
