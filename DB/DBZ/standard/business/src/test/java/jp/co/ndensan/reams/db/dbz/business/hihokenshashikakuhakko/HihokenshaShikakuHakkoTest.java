/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.IKaigoService;
import jp.co.ndensan.reams.ur.urz.business.IKaigoServiceShurui;
import jp.co.ndensan.reams.ur.urz.business._KaigoServiceShurui;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * HihokenshaShikakuHakkoのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class HihokenshaShikakuHakkoTest extends DbzTestBase {

    private static HihokenshaShikakuHakko sut;
    private static final RString SHIKAKUSHAHO_YUKOKIGEN_1 = new RString("1");
    private static final RString SHIKAKUSHAHO_YUKOKIGEN_2 = new RString("2");
    private static final RString SHIKAKUSHAHO_YUKOKIGEN_3 = new RString("3");
    private static final Code SHINSEIKUBUN_SHINKI = new Code(new RString("1"));
    private static final Code SHINSEIKUBUN_KOSHIN = new Code(new RString("2"));
    private static final Code SHINSEIKUBUN_KUBUNHENKO = new Code(new RString("3"));
    private static final Code SHINSEIKUBUN_SHOKKEN = new Code(new RString("4"));
    private static final Code SHINSEIKUBUN_TENNYU = new Code(new RString("5"));
    private static final Code SHINSEIKUBUN_SHOSHITSU = new Code(new RString("6"));
    private static FlexibleDate 申請日;
    private static FlexibleDate 有効データ認定終了日;
    private static FlexibleDate 期待結果日;
    private static RString 計画事業者名称;
    private static RString 委託先事業者名称;
    private static RString 支援事業者名称;

    public static class get有効期限初期値Test {

        /**
         * 業務コンフィグDBD：資格者証期限_有効期限初期表示が3(更新・区分申請時、従前認定終値比較) <br />
         * 申請区分コード = 1(新規) <br />
         * のとき、有効期限は申請日＋資格者証期限_有効期限加算値(初期値30)を返す。
         */
        @Test
        public void 資格者証期限_有効期限初期表示が更新区分申請時_従前認定終値比較で_申請区分コードが新規のとき_有効期限は申請日と資格者証期限_有効期限加算値を足した日付を返す() {
            申請日 = new FlexibleDate("20000101");
            有効データ認定終了日 = new FlexibleDate("20010101");
            期待結果日 = 申請日.plusDay(30);

            FlexibleDate result = sut.get有効期限初期値(SHINSEIKUBUN_SHINKI, 申請日, 有効データ認定終了日);
            assertThat(result, is(期待結果日));
        }

        /**
         * 業務コンフィグDBD：資格者証期限_有効期限初期表示が3(更新・区分申請時、従前認定終値比較) <br />
         * 申請区分コード = 2(更新) or 3(区分変更) <br />
         * 申請日＋資格者証期限_有効期限加算値(初期値30) ＜ 有効データ認定終了日 <br />
         * のとき、有効期限は有効データ認定終了日を返す。
         */
        @Test
        public void 資格者証期限_有効期限初期表示が更新区分申請時_従前認定終値比較で_申請区分コードが更新のとき_有効期限は有効データ認定終了日を返す() {
            申請日 = new FlexibleDate("20000101");
            有効データ認定終了日 = new FlexibleDate("20010101");
            期待結果日 = 有効データ認定終了日;

            FlexibleDate result = sut.get有効期限初期値(SHINSEIKUBUN_KOSHIN, 申請日, 有効データ認定終了日);
            assertThat(result, is(期待結果日));
        }

        /**
         * 業務コンフィグDBD：資格者証期限_有効期限初期表示が3(更新・区分申請時、従前認定終値比較) <br />
         * 申請区分コード = 2(更新) or 3(区分変更) <br />
         * 申請日＋資格者証期限_有効期限加算値(初期値30) ＜ 有効データ認定終了日 <br />
         * のとき、有効期限は有効データ認定終了日を返す。
         */
        @Test
        public void 資格者証期限_有効期限初期表示が更新区分申請時_従前認定終値比較で_申請区分コードが区分変更のとき_有効期限は有効データ認定終了日を返す() {
            申請日 = new FlexibleDate("20000101");
            有効データ認定終了日 = new FlexibleDate("20010101");
            期待結果日 = 有効データ認定終了日;

            FlexibleDate result = sut.get有効期限初期値(SHINSEIKUBUN_KUBUNHENKO, 申請日, 有効データ認定終了日);
            assertThat(result, is(期待結果日));
        }

    }

    public static class compose被保険者証支援事業者名称Test {

        /**
         * 業務コンフィグDBA：被保険者証表示方法_委託代行業者_表示有無が0(非表示) <br />
         * のとき、支援事業者名称は計画事業者名称を返す。
         */
        @Test
        public void 被保険者証表示方法_委託代行業者_表示有無が非表示のとき_支援事業者名称は計画事業者名称を返す() {
            計画事業者名称 = new RString("計画事業者名称");
            委託先事業者名称 = new RString("委託先事業者名称");

            RString result = sut.compose被保険者証支援事業者名称(計画事業者名称, 委託先事業者名称);
            assertThat(result, is(計画事業者名称));
        }
    }

    public static class compose資格者証支援事業者名称Test {

        /**
         * 業務コンフィグDBD：資格者証表示方法_委託代行業者_表示有無が0(非表示) <br />
         * のとき、支援事業者名称は計画事業者名称を返す。
         */
        @Test
        public void 資格者証表示方法_委託代行業者の表示有無が非表示のとき_支援事業者名称は計画事業者名称を返す() {
            計画事業者名称 = new RString("計画事業者名称");
            委託先事業者名称 = new RString("委託先事業者名称");

            RString result = sut.compose資格者証支援事業者名称(計画事業者名称, 委託先事業者名称);
            assertThat(result, is(計画事業者名称));
        }

    }

    public static class compose審査会意見Test {

        RString 審査会意見50文字 = new RString("あいうえおあいうえおかきくけこかきくけこさしすせそさしすせそたちつてとたちつてとなにぬねのなにぬねの");
        RString 審査会意見 = 審査会意見50文字.concat(審査会意見50文字);

        /**
         * 編集された審査会意見が最大長を越えないとき、審査会意見とサービス名称の全文字列が返される。<br />
         */
        @Test
        public void 編集された審査会意見が最大長を越えないとき_審査会意見とサービス名称の全文字列が返される() {
            IItemList<IKaigoService> 介護サービスリスト = create介護サービスリスト();
            FlexibleDate 基準日 = FlexibleDate.getNowDate();
            int 最大長 = 200;
            int 文字列長 = 審査会意見.length() + (create介護サービスリスト().size() * createKaigoServiceShurui().getサービス種類名称().length());

            RString result = sut.compose審査会意見(審査会意見, 介護サービスリスト, 基準日, 最大長);
            assertThat(result.length(), is(文字列長));
        }

        /**
         * 編集された審査会意見が最大長を越えないとき、サービス名称は正式な名称を使用する。<br />
         */
        @Test
        public void 編集された審査会意見が最大長を越えないとき_サービス名称は正式な名称を使用する() {
            IItemList<IKaigoService> 介護サービスリスト = create介護サービスリスト();
            FlexibleDate 基準日 = FlexibleDate.getNowDate();
            int 最大長 = 200;

            RString result = sut.compose審査会意見(審査会意見, 介護サービスリスト, 基準日, 最大長);
            assertThat(result.substring(審査会意見.length(), 審査会意見.length() + createKaigoServiceShurui().getサービス種類名称().length()),
                    is(createKaigoServiceShurui().getサービス種類名称()));
        }

        /**
         * 編集された審査会意見が最大長を越えるとき、最大長に丸めた文字列が返される<br />
         */
        @Test
        public void 編集された審査会意見が最大長を越えるとき_最大長に丸めた文字列が返される() {
            IItemList<IKaigoService> 介護サービスリスト = create介護サービスリスト();
            FlexibleDate 基準日 = FlexibleDate.getNowDate();
            int 最大長 = 110;

            RString result = sut.compose審査会意見(審査会意見, 介護サービスリスト, 基準日, 最大長);
            assertThat(result.length(), is(最大長));
        }

        /**
         * 編集された審査会意見が最大長を越えるとき、サービス名称は略称を使用する。<br />
         */
        @Test
        public void 編集された審査会意見が最大長を越えるとき_サービス名称は略称を使用する() {
            IItemList<IKaigoService> 介護サービスリスト = create介護サービスリスト();
            FlexibleDate 基準日 = FlexibleDate.getNowDate();
            int 最大長 = 110;

            RString result = sut.compose審査会意見(審査会意見, 介護サービスリスト, 基準日, 最大長);
            assertThat(result.substring(審査会意見.length(), 審査会意見.length() + createKaigoServiceShurui().getサービス種類名称略称().length()),
                    is(createKaigoServiceShurui().getサービス種類名称略称()));
        }

        private IItemList<IKaigoService> create介護サービスリスト() {
            List<IKaigoService> list = new ArrayList<>();
            list.add(createKaigoService());
            list.add(createKaigoService());
            list.add(createKaigoService());
            list.add(createKaigoService());

            return ItemList.of(list);
        }

        private static IKaigoService createKaigoService() {
            IKaigoServiceShurui shurui = createKaigoServiceShurui();
            IKaigoService service = mock(IKaigoService.class);
            when(service.get介護サービス種類()).thenReturn(shurui);
            return service;
        }

        private static IKaigoServiceShurui createKaigoServiceShurui() {
            return spy(new _KaigoServiceShurui(
                    new RString("01"), new Range<>(FlexibleYearMonth.MIN, FlexibleYearMonth.MAX), new RString("サービス種類名称。"),
                    new RString("略称。"), new RString("サービス分類")));
        }

    }
}
