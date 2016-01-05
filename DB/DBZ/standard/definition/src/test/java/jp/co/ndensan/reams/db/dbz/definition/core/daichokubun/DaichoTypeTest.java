package jp.co.ndensan.reams.db.dbz.definition.core.daichokubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 台帳種別のテストクラスです。
 * 
 * @author LDNS 
 */
public class DaichoTypeTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        DaichoType.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        DaichoType.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_被保険者を返す() {
        assertThat(DaichoType.toValue(new RString("1")), is(DaichoType.被保険者));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_他市町村住所地特例者を返す() {
        assertThat(DaichoType.toValue(new RString("2")), is(DaichoType.他市町村住所地特例者));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_適用除外者を返す() {
        assertThat(DaichoType.toValue(new RString("3")), is(DaichoType.適用除外者));
    }

    @Test
    public void 被保険者を指定した場合_getコードは_1を返す() {
        assertThat(DaichoType.被保険者.getコード(), is(new RString("1")));
    }

    @Test
    public void 他市町村住所地特例者を指定した場合_getコードは_2を返す() {
        assertThat(DaichoType.他市町村住所地特例者.getコード(), is(new RString("2")));
    }

    @Test
    public void 適用除外者を指定した場合_getコードは_3を返す() {
        assertThat(DaichoType.適用除外者.getコード(), is(new RString("3")));
    }

    @Test
    public void 被保険者を指定した場合_get名称は_被保険者を返す() {
        assertThat(DaichoType.被保険者.get名称(), is(new RString("被保険者")));
    }

    @Test
    public void 他市町村住所地特例者を指定した場合_get名称は_他市町村住所地特例者を返す() {
        assertThat(DaichoType.他市町村住所地特例者.get名称(), is(new RString("他市町村住所地特例者")));
    }

    @Test
    public void 適用除外者を指定した場合_get名称は_適用除外者を返す() {
        assertThat(DaichoType.適用除外者.get名称(), is(new RString("適用除外者")));
    }

}
