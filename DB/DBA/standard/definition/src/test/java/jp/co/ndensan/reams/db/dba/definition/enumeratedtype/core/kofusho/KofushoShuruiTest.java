package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.core.kofusho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 交付証種類のテストクラスです。
 */
public class KofushoShuruiTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KofushoShurui.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KofushoShurui.toValue(new RString("99999"));
    }

    @Test
    public void 引数に001を指定した場合_toValueは_被保険者証を返す() {
        assertThat(KofushoShurui.toValue(new RString("001")), is(KofushoShurui.被保険者証));
    }

    @Test
    public void 引数に002を指定した場合_toValueは_資格者証を返す() {
        assertThat(KofushoShurui.toValue(new RString("002")), is(KofushoShurui.資格者証));
    }

    @Test
    public void 被保険者証を指定した場合_getコードは_001を返す() {
        assertThat(KofushoShurui.被保険者証.getコード(), is(new RString("001")));
    }

    @Test
    public void 資格者証を指定した場合_getコードは_002を返す() {
        assertThat(KofushoShurui.資格者証.getコード(), is(new RString("002")));
    }

    @Test
    public void 被保険者証を指定した場合_get名称は_被保険者証を返す() {
        assertThat(KofushoShurui.被保険者証.get名称(), is(new RString("被保険者証")));
    }

    @Test
    public void 資格者証を指定した場合_get名称は_資格者証を返す() {
        assertThat(KofushoShurui.資格者証.get名称(), is(new RString("資格者証")));
    }

}
