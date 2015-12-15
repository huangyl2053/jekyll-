package jp.co.ndensan.reams.db.dbz.definition.core.shokofukubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 被保険者証を再交付した事由のテストクラスです。
 * 
 * @author LDNS 
 */
public class HihokenshashoSaikofuJiyuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HihokenshashoSaikofuJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HihokenshashoSaikofuJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に00を指定した場合_toValueは_なしを返す() {
        assertThat(HihokenshashoSaikofuJiyu.toValue(new RString("00")), is(HihokenshashoSaikofuJiyu.なし));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他を返す() {
        assertThat(HihokenshashoSaikofuJiyu.toValue(new RString("99")), is(HihokenshashoSaikofuJiyu.その他));
    }

    @Test
    public void なしを指定した場合_getコードは_00を返す() {
        assertThat(HihokenshashoSaikofuJiyu.なし.getコード(), is(new RString("00")));
    }

    @Test
    public void その他を指定した場合_getコードは_99を返す() {
        assertThat(HihokenshashoSaikofuJiyu.その他.getコード(), is(new RString("99")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(HihokenshashoSaikofuJiyu.なし.get名称(), is(new RString("なし")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(HihokenshashoSaikofuJiyu.その他.get名称(), is(new RString("その他")));
    }

}
