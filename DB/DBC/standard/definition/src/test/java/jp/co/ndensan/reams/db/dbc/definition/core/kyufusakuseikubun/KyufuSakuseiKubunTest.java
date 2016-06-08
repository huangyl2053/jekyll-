package jp.co.ndensan.reams.db.dbc.definition.core.kyufusakuseikubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 給付実績情報作成区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class KyufuSakuseiKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KyufuSakuseiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KyufuSakuseiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_新規を返す() {
        assertThat(KyufuSakuseiKubun.toValue(new RString("1")), is(KyufuSakuseiKubun.新規));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_修正を返す() {
        assertThat(KyufuSakuseiKubun.toValue(new RString("2")), is(KyufuSakuseiKubun.修正));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_削除を返す() {
        assertThat(KyufuSakuseiKubun.toValue(new RString("3")), is(KyufuSakuseiKubun.削除));
    }

    @Test
    public void 新規を指定した場合_getコードは_1を返す() {
        assertThat(KyufuSakuseiKubun.新規.getコード(), is(new RString("1")));
    }

    @Test
    public void 修正を指定した場合_getコードは_2を返す() {
        assertThat(KyufuSakuseiKubun.修正.getコード(), is(new RString("2")));
    }

    @Test
    public void 削除を指定した場合_getコードは_3を返す() {
        assertThat(KyufuSakuseiKubun.削除.getコード(), is(new RString("3")));
    }

    @Test
    public void 新規を指定した場合_get名称は_新規を返す() {
        assertThat(KyufuSakuseiKubun.新規.get名称(), is(new RString("新規")));
    }

    @Test
    public void 修正を指定した場合_get名称は_修正を返す() {
        assertThat(KyufuSakuseiKubun.修正.get名称(), is(new RString("修正")));
    }

    @Test
    public void 削除を指定した場合_get名称は_削除を返す() {
        assertThat(KyufuSakuseiKubun.削除.get名称(), is(new RString("削除")));
    }

}
