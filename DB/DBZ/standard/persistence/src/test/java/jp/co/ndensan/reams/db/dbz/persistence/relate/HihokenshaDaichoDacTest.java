/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link HihokenshaDaichoDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoDacTest {

    private static HihokenshaDaichoDac sut;
    private static DbT1001HihokenshaDaichoDac 被保険者台帳Dac;
    private static final LasdecCode 市町村コード1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_市町村コード;
    private static final LasdecCode 市町村コード2 = new LasdecCode("123456");
    private static final HihokenshaNo 被保険者番号1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("0000000002");
    private static final HihokenshaNo 被保険者番号3 = new HihokenshaNo("0000000003");
    private static final YMDHMS 処理日時1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_処理日時;
    private static final YMDHMS 処理日時2 = new YMDHMS(new RString("20140415102040"));

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(HihokenshaDaichoDac.class);
        被保険者台帳Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    public static class selectByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 処理日時1);
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号2, 処理日時2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(null, 被保険者番号1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(市町村コード1, null, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(市町村コード1, 被保険者番号1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_被保険者台帳モデル返す() {
            assertThat(sut.selectByKey(市町村コード1, 被保険者番号1, 処理日時1).get市町村コード(), is(市町村コード1));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.selectByKey(市町村コード2, 被保険者番号1, 処理日時1), is(nullValue()));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 処理日時1);
            IItemList<HihokenshaDaichoModel> modelList = sut.selectAll();
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).get市町村コード(), is(市町村コード1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_空のリストを返す() {
            assertThat(sut.selectAll().isEmpty(), is(true));
        }
    }

    public static class select直近被保険者台帳Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select直近被保険者台帳(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_居宅給付計画事業者作成モデル返す() {
            assertThat(sut.select直近被保険者台帳(被保険者番号1).get().get被保険者番号(), is(被保険者番号1));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.select直近被保険者台帳(被保険者番号2), is(nullValue()));
        }

    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        // TODO HihokenshaDaichoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つHihokenshaDaichoモデルを渡した時_insertは_1を返す() {
            HihokenshaDaichoModel model = new HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

            assertThat(sut.insert(model), is(1));
        }
    }

    public static class updateTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        // TODO HihokenshaDaichoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。異なる状態を指定する。
        @Test
        public void モデルの状態がModifiedの時_updateは_1を返す() {
            HihokenshaDaichoModel model = new HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

            sut.insert(model);

            model.getEntity().initializeMd5();
            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
            model.set再交付区分(new RString("9"));

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        // TODO HihokenshaDaichoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つHihokenshaDaichoモデルを渡した時_deleteは_1を返す() {
            HihokenshaDaichoModel model = new HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }

    public static class deletePhysicalTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deletePhysicalは_0を返す() {
            assertThat(sut.deletePhysical(null), is(0));
        }

        // TODO HihokenshaDaichoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つHihokenshaDaichoモデルを渡した時_deletePhysicalは_1を返す() {
            HihokenshaDaichoModel model = new HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT1001(
                LasdecCode 市町村コード,
                HihokenshaNo 被保険者番号,
                YMDHMS 処理日時) {
            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setHihokenshaNo(被保険者番号);
            entity.setShoriTimestamp(処理日時);
            被保険者台帳Dac.insert(entity);
        }
    }

}
