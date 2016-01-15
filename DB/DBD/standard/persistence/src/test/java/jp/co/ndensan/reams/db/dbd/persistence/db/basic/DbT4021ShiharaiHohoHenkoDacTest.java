/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntityGenerator;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_管理区分;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_証記載保険者番号;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
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
 * {@link DbT4021ShiharaiHohoHenkoDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT4021ShiharaiHohoHenkoDacTest extends DbdTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT4021ShiharaiHohoHenkoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
    }

    public static class selectByKeyのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 管理区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT4021ShiharaiHohoHenkoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT4021ShiharaiHohoHenkoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbdTestDacBase {

        @Test
        public void 支払方法変更が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 支払方法変更が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbdTestDacBase {

        @Test
        public void 支払方法変更エンティティを渡すと_insertは_支払方法変更を追加する() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 支払方法変更エンティティを渡すと_updateは_支払方法変更を更新する() {
            DbT4021ShiharaiHohoHenkoEntity updateRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
//            updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT4021ShiharaiHohoHenkoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);

//            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 支払方法変更エンティティを渡すと_deleteは_支払方法変更を削除する() {
            DbT4021ShiharaiHohoHenkoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShoKisaiHokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                RString 管理区分,
                int 履歴番号) {
            DbT4021ShiharaiHohoHenkoEntity entity = DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setKanriKubun(管理区分);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
