package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 合議体長区分コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class GogitaichoKubunCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GogitaichoKubunCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GogitaichoKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_通常を返す() {
        assertThat(GogitaichoKubunCode.toValue(new RString("0")), is(GogitaichoKubunCode.通常));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_副合議体長を返す() {
        assertThat(GogitaichoKubunCode.toValue(new RString("1")), is(GogitaichoKubunCode.副合議体長));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_合議体長を返す() {
        assertThat(GogitaichoKubunCode.toValue(new RString("2")), is(GogitaichoKubunCode.合議体長));
    }

    @Test
    public void 通常を指定した場合_getコードは_0を返す() {
        assertThat(GogitaichoKubunCode.通常.getコード(), is(new RString("0")));
    }

    @Test
    public void 副合議体長を指定した場合_getコードは_1を返す() {
        assertThat(GogitaichoKubunCode.副合議体長.getコード(), is(new RString("1")));
    }

    @Test
    public void 合議体長を指定した場合_getコードは_2を返す() {
        assertThat(GogitaichoKubunCode.合議体長.getコード(), is(new RString("2")));
    }

    @Test
    public void 通常を指定した場合_get名称は_通常を返す() {
        assertThat(GogitaichoKubunCode.通常.get名称(), is(new RString("通常")));
    }

    @Test
    public void 副合議体長を指定した場合_get名称は_副合議体長を返す() {
        assertThat(GogitaichoKubunCode.副合議体長.get名称(), is(new RString("副合議体長")));
    }

    @Test
    public void 合議体長を指定した場合_get名称は_合議体長を返す() {
        assertThat(GogitaichoKubunCode.合議体長.get名称(), is(new RString("合議体長")));
    }

}
