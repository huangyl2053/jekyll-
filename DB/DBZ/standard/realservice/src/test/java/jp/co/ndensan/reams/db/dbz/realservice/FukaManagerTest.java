/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2002FukaEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.model.fuka.FukaModel;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.helper.FukaModelTestHelper;
import jp.co.ndensan.reams.db.dbz.persistence.relate.FukaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * {link FukaManager}のテストクラスです。
 *
 * @author n3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class FukaManagerTest {

    private static FukaDac dac;
    private static FukaManager sut;

    private static final FukaNendo notFound賦課年度 = new FukaNendo("2111");
    private static final FukaNendo 賦課年度 = new FukaNendo(DEFAULT_賦課年度);
    private static final ChoteiNendo 調定年度 = new ChoteiNendo(DEFAULT_調定年度);
    private static final TsuchishoNo 通知書番号 = DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
    private static final RDateTime 処理日時 = DbT2002FukaEntityGenerator.DEFAULT_処理日時;

    @BeforeClass
    public static void test() {
        dac = mock(FukaDac.class);
        sut = new FukaManager(dac);
    }

    public static class find賦課 extends DbzTestBase {

        @Test
        public void find賦課は_該当の情報がない時_Optionalのemptyを返す() {
            Optional<FukaModel> empty = Optional.empty();

            when(dac.select賦課ByKey(any(ChoteiNendo.class), any(FukaNendo.class),
                    any(TsuchishoNo.class), any(RDateTime.class))).thenReturn(empty);
            Optional<FukaModel> result = sut.find賦課(調定年度, notFound賦課年度, DEFAULT_通知書番号, DEFAULT_処理日時);

            assertThat(result, is(empty));
        }

        @Test
        public void find賦課は_該当の情報がある時_該当情報を返す() {
            Optional<FukaModel> model = Optional.of(
                    new FukaModel(DbT2002FukaEntityGenerator.createDbT2002FukaEntity()));

            when(dac.select賦課ByKey(調定年度, 賦課年度, DEFAULT_通知書番号, DEFAULT_処理日時)).thenReturn(model);
            Optional<FukaModel> result = sut.find賦課(調定年度, 賦課年度, DEFAULT_通知書番号, DEFAULT_処理日時);

            assertThat(result.get().get賦課年度(), is(賦課年度));
        }
    }

    public static class find賦課直近 extends DbzTestBase {

        @Test
        public void find賦課直近は_該当の情報がない時_Optionalのemptyを返す() {
            Optional<FukaModel> empty = Optional.empty();

            when(dac.select賦課Recently(any(FukaNendo.class), any(HihokenshaNo.class), any(RDateTime.class))).thenReturn(empty);
            Optional<FukaModel> result = sut.find賦課直近(notFound賦課年度, DEFAULT_被保険者番号, DEFAULT_処理日時);

            assertThat(result, is(empty));
        }

        @Test
        public void find賦課直近は_該当の情報がある時_該当情報を返す() {
            Optional<FukaModel> model = Optional.of(
                    new FukaModel(DbT2002FukaEntityGenerator.createDbT2002FukaEntity()));

            when(dac.select賦課Recently(賦課年度, DEFAULT_被保険者番号, DEFAULT_処理日時)).thenReturn(model);

            Optional<FukaModel> result = sut.find賦課直近(賦課年度, DEFAULT_被保険者番号, DEFAULT_処理日時);

            assertThat(result.get().get賦課年度(), is(賦課年度));
        }
    }

    //TODO 宮本さんがテストを作る
//    public static class load全賦課履歴_被保険者番号 extends DbzTestBase {
//
//    }
//    public static class load全賦課履歴_被保険者番号_賦課年度 extends DbzTestBase {
//    }
    public static class get介護賦課一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_介護賦課のリストが返る() {

            List<FukaModel> modelList = new ArrayList<>();
            modelList.add(FukaModelTestHelper.createModel());
            modelList.add(FukaModelTestHelper.createModel());
            IItemList<FukaModel> 介護賦課モデルリスト = ItemList.of(modelList);

            when(dac.select介護賦課一覧(any(ChoteiNendo.class), any(FukaNendo.class), any(TsuchishoNo.class))).thenReturn(介護賦課モデルリスト);

            IItemList<FukaModel> result = sut.get介護賦課一覧(調定年度, 賦課年度, 通知書番号);

            assertThat(result.size(), is(2));
            assertThat(result.toList().get(0).get世帯コード(), is(介護賦課モデルリスト.toList().get(0).get世帯コード()));
            assertThat(result.toList().get(1).get世帯員数(), is(介護賦課モデルリスト.toList().get(0).get世帯員数()));
        }
    }

    public static class get最新介護賦課Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_介護賦課が返る() {

            Optional<FukaModel> 介護賦課モデル = Optional.ofNullable(FukaModelTestHelper.createModel());

            when(dac.select最新介護賦課(any(FukaNendo.class), any(TsuchishoNo.class))).thenReturn(介護賦課モデル);

            Optional<FukaModel> result = sut.get最新介護賦課(賦課年度, 通知書番号);

            assertThat(result.get().get世帯コード(), is(介護賦課モデル.get().get世帯コード()));
        }
    }

    public static class save介護賦課 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(FukaModel.class))).thenReturn(1);

            FukaModel 介護賦課モデル = FukaModelTestHelper.createModel();

            assertThat(sut.save介護賦課(介護賦課モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(FukaModel.class))).thenReturn(1);

            FukaModel 介護賦課モデル = FukaModelTestHelper.createModel();
            介護賦課モデル.getEntity().initializeMd5();
            介護賦課モデル.set世帯員数(99);

            assertThat(sut.save介護賦課(介護賦課モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(FukaModel.class))).thenReturn(1);

            FukaModel 介護賦課モデル = FukaModelTestHelper.createModel();
            介護賦課モデル.getEntity().initializeMd5();
            介護賦課モデル.setDeletedState(true);

            assertThat(sut.save介護賦課(介護賦課モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            FukaModel 介護賦課モデル = FukaModelTestHelper.createModel();
            介護賦課モデル.getEntity().initializeMd5();

            sut.save介護賦課(介護賦課モデル);
        }
    }
}
