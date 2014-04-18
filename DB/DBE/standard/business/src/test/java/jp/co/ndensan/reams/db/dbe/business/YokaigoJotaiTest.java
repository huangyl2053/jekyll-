/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.NinteiResultMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 要介護状態を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class YokaigoJotaiTest extends DbeTestBase {

    private static final int AS_要介護状態区分がNULL = 1;
    private static final int AS_認定有効期間がNULL = 2;

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 要介護状態区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createYokaigoJotai(AS_要介護状態区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 認定有効期間がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createYokaigoJotai(AS_認定有効期間がNULL);
        }
    }

    private static YokaigoJotai createYokaigoJotai(int flg) {
        YokaigoJotai yokaigoJotai = NinteiResultMock.getSpiedInstance().get要介護状態();
        return new YokaigoJotai(
                flg == AS_要介護状態区分がNULL ? null : yokaigoJotai.get要介護状態区分(),
                flg == AS_認定有効期間がNULL ? null : yokaigoJotai.get認定有効期間());
    }
}
