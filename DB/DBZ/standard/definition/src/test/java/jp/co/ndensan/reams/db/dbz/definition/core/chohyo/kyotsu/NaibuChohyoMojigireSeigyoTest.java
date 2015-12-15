package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 内部帳票文字切れ制御のテストクラスです。
 * 
 * @author LDNS 
 */
public class NaibuChohyoMojigireSeigyoTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NaibuChohyoMojigireSeigyo.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NaibuChohyoMojigireSeigyo.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_印字可能範囲まで印字するを返す() {
        assertThat(NaibuChohyoMojigireSeigyo.toValue(new RString("1")), is(NaibuChohyoMojigireSeigyo.印字可能範囲まで印字する));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_ｵｰﾊﾞｰﾌﾛｰ文字を印字するを返す() {
        assertThat(NaibuChohyoMojigireSeigyo.toValue(new RString("2")), is(NaibuChohyoMojigireSeigyo.ｵｰﾊﾞｰﾌﾛｰ文字を印字する));
    }

    @Test
    public void 印字可能範囲まで印字するを指定した場合_getコードは_1を返す() {
        assertThat(NaibuChohyoMojigireSeigyo.印字可能範囲まで印字する.getコード(), is(new RString("1")));
    }

    @Test
    public void ｵｰﾊﾞｰﾌﾛｰ文字を印字するを指定した場合_getコードは_2を返す() {
        assertThat(NaibuChohyoMojigireSeigyo.ｵｰﾊﾞｰﾌﾛｰ文字を印字する.getコード(), is(new RString("2")));
    }

    @Test
    public void 印字可能範囲まで印字するを指定した場合_get名称は_印字可能範囲まで印字するを返す() {
        assertThat(NaibuChohyoMojigireSeigyo.印字可能範囲まで印字する.get名称(), is(new RString("印字可能範囲まで印字する")));
    }

    @Test
    public void ｵｰﾊﾞｰﾌﾛｰ文字を印字するを指定した場合_get名称は_オーバーフロー文字を印字するを返す() {
        assertThat(NaibuChohyoMojigireSeigyo.ｵｰﾊﾞｰﾌﾛｰ文字を印字する.get名称(), is(new RString("オーバーフロー文字を印字する")));
    }

    @Test
    public void 印字可能範囲まで印字するを指定した場合_get略称は_印字可能範囲まで印字するを返す() {
        assertThat(NaibuChohyoMojigireSeigyo.印字可能範囲まで印字する.get略称(), is(new RString("印字可能範囲まで印字する")));
    }

    @Test
    public void ｵｰﾊﾞｰﾌﾛｰ文字を印字するを指定した場合_get略称は_ｵｰﾊﾞｰﾌﾛｰ文字を印字するを返す() {
        assertThat(NaibuChohyoMojigireSeigyo.ｵｰﾊﾞｰﾌﾛｰ文字を印字する.get略称(), is(new RString("ｵｰﾊﾞｰﾌﾛｰ文字を印字する")));
    }

}
