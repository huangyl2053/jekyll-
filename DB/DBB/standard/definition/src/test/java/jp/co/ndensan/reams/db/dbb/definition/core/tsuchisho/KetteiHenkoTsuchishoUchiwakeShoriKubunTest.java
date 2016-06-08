package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 決定変更通知書打ち分け処理区分のテストクラスです。
 *
 * @author LDNS
 */
public class KetteiHenkoTsuchishoUchiwakeShoriKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KetteiHenkoTsuchishoUchiwakeShoriKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KetteiHenkoTsuchishoUchiwakeShoriKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_本算定賦課を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeShoriKubun.toValue(new RString("0")), is(KetteiHenkoTsuchishoUchiwakeShoriKubun.本算定賦課));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_異動賦課を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeShoriKubun.toValue(new RString("1")), is(KetteiHenkoTsuchishoUchiwakeShoriKubun.異動賦課));
    }

    @Test
    public void 本算定賦課を指定した場合_getコードは_0を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeShoriKubun.本算定賦課.getコード(), is(new RString("0")));
    }

    @Test
    public void 異動賦課を指定した場合_getコードは_1を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeShoriKubun.異動賦課.getコード(), is(new RString("1")));
    }

    @Test
    public void 本算定賦課を指定した場合_get名称は_本算定賦課を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeShoriKubun.本算定賦課.get名称(), is(new RString("本算定賦課")));
    }

    @Test
    public void 異動賦課を指定した場合_get名称は_異動賦課を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeShoriKubun.異動賦課.get名称(), is(new RString("異動賦課")));
    }

}
