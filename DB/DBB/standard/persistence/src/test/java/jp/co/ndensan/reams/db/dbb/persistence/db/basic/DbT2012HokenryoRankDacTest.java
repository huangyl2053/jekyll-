/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2012HokenryoRankEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT2012HokenryoRankDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT2012HokenryoRankDacTest extends DbbTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT2012HokenryoRankDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2012HokenryoRankDac.class);
    }

    public static class selectByKeyのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
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
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbbTestDacBase {

        @Test
        public void 保険料ランクが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 保険料ランクが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbbTestDacBase {

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

    public static class updateのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
        }

        @Test
        public void 保険料ランクエンティティを渡すと_updateは_保険料ランクを更新する() {
            DbT2012HokenryoRankEntity updateRecord = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
            updateRecord.setRankKubun(new RankKubun(new RString("3")));

            sut.save(updateRecord);

            DbT2012HokenryoRankEntity updatedRecord = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);

            assertThat(updateRecord.getRankKubun(), is(updatedRecord.getRankKubun()));
        }
    }

    public static class deleteのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
        }

        @Test
        public void 保険料ランクエンティティを渡すと_deleteは_保険料ランクを削除する() {
            DbT2012HokenryoRankEntity deletedEntity = sut.selectByKey(
                    DEFAULT_賦課年度,
                    DEFAULT_市町村コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

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
            sut.save(entity);
        }
    }
}
