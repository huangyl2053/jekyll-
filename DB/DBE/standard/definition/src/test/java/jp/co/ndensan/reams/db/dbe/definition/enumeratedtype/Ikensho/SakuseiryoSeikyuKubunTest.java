package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 作成料請求区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class SakuseiryoSeikyuKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SakuseiryoSeikyuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SakuseiryoSeikyuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_在宅新規を返す() {
        assertThat(SakuseiryoSeikyuKubun.toValue(new RString("11")), is(SakuseiryoSeikyuKubun.在宅新規));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_在宅継続を返す() {
        assertThat(SakuseiryoSeikyuKubun.toValue(new RString("12")), is(SakuseiryoSeikyuKubun.在宅継続));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_施設新規を返す() {
        assertThat(SakuseiryoSeikyuKubun.toValue(new RString("21")), is(SakuseiryoSeikyuKubun.施設新規));
    }

    @Test
    public void 引数に22を指定した場合_toValueは_施設継続を返す() {
        assertThat(SakuseiryoSeikyuKubun.toValue(new RString("22")), is(SakuseiryoSeikyuKubun.施設継続));
    }

    @Test
    public void 在宅新規を指定した場合_getコードは_11を返す() {
        assertThat(SakuseiryoSeikyuKubun.在宅新規.getコード(), is(new RString("11")));
    }

    @Test
    public void 在宅継続を指定した場合_getコードは_12を返す() {
        assertThat(SakuseiryoSeikyuKubun.在宅継続.getコード(), is(new RString("12")));
    }

    @Test
    public void 施設新規を指定した場合_getコードは_21を返す() {
        assertThat(SakuseiryoSeikyuKubun.施設新規.getコード(), is(new RString("21")));
    }

    @Test
    public void 施設継続を指定した場合_getコードは_22を返す() {
        assertThat(SakuseiryoSeikyuKubun.施設継続.getコード(), is(new RString("22")));
    }

    @Test
    public void 在宅新規を指定した場合_get名称は_在宅新規を返す() {
        assertThat(SakuseiryoSeikyuKubun.在宅新規.get名称(), is(new RString("在宅新規")));
    }

    @Test
    public void 在宅継続を指定した場合_get名称は_在宅継続を返す() {
        assertThat(SakuseiryoSeikyuKubun.在宅継続.get名称(), is(new RString("在宅継続")));
    }

    @Test
    public void 施設新規を指定した場合_get名称は_施設新規を返す() {
        assertThat(SakuseiryoSeikyuKubun.施設新規.get名称(), is(new RString("施設新規")));
    }

    @Test
    public void 施設継続を指定した場合_get名称は_施設継続を返す() {
        assertThat(SakuseiryoSeikyuKubun.施設継続.get名称(), is(new RString("施設継続")));
    }

}
