/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.NinteichosaResultMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 要介護認定調査の調査結果を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultTest extends DbeTestBase {

    private static final int AS_概況調査結果がNULL = 1;
    private static final int AS_基本調査結果がNULL = 2;

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 概況調査結果がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResult(AS_概況調査結果がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 基本調査結果がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResult(AS_基本調査結果がNULL);
        }
    }

    private static NinteichosaResult createNinteichosaResult(int flg) {
        return new NinteichosaResult(
                flg == AS_概況調査結果がNULL ? null : NinteichosaResultMock.getSpiedNinteichosaResultGaikyoInstance(),
                flg == AS_基本調査結果がNULL ? null : NinteichosaResultMock.getSpiedNinteichosaResultKihonInstance());
    }
}
