package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * カスタマバーコード使用有無のテストクラスです。
 * 
 * @author LDNS 
 */
public class CustomerBarcodeShiyoUmuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        CustomerBarcodeShiyoUmu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        CustomerBarcodeShiyoUmu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_使用しないを返す() {
        assertThat(CustomerBarcodeShiyoUmu.toValue(new RString("0")), is(CustomerBarcodeShiyoUmu.使用しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_使用するを返す() {
        assertThat(CustomerBarcodeShiyoUmu.toValue(new RString("1")), is(CustomerBarcodeShiyoUmu.使用する));
    }

    @Test
    public void 使用しないを指定した場合_getコードは_0を返す() {
        assertThat(CustomerBarcodeShiyoUmu.使用しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 使用するを指定した場合_getコードは_1を返す() {
        assertThat(CustomerBarcodeShiyoUmu.使用する.getコード(), is(new RString("1")));
    }

    @Test
    public void 使用しないを指定した場合_get名称は_使用しないを返す() {
        assertThat(CustomerBarcodeShiyoUmu.使用しない.get名称(), is(new RString("使用しない")));
    }

    @Test
    public void 使用するを指定した場合_get名称は_使用するを返す() {
        assertThat(CustomerBarcodeShiyoUmu.使用する.get名称(), is(new RString("使用する")));
    }

}
