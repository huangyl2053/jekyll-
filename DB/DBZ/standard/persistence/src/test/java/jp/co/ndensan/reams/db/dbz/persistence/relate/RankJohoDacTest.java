/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2011RankJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.RankJohoModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2011RankJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * {@link RankJohoDac}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class RankJohoDacTest {

    private static RankJohoDac sut;
    private static DbT2011RankJohoDac ランク情報Dac;
    private static final FlexibleYear 賦課年度1 = DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度;
    private static final FlexibleYear 賦課年度2 = DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度.plusYear(1);
    private static final RankKubun ランク区分1 = DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分;
    private static final RankKubun ランク区分2 = new RankKubun(new RString("02"));

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(RankJohoDac.class);
        ランク情報Dac = InstanceProvider.create(DbT2011RankJohoDac.class);
    }

    public static class selectランク情報ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2011(賦課年度1, ランク区分1);
            TestSupport.insertDbT2011(賦課年度1, ランク区分2);
            TestSupport.insertDbT2011(賦課年度2, ランク区分1);
            TestSupport.insertDbT2011(賦課年度2, ランク区分2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectランク情報ByKey(null, ランク区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のランク区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectランク情報ByKey(賦課年度1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_ランク情報モデル返す() {
            assertThat(sut.selectランク情報ByKey(賦課年度1, ランク区分1).get賦課年度(), is(賦課年度1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.selectランク情報ByKey(FlexibleYear.MAX, ランク区分1), is(nullValue()));
        }
    }

    public static class selectランク情報一覧Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2011(賦課年度1, ランク区分1);
            TestSupport.insertDbT2011(賦課年度1, ランク区分2);
            TestSupport.insertDbT2011(賦課年度2, ランク区分1);
            TestSupport.insertDbT2011(賦課年度2, ランク区分2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectランク情報一覧(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_ランク情報モデルリストを返す() {
            List<RankJohoModel> modelList = sut.selectランク情報一覧(賦課年度1);
            assertThat(modelList.size(), is(2));
            assertThat(modelList.get(0).getランク区分(), is(ランク区分1));
            assertThat(modelList.get(1).getランク区分(), is(ランク区分2));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.selectランク情報一覧(FlexibleYear.MIN).isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つRankJohoモデルを渡した時_insertは_1を返す() {
            RankJohoModel model = new RankJohoModel(
                    DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity());

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
            RankJohoModel model = new RankJohoModel(
                    DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity());

            sut.insert(model);

            model.getEntity().initializeMd5();
            model.setランク名称(new RString("ランク名称変更"));

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つRankJohoモデルを渡した時_deleteは_1を返す() {
            RankJohoModel model = new RankJohoModel(
                    DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity());

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
        public void 全ての有効なモデルを持つRankJohoモデルを渡した時_deletePhysicalは_1を返す() {
            RankJohoModel model = new RankJohoModel(
                    DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity());

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT2011(
                FlexibleYear 賦課年度,
                RankKubun ランク区分) {
            DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            entity.setFukaNendo(賦課年度);
            entity.setRankKubun(ランク区分);
            ランク情報Dac.insert(entity);
        }
    }
}
