package jp.co.ndensan.reams.db.dba.definition.core.shohyojitype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 被保険者証表示タイプのテストクラスです。
 *
 */
public class HihokenshashoHyojiTypeTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HihokenshashoHyojiType.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HihokenshashoHyojiType.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_A4横を返す() {
        assertThat(HihokenshashoHyojiType.toValue(new RString("01")), is(HihokenshashoHyojiType.A4横));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_B4横を返す() {
        assertThat(HihokenshashoHyojiType.toValue(new RString("21")), is(HihokenshashoHyojiType.B4横));
    }

    @Test
    public void A4横を指定した場合_getコードは_01を返す() {
        assertThat(HihokenshashoHyojiType.A4横.getコード(), is(new RString("01")));
    }

    @Test
    public void B4横を指定した場合_getコードは_21を返す() {
        assertThat(HihokenshashoHyojiType.B4横.getコード(), is(new RString("21")));
    }

    @Test
    public void A4横を指定した場合_get名称は_A4横を返す() {
        assertThat(HihokenshashoHyojiType.A4横.get名称(), is(new RString("A4横")));
    }

    @Test
    public void B4横を指定した場合_get名称は_B4横を返す() {
        assertThat(HihokenshashoHyojiType.B4横.get名称(), is(new RString("B4横")));
    }

}
