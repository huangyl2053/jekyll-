package jp.co.ndensan.reams.db.dbz.definition.core.shikakuidou;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 資格異動を表す区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShikakuIdoKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShikakuIdoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShikakuIdoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_資格取得を返す() {
        assertThat(ShikakuIdoKubun.toValue(new RString("1")), is(ShikakuIdoKubun.資格取得));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_資格変更を返す() {
        assertThat(ShikakuIdoKubun.toValue(new RString("2")), is(ShikakuIdoKubun.資格変更));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_資格喪失を返す() {
        assertThat(ShikakuIdoKubun.toValue(new RString("3")), is(ShikakuIdoKubun.資格喪失));
    }

    @Test
    public void 資格取得を指定した場合_getコードは_1を返す() {
        assertThat(ShikakuIdoKubun.資格取得.getコード(), is(new RString("1")));
    }

    @Test
    public void 資格変更を指定した場合_getコードは_2を返す() {
        assertThat(ShikakuIdoKubun.資格変更.getコード(), is(new RString("2")));
    }

    @Test
    public void 資格喪失を指定した場合_getコードは_3を返す() {
        assertThat(ShikakuIdoKubun.資格喪失.getコード(), is(new RString("3")));
    }

    @Test
    public void 資格取得を指定した場合_get名称は_資格取得を返す() {
        assertThat(ShikakuIdoKubun.資格取得.get名称(), is(new RString("資格取得")));
    }

    @Test
    public void 資格変更を指定した場合_get名称は_資格変更を返す() {
        assertThat(ShikakuIdoKubun.資格変更.get名称(), is(new RString("資格変更")));
    }

    @Test
    public void 資格喪失を指定した場合_get名称は_資格喪失を返す() {
        assertThat(ShikakuIdoKubun.資格喪失.get名称(), is(new RString("資格喪失")));
    }

}
