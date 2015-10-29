/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5031NinteiChosaHoshuTankaDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5031NinteiChosaHoshuTankaEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_意見書入手パターン;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_終了年月;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_訪問種別;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_調査区分;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_開始年月;
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
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5031NinteiChosaHoshuTankaDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT5031NinteiChosaHoshuTankaDacTest extends DbeTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5031NinteiChosaHoshuTankaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5031NinteiChosaHoshuTankaDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
            TestSupport.insert(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test(expected = NullPointerException.class)
        public void 調査区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test(expected = NullPointerException.class)
        public void 訪問種別がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書入手パターンがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test(expected = NullPointerException.class)
        public void 開始年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test(expected = NullPointerException.class)
        public void 終了年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5031NinteiChosaHoshuTankaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5031NinteiChosaHoshuTankaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 認定調査報酬単価が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
            TestSupport.insert(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 認定調査報酬単価が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 認定調査報酬単価エンティティを渡すと_insertは_認定調査報酬単価を追加する() {
            TestSupport.insert(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);

            assertThat(sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test
        public void 認定調査報酬単価エンティティを渡すと_updateは_認定調査報酬単価を更新する() {
            DbT5031NinteiChosaHoshuTankaEntity updateRecord = sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT5031NinteiChosaHoshuTankaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
        }

        @Test
        public void 認定調査報酬単価エンティティを渡すと_deleteは_認定調査報酬単価を削除する() {
            DbT5031NinteiChosaHoshuTankaEntity deletedEntity = sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_調査区分,
                    DEFAULT_訪問種別,
                    DEFAULT_意見書入手パターン,
                    DEFAULT_開始年月,
                    DEFAULT_終了年月), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                Code 調査区分,
                Code 訪問種別,
                Code 意見書入手パターン,
                FlexibleYearMonth 開始年月,
                FlexibleYearMonth 終了年月) {
            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.setChosaKubun(調査区分);
            entity.setHomonShubetsu(訪問種別);
            entity.setIkenshoNyushuPatern(意見書入手パターン);
            entity.setKaishiYM(開始年月);
            entity.setShuryoYM(終了年月);
            sut.save(entity);
        }
    }
}
