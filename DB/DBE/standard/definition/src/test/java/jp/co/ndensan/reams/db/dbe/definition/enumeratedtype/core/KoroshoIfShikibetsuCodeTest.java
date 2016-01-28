package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 厚労省認定ソフトのバージョンのテストクラスです。
 * 
 * @author LDNS 
 */
public class KoroshoIfShikibetsuCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KoroshoIfShikibetsuCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KoroshoIfShikibetsuCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に99Aを指定した場合_toValueは_認定ｿﾌﾄ99を返す() {
        assertThat(KoroshoIfShikibetsuCode.toValue(new RString("99A")), is(KoroshoIfShikibetsuCode.認定ｿﾌﾄ99));
    }

    @Test
    public void 引数に02Aを指定した場合_toValueは_認定ｿﾌﾄ2002を返す() {
        assertThat(KoroshoIfShikibetsuCode.toValue(new RString("02A")), is(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002));
    }

    @Test
    public void 引数に06Aを指定した場合_toValueは_認定ｿﾌﾄ2006_新要介護認定適用区分が未適用を返す() {
        assertThat(KoroshoIfShikibetsuCode.toValue(new RString("06A")), is(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用));
    }

    @Test
    public void 引数に06Bを指定した場合_toValueは_認定ｿﾌﾄ2006_新要介護認定適用区分が適用を返す() {
        assertThat(KoroshoIfShikibetsuCode.toValue(new RString("06B")), is(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が適用));
    }

    @Test
    public void 引数に09Aを指定した場合_toValueは_認定ｿﾌﾄ2009を返す() {
        assertThat(KoroshoIfShikibetsuCode.toValue(new RString("09A")), is(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009));
    }

    @Test
    public void 引数に09Bを指定した場合_toValueは_認定ｿﾌﾄ2009_SP3を返す() {
        assertThat(KoroshoIfShikibetsuCode.toValue(new RString("09B")), is(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3));
    }

    @Test
    public void 認定ｿﾌﾄ99を指定した場合_getコードは_99Aを返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード(), is(new RString("99A")));
    }

    @Test
    public void 認定ｿﾌﾄ2002を指定した場合_getコードは_02Aを返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード(), is(new RString("02A")));
    }

    @Test
    public void 認定ｿﾌﾄ2006_新要介護認定適用区分が未適用を指定した場合_getコードは_06Aを返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード(), is(new RString("06A")));
    }

    @Test
    public void 認定ｿﾌﾄ2006_新要介護認定適用区分が適用を指定した場合_getコードは_06Bを返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が適用.getコード(), is(new RString("06B")));
    }

    @Test
    public void 認定ｿﾌﾄ2009を指定した場合_getコードは_09Aを返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード(), is(new RString("09A")));
    }

    @Test
    public void 認定ｿﾌﾄ2009_SP3を指定した場合_getコードは_09Bを返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード(), is(new RString("09B")));
    }

    @Test
    public void 認定ｿﾌﾄ99を指定した場合_get名称は_認定ｿﾌﾄ99を返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.get名称(), is(new RString("認定ｿﾌﾄ99")));
    }

    @Test
    public void 認定ｿﾌﾄ2002を指定した場合_get名称は_認定ｿﾌﾄ2002を返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.get名称(), is(new RString("認定ｿﾌﾄ2002")));
    }

    @Test
    public void 認定ｿﾌﾄ2006_新要介護認定適用区分が未適用を指定した場合_get名称は_認定ｿﾌﾄ2006_新要介護認定適用区分が未適用を返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.get名称(), is(new RString("認定ｿﾌﾄ2006（新要介護認定適用区分が未適用）")));
    }

    @Test
    public void 認定ｿﾌﾄ2006_新要介護認定適用区分が適用を指定した場合_get名称は_認定ｿﾌﾄ2006_新要介護認定適用区分が適用を返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が適用.get名称(), is(new RString("認定ｿﾌﾄ2006（新要介護認定適用区分が適用）")));
    }

    @Test
    public void 認定ｿﾌﾄ2009を指定した場合_get名称は_認定ｿﾌﾄ2009を返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.get名称(), is(new RString("認定ｿﾌﾄ2009")));
    }

    @Test
    public void 認定ｿﾌﾄ2009_SP3を指定した場合_get名称は_認定ｿﾌﾄ2009_SP3を返す() {
        assertThat(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.get名称(), is(new RString("認定ｿﾌﾄ2009（SP3）")));
    }

}
