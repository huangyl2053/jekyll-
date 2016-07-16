/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.fukarirekiall;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.Kiwarigaku;
import jp.co.ndensan.reams.db.dbb.business.core.KiwarigakuCalculator;
import jp.co.ndensan.reams.db.dbx.business.core.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbx.business.core.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KibetsuChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.FukaRirekiAllDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.FukaRirekiAllHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.dgFukaRirekiAll_Row;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbb.service.core.FukaMiscManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbb.service.core.relate.KiwarigakuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 全賦課履歴Divの操作を行うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
@Ignore
public class FukaRirekiAllHandlerTest extends DbzTestBase {

    private static FukaRirekiAllHandler sut;
    private static FukaRirekiAllDiv result;

    private static final FlexibleYear 激変緩和開始年度 = new FlexibleYear("2006");
    private static final FlexibleYear 激変緩和終了年度 = new FlexibleYear("2007");
    private static final FukaNendo 賦課年度1 = new FukaNendo(DbT2002FukaEntityGenerator.DEFAULT_賦課年度);
    private static final FukaNendo 賦課年度2 = new FukaNendo(DbT2002FukaEntityGenerator.DEFAULT_賦課年度.plusYear(1));
    private static final ChoteiNendo 調定年度1 = new ChoteiNendo(DbT2002FukaEntityGenerator.DEFAULT_調定年度);
    private static final ChoteiNendo 調定年度2 = new ChoteiNendo(DbT2002FukaEntityGenerator.DEFAULT_調定年度.plusYear(1));
    private static final TsuchishoNo 通知書番号1 = DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
    private static final TsuchishoNo 通知書番号2 = new TsuchishoNo("0000000010");

    @BeforeClass
    public static void test() {
        result = createNewDiv();
        sut = new FukaRirekiAllHandler(result, createFukaMiscManager(), createDankaiManager(), createKiwariManager());
//        sut = new FukaRirekiAllHandler(result, createFukaManager(), createDankaiManager(), createKiwariFinder());
//        sut = new FukaRirekiAllHandler(result, createFukaManager(), createDankaiManager());
    }

    public static class load_被保険者番号 {

        @Test
        public void 全賦課履歴のデータがある時_loadは_データをDivに設定する() {
            int count = sut.load(HihokenshaNo.EMPTY);
            assertThat(count, is(2));
            assertThat(result.getDgFukaRirekiAll().getDataSource().get(0).getFukaNendo(), is(賦課年度2.value().toDateString()));
        }
    }

    public static class load_被保険者番号_賦課年度 {

        @Test
        public void 全賦課履歴のデータがある時_loadは_データをDivに設定する() {
            int count = sut.load(HihokenshaNo.EMPTY, FukaNendo.EMPTY);
            assertThat(count, is(2));
            assertThat(result.getDgFukaRirekiAll().getDataSource().get(0).getFukaNendo(), is(賦課年度2.value().toDateString()));
        }
    }

    public static class reload {

        @Test
        public void 全賦課履歴のデータがある時_reloadは_データをDivに設定し_指定行を選択状態にする() {
            int count = sut.reload(HihokenshaNo.EMPTY, 調定年度1, 賦課年度1, 通知書番号1);
            assertThat(count, is(2));
            assertThat(result.getDgFukaRirekiAll().getDataSource().get(0).getFukaNendo(), is(賦課年度2.value().toDateString()));
            assertThat(result.getDgFukaRirekiAll().getSelectedItems().get(0).getFukaNendo(), is(賦課年度1.value().toDateString()));
        }
    }

    public static class get賦課履歴 {

        @Test
        public void 行が選択されていない時_get賦課履歴は_全賦課履歴を返す() {
            sut.load(HihokenshaNo.EMPTY);
            assertThat(sut.get賦課履歴().get賦課履歴All().size(), is(2));
//            assertThat(sut.get賦課履歴().get賦課履歴All().toList().get(0).get賦課年度(), is(賦課年度2));
        }

        @Test
        public void 行が選択されている時_get賦課履歴は_選択行の賦課履歴を返す() {
            sut.reload(HihokenshaNo.EMPTY, 調定年度1, 賦課年度1, 通知書番号1);
            assertThat(sut.get賦課履歴().get賦課履歴All().size(), is(1));
//            assertThat(sut.get賦課履歴().get賦課履歴All().toList().get(0).get賦課年度(), is(賦課年度1));
        }
    }

    private static FukaRirekiAllDiv createNewDiv() {
        FukaRirekiAllDiv div = new FukaRirekiAllDiv();
        div.setDgFukaRirekiAll(new DataGrid<dgFukaRirekiAll_Row>());
        return div;
    }

    private static FukaMiscManager createFukaMiscManager() {
        FukaMiscManager mock = mock(FukaMiscManager.class);
        IItemList<Fuka> modelList = createFukaModelList();
        when(mock.load全賦課履歴(any(HihokenshaNo.class))).thenReturn(modelList);
        when(mock.load全賦課履歴(any(HihokenshaNo.class), any(FlexibleYear.class))).thenReturn(modelList);
        return mock;
    }

    private static HokenryoDankaiManager createDankaiManager() {
        HokenryoDankaiManager mock = mock(HokenryoDankaiManager.class);
        Optional<HokenryoDankai> model = createHokenryoDankai();
        when(mock.get保険料段階(any(FlexibleYear.class), any(RString.class))).thenReturn(model);
        return mock;
    }

    private static KiwarigakuManager createKiwariManager() {
        KiwarigakuManager mock = mock(KiwarigakuManager.class);
        Optional<Kiwarigaku> model = createKiwarigaku();
        when(mock.load期割額(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class), any(int.class))).thenReturn(model);
        return mock;
    }

    private static IItemList<Fuka> createFukaModelList() {
        List<Fuka> modelList = new ArrayList<>();
        modelList.add(createFukaModel(賦課年度1, 調定年度1, 通知書番号1));
        modelList.add(createFukaModel(賦課年度2, 調定年度2, 通知書番号2));
        return ItemList.of(modelList);
    }

    private static Fuka createFukaModel(FukaNendo 賦課年度, ChoteiNendo 調定年度, TsuchishoNo 通知書番号) {
        DbT2002FukaEntity entity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
        entity.setFukaNendo(賦課年度.value());
        entity.setChoteiNendo(調定年度.value());
        entity.setTsuchishoNo(通知書番号);
        return new Fuka(entity);
    }

    private static Optional<HokenryoDankai> createHokenryoDankai() {
        DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
        return Optional.ofNullable(new HokenryoDankai(entity));
    }

    private static Optional<Kiwarigaku> createKiwarigaku() {
        return Optional.ofNullable(new KiwarigakuCalculator(createKiwarigakuModelList()).calculate());
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
        Kibetsu kibetsuModel = mock(Kibetsu.class);
        when(kibetsuModel.get徴収方法()).thenReturn(徴収方法.getコード());

        ChoteiKyotsu choteiKyotsuModel = mock(ChoteiKyotsu.class);
        when(choteiKyotsuModel.get調定額()).thenReturn(new Decimal(調定額));

        KibetsuChoteiKyotsu kibetsuChoteiKyotsuModel = mock(KibetsuChoteiKyotsu.class);
        when(kibetsuChoteiKyotsuModel.get介護期別モデル()).thenReturn(kibetsuModel);
        when(kibetsuChoteiKyotsuModel.get調定共通モデル()).thenReturn(choteiKyotsuModel);

        KibetsuChoteiKyotsu kibetsuChoteiKyotsu = mock(KibetsuChoteiKyotsu.class);

        KiwarigakuMeisai kiwarigakuModel = mock(KiwarigakuMeisai.class);
        when(kiwarigakuModel.get期別調定共通()).thenReturn(kibetsuChoteiKyotsu);
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
