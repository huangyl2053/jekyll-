/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.DentatsuNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinchiNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShokujiKoiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TankiKiokuKomoku;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 主治医意見書5項目のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShujiiIkensho5KomokuTest {

    private static ShujiiIkensho5Komoku sut;
    private static final ShogaiKoreishaJiritsudoKomoku 障害高齢者自立度項目_mock = mock(ShogaiKoreishaJiritsudoKomoku.class);
    private static final NinchishoKoreishaJiritsudoKomoku 認知症高齢者自立度_1_自立 = new NinchishoKoreishaJiritsudoKomoku(new Code(new RString("1")),
            new RString("自立"), new RString("自立"));
    private static final TankiKiokuKomoku 短期記憶_2 = TankiKiokuKomoku.問題あり;
    private static final NinchiNoryokuKomoku 認知能力_1 = NinchiNoryokuKomoku.自立;
    private static final DentatsuNoryokuKomoku 伝達能力_3 = DentatsuNoryokuKomoku.具体的要求に限られる;
    private static final ShokujiKoiHyokaKomoku 食事行為_1 = ShokujiKoiHyokaKomoku.自立ないし何とか自分で食べられる;

    public static class コンストラクタ_引数から5項目を渡す場合のテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 障害高齢者自立度項目にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShujiiIkensho5Komoku(null, 認知症高齢者自立度_1_自立, 短期記憶_2,
                    認知能力_1, 伝達能力_3, 食事行為_1);
        }

        @Test(expected = NullPointerException.class)
        public void 認知症高齢者自立度にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShujiiIkensho5Komoku(障害高齢者自立度項目_mock, null, 短期記憶_2,
                    認知能力_1, 伝達能力_3, 食事行為_1);
        }

        @Test(expected = NullPointerException.class)
        public void 短期記憶にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShujiiIkensho5Komoku(障害高齢者自立度項目_mock, 認知症高齢者自立度_1_自立, null,
                    認知能力_1, 伝達能力_3, 食事行為_1);
        }

        @Test(expected = NullPointerException.class)
        public void 認知能力にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShujiiIkensho5Komoku(障害高齢者自立度項目_mock, 認知症高齢者自立度_1_自立, 短期記憶_2,
                    null, 伝達能力_3, 食事行為_1);
        }

        @Test(expected = NullPointerException.class)
        public void 伝達能力にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShujiiIkensho5Komoku(障害高齢者自立度項目_mock, 認知症高齢者自立度_1_自立, 短期記憶_2,
                    認知能力_1, null, 食事行為_1);
        }

        @Test(expected = NullPointerException.class)
        public void 食事行為にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShujiiIkensho5Komoku(障害高齢者自立度項目_mock, 認知症高齢者自立度_1_自立, 短期記憶_2,
                    認知能力_1, 伝達能力_3, null);
        }
    }

    public static class 仮一次判定で使用する_記載が無いことを表す定数のテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = ShujiiIkensho5Komoku.KISAI_NASHI;
        }

        @Test
        public void get認知症高齢者自立度で_記載無しが返る() {
            assertThat(sut.get認知症高齢者自立度().getMeisho(), is(new RString("記載無し")));
        }

        @Test
        public void get短期記憶で_記載無しが返る() {
            assertThat(sut.get短期記憶(), is(TankiKiokuKomoku.記載無し));
        }

        @Test
        public void get認知能力で_記載無しが返る() {
            assertThat(sut.get認知能力(), is(NinchiNoryokuKomoku.記載無し));
        }

        @Test
        public void get伝達能力で_記載無しが返る() {
            assertThat(sut.get伝達能力(), is(DentatsuNoryokuKomoku.記載無し));
        }

        @Test
        public void get食事行為で_記載無しが返る() {
            assertThat(sut.get食事行為(), is(ShokujiKoiHyokaKomoku.記載無し));
        }
    }

    public static class get5項目回答のテスト extends DbeTestBase {

        @Test
        public void コンストラクタから項目を指定したとき_指定した項目あわせた数列が返る() {
            sut = new ShujiiIkensho5Komoku(障害高齢者自立度項目_mock, 認知症高齢者自立度_1_自立, 短期記憶_2,
                    認知能力_1, 伝達能力_3, 食事行為_1);
            assertThat(sut.get5項目回答(), is(new RString("12131")));
        }

        @Test
        public void 記載が無いことを表す定数の場合_99999が返る() {
            assertThat(ShujiiIkensho5Komoku.KISAI_NASHI.get5項目回答(), is(new RString("99999")));
        }
    }
}
