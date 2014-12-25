/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.business.HokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.Kiwarigaku;
import jp.co.ndensan.reams.db.dbz.business.KiwarigakuCalculator;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.fukarirekiall.dgFukaRirekiAll_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.fukarirekiall.FukaRirekiAllDiv;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.ChoteiKyotsuModel;
import jp.co.ndensan.reams.db.dbz.model.FukaModel;
import jp.co.ndensan.reams.db.dbz.model.HokenryoDankaiModel;
import jp.co.ndensan.reams.db.dbz.model.KibetsuModel;
import jp.co.ndensan.reams.db.dbz.model.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbz.model.relate.KibetsuChoteiKyotsuModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.realservice.FukaShokaiFinder;
import jp.co.ndensan.reams.db.dbz.realservice.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbz.realservice.KiwarigakuFinder;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 全賦課履歴Divの操作を行うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class FukaRirekiAllHandlerTest extends DbzTestBase {

    private static FukaRirekiAllHandler sut;
    private static FukaRirekiAllDiv result;

    private static final FlexibleYear 激変緩和開始年度 = new FlexibleYear("2006");
    private static final FlexibleYear 激変緩和終了年度 = new FlexibleYear("2007");
    private static final FlexibleYear 賦課年度1 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
    private static final FlexibleYear 賦課年度2 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度.plusYear(1);
    private static final FlexibleYear 調定年度1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
    private static final FlexibleYear 調定年度2 = DbT2002FukaEntityGenerator.DEFAULT_調定年度.plusYear(1);
    private static final TsuchishoNo 通知書番号1 = DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
    private static final TsuchishoNo 通知書番号2 = new TsuchishoNo("0000000010");

    @BeforeClass
    public static void test() {
        result = createNewDiv();
        sut = new FukaRirekiAllHandler(result, createFukaFinder(), createDankaiManager(), createKiwariFinder());
    }

    public static class load_被保険者番号 {

        @Test
        public void 全賦課履歴のデータがある時_loadは_データをDivに設定する() {
            int count = sut.load(HihokenshaNo.EMPTY);
            assertThat(count, is(2));
            assertThat(result.getDgFukaRirekiAll().getDataSource().get(0).getFukaNendo(), is(賦課年度2.toDateString()));
        }
    }

    public static class load_被保険者番号_賦課年度 {

        @Test
        public void 全賦課履歴のデータがある時_loadは_データをDivに設定する() {
            int count = sut.load(HihokenshaNo.EMPTY, FlexibleYear.EMPTY);
            assertThat(count, is(2));
            assertThat(result.getDgFukaRirekiAll().getDataSource().get(0).getFukaNendo(), is(賦課年度2.toDateString()));
        }
    }

    public static class reload {

        @Test
        public void 全賦課履歴のデータがある時_reloadは_データをDivに設定し_指定行を選択状態にする() {
            int count = sut.reload(HihokenshaNo.EMPTY, 賦課年度1, 調定年度1, 通知書番号1);
            assertThat(count, is(2));
            assertThat(result.getDgFukaRirekiAll().getDataSource().get(0).getFukaNendo(), is(賦課年度2.toDateString()));
            assertThat(result.getDgFukaRirekiAll().getSelectedItems().get(0).getFukaNendo(), is(賦課年度1.toDateString()));
        }
    }

    public static class get賦課履歴 {

        @Test
        public void 行が選択されていない時_get賦課履歴は_全賦課履歴を返す() {
            sut.load(HihokenshaNo.EMPTY);
            assertThat(sut.get賦課履歴().get賦課履歴All().size(), is(2));
            assertThat(sut.get賦課履歴().get賦課履歴All().toList().get(0).get賦課年度(), is(賦課年度2));
        }

        @Test
        public void 行が選択されている時_get賦課履歴は_選択行の賦課履歴を返す() {
            sut.reload(HihokenshaNo.EMPTY, 賦課年度1, 調定年度1, 通知書番号1);
            assertThat(sut.get賦課履歴().get賦課履歴All().size(), is(1));
            assertThat(sut.get賦課履歴().get賦課履歴All().toList().get(0).get賦課年度(), is(賦課年度1));
        }
    }

    private static FukaRirekiAllDiv createNewDiv() {
        FukaRirekiAllDiv div = new FukaRirekiAllDiv();
        div.setDgFukaRirekiAll(new DataGrid<dgFukaRirekiAll_Row>());
        return div;
    }

    private static FukaShokaiFinder createFukaFinder() {
        FukaShokaiFinder mock = mock(FukaShokaiFinder.class);
        IItemList<FukaModel> modelList = createFukaModelList();
        when(mock.load全賦課履歴(any(HihokenshaNo.class))).thenReturn(modelList);
        when(mock.load全賦課履歴(any(HihokenshaNo.class), any(FlexibleYear.class))).thenReturn(modelList);
        return mock;
    }

    private static HokenryoDankaiManager createDankaiManager() {
        HokenryoDankaiManager mock = mock(HokenryoDankaiManager.class);
        IOptional<HokenryoDankai> model = createHokenryoDankai();
        when(mock.get保険料段階(any(FlexibleYear.class), any(LasdecCode.class), any(RString.class))).thenReturn(model);
        return mock;
    }

    private static KiwarigakuFinder createKiwariFinder() {
        KiwarigakuFinder mock = mock(KiwarigakuFinder.class);
        IOptional<Kiwarigaku> model = createKiwarigaku();
        when(mock.get期割額(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class), any(RDateTime.class))).thenReturn(model);
        return mock;
    }

    private static IItemList<FukaModel> createFukaModelList() {
        List<FukaModel> modelList = new ArrayList<>();
        modelList.add(createFukaModel(賦課年度1, 調定年度1, 通知書番号1));
        modelList.add(createFukaModel(賦課年度2, 調定年度2, 通知書番号2));
        return ItemList.of(modelList);
    }

    private static FukaModel createFukaModel(FlexibleYear 賦課年度, FlexibleYear 調定年度, TsuchishoNo 通知書番号) {
        DbT2002FukaEntity entity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
        entity.setFukaNendo(賦課年度);
        entity.setChoteiNendo(調定年度);
        entity.setTsuchishoNo(通知書番号);
        return new FukaModel(entity);
    }

    private static IOptional<HokenryoDankai> createHokenryoDankai() {
        DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
        return DbOptional.ofNullable(new HokenryoDankai(new HokenryoDankaiModel(entity), createFukaKeisanConfig()));
    }

    private static IOptional<Kiwarigaku> createKiwarigaku() {
        return DbOptional.ofNullable(new KiwarigakuCalculator(createKiwarigakuModelList()).calculate());
    }

    private static List<KiwarigakuMeisai> createKiwarigakuModelList() {
        List<KiwarigakuMeisai> list = new ArrayList<>();
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.特別徴収, 100, 1000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.特別徴収, 200, 2000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.特別徴収, 300, 3000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.普通徴収, 400, 4000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.普通徴収, 500, 5000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.普通徴収, 600, 6000));
        return list;
    }

    private static KiwarigakuMeisai createKiwarigakuModel(ChoshuHohoKibetsu 徴収方法, int 調定額, int 収入額) {
        KibetsuModel kibetsuModel = mock(KibetsuModel.class);
        when(kibetsuModel.get徴収方法()).thenReturn(徴収方法.getCode());

        ChoteiKyotsuModel choteiKyotsuModel = mock(ChoteiKyotsuModel.class);
        when(choteiKyotsuModel.get調定額()).thenReturn(new Decimal(調定額));

        KibetsuChoteiKyotsuModel kibetsuChoteiKyotsuModel = mock(KibetsuChoteiKyotsuModel.class);
        when(kibetsuChoteiKyotsuModel.get介護期別モデル()).thenReturn(kibetsuModel);
        when(kibetsuChoteiKyotsuModel.get調定共通モデル()).thenReturn(choteiKyotsuModel);

        KiwarigakuMeisai kiwarigakuModel = mock(KiwarigakuMeisai.class);
        when(kiwarigakuModel.get期別調定共通()).thenReturn(kibetsuChoteiKyotsuModel);
        when(kiwarigakuModel.get収入額()).thenReturn(new Decimal(収入額));

        return kiwarigakuModel;
    }

    private static FukaKeisanConfig createFukaKeisanConfig() {
        FukaKeisanConfig config = mock(FukaKeisanConfig.class);
        when(config.get激変緩和開始年度()).thenReturn(激変緩和開始年度);
        when(config.get激変緩和終了年度()).thenReturn(激変緩和終了年度);
        when(config.get激変緩和期間()).thenReturn(new Range(激変緩和開始年度, 激変緩和終了年度));
        return config;
    }
}
