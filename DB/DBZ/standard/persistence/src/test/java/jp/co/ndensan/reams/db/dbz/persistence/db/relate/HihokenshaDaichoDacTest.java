/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import jp.co.ndensan.reams.db.dbz.persistence.db.relate.HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link HihokenshaDaichoDac}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@Ignore
@RunWith(Enclosed.class)
public class HihokenshaDaichoDacTest extends DbzTestDacBase {

    private static HihokenshaDaichoDac sut;
    private static DbT1001HihokenshaDaichoDac 被保険者台帳Dac;
    private static final LasdecCode 市町村コード1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_市町村コード;
    private static final LasdecCode 市町村コード2 = new LasdecCode("202012");
    private static final HihokenshaNo 被保険者番号1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("0000000002");
    private static final FlexibleDate 異動日1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
    private static final FlexibleDate 異動日2 = new FlexibleDate("20150808");
    private static final ShikibetsuCode 識別コード1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_識別コード;
    private static final ShikibetsuCode 識別コード2 = new ShikibetsuCode("000001234567899");
    private static final RString 枝番1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番;
    private static final RString 枝番2 = new RString("002");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(HihokenshaDaichoDac.class);
        被保険者台帳Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    public static class select被保険者台帳ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 異動日1, 識別コード1);
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号2, 異動日2, 識別コード2);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号1, 異動日1, 識別コード1);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号2, 異動日2, 識別コード2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select被保険者台帳ByKey(null, 異動日1, 枝番1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の異動日にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select被保険者台帳ByKey(被保険者番号1, null, 枝番1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の枝番にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select被保険者台帳ByKey(被保険者番号1, 異動日1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_被保険者台帳モデル返す() {
            assertThat(sut.select被保険者台帳ByKey(被保険者番号1, 異動日1, 枝番1).get().getHihokenshaNo(), is(被保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.select被保険者台帳ByKey(new HihokenshaNo("0000000002"), 異動日1, 枝番1).isPresent(), is(false));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void selectAllは_insertしたデータを保持するモデルのリストを返す() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 異動日1, 識別コード1);
            IItemList<DbT1001HihokenshaDaichoEntity> modelList = sut.selectAll();
            assertThat(modelList.anyMatch(new IPredicate<DbT1001HihokenshaDaichoEntity>() {
                @Override
                public boolean evaluate(DbT1001HihokenshaDaichoEntity t) {
                    return t.getHihokenshaNo().equals(被保険者番号1);
                }
            }), is(true));
        }
    }

    public static class select被保険者台帳一覧Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 異動日1, 識別コード1);
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 異動日2, 識別コード2);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号2, 異動日1, 識別コード1);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号2, 異動日2, 識別コード2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select被保険者台帳一覧(null, 被保険者番号1);
        }

        @Test
        public void データが見つかる検索条件を渡すと_被保険者台帳モデルリストを返す() {
            IItemList<DbT1001HihokenshaDaichoEntity> modelList = sut.select被保険者台帳一覧(市町村コード1, 被保険者番号1);
            assertThat(modelList.size(), is(2));
            assertThat(modelList.toList().get(0).getIdoYMD(), is(異動日1));
            assertThat(modelList.toList().get(1).getIdoYMD(), is(異動日2));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select被保険者台帳一覧(new LasdecCode("999999"), 被保険者番号1).isEmpty(), is(true));
        }
    }

    public static class select被保険者台帳一覧DescOrderByShoriTimestamp extends DbzTestDacBase {

        private IItemList<DbT1001HihokenshaDaichoEntity> result;

        private final ShikibetsuCode shikibetsu012345678900001 = new ShikibetsuCode("012345678900001");
        private final ShikibetsuCode shikibetsu012345678900002 = new ShikibetsuCode("012345678900002");
        private final ShikibetsuCode shikibetsu012345678900003 = new ShikibetsuCode("012345678900003");
        private final FlexibleDate 異動日2012 = new FlexibleDate("20120808");
        private final FlexibleDate 異動日2013 = new FlexibleDate("20130808");
        private final FlexibleDate 異動日2014 = new FlexibleDate("20140808");

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 異動日2012, shikibetsu012345678900002);
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 異動日2013, shikibetsu012345678900001);
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 異動日2014, shikibetsu012345678900003);
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
        public void 検索した結果_3件のデータが取得できる() {
            result = sut.select被保険者台帳一覧DescOrderByShoriTimestamp(市町村コード1, 被保険者番号1);
            assertThat(result.size(), is(3));
        }

        @Test
        public void 検索した結果_1件目のデータの識別コードが012345678900003になる() {
            result = sut.select被保険者台帳一覧DescOrderByShoriTimestamp(市町村コード1, 被保険者番号1);
            assertThat(result.toList().get(0).getShikibetsuCode(), is(shikibetsu012345678900003));
        }

        @Test
        public void 検索した結果_2件目のデータの識別コードが012345678900001になる() {
            result = sut.select被保険者台帳一覧DescOrderByShoriTimestamp(市町村コード1, 被保険者番号1);
            assertThat(result.toList().get(1).getShikibetsuCode(), is(shikibetsu012345678900001));
        }

        @Test
        public void 検索した結果_3件目のデータの識別コードが012345678900002になる() {
            result = sut.select被保険者台帳一覧DescOrderByShoriTimestamp(市町村コード1, 被保険者番号1);
            assertThat(result.toList().get(2).getShikibetsuCode(), is(shikibetsu012345678900002));
        }
    }

    public static class select最新被保険者台帳 extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 異動日1, 識別コード1);
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 異動日2, 識別コード1);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号2, 異動日1, 識別コード2);
            TestSupport.insertDbT1001(市町村コード2, 被保険者番号2, 異動日2, 識別コード2);
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
            assertThat(sut.select最新被保険者台帳(市町村コード1, 識別コード1).get().getIdoYMD(), is(異動日2));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.select最新被保険者台帳(new LasdecCode("999999"), 識別コード1).isPresent(), is(false));
        }
    }

    public static class select最新被保険者台帳_被保険者番号Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1001(市町村コード1, 被保険者番号1, 異動日1, 識別コード1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select最新被保険者台帳(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_居宅給付計画事業者作成モデル返す() {
            assertThat(sut.select最新被保険者台帳(被保険者番号1).get().getHihokenshaNo(), is(被保険者番号1));
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
            DbT1001HihokenshaDaichoEntity model = new DbT1001HihokenshaDaichoEntity();

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
            DbT1001HihokenshaDaichoEntity model = new DbT1001HihokenshaDaichoEntity();

            sut.insert(model);

            model.initializeMd5();
            model.setLogicalDeletedFlag(true);

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
            DbT1001HihokenshaDaichoEntity model = new DbT1001HihokenshaDaichoEntity();

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
            DbT1001HihokenshaDaichoEntity model = new DbT1001HihokenshaDaichoEntity();

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT1001(LasdecCode 市町村コード, HihokenshaNo 被保険者番号, FlexibleDate 異動日, ShikibetsuCode 識別コード) {
            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setHihokenshaNo(被保険者番号);
            entity.setIdoYMD(異動日);
            entity.setShikibetsuCode(識別コード);
            被保険者台帳Dac.save(entity);
        }
    }
}
