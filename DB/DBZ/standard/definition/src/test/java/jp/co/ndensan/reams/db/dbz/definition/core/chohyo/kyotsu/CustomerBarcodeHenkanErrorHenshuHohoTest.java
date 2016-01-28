package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * カスタマバーコード変換エラー編集方法のテストクラスです。
 * 
 * @author LDNS 
 */
public class CustomerBarcodeHenkanErrorHenshuHohoTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        CustomerBarcodeHenkanErrorHenshuHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        CustomerBarcodeHenkanErrorHenshuHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_空白をセットを返す() {
        assertThat(CustomerBarcodeHenkanErrorHenshuHoho.toValue(new RString("1")), is(CustomerBarcodeHenkanErrorHenshuHoho.空白をセット));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_入力郵便番号をセットを返す() {
        assertThat(CustomerBarcodeHenkanErrorHenshuHoho.toValue(new RString("2")), is(CustomerBarcodeHenkanErrorHenshuHoho.入力郵便番号をセット));
    }

    @Test
    public void 空白をセットを指定した場合_getコードは_1を返す() {
        assertThat(CustomerBarcodeHenkanErrorHenshuHoho.空白をセット.getコード(), is(new RString("1")));
    }

    @Test
    public void 入力郵便番号をセットを指定した場合_getコードは_2を返す() {
        assertThat(CustomerBarcodeHenkanErrorHenshuHoho.入力郵便番号をセット.getコード(), is(new RString("2")));
    }

    @Test
    public void 空白をセットを指定した場合_get名称は_空白をセットを返す() {
        assertThat(CustomerBarcodeHenkanErrorHenshuHoho.空白をセット.get名称(), is(new RString("空白をセット")));
    }

    @Test
    public void 入力郵便番号をセットを指定した場合_get名称は_入力郵便番号をセットを返す() {
        assertThat(CustomerBarcodeHenkanErrorHenshuHoho.入力郵便番号をセット.get名称(), is(new RString("入力郵便番号をセット")));
    }

}
