/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（概況調査サービス状況）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaGaikyoServiceTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void サービス区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoService(
                    null,
                    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
                    GenzaiJokyoKubun.指定介護療養型医療施設,
                    new RString("市町村特別給付"),
                    new RString("介護保険給付以外の在宅サービス"));
        }

        @Test(expected = NullPointerException.class)
        public void 現在の状況がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoService(
                    ServiceKubun.介護給付サービス,
                    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
                    null,
                    new RString("市町村特別給付"),
                    new RString("介護保険給付以外の在宅サービス"));
        }

        @Test(expected = NullPointerException.class)
        public void 市町村特別給付がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoService(
                    ServiceKubun.介護給付サービス,
                    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
                    GenzaiJokyoKubun.指定介護療養型医療施設,
                    null,
                    new RString("介護保険給付以外の在宅サービス"));
        }

        @Test(expected = NullPointerException.class)
        public void 介護保険給付以外の在宅サービスがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaGaikyoService(
                    ServiceKubun.介護給付サービス,
                    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
                    GenzaiJokyoKubun.指定介護療養型医療施設,
                    new RString("市町村特別給付"),
                    null);
        }
    }
}
