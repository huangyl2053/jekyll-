/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.Kiwarigaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KibetsuChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.config.FuchoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.business.config.KanendoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.TokuchoConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 期割額Divの操作を行うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
@Ignore
public class KiwarigakuHandlerTest extends DbbTestBase {

    private static KiwarigakuDiv result;

    private static final ChoteiNendo 調定年度 = new ChoteiNendo("2014");
    private static final FukaNendo 賦課年度 = new FukaNendo("2014");
    private static final FlexibleYear 納期統一年度 = new FlexibleYear("2000");
    private static final TsuchishoNo 通知書番号 = new TsuchishoNo("00000000000000000001");
    private static final RDateTime 処理日時 = RDateTime.MAX;

    @Ignore
    public static class load_期割額 {

        @Before
        public void setup() {
            result = createNewDiv();
            new KiwarigakuHandler(result,
                    create賦課計算Config(), create日付Config(), create普徴Config(), create特徴Config(), create過年度Config())
                    .load(調定年度, 賦課年度, 通知書番号, 処理日時);
        }

        @Test
        public void 特別徴収_期別額のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getLblTokuKibetsuGaku1().getText(), is(new RString("1,001")));
            assertThat(result.getLblTokuKibetsuGaku12().getText(), is(RString.EMPTY));
            assertThat(result.getLblTokuKibetsuGaku13().getText(), is(RString.EMPTY));
            assertThat(result.getLblTokuKibetsuGaku14().getText(), is(RString.EMPTY));
        }

        @Test
        public void 特別徴収_納付額のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getLblTokuNofuGaku1().getText(), is(new RString("1,002")));
            assertThat(result.getLblTokuNofuGaku12().getText(), is(RString.EMPTY));
            assertThat(result.getLblTokuNofuGaku13().getText(), is(RString.EMPTY));
            assertThat(result.getLblTokuNofuGaku14().getText(), is(RString.EMPTY));
        }

        @Test
        public void 普通徴収_期別額のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getLblFuchoKibetsuGaku1().getText(), is(new RString("1,003")));
            assertThat(result.getLblFuchoKibetsuGaku12().getText(), is(new RString("12,003")));
            assertThat(result.getLblFuchoKibetsuGaku13().getText(), is(new RString("13,003")));
            assertThat(result.getLblFuchoKibetsuGaku14().getText(), is(new RString("14,003")));
        }

        @Test
        public void 普通徴収_納付額のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getLblFuchoNofuGaku1().getText(), is(new RString("1,004")));
            assertThat(result.getLblFuchoNofuGaku12().getText(), is(new RString("12,004")));
            assertThat(result.getLblFuchoNofuGaku13().getText(), is(new RString("13,004")));
            assertThat(result.getLblFuchoNofuGaku14().getText(), is(new RString("14,004")));
        }

        @Test
        public void 特別徴収_期別額_合計のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getLblTokuKibetsuGakuGokei().getText(), is(new RString("21,006")));
        }

        @Test
        public void 特別徴収_納付額_合計のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getLblTokuNofuGakuGokei().getText(), is(new RString("21,012")));
        }

        @Test
        public void 普通徴収_期別額_合計のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getLblFuchoKibetsuGakuGokei().getText(), is(new RString("105,042")));
        }

        @Test
        public void 普通徴収_納付額_合計のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getLblFuchoNofuGakuGokei().getText(), is(new RString("105,056")));
        }
    }

    public static class load_納期統一年度 {

        @Test
        public void 納期統一年度の時_loadは_月列を表示する() {
            result = createNewDiv();
            new KiwarigakuHandler(result,
                    create賦課計算Config(), create日付Config(), create普徴Config(), create特徴Config(), create過年度Config())
                    .load(new ChoteiNendo(納期統一年度), new FukaNendo(納期統一年度), 通知書番号, 処理日時);

            assertThat(result.getTblTsuki1().isVisible(), is(true));
            assertThat(result.getTblTsuki1().isDisplayNone(), is(false));
            assertThat(result.getTblTsuki2().isVisible(), is(true));
            assertThat(result.getTblTsuki2().isDisplayNone(), is(false));
            assertThat(result.getTblTsuki3().isVisible(), is(true));
            assertThat(result.getTblTsuki3().isDisplayNone(), is(false));
            assertThat(result.getTblTsuki4().isVisible(), is(true));
            assertThat(result.getTblTsuki4().isDisplayNone(), is(false));
            assertThat(result.getLblTokuchoKiGokei().isVisible(), is(false));
        }

        @Test
        public void 納期統一年度より後の時_loadは_月列を表示する() {
            result = createNewDiv();
            new KiwarigakuHandler(result,
                    create賦課計算Config(), create日付Config(), create普徴Config(), create特徴Config(), create過年度Config())
                    .load(new ChoteiNendo(納期統一年度.plusYear(1)), new FukaNendo(納期統一年度.plusYear(1)), 通知書番号, 処理日時);

            assertThat(result.getTblTsuki1().isVisible(), is(true));
            assertThat(result.getTblTsuki1().isDisplayNone(), is(false));
            assertThat(result.getTblTsuki2().isVisible(), is(true));
            assertThat(result.getTblTsuki2().isDisplayNone(), is(false));
            assertThat(result.getTblTsuki3().isVisible(), is(true));
            assertThat(result.getTblTsuki3().isDisplayNone(), is(false));
            assertThat(result.getTblTsuki4().isVisible(), is(true));
            assertThat(result.getTblTsuki4().isDisplayNone(), is(false));
            assertThat(result.getLblTokuchoKiGokei().isVisible(), is(false));
        }

        @Test
        public void 納期統一年度より前の時_loadは_月列を表示しない() {
            result = createNewDiv();
            new KiwarigakuHandler(result,
                    create賦課計算Config(), create日付Config(), create普徴Config(), create特徴Config(), create過年度Config())
                    .load(new ChoteiNendo(納期統一年度.minusYear(1)), new FukaNendo(納期統一年度.minusYear(1)), 通知書番号, 処理日時);

            assertThat(result.getTblTsuki1().isVisible(), is(false));
            assertThat(result.getTblTsuki1().isDisplayNone(), is(true));
            assertThat(result.getTblTsuki2().isVisible(), is(false));
            assertThat(result.getTblTsuki2().isDisplayNone(), is(true));
            assertThat(result.getTblTsuki3().isVisible(), is(false));
            assertThat(result.getTblTsuki3().isDisplayNone(), is(true));
            assertThat(result.getTblTsuki4().isVisible(), is(false));
            assertThat(result.getTblTsuki4().isDisplayNone(), is(true));
            assertThat(result.getLblTokuchoKiGokei().isVisible(), is(true));
        }
    }

    public static class load_過年度 {

        @Test
        public void 調定年度と賦課年度が同じ時_loadは_普徴期情報を参照する() {
            result = createNewDiv();
            new KiwarigakuHandler(result,
                    create賦課計算Config(), create日付Config(), create普徴Config(), create特徴Config(), create過年度Config())
                    .load(調定年度, 賦課年度, 通知書番号, 処理日時);

            assertThat(result.getTblTsuki2().isVisible(), is(true));
            assertThat(result.getTblTsuki2().isDisplayNone(), is(false));
            assertThat(result.getTblTsuki3().isVisible(), is(true));
            assertThat(result.getTblTsuki3().isDisplayNone(), is(false));
//            assertThat(result.getTblKiwariGaku2().isVisible(), is(true));
            assertThat(result.getTblKiwariGaku2().isDisplayNone(), is(false));
            assertThat(result.getTblKiwariGaku3().isVisible(), is(true));
            assertThat(result.getTblKiwariGaku3().isDisplayNone(), is(false));
        }

        @Test
        public void 調定年度と賦課年度が異なる時_loadは_過年度期情報を参照する() {
            result = createNewDiv();
            new KiwarigakuHandler(result,
                    create賦課計算Config(), create日付Config(), create普徴Config(), create特徴Config(), create過年度Config())
                    .load(調定年度, new FukaNendo(賦課年度.value().plusYear(1)), 通知書番号, 処理日時);

            assertThat(result.getTblTsuki2().isVisible(), is(false));
            assertThat(result.getTblTsuki2().isDisplayNone(), is(true));
            assertThat(result.getTblTsuki3().isVisible(), is(false));
            assertThat(result.getTblTsuki3().isDisplayNone(), is(true));
            assertThat(result.getTblKiwariGaku2().isVisible(), is(false));
            assertThat(result.getTblKiwariGaku2().isDisplayNone(), is(true));
            assertThat(result.getTblKiwariGaku3().isVisible(), is(false));
            assertThat(result.getTblKiwariGaku3().isDisplayNone(), is(true));
        }
    }

    private static KiwarigakuDiv createNewDiv() {

        KiwarigakuDiv mock = mock(KiwarigakuDiv.class);

        when(mock.getTblTsuki1()).thenReturn(new tblTsuki1Div());
        when(mock.getTblTsuki2()).thenReturn(new tblTsuki2Div());
        when(mock.getTblTsuki3()).thenReturn(new tblTsuki3Div());
        when(mock.getTblTsuki4()).thenReturn(new tblTsuki4Div());

        when(mock.getTblKiwariGaku1()).thenReturn(new tblKiwariGaku1Div());
        when(mock.getTblKiwariGaku2()).thenReturn(new tblKiwariGaku2Div());
        when(mock.getTblKiwariGaku3()).thenReturn(new tblKiwariGaku3Div());
        when(mock.getTblKiwariGaku4()).thenReturn(new tblKiwariGaku4Div());

        when(mock.getLblTsuki1()).thenReturn(new Label());
        when(mock.getLblTsuki2()).thenReturn(new Label());
        when(mock.getLblTsuki3()).thenReturn(new Label());
        when(mock.getLblTsuki4()).thenReturn(new Label());
        when(mock.getLblTsuki5()).thenReturn(new Label());
        when(mock.getLblTsuki6()).thenReturn(new Label());
        when(mock.getLblTsuki7()).thenReturn(new Label());
        when(mock.getLblTsuki8()).thenReturn(new Label());
        when(mock.getLblTsuki9()).thenReturn(new Label());
        when(mock.getLblTsuki10()).thenReturn(new Label());
        when(mock.getLblTsuki11()).thenReturn(new Label());
        when(mock.getLblTsuki12()).thenReturn(new Label());
        when(mock.getLblTsuki13()).thenReturn(new Label());
        when(mock.getLblTsuki14()).thenReturn(new Label());
        when(mock.getLblTsukiGokei()).thenReturn(new Label());

        when(mock.getLblTokuchoKi1()).thenReturn(new Label());
        when(mock.getLblTokuchoKi2()).thenReturn(new Label());
        when(mock.getLblTokuchoKi3()).thenReturn(new Label());
        when(mock.getLblTokuchoKi4()).thenReturn(new Label());
        when(mock.getLblTokuchoKi5()).thenReturn(new Label());
        when(mock.getLblTokuchoKi6()).thenReturn(new Label());
        when(mock.getLblTokuchoKi7()).thenReturn(new Label());
        when(mock.getLblTokuchoKi8()).thenReturn(new Label());
        when(mock.getLblTokuchoKi9()).thenReturn(new Label());
        when(mock.getLblTokuchoKi10()).thenReturn(new Label());
        when(mock.getLblTokuchoKi11()).thenReturn(new Label());
        when(mock.getLblTokuchoKi12()).thenReturn(new Label());
        when(mock.getLblTokuchoKi13()).thenReturn(new Label());
        when(mock.getLblTokuchoKi14()).thenReturn(new Label());
        when(mock.getLblTokuchoKiGokei()).thenReturn(new Label());

        when(mock.getLblTokuKibetsuGaku1()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku2()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku3()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku4()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku5()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku6()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku7()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku8()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku9()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku10()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku11()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku12()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku13()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGaku14()).thenReturn(new Label());
        when(mock.getLblTokuKibetsuGakuGokei()).thenReturn(new Label());

        when(mock.getLblTokuNofuGaku1()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku2()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku3()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku4()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku5()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku6()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku7()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku8()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku9()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku10()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku11()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku12()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku13()).thenReturn(new Label());
        when(mock.getLblTokuNofuGaku14()).thenReturn(new Label());
        when(mock.getLblTokuNofuGakuGokei()).thenReturn(new Label());

        when(mock.getLblFuchoKi1()).thenReturn(new Label());
        when(mock.getLblFuchoKi2()).thenReturn(new Label());
        when(mock.getLblFuchoKi3()).thenReturn(new Label());
        when(mock.getLblFuchoKi4()).thenReturn(new Label());
        when(mock.getLblFuchoKi5()).thenReturn(new Label());
        when(mock.getLblFuchoKi6()).thenReturn(new Label());
        when(mock.getLblFuchoKi7()).thenReturn(new Label());
        when(mock.getLblFuchoKi8()).thenReturn(new Label());
        when(mock.getLblFuchoKi9()).thenReturn(new Label());
        when(mock.getLblFuchoKi10()).thenReturn(new Label());
        when(mock.getLblFuchoKi11()).thenReturn(new Label());
        when(mock.getLblFuchoKi12()).thenReturn(new Label());
        when(mock.getLblFuchoKi13()).thenReturn(new Label());
        when(mock.getLblFuchoKi14()).thenReturn(new Label());
        when(mock.getLblFuchoKiGokei()).thenReturn(new Label());

        when(mock.getLblFuchoKibetsuGaku1()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku2()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku3()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku4()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku5()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku6()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku7()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku8()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku9()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku10()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku11()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku12()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku13()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGaku14()).thenReturn(new Label());
        when(mock.getLblFuchoKibetsuGakuGokei()).thenReturn(new Label());

        when(mock.getLblFuchoNofuGaku1()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku2()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku3()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku4()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku5()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku6()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku7()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku8()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku9()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku10()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku11()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku12()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku13()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGaku14()).thenReturn(new Label());
        when(mock.getLblFuchoNofuGakuGokei()).thenReturn(new Label());

        return mock;
    }

//    private static KiwarigakuFinder createFinder() {
//        KiwarigakuFinder mock = mock(KiwarigakuFinder.class);
//        Optional<Kiwarigaku> 期割額 = Optional.ofNullable(new KiwarigakuCalculator(create期割額List().toList()).calculate());
//        when(mock.load期割額(any(ChoteiNendo.class), any(FukaNendo.class), any(TsuchishoNo.class), any(RDateTime.class))).thenReturn(期割額);
//        return mock;
//    }
//
    private static IItemList<KiwarigakuMeisai> create期割額List() {
        List<KiwarigakuMeisai> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            int 金額 = (i * 1000);
            list.add(create期割額(ChoshuHohoKibetsu.特別徴収, i, 金額 + 1, 金額 + 2));
        }
        for (int i = 1; i <= 14; i++) {
            int 金額 = (i * 1000);
            list.add(create期割額(ChoshuHohoKibetsu.普通徴収, i, 金額 + 3, 金額 + 4));
        }
        return ItemList.of(list);
    }

    private static KiwarigakuMeisai create期割額(ChoshuHohoKibetsu 徴収方法, int 期, int 期別額, int 納付額) {
        return new KiwarigakuMeisai(create期別調定共通Model(徴収方法, 期, 期別額), new Decimal(納付額));
    }

    private static KibetsuChoteiKyotsu create期別調定共通Model(ChoshuHohoKibetsu 徴収方法, int 期, int 期別額) {
//        KibetsuChoteiKyotsu model = KibetsuChoteiKyotsuModelTestHelper.createModel();
        KibetsuChoteiKyotsu model = new KibetsuChoteiKyotsu();
        //TODO n8300姜　ビルドエラー回避のために暫定対応
//        model.get介護期別モデル().set徴収方法(徴収方法);
//        model.get介護期別モデル().set期(期);
//        model.get調定共通モデル().set調定額(new Decimal(期別額));
        return model;
    }

    private static FukaKeisanConfig create賦課計算Config() {
        FukaKeisanConfig mock = mock(FukaKeisanConfig.class);
        when(mock.get不均一納期期限()).thenReturn(納期統一年度.toDateString());
        return mock;
    }

    private static HizukeConfig create日付Config() {
        HizukeConfig mock = mock(HizukeConfig.class);
        List<RString> list = new ArrayList<>();
        list.add(new RString("04"));
        list.add(new RString("05"));
        list.add(new RString("06"));
        list.add(new RString("07"));
        list.add(new RString("08"));
        list.add(new RString("09"));
        list.add(new RString("10"));
        list.add(new RString("11"));
        list.add(new RString("12"));
        list.add(new RString("01"));
        list.add(new RString("02"));
        list.add(new RString("03"));
        list.add(new RString("14"));
        list.add(new RString("15"));
        when(mock.get月別テーブル()).thenReturn(list);
        return mock;
    }

    private static FuchoConfig create普徴Config() {
        FuchoConfig mock = mock(FuchoConfig.class);
        List<RString> list = new ArrayList<>();
        list.add(new RString("01"));
        list.add(new RString("02"));
        list.add(new RString("03"));
        list.add(new RString("04"));
        list.add(new RString("05"));
        list.add(new RString("06"));
        list.add(new RString("07"));
        list.add(new RString("08"));
        list.add(new RString("09"));
        list.add(new RString("10"));
        list.add(new RString("11"));
        list.add(new RString("12"));
        list.add(new RString("13"));
        list.add(new RString("14"));
        when(mock.get月の期()).thenReturn(list);
        return mock;
    }

    private static TokuchoConfig create特徴Config() {
        TokuchoConfig mock = mock(TokuchoConfig.class);
        List<RString> list = new ArrayList<>();
        list.add(new RString("01"));
        list.add(new RString("01"));
        list.add(new RString("02"));
        list.add(new RString("02"));
        list.add(new RString("03"));
        list.add(new RString("03"));
        list.add(new RString("04"));
        list.add(new RString("04"));
        list.add(new RString("05"));
        list.add(new RString("05"));
        list.add(new RString("06"));
        list.add(new RString("06"));
        when(mock.get月の期()).thenReturn(list);
        return mock;
    }

    private static KanendoConfig create過年度Config() {
        KanendoConfig mock = mock(KanendoConfig.class);
        List<RString> list = new ArrayList<>();
        list.add(new RString("01"));
        list.add(new RString("02"));
        list.add(new RString("03"));
        list.add(new RString("04"));
        list.add(new RString("05"));
        list.add(new RString("06"));
        list.add(new RString("07"));
        list.add(new RString("08"));
        list.add(new RString("09"));
        list.add(new RString("10"));
        list.add(new RString("11"));
        list.add(new RString("12"));
        when(mock.get月の期()).thenReturn(list);
        return mock;
    }
}
