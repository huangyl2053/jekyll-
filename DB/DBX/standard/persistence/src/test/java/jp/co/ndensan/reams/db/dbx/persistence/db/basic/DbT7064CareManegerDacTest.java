/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7064CareManegerEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7064CareManegerEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
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
 * {@link DbT7064CareManegerDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7064CareManegerDacTest extends DbxTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7064CareManegerDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7064CareManegerDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護支援専門員番号);
            TestSupport.insert(
                    DEFAULT_介護支援専門員番号);
        }

        @Test(expected = NullPointerException.class)
        public void 介護支援専門員番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_介護支援専門員番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7064CareManegerEntity insertedRecord = sut.selectByKey(
                    DEFAULT_介護支援専門員番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7064CareManegerEntity insertedRecord = sut.selectByKey(
                    DEFAULT_介護支援専門員番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 介護支援専門員が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_介護支援専門員番号);
            TestSupport.insert(
                    DEFAULT_介護支援専門員番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護支援専門員が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 介護支援専門員エンティティを渡すと_insertは_介護支援専門員を追加する() {
            TestSupport.insert(
                    DEFAULT_介護支援専門員番号);

            assertThat(sut.selectByKey(
                    DEFAULT_介護支援専門員番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護支援専門員番号);
        }

        @Test
        public void 介護支援専門員エンティティを渡すと_updateは_介護支援専門員を更新する() {
            DbT7064CareManegerEntity updateRecord = sut.selectByKey(
                    DEFAULT_介護支援専門員番号);
            updateRecord.setKaigoShienSenmoninNo(new RString("75"));

            sut.save(updateRecord);

            DbT7064CareManegerEntity updatedRecord = sut.selectByKey(
                    DEFAULT_介護支援専門員番号);

            assertThat(updateRecord.getKaigoShienSenmoninNo(), is(updatedRecord.getKaigoShienSenmoninNo()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護支援専門員番号);
        }

        @Test
        public void 介護支援専門員エンティティを渡すと_deleteは_介護支援専門員を削除する() {
            DbT7064CareManegerEntity deletedEntity = sut.selectByKey(
                    DEFAULT_介護支援専門員番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_介護支援専門員番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 介護支援専門員番号) {
            DbT7064CareManegerEntity entity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            entity.setKaigoShienSenmoninNo(介護支援専門員番号);
            sut.save(entity);
        }
    }
}
