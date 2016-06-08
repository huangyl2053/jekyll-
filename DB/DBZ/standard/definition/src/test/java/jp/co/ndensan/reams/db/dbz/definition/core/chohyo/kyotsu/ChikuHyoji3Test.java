package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 地区表示3のテストクラスです。
 * 
 * @author LDNS 
 */
public class ChikuHyoji3Test extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChikuHyoji3.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChikuHyoji3.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_なしを返す() {
        assertThat(ChikuHyoji3.toValue(new RString("0")), is(ChikuHyoji3.なし));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_地区の分類1を返す() {
        assertThat(ChikuHyoji3.toValue(new RString("3")), is(ChikuHyoji3.地区の分類1));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_地区の分類2を返す() {
        assertThat(ChikuHyoji3.toValue(new RString("4")), is(ChikuHyoji3.地区の分類2));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_地区の分類3を返す() {
        assertThat(ChikuHyoji3.toValue(new RString("5")), is(ChikuHyoji3.地区の分類3));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_納組コードを返す() {
        assertThat(ChikuHyoji3.toValue(new RString("6")), is(ChikuHyoji3.納組コード));
    }

    @Test
    public void なしを指定した場合_getコードは_0を返す() {
        assertThat(ChikuHyoji3.なし.getコード(), is(new RString("0")));
    }

    @Test
    public void 地区の分類1を指定した場合_getコードは_3を返す() {
        assertThat(ChikuHyoji3.地区の分類1.getコード(), is(new RString("3")));
    }

    @Test
    public void 地区の分類2を指定した場合_getコードは_4を返す() {
        assertThat(ChikuHyoji3.地区の分類2.getコード(), is(new RString("4")));
    }

    @Test
    public void 地区の分類3を指定した場合_getコードは_5を返す() {
        assertThat(ChikuHyoji3.地区の分類3.getコード(), is(new RString("5")));
    }

    @Test
    public void 納組コードを指定した場合_getコードは_6を返す() {
        assertThat(ChikuHyoji3.納組コード.getコード(), is(new RString("6")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(ChikuHyoji3.なし.get名称(), is(new RString("なし")));
    }

    @Test
    public void 地区の分類1を指定した場合_get名称は_地区の分類1を返す() {
        assertThat(ChikuHyoji3.地区の分類1.get名称(), is(new RString("地区の分類1")));
    }

    @Test
    public void 地区の分類2を指定した場合_get名称は_地区の分類2を返す() {
        assertThat(ChikuHyoji3.地区の分類2.get名称(), is(new RString("地区の分類2")));
    }

    @Test
    public void 地区の分類3を指定した場合_get名称は_地区の分類3を返す() {
        assertThat(ChikuHyoji3.地区の分類3.get名称(), is(new RString("地区の分類3")));
    }

    @Test
    public void 納組コードを指定した場合_get名称は_納組コードを返す() {
        assertThat(ChikuHyoji3.納組コード.get名称(), is(new RString("納組コード")));
    }

}
