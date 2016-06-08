package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 世帯員把握管理識別区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class SetaiinHaakuKanriShikibetsuKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SetaiinHaakuKanriShikibetsuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SetaiinHaakuKanriShikibetsuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_賦課を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.toValue(new RString("1")), is(SetaiinHaakuKanriShikibetsuKubun.賦課));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_高額介護を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.toValue(new RString("2")), is(SetaiinHaakuKanriShikibetsuKubun.高額介護));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_負担限度額を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.toValue(new RString("3")), is(SetaiinHaakuKanriShikibetsuKubun.負担限度額));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_社福軽減を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.toValue(new RString("4")), is(SetaiinHaakuKanriShikibetsuKubun.社福軽減));
    }

    @Test
    public void 賦課を指定した場合_getコードは_1を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード(), is(new RString("1")));
    }

    @Test
    public void 高額介護を指定した場合_getコードは_2を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.高額介護.getコード(), is(new RString("2")));
    }

    @Test
    public void 負担限度額を指定した場合_getコードは_3を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.負担限度額.getコード(), is(new RString("3")));
    }

    @Test
    public void 社福軽減を指定した場合_getコードは_4を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.社福軽減.getコード(), is(new RString("4")));
    }

    @Test
    public void 賦課を指定した場合_get名称は_賦課を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.賦課.get名称(), is(new RString("賦課")));
    }

    @Test
    public void 高額介護を指定した場合_get名称は_高額介護を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.高額介護.get名称(), is(new RString("高額介護")));
    }

    @Test
    public void 負担限度額を指定した場合_get名称は_負担限度額を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.負担限度額.get名称(), is(new RString("負担限度額")));
    }

    @Test
    public void 社福軽減を指定した場合_get名称は_社福軽減を返す() {
        assertThat(SetaiinHaakuKanriShikibetsuKubun.社福軽減.get名称(), is(new RString("社福軽減")));
    }

}
