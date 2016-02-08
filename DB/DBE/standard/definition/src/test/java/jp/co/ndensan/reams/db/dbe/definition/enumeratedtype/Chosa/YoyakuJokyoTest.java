package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 予約状況のテストクラスです。
 * 
 * @author LDNS 
 */
public class YoyakuJokyoTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        YoyakuJokyo.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        YoyakuJokyo.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_未定を返す() {
        assertThat(YoyakuJokyo.toValue(new RString("0")), is(YoyakuJokyo.未定));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_仮予約を返す() {
        assertThat(YoyakuJokyo.toValue(new RString("1")), is(YoyakuJokyo.仮予約));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_確定を返す() {
        assertThat(YoyakuJokyo.toValue(new RString("2")), is(YoyakuJokyo.確定));
    }

    @Test
    public void 未定を指定した場合_getコードは_0を返す() {
        assertThat(YoyakuJokyo.未定.getコード(), is(new RString("0")));
    }

    @Test
    public void 仮予約を指定した場合_getコードは_1を返す() {
        assertThat(YoyakuJokyo.仮予約.getコード(), is(new RString("1")));
    }

    @Test
    public void 確定を指定した場合_getコードは_2を返す() {
        assertThat(YoyakuJokyo.確定.getコード(), is(new RString("2")));
    }

    @Test
    public void 未定を指定した場合_get名称は_未定を返す() {
        assertThat(YoyakuJokyo.未定.get名称(), is(new RString("未定")));
    }

    @Test
    public void 仮予約を指定した場合_get名称は_仮予約を返す() {
        assertThat(YoyakuJokyo.仮予約.get名称(), is(new RString("仮予約")));
    }

    @Test
    public void 確定を指定した場合_get名称は_確定を返す() {
        assertThat(YoyakuJokyo.確定.get名称(), is(new RString("確定")));
    }

}
