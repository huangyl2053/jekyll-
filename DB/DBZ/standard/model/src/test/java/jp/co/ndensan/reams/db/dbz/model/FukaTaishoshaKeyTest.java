/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 対象者を特定するキー情報のテストクラスです。（賦課系）
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class FukaTaishoshaKeyTest extends DbzTestBase {

    private static final HihokenshaNo 被保険者番号 = new HihokenshaNo("0000000001");
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000001");
    private static final SetaiCode 世帯コード = new SetaiCode("00000001");
    private static final FlexibleYear 調定年度 = new FlexibleYear("2015");
    private static final FlexibleYear 賦課年度 = new FlexibleYear("2014");
    private static final TsuchishoNo 通知書番号 = new TsuchishoNo("00000001");

    public static class コンストラクタ {

        FukaTaishoshaKey sut;

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new FukaTaishoshaKey(null, 識別コード, 世帯コード, 調定年度, 賦課年度, 通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new FukaTaishoshaKey(被保険者番号, null, 世帯コード, 調定年度, 賦課年度, 通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 世帯コードがnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new FukaTaishoshaKey(被保険者番号, 識別コード, null, 調定年度, 賦課年度, 通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new FukaTaishoshaKey(被保険者番号, 識別コード, 世帯コード, 調定年度, null, 通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new FukaTaishoshaKey(被保険者番号, 識別コード, 世帯コード, 調定年度, 賦課年度, null);
        }
    }
}
