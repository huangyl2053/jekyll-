package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 介護認定審査会進捗状況のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShinsakaiShinchokuJokyoTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinsakaiShinchokuJokyo.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinsakaiShinchokuJokyo.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_未開催を返す() {
        assertThat(ShinsakaiShinchokuJokyo.toValue(new RString("0")), is(ShinsakaiShinchokuJokyo.未開催));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_未開催_割付完了を返す() {
        assertThat(ShinsakaiShinchokuJokyo.toValue(new RString("1")), is(ShinsakaiShinchokuJokyo.未開催_割付完了));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_完了を返す() {
        assertThat(ShinsakaiShinchokuJokyo.toValue(new RString("2")), is(ShinsakaiShinchokuJokyo.完了));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_中止を返す() {
        assertThat(ShinsakaiShinchokuJokyo.toValue(new RString("9")), is(ShinsakaiShinchokuJokyo.中止));
    }

    @Test
    public void 未開催を指定した場合_getコードは_0を返す() {
        assertThat(ShinsakaiShinchokuJokyo.未開催.getコード(), is(new RString("0")));
    }

    @Test
    public void 未開催_割付完了を指定した場合_getコードは_1を返す() {
        assertThat(ShinsakaiShinchokuJokyo.未開催_割付完了.getコード(), is(new RString("1")));
    }

    @Test
    public void 完了を指定した場合_getコードは_2を返す() {
        assertThat(ShinsakaiShinchokuJokyo.完了.getコード(), is(new RString("2")));
    }

    @Test
    public void 中止を指定した場合_getコードは_9を返す() {
        assertThat(ShinsakaiShinchokuJokyo.中止.getコード(), is(new RString("9")));
    }

    @Test
    public void 未開催を指定した場合_get名称は_未開催を返す() {
        assertThat(ShinsakaiShinchokuJokyo.未開催.get名称(), is(new RString("未開催")));
    }

    @Test
    public void 未開催_割付完了を指定した場合_get名称は_未開催_割付完了を返す() {
        assertThat(ShinsakaiShinchokuJokyo.未開催_割付完了.get名称(), is(new RString("未開催/割付完了")));
    }

    @Test
    public void 完了を指定した場合_get名称は_完了を返す() {
        assertThat(ShinsakaiShinchokuJokyo.完了.get名称(), is(new RString("完了")));
    }

    @Test
    public void 中止を指定した場合_get名称は_中止を返す() {
        assertThat(ShinsakaiShinchokuJokyo.中止.get名称(), is(new RString("中止")));
    }

}
