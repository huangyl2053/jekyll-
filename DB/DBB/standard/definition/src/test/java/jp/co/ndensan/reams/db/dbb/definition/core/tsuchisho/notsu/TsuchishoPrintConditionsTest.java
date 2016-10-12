package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 通知書プリント条件のテストクラスです。
 *
 * @author LDNS
 */
public class TsuchishoPrintConditionsTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TsuchishoPrintConditions.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TsuchishoPrintConditions.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_なしを返す() {
        assertThat(TsuchishoPrintConditions.toValue(new RString("0")), is(TsuchishoPrintConditions.なし));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_全被保険者_異動時は異動分全件を返す() {
        assertThat(TsuchishoPrintConditions.toValue(new RString("1")), is(TsuchishoPrintConditions.全被保険者));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_差引き保険料１円以上の被保険者を返す() {
        assertThat(TsuchishoPrintConditions.toValue(new RString("2")), is(TsuchishoPrintConditions.差引き保険料1円以上の被保険者));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_保険料変更有りで差引き保険料１円以上の被保険者_異動分のみを返す() {
        assertThat(TsuchishoPrintConditions.toValue(new RString("3")), is(TsuchishoPrintConditions.保険料変更有りで差引き保険料１円以上の被保険者));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_差引き保険料０円以外で確定保険料がある被保険者_当初のみを返す() {
        assertThat(TsuchishoPrintConditions.toValue(new RString("4")), is(TsuchishoPrintConditions.差引き保険料0円以外で確定保険料がある被保険者));
    }

    @Test
    public void なしを指定した場合_getコードは_0を返す() {
        assertThat(TsuchishoPrintConditions.なし.getコード(), is(new RString("0")));
    }

    @Test
    public void 全被保険者_異動時は異動分全件を指定した場合_getコードは_1を返す() {
        assertThat(TsuchishoPrintConditions.全被保険者.getコード(), is(new RString("1")));
    }

    @Test
    public void 差引き保険料１円以上の被保険者を指定した場合_getコードは_2を返す() {
        assertThat(TsuchishoPrintConditions.差引き保険料1円以上の被保険者.getコード(), is(new RString("2")));
    }

    @Test
    public void 保険料変更有りで差引き保険料１円以上の被保険者_異動分のみを指定した場合_getコードは_3を返す() {
        assertThat(TsuchishoPrintConditions.保険料変更有りで差引き保険料１円以上の被保険者.getコード(), is(new RString("3")));
    }

    @Test
    public void 差引き保険料０円以外で確定保険料がある被保険者_当初のみを指定した場合_getコードは_4を返す() {
        assertThat(TsuchishoPrintConditions.差引き保険料0円以外で確定保険料がある被保険者.getコード(), is(new RString("4")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(TsuchishoPrintConditions.なし.get名称(), is(new RString("なし")));
    }

    @Test
    public void 全被保険者_異動時は異動分全件を指定した場合_get名称は_全被保険者を返す() {
        assertThat(TsuchishoPrintConditions.全被保険者.get名称(), is(new RString("全被保険者（異動時は異動分全件）")));
    }

    @Test
    public void 差引き保険料１円以上の被保険者を指定した場合_get名称は_差引き保険料1円以上の被保険者を返す() {
        assertThat(TsuchishoPrintConditions.差引き保険料1円以上の被保険者.get名称(), is(new RString("差引き保険料１円以上の被保険者")));
    }

    @Test
    public void 保険料変更有りで差引き保険料１円以上の被保険者_異動分のみを指定した場合_get名称は_保険料変更有りで差引き保険料１円以上の被保険者を返す() {
        assertThat(TsuchishoPrintConditions.保険料変更有りで差引き保険料１円以上の被保険者.get名称(), is(new RString("保険料変更有りで差引き保険料１円以上の被保険者（異動分のみ）")));
    }

    @Test
    public void 差引き保険料０円以外で確定保険料がある被保険者_当初のみを指定した場合_get名称は_差引き保険料0円以外で確定保険料がある被保険者を返す() {
        assertThat(TsuchishoPrintConditions.差引き保険料0円以外で確定保険料がある被保険者.get名称(), is(new RString("差引き保険料０円以外で確定保険料がある被保険者（当初のみ）")));
    }

}
