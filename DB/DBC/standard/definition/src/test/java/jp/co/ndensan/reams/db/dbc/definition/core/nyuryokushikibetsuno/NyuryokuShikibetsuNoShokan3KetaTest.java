package jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 入力識別番号償還上３桁のテストクラスです。
 * 
 * @author LDNS 
 */
public class NyuryokuShikibetsuNoShokan3KetaTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NyuryokuShikibetsuNoShokan3Keta.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("99999"));
    }

    @Test
    public void 引数に213を指定した場合_toValueは_居宅介護サービスを返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("213")), is(NyuryokuShikibetsuNoShokan3Keta.居宅介護サービス));
    }

    @Test
    public void 引数に214を指定した場合_toValueは_短期入所生活介護を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("214")), is(NyuryokuShikibetsuNoShokan3Keta.短期入所生活介護));
    }

    @Test
    public void 引数に215を指定した場合_toValueは_短期入所老健施設を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("215")), is(NyuryokuShikibetsuNoShokan3Keta.短期入所老健施設));
    }

    @Test
    public void 引数に216を指定した場合_toValueは_短期入所医療施設を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("216")), is(NyuryokuShikibetsuNoShokan3Keta.短期入所医療施設));
    }

    @Test
    public void 引数に217を指定した場合_toValueは_認知症型共同生活を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("217")), is(NyuryokuShikibetsuNoShokan3Keta.認知症型共同生活));
    }

    @Test
    public void 引数に218を指定した場合_toValueは_福祉施設_地域福祉施設を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("218")), is(NyuryokuShikibetsuNoShokan3Keta.福祉施設_地域福祉施設));
    }

    @Test
    public void 引数に219を指定した場合_toValueは_介護老人保健施設を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("219")), is(NyuryokuShikibetsuNoShokan3Keta.介護老人保健施設));
    }

    @Test
    public void 引数に21Aを指定した場合_toValueは_介護療養型医療施設を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("21A")), is(NyuryokuShikibetsuNoShokan3Keta.介護療養型医療施設));
    }

    @Test
    public void 引数に21Bを指定した場合_toValueは_居宅サービス計画費を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("21B")), is(NyuryokuShikibetsuNoShokan3Keta.居宅サービス計画費));
    }

    @Test
    public void 引数に21Cを指定した場合_toValueは_福祉用具販売費を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("21C")), is(NyuryokuShikibetsuNoShokan3Keta.福祉用具販売費));
    }

    @Test
    public void 引数に21Dを指定した場合_toValueは_住宅改修費を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.toValue(new RString("21D")), is(NyuryokuShikibetsuNoShokan3Keta.住宅改修費));
    }

    @Test
    public void 居宅介護サービスを指定した場合_getコードは_213を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.居宅介護サービス.getコード(), is(new RString("213")));
    }

    @Test
    public void 短期入所生活介護を指定した場合_getコードは_214を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.短期入所生活介護.getコード(), is(new RString("214")));
    }

    @Test
    public void 短期入所老健施設を指定した場合_getコードは_215を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.短期入所老健施設.getコード(), is(new RString("215")));
    }

    @Test
    public void 短期入所医療施設を指定した場合_getコードは_216を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.短期入所医療施設.getコード(), is(new RString("216")));
    }

    @Test
    public void 認知症型共同生活を指定した場合_getコードは_217を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.認知症型共同生活.getコード(), is(new RString("217")));
    }

    @Test
    public void 福祉施設_地域福祉施設を指定した場合_getコードは_218を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.福祉施設_地域福祉施設.getコード(), is(new RString("218")));
    }

    @Test
    public void 介護老人保健施設を指定した場合_getコードは_219を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.介護老人保健施設.getコード(), is(new RString("219")));
    }

    @Test
    public void 介護療養型医療施設を指定した場合_getコードは_21Aを返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.介護療養型医療施設.getコード(), is(new RString("21A")));
    }

    @Test
    public void 居宅サービス計画費を指定した場合_getコードは_21Bを返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.居宅サービス計画費.getコード(), is(new RString("21B")));
    }

    @Test
    public void 福祉用具販売費を指定した場合_getコードは_21Cを返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.福祉用具販売費.getコード(), is(new RString("21C")));
    }

    @Test
    public void 住宅改修費を指定した場合_getコードは_21Dを返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.住宅改修費.getコード(), is(new RString("21D")));
    }

    @Test
    public void 居宅介護サービスを指定した場合_get名称は_居宅介護サービスを返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.居宅介護サービス.get名称(), is(new RString("居宅介護サービス")));
    }

    @Test
    public void 短期入所生活介護を指定した場合_get名称は_短期入所生活介護を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.短期入所生活介護.get名称(), is(new RString("短期入所生活介護")));
    }

    @Test
    public void 短期入所老健施設を指定した場合_get名称は_短期入所老健施設を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.短期入所老健施設.get名称(), is(new RString("短期入所老健施設")));
    }

    @Test
    public void 短期入所医療施設を指定した場合_get名称は_短期入所医療施設を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.短期入所医療施設.get名称(), is(new RString("短期入所医療施設")));
    }

    @Test
    public void 認知症型共同生活を指定した場合_get名称は_認知症型共同生活を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.認知症型共同生活.get名称(), is(new RString("認知症型共同生活")));
    }

    @Test
    public void 福祉施設_地域福祉施設を指定した場合_get名称は_福祉施設_地域福祉施設を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.福祉施設_地域福祉施設.get名称(), is(new RString("福祉施設・地域福祉施設")));
    }

    @Test
    public void 介護老人保健施設を指定した場合_get名称は_介護老人保健施設を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.介護老人保健施設.get名称(), is(new RString("介護老人保健施設")));
    }

    @Test
    public void 介護療養型医療施設を指定した場合_get名称は_介護療養型医療施設を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.介護療養型医療施設.get名称(), is(new RString("介護療養型医療施設")));
    }

    @Test
    public void 居宅サービス計画費を指定した場合_get名称は_居宅サービス計画費を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.居宅サービス計画費.get名称(), is(new RString("居宅サービス計画費")));
    }

    @Test
    public void 福祉用具販売費を指定した場合_get名称は_福祉用具販売費を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.福祉用具販売費.get名称(), is(new RString("福祉用具販売費")));
    }

    @Test
    public void 住宅改修費を指定した場合_get名称は_住宅改修費を返す() {
        assertThat(NyuryokuShikibetsuNoShokan3Keta.住宅改修費.get名称(), is(new RString("住宅改修費")));
    }

}
