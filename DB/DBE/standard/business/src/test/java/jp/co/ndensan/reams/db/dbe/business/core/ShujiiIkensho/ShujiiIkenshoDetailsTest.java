/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ShujiiIkensho;

import jp.co.ndensan.reams.db.dbe.business.core.shujiiikensho.ShujiiIkenshoDetails;
import jp.co.ndensan.reams.db.dbe.business.helper.ShujiiIkenshoResultMock;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 主治医意見書の詳細情報を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoDetailsTest extends DbeTestBase {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_意見書履歴番号がNULL = 2;
    private static final int AS_厚労省IF識別区分がNULL = 3;
    private static final int AS_主治医意見書がNULL = 4;

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoDetails(AS_申請書管理番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 見書履歴番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoDetails(AS_意見書履歴番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 厚労省IF識別区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoDetails(AS_厚労省IF識別区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医意見書がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoDetails(AS_主治医意見書がNULL);
        }
    }

    private static ShujiiIkenshoDetails createShujiiIkenshoDetails(int flg) {
        return new ShujiiIkenshoDetails(
                flg == AS_申請書管理番号がNULL ? null : new ShinseishoKanriNo(new RString("1234567890")),
                flg == AS_意見書履歴番号がNULL ? null : new IkenshosakuseiIraiRirekiNo(0),
                flg == AS_厚労省IF識別区分がNULL ? null : KoroshoIFKubun.V09A,
                flg == AS_主治医意見書がNULL ? null : ShujiiIkenshoResultMock.getSpiedShujiiIkenshoDetailsInstance().get主治医意見書());
    }
}
