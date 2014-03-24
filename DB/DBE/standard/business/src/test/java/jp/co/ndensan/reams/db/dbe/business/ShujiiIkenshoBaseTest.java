/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiKaisu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiryoShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * 主治医意見書の基本情報を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoBaseTest {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_主治医意見書履歴番号がNULL = 2;
    private static final int AS_意見書依頼区分がNULL = 3;
    private static final int AS_主治医がNULL = 4;
    private static final int AS_意見書受領年月日がNULL = 5;
    private static final int AS_意見書記入年月日がNULL = 6;
    private static final int AS_意見書作成回数がNULL = 7;
    private static final int AS_意見書作成料種別がNULL = 8;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoBase(AS_申請書管理番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医意見書履歴番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoBase(AS_主治医意見書履歴番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書依頼区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoBase(AS_意見書依頼区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoBase(AS_主治医がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書受領年月日がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoBase(AS_意見書受領年月日がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書記入年月日がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoBase(AS_意見書記入年月日がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書作成回数がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoBase(AS_意見書作成回数がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書作成料種別がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoBase(AS_意見書作成料種別がNULL);
        }
    }

    private static ShujiiIkenshoBase createShujiiIkenshoBase(int flg) {
        return new ShujiiIkenshoBase(
                flg == AS_申請書管理番号がNULL ? null : any(ShinseishoKanriNo.class),
                flg == AS_主治医意見書履歴番号がNULL ? null : any(ShujiiIkenshoRirekiNo.class),
                flg == AS_意見書依頼区分がNULL ? null : any(ShujiiIkenshoIraiKubun.class),
                flg == AS_主治医がNULL ? null : any(KaigoDoctor.class),
                flg == AS_意見書受領年月日がNULL ? null : any(FlexibleDate.class),
                flg == AS_意見書記入年月日がNULL ? null : any(FlexibleDate.class),
                flg == AS_意見書作成回数がNULL ? null : any(ShujiiIkenshoSakuseiKaisu.class),
                flg == AS_意見書作成料種別がNULL ? null : any(ShujiiIkenshoSakuseiryoShubetsu.class),
                true,
                false);
    }
}
