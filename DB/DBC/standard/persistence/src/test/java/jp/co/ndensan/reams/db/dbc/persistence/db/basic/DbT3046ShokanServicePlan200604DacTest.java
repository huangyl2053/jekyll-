/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3046ShokanServicePlan200604EntityGenerator;
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
 * {@link DbT3046ShokanServicePlan200604Dac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3046ShokanServicePlan200604DacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3046ShokanServicePlan200604Dac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3046ShokanServicePlan200604Dac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert();
            TestSupport.insert();
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3046ShokanServicePlan200604Entity insertedRecord = sut.selectByKey();
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3046ShokanServicePlan200604Entity insertedRecord = sut.selectByKey();
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 償還払請求サービス計画200604が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert();
            TestSupport.insert();
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 償還払請求サービス計画200604が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 償還払請求サービス計画200604エンティティを渡すと_insertは_償還払請求サービス計画200604を追加する() {
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
        public void 償還払請求サービス計画200604エンティティを渡すと_updateは_償還払請求サービス計画200604を更新する() {
            DbT3046ShokanServicePlan200604Entity updateRecord = sut.selectByKey();
            updateRecord.setFushikyuRiyu(new RString("test"));

            sut.save(updateRecord);

            DbT3046ShokanServicePlan200604Entity updatedRecord = sut.selectByKey();

            assertThat(updateRecord.getFushikyuRiyu(), is(updatedRecord.getFushikyuRiyu()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert();
        }

        @Test
        public void 償還払請求サービス計画200604エンティティを渡すと_deleteは_償還払請求サービス計画200604を削除する() {
            DbT3046ShokanServicePlan200604Entity deletedEntity = sut.selectByKey();
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert() {
            DbT3046ShokanServicePlan200604Entity entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();

            sut.save(entity);
        }
    }
}
