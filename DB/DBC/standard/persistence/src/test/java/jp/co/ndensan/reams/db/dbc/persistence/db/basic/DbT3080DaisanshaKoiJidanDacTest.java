/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3080DaisanshaKoiJidanEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3080DaisanshaKoiJidanEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3080DaisanshaKoiJidanEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link DbT3080DaisanshaKoiJidanDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3080DaisanshaKoiJidanDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3080DaisanshaKoiJidanDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3080DaisanshaKoiJidanDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 第三者行為届出管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 示談報告書受付年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3080DaisanshaKoiJidanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3080DaisanshaKoiJidanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 介護第三者行為示談が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護第三者行為示談が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 介護第三者行為示談エンティティを渡すと_insertは_介護第三者行為示談を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 介護第三者行為示談エンティティを渡すと_updateは_介護第三者行為示談を更新する() {
            DbT3080DaisanshaKoiJidanEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
            updateRecord.setJidanHokokushoTeishutsuYMD(new FlexibleDate("20100110"));

            sut.save(updateRecord);

            DbT3080DaisanshaKoiJidanEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getJidanHokokushoTeishutsuYMD(), is(updatedRecord.getJidanHokokushoTeishutsuYMD()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 介護第三者行為示談エンティティを渡すと_deleteは_介護第三者行為示談を削除する() {
            DbT3080DaisanshaKoiJidanEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_示談報告書受付年月日,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                RString 第三者行為届出管理番号,
                FlexibleDate 示談報告書受付年月日,
                Decimal 履歴番号) {
            DbT3080DaisanshaKoiJidanEntity entity = DbT3080DaisanshaKoiJidanEntityGenerator.createDbT3080DaisanshaKoiJidanEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setTodokedeKanriNo(第三者行為届出管理番号);
            entity.setJidanHokokushoUketukeYMD(示談報告書受付年月日);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
