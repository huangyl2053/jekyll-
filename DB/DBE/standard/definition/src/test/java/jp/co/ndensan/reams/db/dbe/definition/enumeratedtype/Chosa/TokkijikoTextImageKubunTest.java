package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特記事項テキスト・イメージ区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class TokkijikoTextImageKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokkijikoTextImageKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokkijikoTextImageKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_テキストを返す() {
        assertThat(TokkijikoTextImageKubun.toValue(new RString("1")), is(TokkijikoTextImageKubun.テキスト));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_イメージを返す() {
        assertThat(TokkijikoTextImageKubun.toValue(new RString("2")), is(TokkijikoTextImageKubun.イメージ));
    }

    @Test
    public void テキストを指定した場合_getコードは_1を返す() {
        assertThat(TokkijikoTextImageKubun.テキスト.getコード(), is(new RString("1")));
    }

    @Test
    public void イメージを指定した場合_getコードは_2を返す() {
        assertThat(TokkijikoTextImageKubun.イメージ.getコード(), is(new RString("2")));
    }

    @Test
    public void テキストを指定した場合_get名称は_テキストを返す() {
        assertThat(TokkijikoTextImageKubun.テキスト.get名称(), is(new RString("テキスト")));
    }

    @Test
    public void イメージを指定した場合_get名称は_イメージを返す() {
        assertThat(TokkijikoTextImageKubun.イメージ.get名称(), is(new RString("イメージ")));
    }

}
