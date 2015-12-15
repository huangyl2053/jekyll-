package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 意見書・症状としての安定性のテストクラスです。
 * 
 * @author LDNS 
 */
public class AnteiseiTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        Anteisei.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        Anteisei.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_安定を返す() {
        assertThat(Anteisei.toValue(new RString("1")), is(Anteisei.安定));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_不安定を返す() {
        assertThat(Anteisei.toValue(new RString("2")), is(Anteisei.不安定));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_不明を返す() {
        assertThat(Anteisei.toValue(new RString("3")), is(Anteisei.不明));
    }

    @Test
    public void 安定を指定した場合_getコードは_1を返す() {
        assertThat(Anteisei.安定.getコード(), is(new RString("1")));
    }

    @Test
    public void 不安定を指定した場合_getコードは_2を返す() {
        assertThat(Anteisei.不安定.getコード(), is(new RString("2")));
    }

    @Test
    public void 不明を指定した場合_getコードは_3を返す() {
        assertThat(Anteisei.不明.getコード(), is(new RString("3")));
    }

    @Test
    public void 安定を指定した場合_get名称は_安定を返す() {
        assertThat(Anteisei.安定.get名称(), is(new RString("安定")));
    }

    @Test
    public void 不安定を指定した場合_get名称は_不安定を返す() {
        assertThat(Anteisei.不安定.get名称(), is(new RString("不安定")));
    }

    @Test
    public void 不明を指定した場合_get名称は_不明を返す() {
        assertThat(Anteisei.不明.get名称(), is(new RString("不明")));
    }

}
