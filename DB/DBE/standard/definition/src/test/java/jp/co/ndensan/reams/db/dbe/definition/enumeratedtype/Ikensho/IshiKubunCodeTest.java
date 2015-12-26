package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 医師区分コードのテストクラスです。
 *
 * @author LDNS
 */
public class IshiKubunCodeTest extends DbeTestBase {

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        IshiKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_主治医を返す() {
        assertThat(IshiKubunCode.toValue(new RString("1")), is(IshiKubunCode.主治医));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_指定医を返す() {
        assertThat(IshiKubunCode.toValue(new RString("2")), is(IshiKubunCode.指定医));
    }

    @Test
    public void 主治医を指定した場合_getコードは_1を返す() {
        assertThat(IshiKubunCode.主治医.getコード(), is(new RString("1")));
    }

    @Test
    public void 指定医を指定した場合_getコードは_2を返す() {
        assertThat(IshiKubunCode.指定医.getコード(), is(new RString("2")));
    }

    @Test
    public void 主治医を指定した場合_get名称は_主治医を返す() {
        assertThat(IshiKubunCode.主治医.get名称(), is(new RString("主治医")));
    }

    @Test
    public void 指定医を指定した場合_get名称は_指定医を返す() {
        assertThat(IshiKubunCode.指定医.get名称(), is(new RString("指定医")));
    }

}
