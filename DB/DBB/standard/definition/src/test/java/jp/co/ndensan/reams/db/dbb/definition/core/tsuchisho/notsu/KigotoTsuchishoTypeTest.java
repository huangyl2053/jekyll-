package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 期毎納入通知書タイプのテストクラスです。
 *
 * @author LDNS
 */
public class KigotoTsuchishoTypeTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KigotoTsuchishoType.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KigotoTsuchishoType.toValue(new RString("99999"));
    }

    @Test
    public void 引数に001を指定した場合_toValueは_標準版期毎タイプを返す() {
        assertThat(KigotoTsuchishoType.toValue(new RString("001")), is(KigotoTsuchishoType.標準版期毎タイプ));
    }

    @Test
    public void 標準版期毎タイプを指定した場合_getコードは_001を返す() {
        assertThat(KigotoTsuchishoType.標準版期毎タイプ.getコード(), is(new RString("001")));
    }

    @Test
    public void 標準版期毎タイプを指定した場合_get名称は_標準版期毎タイプを返す() {
        assertThat(KigotoTsuchishoType.標準版期毎タイプ.get名称(), is(new RString("標準版期毎タイプ")));
    }

}
