package jp.co.ndensan.reams.db.dbc.definition.core.keikoku;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 警告区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class KeikokuKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KeikokuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KeikokuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_警告なしを返す() {
        assertThat(KeikokuKubun.toValue(new RString("1")), is(KeikokuKubun.警告なし));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_警告ありを返す() {
        assertThat(KeikokuKubun.toValue(new RString("2")), is(KeikokuKubun.警告あり));
    }

    @Test
    public void 警告なしを指定した場合_getコードは_1を返す() {
        assertThat(KeikokuKubun.警告なし.getコード(), is(new RString("1")));
    }

    @Test
    public void 警告ありを指定した場合_getコードは_2を返す() {
        assertThat(KeikokuKubun.警告あり.getコード(), is(new RString("2")));
    }

    @Test
    public void 警告なしを指定した場合_get名称は_警告なしを返す() {
        assertThat(KeikokuKubun.警告なし.get名称(), is(new RString("警告なし")));
    }

    @Test
    public void 警告ありを指定した場合_get名称は_警告ありを返す() {
        assertThat(KeikokuKubun.警告あり.get名称(), is(new RString("警告あり")));
    }

}
