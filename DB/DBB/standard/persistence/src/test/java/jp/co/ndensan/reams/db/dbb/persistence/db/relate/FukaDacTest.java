/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.relate;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2002FukaEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2002FukaEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaDac}のテストクラスです。
 *
 * @author n3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class FukaDacTest {

    private static FukaDac sut;
    private static DbT2002FukaDac 介護賦課Dac;

    private static final FlexibleYear 調定年度1 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
    private static final FlexibleYear 調定年度2 = new FlexibleYear("2013");
    private static final FlexibleYear notFound調定年度 = DbT2002FukaEntityGenerator.DEFAULT_調定年度.plusYear(1);
    private static final FlexibleYear 賦課年度1 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
    private static final FlexibleYear 賦課年度2 = new FlexibleYear("2013");
    private static final FlexibleYear notFound賦課年度 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度.plusYear(1);
    private static final TsuchishoNo 通知書番号1 = DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
    private static final TsuchishoNo 通知書番号2 = new TsuchishoNo("3");
//    private static final RDateTime 履歴番号 = DbT2002FukaEntityGenerator.DEFAULT_履歴番号;
    private static final int 履歴番号 = DbT2002FukaEntityGenerator.DEFAULT_履歴番号;
    private static final int 履歴番号2 = DbT2002FukaEntityGenerator.DEFAULT_履歴番号 + 1;
//    private static final RDateTime 履歴番号2 = RDateTime.of(2013, 9, 01, 10, 20, 30, 123);
    private static final HihokenshaNo 被保険者番号1 = DbT2002FukaEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("0000000003");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(FukaDac.class);
        介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
    }

    public static class select賦課ByKeyTest extends DbzTestDacBase {

//        private static final FukaNendo 賦課年度1 = new FukaNendo(DbT2002FukaEntityGenerator.DEFAULT_賦課年度);
//        private static final TsuchishoNo 通知書番号1 = DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
//        private static final RDateTime 履歴番号 = DbT2002FukaEntityGenerator.DEFAULT_履歴番号;
        public static class select介護賦課ByKeyTest extends DbzTestDacBase {

            @Before
            public void setUp() {
                TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 履歴番号, 被保険者番号1);
                TestSupport.insertDbT2002(調定年度1, 賦課年度2, 通知書番号2, 履歴番号2, 被保険者番号2);
                TestSupport.insertDbT2002(調定年度2, 賦課年度1, 通知書番号1, 履歴番号, 被保険者番号1);
                TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 履歴番号2, 被保険者番号2);
            }

            @Test(expected = NullPointerException.class)
            public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
                sut.select賦課ByKey(null, 賦課年度1, 通知書番号1, 履歴番号);
            }

            @Test(expected = NullPointerException.class)
            public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
                sut.select賦課ByKey(調定年度1, null, 通知書番号1, 履歴番号);
            }

            @Test(expected = NullPointerException.class)
            public void 引数の通知書番号にnullを指定した場合_NullPointerExceptionが発生する() {
                sut.select賦課ByKey(調定年度1, 賦課年度1, null, 履歴番号);
            }

//            @Test(expected = NullPointerException.class)
//            public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
//                sut.select賦課ByKey(調定年度1, 賦課年度1, 通知書番号1, null);
//            }
            @Test
            public void データが見つかる検索条件を渡すと_賦課モデル返す() {
                assertThat(sut.select賦課ByKey(調定年度1, 賦課年度1, 通知書番号1, 履歴番号)
                        .get().getChoteiNendo(), is(調定年度1));
            }

            @Test
            public void データが見つかない検索条件を渡すと_Optionalのemptyを返す() {
                Optional<DbT2002FukaEntity> empty = Optional.empty();
                assertThat(sut.select賦課ByKey(notFound調定年度, 賦課年度1, 通知書番号1, 履歴番号), is(empty));
            }
        }

        public static class selectRecentlyのテスト extends DbzTestDacBase {

            private static final FlexibleYear notFound賦課年度 = new FlexibleYear("2000");

            private static final FlexibleYear 調定年度_2001 = new FlexibleYear("2001");
            private static final FlexibleYear 調定年度_2002 = new FlexibleYear("2002");
            private static final TsuchishoNo 通知書番号_1 = new TsuchishoNo("1");
            private static final TsuchishoNo 通知書番号_2 = new TsuchishoNo("2");
            private static final int 履歴番号1 = 1;
            private static final int 履歴番号2 = 2;
//            private static final RDateTime 履歴番号1 = RDateTime.of(2001, 1, 1, 1, 1, 1, 1);
//            private static final RDateTime 履歴番号2 = RDateTime.of(2002, 2, 2, 2, 2, 2, 2);

            @Before
            public void setUp() {
                /**
                 * 以下のテストデータをinsertする。 <br/>
                 * 通知書　調定　処理<br/>
                 * ① 2 2 1<br/>
                 * ② 2 2 2<br/>
                 * ③ 1 1 2<br/>
                 * ④ 2 1 1<br/>
                 * 取得できる直近データは②
                 */
                TestSupport.insertDbT2002(
                        調定年度_2002,
                        DEFAULT_賦課年度,
                        通知書番号_2,
                        履歴番号1,
                        DEFAULT_被保険者番号);
                TestSupport.insertDbT2002(
                        調定年度_2002,
                        DEFAULT_賦課年度,
                        通知書番号_2,
                        履歴番号2,
                        DEFAULT_被保険者番号);
                TestSupport.insertDbT2002(
                        調定年度_2001,
                        DEFAULT_賦課年度,
                        通知書番号_1,
                        履歴番号2,
                        DEFAULT_被保険者番号);
                TestSupport.insertDbT2002(
                        調定年度_2001,
                        DEFAULT_賦課年度,
                        通知書番号_2,
                        履歴番号1,
                        DEFAULT_被保険者番号);
            }

            @Test(expected = NullPointerException.class)
            public void 賦課年度がnullの場合_selectRecentlyは_NullPointerExceptionをスローする() {
                sut.select賦課Recently(
                        null,
                        DEFAULT_通知書番号,
                        DEFAULT_履歴番号);
            }

            @Test(expected = NullPointerException.class)
            public void 被保険者番号がnullの場合_selectRecentlyは_NullPointerExceptionをスローする() {
                sut.select賦課Recently(
                        DEFAULT_賦課年度,
                        null,
                        DEFAULT_履歴番号);
            }

//            @Test(expected = NullPointerException.class)
//            public void 処理日時がnullの場合_selectRecentlyは_NullPointerExceptionをスローする() {
//                sut.select賦課Recently(
//                        DEFAULT_賦課年度,
//                        DEFAULT_通知書番号,
//                        null);
//            }
            public static class 引数に該当する情報がある時_selectRecentlyは_直近のモデルを１件返す extends DbzTestDacBase {

                @Test
                public void selectRecentlが返す直近データの調定年度は_調定年度_2002() {
                    Optional<DbT2002FukaEntity> insertedRecord = sut.select賦課Recently(
                            DEFAULT_賦課年度,
                            DEFAULT_通知書番号,
                            DEFAULT_履歴番号);
                    assertThat(insertedRecord.get().getChoteiNendo(), is(調定年度_2002));
                }

                @Test
                public void selectRecentlが返す直近データの通知書番号は_通知書番号_2() {
                    Optional<DbT2002FukaEntity> insertedRecord = sut.select賦課Recently(
                            DEFAULT_賦課年度,
                            DEFAULT_通知書番号,
                            DEFAULT_履歴番号);
                    assertThat(insertedRecord.get().getTsuchishoNo(), is(通知書番号_2));
                }

                @Test
                public void selectRecentlが返す直近データの処理日時は_処理日時2002_2_2_2_2_2_2() {
                    Optional<DbT2002FukaEntity> insertedRecord = sut.select賦課Recently(
                            DEFAULT_賦課年度,
                            DEFAULT_通知書番号,
                            DEFAULT_履歴番号);
                    assertThat(insertedRecord.get().getRirekiNo(), is(履歴番号2));
                }
            }

            @Test
            public void 引数に該当する情報がない時_selectRecentlyは_emptyを返す() {
                Optional<DbT2002FukaEntity> insertedRecord = sut.select賦課Recently(
                        notFound賦課年度,
                        DEFAULT_通知書番号,
                        DEFAULT_履歴番号);
                Optional<DbT2002FukaEntity> empty = Optional.empty();
                assertThat(insertedRecord, is(empty));
            }
        }

        public static class select介護賦課一覧_調定年度_賦課年度_通知書番号Test extends DbzTestDacBase {

            @Before
            public void setUp() {
                TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 履歴番号, 被保険者番号1);
                TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 履歴番号2, 被保険者番号1);
                TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 履歴番号, 被保険者番号2);
                TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 履歴番号2, 被保険者番号2);
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
                IItemList<DbT2002FukaEntity> modelList = sut.select介護賦課一覧(調定年度1, 賦課年度1, 通知書番号1);
                assertThat(modelList.size(), is(2));
                assertThat(modelList.toList().get(0).getRirekiNo(), is(履歴番号));
                assertThat(modelList.toList().get(1).getRirekiNo(), is(履歴番号2));
            }

            @Test
            public void データが見つかない検索条件を渡すと_空のリストを返す() {
                assertThat(sut.select介護賦課一覧(notFound調定年度, 賦課年度1, 通知書番号1).isEmpty(), is(true));
            }
        }

        public static class select最新介護賦課Test extends DbzTestDacBase {

            @Before
            public void setUp() {
                TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 履歴番号2, 被保険者番号1);
                TestSupport.insertDbT2002(調定年度2, 賦課年度1, 通知書番号1, 履歴番号2, 被保険者番号1);
                TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 履歴番号, 被保険者番号2);
                TestSupport.insertDbT2002(調定年度2, 賦課年度1, 通知書番号1, 履歴番号, 被保険者番号1);
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
                assertThat(sut.select最新介護賦課(賦課年度1, 通知書番号1).get().getHihokenshaNo(), is(被保険者番号2));
            }

            @Test
            public void データが見つかない検索条件を渡すと_nullを返す() {
                assertThat(sut.select最新介護賦課(notFound賦課年度, 通知書番号1).isPresent(), is(false));
            }
        }

        public static class select介護賦課一覧_被保険者番号Test extends DbzTestDacBase {

            @Before
            public void setUp() {
                TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 履歴番号, 被保険者番号1);
                TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 履歴番号2, 被保険者番号1);
                TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 履歴番号, 被保険者番号2);
                TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 履歴番号2, 被保険者番号2);
            }

            @Test(expected = NullPointerException.class)
            public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
                sut.select介護賦課一覧(null);
            }

            @Test
            public void データが見つかる検索条件を渡すと_介護賦課モデルリストを返す() {
                IItemList<DbT2002FukaEntity> modelList = sut.select介護賦課一覧(被保険者番号1);
                assertThat(modelList.size(), is(2));
                assertThat(modelList.toList().get(0).getRirekiNo(), is(履歴番号));
                assertThat(modelList.toList().get(1).getRirekiNo(), is(履歴番号2));
            }

            @Test
            public void データが見つかない検索条件を渡すと__空のリストを返す() {
                assertThat(sut.select介護賦課一覧(new HihokenshaNo("9999999999")).isEmpty(), is(true));
            }
        }

        public static class select介護賦課一覧_被保険者番号_調定年度Test extends DbzTestDacBase {

            @Before
            public void setUp() {
                TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 履歴番号, 被保険者番号1);
                TestSupport.insertDbT2002(調定年度1, 賦課年度1, 通知書番号1, 履歴番号2, 被保険者番号1);
                TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 履歴番号, 被保険者番号2);
                TestSupport.insertDbT2002(調定年度2, 賦課年度2, 通知書番号2, 履歴番号2, 被保険者番号2);
            }

            @Test(expected = NullPointerException.class)
            public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
                sut.select介護賦課一覧(null, 賦課年度1);
            }

            @Test(expected = NullPointerException.class)
            public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
                sut.select介護賦課一覧(被保険者番号1, null);
            }

            @Test
            public void データが見つかる検索条件を渡すと_介護賦課モデルリストを返す() {
                IItemList<DbT2002FukaEntity> modelList = sut.select介護賦課一覧(被保険者番号1, 賦課年度1);
                assertThat(modelList.size(), is(2));
                assertThat(modelList.toList().get(0).getRirekiNo(), is(履歴番号));
                assertThat(modelList.toList().get(1).getRirekiNo(), is(履歴番号2));
            }

            @Test
            public void データが見つかない検索条件を渡すと__空のリストを返す() {
                assertThat(sut.select介護賦課一覧(new HihokenshaNo("9999999999"), 賦課年度1).isEmpty(), is(true));
            }
        }

        public static class insertTest extends DbzTestDacBase {

            @Test
            public void nullを渡した時_insertは_0を返す() {
                assertThat(sut.insert(null), is(0));
            }

            @Test
            public void 全ての有効なモデルを持つFukaモデルを渡した時_insertは_1を返す() {
                DbT2002FukaEntity model = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();

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
                DbT2002FukaEntity model = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();

                sut.insert(model);

                model.initializeMd5();
                model.setSetaiInsu(5);

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
                DbT2002FukaEntity model = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();

                sut.insert(model);
                assertThat(sut.delete(model), is(1));
            }
        }

        private static class TestSupport {

            public static void insertDbT2002(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, int 履歴番号, HihokenshaNo 被保険者番号) {
                DbT2002FukaEntity entity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
                entity.setChoteiNendo(調定年度);
                entity.setFukaNendo(賦課年度);
                entity.setTsuchishoNo(通知書番号);
                entity.setRirekiNo(履歴番号);
                entity.setHihokenshaNo(被保険者番号);
                介護賦課Dac.save(entity);
            }
        }
    }
}
