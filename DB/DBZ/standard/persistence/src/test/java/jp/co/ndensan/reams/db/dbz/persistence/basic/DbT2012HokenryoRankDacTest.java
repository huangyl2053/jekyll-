/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2012HokenryoRankEntityGenerator.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * {@link DbT2012HokenryoRankDac}のテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class DbT2012HokenryoRankDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT2012HokenryoRankDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2012HokenryoRankDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
            TestSupport.insert(
                    DEFAULT_賦課年度.plusYear(1),
                    DEFAULT_市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_賦課年度,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2012HokenryoRankEntity insertedRecord = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2012HokenryoRankEntity insertedRecord = sut.selectByKey(
                    DEFAULT_賦課年度.plusYear(10),
                    DEFAULT_市町村コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 保険料ランクが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
            TestSupport.insert(
                    DEFAULT_賦課年度.plusYear(1),
                    DEFAULT_市町村コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 保険料ランクが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 保険料ランクエンティティを渡すと_insertは_保険料ランクを追加する() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);

            assertThat(sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
        }

        @Test
        public void 保険料ランクエンティティを渡すと_updateは_保険料ランクを更新する() {
            DbT2012HokenryoRankEntity updateRecord = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            updateRecord.setSokyuNendo(FlexibleYear.MAX);

            sut.update(updateRecord);

            DbT2012HokenryoRankEntity updatedRecord = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);

            assertThat(updateRecord.getSokyuNendo(), is(updatedRecord.getSokyuNendo()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
        }

        @Test
        public void 保険料ランクエンティティを渡すと_deleteは_保険料ランクを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード));
            assertThat(sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYear 賦課年度,
                LasdecCode 市町村コード) {
            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            entity.setFukaNendo(賦課年度);
            entity.setShichosonCode(市町村コード);
            sut.insert(entity);
        }
    }
}
