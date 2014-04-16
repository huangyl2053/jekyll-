/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChukanHyokaKomoku;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定中間評価項目得点のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class YokaigoNinteiChukanHyokaKomokuTokutenTest {

    private static YokaigoNinteiChukanHyokaKomokuTokuten sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        Map<ChukanHyokaKomoku, Integer> 中間評価項目得点群;
        private int 第1群;
        private int 第2群;
        private int 第3群;
        private int 第4群;
        private int 第5群;
        private int 第6群;
        private int 第7群;

        @Before
        public void setUp() {
            第1群 = 0;
            第2群 = 1;
            第3群 = 2;
            第4群 = 3;
            第5群 = 4;
            第6群 = 5;
            第7群 = 6;
            中間評価項目得点群 = new EnumMap<>(ChukanHyokaKomoku.class);
            中間評価項目得点群.put(ChukanHyokaKomoku.第1群, 第1群);
            中間評価項目得点群.put(ChukanHyokaKomoku.第2群, 第2群);
            中間評価項目得点群.put(ChukanHyokaKomoku.第3群, 第3群);
            中間評価項目得点群.put(ChukanHyokaKomoku.第4群, 第4群);
            中間評価項目得点群.put(ChukanHyokaKomoku.第5群, 第5群);
            中間評価項目得点群.put(ChukanHyokaKomoku.第6群, 第6群);
            中間評価項目得点群.put(ChukanHyokaKomoku.第7群, 第7群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第1群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            中間評価項目得点群.put(ChukanHyokaKomoku.第1群, -1);
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(中間評価項目得点群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第2群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            中間評価項目得点群.put(ChukanHyokaKomoku.第2群, -1);
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(中間評価項目得点群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第3群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            中間評価項目得点群.put(ChukanHyokaKomoku.第3群, -1);
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(中間評価項目得点群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第4群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            中間評価項目得点群.put(ChukanHyokaKomoku.第4群, -1);
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(中間評価項目得点群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第5群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            中間評価項目得点群.put(ChukanHyokaKomoku.第5群, -1);
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(中間評価項目得点群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第6群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            中間評価項目得点群.put(ChukanHyokaKomoku.第6群, -1);
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(中間評価項目得点群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第7群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            中間評価項目得点群.put(ChukanHyokaKomoku.第7群, -1);
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(中間評価項目得点群);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(null);
        }
    }
}
