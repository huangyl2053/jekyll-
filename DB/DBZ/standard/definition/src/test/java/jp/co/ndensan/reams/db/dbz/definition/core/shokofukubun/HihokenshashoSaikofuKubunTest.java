package jp.co.ndensan.reams.db.dbz.definition.core.shokofukubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 被保険者証再交付の有無のテストクラスです。
 * 
 * @author LDNS 
 */
public class HihokenshashoSaikofuKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HihokenshashoSaikofuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HihokenshashoSaikofuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_ありを返す() {
        assertThat(HihokenshashoSaikofuKubun.toValue(new RString("1")), is(HihokenshashoSaikofuKubun.あり));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_なしを返す() {
        assertThat(HihokenshashoSaikofuKubun.toValue(new RString("2")), is(HihokenshashoSaikofuKubun.なし));
    }

    @Test
    public void ありを指定した場合_getコードは_1を返す() {
        assertThat(HihokenshashoSaikofuKubun.あり.getコード(), is(new RString("1")));
    }

    @Test
    public void なしを指定した場合_getコードは_2を返す() {
        assertThat(HihokenshashoSaikofuKubun.なし.getコード(), is(new RString("2")));
    }

    @Test
    public void ありを指定した場合_get名称は_ありを返す() {
        assertThat(HihokenshashoSaikofuKubun.あり.get名称(), is(new RString("あり")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(HihokenshashoSaikofuKubun.なし.get名称(), is(new RString("なし")));
    }

}
