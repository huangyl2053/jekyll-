package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 統計対象区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class TokeiTaishoKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokeiTaishoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokeiTaishoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_保険者分を返す() {
        assertThat(TokeiTaishoKubun.toValue(new RString("1")), is(TokeiTaishoKubun.保険者分));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_構成市町村分を返す() {
        assertThat(TokeiTaishoKubun.toValue(new RString("2")), is(TokeiTaishoKubun.構成市町村分));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_旧市町村分を返す() {
        assertThat(TokeiTaishoKubun.toValue(new RString("3")), is(TokeiTaishoKubun.旧市町村分));
    }

    @Test
    public void 保険者分を指定した場合_getコードは_1を返す() {
        assertThat(TokeiTaishoKubun.保険者分.getコード(), is(new RString("1")));
    }

    @Test
    public void 構成市町村分を指定した場合_getコードは_2を返す() {
        assertThat(TokeiTaishoKubun.構成市町村分.getコード(), is(new RString("2")));
    }

    @Test
    public void 旧市町村分を指定した場合_getコードは_3を返す() {
        assertThat(TokeiTaishoKubun.旧市町村分.getコード(), is(new RString("3")));
    }

    @Test
    public void 保険者分を指定した場合_get名称は_保険者分を返す() {
        assertThat(TokeiTaishoKubun.保険者分.get名称(), is(new RString("保険者分")));
    }

    @Test
    public void 構成市町村分を指定した場合_get名称は_構成市町村分を返す() {
        assertThat(TokeiTaishoKubun.構成市町村分.get名称(), is(new RString("構成市町村分")));
    }

    @Test
    public void 旧市町村分を指定した場合_get名称は_旧市町村分を返す() {
        assertThat(TokeiTaishoKubun.旧市町村分.get名称(), is(new RString("旧市町村分")));
    }

}
