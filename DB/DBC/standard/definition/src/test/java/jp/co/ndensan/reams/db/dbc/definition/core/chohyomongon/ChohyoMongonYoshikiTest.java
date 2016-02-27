package jp.co.ndensan.reams.db.dbc.definition.core.chohyomongon;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 帳票文言様式のテストクラスです。
 * 
 * @author LDNS 
 */
public class ChohyoMongonYoshikiTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChohyoMongonYoshiki.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChohyoMongonYoshiki.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_フォント小を返す() {
        assertThat(ChohyoMongonYoshiki.toValue(new RString("1")), is(ChohyoMongonYoshiki.フォント小));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_フォント大を返す() {
        assertThat(ChohyoMongonYoshiki.toValue(new RString("2")), is(ChohyoMongonYoshiki.フォント大));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_フォント混在_上大_下小を返す() {
        assertThat(ChohyoMongonYoshiki.toValue(new RString("3")), is(ChohyoMongonYoshiki.フォント混在_上大_下小));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_フォント混在_上小_下大を返す() {
        assertThat(ChohyoMongonYoshiki.toValue(new RString("4")), is(ChohyoMongonYoshiki.フォント混在_上小_下大));
    }

    @Test
    public void フォント小を指定した場合_getコードは_1を返す() {
        assertThat(ChohyoMongonYoshiki.フォント小.getコード(), is(new RString("1")));
    }

    @Test
    public void フォント大を指定した場合_getコードは_2を返す() {
        assertThat(ChohyoMongonYoshiki.フォント大.getコード(), is(new RString("2")));
    }

    @Test
    public void フォント混在_上大_下小を指定した場合_getコードは_3を返す() {
        assertThat(ChohyoMongonYoshiki.フォント混在_上大_下小.getコード(), is(new RString("3")));
    }

    @Test
    public void フォント混在_上小_下大を指定した場合_getコードは_4を返す() {
        assertThat(ChohyoMongonYoshiki.フォント混在_上小_下大.getコード(), is(new RString("4")));
    }

    @Test
    public void フォント小を指定した場合_get名称は_フォント小を返す() {
        assertThat(ChohyoMongonYoshiki.フォント小.get名称(), is(new RString("フォント小")));
    }

    @Test
    public void フォント大を指定した場合_get名称は_フォント大を返す() {
        assertThat(ChohyoMongonYoshiki.フォント大.get名称(), is(new RString("フォント大")));
    }

    @Test
    public void フォント混在_上大_下小を指定した場合_get名称は_フォント混在_上大_下小を返す() {
        assertThat(ChohyoMongonYoshiki.フォント混在_上大_下小.get名称(), is(new RString("フォント混在（上大・下小）")));
    }

    @Test
    public void フォント混在_上小_下大を指定した場合_get名称は_フォント混在_上小_下大を返す() {
        assertThat(ChohyoMongonYoshiki.フォント混在_上小_下大.get名称(), is(new RString("フォント混在（上小・下大）")));
    }

}
