/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.JutakuKaishuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KogakuKyufuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShokanbaraiKyufuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.TokuteiFukushiYoguHanbaiKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ToriatsukaiKakuyakushoKubun;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 受領委任者のテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JuryoininJigyoshaTest extends DbcTestBase {

    private static JuryoininJigyosha sut;
    private static KeiyakuNo 契約番号;
    private static Range<FlexibleDate> 契約期間;
    private static YMDHMS 処理日時;
    private static FlexibleDate 届出年月日;
    private static Todokedesha 届出者;
    private static FlexibleDate 契約登録年月日;
    private static KeiyakuJigyosha 契約事業者;
    private static JutakuKaishuKeiyakuKubun 住宅改修契約区分;
    private static TokuteiFukushiYoguHanbaiKeiyakuKubun 特定福祉用具販売契約区分;
    private static ShokanbaraiKyufuKeiyakuKubun 償還払給付契約区分;
    private static KogakuKyufuKeiyakuKubun 高額給付契約区分;
    private static ToriatsukaiKakuyakushoKubun 取扱確約書区分;

    @BeforeClass
    public static void setUp() {
        契約番号 = create契約番号();
        契約期間 = create契約期間();
        処理日時 = mock(YMDHMS.class);
        届出年月日 = mock(FlexibleDate.class);
        届出者 = mock(Todokedesha.class);
        契約登録年月日 = mock(FlexibleDate.class);
        契約事業者 = mock(KeiyakuJigyosha.class);
        住宅改修契約区分 = JutakuKaishuKeiyakuKubun.契約有り;
        特定福祉用具販売契約区分 = TokuteiFukushiYoguHanbaiKeiyakuKubun.契約無し;
        償還払給付契約区分 = ShokanbaraiKyufuKeiyakuKubun.契約無し;
        高額給付契約区分 = KogakuKyufuKeiyakuKubun.契約無し;
        取扱確約書区分 = ToriatsukaiKakuyakushoKubun.確約書有り;
    }

    public static class ConstructorTest extends DbcTestBase {

        @Test
        public void 引数に必要な値が渡された時_インスタンスが生成される() {
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut, is(instanceOf(JuryoininJigyosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 契約番号がnullの時_NullPointerExceptionが発生する() {
            sut = new JuryoininJigyosha(null, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
        }

        @Test(expected = NullPointerException.class)
        public void 契約期間がnullの時_NullPointerExceptionが発生する() {
            sut = new JuryoininJigyosha(契約番号, null, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの時_NullPointerExceptionが発生する() {
            sut = new JuryoininJigyosha(契約番号, 契約期間, null, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
        }

        @Test(expected = NullPointerException.class)
        public void 契約事業者がnullの時_NullPointerExceptionが発生する() {
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, null, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
        }
    }

    public static class has住宅改修契約Test {

        @Test
        public void 住宅改修契約区分がnullの時_has住宅改修契約は_falseを返す() {
            住宅改修契約区分 = null;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has住宅改修契約(), is(false));
        }

        @Test
        public void 住宅改修契約区分が契約無しの時__has住宅改修契約は_falseを返す() {
            住宅改修契約区分 = JutakuKaishuKeiyakuKubun.契約無し;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has住宅改修契約(), is(false));
        }

        @Test
        public void 住宅改修契約区分が契約有りの時__has住宅改修契約は_trueを返す() {
            住宅改修契約区分 = JutakuKaishuKeiyakuKubun.契約有り;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has住宅改修契約(), is(true));
        }
    }

    public static class has特定福祉用具販売契約Test {

        @Test
        public void 特定福祉用具販売契約区分がnullの時_has特定福祉用具販売契約は_falseを返す() {
            特定福祉用具販売契約区分 = null;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has特定福祉用具販売契約(), is(false));
        }

        @Test
        public void 特定福祉用具販売契約区分が契約無しの時__has特定福祉用具販売契約は_falseを返す() {
            特定福祉用具販売契約区分 = TokuteiFukushiYoguHanbaiKeiyakuKubun.契約無し;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has特定福祉用具販売契約(), is(false));
        }

        @Test
        public void 特定福祉用具販売契約区分が契約有りの時__has特定福祉用具販売契約は_trueを返す() {
            特定福祉用具販売契約区分 = TokuteiFukushiYoguHanbaiKeiyakuKubun.契約有り;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has特定福祉用具販売契約(), is(true));
        }
    }

    public static class has償還払給付契約Test {

        @Test
        public void 償還払給付契約区分がnullの時_has償還払給付契約は_falseを返す() {
            償還払給付契約区分 = null;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has償還払給付契約(), is(false));
        }

        @Test
        public void 償還払給付契約区分が契約無しの時__has償還払給付契約は_falseを返す() {
            償還払給付契約区分 = ShokanbaraiKyufuKeiyakuKubun.契約無し;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has償還払給付契約(), is(false));
        }

        @Test
        public void 償還払給付契約区分が契約有りの時__has償還払給付契約は_trueを返す() {
            償還払給付契約区分 = ShokanbaraiKyufuKeiyakuKubun.契約有り;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has償還払給付契約(), is(true));
        }
    }

    public static class has高額給付契約Test {

        @Test
        public void 高額給付契約区分がnullの時_has高額給付契約は_falseを返す() {
            高額給付契約区分 = null;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has高額給付契約(), is(false));
        }

        @Test
        public void 高額給付契約区分が契約無しの時__has高額給付契約は_falseを返す() {
            高額給付契約区分 = KogakuKyufuKeiyakuKubun.契約無し;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has高額給付契約(), is(false));
        }

        @Test
        public void 高額給付契約区分が契約有りの時__has高額給付契約は_trueを返す() {
            高額給付契約区分 = KogakuKyufuKeiyakuKubun.契約有り;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has高額給付契約(), is(true));
        }
    }

    public static class has取扱確約書Test {

        @Test
        public void 取扱確約書区分がnullの時_has取扱確約書は_falseを返す() {
            取扱確約書区分 = null;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has取扱確約書(), is(false));
        }

        @Test
        public void 取扱確約書区分が契約無しの時__has取扱確約書は_falseを返す() {
            取扱確約書区分 = ToriatsukaiKakuyakushoKubun.確約書無し;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has取扱確約書(), is(false));
        }

        @Test
        public void 取扱確約書区分が契約有りの時__has取扱確約書は_trueを返す() {
            取扱確約書区分 = ToriatsukaiKakuyakushoKubun.確約書有り;
            sut = new JuryoininJigyosha(契約番号, 契約期間, 処理日時, 届出年月日, 届出者,
                    契約登録年月日, 契約事業者, 住宅改修契約区分, 特定福祉用具販売契約区分,
                    償還払給付契約区分, 高額給付契約区分, 取扱確約書区分);
            assertThat(sut.has取扱確約書(), is(true));
        }
    }

    private static KeiyakuNo create契約番号() {
        return new KeiyakuNo(new RString("1234567890"));
    }

    private static Range<FlexibleDate> create契約期間() {
        FlexibleDate 契約開始年月日 = new FlexibleDate("20110303");
        FlexibleDate 契約終了年月日 = new FlexibleDate("20130303");
        return new Range(契約開始年月日, 契約終了年月日);
    }
}
