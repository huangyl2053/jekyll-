package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 原本マスク区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class GenponMaskKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GenponMaskKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GenponMaskKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_原本を返す() {
        assertThat(GenponMaskKubun.toValue(new RString("1")), is(GenponMaskKubun.原本));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_マスクを返す() {
        assertThat(GenponMaskKubun.toValue(new RString("2")), is(GenponMaskKubun.マスク));
    }

    @Test
    public void 原本を指定した場合_getコードは_1を返す() {
        assertThat(GenponMaskKubun.原本.getコード(), is(new RString("1")));
    }

    @Test
    public void マスクを指定した場合_getコードは_2を返す() {
        assertThat(GenponMaskKubun.マスク.getコード(), is(new RString("2")));
    }

    @Test
    public void 原本を指定した場合_get名称は_原本を返す() {
        assertThat(GenponMaskKubun.原本.get名称(), is(new RString("原本")));
    }

    @Test
    public void マスクを指定した場合_get名称は_マスクを返す() {
        assertThat(GenponMaskKubun.マスク.get名称(), is(new RString("マスク")));
    }

}
