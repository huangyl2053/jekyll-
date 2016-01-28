package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 外部出力データ区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class DatakubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        Datakubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        Datakubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_申請情報を返す() {
        assertThat(Datakubun.toValue(new RString("1")), is(Datakubun.申請情報));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_4マスタを返す() {
        assertThat(Datakubun.toValue(new RString("2")), is(Datakubun._4マスタ));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_資格喪失_死亡_情報を返す() {
        assertThat(Datakubun.toValue(new RString("3")), is(Datakubun.資格喪失_死亡_情報));
    }

    @Test
    public void 申請情報を指定した場合_getコードは_1を返す() {
        assertThat(Datakubun.申請情報.getコード(), is(new RString("1")));
    }

    @Test
    public void _4マスタを指定した場合_getコードは_2を返す() {
        assertThat(Datakubun._4マスタ.getコード(), is(new RString("2")));
    }

    @Test
    public void 資格喪失_死亡_情報を指定した場合_getコードは_3を返す() {
        assertThat(Datakubun.資格喪失_死亡_情報.getコード(), is(new RString("3")));
    }

    @Test
    public void 申請情報を指定した場合_get名称は_申請情報を返す() {
        assertThat(Datakubun.申請情報.get名称(), is(new RString("申請情報")));
    }

    @Test
    public void _4マスタを指定した場合_get名称は_4マスタを返す() {
        assertThat(Datakubun._4マスタ.get名称(), is(new RString("4マスタ")));
    }

    @Test
    public void 資格喪失_死亡_情報を指定した場合_get名称は_資格喪失_死亡_情報を返す() {
        assertThat(Datakubun.資格喪失_死亡_情報.get名称(), is(new RString("資格喪失（死亡）情報")));
    }

}
