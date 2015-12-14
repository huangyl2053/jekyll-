package jp.co.ndensan.reams.db.dbb.definition.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 処理区分のテストクラスです。
 *
 * @author LDNS
 */
public class ShoriKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShoriKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShoriKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_リアルを返す() {
        assertThat(ShoriKubun.toValue(new RString("1")), is(ShoriKubun.リアル));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_バッチを返す() {
        assertThat(ShoriKubun.toValue(new RString("2")), is(ShoriKubun.バッチ));
    }

    @Test
    public void リアルを指定した場合_getコードは_1を返す() {
        assertThat(ShoriKubun.リアル.getコード(), is(new RString("1")));
    }

    @Test
    public void バッチを指定した場合_getコードは_2を返す() {
        assertThat(ShoriKubun.バッチ.getコード(), is(new RString("2")));
    }

    @Test
    public void リアルを指定した場合_get名称は_リアルを返す() {
        assertThat(ShoriKubun.リアル.get名称(), is(new RString("リアル")));
    }

    @Test
    public void バッチを指定した場合_get名称は_バッチを返す() {
        assertThat(ShoriKubun.バッチ.get名称(), is(new RString("バッチ")));
    }

}
