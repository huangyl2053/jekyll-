/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.relate;

import jp.co.ndensan.reams.db.dbb.persistence.db.relate.HokenryoDankaiDac;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2012HokenryoRankDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HokenryoDankaiDac}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HokenryoDankaiDacTest {

    private static HokenryoDankaiDac sut;
    private static DbT2013HokenryoDankaiDac 保険料段階Dac;
    private static DbT2012HokenryoRankDac 保険料ランクDac;
    private static final FlexibleYear 賦課年度1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度;
    private static final FlexibleYear 賦課年度2 = new FlexibleYear("2015");
    private static final DankaiIndex 段階インデックス1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス;
    private static final DankaiIndex 段階インデックス2 = new DankaiIndex("06");
    private static final RankKubun ランク区分1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分;
    private static final RankKubun ランク区分2 = new RankKubun("01");
    private static final RString 段階区分1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階区分;
    private static final RString 段階区分2 = new RString("050");
    private static final LasdecCode 市町村コード1 = DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード;
    private static final LasdecCode 市町村コード2 = new LasdecCode("000010");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(HokenryoDankaiDac.class);
        保険料段階Dac = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
        保険料ランクDac = InstanceProvider.create(DbT2012HokenryoRankDac.class);
    }

    public static class select保険料段階ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2013(賦課年度1, 段階インデックス1, ランク区分1, 段階区分1);
            TestSupport.insertDbT2013(賦課年度1, 段階インデックス2, ランク区分1, 段階区分1);
            TestSupport.insertDbT2013(賦課年度2, 段階インデックス1, ランク区分2, 段階区分2);
            TestSupport.insertDbT2013(賦課年度2, 段階インデックス2, ランク区分2, 段階区分2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料段階ByKey(null, 段階インデックス1, ランク区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の段階インデックスにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料段階ByKey(賦課年度1, null, ランク区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のランク区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料段階ByKey(賦課年度1, 段階インデックス1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_保険料段階モデル返す() {
            assertThat(sut.select保険料段階ByKey(賦課年度1, 段階インデックス1, ランク区分1).getFukaNendo(), is(賦課年度1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.select保険料段階ByKey(FlexibleYear.EMPTY, 段階インデックス1, ランク区分1), is(nullValue()));
        }
    }

    public static class select保険料段階一覧_賦課年度Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2013(賦課年度1, 段階インデックス1, ランク区分1, 段階区分1);
            TestSupport.insertDbT2013(賦課年度1, 段階インデックス2, ランク区分1, 段階区分1);
            TestSupport.insertDbT2013(賦課年度2, 段階インデックス1, ランク区分2, 段階区分2);
            TestSupport.insertDbT2013(賦課年度2, 段階インデックス2, ランク区分2, 段階区分2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料段階一覧(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_保険料段階モデルリストを返す() {
            List<DbT2013HokenryoDankaiEntity> modelList = sut.select保険料段階一覧(賦課年度1);
            assertThat(modelList.size(), is(2));
            assertThat(modelList.get(0).getDankaiIndex().toString(), is(段階インデックス1.toString()));
            assertThat(modelList.get(1).getDankaiIndex().toString(), is(段階インデックス2.toString()));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select保険料段階一覧(FlexibleYear.EMPTY).isEmpty(), is(true));
        }
    }

    public static class select保険料段階一覧_賦課年度_段階区分Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2013(賦課年度1, 段階インデックス1, ランク区分1, 段階区分1);
            TestSupport.insertDbT2013(賦課年度1, 段階インデックス2, ランク区分1, 段階区分1);
            TestSupport.insertDbT2013(賦課年度2, 段階インデックス1, ランク区分2, 段階区分2);
            TestSupport.insertDbT2013(賦課年度2, 段階インデックス2, ランク区分2, 段階区分2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料段階一覧(null, 段階区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の段階区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料段階一覧(賦課年度1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_保険料段階モデルリストを返す() {
            List<DbT2013HokenryoDankaiEntity> modelList = sut.select保険料段階一覧(賦課年度1, 段階区分1);
            assertThat(modelList.size(), is(2));
            assertThat(modelList.get(0).getDankaiIndex().toString(), is(段階インデックス1.toString()));
            assertThat(modelList.get(1).getDankaiIndex().toString(), is(段階インデックス2.toString()));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select保険料段階一覧(FlexibleYear.EMPTY, 段階区分1).isEmpty(), is(true));
        }
    }

    public static class select保険料段階一覧_賦課年度_市町村コード_段階区分Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT2013(賦課年度1, 段階インデックス1, ランク区分1, 段階区分1);
            TestSupport.insertDbT2013(賦課年度1, 段階インデックス2, ランク区分1, 段階区分1);
            TestSupport.insertDbT2013(賦課年度2, 段階インデックス1, ランク区分2, 段階区分2);
            TestSupport.insertDbT2013(賦課年度2, 段階インデックス2, ランク区分2, 段階区分2);
            TestSupport.insertDbT2012(賦課年度1, 市町村コード1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料段階一覧(null, 市町村コード1, 段階区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料段階一覧(賦課年度1, null, 段階区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の段階区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select保険料段階一覧(賦課年度1, 市町村コード1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_保険料段階モデルリストを返す() {
            List<DbT2013HokenryoDankaiEntity> modelList = sut.select保険料段階一覧(賦課年度1, 市町村コード1, 段階区分1);
            assertThat(modelList.size(), is(2));
            assertThat(modelList.get(0).getDankaiIndex().toString(), is(段階インデックス1.toString()));
            assertThat(modelList.get(1).getDankaiIndex().toString(), is(段階インデックス2.toString()));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select保険料段階一覧(FlexibleYear.EMPTY, 市町村コード1, 段階区分1).isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つHokenryoDankaiモデルを渡した時_insertは_1を返す() {
            DbT2013HokenryoDankaiEntity model = new DbT2013HokenryoDankaiEntity();

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
            DbT2013HokenryoDankaiEntity model = new DbT2013HokenryoDankaiEntity();

            sut.insert(model);

            model.initializeMd5();
            model.setHokenryoRitsu(Decimal.ZERO);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つHokenryoDankaiモデルを渡した時_deleteは_1を返す() {
            DbT2013HokenryoDankaiEntity model = new DbT2013HokenryoDankaiEntity();

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
        public void 全ての有効なモデルを持つHokenryoDankaiモデルを渡した時_deletePhysicalは_1を返す() {
            DbT2013HokenryoDankaiEntity model = new DbT2013HokenryoDankaiEntity();

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT2013(
                FlexibleYear 賦課年度,
                DankaiIndex 段階インデックス,
                RankKubun ランク区分,
                RString 段階区分) {
            DbT2013HokenryoDankaiEntity entity = new DbT2013HokenryoDankaiEntity();
            entity.setFukaNendo(賦課年度);
            entity.setDankaiIndex(段階インデックス);
            entity.setRankuKubun(ランク区分);
            entity.setDankaiKubun(段階区分);
            保険料段階Dac.save(entity);
        }

        public static void insertDbT2012(
                FlexibleYear 賦課年度,
                LasdecCode 市町村コード) {
            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            entity.setFukaNendo(賦課年度);
            entity.setShichosonCode(市町村コード);
            保険料ランクDac.save(entity);
        }
    }
}
