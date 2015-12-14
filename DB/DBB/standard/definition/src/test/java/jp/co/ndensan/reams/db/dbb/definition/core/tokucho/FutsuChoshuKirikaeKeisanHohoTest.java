package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 普通徴収切替計算方法のテストクラスです。
 *
 * @author LDNS
 */
public class FutsuChoshuKirikaeKeisanHohoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        FutsuChoshuKirikaeKeisanHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        FutsuChoshuKirikaeKeisanHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に00を指定した場合_toValueは_重複させないを返す() {
        assertThat(FutsuChoshuKirikaeKeisanHoho.toValue(new RString("00")), is(FutsuChoshuKirikaeKeisanHoho.重複させない));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_重複させるを返す() {
        assertThat(FutsuChoshuKirikaeKeisanHoho.toValue(new RString("01")), is(FutsuChoshuKirikaeKeisanHoho.重複させる));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_指定期以降重複させるを返す() {
        assertThat(FutsuChoshuKirikaeKeisanHoho.toValue(new RString("99")), is(FutsuChoshuKirikaeKeisanHoho.指定期以降重複させる));
    }

    @Test
    public void 重複させないを指定した場合_getコードは_00を返す() {
        assertThat(FutsuChoshuKirikaeKeisanHoho.重複させない.getコード(), is(new RString("00")));
    }

    @Test
    public void 重複させるを指定した場合_getコードは_01を返す() {
        assertThat(FutsuChoshuKirikaeKeisanHoho.重複させる.getコード(), is(new RString("01")));
    }

    @Test
    public void 指定期以降重複させるを指定した場合_getコードは_99を返す() {
        assertThat(FutsuChoshuKirikaeKeisanHoho.指定期以降重複させる.getコード(), is(new RString("99")));
    }

    @Test
    public void 重複させないを指定した場合_get名称は_重複させないを返す() {
        assertThat(FutsuChoshuKirikaeKeisanHoho.重複させない.get名称(), is(new RString("重複させない")));
    }

    @Test
    public void 重複させるを指定した場合_get名称は_重複させるを返す() {
        assertThat(FutsuChoshuKirikaeKeisanHoho.重複させる.get名称(), is(new RString("重複させる")));
    }

    @Test
    public void 指定期以降重複させるを指定した場合_get名称は_指定期以降重複させるを返す() {
        assertThat(FutsuChoshuKirikaeKeisanHoho.指定期以降重複させる.get名称(), is(new RString("指定期以降重複させる")));
    }

}
