/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.JukyushaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaDaichoDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class JukyushaDaichoDacTest {

    private static JukyushaDaichoDac sut;
    private static DbT4001JukyushaDaichoDac 受給者台帳Dac;

    private static final ShoKisaiHokenshaNo 証記載保険者番号1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_証記載保険者番号;
    private static final ShoKisaiHokenshaNo 証記載保険者番号2 = new ShoKisaiHokenshaNo("124562");
    private static final HihokenshaNo 被保険者番号1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("987654");
    private static final ShinseishoKanriNo 申請書管理番号1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書管理番号;
    private static final ShinseishoKanriNo 申請書管理番号2 = new ShinseishoKanriNo("222");
    private static final YMDHMS 処理日時1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_処理日時;
    private static final YMDHMS 処理日時2 = new YMDHMS("20140101102040");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(JukyushaDaichoDac.class);
        受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    public static class selectByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT4001(証記載保険者番号1, 被保険者番号1, 申請書管理番号1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyTest_引数の証記載保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(null, 被保険者番号1, 申請書管理番号1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyTest_引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(証記載保険者番号1, null, 申請書管理番号1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyTest_引数の申請書管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(証記載保険者番号1, 被保険者番号1, null, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyTest_引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(証記載保険者番号1, 被保険者番号1, 申請書管理番号1, null);
        }

        // TODO 見つかる場合、受給者台帳モデルを構成している全てのモデルクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void selectByKeyTest_データが見つかる検索条件を渡すと_受給者台帳モデル返す() {
            assertThat(sut.selectByKey(証記載保険者番号1, 被保険者番号1, 申請書管理番号1, 処理日時1).get証記載保険者番号(), is(証記載保険者番号1));
        }

        @Test
        public void selectByKeyTest_データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.selectByKey(証記載保険者番号2, 被保険者番号1, 申請書管理番号1, 処理日時1), is(nullValue()));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void selectAll_データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT4001(証記載保険者番号1, 被保険者番号1, 申請書管理番号1, 処理日時1);
            IItemList<JukyushaDaichoModel> modelList = sut.selectAll();
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).get証記載保険者番号(), is(証記載保険者番号1));
        }

        @Test
        public void selectAll_データが見つかない検索条件を渡すと_空のリストを返す() {
            assertThat(sut.selectAll().isEmpty(), is(true));
        }
    }

    public static class select受給者台帳履歴By被保険者番号Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT4001(証記載保険者番号1, 被保険者番号1, 申請書管理番号1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void select受給者台帳履歴By被保険者番号Test_引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select受給者台帳履歴By被保険者番号(null);
        }

        @Test
        public void select受給者台帳履歴By被保険者番号Test_データが見つかる検索条件を渡すと_台帳モデルリストを返す() {
            IItemList<JukyushaDaichoModel> modelList = sut.select受給者台帳履歴By被保険者番号(被保険者番号1);
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.findFirst().get().get証記載保険者番号(), is(証記載保険者番号1));
        }

        @Test
        public void select受給者台帳履歴By被保険者番号Test_データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select受給者台帳履歴By被保険者番号(被保険者番号2).isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        // TODO JukyushaDaichoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つJukyushaDaichoRelateモデルを渡した時_insertは_1を返す() {
            JukyushaDaichoModel model = new JukyushaDaichoModel(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());

            assertThat(sut.insert(model), is(1));
        }
    }

    public static class updateTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        // TODO JukyushaDaichoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。異なる状態を指定する。
        @Test
        public void モデルの状態がModifiedの時_updateは_1を返す() {
            JukyushaDaichoModel model = new JukyushaDaichoModel(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());

            sut.insert(model);

            model.getEntity().initializeMd5();
            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
            model.set短期入所支給限度日数(2);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        // TODO JukyushaDaichoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つJukyushaDaichoRelateモデルを渡した時_deleteは_1を返す() {
            JukyushaDaichoModel model = new JukyushaDaichoModel(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());

            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }

    public static class deletePhysicalTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deletePhysicalは_0を返す() {
            assertThat(sut.deletePhysical(null), is(0));
        }

        // TODO JukyushaDaichoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つJukyushaDaichoRelateモデルを渡した時_deletePhysicalは_1を返す() {
            JukyushaDaichoModel model = new JukyushaDaichoModel(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT4001(
                ShoKisaiHokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                ShinseishoKanriNo 申請書管理番号,
                YMDHMS 処理日時) {
            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setShoriTimeStamp(処理日時);
            受給者台帳Dac.insert(entity);
        }
    }
}
