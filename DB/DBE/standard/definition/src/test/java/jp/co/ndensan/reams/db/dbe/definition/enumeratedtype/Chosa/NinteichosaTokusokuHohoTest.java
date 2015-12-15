package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 認定調査督促方法のテストクラスです。
 * 
 * @author LDNS 
 */
public class NinteichosaTokusokuHohoTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NinteichosaTokusokuHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NinteichosaTokusokuHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_督促状郵送を返す() {
        assertThat(NinteichosaTokusokuHoho.toValue(new RString("0")), is(NinteichosaTokusokuHoho.督促状郵送));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_督促状ＦＡＸを返す() {
        assertThat(NinteichosaTokusokuHoho.toValue(new RString("1")), is(NinteichosaTokusokuHoho.督促状ＦＡＸ));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_電話を返す() {
        assertThat(NinteichosaTokusokuHoho.toValue(new RString("2")), is(NinteichosaTokusokuHoho.電話));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_その他を返す() {
        assertThat(NinteichosaTokusokuHoho.toValue(new RString("3")), is(NinteichosaTokusokuHoho.その他));
    }

    @Test
    public void 督促状郵送を指定した場合_getコードは_0を返す() {
        assertThat(NinteichosaTokusokuHoho.督促状郵送.getコード(), is(new RString("0")));
    }

    @Test
    public void 督促状ＦＡＸを指定した場合_getコードは_1を返す() {
        assertThat(NinteichosaTokusokuHoho.督促状ＦＡＸ.getコード(), is(new RString("1")));
    }

    @Test
    public void 電話を指定した場合_getコードは_2を返す() {
        assertThat(NinteichosaTokusokuHoho.電話.getコード(), is(new RString("2")));
    }

    @Test
    public void その他を指定した場合_getコードは_3を返す() {
        assertThat(NinteichosaTokusokuHoho.その他.getコード(), is(new RString("3")));
    }

    @Test
    public void 督促状郵送を指定した場合_get名称は_督促状郵送を返す() {
        assertThat(NinteichosaTokusokuHoho.督促状郵送.get名称(), is(new RString("督促状郵送")));
    }

    @Test
    public void 督促状ＦＡＸを指定した場合_get名称は_督促状ＦＡＸを返す() {
        assertThat(NinteichosaTokusokuHoho.督促状ＦＡＸ.get名称(), is(new RString("督促状ＦＡＸ")));
    }

    @Test
    public void 電話を指定した場合_get名称は_電話を返す() {
        assertThat(NinteichosaTokusokuHoho.電話.get名称(), is(new RString("電話")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(NinteichosaTokusokuHoho.その他.get名称(), is(new RString("その他")));
    }

}
