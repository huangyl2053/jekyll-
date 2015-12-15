package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 意見書作成回数区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class IkenshoSakuseiKaisuKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        IkenshoSakuseiKaisuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        IkenshoSakuseiKaisuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_初回を返す() {
        assertThat(IkenshoSakuseiKaisuKubun.toValue(new RString("1")), is(IkenshoSakuseiKaisuKubun.初回));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_2回目以降を返す() {
        assertThat(IkenshoSakuseiKaisuKubun.toValue(new RString("2")), is(IkenshoSakuseiKaisuKubun._2回目以降));
    }

    @Test
    public void 初回を指定した場合_getコードは_1を返す() {
        assertThat(IkenshoSakuseiKaisuKubun.初回.getコード(), is(new RString("1")));
    }

    @Test
    public void _2回目以降を指定した場合_getコードは_2を返す() {
        assertThat(IkenshoSakuseiKaisuKubun._2回目以降.getコード(), is(new RString("2")));
    }

    @Test
    public void 初回を指定した場合_get名称は_初回を返す() {
        assertThat(IkenshoSakuseiKaisuKubun.初回.get名称(), is(new RString("初回")));
    }

    @Test
    public void _2回目以降を指定した場合_get名称は_2回目以降を返す() {
        assertThat(IkenshoSakuseiKaisuKubun._2回目以降.get名称(), is(new RString("2回目以降")));
    }

}
