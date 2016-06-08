package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 取込連携データ共有ファイル名称のテストクラスです。
 * 
 * @author LDNS 
 */
public class TorikomiRenkeiDataKyoyuFileNameTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TorikomiRenkeiDataKyoyuFileName.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TorikomiRenkeiDataKyoyuFileName.toValue(new RString("99999"));
    }

    @Test
    public void 引数にA1を指定した場合_toValueは_住民異動情報_一定間隔を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.toValue(new RString("A1")), is(TorikomiRenkeiDataKyoyuFileName.住民異動情報_一定間隔));
    }

    @Test
    public void 引数にE1を指定した場合_toValueは_特徴対象者情報_年次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.toValue(new RString("E1")), is(TorikomiRenkeiDataKyoyuFileName.特徴対象者情報_年次));
    }

    @Test
    public void 引数にE2を指定した場合_toValueは_特徴依頼処理結果情報_年次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.toValue(new RString("E2")), is(TorikomiRenkeiDataKyoyuFileName.特徴依頼処理結果情報_年次));
    }

    @Test
    public void 引数にE3を指定した場合_toValueは_特別徴収結果情報_月次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.toValue(new RString("E3")), is(TorikomiRenkeiDataKyoyuFileName.特別徴収結果情報_月次));
    }

    @Test
    public void 引数にC1を指定した場合_toValueは_所得情報_年次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.toValue(new RString("C1")), is(TorikomiRenkeiDataKyoyuFileName.所得情報_年次));
    }

    @Test
    public void 引数にC2を指定した場合_toValueは_所得情報_月次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.toValue(new RString("C2")), is(TorikomiRenkeiDataKyoyuFileName.所得情報_月次));
    }

    @Test
    public void 引数にH1を指定した場合_toValueは_国保資格情報_月次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.toValue(new RString("H1")), is(TorikomiRenkeiDataKyoyuFileName.国保資格情報_月次));
    }

    @Test
    public void 引数にG1を指定した場合_toValueは_後期高齢受給資格情報_月次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.toValue(new RString("G1")), is(TorikomiRenkeiDataKyoyuFileName.後期高齢受給資格情報_月次));
    }

    @Test
    public void 住民異動情報_一定間隔を指定した場合_getコードは_A1を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.住民異動情報_一定間隔.getコード(), is(new RString("A1")));
    }

    @Test
    public void 特徴対象者情報_年次を指定した場合_getコードは_E1を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.特徴対象者情報_年次.getコード(), is(new RString("E1")));
    }

    @Test
    public void 特徴依頼処理結果情報_年次を指定した場合_getコードは_E2を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.特徴依頼処理結果情報_年次.getコード(), is(new RString("E2")));
    }

    @Test
    public void 特別徴収結果情報_月次を指定した場合_getコードは_E3を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.特別徴収結果情報_月次.getコード(), is(new RString("E3")));
    }

    @Test
    public void 所得情報_年次を指定した場合_getコードは_C1を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.所得情報_年次.getコード(), is(new RString("C1")));
    }

    @Test
    public void 所得情報_月次を指定した場合_getコードは_C2を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.所得情報_月次.getコード(), is(new RString("C2")));
    }

    @Test
    public void 国保資格情報_月次を指定した場合_getコードは_H1を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.国保資格情報_月次.getコード(), is(new RString("H1")));
    }

    @Test
    public void 後期高齢受給資格情報_月次を指定した場合_getコードは_G1を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.後期高齢受給資格情報_月次.getコード(), is(new RString("G1")));
    }

    @Test
    public void 住民異動情報_一定間隔を指定した場合_get名称は_住民異動情報_一定間隔を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.住民異動情報_一定間隔.get名称(), is(new RString("住民異動情報（一定間隔）")));
    }

    @Test
    public void 特徴対象者情報_年次を指定した場合_get名称は_特徴対象者情報_年次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.特徴対象者情報_年次.get名称(), is(new RString("特徴対象者情報（年次）")));
    }

    @Test
    public void 特徴依頼処理結果情報_年次を指定した場合_get名称は_特徴依頼処理結果情報_年次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.特徴依頼処理結果情報_年次.get名称(), is(new RString("特徴依頼処理結果情報（年次）")));
    }

    @Test
    public void 特別徴収結果情報_月次を指定した場合_get名称は_特別徴収結果情報_月次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.特別徴収結果情報_月次.get名称(), is(new RString("特別徴収結果情報（月次）")));
    }

    @Test
    public void 所得情報_年次を指定した場合_get名称は_所得情報_年次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.所得情報_年次.get名称(), is(new RString("所得情報（年次）")));
    }

    @Test
    public void 所得情報_月次を指定した場合_get名称は_所得情報_月次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.所得情報_月次.get名称(), is(new RString("所得情報（月次）")));
    }

    @Test
    public void 国保資格情報_月次を指定した場合_get名称は_国保資格情報_月次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.国保資格情報_月次.get名称(), is(new RString("国保資格情報（月次）")));
    }

    @Test
    public void 後期高齢受給資格情報_月次を指定した場合_get名称は_後期高齢受給資格情報_月次を返す() {
        assertThat(TorikomiRenkeiDataKyoyuFileName.後期高齢受給資格情報_月次.get名称(), is(new RString("後期高齢受給資格情報（月次）")));
    }

}
