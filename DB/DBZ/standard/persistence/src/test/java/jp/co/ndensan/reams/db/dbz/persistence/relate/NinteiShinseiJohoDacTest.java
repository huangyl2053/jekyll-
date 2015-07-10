/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.model.NinteiShinseiJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
//TODO n8235 船山洋介 受給者台帳・認定申請結果情報・認定申請情報のテーブルが変更されたため、最新化が必要
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5001NinteiShinseiJohoEntityGenerator;
//import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5001NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiShinseiJohoDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
//TODO n8235 船山洋介 受給者台帳・認定申請結果情報・認定申請情報のテーブルが変更されたため、最新化が必要
//@RunWith(Enclosed.class)
//public class NinteiShinseiJohoDacTest {
//
//    private static NinteiShinseiJohoDac sut;
//    private static DbT5001NinteiShinseiJohoDac 要介護認定申請情報Dac;
//    private static final ShinseishoKanriNo 申請書管理番号1 = new ShinseishoKanriNo(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号);
//    private static final ShinseishoKanriNo 申請書管理番号2 = new ShinseishoKanriNo(new RString("9234567890"));
//    private static final YMDHMS 処理日時1 = DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_処理日時;
//    private static final YMDHMS 処理日時2 = new YMDHMS("20140101102040");
//
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceProvider.create(NinteiShinseiJohoDac.class);
//        要介護認定申請情報Dac = InstanceProvider.create(DbT5001NinteiShinseiJohoDac.class);
//    }
//
//    public static class selectByKeyTest extends DbzTestDacBase {
//
//        @Before
//        public void setUp() {
//            TestSupport.insertDbT5001(申請書管理番号1, 処理日時1);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の申請書管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.selectByKey(null, 処理日時1);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.selectByKey(申請書管理番号1, null);
//        }
//
//        // TODO 見つかる場合、要介護認定申請情報モデルを構成している全てのモデルクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
//        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
//        @Test
//        public void データが見つかる検索条件を渡すと_要介護認定申請情報モデル返す() {
//            assertThat(sut.selectByKey(申請書管理番号1, 処理日時1).get().get申請書管理番号(), is(申請書管理番号1.value()));
//        }
//
//        // データが見つからない値を指定するように修正してください。
//        @Test
//        public void データが見つかない検索条件を渡すと_データ無しを返す() {
//            assertThat(sut.selectByKey(申請書管理番号2, 処理日時1).isPresent(), is(false));
//        }
//    }
//
//    public static class selectAll extends DbzTestDacBase {
//
//        @Test
//        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
//            TestSupport.insertDbT5001(申請書管理番号1, 処理日時1);
//            IItemList<NinteiShinseiJohoModel> modelList = sut.selectAll();
//            assertThat(modelList.size(), is(1));
//            // 任意の項目が一致するテストケースを記述してください。
//            assertThat(modelList.toList().get(0).get申請書管理番号(), is(申請書管理番号1.value()));
//        }
//
//        @Test
//        public void データが見つかない検索条件を渡すと_空のリストを返す() {
//            assertThat(sut.selectAll().isEmpty(), is(true));
//        }
//    }
//
//    public static class select要介護認定申請情報By申請書管理番号Test extends DbzTestDacBase {
//
//        @Before
//        public void setUp() {
//            TestSupport.insertDbT5001(申請書管理番号1, 処理日時1);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー値にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.select要介護認定申請情報By申請書管理番号(null);
//        }
//
//        // TODO 見つかる場合、要介護認定申請情報モデルを構成している全てのモデルクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
//        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
//        @Test
//        public void データが見つかる検索条件を渡すと_要介護認定申請情報モデル返す() {
//            assertThat(sut.select要介護認定申請情報By申請書管理番号(申請書管理番号1).get().get申請書管理番号(), is(申請書管理番号1.value()));
//        }
//
//        // データが見つからない値を指定するように修正してください。
//        @Test
//        public void データが見つかない検索条件を渡すと_データ無しを返す() {
//            assertThat(sut.select要介護認定申請情報By申請書管理番号(申請書管理番号2).isPresent(), is(false));
//        }
//    }
//
//    public static class insertTest extends DbzTestDacBase {
//
//        @Test
//        public void nullを渡した時_insertは_0を返す() {
//            assertThat(sut.insert(null), is(0));
//        }
//
//        // TODO NinteiShinseiJohoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
//        @Test
//        public void 全ての有効なモデルを持つNinteiShinseiJohoRelateモデルを渡した時_insertは_1を返す() {
//            NinteiShinseiJohoModel model = new NinteiShinseiJohoModel(DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity());
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
//        // TODO NinteiShinseiJohoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。異なる状態を指定する。
//        @Test
//        public void モデルの状態がModifiedの時_updateは_1を返す() {
//            NinteiShinseiJohoModel model = new NinteiShinseiJohoModel(DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity());
//
//            sut.insert(model);
//
//            model.getEntity().initializeMd5();
//            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
//            model.set取下げ理由(new RString("99"));
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
//        // TODO NinteiShinseiJohoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
//        @Test
//        public void 全ての有効なモデルを持つNinteiShinseiJohoRelateモデルを渡した時_deleteは_1を返す() {
//            NinteiShinseiJohoModel model = new NinteiShinseiJohoModel(DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity());
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
//        // TODO NinteiShinseiJohoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
//        @Test
//        public void 全ての有効なモデルを持つNinteiShinseiJohoRelateモデルを渡した時_deletePhysicalは_1を返す() {
//            NinteiShinseiJohoModel model = new NinteiShinseiJohoModel(DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity());
//
//            sut.insert(model);
//            assertThat(sut.deletePhysical(model), is(1));
//        }
//    }
//
//    private static class TestSupport {
//
//        public static void insertDbT5001(
//                ShinseishoKanriNo 申請書管理番号,
//                YMDHMS 処理日時) {
//            DbT5001NinteiShinseiJohoEntity entity = DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity();
//            entity.setShinseishoKanriNo(申請書管理番号.value());
//            entity.setShoriTimestamp(処理日時);
//            要介護認定申請情報Dac.insert(entity);
//        }
//    }
//}
