/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5032ShujiiIkenshoHoshuTankaEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_在宅施設区分;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_意見書作成回数区分;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_開始年月;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5032ShujiiIkenshoHoshuTankaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link DbT5032ShujiiIkenshoHoshuTankaDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT5032ShujiiIkenshoHoshuTankaDacTest extends DbeTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5032ShujiiIkenshoHoshuTankaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5032ShujiiIkenshoHoshuTankaDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
            TestSupport.insert(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void 在宅施設区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書作成回数区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void 開始年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5032ShujiiIkenshoHoshuTankaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5032ShujiiIkenshoHoshuTankaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 意見書作成報酬単価が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
            TestSupport.insert(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 意見書作成報酬単価が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 意見書作成報酬単価エンティティを渡すと_insertは_意見書作成報酬単価を追加する() {
            TestSupport.insert(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);

            assertThat(sut.selectByKey(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
        }

        @Test
        public void 意見書作成報酬単価エンティティを渡すと_updateは_意見書作成報酬単価を更新する() {
            DbT5032ShujiiIkenshoHoshuTankaEntity updateRecord = sut.selectByKey(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT5032ShujiiIkenshoHoshuTankaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
        }

        @Test
        public void 意見書作成報酬単価エンティティを渡すと_deleteは_意見書作成報酬単価を削除する() {
            DbT5032ShujiiIkenshoHoshuTankaEntity deletedEntity = sut.selectByKey(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_在宅施設区分,
                    DEFAULT_意見書作成回数区分,
                    DEFAULT_開始年月), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                Code 在宅施設区分,
                Code 意見書作成回数区分,
                FlexibleYearMonth 開始年月) {
            DbT5032ShujiiIkenshoHoshuTankaEntity entity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
            entity.setZaitakuShisetsuKubun(在宅施設区分);
            entity.setIkenshoSakuseiKaisuKubun(意見書作成回数区分);
            entity.setKaishiYM(開始年月);
            sut.save(entity);
        }
    }
}
