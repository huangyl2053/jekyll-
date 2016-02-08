package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法変更終了区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShiharaiHenkoShuryoKubunTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHenkoShuryoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHenkoShuryoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_差止措置終了依頼書受理を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.toValue(new RString("01")), is(ShiharaiHenkoShuryoKubun.差止措置終了依頼書受理));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_弁明書受理を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.toValue(new RString("02")), is(ShiharaiHenkoShuryoKubun.弁明書受理));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_終了申請書受理を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.toValue(new RString("03")), is(ShiharaiHenkoShuryoKubun.終了申請書受理));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_減額免除申請書受理を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.toValue(new RString("04")), is(ShiharaiHenkoShuryoKubun.減額免除申請書受理));
    }

    @Test
    public void 引数に98を指定した場合_toValueは_職権を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.toValue(new RString("98")), is(ShiharaiHenkoShuryoKubun.職権));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.toValue(new RString("99")), is(ShiharaiHenkoShuryoKubun.その他));
    }

    @Test
    public void 差止措置終了依頼書受理を指定した場合_getコードは_01を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.差止措置終了依頼書受理.getコード(), is(new RString("01")));
    }

    @Test
    public void 弁明書受理を指定した場合_getコードは_02を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.弁明書受理.getコード(), is(new RString("02")));
    }

    @Test
    public void 終了申請書受理を指定した場合_getコードは_03を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.終了申請書受理.getコード(), is(new RString("03")));
    }

    @Test
    public void 減額免除申請書受理を指定した場合_getコードは_04を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.減額免除申請書受理.getコード(), is(new RString("04")));
    }

    @Test
    public void 職権を指定した場合_getコードは_98を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.職権.getコード(), is(new RString("98")));
    }

    @Test
    public void その他を指定した場合_getコードは_99を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.その他.getコード(), is(new RString("99")));
    }

    @Test
    public void 差止措置終了依頼書受理を指定した場合_get名称は_差止措置終了依頼書受理を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.差止措置終了依頼書受理.get名称(), is(new RString("差止措置終了依頼書受理")));
    }

    @Test
    public void 弁明書受理を指定した場合_get名称は_弁明書受理を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.弁明書受理.get名称(), is(new RString("弁明書受理")));
    }

    @Test
    public void 終了申請書受理を指定した場合_get名称は_終了申請書受理を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.終了申請書受理.get名称(), is(new RString("終了申請書受理")));
    }

    @Test
    public void 減額免除申請書受理を指定した場合_get名称は_減額免除申請書受理を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.減額免除申請書受理.get名称(), is(new RString("減額免除申請書受理")));
    }

    @Test
    public void 職権を指定した場合_get名称は_職権を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.職権.get名称(), is(new RString("職権")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(ShiharaiHenkoShuryoKubun.その他.get名称(), is(new RString("その他")));
    }

}
