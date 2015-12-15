package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 広域内転居区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class KoikinaiTenkyoKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KoikinaiTenkyoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KoikinaiTenkyoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_対象外を返す() {
        assertThat(KoikinaiTenkyoKubun.toValue(new RString("0")), is(KoikinaiTenkyoKubun.対象外));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_申請中を返す() {
        assertThat(KoikinaiTenkyoKubun.toValue(new RString("1")), is(KoikinaiTenkyoKubun.申請中));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_申請終了を返す() {
        assertThat(KoikinaiTenkyoKubun.toValue(new RString("2")), is(KoikinaiTenkyoKubun.申請終了));
    }

    @Test
    public void 対象外を指定した場合_getコードは_0を返す() {
        assertThat(KoikinaiTenkyoKubun.対象外.getコード(), is(new RString("0")));
    }

    @Test
    public void 申請中を指定した場合_getコードは_1を返す() {
        assertThat(KoikinaiTenkyoKubun.申請中.getコード(), is(new RString("1")));
    }

    @Test
    public void 申請終了を指定した場合_getコードは_2を返す() {
        assertThat(KoikinaiTenkyoKubun.申請終了.getコード(), is(new RString("2")));
    }

    @Test
    public void 対象外を指定した場合_get名称は_対象外を返す() {
        assertThat(KoikinaiTenkyoKubun.対象外.get名称(), is(new RString("対象外")));
    }

    @Test
    public void 申請中を指定した場合_get名称は_申請中を返す() {
        assertThat(KoikinaiTenkyoKubun.申請中.get名称(), is(new RString("申請中")));
    }

    @Test
    public void 申請終了を指定した場合_get名称は_申請終了を返す() {
        assertThat(KoikinaiTenkyoKubun.申請終了.get名称(), is(new RString("申請終了")));
    }

}
