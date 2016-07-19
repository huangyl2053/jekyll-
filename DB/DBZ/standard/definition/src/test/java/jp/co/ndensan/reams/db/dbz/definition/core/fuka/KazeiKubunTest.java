package jp.co.ndensan.reams.db.dbz.definition.core.fuka;

import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 課税区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class KazeiKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KazeiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KazeiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_課税を返す() {
        assertThat(KazeiKubun.toValue(new RString("1")), is(KazeiKubun.課税));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_非課税を返す() {
        assertThat(KazeiKubun.toValue(new RString("2")), is(KazeiKubun.非課税));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_未申告を返す() {
        assertThat(KazeiKubun.toValue(new RString("3")), is(KazeiKubun.未申告));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_所得調査中を返す() {
        assertThat(KazeiKubun.toValue(new RString("4")), is(KazeiKubun.所得調査中));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_課税取消を返す() {
        assertThat(KazeiKubun.toValue(new RString("5")), is(KazeiKubun.課税取消));
    }

    @Test
    public void 課税を指定した場合_getコードは_1を返す() {
        assertThat(KazeiKubun.課税.getコード(), is(new RString("1")));
    }

    @Test
    public void 非課税を指定した場合_getコードは_2を返す() {
        assertThat(KazeiKubun.非課税.getコード(), is(new RString("2")));
    }

    @Test
    public void 未申告を指定した場合_getコードは_3を返す() {
        assertThat(KazeiKubun.未申告.getコード(), is(new RString("3")));
    }

    @Test
    public void 所得調査中を指定した場合_getコードは_4を返す() {
        assertThat(KazeiKubun.所得調査中.getコード(), is(new RString("4")));
    }

    @Test
    public void 課税取消を指定した場合_getコードは_5を返す() {
        assertThat(KazeiKubun.課税取消.getコード(), is(new RString("5")));
    }

    @Test
    public void 課税を指定した場合_get名称は_課税を返す() {
        assertThat(KazeiKubun.課税.get名称(), is(new RString("課税")));
    }

    @Test
    public void 非課税を指定した場合_get名称は_非課税を返す() {
        assertThat(KazeiKubun.非課税.get名称(), is(new RString("非課税")));
    }

    @Test
    public void 未申告を指定した場合_get名称は_未申告を返す() {
        assertThat(KazeiKubun.未申告.get名称(), is(new RString("未申告")));
    }

    @Test
    public void 所得調査中を指定した場合_get名称は_所得調査中を返す() {
        assertThat(KazeiKubun.所得調査中.get名称(), is(new RString("所得調査中")));
    }

    @Test
    public void 課税取消を指定した場合_get名称は_課税取消を返す() {
        assertThat(KazeiKubun.課税取消.get名称(), is(new RString("課税取消")));
    }

}
