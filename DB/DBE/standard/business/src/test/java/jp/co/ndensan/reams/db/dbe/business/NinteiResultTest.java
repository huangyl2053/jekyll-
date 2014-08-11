/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.NinteiResultMock;
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
    private static final int AS_処理日時がNULL = 2;
    private static final int AS_証記載保険者番号がNULL = 3;
    private static final int AS_被保険者番号がNULL = 4;
    private static final int AS_要介護度認定年月日がNULL = 5;
    private static final int AS_要介護状態がNULL = 6;

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteiResult(AS_申請書管理番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteiResult(AS_処理日時がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteiResult(AS_証記載保険者番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteiResult(AS_被保険者番号がNULL);
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
                flg == AS_処理日時がNULL ? null : ninteiResult.get処理日時(),
                flg == AS_証記載保険者番号がNULL ? null : ninteiResult.get証記載保険者番号(),
                flg == AS_被保険者番号がNULL ? null : ninteiResult.get被保険者番号(),
                flg == AS_要介護度認定年月日がNULL ? null : FlexibleDate.MIN,
                flg == AS_要介護状態がNULL ? null : ninteiResult.get要介護状態(),
                ninteiResult.get要介護状態像例(),
                ninteiResult.get介護サービス種類０１(),
                ninteiResult.get介護サービス種類０２(),
                ninteiResult.get介護サービス種類０３(),
                ninteiResult.get介護サービス種類０４(),
                ninteiResult.get介護サービス種類０５(),
                ninteiResult.get介護サービス種類０６(),
                ninteiResult.get介護サービス種類０７(),
                ninteiResult.get介護サービス種類０８(),
                ninteiResult.get介護サービス種類０９(),
                ninteiResult.get介護サービス種類１０(),
                ninteiResult.get介護サービス種類１１(),
                ninteiResult.get介護サービス種類１２(),
                ninteiResult.get介護サービス種類１３(),
                ninteiResult.get介護サービス種類１４(),
                ninteiResult.get介護サービス種類１５(),
                ninteiResult.get介護サービス種類１６(),
                ninteiResult.get介護サービス種類１７(),
                ninteiResult.get介護サービス種類１８(),
                ninteiResult.get介護サービス種類１９(),
                ninteiResult.get介護サービス種類２０(),
                ninteiResult.get介護サービス種類２１(),
                ninteiResult.get介護サービス種類２２(),
                ninteiResult.get介護サービス種類２３(),
                ninteiResult.get介護サービス種類２４(),
                ninteiResult.get介護サービス種類２５(),
                ninteiResult.get介護サービス種類２６(),
                ninteiResult.get介護サービス種類２７(),
                ninteiResult.get介護サービス種類２８(),
                ninteiResult.get介護サービス種類２９(),
                ninteiResult.get介護サービス種類３０(),
                ninteiResult.get施設入所区分(),
                ninteiResult.get特定疾病(),
                ninteiResult.get認定審査会意見(),
                ninteiResult.get認定結果異動(),
                ninteiResult.get認定取消(),
                ninteiResult.get通知区分(),
                ninteiResult.get認定理由(),
                ninteiResult.getIF送付年月日());
    }
}
