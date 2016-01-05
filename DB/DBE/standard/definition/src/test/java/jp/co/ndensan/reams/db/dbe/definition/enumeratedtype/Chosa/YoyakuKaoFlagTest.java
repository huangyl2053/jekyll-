package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 予約可能フラグのテストクラスです。
 *
 * @author LDNS
 */
public class YoyakuKaoFlagTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_可能を返す() {
        assertThat(YoyakuKaoFlag.toValue(true), is(YoyakuKaoFlag.可能));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_不可能を返す() {
        assertThat(YoyakuKaoFlag.toValue(false), is(YoyakuKaoFlag.不可能));
    }

    @Test
    public void 可能を指定した場合_getコードは_Trueを返す() {
        assertThat(YoyakuKaoFlag.可能.getコード(), is(true));
    }

    @Test
    public void 不可能を指定した場合_getコードは_Falseを返す() {
        assertThat(YoyakuKaoFlag.不可能.getコード(), is(false));
    }

    @Test
    public void 可能を指定した場合_get名称は_可能を返す() {
        assertThat(YoyakuKaoFlag.可能.get名称(), is(new RString("可能")));
    }

    @Test
    public void 不可能を指定した場合_get名称は_不可能を返す() {
        assertThat(YoyakuKaoFlag.不可能.get名称(), is(new RString("不可能")));
    }

}
