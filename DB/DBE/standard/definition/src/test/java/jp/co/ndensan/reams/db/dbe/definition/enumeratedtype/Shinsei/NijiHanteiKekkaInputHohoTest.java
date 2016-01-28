package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 二次判定結果入力方法のテストクラスです。
 * 
 * @author LDNS 
 */
public class NijiHanteiKekkaInputHohoTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NijiHanteiKekkaInputHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NijiHanteiKekkaInputHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_画面入力を返す() {
        assertThat(NijiHanteiKekkaInputHoho.toValue(new RString("1")), is(NijiHanteiKekkaInputHoho.画面入力));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_モバイル取込みを返す() {
        assertThat(NijiHanteiKekkaInputHoho.toValue(new RString("2")), is(NijiHanteiKekkaInputHoho.モバイル取込み));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_OCR取込みを返す() {
        assertThat(NijiHanteiKekkaInputHoho.toValue(new RString("3")), is(NijiHanteiKekkaInputHoho.OCR取込み));
    }

    @Test
    public void 画面入力を指定した場合_getコードは_1を返す() {
        assertThat(NijiHanteiKekkaInputHoho.画面入力.getコード(), is(new RString("1")));
    }

    @Test
    public void モバイル取込みを指定した場合_getコードは_2を返す() {
        assertThat(NijiHanteiKekkaInputHoho.モバイル取込み.getコード(), is(new RString("2")));
    }

    @Test
    public void OCR取込みを指定した場合_getコードは_3を返す() {
        assertThat(NijiHanteiKekkaInputHoho.OCR取込み.getコード(), is(new RString("3")));
    }

    @Test
    public void 画面入力を指定した場合_get名称は_画面入力を返す() {
        assertThat(NijiHanteiKekkaInputHoho.画面入力.get名称(), is(new RString("画面入力")));
    }

    @Test
    public void モバイル取込みを指定した場合_get名称は_モバイル取込みを返す() {
        assertThat(NijiHanteiKekkaInputHoho.モバイル取込み.get名称(), is(new RString("モバイル取込み")));
    }

    @Test
    public void OCR取込みを指定した場合_get名称は_OCR取込みを返す() {
        assertThat(NijiHanteiKekkaInputHoho.OCR取込み.get名称(), is(new RString("OCR取込み")));
    }

}
