/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5116IchijiHanteiKekkaJohoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5116IchijiHanteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
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
 * {@link DbT5116IchijiHanteiKekkaJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT5116IchijiHanteiKekkaJohoDacTest extends DbeTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5116IchijiHanteiKekkaJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5116IchijiHanteiKekkaJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert();
            TestSupport.insert();
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5116IchijiHanteiKekkaJohoEntity insertedRecord = sut.selectByKey();
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5116IchijiHanteiKekkaJohoEntity insertedRecord = sut.selectByKey();
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 要介護認定一次判定結果情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert();
            TestSupport.insert();
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 要介護認定一次判定結果情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 要介護認定一次判定結果情報エンティティを渡すと_insertは_要介護認定一次判定結果情報を追加する() {
            TestSupport.insert();

            assertThat(sut.selectByKey(), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert();
        }

        @Test
        public void 要介護認定一次判定結果情報エンティティを渡すと_updateは_要介護認定一次判定結果情報を更新する() {
            DbT5116IchijiHanteiKekkaJohoEntity updateRecord = sut.selectByKey();
            // TODO  主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT5116IchijiHanteiKekkaJohoEntity updatedRecord = sut.selectByKey();

            // TODO  主キー以外の項目を変更してください
            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert();
        }

        @Test
        public void 要介護認定一次判定結果情報エンティティを渡すと_deleteは_要介護認定一次判定結果情報を削除する() {
            DbT5116IchijiHanteiKekkaJohoEntity deletedEntity = sut.selectByKey();
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert() {
            DbT5116IchijiHanteiKekkaJohoEntity entity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();

            sut.save(entity);
        }
    }
}
