/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.business.IDoctors;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikan;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business._Doctor;
import jp.co.ndensan.reams.ur.urz.business._Doctors;
import jp.co.ndensan.reams.ur.urz.business._IryoKikan;
import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Name;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
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
public class ShujiiIkenshoSakuseiIraiTest extends DbeTestBase {

//TODO N1013 松本 mockの取り扱いがわかるまで保留　2014/03/24
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

    public static class コンストラクタ extends DbeTestBase {

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

    public static class is意見書作成依頼済み extends DbeTestBase {

        @Test
        public void 意見書作成依頼済の時_is意見書作成依頼済みは_TRUEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_意見書作成依頼済).is意見書作成依頼済み(), is(true));
        }

        @Test
        public void 意見書作成未依頼の時_is意見書作成依頼済みは_FALSEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_意見書作成未依頼).is意見書作成依頼済み(), is(false));
        }
    }

    public static class is意見書出力済み extends DbeTestBase {

        @Test
        public void 意見書出力済の時_is意見書出力済みは_TRUEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_意見書出力済).is意見書出力済み(), is(true));
        }

        @Test
        public void 意見書未出力の時_is意見書出力済みは_FALSEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_意見書未出力).is意見書出力済み(), is(false));
        }
    }

    public static class is請求書出力済み extends DbeTestBase {

        @Test
        public void 請求書出力済の時_is請求書出力済みは_TRUEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_請求書出力済).is請求書出力済み(), is(true));
        }

        @Test
        public void 請求書未出力の時_is請求書出力済みは_FALSEを返す() {
            assertThat(createShujiiIkenshoSakuseiIrai(AS_請求書未出力).is請求書出力済み(), is(false));
        }
    }

    public static class is意見書作成督促済み extends DbeTestBase {

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
        AtenaMeisho 医師氏名 = new AtenaMeisho(new RString("医師氏名"));
        Code 所属診療科 = new Code(new RString("000"));
        Code 医師区分 = new Code(new RString("000"));
        IIryoKikanCode iryoKikanCode = new _IryoKikanCode(new RString("123456789"));
        IDoctor 医師 = new _Doctor(new RString("医師識別番号"), 医師氏名, iryoKikanCode,
                所属診療科, 医師区分);
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(new RString("0000000001"));
        AtenaMeisho 医療機関名称漢字 = new AtenaMeisho(new RString("医療機関名称漢字"));
        AtenaKanaMeisho 医療機関名称カナ = new AtenaKanaMeisho(new RString("医療機関名称カナ"));
        IName 医療機関名称 = new _Name(医療機関名称漢字, 医療機関名称カナ);
        AtenaMeisho 医療機関略称漢字 = new AtenaMeisho(new RString("医療機関略称漢字"));
        AtenaKanaMeisho 医療機関略称カナ = new AtenaKanaMeisho(new RString("医療機関略称カナ"));
        IName 医療機関略称 = new _Name(医療機関略称漢字, 医療機関略称カナ);
        Range<FlexibleDate> 開設期間 = new Range<>(new FlexibleDate("20140301"), new FlexibleDate("20140331"));
        IDoctor 所属医師Ａ = new _Doctor(new RString("医師識別番号"), 医師氏名, iryoKikanCode,
                所属診療科, 医師区分);
        List<IDoctor> 所属医師リスト = new ArrayList<>();
        所属医師リスト.add(所属医師Ａ);
        IDoctors 所属医師 = new _Doctors(所属医師リスト);
        List<IKoza> 口座 = new ArrayList<>();
        IIryoKikan iryoKikan = new _IryoKikan(iryoKikanCode, shikibetsuCode,
                医療機関名称, 医療機関略称, new RString("所在地郵便番号"),
                new RString("所在地住所"), new RString("所在地カナ住所"),
                開設期間, 所属医師, 口座, new FlexibleDate("20140301"),
                new RString("休止区分"), new RString("異動自由"),
                new RString("会員区分"), true);
        KaigoIryoKikanCode 介護医療機関コード = new KaigoIryoKikanCode(new RString("0000000001"));
        IShujiiIryoKikan 主治医医療機関 = new ShujiiIryoKikan(new ShichosonCode(new RString("20205")),
                介護医療機関コード, iryoKikanCode, IryoKikanJokyo.有効,
                new IryoKikanKubun(new RString("医療機関区分コード"), RString.EMPTY, RString.EMPTY));
        KaigoIryoKikan 介護医療機関 = new KaigoIryoKikan(iryoKikan, 主治医医療機関);
        KaigoDoctorCode 介護医師 = new KaigoDoctorCode(new RString("0000000001"));
        IShujii 主治医 = new Shujii(new ShichosonCode(new RString("20205")), 介護医療機関コード,
                介護医師, iryoKikanCode, new RString("0000000001"), IshiJokyo.有効,
                new YubinNo(new RString("3010000")), new AtenaJusho(new RString("住所")),
                new TelNo(new RString("3010000")), new RString("0262340000"));

        return new ShujiiIkenshoSakuseiIrai(
                //                flg == AS_申請書管理番号がNULL ? null : mock(ShinseishoKanriNo.class),
                //                flg == AS_意見書作成依頼履歴番号がNULL ? null : mock(IkenshosakuseiIraiRirekiNo.class),
                //                flg == AS_介護医師がNULL ? null : mock(KaigoDoctor.class),
                //                flg == AS_意見書作成依頼区分がNULL ? null : IkenshoIraiKubun.初回依頼, 0,
                //                flg == AS_医師区分がNULL ? null : IshiKubun.主治医,
                //                flg == AS_意見書作成依頼済 ? FlexibleDate.MAX : FlexibleDate.MIN,
                //                FlexibleDate.MAX,
                //                flg == AS_意見書出力済 ? FlexibleDate.MAX : FlexibleDate.MIN,
                //                flg == AS_請求書出力済 ? FlexibleDate.MAX : FlexibleDate.MIN,
                //                SakuseiryoSeikyuKubun.施設新規,
                //                flg == AS_督促情報がNULL ? null
                //                : flg == AS_督促情報内項目がNULL ? new ShujiiIkenshoSakuseiTokusoku(null, null, 0, null)
                //                : new ShujiiIkenshoSakuseiTokusoku(FlexibleDate.MAX, IkenshoSakuseiTokusokuHoho.督促状郵送, 1, RString.EMPTY));
                flg == AS_申請書管理番号がNULL ? null : new ShinseishoKanriNo(new RString("0000000000")),
                flg == AS_意見書作成依頼履歴番号がNULL ? null : new IkenshosakuseiIraiRirekiNo(0000000),
                flg == AS_介護医師がNULL ? null : new KaigoDoctor(医師, 主治医, 介護医療機関),
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
