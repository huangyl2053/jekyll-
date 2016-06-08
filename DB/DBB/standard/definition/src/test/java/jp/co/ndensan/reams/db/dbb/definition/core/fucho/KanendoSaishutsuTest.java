package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 過年度の歳出のテストクラスです。
 *
 * @author LDNS
 */
public class KanendoSaishutsuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KanendoSaishutsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KanendoSaishutsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_過年度を返す() {
        assertThat(KanendoSaishutsu.toValue(new RString("1")), is(KanendoSaishutsu.過年度));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_現年度を返す() {
        assertThat(KanendoSaishutsu.toValue(new RString("2")), is(KanendoSaishutsu.現年度));
    }

    @Test
    public void 過年度を指定した場合_getコードは_1を返す() {
        assertThat(KanendoSaishutsu.過年度.getコード(), is(new RString("1")));
    }

    @Test
    public void 現年度を指定した場合_getコードは_2を返す() {
        assertThat(KanendoSaishutsu.現年度.getコード(), is(new RString("2")));
    }

    @Test
    public void 過年度を指定した場合_get名称は_過年度を返す() {
        assertThat(KanendoSaishutsu.過年度.get名称(), is(new RString("過年度")));
    }

    @Test
    public void 現年度を指定した場合_get名称は_現年度を返す() {
        assertThat(KanendoSaishutsu.現年度.get名称(), is(new RString("現年度")));
    }

}
