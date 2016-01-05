package jp.co.ndensan.reams.db.dbc.definition.core.configkeys;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 受給者台帳突合結果情報随時コンフィグキーのテストクラスです。
 * 
 * @author LDNS 
 */
public class ConfigKeysJukyushaDaichoTotsugoKekkaTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ConfigKeysJukyushaDaichoTotsugoKekka.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("99999"));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_受給者台帳突合結果情報随時を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("無し")), is(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_受給者台帳突合結果情報随時_バッチIDを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("無し")), is(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_バッチID));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_受給者台帳突合結果情報随時_一覧表示順を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("無し")), is(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_一覧表示順));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_受給者台帳突合結果情報随時_交換情報識別番号を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("無し")), is(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_交換情報識別番号));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_受給者台帳突合結果情報随時_再処理不可区分を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("無し")), is(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_再処理不可区分));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_受給者台帳突合結果情報随時_処理サイクル区分を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("無し")), is(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理サイクル区分));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_受給者台帳突合結果情報随時_処理月を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("無し")), is(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理月));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_受給者台帳突合結果情報随時_処理名称を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("無し")), is(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理名称));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("無し")), is(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_国保連取込_受給者台帳突合結果情報随時_有効区分を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.toValue(new RString("無し")), is(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_有効区分));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_バッチIDを指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_バッチID.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_一覧表示順を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_一覧表示順.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_交換情報識別番号を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_交換情報識別番号.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_再処理不可区分を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_再処理不可区分.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_処理サイクル区分を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理サイクル区分.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_処理月を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理月.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_処理名称を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理名称.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_有効区分を指定した場合_getコードは_無しを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_有効区分.getコード(), is(new RString("無し")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時を指定した場合_get名称は_国保連取込_受給者台帳突合結果情報随時を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時.get名称(), is(new RString("国保連取込_受給者台帳突合結果情報随時")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_バッチIDを指定した場合_get名称は_国保連取込_受給者台帳突合結果情報随時_バッチIDを返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_バッチID.get名称(), is(new RString("国保連取込_受給者台帳突合結果情報随時_バッチID")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_一覧表示順を指定した場合_get名称は_国保連取込_受給者台帳突合結果情報随時_一覧表示順を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_一覧表示順.get名称(), is(new RString("国保連取込_受給者台帳突合結果情報随時_一覧表示順")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_交換情報識別番号を指定した場合_get名称は_国保連取込_受給者台帳突合結果情報随時_交換情報識別番号を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_交換情報識別番号.get名称(), is(new RString("国保連取込_受給者台帳突合結果情報随時_交換情報識別番号")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_再処理不可区分を指定した場合_get名称は_国保連取込_受給者台帳突合結果情報随時_再処理不可区分を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_再処理不可区分.get名称(), is(new RString("国保連取込_受給者台帳突合結果情報随時_再処理不可区分")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_処理サイクル区分を指定した場合_get名称は_国保連取込_受給者台帳突合結果情報随時_処理サイクル区分を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理サイクル区分.get名称(), is(new RString("国保連取込_受給者台帳突合結果情報随時_処理サイクル区分")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_処理月を指定した場合_get名称は_国保連取込_受給者台帳突合結果情報随時_処理月を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理月.get名称(), is(new RString("国保連取込_受給者台帳突合結果情報随時_処理月")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_処理名称を指定した場合_get名称は_国保連取込_受給者台帳突合結果情報随時_処理名称を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理名称.get名称(), is(new RString("国保連取込_受給者台帳突合結果情報随時_処理名称")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分を指定した場合_get名称は_国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分.get名称(), is(new RString("国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分")));
    }

    @Test
    public void 国保連取込_受給者台帳突合結果情報随時_有効区分を指定した場合_get名称は_国保連取込_受給者台帳突合結果情報随時_有効区分を返す() {
        assertThat(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_有効区分.get名称(), is(new RString("国保連取込_受給者台帳突合結果情報随時_有効区分")));
    }

}
