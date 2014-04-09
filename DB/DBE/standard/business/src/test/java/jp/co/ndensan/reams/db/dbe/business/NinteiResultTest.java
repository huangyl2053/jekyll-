/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.NinteiResultMock;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KaigoServiceType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShisetsuNyushoKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 要介護認定結果を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteiResultTest extends DbeTestBase {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_要介護度認定年月日がNULL = 2;
    private static final int AS_要介護状態がNULL = 3;

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteiResult(AS_申請書管理番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護度認定年月日がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteiResult(AS_要介護度認定年月日がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護状態区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteiResult(AS_要介護状態がNULL);
        }
    }

    private static NinteiResult createNinteiResult(int flg) {
        NinteiResult ninteiResult = NinteiResultMock.getSpiedInstance();
        return new NinteiResult(
                flg == AS_申請書管理番号がNULL ? null : ninteiResult.get申請書管理番号(),
                flg == AS_要介護度認定年月日がNULL ? null : FlexibleDate.MIN,
                flg == AS_要介護状態がNULL ? null : ninteiResult.get要介護状態(),
                ninteiResult.get要介護状態像例(),
                KaigoServiceType.訪問介護,
                ShisetsuNyushoKubun.入所している,
                ninteiResult.get特定疾病区分(),
                ninteiResult.get認定審査会意見(),
                ninteiResult.get認定理由());
    }
}
