/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 対象者を特定するキー情報のテストクラスです。（資格系）
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class TaishoshaKeyTest extends DbzTestBase {

    private static final HihokenshaNo 被保険者番号 = new HihokenshaNo("0000000001");
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000001");
    private static final SetaiCode 世帯コード = new SetaiCode("00000001");

    public static class コンストラクタ {

        TaishoshaKey sut;

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new TaishoshaKey(null, 識別コード, 世帯コード);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new TaishoshaKey(被保険者番号, null, 世帯コード);
        }

        @Test(expected = NullPointerException.class)
        public void 世帯コードがnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new TaishoshaKey(被保険者番号, 識別コード, null);
        }
    }
}
