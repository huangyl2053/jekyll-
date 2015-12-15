package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 訪問種別のテストクラスです。
 * 
 * @author LDNS 
 */
public class HomonShubetsuTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HomonShubetsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HomonShubetsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_1を返す() {
        assertThat(HomonShubetsu.toValue(new RString("1")), is(HomonShubetsu._1));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_2を返す() {
        assertThat(HomonShubetsu.toValue(new RString("2")), is(HomonShubetsu._2));
    }

    @Test
    public void _1を指定した場合_getコードは_1を返す() {
        assertThat(HomonShubetsu._1.getコード(), is(new RString("1")));
    }

    @Test
    public void _2を指定した場合_getコードは_2を返す() {
        assertThat(HomonShubetsu._2.getコード(), is(new RString("2")));
    }

    @Test
    public void _1を指定した場合_get名称は_を返す() {
        assertThat(HomonShubetsu._1.get名称(), is(new RString("")));
    }

    @Test
    public void _2を指定した場合_get名称は_を返す() {
        assertThat(HomonShubetsu._2.get名称(), is(new RString("")));
    }

}
