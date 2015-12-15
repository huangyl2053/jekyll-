package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 審査会委員報酬区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShinsakaiIinHoshukubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinsakaiIinHoshukubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinsakaiIinHoshukubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_審査報酬を返す() {
        assertThat(ShinsakaiIinHoshukubun.toValue(new RString("1")), is(ShinsakaiIinHoshukubun.審査報酬));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_その他報酬を返す() {
        assertThat(ShinsakaiIinHoshukubun.toValue(new RString("2")), is(ShinsakaiIinHoshukubun.その他報酬));
    }

    @Test
    public void 審査報酬を指定した場合_getコードは_1を返す() {
        assertThat(ShinsakaiIinHoshukubun.審査報酬.getコード(), is(new RString("1")));
    }

    @Test
    public void その他報酬を指定した場合_getコードは_2を返す() {
        assertThat(ShinsakaiIinHoshukubun.その他報酬.getコード(), is(new RString("2")));
    }

    @Test
    public void 審査報酬を指定した場合_get名称は_審査報酬を返す() {
        assertThat(ShinsakaiIinHoshukubun.審査報酬.get名称(), is(new RString("審査報酬")));
    }

    @Test
    public void その他報酬を指定した場合_get名称は_その他報酬を返す() {
        assertThat(ShinsakaiIinHoshukubun.その他報酬.get名称(), is(new RString("その他報酬")));
    }

}
