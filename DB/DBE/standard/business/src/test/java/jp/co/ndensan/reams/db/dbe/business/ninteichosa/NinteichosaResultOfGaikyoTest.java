/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 要介護認定調査の調査結果（概況調査）を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultOfGaikyoTest {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_認定調査依頼履歴番号がNULL = 2;
    private static final int AS_基本情報がNULL = 3;
    private static final int AS_厚労省IF識別区分がNULL = 4;
    private static final int AS_認定調査票がNULL = 5;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyo(AS_申請書管理番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査依頼履歴番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyo(AS_認定調査依頼履歴番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 厚労省IF識別区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyo(AS_厚労省IF識別区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 基本情報がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyo(AS_基本情報がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査票がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfGaikyo(AS_認定調査票がNULL);
        }
    }

    private static NinteichosaResultOfGaikyo createNinteichosaResultOfGaikyo(int flg) {
        return new NinteichosaResultOfGaikyo(
                flg == AS_申請書管理番号がNULL ? null : any(ShinseishoKanriNo.class),
                flg == AS_認定調査依頼履歴番号がNULL ? null : any(NinteichosaIraiRirekiNo.class),
                flg == AS_厚労省IF識別区分がNULL ? null : any(KoroshoIFKubun.class),
                flg == AS_基本情報がNULL ? null : any(NinteichosaResultOfGaikyoKihon.class),
                flg == AS_認定調査票がNULL ? null : any(Ninteichosahyo.class));
    }
}
