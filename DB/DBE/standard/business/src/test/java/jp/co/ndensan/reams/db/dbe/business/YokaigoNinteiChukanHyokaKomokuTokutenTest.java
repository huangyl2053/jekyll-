/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
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
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第1群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(-1, 第2群, 第3群, 第4群, 第5群, 第6群, 第7群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第2群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(第1群, -1, 第3群, 第4群, 第5群, 第6群, 第7群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第3群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(第1群, 第2群, -1, 第4群, 第5群, 第6群, 第7群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第4群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(第1群, 第2群, 第3群, -1, 第5群, 第6群, 第7群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第5群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(第1群, 第2群, 第3群, 第4群, -1, 第6群, 第7群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第6群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(第1群, 第2群, 第3群, 第4群, 第5群, -1, 第7群);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 第7群に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(第1群, 第2群, 第3群, 第4群, 第5群, 第6群, -1);
        }

        @Test
        public void 引数に渡された値が_すべて0以上であるとき_インスタンスが生成される() {
            sut = new YokaigoNinteiChukanHyokaKomokuTokuten(第1群, 第2群, 第3群, 第4群, 第5群, 第6群, 第7群);
            assertThat(sut, is(instanceOf(YokaigoNinteiChukanHyokaKomokuTokuten.class)));
        }
    }
}
