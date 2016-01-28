package jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 資格変更事由のテストクラスです。
 *
 */
public class ShikakuHenkoJiyuTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShikakuHenkoJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShikakuHenkoJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_転居を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("21")), is(ShikakuHenkoJiyu.転居));
    }

    @Test
    public void 引数に22を指定した場合_toValueは_氏名変更を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("22")), is(ShikakuHenkoJiyu.氏名変更));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_広域内転居を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("11")), is(ShikakuHenkoJiyu.広域内転居));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_広住特適用を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("13")), is(ShikakuHenkoJiyu.広住特適用));
    }

    @Test
    public void 引数に14を指定した場合_toValueは_広住特転入を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("14")), is(ShikakuHenkoJiyu.広住特転入));
    }

    @Test
    public void 引数に15を指定した場合_toValueは_広住特居住を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("15")), is(ShikakuHenkoJiyu.広住特居住));
    }

    @Test
    public void 引数に17を指定した場合_toValueは_広住特転居を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("17")), is(ShikakuHenkoJiyu.広住特転居));
    }

    @Test
    public void 引数に16を指定した場合_toValueは_合併内転居を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("16")), is(ShikakuHenkoJiyu.合併内転居));
    }

    @Test
    public void 引数に41を指定した場合_toValueは_一本化を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("41")), is(ShikakuHenkoJiyu.一本化));
    }

    @Test
    public void 引数に31を指定した場合_toValueは_１号到達を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("31")), is(ShikakuHenkoJiyu._１号到達
        ));
    }

    @Test
    public void 引数に42を指定した場合_toValueは_合併を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("42")), is(ShikakuHenkoJiyu.合併));
    }

    @Test
    public void 引数に23を指定した場合_toValueは_帰化を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("23")), is(ShikakuHenkoJiyu.帰化));
    }

    @Test
    public void 引数に24を指定した場合_toValueは_国籍取得を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("24")), is(ShikakuHenkoJiyu.国籍取得));
    }

    @Test
    public void 引数に48を指定した場合_toValueは_その他を返す() {
        assertThat(ShikakuHenkoJiyu.toValue(new RString("48")), is(ShikakuHenkoJiyu.その他));
    }

    @Test
    public void 転居を指定した場合_getコードは_21を返す() {
        assertThat(ShikakuHenkoJiyu.転居.getコード(), is(new RString("21")));
    }

    @Test
    public void 氏名変更を指定した場合_getコードは_22を返す() {
        assertThat(ShikakuHenkoJiyu.氏名変更.getコード(), is(new RString("22")));
    }

    @Test
    public void 広域内転居を指定した場合_getコードは_11を返す() {
        assertThat(ShikakuHenkoJiyu.広域内転居.getコード(), is(new RString("11")));
    }

    @Test
    public void 広住特適用を指定した場合_getコードは_13を返す() {
        assertThat(ShikakuHenkoJiyu.広住特適用.getコード(), is(new RString("13")));
    }

    @Test
    public void 広住特転入を指定した場合_getコードは_14を返す() {
        assertThat(ShikakuHenkoJiyu.広住特転入.getコード(), is(new RString("14")));
    }

    @Test
    public void 広住特居住を指定した場合_getコードは_15を返す() {
        assertThat(ShikakuHenkoJiyu.広住特居住.getコード(), is(new RString("15")));
    }

    @Test
    public void 広住特転居を指定した場合_getコードは_17を返す() {
        assertThat(ShikakuHenkoJiyu.広住特転居.getコード(), is(new RString("17")));
    }

    @Test
    public void 合併内転居を指定した場合_getコードは_16を返す() {
        assertThat(ShikakuHenkoJiyu.合併内転居.getコード(), is(new RString("16")));
    }

    @Test
    public void 一本化を指定した場合_getコードは_41を返す() {
        assertThat(ShikakuHenkoJiyu.一本化.getコード(), is(new RString("41")));
    }

    @Test
    public void _１号到達を指定した場合_getコードは_31を返す() {
        assertThat(ShikakuHenkoJiyu._１号到達.getコード(), is(new RString("31"))
        );
    }

    @Test
    public void 合併を指定した場合_getコードは_42を返す() {
        assertThat(ShikakuHenkoJiyu.合併.getコード(), is(new RString("42")));
    }

    @Test
    public void 帰化を指定した場合_getコードは_23を返す() {
        assertThat(ShikakuHenkoJiyu.帰化.getコード(), is(new RString("23")));
    }

    @Test
    public void 国籍取得を指定した場合_getコードは_24を返す() {
        assertThat(ShikakuHenkoJiyu.国籍取得.getコード(), is(new RString("24")));
    }

    @Test
    public void その他を指定した場合_getコードは_48を返す() {
        assertThat(ShikakuHenkoJiyu.その他.getコード(), is(new RString("48")));
    }

    @Test
    public void 転居を指定した場合_get名称は_転居を返す() {
        assertThat(ShikakuHenkoJiyu.転居.get名称(), is(new RString("転居")));
    }

    @Test
    public void 氏名変更を指定した場合_get名称は_氏名変更を返す() {
        assertThat(ShikakuHenkoJiyu.氏名変更.get名称(), is(new RString("氏名変更")));
    }

    @Test
    public void 広域内転居を指定した場合_get名称は_広域内転居を返す() {
        assertThat(ShikakuHenkoJiyu.広域内転居.get名称(), is(new RString("広域内転居")));
    }

    @Test
    public void 広住特適用を指定した場合_get名称は_広住特適用を返す() {
        assertThat(ShikakuHenkoJiyu.広住特適用.get名称(), is(new RString("広住特適用")));
    }

    @Test
    public void 広住特転入を指定した場合_get名称は_広住特転入を返す() {
        assertThat(ShikakuHenkoJiyu.広住特転入.get名称(), is(new RString("広住特転入")));
    }

    @Test
    public void 広住特居住を指定した場合_get名称は_広住特居住を返す() {
        assertThat(ShikakuHenkoJiyu.広住特居住.get名称(), is(new RString("広住特居住")));
    }

    @Test
    public void 広住特転居を指定した場合_get名称は_広住特転居を返す() {
        assertThat(ShikakuHenkoJiyu.広住特転居.get名称(), is(new RString("広住特転居")));
    }

    @Test
    public void 合併内転居を指定した場合_get名称は_合併内転居を返す() {
        assertThat(ShikakuHenkoJiyu.合併内転居.get名称(), is(new RString("合併内転居")));
    }

    @Test
    public void 一本化を指定した場合_get名称は_一本化を返す() {
        assertThat(ShikakuHenkoJiyu.一本化.get名称(), is(new RString("一本化")));
    }

    @Test
    public void _１号到達を指定した場合_get名称は_１号到達を返す() {
        assertThat(ShikakuHenkoJiyu._１号到達.get名称(), is(new RString("１号到達"))
        );
    }

    @Test
    public void 合併を指定した場合_get名称は_合併を返す() {
        assertThat(ShikakuHenkoJiyu.合併.get名称(), is(new RString("合併")));
    }

    @Test
    public void 帰化を指定した場合_get名称は_帰化を返す() {
        assertThat(ShikakuHenkoJiyu.帰化.get名称(), is(new RString("帰化")));
    }

    @Test
    public void 国籍取得を指定した場合_get名称は_国籍取得を返す() {
        assertThat(ShikakuHenkoJiyu.国籍取得.get名称(), is(new RString("国籍取得")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(ShikakuHenkoJiyu.その他.get名称(), is(new RString("その他")));
    }

}
