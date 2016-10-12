package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 平準化対象外理由のテストクラスです。
 *
 * @author LDNS
 */
public class HeijunkaTaishogaiRiyuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HeijunkaTaishogaiRiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HeijunkaTaishogaiRiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_併徴者を返す() {
        assertThat(HeijunkaTaishogaiRiyu.toValue(new RString("1")), is(HeijunkaTaishogaiRiyu.併徴者));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_仮徴収額修正者を返す() {
        assertThat(HeijunkaTaishogaiRiyu.toValue(new RString("2")), is(HeijunkaTaishogaiRiyu.仮徴収額修正者));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_平準化の結果0円以下を返す() {
        assertThat(HeijunkaTaishogaiRiyu.toValue(new RString("3")), is(HeijunkaTaishogaiRiyu.平準化の結果0円以下));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_対象外_減額を返す() {
        assertThat(HeijunkaTaishogaiRiyu.toValue(new RString("4")), is(HeijunkaTaishogaiRiyu.対象外_減額));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_対象外_増額を返す() {
        assertThat(HeijunkaTaishogaiRiyu.toValue(new RString("5")), is(HeijunkaTaishogaiRiyu.対象外_増額));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_特徴6月開始者を返す() {
        assertThat(HeijunkaTaishogaiRiyu.toValue(new RString("6")), is(HeijunkaTaishogaiRiyu.特徴6月開始者));
    }

    @Test
    public void 併徴者を指定した場合_getコードは_1を返す() {
        assertThat(HeijunkaTaishogaiRiyu.併徴者.getコード(), is(new RString("1")));
    }

    @Test
    public void 仮徴収額修正者を指定した場合_getコードは_2を返す() {
        assertThat(HeijunkaTaishogaiRiyu.仮徴収額修正者.getコード(), is(new RString("2")));
    }

    @Test
    public void 平準化の結果0円以下を指定した場合_getコードは_3を返す() {
        assertThat(HeijunkaTaishogaiRiyu.平準化の結果0円以下.getコード(), is(new RString("3")));
    }

    @Test
    public void 対象外_減額を指定した場合_getコードは_4を返す() {
        assertThat(HeijunkaTaishogaiRiyu.対象外_減額.getコード(), is(new RString("4")));
    }

    @Test
    public void 対象外_増額を指定した場合_getコードは_5を返す() {
        assertThat(HeijunkaTaishogaiRiyu.対象外_増額.getコード(), is(new RString("5")));
    }

    @Test
    public void 特徴6月開始者を指定した場合_getコードは_6を返す() {
        assertThat(HeijunkaTaishogaiRiyu.特徴6月開始者.getコード(), is(new RString("6")));
    }

    @Test
    public void 併徴者を指定した場合_get名称は_併徴者を返す() {
        assertThat(HeijunkaTaishogaiRiyu.併徴者.get名称(), is(new RString("併徴者")));
    }

    @Test
    public void 仮徴収額修正者を指定した場合_get名称は_仮徴収額修正者を返す() {
        assertThat(HeijunkaTaishogaiRiyu.仮徴収額修正者.get名称(), is(new RString("仮徴収額修正者")));
    }

    @Test
    public void 平準化の結果0円以下を指定した場合_get名称は_平準化の結果0円以下を返す() {
        assertThat(HeijunkaTaishogaiRiyu.平準化の結果0円以下.get名称(), is(new RString("平準化の結果0円以下")));
    }

    @Test
    public void 対象外_減額を指定した場合_get名称は_対象外_減額を返す() {
        assertThat(HeijunkaTaishogaiRiyu.対象外_減額.get名称(), is(new RString("対象外・減額")));
    }

    @Test
    public void 対象外_増額を指定した場合_get名称は_対象外_増額を返す() {
        assertThat(HeijunkaTaishogaiRiyu.対象外_増額.get名称(), is(new RString("対象外・増額")));
    }

    @Test
    public void 特徴6月開始者を指定した場合_get名称は_特徴6月開始者を返す() {
        assertThat(HeijunkaTaishogaiRiyu.特徴6月開始者.get名称(), is(new RString("特徴6月開始者")));
    }

}
