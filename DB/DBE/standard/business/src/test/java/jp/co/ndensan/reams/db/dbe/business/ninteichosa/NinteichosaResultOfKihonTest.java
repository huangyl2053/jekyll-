/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.business.helper.NinteichosaResultMock;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査の調査結果（基本調査）を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultOfKihonTest {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_認定調査依頼履歴番号がNULL = 2;
    private static final int AS_厚労省IF識別区分がNULL = 3;
    private static final int AS_認定調査票がNULL = 4;

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
        public void 厚労省IF識別区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfKihon(AS_厚労省IF識別区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査票がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultOfKihon(AS_認定調査票がNULL);
        }
    }

    private static NinteichosaResultOfKihon createNinteichosaResultOfKihon(int flg) {
        return new NinteichosaResultOfKihon(
                flg == AS_申請書管理番号がNULL ? null : new ShinseishoKanriNo(new RString("1234567890")),
                flg == AS_認定調査依頼履歴番号がNULL ? null : new NinteichosaIraiRirekiNo(0),
                flg == AS_厚労省IF識別区分がNULL ? null : KoroshoIFKubun.V09A,
                flg == AS_認定調査票がNULL ? null : NinteichosaResultMock.getSpiedNinteichosaResultKihonInstance().get認定調査票());
    }
}
