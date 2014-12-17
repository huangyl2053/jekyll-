/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.HokenryoRankModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2012HokenryoRankDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {@link HokenryoRankDac}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HokenryoRankDacTest {

    private static HokenryoRankDac sut;
    private static DbT2012HokenryoRankDac 保険料ランクDac;
    private static final FlexibleYear 賦課年度1 = DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度;
    private static final FlexibleYear 賦課年度2 = DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度.plusYear(1);
    private static final LasdecCode 市町村コード1 = DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード;
    private static final LasdecCode 市町村コード2 = new LasdecCode("000010");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(HokenryoRankDac.class);
        保険料ランクDac = InstanceProvider.create(DbT2012HokenryoRankDac.class);
    }

    public static class select保険料ランクByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2012(賦課年度1, 市町村コード1);
            TestSupport.insertDbT2012(賦課年度1, 市町村コード2);
            TestSupport.insertDbT2012(賦課年度2, 市町村コード1);
            TestSupport.insertDbT2012(賦課年度2, 市町村コード2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料ランクByKey(null, 市町村コード1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料ランクByKey(賦課年度1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_保険料ランクモデル返す() {
            assertThat(sut.select保険料ランクByKey(賦課年度1, 市町村コード1).get賦課年度(), is(賦課年度1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.select保険料ランクByKey(FlexibleYear.MAX, 市町村コード1), is(nullValue()));
        }
    }

    public static class select保険料ランク一覧Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2012(賦課年度1, 市町村コード1);
            TestSupport.insertDbT2012(賦課年度1, 市町村コード2);
            TestSupport.insertDbT2012(賦課年度2, 市町村コード1);
            TestSupport.insertDbT2012(賦課年度2, 市町村コード2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料ランク一覧(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_保険料ランクモデルリストを返す() {
            List<HokenryoRankModel> modelList = sut.select保険料ランク一覧(賦課年度1);
            assertThat(modelList.size(), is(2));
            assertThat(modelList.get(0).get市町村コード(), is(市町村コード1));
            assertThat(modelList.get(1).get市町村コード(), is(市町村コード2));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select保険料ランク一覧(FlexibleYear.MIN).isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つHokenryoRankモデルを渡した時_insertは_1を返す() {
            HokenryoRankModel model = new HokenryoRankModel(
                    DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity());

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
            HokenryoRankModel model = new HokenryoRankModel(
                    DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity());

            sut.insert(model);

            model.getEntity().initializeMd5();
            model.set遡及年度(FlexibleYear.MAX);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つHokenryoRankモデルを渡した時_deleteは_1を返す() {
            HokenryoRankModel model = new HokenryoRankModel(
                    DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity());

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
        public void 全ての有効なモデルを持つHokenryoRankモデルを渡した時_deletePhysicalは_1を返す() {
            HokenryoRankModel model = new HokenryoRankModel(
                    DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity());

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT2012(
                FlexibleYear 賦課年度,
                LasdecCode 市町村コード) {
            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            entity.setFukaNendo(賦課年度);
            entity.setShichosonCode(市町村コード);
            保険料ランクDac.insert(entity);
        }
    }

}
