package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 住所編集町域編集方法のテストクラスです。
 *
 * @author LDNS
 */
public class JushoHenshuChoikiHenshuHohoTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JushoHenshuChoikiHenshuHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JushoHenshuChoikiHenshuHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_住所足す番地を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.toValue(new RString("1")), is(JushoHenshuChoikiHenshuHoho.住所足す番地));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_行政区足す番地を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.toValue(new RString("2")), is(JushoHenshuChoikiHenshuHoho.行政区足す番地));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_住所足す番地_行政区を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.toValue(new RString("3")), is(JushoHenshuChoikiHenshuHoho.住所足す番地_行政区));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_番地のみを返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.toValue(new RString("4")), is(JushoHenshuChoikiHenshuHoho.番地のみ));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_表示なし_住所は印字しないを返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.toValue(new RString("5")), is(JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない));
    }

    @Test
    public void 住所足す番地を指定した場合_getコードは_1を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.住所足す番地.getコード(), is(new RString("1")));
    }

    @Test
    public void 行政区足す番地を指定した場合_getコードは_2を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.行政区足す番地.getコード(), is(new RString("2")));
    }

    @Test
    public void 住所足す番地_行政区を指定した場合_getコードは_3を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.住所足す番地_行政区.getコード(), is(new RString("3")));
    }

    @Test
    public void 番地のみを指定した場合_getコードは_4を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.番地のみ.getコード(), is(new RString("4")));
    }

    @Test
    public void 表示なし_住所は印字しないを指定した場合_getコードは_5を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない.getコード(), is(new RString("5")));
    }

    @Test
    public void 住所足す番地を指定した場合_get名称は_住所_番地を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.住所足す番地.get名称(), is(new RString("住所_番地")));
    }

    @Test
    public void 行政区足す番地を指定した場合_get名称は_行政区_番地を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.行政区足す番地.get名称(), is(new RString("行政区_番地")));
    }

    @Test
    public void 住所足す番地_行政区を指定した場合_get名称は_住所_番地_行政区を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.住所足す番地_行政区.get名称(), is(new RString("住所_番地_行政区")));
    }

    @Test
    public void 番地のみを指定した場合_get名称は_番地のみを返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.番地のみ.get名称(), is(new RString("番地のみ")));
    }

    @Test
    public void 表示なし_住所は印字しないを指定した場合_get名称は_表示なしを返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない.get名称(), is(new RString("表示なし")));
    }

    @Test
    public void 住所足す番地を指定した場合_get略称は_住所足す番地を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.住所足す番地.get略称(), is(new RString("住所＋番地")));
    }

    @Test
    public void 行政区足す番地を指定した場合_get略称は_行政区足す番地を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.行政区足す番地.get略称(), is(new RString("行政区＋番地")));
    }

    @Test
    public void 住所足す番地_行政区を指定した場合_get略称は_住所足す番地_行政区を返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.住所足す番地_行政区.get略称(), is(new RString("住所＋番地、（行政区）")));
    }

    @Test
    public void 番地のみを指定した場合_get略称は_番地のみを返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.番地のみ.get略称(), is(new RString("番地のみ")));
    }

    @Test
    public void 表示なし_住所は印字しないを指定した場合_get略称は_表示なし_住所は印字しないを返す() {
        assertThat(JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない.get略称(), is(new RString("表示なし(住所は印字しない)")));
    }

}
