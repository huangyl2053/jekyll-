package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 認定支援申請区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class NinteiShienShinseiKubunTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NinteiShienShinseiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NinteiShienShinseiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_認定支援申請以外を返す() {
        assertThat(NinteiShienShinseiKubun.toValue(new RString("0")), is(NinteiShienShinseiKubun.認定支援申請以外));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_認定支援申請を返す() {
        assertThat(NinteiShienShinseiKubun.toValue(new RString("1")), is(NinteiShienShinseiKubun.認定支援申請));
    }

    @Test
    public void 認定支援申請以外を指定した場合_getコードは_0を返す() {
        assertThat(NinteiShienShinseiKubun.認定支援申請以外.getコード(), is(new RString("0")));
    }

    @Test
    public void 認定支援申請を指定した場合_getコードは_1を返す() {
        assertThat(NinteiShienShinseiKubun.認定支援申請.getコード(), is(new RString("1")));
    }

    @Test
    public void 認定支援申請以外を指定した場合_get名称は_認定支援申請以外を返す() {
        assertThat(NinteiShienShinseiKubun.認定支援申請以外.get名称(), is(new RString("認定支援申請以外")));
    }

    @Test
    public void 認定支援申請を指定した場合_get名称は_認定支援申請を返す() {
        assertThat(NinteiShienShinseiKubun.認定支援申請.get名称(), is(new RString("認定支援申請")));
    }

}
