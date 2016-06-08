package jp.co.ndensan.reams.db.dbz.definition.core.shotoku;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 登録業務のテストクラスです。
 * 
 * @author LDNS 
 */
public class TorokuGyomuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TorokuGyomu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TorokuGyomu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_住民税を返す() {
        assertThat(TorokuGyomu.toValue(new RString("1")), is(TorokuGyomu.住民税));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_介護保険を返す() {
        assertThat(TorokuGyomu.toValue(new RString("2")), is(TorokuGyomu.介護保険));
    }

    @Test
    public void 住民税を指定した場合_getコードは_1を返す() {
        assertThat(TorokuGyomu.住民税.getコード(), is(new RString("1")));
    }

    @Test
    public void 介護保険を指定した場合_getコードは_2を返す() {
        assertThat(TorokuGyomu.介護保険.getコード(), is(new RString("2")));
    }

    @Test
    public void 住民税を指定した場合_get名称は_住民税を返す() {
        assertThat(TorokuGyomu.住民税.get名称(), is(new RString("住民税")));
    }

    @Test
    public void 介護保険を指定した場合_get名称は_介護保険を返す() {
        assertThat(TorokuGyomu.介護保険.get名称(), is(new RString("介護保険")));
    }

}
