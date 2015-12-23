/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7130KaigoServiceShuruiEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_提供開始年月;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link DbT7130KaigoServiceShuruiDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT7130KaigoServiceShuruiDacTest extends DbxTestDacBase {

    private static final KaigoServiceShuruiCode サービス種類コード_01 = new KaigoServiceShuruiCode("01");
    private static final KaigoServiceShuruiCode サービス種類コード_02 = new KaigoServiceShuruiCode("02");
    private static final KaigoServiceShuruiCode サービス種類コード_03 = new KaigoServiceShuruiCode("03");
    private static DbT7130KaigoServiceShuruiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    サービス種類コード_01,
                    DEFAULT_提供開始年月);
            TestSupport.insert(
                    サービス種類コード_02,
                    DEFAULT_提供開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_提供開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void 提供開始年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    null);
        }

        @Test
        public void 存在する主サービス種類コードを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7130KaigoServiceShuruiEntity insertedRecord = sut.selectByKey(
                    サービス種類コード_01,
                    DEFAULT_提供開始年月);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主サービス種類コードを渡すと_selectByKeyは_nullを返す() {
            DbT7130KaigoServiceShuruiEntity insertedRecord = sut.selectByKey(
                    サービス種類コード_03,
                    DEFAULT_提供開始年月);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 介護サービス種類が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    サービス種類コード_01,
                    DEFAULT_提供開始年月);
            TestSupport.insert(
                    サービス種類コード_02,
                    DEFAULT_提供開始年月);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護サービス種類が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 介護サービス種類エンティティを渡すと_insertは_介護サービス種類を追加する() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_提供開始年月);

            assertThat(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_提供開始年月), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_提供開始年月);
        }

        @Test
        public void 介護サービス種類エンティティを渡すと_updateは_介護サービス種類を更新する() {
            DbT7130KaigoServiceShuruiEntity updateRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_提供開始年月);
            updateRecord.setTeikyoshuryoYM(new FlexibleYearMonth("201409"));

            sut.save(updateRecord);

            DbT7130KaigoServiceShuruiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_提供開始年月);

            assertThat(updateRecord.getTeikyoshuryoYM(), is(updatedRecord.getTeikyoshuryoYM()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_提供開始年月);
        }

        @Test
        public void 介護サービス種類エンティティを渡すと_deleteは_介護サービス種類を削除する() {
            DbT7130KaigoServiceShuruiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_提供開始年月);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_提供開始年月), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                KaigoServiceShuruiCode サービス種類コード,
                FlexibleYearMonth 提供開始年月) {
            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            entity.setServiceShuruiCd(サービス種類コード);
            entity.setTeikyoKaishiYM(提供開始年月);
            sut.save(entity);
        }
    }
}
