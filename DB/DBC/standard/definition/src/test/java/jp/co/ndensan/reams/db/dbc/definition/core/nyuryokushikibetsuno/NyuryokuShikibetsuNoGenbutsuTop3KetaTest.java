package jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 入力識別番号現物上３桁のテストクラスです。
 * 
 * @author LDNS 
 */
public class NyuryokuShikibetsuNoGenbutsuTop3KetaTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("99999"));
    }

    @Test
    public void 引数に713を指定した場合_toValueは_居宅介護サービスを返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("713")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.居宅介護サービス));
    }

    @Test
    public void 引数に714を指定した場合_toValueは_短期入所生活介護を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("714")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.短期入所生活介護));
    }

    @Test
    public void 引数に715を指定した場合_toValueは_短期入所老健施設を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("715")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.短期入所老健施設));
    }

    @Test
    public void 引数に716を指定した場合_toValueは_短期入所医療施設を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("716")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.短期入所医療施設));
    }

    @Test
    public void 引数に717を指定した場合_toValueは_認知症型共同生活を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("717")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.認知症型共同生活));
    }

    @Test
    public void 引数に718を指定した場合_toValueは_福祉施設_地域福祉施設を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("718")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.福祉施設_地域福祉施設));
    }

    @Test
    public void 引数に719を指定した場合_toValueは_介護老人保健施設を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("719")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護老人保健施設));
    }

    @Test
    public void 引数に71Aを指定した場合_toValueは_介護療養型医療施設を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("71A")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護療養型医療施設));
    }

    @Test
    public void 引数に812を指定した場合_toValueは_居宅サービス計画費を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("812")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.居宅サービス計画費));
    }

    @Test
    public void 引数に71Pを指定した場合_toValueは_介護予防_日常生活支援総合事業_予防サービス_生活支援サービスを返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("71P")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護予防_日常生活支援総合事業_予防サービス_生活支援サービス));
    }

    @Test
    public void 引数に816を指定した場合_toValueは_介護予防_日常生活支援総合事業_ケアマネジメントを返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.toValue(new RString("816")), is(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護予防_日常生活支援総合事業_ケアマネジメント));
    }

    @Test
    public void 居宅介護サービスを指定した場合_getコードは_713を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.居宅介護サービス.getコード(), is(new RString("713")));
    }

    @Test
    public void 短期入所生活介護を指定した場合_getコードは_714を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.短期入所生活介護.getコード(), is(new RString("714")));
    }

    @Test
    public void 短期入所老健施設を指定した場合_getコードは_715を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.短期入所老健施設.getコード(), is(new RString("715")));
    }

    @Test
    public void 短期入所医療施設を指定した場合_getコードは_716を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.短期入所医療施設.getコード(), is(new RString("716")));
    }

    @Test
    public void 認知症型共同生活を指定した場合_getコードは_717を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.認知症型共同生活.getコード(), is(new RString("717")));
    }

    @Test
    public void 福祉施設_地域福祉施設を指定した場合_getコードは_718を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.福祉施設_地域福祉施設.getコード(), is(new RString("718")));
    }

    @Test
    public void 介護老人保健施設を指定した場合_getコードは_719を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護老人保健施設.getコード(), is(new RString("719")));
    }

    @Test
    public void 介護療養型医療施設を指定した場合_getコードは_71Aを返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護療養型医療施設.getコード(), is(new RString("71A")));
    }

    @Test
    public void 居宅サービス計画費を指定した場合_getコードは_812を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.居宅サービス計画費.getコード(), is(new RString("812")));
    }

    @Test
    public void 介護予防_日常生活支援総合事業_予防サービス_生活支援サービスを指定した場合_getコードは_71Pを返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護予防_日常生活支援総合事業_予防サービス_生活支援サービス.getコード(), is(new RString("71P")));
    }

    @Test
    public void 介護予防_日常生活支援総合事業_ケアマネジメントを指定した場合_getコードは_816を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護予防_日常生活支援総合事業_ケアマネジメント.getコード(), is(new RString("816")));
    }

    @Test
    public void 居宅介護サービスを指定した場合_get名称は_居宅介護サービスを返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.居宅介護サービス.get名称(), is(new RString("居宅介護サービス")));
    }

    @Test
    public void 短期入所生活介護を指定した場合_get名称は_短期入所生活介護を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.短期入所生活介護.get名称(), is(new RString("短期入所生活介護")));
    }

    @Test
    public void 短期入所老健施設を指定した場合_get名称は_短期入所老健施設を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.短期入所老健施設.get名称(), is(new RString("短期入所老健施設")));
    }

    @Test
    public void 短期入所医療施設を指定した場合_get名称は_短期入所医療施設を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.短期入所医療施設.get名称(), is(new RString("短期入所医療施設")));
    }

    @Test
    public void 認知症型共同生活を指定した場合_get名称は_認知症型共同生活を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.認知症型共同生活.get名称(), is(new RString("認知症型共同生活")));
    }

    @Test
    public void 福祉施設_地域福祉施設を指定した場合_get名称は_福祉施設_地域福祉施設を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.福祉施設_地域福祉施設.get名称(), is(new RString("福祉施設・地域福祉施設")));
    }

    @Test
    public void 介護老人保健施設を指定した場合_get名称は_介護老人保健施設を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護老人保健施設.get名称(), is(new RString("介護老人保健施設")));
    }

    @Test
    public void 介護療養型医療施設を指定した場合_get名称は_介護療養型医療施設を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護療養型医療施設.get名称(), is(new RString("介護療養型医療施設")));
    }

    @Test
    public void 居宅サービス計画費を指定した場合_get名称は_居宅サービス計画費を返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.居宅サービス計画費.get名称(), is(new RString("居宅サービス計画費")));
    }

    @Test
    public void 介護予防_日常生活支援総合事業_予防サービス_生活支援サービスを指定した場合_get名称は_介護予防_日常生活支援総合事業_予防サービス_生活支援サービスを返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護予防_日常生活支援総合事業_予防サービス_生活支援サービス.get名称(), is(new RString("介護予防・日常生活支援総合事業（予防サービス・生活支援サービス）")));
    }

    @Test
    public void 介護予防_日常生活支援総合事業_ケアマネジメントを指定した場合_get名称は_介護予防_日常生活支援総合事業_ケアマネジメントを返す() {
        assertThat(NyuryokuShikibetsuNoGenbutsuTop3Keta.介護予防_日常生活支援総合事業_ケアマネジメント.get名称(), is(new RString("介護予防・日常生活支援総合事業（ケアマネジメント）")));
    }

}
