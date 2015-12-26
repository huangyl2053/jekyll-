package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 申請者関係コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class ShinseishaKankeiCodeTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinseishaKankeiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinseishaKankeiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_居宅介護支援事業者を返す() {
        assertThat(ShinseishaKankeiCode.toValue(new RString("01")), is(ShinseishaKankeiCode.居宅介護支援事業者));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_指定介護老人福祉施設を返す() {
        assertThat(ShinseishaKankeiCode.toValue(new RString("02")), is(ShinseishaKankeiCode.指定介護老人福祉施設));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_指定介護老人保健施設を返す() {
        assertThat(ShinseishaKankeiCode.toValue(new RString("03")), is(ShinseishaKankeiCode.指定介護老人保健施設));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_指定介護療養型医療施設を返す() {
        assertThat(ShinseishaKankeiCode.toValue(new RString("04")), is(ShinseishaKankeiCode.指定介護療養型医療施設));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_地域包括支援センターを返す() {
        assertThat(ShinseishaKankeiCode.toValue(new RString("05")), is(ShinseishaKankeiCode.地域包括支援センター));
    }

    @Test
    public void 居宅介護支援事業者を指定した場合_getコードは_01を返す() {
        assertThat(ShinseishaKankeiCode.居宅介護支援事業者.getコード(), is(new RString("01")));
    }

    @Test
    public void 指定介護老人福祉施設を指定した場合_getコードは_02を返す() {
        assertThat(ShinseishaKankeiCode.指定介護老人福祉施設.getコード(), is(new RString("02")));
    }

    @Test
    public void 指定介護老人保健施設を指定した場合_getコードは_03を返す() {
        assertThat(ShinseishaKankeiCode.指定介護老人保健施設.getコード(), is(new RString("03")));
    }

    @Test
    public void 指定介護療養型医療施設を指定した場合_getコードは_04を返す() {
        assertThat(ShinseishaKankeiCode.指定介護療養型医療施設.getコード(), is(new RString("04")));
    }

    @Test
    public void 地域包括支援センターを指定した場合_getコードは_05を返す() {
        assertThat(ShinseishaKankeiCode.地域包括支援センター.getコード(), is(new RString("05")));
    }

    @Test
    public void 居宅介護支援事業者を指定した場合_get名称は_居宅介護支援事業者を返す() {
        assertThat(ShinseishaKankeiCode.居宅介護支援事業者.get名称(), is(new RString("居宅介護支援事業者")));
    }

    @Test
    public void 指定介護老人福祉施設を指定した場合_get名称は_指定介護老人福祉施設を返す() {
        assertThat(ShinseishaKankeiCode.指定介護老人福祉施設.get名称(), is(new RString("指定介護老人福祉施設")));
    }

    @Test
    public void 指定介護老人保健施設を指定した場合_get名称は_指定介護老人保健施設を返す() {
        assertThat(ShinseishaKankeiCode.指定介護老人保健施設.get名称(), is(new RString("指定介護老人保健施設")));
    }

    @Test
    public void 指定介護療養型医療施設を指定した場合_get名称は_指定介護療養型医療施設を返す() {
        assertThat(ShinseishaKankeiCode.指定介護療養型医療施設.get名称(), is(new RString("指定介護療養型医療施設")));
    }

    @Test
    public void 地域包括支援センターを指定した場合_get名称は_地域包括支援センターを返す() {
        assertThat(ShinseishaKankeiCode.地域包括支援センター.get名称(), is(new RString("地域包括支援センター")));
    }

}
