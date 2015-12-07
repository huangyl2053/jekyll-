package jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 資格喪失事由のテストクラスです。
 *
 */
public class ShikakuSoshitsuJiyuTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShikakuSoshitsuJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShikakuSoshitsuJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に51を指定した場合_toValueは_転出を返す() {
        assertThat(ShikakuSoshitsuJiyu.toValue(new RString("51")), is(ShikakuSoshitsuJiyu.転出));
    }

    @Test
    public void 引数に52を指定した場合_toValueは_死亡を返す() {
        assertThat(ShikakuSoshitsuJiyu.toValue(new RString("52")), is(ShikakuSoshitsuJiyu.死亡));
    }

    @Test
    public void 引数に53を指定した場合_toValueは_除外者を返す() {
        assertThat(ShikakuSoshitsuJiyu.toValue(new RString("53")), is(ShikakuSoshitsuJiyu.除外者));
    }

    @Test
    public void 引数に55を指定した場合_toValueは_自特例解除を返す() {
        assertThat(ShikakuSoshitsuJiyu.toValue(new RString("55")), is(ShikakuSoshitsuJiyu.自特例解除));
    }

    @Test
    public void 引数に57を指定した場合_toValueは_国籍喪失を返す() {
        assertThat(ShikakuSoshitsuJiyu.toValue(new RString("57")), is(ShikakuSoshitsuJiyu.国籍喪失));
    }

    @Test
    public void 引数に58を指定した場合_toValueは_他特例者を返す() {
        assertThat(ShikakuSoshitsuJiyu.toValue(new RString("58")), is(ShikakuSoshitsuJiyu.他特例者));
    }

    @Test
    public void 引数に68を指定した場合_toValueは_職権喪失を返す() {
        assertThat(ShikakuSoshitsuJiyu.toValue(new RString("68")), is(ShikakuSoshitsuJiyu.職権喪失));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他を返す() {
        assertThat(ShikakuSoshitsuJiyu.toValue(new RString("99")), is(ShikakuSoshitsuJiyu.その他));
    }

    @Test
    public void 転出を指定した場合_getコードは_51を返す() {
        assertThat(ShikakuSoshitsuJiyu.転出.getコード(), is(new RString("51")));
    }

    @Test
    public void 死亡を指定した場合_getコードは_52を返す() {
        assertThat(ShikakuSoshitsuJiyu.死亡.getコード(), is(new RString("52")));
    }

    @Test
    public void 除外者を指定した場合_getコードは_53を返す() {
        assertThat(ShikakuSoshitsuJiyu.除外者.getコード(), is(new RString("53")));
    }

    @Test
    public void 自特例解除を指定した場合_getコードは_55を返す() {
        assertThat(ShikakuSoshitsuJiyu.自特例解除.getコード(), is(new RString("55")));
    }

    @Test
    public void 国籍喪失を指定した場合_getコードは_57を返す() {
        assertThat(ShikakuSoshitsuJiyu.国籍喪失.getコード(), is(new RString("57")));
    }

    @Test
    public void 他特例者を指定した場合_getコードは_58を返す() {
        assertThat(ShikakuSoshitsuJiyu.他特例者.getコード(), is(new RString("58")));
    }

    @Test
    public void 職権喪失を指定した場合_getコードは_68を返す() {
        assertThat(ShikakuSoshitsuJiyu.職権喪失.getコード(), is(new RString("68")));
    }

    @Test
    public void その他を指定した場合_getコードは_99を返す() {
        assertThat(ShikakuSoshitsuJiyu.その他.getコード(), is(new RString("99")));
    }

    @Test
    public void 転出を指定した場合_get名称は_転出を返す() {
        assertThat(ShikakuSoshitsuJiyu.転出.get名称(), is(new RString("転出")));
    }

    @Test
    public void 死亡を指定した場合_get名称は_死亡を返す() {
        assertThat(ShikakuSoshitsuJiyu.死亡.get名称(), is(new RString("死亡")));
    }

    @Test
    public void 除外者を指定した場合_get名称は_除外者を返す() {
        assertThat(ShikakuSoshitsuJiyu.除外者.get名称(), is(new RString("除外者")));
    }

    @Test
    public void 自特例解除を指定した場合_get名称は_自特例解除を返す() {
        assertThat(ShikakuSoshitsuJiyu.自特例解除.get名称(), is(new RString("自特例解除")));
    }

    @Test
    public void 国籍喪失を指定した場合_get名称は_国籍喪失を返す() {
        assertThat(ShikakuSoshitsuJiyu.国籍喪失.get名称(), is(new RString("国籍喪失")));
    }

    @Test
    public void 他特例者を指定した場合_get名称は_他特例者を返す() {
        assertThat(ShikakuSoshitsuJiyu.他特例者.get名称(), is(new RString("他特例者")));
    }

    @Test
    public void 職権喪失を指定した場合_get名称は_職権喪失を返す() {
        assertThat(ShikakuSoshitsuJiyu.職権喪失.get名称(), is(new RString("職権喪失")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(ShikakuSoshitsuJiyu.その他.get名称(), is(new RString("その他")));
    }

}
