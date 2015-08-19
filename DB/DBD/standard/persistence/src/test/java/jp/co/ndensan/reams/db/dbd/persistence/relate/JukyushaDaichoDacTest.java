/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.relate;

import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaDaichoDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
//TODO n8235 船山洋介 受給者台帳・認定申請結果情報・認定申請情報のテーブルが変更されたため、最新化が必要
@RunWith(Enclosed.class)
public class JukyushaDaichoDacTest {

    private static JukyushaDaichoDac sut;
    private static DbT4001JukyushaDaichoDac 受給者台帳Dac;
    private static final LasdecCode 市町村コード1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード;
    private static final LasdecCode 市町村コード2 = new LasdecCode("124562");
    private static final HihokenshaNo 被保険者番号1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("987654");
    private static final RString 履歴番号1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号;
    private static final RString 履歴番号2 = new RString("002");
    private static final RString 枝番1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_枝番;
    private static final RString 枝番2 = new RString("002");
    private static final Code 受給申請事由1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由;
    private static final Code 受給申請事由2 = new Code("1");
    private static final ShinseishoKanriNo 申請書管理番号1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書管理番号;
    private static final ShinseishoKanriNo 申請書管理番号2 = new ShinseishoKanriNo("222");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(JukyushaDaichoDac.class);
        受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    public static class selectByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT4001(市町村コード1, 被保険者番号1, 履歴番号1, 枝番1, 受給申請事由1);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyTest_引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(null, 被保険者番号1, 履歴番号1, 枝番1, 受給申請事由1);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyTest_引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(市町村コード1, null, 履歴番号1, 枝番1, 受給申請事由1);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyTest_引数の履歴番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(市町村コード1, 被保険者番号1, null, 枝番1, 受給申請事由1);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyTest_引数の枝番にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(市町村コード1, 被保険者番号1, 履歴番号1, null, 受給申請事由1);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyTest_引数の受給申請事由にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(市町村コード1, 被保険者番号1, 履歴番号1, 枝番1, null);
        }

        // TODO 見つかる場合、受給者台帳モデルを構成している全てのモデルクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void selectByKeyTest_データが見つかる検索条件を渡すと_受給者台帳モデル返す() {
            assertThat(sut.selectByKey(市町村コード1, 被保険者番号1, 履歴番号1, 枝番1, 受給申請事由1).get().getShichosonCode(), is(市町村コード1));
        }

        @Test
        public void selectByKeyTest_データが見つかない検索条件を渡すと_データ無しを返す() {
            assertThat(sut.selectByKey(市町村コード2, 被保険者番号2, 履歴番号2, 枝番2, 受給申請事由2).isPresent(), is(false));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void selectAll_データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT4001(市町村コード1, 被保険者番号1, 履歴番号1, 枝番1, 受給申請事由1);
            IItemList<DbT4001JukyushaDaichoEntity> modelList = sut.selectAll();
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getShichosonCode(), is(市町村コード1));
        }

        @Test
        public void selectAll_データが見つかない検索条件を渡すと_空のリストを返す() {
            assertThat(sut.selectAll().isEmpty(), is(true));
        }
    }

    public static class select受給者台帳履歴By被保険者番号Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT4001(市町村コード1, 被保険者番号1, 履歴番号1, 枝番1, 受給申請事由1);
        }

        @Test(expected = NullPointerException.class)
        public void select受給者台帳履歴By被保険者番号Test_引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select受給者台帳履歴By被保険者番号(null);
        }

        @Test
        public void select受給者台帳履歴By被保険者番号Test_データが見つかる検索条件を渡すと_台帳モデルリストを返す() {
            IItemList<DbT4001JukyushaDaichoEntity> modelList = sut.select受給者台帳履歴By被保険者番号(被保険者番号1);
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.findFirst().get().getShichosonCode(), is(市町村コード1));
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
            DbT4001JukyushaDaichoEntity model = new DbT4001JukyushaDaichoEntity();

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
            DbT4001JukyushaDaichoEntity model = new DbT4001JukyushaDaichoEntity();

            sut.insert(model);

            model.initializeMd5();
            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
            model.setChokkinFlag(true);

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
            DbT4001JukyushaDaichoEntity model = new DbT4001JukyushaDaichoEntity();

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
            DbT4001JukyushaDaichoEntity model = new DbT4001JukyushaDaichoEntity();

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT4001(
                LasdecCode 市町村コード,
                HihokenshaNo 被保険者番号,
                RString 履歴番号,
                RString 枝番,
                Code 受給申請事由) {
            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            entity.setEdaban(枝番);
            entity.setJukyuShinseiJiyu(受給申請事由);
            受給者台帳Dac.save(entity);
        }
    }
}
