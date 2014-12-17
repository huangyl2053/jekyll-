/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.HokenryoRankModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HokenryoRankDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link HokenryoRankManager}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HokenryoRankManagerTest {

    private static HokenryoRankDac dac;
    private static HokenryoRankManager sut;
    private static final FlexibleYear 賦課年度1 = DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度;
    private static final FlexibleYear 賦課年度2 = DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度.plusYear(1);
    private static final LasdecCode 市町村コード1 = DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード;
    private static final LasdecCode 市町村コード2 = new LasdecCode("000010");

    @BeforeClass
    public static void test() {
        dac = mock(HokenryoRankDac.class);
        sut = new HokenryoRankManager(dac);
    }

    public static class get保険料ランクTest extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_保険料ランクが返る() {

            HokenryoRankModel 保険料ランクモデル = createHokenryoRankModel(賦課年度1, 市町村コード1);

            when(dac.select保険料ランクByKey(any(FlexibleYear.class), any(LasdecCode.class))).thenReturn(保険料ランクモデル);

            IOptional<HokenryoRankModel> 保険料ランク = sut.get保険料ランク(賦課年度1, 市町村コード1);

            assertThat(保険料ランク.get().get賦課年度(), is(賦課年度1));
        }
    }

    public static class get保険料ランク一覧_賦課年度Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_保険料ランクのリストが返る() {

            List<HokenryoRankModel> 保険料ランクモデルリスト = new ArrayList<>();
            保険料ランクモデルリスト.add(createHokenryoRankModel(賦課年度1, 市町村コード1));
            保険料ランクモデルリスト.add(createHokenryoRankModel(賦課年度1, 市町村コード2));

            when(dac.select保険料ランク一覧(any(FlexibleYear.class))).thenReturn(保険料ランクモデルリスト);

            IItemList<HokenryoRankModel> 保険料ランクリスト = sut.get保険料ランク一覧(賦課年度1);

            assertThat(保険料ランクリスト.size(), is(2));
            assertThat(保険料ランクリスト.asList().get(0).get市町村コード(), is(市町村コード1));
            assertThat(保険料ランクリスト.asList().get(1).get市町村コード(), is(市町村コード2));
        }
    }

    public static class save保険料ランク extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(HokenryoRankModel.class))).thenReturn(1);

            HokenryoRankModel 保険料ランクモデル = createHokenryoRankModel(賦課年度1, 市町村コード1);

            assertThat(sut.save保険料ランク(保険料ランクモデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(HokenryoRankModel.class))).thenReturn(1);

            HokenryoRankModel 保険料ランクモデル = createHokenryoRankModel(賦課年度1, 市町村コード1);
            保険料ランクモデル.getEntity().initializeMd5();
            保険料ランクモデル.set遡及年度(FlexibleYear.MAX);

            assertThat(sut.save保険料ランク(保険料ランクモデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(HokenryoRankModel.class))).thenReturn(1);

            HokenryoRankModel 保険料ランクモデル = createHokenryoRankModel(賦課年度1, 市町村コード1);
            保険料ランクモデル.getEntity().initializeMd5();
            保険料ランクモデル.setDeletedState(true);

            assertThat(sut.save保険料ランク(保険料ランクモデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            HokenryoRankModel 保険料ランクモデル = createHokenryoRankModel(賦課年度1, 市町村コード1);
            保険料ランクモデル.getEntity().initializeMd5();

            sut.save保険料ランク(保険料ランクモデル);
        }
    }

    private static HokenryoRankModel createHokenryoRankModel(FlexibleYear 賦課年度, LasdecCode 市町村コード) {
        DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
        entity.setFukaNendo(賦課年度);
        entity.setShichosonCode(市町村コード);
        return new HokenryoRankModel(entity);
    }
}
