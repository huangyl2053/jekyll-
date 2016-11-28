/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2013HokenryoDankaiDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT2013HokenryoDankaiDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT2013HokenryoDankaiDacTest extends DbbTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT2013HokenryoDankaiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
    }

    public static class selectByKeyのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 段階インデックスがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void ランク区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2013HokenryoDankaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2013HokenryoDankaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbbTestDacBase {

        @Test
        public void 保険料段階が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 保険料段階が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbbTestDacBase {

        @Test
        public void 保険料段階エンティティを渡すと_insertは_保険料段階を追加する() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);

            assertThat(sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
        }

        @Test
        public void 保険料段階エンティティを渡すと_updateは_保険料段階を更新する() {
            DbT2013HokenryoDankaiEntity updateRecord = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            updateRecord.setRankuKubun(new RString("2"));

            sut.save(updateRecord);

            DbT2013HokenryoDankaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);

            assertThat(updateRecord.getRankuKubun(), is(updatedRecord.getRankuKubun()));
        }
    }

    public static class deleteのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
        }

        @Test
        public void 保険料段階エンティティを渡すと_deleteは_保険料段階を削除する() {
            DbT2013HokenryoDankaiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYear 賦課年度,
                RString 段階インデックス,
                RString ランク区分) {
            DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            entity.setFukaNendo(賦課年度);
            entity.setDankaiIndex(段階インデックス);
            entity.setRankuKubun(ランク区分);
            sut.save(entity);
        }
    }
}
