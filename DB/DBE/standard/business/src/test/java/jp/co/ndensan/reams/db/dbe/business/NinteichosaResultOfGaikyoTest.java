/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.NinteichosaResultMock;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 要介護認定調査の調査結果（概況調査）を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultOfGaikyoTest extends DbeTestBase {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_認定調査依頼履歴番号がNULL = 2;
    private static final int AS_基本情報がNULL = 3;
    private static final int AS_厚労省IF識別区分がNULL = 4;
    private static final int AS_認定調査票がNULL = 5;

    public static class コンストラクタ extends DbeTestBase {

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
                flg == AS_申請書管理番号がNULL ? null : new ShinseishoKanriNo(new RString("1234567890")),
                flg == AS_認定調査依頼履歴番号がNULL ? null : new NinteichosaIraiRirekiNo(0),
                flg == AS_厚労省IF識別区分がNULL ? null : KoroshoIFKubun.V09A,
                flg == AS_基本情報がNULL ? null : NinteichosaResultMock.getSpiedNinteichosaResultGaikyoInstance().get基本情報(),
                flg == AS_認定調査票がNULL ? null : NinteichosaResultMock.getSpiedNinteichosaResultGaikyoInstance().get認定調査票());
    }
}
