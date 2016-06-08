package jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 処理状態区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShoriJotaiKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShoriJotaiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShoriJotaiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_処理前を返す() {
        assertThat(ShoriJotaiKubun.toValue(new RString("1")), is(ShoriJotaiKubun.処理前));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_起動を返す() {
        assertThat(ShoriJotaiKubun.toValue(new RString("2")), is(ShoriJotaiKubun.起動));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_終了を返す() {
        assertThat(ShoriJotaiKubun.toValue(new RString("3")), is(ShoriJotaiKubun.終了));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_処理なしを返す() {
        assertThat(ShoriJotaiKubun.toValue(new RString("4")), is(ShoriJotaiKubun.処理なし));
    }

    @Test
    public void 処理前を指定した場合_getコードは_1を返す() {
        assertThat(ShoriJotaiKubun.処理前.getコード(), is(new RString("1")));
    }

    @Test
    public void 起動を指定した場合_getコードは_2を返す() {
        assertThat(ShoriJotaiKubun.起動.getコード(), is(new RString("2")));
    }

    @Test
    public void 終了を指定した場合_getコードは_3を返す() {
        assertThat(ShoriJotaiKubun.終了.getコード(), is(new RString("3")));
    }

    @Test
    public void 処理なしを指定した場合_getコードは_4を返す() {
        assertThat(ShoriJotaiKubun.処理なし.getコード(), is(new RString("4")));
    }

    @Test
    public void 処理前を指定した場合_get名称は_処理前を返す() {
        assertThat(ShoriJotaiKubun.処理前.get名称(), is(new RString("処理前")));
    }

    @Test
    public void 起動を指定した場合_get名称は_起動を返す() {
        assertThat(ShoriJotaiKubun.起動.get名称(), is(new RString("起動")));
    }

    @Test
    public void 終了を指定した場合_get名称は_終了を返す() {
        assertThat(ShoriJotaiKubun.終了.get名称(), is(new RString("終了")));
    }

    @Test
    public void 処理なしを指定した場合_get名称は_処理なしを返す() {
        assertThat(ShoriJotaiKubun.処理なし.get名称(), is(new RString("処理なし")));
    }

}
