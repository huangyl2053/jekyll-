/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2011RankJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2011RankJohoEntityGenerator.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * {@link DbT2011RankJohoDac}のテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class DbT2011RankJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT2011RankJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2011RankJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_ランク区分);
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度.plusYear(1)),
                    DEFAULT_ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void ランク区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2011RankJohoEntity insertedRecord = sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_ランク区分);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2011RankJohoEntity insertedRecord = sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度.plusYear(10)),
                    DEFAULT_ランク区分);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void ランク情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_ランク区分);
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度.plusYear(1)),
                    DEFAULT_ランク区分);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void ランク情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void ランク情報エンティティを渡すと_insertは_ランク情報を追加する() {
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_ランク区分);

            assertThat(sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_ランク区分), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_ランク区分);
        }

        @Test
        public void ランク情報エンティティを渡すと_updateは_ランク情報を更新する() {
            DbT2011RankJohoEntity updateRecord = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            updateRecord.setRankName(new RString("ランク名称変更"));

            sut.update(updateRecord);

            DbT2011RankJohoEntity updatedRecord = sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_ランク区分);

            assertThat(updateRecord.getRankName(), is(updatedRecord.getRankName()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_ランク区分);
        }

        @Test
        public void ランク情報エンティティを渡すと_deleteは_ランク情報を削除する() {
            sut.delete(sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_ランク区分));
            assertThat(sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_ランク区分), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FukaNendo 賦課年度,
                RankKubun ランク区分) {
            DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            entity.setFukaNendo(賦課年度.value());
            entity.setRankKubun(ランク区分);
            sut.insert(entity);
        }
    }
}
