/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.relate.fuka.ChoshuYuyoRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2007KibetsuChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChoshuYuyoRelateDac}のテストクラスです。
 *
 * @author n3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ChoshuYuyoRelateDacTest {

    private static ChoshuYuyoRelateDac sut;
    private static DbT2006ChoshuYuyoDac 徴収猶予Dac;
    private static DbT2007KibetsuChoshuYuyoDac 期別徴収猶予Dac;

    private static final ChoteiNendo 調定年度1 = new ChoteiNendo(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度);
    private static final ChoteiNendo notFound調定年度 = new ChoteiNendo(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度.plusYear(1));
    private static final FukaNendo 賦課年度1 = new FukaNendo(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度);
    private static final TsuchishoNo 通知書番号1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_通知書番号;
    private static final RDateTime 処理日時1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_処理日時;
    private static final GemmenChoshuYuyoStateKubun 状態区分1
            = GemmenChoshuYuyoStateKubun.toValue(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予状態区分);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ChoshuYuyoRelateDac.class);
        徴収猶予Dac = InstanceProvider.create(DbT2006ChoshuYuyoDac.class);
        期別徴収猶予Dac = InstanceProvider.create(DbT2007KibetsuChoshuYuyoDac.class);
    }

    public static class select徴収猶予RelateByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2006(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, 状態区分1);
            TestSupport.insertDbT2007(調定年度1, 賦課年度1, 通知書番号1, 処理日時1);
        }

        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select徴収猶予RelateByKeyAndState(null, 賦課年度1, 通知書番号1, 処理日時1, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select徴収猶予RelateByKeyAndState(調定年度1, null, 通知書番号1, 処理日時1, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の通知書番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select徴収猶予RelateByKeyAndState(調定年度1, 賦課年度1, null, 処理日時1, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select徴収猶予RelateByKeyAndState(調定年度1, 賦課年度1, 通知書番号1, null, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の状態区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select徴収猶予RelateByKeyAndState(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_徴収猶予モデル返す() {
            assertThat(sut.select徴収猶予RelateByKeyAndState(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, 状態区分1)
                    .get().get徴収猶予モデル().get調定年度(), is(調定年度1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_Optionalのemptyを返す() {
            Optional<ChoshuYuyoRelateModel> empty = Optional.empty();
            assertThat(sut.select徴収猶予RelateByKeyAndState(
                    notFound調定年度, 賦課年度1, 通知書番号1, 処理日時1, 状態区分1), is(empty));
        }
    }

    //TODO n3317塚田萌　更新処理が必要になったときに対応する
//    public static class insertTest extends DbzTestDacBase {
//
//        @Test
//        public void nullを渡した時_insertは_0を返す() {
//            assertThat(sut.insert(null), is(0));
//        }
//
//        // TODO ChoshuYuyoRelateModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
//        @Test
//        public void 全ての有効なモデルを持つChoshuYuyoRelateモデルを渡した時_insertは_1を返す() {
//            ChoshuYuyoRelateModel model = new ChoshuYuyoRelateModel(
//                    new ChoshuYuyoModel(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity()),
//                    new KibetsuChoshuYuyoModel(DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity()));
//
//            assertThat(sut.insert(model), is(1));
//        }
//    }
//
//    public static class updateTest extends DbzTestDacBase {
//
//        @Test
//        public void nullを渡した時_updateは_0を返す() {
//            assertThat(sut.update(null), is(0));
//        }
//
//        // TODO ChoshuYuyoRelateModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。異なる状態を指定する。
//        @Test
//        public void モデルの状態がModifiedの時_updateは_1を返す() {
//            ChoshuYuyoRelateModel model = new ChoshuYuyoRelateModel(
//                    new ChoshuYuyoModel(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity()),
//                    new KibetsuChoshuYuyoModel(DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity()));
//
//            sut.insert(model);
//
//            model.get徴収猶予モデル().getEntity().initializeMd5();
//            model.get期別徴収猶予モデル().getEntity().initializeMd5();
//            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
//            model.getXXXモデル.setXXX();
//
//            assertThat(sut.update(model), is(1));
//        }
//
//    }
//
//    public static class deleteTest extends DbzTestDacBase {
//
//        @Test
//        public void nullを渡した時_deleteは_0を返す() {
//            assertThat(sut.delete(null), is(0));
//        }
//
//        // TODO ChoshuYuyoRelateModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
//        @Test
//        public void 全ての有効なモデルを持つChoshuYuyoRelateモデルを渡した時_deleteは_1を返す() {
//            ChoshuYuyoRelateModel model = new ChoshuYuyoRelateModel(
//                    new ChoshuYuyoModel(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity()),
//                    new KibetsuChoshuYuyoModel(DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity()));
//
//            sut.insert(model);
//            assertThat(sut.delete(model), is(1));
//        }
//    }
//
//    public static class deletePhysicalTest extends DbzTestDacBase {
//
//        @Test
//        public void nullを渡した時_deletePhysicalは_0を返す() {
//            assertThat(sut.deletePhysical(null), is(0));
//        }
//
//        // TODO ChoshuYuyoRelateModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
//        @Test
//        public void 全ての有効なモデルを持つChoshuYuyoRelateモデルを渡した時_deletePhysicalは_1を返す() {
//            ChoshuYuyoRelateModel model = new ChoshuYuyoRelateModel(
//                    new ChoshuYuyoModel(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity()),
//                    new KibetsuChoshuYuyoModel(DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity()));
//
//            sut.insert(model);
//            assertThat(sut.deletePhysical(model), is(1));
//        }
//    }
    private static class TestSupport {

        public static void insertDbT2006(
                ChoteiNendo 調定年度, FukaNendo 賦課年度,
                TsuchishoNo 通知書番号, RDateTime 処理日時, GemmenChoshuYuyoStateKubun 状態区分1) {

            DbT2006ChoshuYuyoEntity entity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            entity.setChoteiNendo(調定年度.value());
            entity.setFukaNendo(賦課年度.value());
            entity.setTsuchishoNo(通知書番号);
            entity.setShoriTimestamp(処理日時);
            entity.setJotaiKubun(状態区分1.code());

            徴収猶予Dac.insert(entity);
        }

        public static void insertDbT2007(
                ChoteiNendo 調定年度, FukaNendo 賦課年度,
                TsuchishoNo 通知書番号, RDateTime 処理日時) {
            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            entity.setChoteiNendo(調定年度.value());
            entity.setFukaNendo(賦課年度.value());
            entity.setTsuchishoNo(通知書番号);
            entity.setShoriTimestamp(処理日時);
            期別徴収猶予Dac.insert(entity);
        }
    }
}
