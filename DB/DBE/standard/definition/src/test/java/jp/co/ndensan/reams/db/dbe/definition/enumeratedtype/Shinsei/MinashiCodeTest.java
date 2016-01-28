package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * みなし要介護区分コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class MinashiCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        MinashiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        MinashiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_通常の認定を返す() {
        assertThat(MinashiCode.toValue(new RString("1")), is(MinashiCode.通常の認定));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_みなし認定_旧措置入所者を返す() {
        assertThat(MinashiCode.toValue(new RString("2")), is(MinashiCode.みなし認定_旧措置入所者));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_やむを得ない事由を返す() {
        assertThat(MinashiCode.toValue(new RString("3")), is(MinashiCode.やむを得ない事由));
    }

    @Test
    public void 通常の認定を指定した場合_getコードは_1を返す() {
        assertThat(MinashiCode.通常の認定.getコード(), is(new RString("1")));
    }

    @Test
    public void みなし認定_旧措置入所者を指定した場合_getコードは_2を返す() {
        assertThat(MinashiCode.みなし認定_旧措置入所者.getコード(), is(new RString("2")));
    }

    @Test
    public void やむを得ない事由を指定した場合_getコードは_3を返す() {
        assertThat(MinashiCode.やむを得ない事由.getコード(), is(new RString("3")));
    }

    @Test
    public void 通常の認定を指定した場合_get名称は_通常の認定を返す() {
        assertThat(MinashiCode.通常の認定.get名称(), is(new RString("通常の認定")));
    }

    @Test
    public void みなし認定_旧措置入所者を指定した場合_get名称は_みなし認定_旧措置入所者を返す() {
        assertThat(MinashiCode.みなし認定_旧措置入所者.get名称(), is(new RString("みなし認定（旧措置入所者）")));
    }

    @Test
    public void やむを得ない事由を指定した場合_get名称は_やむを得ない事由を返す() {
        assertThat(MinashiCode.やむを得ない事由.get名称(), is(new RString("やむを得ない事由")));
    }

}
