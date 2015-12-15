package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 被保険者区分コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class HihokenshaKubunCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HihokenshaKubunCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HihokenshaKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_第１号被保険者を返す() {
        assertThat(HihokenshaKubunCode.toValue(new RString("1")), is(HihokenshaKubunCode.第１号被保険者));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_第２号被保険者を返す() {
        assertThat(HihokenshaKubunCode.toValue(new RString("2")), is(HihokenshaKubunCode.第２号被保険者));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_その他を返す() {
        assertThat(HihokenshaKubunCode.toValue(new RString("3")), is(HihokenshaKubunCode.その他));
    }

    @Test
    public void 第１号被保険者を指定した場合_getコードは_1を返す() {
        assertThat(HihokenshaKubunCode.第１号被保険者.getコード(), is(new RString("1")));
    }

    @Test
    public void 第２号被保険者を指定した場合_getコードは_2を返す() {
        assertThat(HihokenshaKubunCode.第２号被保険者.getコード(), is(new RString("2")));
    }

    @Test
    public void その他を指定した場合_getコードは_3を返す() {
        assertThat(HihokenshaKubunCode.その他.getコード(), is(new RString("3")));
    }

    @Test
    public void 第１号被保険者を指定した場合_get名称は_第１号被保険者を返す() {
        assertThat(HihokenshaKubunCode.第１号被保険者.get名称(), is(new RString("第１号被保険者")));
    }

    @Test
    public void 第２号被保険者を指定した場合_get名称は_第２号被保険者を返す() {
        assertThat(HihokenshaKubunCode.第２号被保険者.get名称(), is(new RString("第２号被保険者")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(HihokenshaKubunCode.その他.get名称(), is(new RString("その他")));
    }

}
