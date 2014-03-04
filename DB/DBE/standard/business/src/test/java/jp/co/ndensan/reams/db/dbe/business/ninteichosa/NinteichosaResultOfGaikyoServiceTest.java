/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 要介護認定調査の調査結果情報（概況調査サービス状況）を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultOfGaikyoServiceTest {

    private static final int AS_サービス区分がNULL = 1;
    private static final int AS_現在の状況がNULL = 2;
    private static final int AS_市町村特別給付がNULL = 3;
    private static final int AS_介護保険給付以外の在宅サービスがNULL = 4;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void サービス区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyoService(AS_サービス区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 現在の状況がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyoService(AS_現在の状況がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村特別給付がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyoService(AS_市町村特別給付がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 介護保険給付以外の在宅サービスがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaResultGaikyoService(AS_介護保険給付以外の在宅サービスがNULL);
        }
    }

    private static NinteichosaResultOfGaikyoService createNinteichosaResultGaikyoService(int flg) {
        return new NinteichosaResultOfGaikyoService(
                flg == AS_サービス区分がNULL ? null : any(ServiceKubun.class),
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
                flg == AS_現在の状況がNULL ? null : any(GenzaiJokyoKubun.class),
                flg == AS_市町村特別給付がNULL ? null : any(RString.class),
                flg == AS_介護保険給付以外の在宅サービスがNULL ? null : any(RString.class));
    }
}
