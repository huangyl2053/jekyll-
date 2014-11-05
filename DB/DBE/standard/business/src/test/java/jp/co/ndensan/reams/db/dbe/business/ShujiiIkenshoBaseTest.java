/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.ShujiiIkenshoResultMock;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoDoi;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiJohoTeikyoKibo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiKaisu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiryoShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 主治医意見書の基本情報を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoBaseTest extends DbeTestBase {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_主治医意見書履歴番号がNULL = 2;
    private static final int AS_意見書依頼区分がNULL = 3;
    private static final int AS_主治医がNULL = 4;
    private static final int AS_意見書受領年月日がNULL = 5;
    private static final int AS_意見書記入年月日がNULL = 6;
    private static final int AS_意見書作成回数がNULL = 7;
    private static final int AS_意見書作成料種別がNULL = 8;
    private static final int AS_認定情報提供希望がNULL = 9;
    private static final int AS_意見書同意がNULL = 10;

    public static class コンストラクタ extends DbeTestBase {

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

        @Test(expected = NullPointerException.class)
        public void 認定情報提供希望がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoBase(AS_認定情報提供希望がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書同意がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoBase(AS_意見書同意がNULL);
        }
    }

    private static ShujiiIkenshoBase createShujiiIkenshoBase(int flg) {
        return new ShujiiIkenshoBase(
                flg == AS_申請書管理番号がNULL ? null : new ShinseishoKanriNo(new RString("1234567890")),
                flg == AS_主治医意見書履歴番号がNULL ? null : new IkenshosakuseiIraiRirekiNo(0),
                flg == AS_意見書依頼区分がNULL ? null : ShujiiIkenshoIraiKubun.初回,
                flg == AS_主治医がNULL ? null : ShujiiIkenshoResultMock.getSpiedShujiiIkenshoBaseInstance().get主治医(),
                flg == AS_意見書受領年月日がNULL ? null : FlexibleDate.MIN,
                flg == AS_意見書記入年月日がNULL ? null : FlexibleDate.MAX,
                flg == AS_意見書作成回数がNULL ? null : ShujiiIkenshoSakuseiKaisu.初回,
                flg == AS_意見書作成料種別がNULL ? null : ShujiiIkenshoSakuseiryoShubetsu.施設,
                flg == AS_認定情報提供希望がNULL ? null : NinteiJohoTeikyoKibo.希望する,
                flg == AS_意見書同意がNULL ? null : IkenshoDoi.同意しない);
    }
}
