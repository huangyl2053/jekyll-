package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 認定調査依頼区分コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class NinteiChousaIraiKubunCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NinteiChousaIraiKubunCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NinteiChousaIraiKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_初回を返す() {
        assertThat(NinteiChousaIraiKubunCode.toValue(new RString("0")), is(NinteiChousaIraiKubunCode.初回));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_再依頼を返す() {
        assertThat(NinteiChousaIraiKubunCode.toValue(new RString("1")), is(NinteiChousaIraiKubunCode.再依頼));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_再調査を返す() {
        assertThat(NinteiChousaIraiKubunCode.toValue(new RString("2")), is(NinteiChousaIraiKubunCode.再調査));
    }

    @Test
    public void 初回を指定した場合_getコードは_0を返す() {
        assertThat(NinteiChousaIraiKubunCode.初回.getコード(), is(new RString("0")));
    }

    @Test
    public void 再依頼を指定した場合_getコードは_1を返す() {
        assertThat(NinteiChousaIraiKubunCode.再依頼.getコード(), is(new RString("1")));
    }

    @Test
    public void 再調査を指定した場合_getコードは_2を返す() {
        assertThat(NinteiChousaIraiKubunCode.再調査.getコード(), is(new RString("2")));
    }

    @Test
    public void 初回を指定した場合_get名称は_初回を返す() {
        assertThat(NinteiChousaIraiKubunCode.初回.get名称(), is(new RString("初回")));
    }

    @Test
    public void 再依頼を指定した場合_get名称は_再依頼を返す() {
        assertThat(NinteiChousaIraiKubunCode.再依頼.get名称(), is(new RString("再依頼")));
    }

    @Test
    public void 再調査を指定した場合_get名称は_再調査を返す() {
        assertThat(NinteiChousaIraiKubunCode.再調査.get名称(), is(new RString("再調査")));
    }

}
