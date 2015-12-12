/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3045ShokanServicePlan200004EntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
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
 * {@link DbT3045ShokanServicePlan200004Dac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3045ShokanServicePlan200004DacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3045ShokanServicePlan200004Dac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3045ShokanServicePlan200004Dac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert();
            TestSupport.insert();
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3045ShokanServicePlan200004Entity insertedRecord = sut.selectByKey();
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3045ShokanServicePlan200004Entity insertedRecord = sut.selectByKey();
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 償還払請求サービス計画200004が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert();
            TestSupport.insert();
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 償還払請求サービス計画200004が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 償還払請求サービス計画200004エンティティを渡すと_insertは_償還払請求サービス計画200004を追加する() {
            TestSupport.insert();
            assertThat(sut.selectByKey(), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert();
        }

        @Test
        public void 償還払請求サービス計画200004エンティティを渡すと_updateは_償還払請求サービス計画200004を更新する() {
            DbT3045ShokanServicePlan200004Entity updateRecord = sut.selectByKey();
            updateRecord.setSeiriNp(new RString("test"));
            sut.save(updateRecord);
            DbT3045ShokanServicePlan200004Entity updatedRecord = sut.selectByKey();
            assertThat(updateRecord.getSeiriNp(), is(updatedRecord.getSeiriNp()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert();
        }

        @Test
        public void 償還払請求サービス計画200004エンティティを渡すと_deleteは_償還払請求サービス計画200004を削除する() {
            DbT3045ShokanServicePlan200004Entity deletedEntity = sut.selectByKey();
            deletedEntity.setState(EntityDataState.Deleted);
            sut.save(deletedEntity);
            assertThat(sut.selectByKey(), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert() {
            DbT3045ShokanServicePlan200004Entity entity = DbT3045ShokanServicePlan200004EntityGenerator.createDbT3045ShokanServicePlan200004Entity();
            sut.save(entity);
        }
    }
}
