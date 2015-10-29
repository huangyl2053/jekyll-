/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import jp.co.ndensan.reams.db.dbz.persistence.db.relate.NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4102NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiKekkaJohoDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteiKekkaJohoDacTest {

    private static NinteiKekkaJohoDac sut;
    private static DbT4102NinteiKekkaJohoDac 要介護認定結果情報Dac;
    private static final ShinseishoKanriNo 申請書管理番号1 = DbT4102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号;
    private static final ShinseishoKanriNo 申請書管理番号2 = new ShinseishoKanriNo(new RString("9234567890"));

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(NinteiKekkaJohoDac.class);
        要介護認定結果情報Dac = InstanceProvider.create(DbT4102NinteiKekkaJohoDac.class);
    }

    public static class selectByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT4102(申請書管理番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の申請書管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(null);
        }

        // TODO 見つかる場合、要介護認定結果情報モデルを構成している全てのモデルクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_要介護認定結果情報モデル返す() {
            assertThat(sut.selectByKey(申請書管理番号1).get().getShinseishoKanriNo(), is(申請書管理番号1));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_データ無しを返す() {
            assertThat(sut.selectByKey(申請書管理番号2).isPresent(), is(false));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT4102(申請書管理番号1);
            IItemList<DbT4102NinteiKekkaJohoEntity> modelList = sut.selectAll();
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getShinseishoKanriNo(), is(申請書管理番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_空のリストを返す() {
            assertThat(sut.selectAll().isEmpty(), is(true));
        }
    }

    public static class select直近要介護認定結果情報By申請書管理番号Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT4102(申請書管理番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー値にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select直近要介護認定結果情報By申請書管理番号(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_要介護認定結果情報モデル返す() {
            assertThat(sut.select直近要介護認定結果情報By申請書管理番号(申請書管理番号1).get().getShinseishoKanriNo(), is(申請書管理番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_データ無しを返す() {
            assertThat(sut.select直近要介護認定結果情報By申請書管理番号(申請書管理番号2).isPresent(), is(false));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        // TODO NinteiKekkaJohoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つNinteiKekkaJohoRelateモデルを渡した時_insertは_1を返す() {
            DbT4102NinteiKekkaJohoEntity model = new DbT4102NinteiKekkaJohoEntity();

            assertThat(sut.insert(model), is(1));
        }
    }

    public static class updateTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        // TODO NinteiKekkaJohoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。異なる状態を指定する。
        @Test
        public void モデルの状態がModifiedの時_updateは_1を返す() {
            DbT4102NinteiKekkaJohoEntity model = new DbT4102NinteiKekkaJohoEntity();

            sut.insert(model);

            model.initializeMd5();
            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
            model.setIsDeleted(false);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        // TODO NinteiKekkaJohoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つNinteiKekkaJohoRelateモデルを渡した時_deleteは_1を返す() {
            DbT4102NinteiKekkaJohoEntity model = new DbT4102NinteiKekkaJohoEntity();

            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }

    public static class deletePhysicalTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deletePhysicalは_0を返す() {
            assertThat(sut.deletePhysical(null), is(0));
        }

        // TODO NinteiKekkaJohoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つNinteiKekkaJohoRelateモデルを渡した時_deletePhysicalは_1を返す() {
            DbT4102NinteiKekkaJohoEntity model = new DbT4102NinteiKekkaJohoEntity();

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT4102(ShinseishoKanriNo 申請書管理番号) {
            DbT4102NinteiKekkaJohoEntity entity = DbT4102NinteiKekkaJohoEntityGenerator.createDbT4102NinteiKekkaJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            要介護認定結果情報Dac.save(entity);
        }
    }

}
