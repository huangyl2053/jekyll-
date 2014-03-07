/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 要介護認定調査の調査結果（基本調査）を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultOfKihonTest {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_認定調査依頼履歴番号がNULL = 2;
    private static final int AS_調査結果がNULL = 3;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfKihon(AS_申請書管理番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査依頼履歴番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfKihon(AS_認定調査依頼履歴番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 調査結果がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfKihon(AS_調査結果がNULL);
        }
    }

    private static NinteichosaResultOfKihon createNinteichosaResultOfKihon(int flg) {
        return new NinteichosaResultOfKihon(
                flg == AS_申請書管理番号がNULL ? null : any(ShinseishoKanriNo.class),
                flg == AS_認定調査依頼履歴番号がNULL ? null : any(NinteichosaIraiRirekiNo.class), 2009,
                flg == AS_調査結果がNULL ? null : any(Ninteichosahyo.class));
    }
}
