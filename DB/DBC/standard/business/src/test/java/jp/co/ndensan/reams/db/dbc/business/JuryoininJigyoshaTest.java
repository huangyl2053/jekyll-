/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 受領委任者のテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JuryoininJigyoshaTest extends TestBase {

    private static JuryoininJigyosha sut;
    private static KeiyakuNo 契約番号;
    private static Range<FlexibleDate> 契約期間;
    private static RDateTime 処理日時;
    private static FlexibleDate 届出年月日;
    private static Todokedesha 届出者;
    private static FlexibleDate 契約登録年月日;
    private static KeiyakuJigyosha 契約事業者;
    private static boolean is住宅改修契約;
    private static boolean is特定福祉用具販売契約;
    private static boolean is償還払給付契約;
    private static boolean is高額給付契約;
    private static boolean has取扱確約書;

    public static class ConstructorTest extends TestBase {

        @Override
        protected void setUp() {
            契約番号 = create契約番号();
            契約期間 = create契約期間();
            処理日時 = RDateTime.of(2014, 1, 10, 11, 12);
            届出年月日 = mock(FlexibleDate.class);
            届出者 = mock(Todokedesha.class);
            契約登録年月日 = mock(FlexibleDate.class);
            契約事業者 = mock(KeiyakuJigyosha.class);
            is住宅改修契約 = true;
            is特定福祉用具販売契約 = true;
            is償還払給付契約 = true;
            is高額給付契約 = true;
            has取扱確約書 = true;
        }

        @Test
        public void 引数に必要な値が渡されたとき_インスタンスが生成される() {
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, is住宅改修契約, is特定福祉用具販売契約,
                    is償還払給付契約, is高額給付契約, has取扱確約書);
            assertThat(sut, is(instanceOf(JuryoininJigyosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 契約番号がnullの時_NullPointerExceptionが発生する() {
            sut = new JuryoininJigyosha(null, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, is住宅改修契約, is特定福祉用具販売契約,
                    is償還払給付契約, is高額給付契約, has取扱確約書);
        }

        @Test(expected = NullPointerException.class)
        public void 契約期間がnullの時_NullPointerExceptionが発生する() {
            sut = new JuryoininJigyosha(契約番号, null, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, is住宅改修契約, is特定福祉用具販売契約,
                    is償還払給付契約, is高額給付契約, has取扱確約書);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの時_NullPointerExceptionが発生する() {
            sut = new JuryoininJigyosha(契約番号, 契約期間, null, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, is住宅改修契約, is特定福祉用具販売契約,
                    is償還払給付契約, is高額給付契約, has取扱確約書);
        }

        private static KeiyakuNo create契約番号() {
            return new KeiyakuNo(new RString("1234567890"));
        }

        private static Range<FlexibleDate> create契約期間() {
            FlexibleDate 契約開始年月日 = new FlexibleDate("20110303");
            FlexibleDate 契約終了年月日 = new FlexibleDate("20130303");
            Range<FlexibleDate> 契約期間 = new Range(契約開始年月日, 契約終了年月日);
            return 契約期間;
        }
    }
}
