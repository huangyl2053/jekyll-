package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 仮算定計算異動方法のテストクラスです。
 *
 * @author LDNS
 */
public class ZanteiKeisanIdoHohoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ZanteiKeisanIdoHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ZanteiKeisanIdoHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_4月喪失のみ0円にするを返す() {
        assertThat(ZanteiKeisanIdoHoho.toValue(new RString("1")), is(ZanteiKeisanIdoHoho._4月喪失のみ0円にする));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_喪失月以降0円にするを返す() {
        assertThat(ZanteiKeisanIdoHoho.toValue(new RString("2")), is(ZanteiKeisanIdoHoho.喪失月以降0円にする));
    }

    @Test
    public void _4月喪失のみ0円にするを指定した場合_getコードは_1を返す() {
        assertThat(ZanteiKeisanIdoHoho._4月喪失のみ0円にする.getコード(), is(new RString("1")));
    }

    @Test
    public void 喪失月以降0円にするを指定した場合_getコードは_2を返す() {
        assertThat(ZanteiKeisanIdoHoho.喪失月以降0円にする.getコード(), is(new RString("2")));
    }

    @Test
    public void _4月喪失のみ0円にするを指定した場合_get名称は__4月喪失のみ0円にするを返す() {
        assertThat(ZanteiKeisanIdoHoho._4月喪失のみ0円にする.get名称(), is(new RString("_4月喪失のみ0円にする")));
    }

    @Test
    public void 喪失月以降0円にするを指定した場合_get名称は_喪失月以降0円にするを返す() {
        assertThat(ZanteiKeisanIdoHoho.喪失月以降0円にする.get名称(), is(new RString("喪失月以降0円にする")));
    }

}
