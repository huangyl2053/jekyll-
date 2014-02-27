/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 要介護認定調査の調査結果情報（調査票）を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultChosahyoTest {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_調査票結果がNULL = 2;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultChosahyo(AS_申請書管理番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 調査票結果がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultChosahyo(AS_調査票結果がNULL);
        }
    }

    private static NinteichosaResultChosahyo createNinteichosaResultChosahyo(int flg) {
        return new NinteichosaResultChosahyo(
                flg == AS_申請書管理番号がNULL ? null : any(ShinseishoKanriNo.class), 0, 2006,
                flg == AS_調査票結果がNULL ? null : any(Map.class));
    }
}
