package jp.co.ndensan.reams.db.dbc.definition.core.configkeys;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 介護給付費過誤決定通知書公費情報コンフィグキーのテストクラスです。
 * 
 * @author LDNS 
 */
public class ConfigKeysKagoKetteiTuchi_KohiTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ConfigKeysKagoKetteiTuchi_Kohi.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("99999"));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_介護給付費過誤決定通知書公費情報を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("無し")), is(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_介護給付費過誤決定通知書公費情報_バッチIDを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("無し")), is(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_バッチID));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_介護給付費過誤決定通知書公費情報_一覧表示順を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("無し")), is(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_一覧表示順));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("無し")), is(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_介護給付費過誤決定通知書公費情報_再処理不可区分を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("無し")), is(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_再処理不可区分));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_介護給付費過誤決定通知書公費情報_処理サイクル区分を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("無し")), is(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理サイクル区分));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_介護給付費過誤決定通知書公費情報_処理月を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("無し")), is(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理月));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_介護給付費過誤決定通知書公費情報_処理名称を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("無し")), is(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理名称));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_介護給付費過誤決定通知書公費情報_排他チェック有り区分を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("無し")), is(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_排他チェック有り区分));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_介護給付費過誤決定通知書公費情報_有効区分を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.toValue(new RString("無し")), is(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_有効区分));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_バッチIDを指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_バッチID.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_一覧表示順を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_一覧表示順.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_再処理不可区分を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_再処理不可区分.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_処理サイクル区分を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理サイクル区分.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_処理月を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理月.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_処理名称を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理名称.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_排他チェック有り区分を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_排他チェック有り区分.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_有効区分を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_有効区分.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報を指定した場合_get名称は_国保連取込_介護給付費過誤決定通知書公費情報を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報.get名称(), is(new RString("国保連取込_介護給付費過誤決定通知書公費情報")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_バッチIDを指定した場合_get名称は_国保連取込_介護給付費過誤決定通知書公費情報_バッチIDを返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_バッチID.get名称(), is(new RString("国保連取込_介護給付費過誤決定通知書公費情報_バッチID")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_一覧表示順を指定した場合_get名称は_国保連取込_介護給付費過誤決定通知書公費情報_一覧表示順を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_一覧表示順.get名称(), is(new RString("国保連取込_介護給付費過誤決定通知書公費情報_一覧表示順")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号を指定した場合_get名称は_国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号.get名称(), is(new RString("国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_再処理不可区分を指定した場合_get名称は_国保連取込_介護給付費過誤決定通知書公費情報_再処理不可区分を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_再処理不可区分.get名称(), is(new RString("国保連取込_介護給付費過誤決定通知書公費情報_再処理不可区分")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_処理サイクル区分を指定した場合_get名称は_国保連取込_介護給付費過誤決定通知書公費情報_処理サイクル区分を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理サイクル区分.get名称(), is(new RString("国保連取込_介護給付費過誤決定通知書公費情報_処理サイクル区分")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_処理月を指定した場合_get名称は_国保連取込_介護給付費過誤決定通知書公費情報_処理月を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理月.get名称(), is(new RString("国保連取込_介護給付費過誤決定通知書公費情報_処理月")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_処理名称を指定した場合_get名称は_国保連取込_介護給付費過誤決定通知書公費情報_処理名称を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理名称.get名称(), is(new RString("国保連取込_介護給付費過誤決定通知書公費情報_処理名称")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_排他チェック有り区分を指定した場合_get名称は_国保連取込_介護給付費過誤決定通知書公費情報_排他チェック有り区分を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_排他チェック有り区分.get名称(), is(new RString("国保連取込_介護給付費過誤決定通知書公費情報_排他チェック有り区分")));
    }

    @Test
    public void 国保連取込_介護給付費過誤決定通知書公費情報_有効区分を指定した場合_get名称は_国保連取込_介護給付費過誤決定通知書公費情報_有効区分を返す() {
        assertThat(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_有効区分.get名称(), is(new RString("国保連取込_介護給付費過誤決定通知書公費情報_有効区分")));
    }

}
