/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 要介護認定調査の調査結果情報（概況調査）を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultGaikyoTest {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_基本情報がNULL = 2;
    private static final int AS_サービス状況がNULL = 3;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyo(AS_申請書管理番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 基本情報がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyo(AS_基本情報がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void サービス状況がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyo(AS_サービス状況がNULL);
        }
    }

    private static NinteichosaResultGaikyo createNinteichosaResultGaikyo(int flg) {
        return new NinteichosaResultGaikyo(
                flg == AS_申請書管理番号がNULL ? null : any(ShinseishoKanriNo.class), 0,
                flg == AS_基本情報がNULL ? null : any(NinteichosaResultGaikyoKihon.class),
                flg == AS_サービス状況がNULL ? null : any(NinteichosaResultGaikyoService.class));
    }
}
