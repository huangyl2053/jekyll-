package jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 施設種類のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShisetsuTypeTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShisetsuType.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShisetsuType.toValue(new RString("99999"));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_介護保険施設を返す() {
        assertThat(ShisetsuType.toValue(new RString("11")), is(ShisetsuType.介護保険施設));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_住所地特例対象施設を返す() {
        assertThat(ShisetsuType.toValue(new RString("12")), is(ShisetsuType.住所地特例対象施設));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_適用除外施設を返す() {
        assertThat(ShisetsuType.toValue(new RString("21")), is(ShisetsuType.適用除外施設));
    }

    @Test
    public void 介護保険施設を指定した場合_getコードは_11を返す() {
        assertThat(ShisetsuType.介護保険施設.getコード(), is(new RString("11")));
    }

    @Test
    public void 住所地特例対象施設を指定した場合_getコードは_12を返す() {
        assertThat(ShisetsuType.住所地特例対象施設.getコード(), is(new RString("12")));
    }

    @Test
    public void 適用除外施設を指定した場合_getコードは_21を返す() {
        assertThat(ShisetsuType.適用除外施設.getコード(), is(new RString("21")));
    }

    @Test
    public void 介護保険施設を指定した場合_get名称は_介護保険施設を返す() {
        assertThat(ShisetsuType.介護保険施設.get名称(), is(new RString("介護保険施設")));
    }

    @Test
    public void 住所地特例対象施設を指定した場合_get名称は_住所地特例対象施設を返す() {
        assertThat(ShisetsuType.住所地特例対象施設.get名称(), is(new RString("住所地特例対象施設")));
    }

    @Test
    public void 適用除外施設を指定した場合_get名称は_適用除外施設を返す() {
        assertThat(ShisetsuType.適用除外施設.get名称(), is(new RString("適用除外施設")));
    }

}
