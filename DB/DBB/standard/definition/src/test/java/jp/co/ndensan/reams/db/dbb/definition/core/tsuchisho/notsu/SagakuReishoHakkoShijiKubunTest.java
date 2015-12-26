package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 差額令書発行指示区分のテストクラスです。
 *
 * @author LDNS
 */
public class SagakuReishoHakkoShijiKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SagakuReishoHakkoShijiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SagakuReishoHakkoShijiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_差額令書で発行するを返す() {
        assertThat(SagakuReishoHakkoShijiKubun.toValue(new RString("0")), is(SagakuReishoHakkoShijiKubun.差額令書で発行する));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_差額令書で発行しないを返す() {
        assertThat(SagakuReishoHakkoShijiKubun.toValue(new RString("1")), is(SagakuReishoHakkoShijiKubun.差額令書で発行しない));
    }

    @Test
    public void 差額令書で発行するを指定した場合_getコードは_0を返す() {
        assertThat(SagakuReishoHakkoShijiKubun.差額令書で発行する.getコード(), is(new RString("0")));
    }

    @Test
    public void 差額令書で発行しないを指定した場合_getコードは_1を返す() {
        assertThat(SagakuReishoHakkoShijiKubun.差額令書で発行しない.getコード(), is(new RString("1")));
    }

    @Test
    public void 差額令書で発行するを指定した場合_get名称は_差額令書で発行するを返す() {
        assertThat(SagakuReishoHakkoShijiKubun.差額令書で発行する.get名称(), is(new RString("差額令書で発行する")));
    }

    @Test
    public void 差額令書で発行しないを指定した場合_get名称は_差額令書で発行しないを返す() {
        assertThat(SagakuReishoHakkoShijiKubun.差額令書で発行しない.get名称(), is(new RString("差額令書で発行しない")));
    }

}
