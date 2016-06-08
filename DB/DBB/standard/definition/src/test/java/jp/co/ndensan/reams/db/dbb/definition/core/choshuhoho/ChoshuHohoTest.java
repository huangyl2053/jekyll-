package jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 徴収方法のテストクラスです。
 *
 * @author LDNS
 */
public class ChoshuHohoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChoshuHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChoshuHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_資格なしを返す() {
        assertThat(ChoshuHoho.toValue(new RString("0")), is(ChoshuHoho.資格なし));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_特別徴収_厚生労働省を返す() {
        assertThat(ChoshuHoho.toValue(new RString("1")), is(ChoshuHoho.特別徴収_厚生労働省));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_特別徴収_地共済を返す() {
        assertThat(ChoshuHoho.toValue(new RString("2")), is(ChoshuHoho.特別徴収_地共済));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_普通徴収を返す() {
        assertThat(ChoshuHoho.toValue(new RString("3")), is(ChoshuHoho.普通徴収));
    }

    @Test
    public void 資格なしを指定した場合_getコードは_0を返す() {
        assertThat(ChoshuHoho.資格なし.getコード(), is(new RString("0")));
    }

    @Test
    public void 特別徴収_厚生労働省を指定した場合_getコードは_1を返す() {
        assertThat(ChoshuHoho.特別徴収_厚生労働省.getコード(), is(new RString("1")));
    }

    @Test
    public void 特別徴収_地共済を指定した場合_getコードは_2を返す() {
        assertThat(ChoshuHoho.特別徴収_地共済.getコード(), is(new RString("2")));
    }

    @Test
    public void 普通徴収を指定した場合_getコードは_3を返す() {
        assertThat(ChoshuHoho.普通徴収.getコード(), is(new RString("3")));
    }

    @Test
    public void 資格なしを指定した場合_get名称は_資格なしを返す() {
        assertThat(ChoshuHoho.資格なし.get名称(), is(new RString("資格なし")));
    }

    @Test
    public void 特別徴収_厚生労働省を指定した場合_get名称は_特別徴収_厚生労働省を返す() {
        assertThat(ChoshuHoho.特別徴収_厚生労働省.get名称(), is(new RString("特別徴収_厚生労働省")));
    }

    @Test
    public void 特別徴収_地共済を指定した場合_get名称は_特別徴収_地共済を返す() {
        assertThat(ChoshuHoho.特別徴収_地共済.get名称(), is(new RString("特別徴収_地共済")));
    }

    @Test
    public void 普通徴収を指定した場合_get名称は_普通徴収を返す() {
        assertThat(ChoshuHoho.普通徴収.get名称(), is(new RString("普通徴収")));
    }

}
