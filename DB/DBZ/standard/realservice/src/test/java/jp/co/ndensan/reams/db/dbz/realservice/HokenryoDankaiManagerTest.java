/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.HokenryoDankaiModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link HokenryoDankaiManager}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HokenryoDankaiManagerTest {

    private static HokenryoDankaiManager sut;
    private static final FlexibleYear 賦課年度1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度;
    private static final DankaiIndex 段階インデックス1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス;
    private static final DankaiIndex 段階インデックス2 = new DankaiIndex(new RString("06"));
    private static final RankKubun ランク区分1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分;
    private static final RankKubun ランク区分2 = new RankKubun(new RString("01"));

    private static final boolean ランク有り = true;
    private static final boolean ランク無し = false;
    private static final Range<FlexibleYear> ランク対象期間 = new Range(new FlexibleYear("2000"), new FlexibleYear("2005"));
    private static final FlexibleYear 賦課年度_ランク対象期間内 = new FlexibleYear("2001");
    private static final FlexibleYear 賦課年度_ランク対象期間外 = new FlexibleYear("2008");
    private static final LasdecCode 市町村コード_指定有り = new LasdecCode("000001");
    private static final LasdecCode 市町村コード_指定無し = null;
    private static final RString 段階区分1 = new RString("010");
    private static final RString 段階区分2 = new RString("020");

    public static class get保険料段階Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_保険料段階が返る() {
            sut = createManager(ランク有り);
            assertThat(sut.get保険料段階(賦課年度1, 段階インデックス1, ランク区分1).get().get賦課年度(), is(賦課年度1));
        }
    }

    public static class get保険料段階_ランク対象 {

        @Test
        public void ランク有り_ランク対象期間内の時_get保険料段階は_該当の保険料段階を返す() {
            sut = createManager(ランク有り);
            assertThat(sut.get保険料段階(賦課年度_ランク対象期間内, 市町村コード_指定有り, 段階区分1).get().get段階区分(), is(段階区分1));
        }

        @Test
        public void ランク有り_ランク対象期間外の時_get保険料段階は_該当の保険料段階を返す() {
            sut = createManager(ランク有り);
            assertThat(sut.get保険料段階(賦課年度_ランク対象期間外, 市町村コード_指定有り, 段階区分2).get().get段階区分(), is(段階区分2));
        }

        @Test
        public void ランク無しの時_get保険料段階は_該当の保険料段階を返す() {
            sut = createManager(ランク無し);
            assertThat(sut.get保険料段階(賦課年度_ランク対象期間内, 市町村コード_指定有り, 段階区分2).get().get段階区分(), is(段階区分2));
        }

        @Test
        public void 市町村コードの指定が無い時_get保険料段階は_該当の保険料段階を返す() {
            sut = createManager(ランク有り);
            assertThat(sut.get保険料段階(賦課年度_ランク対象期間内, 市町村コード_指定無し, 段階区分2).get().get段階区分(), is(段階区分2));
        }
    }

    public static class get保険料段階一覧_賦課年度Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_保険料段階のリストが返る() {
            sut = createManager(ランク有り);
            IItemList<HokenryoDankaiModel> 保険料段階リスト = sut.get保険料段階一覧(賦課年度1);
            assertThat(保険料段階リスト.size(), is(2));
            assertThat(保険料段階リスト.asList().get(0).get段階インデックス(), is(段階インデックス1));
            assertThat(保険料段階リスト.asList().get(1).get段階インデックス(), is(段階インデックス2));
        }
    }

    public static class save保険料段階 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            HokenryoDankaiModel 保険料段階モデル = createModel(賦課年度1, 段階インデックス1, ランク区分1, 段階区分1);
            sut = createManager(ランク有り);
            assertThat(sut.save保険料段階(保険料段階モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            HokenryoDankaiModel 保険料段階モデル = createModel(賦課年度1, 段階インデックス1, ランク区分1, 段階区分1);
            保険料段階モデル.getEntity().initializeMd5();
            保険料段階モデル.set保険料率(Decimal.ZERO);
            sut = createManager(ランク有り);
            assertThat(sut.save保険料段階(保険料段階モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            HokenryoDankaiModel 保険料段階モデル = createModel(賦課年度1, 段階インデックス1, ランク区分1, 段階区分1);
            保険料段階モデル.getEntity().initializeMd5();
            保険料段階モデル.setDeletedState(true);
            sut = createManager(ランク有り);
            assertThat(sut.save保険料段階(保険料段階モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {
            HokenryoDankaiModel 保険料段階モデル = createModel(賦課年度1, 段階インデックス1, ランク区分1, 段階区分1);
            保険料段階モデル.getEntity().initializeMd5();
            sut = createManager(ランク有り);
            sut.save保険料段階(保険料段階モデル);
        }
    }

    private static HokenryoDankaiManager createManager(boolean ランク有無) {
        return new HokenryoDankaiManager(createDac(), createConfig(ランク有無));
    }

    private static HokenryoDankaiDac createDac() {
        HokenryoDankaiDac dac = mock(HokenryoDankaiDac.class);

        HokenryoDankaiModel model1 = createModel(賦課年度1, 段階インデックス1, ランク区分1, 段階区分1);
        HokenryoDankaiModel model2 = createModel(賦課年度1, 段階インデックス2, ランク区分2, 段階区分2);

        when(dac.select保険料段階ByKey(any(FlexibleYear.class), any(DankaiIndex.class), any(RankKubun.class))).thenReturn(model1);

        List<HokenryoDankaiModel> modelList1 = new ArrayList<>();
        modelList1.add(model1);
        when(dac.select保険料段階一覧(any(FlexibleYear.class), any(LasdecCode.class), any(RString.class))).thenReturn(modelList1);

        List<HokenryoDankaiModel> modelList2 = new ArrayList<>();
        modelList2.add(model2);
        when(dac.select保険料段階一覧(any(FlexibleYear.class), any(RString.class))).thenReturn(modelList2);

        List<HokenryoDankaiModel> modelList3 = new ArrayList<>();
        modelList3.add(model1);
        modelList3.add(model2);
        when(dac.select保険料段階一覧(any(FlexibleYear.class))).thenReturn(modelList3);

        when(dac.insert(any(HokenryoDankaiModel.class))).thenReturn(1);
        when(dac.update(any(HokenryoDankaiModel.class))).thenReturn(1);
        when(dac.delete(any(HokenryoDankaiModel.class))).thenReturn(1);

        return dac;
    }

    private static HokenryoDankaiModel createModel(FlexibleYear 賦課年度, DankaiIndex 段階インデックス, RankKubun ランク区分, RString 段階区分) {
        DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
        entity.setFukaNendo(賦課年度);
        entity.setDankaiIndex(段階インデックス);
        entity.setRankuKubun(ランク区分);
        entity.setDankaiKubun(段階区分);
        return new HokenryoDankaiModel(entity);
    }

    private static FukaKeisanConfig createConfig(boolean ランク有無) {
        FukaKeisanConfig mock = mock(FukaKeisanConfig.class);
        when(mock.isランク有り()).thenReturn(ランク有無);
        when(mock.getランク開始年度()).thenReturn(ランク対象期間.getFrom());
        when(mock.getランク終了年度()).thenReturn(ランク対象期間.getTo());
        return mock;
    }
}
