/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.NinteichosaKekkaMock;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（概況調査）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaGaikyoTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 基本情報がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyo(
                    null,
                    NinteichosaKekkaMock.getSpiedChosaKekkaGaikyoServiceInstance());
        }

        @Test(expected = NullPointerException.class)
        public void サービス状況がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyo(
                    NinteichosaKekkaMock.getSpiedChosaKekkaGaikyoKihonInstance(),
                    null);
        }
    }
}
