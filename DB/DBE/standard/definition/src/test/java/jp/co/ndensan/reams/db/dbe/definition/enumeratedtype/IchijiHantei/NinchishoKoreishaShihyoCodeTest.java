package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 運動能力の低下していない認知症高齢者の指標コードのテストクラスです。
 *
 * @author LDNS
 */
public class NinchishoKoreishaShihyoCodeTest extends DbeTestBase {

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NinchishoKoreishaShihyoCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数にXX1を指定した場合_toValueは_XX1を返す() {
        assertThat(NinchishoKoreishaShihyoCode.toValue(new RString("XX1")), is(NinchishoKoreishaShihyoCode._XX1));
    }

    @Test
    public void 引数にXX2を指定した場合_toValueは_XX2を返す() {
        assertThat(NinchishoKoreishaShihyoCode.toValue(new RString("XX2")), is(NinchishoKoreishaShihyoCode._XX2));
    }

    @Test
    public void _XX1を指定した場合_getコードは_XX1を返す() {
        assertThat(NinchishoKoreishaShihyoCode._XX1.getコード(), is(new RString("XX1")));
    }

    @Test
    public void _XX2を指定した場合_getコードは_XX2を返す() {
        assertThat(NinchishoKoreishaShihyoCode._XX2.getコード(), is(new RString("XX2")));
    }

    @Test
    public void _XX1を指定した場合_get名称は_1を返す() {
        assertThat(NinchishoKoreishaShihyoCode._XX1.get名称(), is(new RString("？？？")));
    }

    @Test
    public void _XX2を指定した場合_get名称は_2を返す() {
        assertThat(NinchishoKoreishaShihyoCode._XX2.get名称(), is(new RString("？？？")));
    }

}
