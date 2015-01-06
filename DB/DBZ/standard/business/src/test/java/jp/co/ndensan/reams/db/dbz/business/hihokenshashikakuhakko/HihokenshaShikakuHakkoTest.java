/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.config.HihokenshashoItakudaikoHyojiConfig;
import jp.co.ndensan.reams.db.dbz.business.config.ShikakushashoItakudaikoHyojiConfig;
import jp.co.ndensan.reams.db.dbz.business.config.ShikakushashoKigenConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHihokenshashoItakudaikoHyoji;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShikakushashoItakudaikoHyoji;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShikakushashoKigen;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.IKaigoService;
import jp.co.ndensan.reams.ur.urz.business.IKaigoServiceShurui;
import jp.co.ndensan.reams.ur.urz.business._KaigoServiceShurui;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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

    private static HihokenshaShikakuHakko sut = new HihokenshaShikakuHakko();
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
         * 業務コンフィグDBD：資格者証期限_有効期限初期表示が1(常にシステム日付+有効期限加算値) <br />
         * のとき、有効期限はシステム日付＋資格者証期限_有効期限加算値を返す。
         */
        @Test
        public void 有効期限初期表示が常にシステム日付足す有効期限加算値のとき_有効期限は申請日と有効期限加算値を足した日付を返す() {
            申請日 = FlexibleDate.getNowDate();
            有効データ認定終了日 = 申請日.plusDay(50);
            期待結果日 = 申請日.plusDay(30);

            sut = new HihokenshaShikakuHakko(new ShikakushashoKigenConfig(createBusinessConfig_資格者証期限_初期表示1Mock()),
                    mock(HihokenshashoItakudaikoHyojiConfig.class),
                    mock(ShikakushashoItakudaikoHyojiConfig.class));

            FlexibleDate result = sut.get有効期限初期値(SHINSEIKUBUN_SHINKI, 申請日, 有効データ認定終了日);
            assertThat(result, is(期待結果日));
        }

        /**
         * 業務コンフィグDBD：資格者証期限_有効期限初期表示が2(更新申請時、従前認定終値比較) <br />
         * 申請区分コード = 2(更新) <br />
         * 申請日＋資格者証期限_有効期限加算値 ＜ 有効データ認定終了日 <br />
         * のとき、有効期限は有効データ認定終了日を返す。
         */
        @Test
        public void 有効期限初期表示が更新申請時従前認定終値比較で_申請区分コードが更新で_有効データ認定終了日が申請日に有効期限加算値を加算したときよりも後のとき_有効期限は有効データ認定終了日を返す() {
            申請日 = new FlexibleDate("20000101");
            有効データ認定終了日 = 申請日.plusDay(50);
            期待結果日 = 有効データ認定終了日;

            sut = new HihokenshaShikakuHakko(new ShikakushashoKigenConfig(createBusinessConfig_資格者証期限_初期表示2Mock()),
                    mock(HihokenshashoItakudaikoHyojiConfig.class),
                    mock(ShikakushashoItakudaikoHyojiConfig.class));

            FlexibleDate result = sut.get有効期限初期値(SHINSEIKUBUN_KOSHIN, 申請日, 有効データ認定終了日);
            assertThat(result, is(期待結果日));
        }

        /**
         * 業務コンフィグDBD：資格者証期限_有効期限初期表示が2(更新申請時、従前認定終値比較) <br />
         * 申請区分コード = 2(更新) <br />
         * 申請日＋資格者証期限_有効期限加算値 ＞ 有効データ認定終了日 <br />
         * のとき、有効期限は申請日＋有効期限加算値を返す。
         */
        @Test
        public void 有効期限初期表示が更新申請時従前認定終値比較で_申請区分コードが更新で_有効データ認定終了日が申請日に有効期限加算値を加算したときよりも前のとき_有効期限は申請日と有効期限加算値を足した日付を返す() {
            申請日 = new FlexibleDate("20000101");
            有効データ認定終了日 = 申請日.plusDay(20);
            期待結果日 = 申請日.plusDay(30);

            sut = new HihokenshaShikakuHakko(new ShikakushashoKigenConfig(createBusinessConfig_資格者証期限_初期表示2Mock()),
                    mock(HihokenshashoItakudaikoHyojiConfig.class),
                    mock(ShikakushashoItakudaikoHyojiConfig.class));

            FlexibleDate result = sut.get有効期限初期値(SHINSEIKUBUN_KOSHIN, 申請日, 有効データ認定終了日);
            assertThat(result, is(期待結果日));
        }

        /**
         * 業務コンフィグDBD：資格者証期限_有効期限初期表示が3(更新・区分申請時、従前認定終値比較) <br />
         * 申請区分コード = 2(更新) <br />
         * 申請日＋資格者証期限_有効期限加算値 ＜ 有効データ認定終了日 <br />
         * のとき、有効期限は有効データ認定終了日を返す。
         */
        @Test
        public void 有効期限初期表示が更新区分申請時従前認定終値比較で_申請区分コードが更新で_有効データ認定終了日が申請日に有効期限加算値を加算したときよりも後のとき_有効期限は有効データ認定終了日を返す() {
            申請日 = new FlexibleDate("20000101");
            有効データ認定終了日 = 申請日.plusDay(50);
            期待結果日 = 有効データ認定終了日;

            sut = new HihokenshaShikakuHakko(new ShikakushashoKigenConfig(createBusinessConfig_資格者証期限_初期表示3Mock()),
                    mock(HihokenshashoItakudaikoHyojiConfig.class),
                    mock(ShikakushashoItakudaikoHyojiConfig.class));

            FlexibleDate result = sut.get有効期限初期値(SHINSEIKUBUN_KOSHIN, 申請日, 有効データ認定終了日);
            assertThat(result, is(期待結果日));
        }

        /**
         * 業務コンフィグDBD：資格者証期限_有効期限初期表示が3(更新・区分申請時、従前認定終値比較) <br />
         * 申請区分コード = 2(更新) <br />
         * 申請日＋資格者証期限_有効期限加算値 ＞ 有効データ認定終了日 <br />
         * のとき、有効期限は申請日＋有効期限加算値を返す。
         */
        @Test
        public void 有効期限初期表示が更新区分申請時従前認定終値比較で_申請区分コードが更新で_有効データ認定終了日が申請日に有効期限加算値を加算したときよりも前のとき_有効期限は申請日と有効期限加算値を足した日付を返す() {
            申請日 = new FlexibleDate("20000101");
            有効データ認定終了日 = 申請日.plusDay(20);
            期待結果日 = 申請日.plusDay(30);

            sut = new HihokenshaShikakuHakko(new ShikakushashoKigenConfig(createBusinessConfig_資格者証期限_初期表示3Mock()),
                    mock(HihokenshashoItakudaikoHyojiConfig.class),
                    mock(ShikakushashoItakudaikoHyojiConfig.class));

            FlexibleDate result = sut.get有効期限初期値(SHINSEIKUBUN_KOSHIN, 申請日, 有効データ認定終了日);
            assertThat(result, is(期待結果日));
        }

        /**
         * 業務コンフィグDBD：資格者証期限_有効期限初期表示が3(更新・区分申請時、従前認定終値比較) <br />
         * 申請区分コード = 3(区分変更) <br />
         * 申請日＋資格者証期限_有効期限加算値 ＜ 有効データ認定終了日 <br />
         * のとき、有効期限は有効データ認定終了日を返す。
         */
        @Test
        public void 有効期限初期表示が更新区分申請時従前認定終値比較で_申請区分コードが区分変更で_有効データ認定終了日が申請日に有効期限加算値を加算したときよりも後のとき_有効期限は有効データ認定終了日を返す() {
            申請日 = new FlexibleDate("20000101");
            有効データ認定終了日 = 申請日.plusDay(50);
            期待結果日 = 有効データ認定終了日;

            sut = new HihokenshaShikakuHakko(new ShikakushashoKigenConfig(createBusinessConfig_資格者証期限_初期表示3Mock()),
                    mock(HihokenshashoItakudaikoHyojiConfig.class),
                    mock(ShikakushashoItakudaikoHyojiConfig.class));

            FlexibleDate result = sut.get有効期限初期値(SHINSEIKUBUN_KUBUNHENKO, 申請日, 有効データ認定終了日);
            assertThat(result, is(期待結果日));
        }

        /**
         * 業務コンフィグDBD：資格者証期限_有効期限初期表示が3(更新・区分申請時、従前認定終値比較) <br />
         * 申請区分コード = 3(区分変更) <br />
         * 申請日＋資格者証期限_有効期限加算値 ＞ 有効データ認定終了日 <br />
         * のとき、有効期限は申請日＋有効期限加算値を返す。
         */
        @Test
        public void 有効期限初期表示が更新区分申請時従前認定終値比較で_申請区分コードが区分変更で_有効データ認定終了日が申請日に有効期限加算値を加算したときよりも前のとき_有効期限は申請日と有効期限加算値を足した日付を返す() {
            申請日 = new FlexibleDate("20000101");
            有効データ認定終了日 = 申請日.plusDay(50);
            期待結果日 = 有効データ認定終了日;

            sut = new HihokenshaShikakuHakko(new ShikakushashoKigenConfig(createBusinessConfig_資格者証期限_初期表示3Mock()),
                    mock(HihokenshashoItakudaikoHyojiConfig.class),
                    mock(ShikakushashoItakudaikoHyojiConfig.class));

            FlexibleDate result = sut.get有効期限初期値(SHINSEIKUBUN_KUBUNHENKO, 申請日, 有効データ認定終了日);
            assertThat(result, is(期待結果日));
        }

    }

    private static IUrBusinessConfig createBusinessConfig_資格者証期限_初期表示1Mock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysShikakushashoKigen.資格者証期限_有効期限加算値,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("30"));
        when(mock.get(
                ConfigKeysShikakushashoKigen.資格者証期限_有効期限初期表示,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("1"));
        return mock;
    }

    private static IUrBusinessConfig createBusinessConfig_資格者証期限_初期表示2Mock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysShikakushashoKigen.資格者証期限_有効期限加算値,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("30"));
        when(mock.get(
                ConfigKeysShikakushashoKigen.資格者証期限_有効期限初期表示,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("2"));
        return mock;
    }

    private static IUrBusinessConfig createBusinessConfig_資格者証期限_初期表示3Mock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysShikakushashoKigen.資格者証期限_有効期限加算値,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("30"));
        when(mock.get(
                ConfigKeysShikakushashoKigen.資格者証期限_有効期限初期表示,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("3"));
        return mock;
    }

    public static class compose被保険者証支援事業者名称Test {

        /**
         * 業務コンフィグDBA：被保険者証表示方法_委託代行業者_表示有無が0(非表示) <br />
         * のとき、支援事業者名称は計画事業者名称を返す。
         */
        @Test
        public void 被保険者証表示方法_委託代行業者_表示有無が非表示のとき_支援事業者名称は計画事業者名称を返す() {
            計画事業者名称 = new RString("被保険者証計画事業者名称");
            委託先事業者名称 = new RString("被保険者証委託先事業者名称");
            支援事業者名称 = 計画事業者名称;

            sut = new HihokenshaShikakuHakko(
                    mock(ShikakushashoKigenConfig.class),
                    new HihokenshashoItakudaikoHyojiConfig(createBusinessConfig_被保険者証表示方法_委託代行業者_非表示Mock()),
                    mock(ShikakushashoItakudaikoHyojiConfig.class));

            RString result = sut.compose被保険者証支援事業者名称(計画事業者名称, 委託先事業者名称);
            assertThat(result, is(支援事業者名称));
        }

        /**
         * 業務コンフィグDBA：被保険者証表示方法_委託代行業者_表示有無が1(表示) <br />
         * のとき、支援事業者名称は計画事業者名称と委託先事業者名称を編集した事業者名称を返す。
         */
        @Test
        public void 被保険者証表示方法_委託代行業者_表示有無が表示のとき_支援事業者名称は計画事業者名称と委託先事業者名称を編集した事業者名称を返す() {
            計画事業者名称 = new RString("被保険者証計画事業者名称");
            委託先事業者名称 = new RString("被保険者証委託先事業者名称");
            支援事業者名称 = new RStringBuilder(計画事業者名称).append(new RString("（委託先：")).append(委託先事業者名称).append(new RString("）")).toRString();

            sut = new HihokenshaShikakuHakko(
                    mock(ShikakushashoKigenConfig.class),
                    new HihokenshashoItakudaikoHyojiConfig(createBusinessConfig_被保険者証表示方法_委託代行業者_表示Mock()),
                    mock(ShikakushashoItakudaikoHyojiConfig.class));

            RString result = sut.compose被保険者証支援事業者名称(計画事業者名称, 委託先事業者名称);
            assertThat(result, is(支援事業者名称));
        }
    }

    private static IUrBusinessConfig createBusinessConfig_被保険者証表示方法_委託代行業者_非表示Mock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示有無,
                nowDate,
                SubGyomuCode.DBA介護資格
        )).thenReturn(new RString("0"));
        return mock;
    }

    private static IUrBusinessConfig createBusinessConfig_被保険者証表示方法_委託代行業者_表示Mock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示有無,
                nowDate,
                SubGyomuCode.DBA介護資格
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示開始文言,
                nowDate,
                SubGyomuCode.DBA介護資格
        )).thenReturn(new RString("（委託先："));
        when(mock.get(
                ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示終了文言,
                nowDate,
                SubGyomuCode.DBA介護資格
        )).thenReturn(new RString("）"));
        return mock;
    }

    public static class compose資格者証支援事業者名称Test {

        /**
         * 業務コンフィグDBD：資格者証表示方法_委託代行業者_表示有無が0(非表示) <br />
         * のとき、支援事業者名称は計画事業者名称を返す。
         */
        @Test
        public void 資格者証表示方法_委託代行業者の表示有無が非表示のとき_支援事業者名称は計画事業者名称を返す() {
            計画事業者名称 = new RString("資格者証計画事業者名称");
            委託先事業者名称 = new RString("資格者証委託先事業者名称");
            支援事業者名称 = 計画事業者名称;

            sut = new HihokenshaShikakuHakko(
                    mock(ShikakushashoKigenConfig.class),
                    mock(HihokenshashoItakudaikoHyojiConfig.class),
                    new ShikakushashoItakudaikoHyojiConfig(createBusinessConfig_資格者証表示方法_委託代行業者_非表示Mock()));

            RString result = sut.compose資格者証支援事業者名称(計画事業者名称, 委託先事業者名称);
            assertThat(result, is(計画事業者名称));
        }

        /**
         * 業務コンフィグDBD：資格者証表示方法_委託代行業者_表示有無が1(表示) <br />
         * のとき、支援事業者名称は計画事業者名称と委託先事業者名称を編集した事業者名称を返す。
         */
        @Test
        public void 資格者証表示方法_委託代行業者の表示有無が表示のとき_支援事業者名称は計画事業者名称と委託先事業者名称を編集した事業者名称を返す() {
            計画事業者名称 = new RString("資格者証計画事業者名称");
            委託先事業者名称 = new RString("資格者証委託先事業者名称");
            支援事業者名称 = new RStringBuilder(計画事業者名称).append(new RString("（委託先：")).append(委託先事業者名称).append(new RString("）")).toRString();

            sut = new HihokenshaShikakuHakko(
                    mock(ShikakushashoKigenConfig.class),
                    mock(HihokenshashoItakudaikoHyojiConfig.class),
                    new ShikakushashoItakudaikoHyojiConfig(createBusinessConfig_資格者証表示方法_委託代行業者_表示Mock()));

            RString result = sut.compose資格者証支援事業者名称(計画事業者名称, 委託先事業者名称);
            assertThat(result, is(支援事業者名称));
        }

    }

    private static IUrBusinessConfig createBusinessConfig_資格者証表示方法_委託代行業者_非表示Mock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者の表示有無,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("0"));
        return mock;
    }

    private static IUrBusinessConfig createBusinessConfig_資格者証表示方法_委託代行業者_表示Mock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者の表示有無,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者表示開始文言,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("（委託先："));
        when(mock.get(
                ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者表示終了文言,
                nowDate,
                SubGyomuCode.DBD介護受給
        )).thenReturn(new RString("）"));
        return mock;
    }

    public static class compose審査会意見Test {

        RString 審査会意見50文字 = new RString("あいうえおあいうえおかきくけこかきくけこさしすせそさしすせそたちつてとたちつてとなにぬねのなにぬねの");
        RString 審査会意見 = 審査会意見50文字.concat(審査会意見50文字);

        /**
         * 編集された審査会意見が最大長を越えないとき、審査会意見とサービス名称の全文字列が返される。<br />
         */
        @Test
        public void 介護サービスリストがないとき_審査会意見がそのまま返される() {
            IItemList<IKaigoService> 介護サービスリスト = ItemList.empty();
            int 最大長 = 200;

            RString result = sut.compose審査会意見(審査会意見, 介護サービスリスト, 最大長);
            assertThat(result, is(審査会意見));
        }

        /**
         * 編集された審査会意見が最大長を越えないとき、審査会意見とサービス名称の全文字列が返される。<br />
         */
        @Test
        public void 編集された審査会意見が最大長を越えないとき_審査会意見とサービス名称の全文字列が返される() {
            IItemList<IKaigoService> 介護サービスリスト = create介護サービスリスト();
            int 最大長 = 200;
            int 文字列長 = 審査会意見.length() + (create介護サービスリスト().size() * createKaigoServiceShurui().getサービス種類名称().length());

            RString result = sut.compose審査会意見(審査会意見, 介護サービスリスト, 最大長);
            assertThat(result.length(), is(文字列長));
        }

        /**
         * 編集された審査会意見が最大長を越えないとき、サービス名称は正式な名称を使用する。<br />
         */
        @Test
        public void 編集された審査会意見が最大長を越えないとき_サービス名称は正式な名称を使用する() {
            IItemList<IKaigoService> 介護サービスリスト = create介護サービスリスト();
            int 最大長 = 200;

            RString result = sut.compose審査会意見(審査会意見, 介護サービスリスト, 最大長);
            assertThat(result.substring(審査会意見.length(), 審査会意見.length() + createKaigoServiceShurui().getサービス種類名称().length()),
                    is(createKaigoServiceShurui().getサービス種類名称()));
        }

        /**
         * 編集された審査会意見が最大長を越えるとき、最大長に丸めた文字列が返される<br />
         */
        @Test
        public void 編集された審査会意見が最大長を越えるとき_最大長に丸めた文字列が返される() {
            IItemList<IKaigoService> 介護サービスリスト = create介護サービスリスト();
            int 最大長 = 110;

            RString result = sut.compose審査会意見(審査会意見, 介護サービスリスト, 最大長);
            assertThat(result.length(), is(最大長));
        }

        /**
         * 編集された審査会意見が最大長を越えるとき、サービス名称は略称を使用する。<br />
         */
        @Test
        public void 編集された審査会意見が最大長を越えるとき_サービス名称は略称を使用する() {
            IItemList<IKaigoService> 介護サービスリスト = create介護サービスリスト();
            int 最大長 = 110;

            RString result = sut.compose審査会意見(審査会意見, 介護サービスリスト, 最大長);
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
