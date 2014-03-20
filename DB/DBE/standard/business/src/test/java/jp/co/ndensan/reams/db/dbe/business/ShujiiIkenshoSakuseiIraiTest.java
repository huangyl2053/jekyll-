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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

/**
 * 主治医意見書作成依頼情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoSakuseiIraiTest {

    private static final int AS_申請書管理番号がNULL = 1;
    private static final int AS_意見書作成依頼履歴番号がNULL = 2;
    private static final int AS_介護医師がNULL = 3;
    private static final int AS_意見書作成依頼区分がNULL = 4;
    private static final int AS_医師区分がNULL = 5;
    private static final int AS_意見書作成依頼済 = 6;
    private static final int AS_意見書作成未依頼 = 7;
    private static final int AS_意見書出力済 = 8;
    private static final int AS_意見書未出力 = 9;
    private static final int AS_請求書出力済 = 10;
    private static final int AS_請求書未出力 = 11;
    private static final int AS_督促情報がある = 12;
    private static final int AS_督促情報がNULL = 13;
    private static final int AS_督促情報内項目がNULL = 14;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIrai(AS_申請書管理番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書作成依頼履歴番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIrai(AS_意見書作成依頼履歴番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 介護医師がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIrai(AS_介護医師がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書作成依頼区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIrai(AS_意見書作成依頼区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 医師区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoSakuseiIrai(AS_医師区分がNULL);
        }
    }

    public static class is意見書作成依頼済み {

        @Test
        public void 意見書作成依頼済の時_is意見書作成依頼済みは_TRUEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_意見書作成依頼済).is意見書作成依頼済み(), is(true));
        }

        @Test
        public void 意見書作成未依頼の時_is意見書作成依頼済みは_FALSEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_意見書作成未依頼).is意見書作成依頼済み(), is(false));
        }
    }

    public static class is意見書出力済み {

        @Test
        public void 意見書出力済の時_is意見書出力済みは_TRUEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_意見書出力済).is意見書出力済み(), is(true));
        }

        @Test
        public void 意見書未出力の時_is意見書出力済みは_FALSEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_意見書未出力).is意見書出力済み(), is(false));
        }
    }

    public static class is請求書出力済み {

        @Test
        public void 請求書出力済の時_is請求書出力済みは_TRUEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_請求書出力済).is請求書出力済み(), is(true));
        }

        @Test
        public void 請求書未出力の時_is請求書出力済みは_FALSEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_請求書未出力).is請求書出力済み(), is(false));
        }
    }

    public static class is意見書作成督促済み {

        @Test
        public void 督促情報がある時_is意見書作成督促済みは_TRUEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_督促情報がある).is意見書作成督促済み(), is(true));
        }

        @Test
        public void 督促情報がNULLの時_is意見書作成督促済みは_FALSEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_督促情報がNULL).is意見書作成督促済み(), is(false));
        }

        @Test
        public void 督促情報内項目がNULLの時_is意見書作成督促済みは_FALSEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_督促情報内項目がNULL).is意見書作成督促済み(), is(false));
        }
    }

    private static ShujiiIkenshoSakuseiIrai createShujiiIkenshoSakuseiIrai(int flg) {
        return new ShujiiIkenshoSakuseiIrai(
                flg == AS_申請書管理番号がNULL ? null : mock(ShinseishoKanriNo.class),
                flg == AS_意見書作成依頼履歴番号がNULL ? null : mock(IkenshosakuseiIraiRirekiNo.class),
                flg == AS_介護医師がNULL ? null : mock(KaigoDoctor.class),
                flg == AS_意見書作成依頼区分がNULL ? null : IkenshoIraiKubun.初回依頼, 0,
                flg == AS_医師区分がNULL ? null : IshiKubun.主治医,
                flg == AS_意見書作成依頼済 ? FlexibleDate.MAX : FlexibleDate.MIN,
                FlexibleDate.MAX,
                flg == AS_意見書出力済 ? FlexibleDate.MAX : FlexibleDate.MIN,
                flg == AS_請求書出力済 ? FlexibleDate.MAX : FlexibleDate.MIN,
                SakuseiryoSeikyuKubun.施設新規,
                flg == AS_督促情報がNULL ? null
                : flg == AS_督促情報内項目がNULL ? new ShujiiIkenshoSakuseiTokusoku(null, null, 0, null)
                : new ShujiiIkenshoSakuseiTokusoku(FlexibleDate.MAX, IkenshoSakuseiTokusokuHoho.督促状郵送, 1, RString.EMPTY));
    }
}
