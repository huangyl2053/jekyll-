package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 送付連携データ共有ファイル名称のテストクラスです。
 * 
 * @author LDNS 
 */
public class SofuRenkeiDataKyoyuFileNameTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SofuRenkeiDataKyoyuFileName.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SofuRenkeiDataKyoyuFileName.toValue(new RString("99999"));
    }

    @Test
    public void 引数にB1を指定した場合_toValueは_介護個別事項異動情報_一定間隔を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.toValue(new RString("B1")), is(SofuRenkeiDataKyoyuFileName.介護個別事項異動情報_一定間隔));
    }

    @Test
    public void 引数にF1を指定した場合_toValueは_特徴依頼情報_年次を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.toValue(new RString("F1")), is(SofuRenkeiDataKyoyuFileName.特徴依頼情報_年次));
    }

    @Test
    public void 引数にF2を指定した場合_toValueは_特徴各種異動情報_月次を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.toValue(new RString("F2")), is(SofuRenkeiDataKyoyuFileName.特徴各種異動情報_月次));
    }

    @Test
    public void 引数にF3を指定した場合_toValueは_特徴依頼データ_550バイトを返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.toValue(new RString("F3")), is(SofuRenkeiDataKyoyuFileName.特徴依頼データ_550バイト));
    }

    @Test
    public void 引数にI1を指定した場合_toValueは_介護資格情報_日次を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.toValue(new RString("I1")), is(SofuRenkeiDataKyoyuFileName.介護資格情報_日次));
    }

    @Test
    public void 引数にD1を指定した場合_toValueは_納付額情報_年次を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.toValue(new RString("D1")), is(SofuRenkeiDataKyoyuFileName.納付額情報_年次));
    }

    @Test
    public void 介護個別事項異動情報_一定間隔を指定した場合_getコードは_B1を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.介護個別事項異動情報_一定間隔.getコード(), is(new RString("B1")));
    }

    @Test
    public void 特徴依頼情報_年次を指定した場合_getコードは_F1を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.特徴依頼情報_年次.getコード(), is(new RString("F1")));
    }

    @Test
    public void 特徴各種異動情報_月次を指定した場合_getコードは_F2を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.特徴各種異動情報_月次.getコード(), is(new RString("F2")));
    }

    @Test
    public void 特徴依頼データ_550バイトを指定した場合_getコードは_F3を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.特徴依頼データ_550バイト.getコード(), is(new RString("F3")));
    }

    @Test
    public void 介護資格情報_日次を指定した場合_getコードは_I1を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.介護資格情報_日次.getコード(), is(new RString("I1")));
    }

    @Test
    public void 納付額情報_年次を指定した場合_getコードは_D1を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.納付額情報_年次.getコード(), is(new RString("D1")));
    }

    @Test
    public void 介護個別事項異動情報_一定間隔を指定した場合_get名称は_介護個別事項異動情報_一定間隔を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.介護個別事項異動情報_一定間隔.get名称(), is(new RString("介護個別事項異動情報（一定間隔）")));
    }

    @Test
    public void 特徴依頼情報_年次を指定した場合_get名称は_特徴依頼情報_年次を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.特徴依頼情報_年次.get名称(), is(new RString("特徴依頼情報（年次）")));
    }

    @Test
    public void 特徴各種異動情報_月次を指定した場合_get名称は_特徴各種異動情報_月次を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.特徴各種異動情報_月次.get名称(), is(new RString("特徴各種異動情報（月次）")));
    }

    @Test
    public void 特徴依頼データ_550バイトを指定した場合_get名称は_特徴依頼データ_550バイトを返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.特徴依頼データ_550バイト.get名称(), is(new RString("特徴依頼データ（550バイト）")));
    }

    @Test
    public void 介護資格情報_日次を指定した場合_get名称は_介護資格情報_日次を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.介護資格情報_日次.get名称(), is(new RString("介護資格情報（日次）")));
    }

    @Test
    public void 納付額情報_年次を指定した場合_get名称は_納付額情報_年次を返す() {
        assertThat(SofuRenkeiDataKyoyuFileName.納付額情報_年次.get名称(), is(new RString("納付額情報（年次）")));
    }

}
