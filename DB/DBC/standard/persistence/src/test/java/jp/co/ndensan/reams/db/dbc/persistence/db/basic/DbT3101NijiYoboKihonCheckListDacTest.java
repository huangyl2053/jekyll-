/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_受付年月日;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
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
 * {@link DbT3101NijiYoboKihonCheckListDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3101NijiYoboKihonCheckListDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3101NijiYoboKihonCheckListDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3101NijiYoboKihonCheckListDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 受付年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3101NijiYoboKihonCheckListEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3101NijiYoboKihonCheckListEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 二次予防基本チェックリストが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 二次予防基本チェックリストが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 二次予防基本チェックリストエンティティを渡すと_insertは_二次予防基本チェックリストを追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 二次予防基本チェックリストエンティティを渡すと_updateは_二次予防基本チェックリストを更新する() {
            DbT3101NijiYoboKihonCheckListEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
            updateRecord.setShitsumonJiko01(75);

            sut.save(updateRecord);

            DbT3101NijiYoboKihonCheckListEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getShitsumonJiko01(), is(updatedRecord.getShitsumonJiko01()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 二次予防基本チェックリストエンティティを渡すと_deleteは_二次予防基本チェックリストを削除する() {
            DbT3101NijiYoboKihonCheckListEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                FlexibleDate 受付年月日,
                int 履歴番号) {
            DbT3101NijiYoboKihonCheckListEntity entity = DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setUketsukeYMD(受付年月日);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
