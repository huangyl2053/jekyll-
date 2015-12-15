package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 通知書定型文管理項目番号のテストクラスです。
 * 
 * @author LDNS 
 */
public class TeikenbunKomokuNoTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TeikenbunKomokuNo.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TeikenbunKomokuNo.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_申請書文言を返す() {
        assertThat(TeikenbunKomokuNo.toValue(new RString("1")), is(TeikenbunKomokuNo.申請書文言));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_注意文言を返す() {
        assertThat(TeikenbunKomokuNo.toValue(new RString("2")), is(TeikenbunKomokuNo.注意文言));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_同意文言を返す() {
        assertThat(TeikenbunKomokuNo.toValue(new RString("3")), is(TeikenbunKomokuNo.同意文言));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_申請書文言２を返す() {
        assertThat(TeikenbunKomokuNo.toValue(new RString("4")), is(TeikenbunKomokuNo.申請書文言２));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_申請書文言３を返す() {
        assertThat(TeikenbunKomokuNo.toValue(new RString("5")), is(TeikenbunKomokuNo.申請書文言３));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_内容１を返す() {
        assertThat(TeikenbunKomokuNo.toValue(new RString("6")), is(TeikenbunKomokuNo.内容１));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_内容２を返す() {
        assertThat(TeikenbunKomokuNo.toValue(new RString("7")), is(TeikenbunKomokuNo.内容２));
    }

    @Test
    public void 引数に8を指定した場合_toValueは_内容３を返す() {
        assertThat(TeikenbunKomokuNo.toValue(new RString("8")), is(TeikenbunKomokuNo.内容３));
    }

    @Test
    public void 申請書文言を指定した場合_getコードは_1を返す() {
        assertThat(TeikenbunKomokuNo.申請書文言.getコード(), is(new RString("1")));
    }

    @Test
    public void 注意文言を指定した場合_getコードは_2を返す() {
        assertThat(TeikenbunKomokuNo.注意文言.getコード(), is(new RString("2")));
    }

    @Test
    public void 同意文言を指定した場合_getコードは_3を返す() {
        assertThat(TeikenbunKomokuNo.同意文言.getコード(), is(new RString("3")));
    }

    @Test
    public void 申請書文言２を指定した場合_getコードは_4を返す() {
        assertThat(TeikenbunKomokuNo.申請書文言２.getコード(), is(new RString("4")));
    }

    @Test
    public void 申請書文言３を指定した場合_getコードは_5を返す() {
        assertThat(TeikenbunKomokuNo.申請書文言３.getコード(), is(new RString("5")));
    }

    @Test
    public void 内容１を指定した場合_getコードは_6を返す() {
        assertThat(TeikenbunKomokuNo.内容１.getコード(), is(new RString("6")));
    }

    @Test
    public void 内容２を指定した場合_getコードは_7を返す() {
        assertThat(TeikenbunKomokuNo.内容２.getコード(), is(new RString("7")));
    }

    @Test
    public void 内容３を指定した場合_getコードは_8を返す() {
        assertThat(TeikenbunKomokuNo.内容３.getコード(), is(new RString("8")));
    }

    @Test
    public void 申請書文言を指定した場合_get名称は_申請書文言を返す() {
        assertThat(TeikenbunKomokuNo.申請書文言.get名称(), is(new RString("申請書文言")));
    }

    @Test
    public void 注意文言を指定した場合_get名称は_注意文言を返す() {
        assertThat(TeikenbunKomokuNo.注意文言.get名称(), is(new RString("注意文言")));
    }

    @Test
    public void 同意文言を指定した場合_get名称は_同意文言を返す() {
        assertThat(TeikenbunKomokuNo.同意文言.get名称(), is(new RString("同意文言")));
    }

    @Test
    public void 申請書文言２を指定した場合_get名称は_申請書文言２を返す() {
        assertThat(TeikenbunKomokuNo.申請書文言２.get名称(), is(new RString("申請書文言２")));
    }

    @Test
    public void 申請書文言３を指定した場合_get名称は_申請書文言３を返す() {
        assertThat(TeikenbunKomokuNo.申請書文言３.get名称(), is(new RString("申請書文言３")));
    }

    @Test
    public void 内容１を指定した場合_get名称は_内容１を返す() {
        assertThat(TeikenbunKomokuNo.内容１.get名称(), is(new RString("内容１")));
    }

    @Test
    public void 内容２を指定した場合_get名称は_内容２を返す() {
        assertThat(TeikenbunKomokuNo.内容２.get名称(), is(new RString("内容２")));
    }

    @Test
    public void 内容３を指定した場合_get名称は_内容３を返す() {
        assertThat(TeikenbunKomokuNo.内容３.get名称(), is(new RString("内容３")));
    }

}
