/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 要介護認定調査の調査結果情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultTest {

    private static final int AS_調査票結果がNULL = 1;
    private static final int AS_概況調査結果がNULL = 2;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 調査票結果がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResult(AS_調査票結果がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 概況調査結果がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResult(AS_概況調査結果がNULL);
        }
    }

    private static NinteichosaResult createNinteichosaResult(int flg) {
        return new NinteichosaResult(
                flg == AS_調査票結果がNULL ? null : any(NinteichosaResultChosahyo.class),
                flg == AS_概況調査結果がNULL ? null : any(NinteichosaResultGaikyo.class));
    }
}
