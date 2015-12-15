package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 主治医意見書依頼区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class IkenshoIraiKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        IkenshoIraiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        IkenshoIraiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_初回依頼を返す() {
        assertThat(IkenshoIraiKubun.toValue(new RString("1")), is(IkenshoIraiKubun.初回依頼));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_再依頼を返す() {
        assertThat(IkenshoIraiKubun.toValue(new RString("2")), is(IkenshoIraiKubun.再依頼));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_再意見書を返す() {
        assertThat(IkenshoIraiKubun.toValue(new RString("3")), is(IkenshoIraiKubun.再意見書));
    }

    @Test
    public void 初回依頼を指定した場合_getコードは_1を返す() {
        assertThat(IkenshoIraiKubun.初回依頼.getコード(), is(new RString("1")));
    }

    @Test
    public void 再依頼を指定した場合_getコードは_2を返す() {
        assertThat(IkenshoIraiKubun.再依頼.getコード(), is(new RString("2")));
    }

    @Test
    public void 再意見書を指定した場合_getコードは_3を返す() {
        assertThat(IkenshoIraiKubun.再意見書.getコード(), is(new RString("3")));
    }

    @Test
    public void 初回依頼を指定した場合_get名称は_初回依頼を返す() {
        assertThat(IkenshoIraiKubun.初回依頼.get名称(), is(new RString("初回依頼")));
    }

    @Test
    public void 再依頼を指定した場合_get名称は_再依頼を返す() {
        assertThat(IkenshoIraiKubun.再依頼.get名称(), is(new RString("再依頼")));
    }

    @Test
    public void 再意見書を指定した場合_get名称は_再意見書を返す() {
        assertThat(IkenshoIraiKubun.再意見書.get名称(), is(new RString("再意見書")));
    }

}
