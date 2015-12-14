package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 平準化開始期のテストクラスです。
 *
 * @author LDNS
 */
public class HeijunkaKaishiKiTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HeijunkaKaishiKi.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HeijunkaKaishiKi.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_二期から平準化を返す() {
        assertThat(HeijunkaKaishiKi.toValue(new RString("1")), is(HeijunkaKaishiKi.二期から平準化));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_三期から平準化を返す() {
        assertThat(HeijunkaKaishiKi.toValue(new RString("2")), is(HeijunkaKaishiKi.三期から平準化));
    }

    @Test
    public void 二期から平準化を指定した場合_getコードは_1を返す() {
        assertThat(HeijunkaKaishiKi.二期から平準化.getコード(), is(new RString("1")));
    }

    @Test
    public void 三期から平準化を指定した場合_getコードは_2を返す() {
        assertThat(HeijunkaKaishiKi.三期から平準化.getコード(), is(new RString("2")));
    }

    @Test
    public void 二期から平準化を指定した場合_get名称は_二期から平準化を返す() {
        assertThat(HeijunkaKaishiKi.二期から平準化.get名称(), is(new RString("二期から平準化")));
    }

    @Test
    public void 三期から平準化を指定した場合_get名称は_三期から平準化を返す() {
        assertThat(HeijunkaKaishiKi.三期から平準化.get名称(), is(new RString("三期から平準化")));
    }

}
