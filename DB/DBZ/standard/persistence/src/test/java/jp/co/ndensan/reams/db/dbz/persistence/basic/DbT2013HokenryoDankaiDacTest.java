/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * {@link DbT2013HokenryoDankaiDac}のテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class DbT2013HokenryoDankaiDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT2013HokenryoDankaiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            TestSupport.insert(
                    DEFAULT_賦課年度.plusYear(1),
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 段階インデックスがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_賦課年度,
                    null,
                    DEFAULT_ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void ランク区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    null);
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
                    DEFAULT_賦課年度.plusYear(10),
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 保険料段階が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            TestSupport.insert(
                    DEFAULT_賦課年度.plusYear(1),
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 保険料段階が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

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

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
        }

        @Test
        public void 保険料段階エンティティを渡すと_updateは_保険料段階を更新する() {
            DbT2013HokenryoDankaiEntity updateRecord = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            updateRecord.setHokenryoRitsu(Decimal.ZERO);

            sut.update(updateRecord);

            DbT2013HokenryoDankaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);

            assertThat(updateRecord.getHokenryoRitsu(), is(updatedRecord.getHokenryoRitsu()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分);
        }

        @Test
        public void 保険料段階エンティティを渡すと_deleteは_保険料段階を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_段階インデックス,
                    DEFAULT_ランク区分));
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
            sut.insert(entity);
        }
    }
}
