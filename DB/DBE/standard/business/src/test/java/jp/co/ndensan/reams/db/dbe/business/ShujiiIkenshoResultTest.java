/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.ShujiiIkenshoResultMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 主治医意見書の結果を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoResultTest extends DbeTestBase {

    private static final int AS_基本情報がNULL = 1;
    private static final int AS_詳細情報がNULL = 2;

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 基本情報がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoResult(AS_基本情報がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 詳細情報がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoResult(AS_詳細情報がNULL);
        }
    }

    private static ShujiiIkenshoResult createShujiiIkenshoResult(int flg) {
        return new ShujiiIkenshoResult(
                flg == AS_基本情報がNULL ? null : ShujiiIkenshoResultMock.getSpiedShujiiIkenshoBaseInstance(),
                flg == AS_詳細情報がNULL ? null : ShujiiIkenshoResultMock.getSpiedShujiiIkenshoDetailsInstance());
    }
}
