package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 現在の状況コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class GenzainoJokyoCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GenzainoJokyoCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GenzainoJokyoCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_居宅_施設利用なしを返す() {
        assertThat(GenzainoJokyoCode.toValue(new RString("1")), is(GenzainoJokyoCode.居宅_施設利用なし));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_指定介護老人福祉施設を返す() {
        assertThat(GenzainoJokyoCode.toValue(new RString("2")), is(GenzainoJokyoCode.指定介護老人福祉施設));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_介護老人保健施設を返す() {
        assertThat(GenzainoJokyoCode.toValue(new RString("3")), is(GenzainoJokyoCode.介護老人保健施設));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_指定介護療養型医療施設を返す() {
        assertThat(GenzainoJokyoCode.toValue(new RString("4")), is(GenzainoJokyoCode.指定介護療養型医療施設));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_認知症対応型共同生活介護適用施設_グループホームを返す() {
        assertThat(GenzainoJokyoCode.toValue(new RString("5")), is(GenzainoJokyoCode.認知症対応型共同生活介護適用施設_グループホーム));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_特定施設入居者生活介護適用施設_ケアハウス等を返す() {
        assertThat(GenzainoJokyoCode.toValue(new RString("6")), is(GenzainoJokyoCode.特定施設入居者生活介護適用施設_ケアハウス等));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_医療機関_医療保険適用療養病床を返す() {
        assertThat(GenzainoJokyoCode.toValue(new RString("7")), is(GenzainoJokyoCode.医療機関_医療保険適用療養病床));
    }

    @Test
    public void 引数に8を指定した場合_toValueは_医療機関_療養病棟以外を返す() {
        assertThat(GenzainoJokyoCode.toValue(new RString("8")), is(GenzainoJokyoCode.医療機関_療養病棟以外));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_その他の施設を返す() {
        assertThat(GenzainoJokyoCode.toValue(new RString("9")), is(GenzainoJokyoCode.その他の施設));
    }

    @Test
    public void 居宅_施設利用なしを指定した場合_getコードは_1を返す() {
        assertThat(GenzainoJokyoCode.居宅_施設利用なし.getコード(), is(new RString("1")));
    }

    @Test
    public void 指定介護老人福祉施設を指定した場合_getコードは_2を返す() {
        assertThat(GenzainoJokyoCode.指定介護老人福祉施設.getコード(), is(new RString("2")));
    }

    @Test
    public void 介護老人保健施設を指定した場合_getコードは_3を返す() {
        assertThat(GenzainoJokyoCode.介護老人保健施設.getコード(), is(new RString("3")));
    }

    @Test
    public void 指定介護療養型医療施設を指定した場合_getコードは_4を返す() {
        assertThat(GenzainoJokyoCode.指定介護療養型医療施設.getコード(), is(new RString("4")));
    }

    @Test
    public void 認知症対応型共同生活介護適用施設_グループホームを指定した場合_getコードは_5を返す() {
        assertThat(GenzainoJokyoCode.認知症対応型共同生活介護適用施設_グループホーム.getコード(), is(new RString("5")));
    }

    @Test
    public void 特定施設入居者生活介護適用施設_ケアハウス等を指定した場合_getコードは_6を返す() {
        assertThat(GenzainoJokyoCode.特定施設入居者生活介護適用施設_ケアハウス等.getコード(), is(new RString("6")));
    }

    @Test
    public void 医療機関_医療保険適用療養病床を指定した場合_getコードは_7を返す() {
        assertThat(GenzainoJokyoCode.医療機関_医療保険適用療養病床.getコード(), is(new RString("7")));
    }

    @Test
    public void 医療機関_療養病棟以外を指定した場合_getコードは_8を返す() {
        assertThat(GenzainoJokyoCode.医療機関_療養病棟以外.getコード(), is(new RString("8")));
    }

    @Test
    public void その他の施設を指定した場合_getコードは_9を返す() {
        assertThat(GenzainoJokyoCode.その他の施設.getコード(), is(new RString("9")));
    }

    @Test
    public void 居宅_施設利用なしを指定した場合_get名称は_居宅_施設利用なしを返す() {
        assertThat(GenzainoJokyoCode.居宅_施設利用なし.get名称(), is(new RString("居宅（施設利用なし）")));
    }

    @Test
    public void 指定介護老人福祉施設を指定した場合_get名称は_指定介護老人福祉施設を返す() {
        assertThat(GenzainoJokyoCode.指定介護老人福祉施設.get名称(), is(new RString("指定介護老人福祉施設")));
    }

    @Test
    public void 介護老人保健施設を指定した場合_get名称は_介護老人保健施設を返す() {
        assertThat(GenzainoJokyoCode.介護老人保健施設.get名称(), is(new RString("介護老人保健施設")));
    }

    @Test
    public void 指定介護療養型医療施設を指定した場合_get名称は_指定介護療養型医療施設を返す() {
        assertThat(GenzainoJokyoCode.指定介護療養型医療施設.get名称(), is(new RString("指定介護療養型医療施設")));
    }

    @Test
    public void 認知症対応型共同生活介護適用施設_グループホームを指定した場合_get名称は_認知症対応型共同生活介護適用施設_グループホームを返す() {
        assertThat(GenzainoJokyoCode.認知症対応型共同生活介護適用施設_グループホーム.get名称(), is(new RString("認知症対応型共同生活介護適用施設（グループホーム）")));
    }

    @Test
    public void 特定施設入居者生活介護適用施設_ケアハウス等を指定した場合_get名称は_特定施設入居者生活介護適用施設_ケアハウス等を返す() {
        assertThat(GenzainoJokyoCode.特定施設入居者生活介護適用施設_ケアハウス等.get名称(), is(new RString("特定施設入居者生活介護適用施設（ケアハウス等）")));
    }

    @Test
    public void 医療機関_医療保険適用療養病床を指定した場合_get名称は_医療機関_医療保険適用療養病床を返す() {
        assertThat(GenzainoJokyoCode.医療機関_医療保険適用療養病床.get名称(), is(new RString("医療機関（医療保険適用療養病床）")));
    }

    @Test
    public void 医療機関_療養病棟以外を指定した場合_get名称は_医療機関_療養病棟以外を返す() {
        assertThat(GenzainoJokyoCode.医療機関_療養病棟以外.get名称(), is(new RString("医療機関（療養病棟以外）")));
    }

    @Test
    public void その他の施設を指定した場合_get名称は_その他の施設を返す() {
        assertThat(GenzainoJokyoCode.その他の施設.get名称(), is(new RString("その他の施設")));
    }

}
