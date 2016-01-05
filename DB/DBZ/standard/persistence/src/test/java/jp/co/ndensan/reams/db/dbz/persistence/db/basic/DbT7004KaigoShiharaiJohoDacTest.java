/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7004KaigoShiharaiJohoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7004KaigoShiharaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7004KaigoShiharaiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_決定年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_科目コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_識別コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7004KaigoShiharaiJohoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7004KaigoShiharaiJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7004KaigoShiharaiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7004KaigoShiharaiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 科目コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 決定年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7004KaigoShiharaiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7004KaigoShiharaiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護支払情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護支払情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護支払情報エンティティを渡すと_insertは_介護支払情報を追加する() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
        }

        @Test
        public void 介護支払情報エンティティを渡すと_updateは_介護支払情報を更新する() {
            DbT7004KaigoShiharaiJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7004KaigoShiharaiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
        }

        @Test
        public void 介護支払情報エンティティを渡すと_deleteは_介護支払情報を削除する() {
            DbT7004KaigoShiharaiJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_科目コード,
                    DEFAULT_決定年月日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShikibetsuCode 識別コード,
                KamokuCode 科目コード,
                FlexibleDate 決定年月日) {
            DbT7004KaigoShiharaiJohoEntity entity = DbT7004KaigoShiharaiJohoEntityGenerator.createDbT7004KaigoShiharaiJohoEntity();
            entity.setShikibetsuCode(識別コード);
            entity.setKamokuCode(科目コード);
            entity.setKetteiYMD(決定年月日);
            sut.save(entity);
        }
    }
}
