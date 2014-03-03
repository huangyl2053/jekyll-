/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IshiShikibetsuNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIryoKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * 主治医意見書作成依頼情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoSakuseiIraiJohoTest {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_意見書作成依頼履歴番号がNULL = 2;
    private static final int AS_主治医医療機関コードがNULL = 3;
    private static final int AS_医師識別番号がNULL = 4;
    private static final int AS_意見書作成依頼区分がNULL = 5;
    private static final int AS_医師区分がNULL = 6;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIraiJoho(AS_申請書管理番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書作成依頼履歴番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIraiJoho(AS_意見書作成依頼履歴番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医医療機関コードがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIraiJoho(AS_主治医医療機関コードがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 医師識別番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIraiJoho(AS_医師識別番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書作成依頼区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIraiJoho(AS_意見書作成依頼区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 医師区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIraiJoho(AS_医師区分がNULL);
        }
    }

    private static ShujiiIkenshoSakuseiIraiJoho createShujiiIkenshoSakuseiIraiJoho(int flg) {
        return new ShujiiIkenshoSakuseiIraiJoho(
                flg == AS_申請書管理番号がNULL ? null : any(ShinseishoKanriNo.class),
                flg == AS_意見書作成依頼履歴番号がNULL ? null : any(IkenshosakuseiIraiRirekiNo.class),
                flg == AS_主治医医療機関コードがNULL ? null : any(ShujiiIryoKikanCode.class),
                flg == AS_医師識別番号がNULL ? null : any(IshiShikibetsuNo.class),
                flg == AS_意見書作成依頼区分がNULL ? null : any(IkenshoIraiKubun.class), 0,
                flg == AS_医師区分がNULL ? null : any(IshiKubun.class),
                any(FlexibleDate.class),
                any(FlexibleDate.class),
                any(FlexibleDate.class),
                any(FlexibleDate.class),
                any(SakuseiryoSeikyuKubun.class),
                any(FlexibleDate.class),
                any(IkenshoSakuseiTokusokuHoho.class), 0,
                any(RString.class));
    }
}
