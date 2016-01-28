package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 変更通知書タイプのテストクラスです。
 *
 * @author LDNS
 */
public class HenkoTsuchishoTypeTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HenkoTsuchishoType.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HenkoTsuchishoType.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_B5横を返す() {
        assertThat(HenkoTsuchishoType.toValue(new RString("01")), is(HenkoTsuchishoType.B5横));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_A4縦を返す() {
        assertThat(HenkoTsuchishoType.toValue(new RString("02")), is(HenkoTsuchishoType.A4縦));
    }

    @Test
    public void B5横を指定した場合_getコードは_01を返す() {
        assertThat(HenkoTsuchishoType.B5横.getコード(), is(new RString("01")));
    }

    @Test
    public void A4縦を指定した場合_getコードは_02を返す() {
        assertThat(HenkoTsuchishoType.A4縦.getコード(), is(new RString("02")));
    }

    @Test
    public void B5横を指定した場合_get名称は_B5横を返す() {
        assertThat(HenkoTsuchishoType.B5横.get名称(), is(new RString("B5横")));
    }

    @Test
    public void A4縦を指定した場合_get名称は_A4縦を返す() {
        assertThat(HenkoTsuchishoType.A4縦.get名称(), is(new RString("A4縦")));
    }

}
