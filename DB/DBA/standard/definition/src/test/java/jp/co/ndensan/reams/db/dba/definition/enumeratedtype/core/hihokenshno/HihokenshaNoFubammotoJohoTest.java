package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.core.hihokenshno;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 被保険者番号付番元情報のテストクラスです。
 *
 */
public class HihokenshaNoFubammotoJohoTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HihokenshaNoFubammotoJoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HihokenshaNoFubammotoJoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_未設定を返す() {
        assertThat(HihokenshaNoFubammotoJoho.toValue(new RString("0")), is(HihokenshaNoFubammotoJoho.未設定));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_住民コードを返す() {
        assertThat(HihokenshaNoFubammotoJoho.toValue(new RString("1")), is(HihokenshaNoFubammotoJoho.住民コード));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_自動連番を返す() {
        assertThat(HihokenshaNoFubammotoJoho.toValue(new RString("2")), is(HihokenshaNoFubammotoJoho.自動連番));
    }

    @Test
    public void 未設定を指定した場合_getコードは_0を返す() {
        assertThat(HihokenshaNoFubammotoJoho.未設定.getコード(), is(new RString("0")));
    }

    @Test
    public void 住民コードを指定した場合_getコードは_1を返す() {
        assertThat(HihokenshaNoFubammotoJoho.住民コード.getコード(), is(new RString("1")));
    }

    @Test
    public void 自動連番を指定した場合_getコードは_2を返す() {
        assertThat(HihokenshaNoFubammotoJoho.自動連番.getコード(), is(new RString("2")));
    }

    @Test
    public void 未設定を指定した場合_get名称は_未設定を返す() {
        assertThat(HihokenshaNoFubammotoJoho.未設定.get名称(), is(new RString("未設定")));
    }

    @Test
    public void 住民コードを指定した場合_get名称は_住民コードを返す() {
        assertThat(HihokenshaNoFubammotoJoho.住民コード.get名称(), is(new RString("住民コード")));
    }

    @Test
    public void 自動連番を指定した場合_get名称は_自動連番を返す() {
        assertThat(HihokenshaNoFubammotoJoho.自動連番.get名称(), is(new RString("自動連番")));
    }

}
