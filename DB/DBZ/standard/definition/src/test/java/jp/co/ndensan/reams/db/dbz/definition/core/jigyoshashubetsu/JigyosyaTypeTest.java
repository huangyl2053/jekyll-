package jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 事業者種別のテストクラスです。
 * 
 * @author LDNS 
 */
public class JigyosyaTypeTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JigyosyaType.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JigyosyaType.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_住所地特例対象施設を返す() {
        assertThat(JigyosyaType.toValue(new RString("01")), is(JigyosyaType.住所地特例対象施設));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_適用除外施設を返す() {
        assertThat(JigyosyaType.toValue(new RString("02")), is(JigyosyaType.適用除外施設));
    }

    @Test
    public void 住所地特例対象施設を指定した場合_getコードは_01を返す() {
        assertThat(JigyosyaType.住所地特例対象施設.getコード(), is(new RString("01")));
    }

    @Test
    public void 適用除外施設を指定した場合_getコードは_02を返す() {
        assertThat(JigyosyaType.適用除外施設.getコード(), is(new RString("02")));
    }

    @Test
    public void 住所地特例対象施設を指定した場合_get名称は_住所地特例対象施設を返す() {
        assertThat(JigyosyaType.住所地特例対象施設.get名称(), is(new RString("住所地特例対象施設")));
    }

    @Test
    public void 適用除外施設を指定した場合_get名称は_適用除外施設を返す() {
        assertThat(JigyosyaType.適用除外施設.get名称(), is(new RString("適用除外施設")));
    }

}
