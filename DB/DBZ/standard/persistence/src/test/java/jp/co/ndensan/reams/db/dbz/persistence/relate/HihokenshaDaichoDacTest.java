/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * {@link HihokenshaDaichoDac}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoDacTest extends DbzTestDacBase {

    private static HihokenshaDaichoDac sut;
    private static DbT1001HihokenshaDaichoDac 被保険者台帳Dac;
    private static final LasdecCode 市町村コード1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_市町村コード;
    private static final LasdecCode 市町村コード2 = new LasdecCode("202012");
    private static final HihokenshaNo 被保険者番号1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("0000000002");
    private static final YMDHMS 処理日時1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_処理日時;
    private static final YMDHMS 処理日時2 = new YMDHMS("20140415102031");
    private static final ShikibetsuCode 識別コード1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_識別コード;
    private static final ShikibetsuCode 識別コード2 = new ShikibetsuCode("000001234567899");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(HihokenshaDaichoDac.class);
        被保険者台帳Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    public static class select被保険者台帳ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 処理日時1, 識別コード1);
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号2, 処理日時2, 識別コード2);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号1, 処理日時1, 識別コード1);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号2, 処理日時2, 識別コード2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select被保険者台帳ByKey(null, 被保険者番号1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select被保険者台帳ByKey(市町村コード1, null, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select被保険者台帳ByKey(市町村コード1, 被保険者番号1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_被保険者台帳モデル返す() {
            assertThat(sut.select被保険者台帳ByKey(市町村コード1, 被保険者番号1, 処理日時1).get().get市町村コード(), is(市町村コード1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.select被保険者台帳ByKey(new LasdecCode("999999"), 被保険者番号1, 処理日時1).isPresent(), is(false));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void selectAllは_insertしたデータを保持するモデルのリストを返す() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 処理日時1, 識別コード1);
            IItemList<HihokenshaDaichoModel> modelList = sut.selectAll();
            assertThat(modelList.anyMatch(new IPredicate<HihokenshaDaichoModel>() {
                @Override
                public boolean evaluate(HihokenshaDaichoModel t) {
                    return t.get市町村コード().equals(市町村コード1);
                }
            }), is(true));
        }
    }

    public static class select被保険者台帳一覧Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 処理日時1, 識別コード1);
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 処理日時2, 識別コード2);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号2, 処理日時1, 識別コード1);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号2, 処理日時2, 識別コード2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select被保険者台帳一覧(null, 被保険者番号1);
        }

        @Test
        public void データが見つかる検索条件を渡すと_被保険者台帳モデルリストを返す() {
            IItemList<HihokenshaDaichoModel> modelList = sut.select被保険者台帳一覧(市町村コード1, 被保険者番号1);
            assertThat(modelList.size(), is(2));
            assertThat(modelList.toList().get(0).get処理日時(), is(処理日時1));
            assertThat(modelList.toList().get(1).get処理日時(), is(処理日時2));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select被保険者台帳一覧(new LasdecCode("999999"), 被保険者番号1).isEmpty(), is(true));
        }
    }

    public static class select最新被保険者台帳 extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 処理日時1, 識別コード1);
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 処理日時2, 識別コード1);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号2, 処理日時1, 識別コード2);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号2, 処理日時2, 識別コード2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の識別コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select最新被保険者台帳(null, 識別コード1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select最新被保険者台帳(市町村コード1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_被保険者台帳モデル返す() {
            assertThat(sut.select最新被保険者台帳(市町村コード1, 識別コード1).get().get処理日時(), is(処理日時2));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.select最新被保険者台帳(new LasdecCode("999999"), 識別コード1).isPresent(), is(false));
        }
    }

    public static class select最新被保険者台帳_被保険者番号Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 処理日時1, 識別コード1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select最新被保険者台帳(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_居宅給付計画事業者作成モデル返す() {
            assertThat(sut.select最新被保険者台帳(被保険者番号1).get().get被保険者番号(), is(被保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_データ無しを返す() {
            assertThat(sut.select最新被保険者台帳(被保険者番号2).isPresent(), is(false));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つHihokenshaDaichoモデルを渡した時_insertは_1を返す() {
            HihokenshaDaichoModel model = new HihokenshaDaichoModel(
                    DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

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
            HihokenshaDaichoModel model = new HihokenshaDaichoModel(
                    DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

            sut.insert(model);

            model.getEntity().initializeMd5();
            model.set資格取得事由(ShikakuShutokuJiyu.合併);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つHihokenshaDaichoモデルを渡した時_deleteは_1を返す() {
            HihokenshaDaichoModel model = new HihokenshaDaichoModel(
                    DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

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
        public void 全ての有効なモデルを持つHihokenshaDaichoモデルを渡した時_deletePhysicalは_1を返す() {
            HihokenshaDaichoModel model = new HihokenshaDaichoModel(
                    DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT1001(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, YMDHMS 処理日時, ShikibetsuCode 識別コード) {
            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setHihokenshaNo(被保険者番号);
            entity.setShoriTimestamp(処理日時);
            entity.setShikibetsuCode(識別コード);
            被保険者台帳Dac.insert(entity);
        }
    }
}
