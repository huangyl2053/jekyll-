package jp.co.ndensan.reams.db.dbc.definition.core.riyoshafutandankai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 利用者負担段階のテストクラスです。
 * 
 * @author LDNS 
 */
public class RiyoshaFutanDankaiTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        RiyoshaFutanDankai.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        RiyoshaFutanDankai.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_第1段階を返す() {
        assertThat(RiyoshaFutanDankai.toValue(new RString("0")), is(RiyoshaFutanDankai.第1段階));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_第2段階を返す() {
        assertThat(RiyoshaFutanDankai.toValue(new RString("1")), is(RiyoshaFutanDankai.第2段階));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_第3段階を返す() {
        assertThat(RiyoshaFutanDankai.toValue(new RString("2")), is(RiyoshaFutanDankai.第3段階));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_課税層第3段階を返す() {
        assertThat(RiyoshaFutanDankai.toValue(new RString("3")), is(RiyoshaFutanDankai.課税層第3段階));
    }

    @Test
    public void 第1段階を指定した場合_getコードは_0を返す() {
        assertThat(RiyoshaFutanDankai.第1段階.getコード(), is(new RString("0")));
    }

    @Test
    public void 第2段階を指定した場合_getコードは_1を返す() {
        assertThat(RiyoshaFutanDankai.第2段階.getコード(), is(new RString("1")));
    }

    @Test
    public void 第3段階を指定した場合_getコードは_2を返す() {
        assertThat(RiyoshaFutanDankai.第3段階.getコード(), is(new RString("2")));
    }

    @Test
    public void 課税層第3段階を指定した場合_getコードは_3を返す() {
        assertThat(RiyoshaFutanDankai.課税層第3段階.getコード(), is(new RString("3")));
    }

    @Test
    public void 第1段階を指定した場合_get名称は_第1段階を返す() {
        assertThat(RiyoshaFutanDankai.第1段階.get名称(), is(new RString("第1段階")));
    }

    @Test
    public void 第2段階を指定した場合_get名称は_第2段階を返す() {
        assertThat(RiyoshaFutanDankai.第2段階.get名称(), is(new RString("第2段階")));
    }

    @Test
    public void 第3段階を指定した場合_get名称は_第3段階を返す() {
        assertThat(RiyoshaFutanDankai.第3段階.get名称(), is(new RString("第3段階")));
    }

    @Test
    public void 課税層第3段階を指定した場合_get名称は_課税層第3段階を返す() {
        assertThat(RiyoshaFutanDankai.課税層第3段階.get名称(), is(new RString("課税層第3段階")));
    }

}
