/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.FukaModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * {@link FukaDac}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class FukaDacTest {

    private static FukaDac sut;
    private static DbT2002FukaDac 介護賦課Dac;
    private static final FlexibleYear 調定年度1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
    private static final FlexibleYear 調定年度2 = new FlexibleYear("2013");
    private static final FlexibleYear 賦課年度1 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
    private static final FlexibleYear 賦課年度2 = new FlexibleYear("2013");
    private static final TsuchishoNo 通知書番号1 = DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
    private static final TsuchishoNo 通知書番号2 = new TsuchishoNo("3");
    private static final RDateTime 処理日時1 = DbT2002FukaEntityGenerator.DEFAULT_処理日時;
    private static final RDateTime 処理日時2 = RDateTime.of(2013, 9, 01, 10, 20, 30, 123);
    private static final HihokenshaNo 被保険者番号1 = DbT2002FukaEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("0000000003");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(FukaDac.class);
        介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
    }

    public static class select介護賦課ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, 被保険者番号1);
            TestSupport.insertDbT2002(調定年度1, 賦課年度2, 通知書番号2, 処理日時2, 被保険者番号2);
            TestSupport.insertDbT2002(調定年度2, 賦課年度1, 通知書番号1, 処理日時1, 被保険者番号1);
            TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 処理日時2, 被保険者番号2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護賦課ByKey(null, 賦課年度1, 通知書番号1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護賦課ByKey(調定年度1, null, 通知書番号1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の通知書番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護賦課ByKey(調定年度1, 賦課年度1, null, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護賦課ByKey(調定年度1, 賦課年度1, 通知書番号1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_介護賦課モデル返す() {
            assertThat(sut.select介護賦課ByKey(調定年度1, 賦課年度1, 通知書番号1, 処理日時1).get().get調定年度(), is(調定年度1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.select介護賦課ByKey(FlexibleYear.MAX, 賦課年度1, 通知書番号1, 処理日時1).isPresent(), is(false));
        }
    }

    public static class select介護賦課一覧_調定年度_賦課年度_通知書番号Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, 被保険者番号1);
            TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 処理日時2, 被保険者番号1);
            TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 処理日時1, 被保険者番号2);
            TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 処理日時2, 被保険者番号2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護賦課一覧(null, 賦課年度1, 通知書番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護賦課一覧(調定年度1, null, 通知書番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の通知書番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護賦課一覧(調定年度1, 賦課年度1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_介護賦課モデルリストを返す() {
            IItemList<FukaModel> modelList = sut.select介護賦課一覧(調定年度1, 賦課年度1, 通知書番号1);
            assertThat(modelList.size(), is(2));
            assertThat(modelList.toList().get(0).get処理日時(), is(処理日時1));
            assertThat(modelList.toList().get(1).get処理日時(), is(処理日時2));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select介護賦課一覧(FlexibleYear.MAX, 賦課年度1, 通知書番号1).isEmpty(), is(true));
        }
    }

    public static class select最新介護賦課Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 処理日時2, 被保険者番号1);
            TestSupport.insertDbT2002(調定年度2, 賦課年度1, 通知書番号1, 処理日時2, 被保険者番号1);
            TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, 被保険者番号2);
            TestSupport.insertDbT2002(調定年度2, 賦課年度1, 通知書番号1, 処理日時1, 被保険者番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select最新介護賦課(null, 通知書番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の通知書番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select最新介護賦課(賦課年度1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_介護賦課モデル返す() {
            assertThat(sut.select最新介護賦課(賦課年度1, 通知書番号1).get().get被保険者番号(), is(被保険者番号2));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.select最新介護賦課(FlexibleYear.MAX, 通知書番号1).isPresent(), is(false));
        }
    }

    public static class select介護賦課一覧_被保険者番号Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, 被保険者番号1);
            TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 処理日時2, 被保険者番号1);
            TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 処理日時1, 被保険者番号2);
            TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 処理日時2, 被保険者番号2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護賦課一覧(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_介護賦課モデルリストを返す() {
            IItemList<FukaModel> modelList = sut.select介護賦課一覧(被保険者番号1);
            assertThat(modelList.size(), is(2));
            assertThat(modelList.toList().get(0).get処理日時(), is(処理日時1));
            assertThat(modelList.toList().get(1).get処理日時(), is(処理日時2));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select介護賦課一覧(new HihokenshaNo("9999999999")).isEmpty(), is(true));
        }
    }

    public static class select介護賦課一覧_被保険者番号_調定年度Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, 被保険者番号1);
            TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 処理日時2, 被保険者番号1);
            TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 処理日時1, 被保険者番号2);
            TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 処理日時2, 被保険者番号2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護賦課一覧(null, 調定年度1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護賦課一覧(被保険者番号1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_介護賦課モデルリストを返す() {
            IItemList<FukaModel> modelList = sut.select介護賦課一覧(被保険者番号1, 調定年度1);
            assertThat(modelList.size(), is(2));
            assertThat(modelList.toList().get(0).get処理日時(), is(処理日時1));
            assertThat(modelList.toList().get(1).get処理日時(), is(処理日時2));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select介護賦課一覧(new HihokenshaNo("9999999999"), 調定年度1).isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つFukaモデルを渡した時_insertは_1を返す() {
            FukaModel model = new FukaModel(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());

            assertThat(sut.insert(model), is(1));
        }
    }

    public static class updateTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        @Test
        public void モデルの状態がModifiedの時_updateは_1を返す() {
            FukaModel model = new FukaModel(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());

            sut.insert(model);

            model.getEntity().initializeMd5();
            model.set世帯員数(5);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つFukaモデルを渡した時_deleteは_1を返す() {
            FukaModel model = new FukaModel(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());

            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }

    public static class deletePhysicalTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deletePhysicalは_0を返す() {
            assertThat(sut.deletePhysical(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つFukaモデルを渡した時_deletePhysicalは_1を返す() {
            FukaModel model = new FukaModel(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT2002(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, RDateTime 処理日時, HihokenshaNo 被保険者番号) {
            DbT2002FukaEntity entity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            entity.setChoteiNendo(調定年度);
            entity.setFukaNendo(賦課年度);
            entity.setTsuchishoNo(通知書番号);
            entity.setShoriTimestamp(処理日時);
            entity.setHihokenshaNo(被保険者番号);
            介護賦課Dac.insert(entity);
        }
    }

}
