package jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 資格取得事由のテストクラスです。
 *
 * @author LDNS
 */
public class ShikakuShutokuJiyuTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShikakuShutokuJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShikakuShutokuJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_転入を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("01")), is(ShikakuShutokuJiyu.転入));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_年齢到達を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("02")), is(ShikakuShutokuJiyu.年齢到達));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_外国人を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("03")), is(ShikakuShutokuJiyu.外国人));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_２号申請を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("04")), is(ShikakuShutokuJiyu._２号申請
        ));
    }

    @Test
    public void 引数に07を指定した場合_toValueは_他特例居住を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("07")), is(ShikakuShutokuJiyu.他特例居住));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_除外者居住を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("08")), is(ShikakuShutokuJiyu.除外者居住));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_帰化を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("09")), is(ShikakuShutokuJiyu.帰化));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_国籍取得を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("12")), is(ShikakuShutokuJiyu.国籍取得));
    }

    @Test
    public void 引数に18を指定した場合_toValueは_職権取得を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("18")), is(ShikakuShutokuJiyu.職権取得));
    }

    @Test
    public void 引数に46を指定した場合_toValueは_施行時取得を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("46")), is(ShikakuShutokuJiyu.施行時取得));
    }

    @Test
    public void 引数に49を指定した場合_toValueは_その他を返す() {
        assertThat(ShikakuShutokuJiyu.toValue(new RString("49")), is(ShikakuShutokuJiyu.その他));
    }

    @Test
    public void 転入を指定した場合_getコードは_01を返す() {
        assertThat(ShikakuShutokuJiyu.転入.getコード(), is(new RString("01")));
    }

    @Test
    public void 年齢到達を指定した場合_getコードは_02を返す() {
        assertThat(ShikakuShutokuJiyu.年齢到達.getコード(), is(new RString("02")));
    }

    @Test
    public void 外国人を指定した場合_getコードは_03を返す() {
        assertThat(ShikakuShutokuJiyu.外国人.getコード(), is(new RString("03")));
    }

    @Test
    public void _２号申請を指定した場合_getコードは_04を返す() {
        assertThat(ShikakuShutokuJiyu._２号申請.getコード(), is(new RString("04"))
        );
    }

    @Test
    public void 他特例居住を指定した場合_getコードは_07を返す() {
        assertThat(ShikakuShutokuJiyu.他特例居住.getコード(), is(new RString("07")));
    }

    @Test
    public void 除外者居住を指定した場合_getコードは_08を返す() {
        assertThat(ShikakuShutokuJiyu.除外者居住.getコード(), is(new RString("08")));
    }

    @Test
    public void 帰化を指定した場合_getコードは_09を返す() {
        assertThat(ShikakuShutokuJiyu.帰化.getコード(), is(new RString("09")));
    }

    @Test
    public void 国籍取得を指定した場合_getコードは_12を返す() {
        assertThat(ShikakuShutokuJiyu.国籍取得.getコード(), is(new RString("12")));
    }

    @Test
    public void 職権取得を指定した場合_getコードは_18を返す() {
        assertThat(ShikakuShutokuJiyu.職権取得.getコード(), is(new RString("18")));
    }

    @Test
    public void 施行時取得を指定した場合_getコードは_46を返す() {
        assertThat(ShikakuShutokuJiyu.施行時取得.getコード(), is(new RString("46")));
    }

    @Test
    public void その他を指定した場合_getコードは_49を返す() {
        assertThat(ShikakuShutokuJiyu.その他.getコード(), is(new RString("49")));
    }

    @Test
    public void 転入を指定した場合_get名称は_転入を返す() {
        assertThat(ShikakuShutokuJiyu.転入.get名称(), is(new RString("転入")));
    }

    @Test
    public void 年齢到達を指定した場合_get名称は_年齢到達を返す() {
        assertThat(ShikakuShutokuJiyu.年齢到達.get名称(), is(new RString("年齢到達")));
    }

    @Test
    public void 外国人を指定した場合_get名称は_外国人を返す() {
        assertThat(ShikakuShutokuJiyu.外国人.get名称(), is(new RString("外国人")));
    }

    @Test
    public void _２号申請を指定した場合_get名称は_２号申請を返す() {
        assertThat(ShikakuShutokuJiyu._２号申請.get名称(), is(new RString("２号申請"))
        );
    }

    @Test
    public void 他特例居住を指定した場合_get名称は_他特例居住を返す() {
        assertThat(ShikakuShutokuJiyu.他特例居住.get名称(), is(new RString("他特例居住")));
    }

    @Test
    public void 除外者居住を指定した場合_get名称は_除外者居住を返す() {
        assertThat(ShikakuShutokuJiyu.除外者居住.get名称(), is(new RString("除外者居住")));
    }

    @Test
    public void 帰化を指定した場合_get名称は_帰化を返す() {
        assertThat(ShikakuShutokuJiyu.帰化.get名称(), is(new RString("帰化")));
    }

    @Test
    public void 国籍取得を指定した場合_get名称は_国籍取得を返す() {
        assertThat(ShikakuShutokuJiyu.国籍取得.get名称(), is(new RString("国籍取得")));
    }

    @Test
    public void 職権取得を指定した場合_get名称は_職権取得を返す() {
        assertThat(ShikakuShutokuJiyu.職権取得.get名称(), is(new RString("職権取得")));
    }

    @Test
    public void 施行時取得を指定した場合_get名称は_施行時取得を返す() {
        assertThat(ShikakuShutokuJiyu.施行時取得.get名称(), is(new RString("施行時取得")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(ShikakuShutokuJiyu.その他.get名称(), is(new RString("その他")));
    }

}
