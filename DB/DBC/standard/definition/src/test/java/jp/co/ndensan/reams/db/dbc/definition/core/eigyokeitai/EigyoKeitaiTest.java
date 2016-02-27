package jp.co.ndensan.reams.db.dbc.definition.core.eigyokeitai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 営業形態のテストクラスです。
 * 
 * @author LDNS 
 */
public class EigyoKeitaiTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        EigyoKeitai.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        EigyoKeitai.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_法人を返す() {
        assertThat(EigyoKeitai.toValue(new RString("1")), is(EigyoKeitai.法人));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_個人を返す() {
        assertThat(EigyoKeitai.toValue(new RString("2")), is(EigyoKeitai.個人));
    }

    @Test
    public void 法人を指定した場合_getコードは_1を返す() {
        assertThat(EigyoKeitai.法人.getコード(), is(new RString("1")));
    }

    @Test
    public void 個人を指定した場合_getコードは_2を返す() {
        assertThat(EigyoKeitai.個人.getコード(), is(new RString("2")));
    }

    @Test
    public void 法人を指定した場合_get名称は_法人を返す() {
        assertThat(EigyoKeitai.法人.get名称(), is(new RString("法人")));
    }

    @Test
    public void 個人を指定した場合_get名称は_個人を返す() {
        assertThat(EigyoKeitai.個人.get名称(), is(new RString("個人")));
    }

}
