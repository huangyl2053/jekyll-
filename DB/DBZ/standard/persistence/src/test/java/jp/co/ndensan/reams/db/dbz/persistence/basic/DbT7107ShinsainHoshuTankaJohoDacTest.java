/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7107ShinsainHoshuTankaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7107ShinsainHoshuTankaJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_合議体長区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_報酬単価適用終了年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7107ShinsainHoshuTankaJohoEntityGenerator.DEFAULT_報酬単価適用開始年月日;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link DbT7107ShinsainHoshuTankaJohoDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7107ShinsainHoshuTankaJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final FlexibleDate 報酬単価適用開始年月日 = new FlexibleDate("20140401");
    private static final FlexibleDate 報酬単価適用開始年月日20140403 = new FlexibleDate("20140403");
    private static DbT7107ShinsainHoshuTankaJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7107ShinsainHoshuTankaJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);
            TestSupport.insert(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);
        }

        @Test(expected = NullPointerException.class)
        public void 報酬単価適用開始年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);
        }

        @Test(expected = NullPointerException.class)
        public void 報酬単価適用終了年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    null,
                    DEFAULT_合議体長区分);
        }

        @Test(expected = NullPointerException.class)
        public void 合議体長区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7107ShinsainHoshuTankaJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7107ShinsainHoshuTankaJohoEntity insertedRecord = sut.selectByKey(
                    報酬単価適用開始年月日20140403,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 要介護認定審査員報酬単価情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);
            TestSupport.insert(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 要介護認定審査員報酬単価情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 要介護認定審査員報酬単価情報エンティティを渡すと_insertは_要介護認定審査員報酬単価情報を追加する() {
            TestSupport.insert(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);

            assertThat(sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);
        }

        @Test
        public void 要介護認定審査員報酬単価情報エンティティを渡すと_updateは_要介護認定審査員報酬単価情報を更新する() {
            DbT7107ShinsainHoshuTankaJohoEntity updateRecord = DbT7107ShinsainHoshuTankaJohoEntityGenerator.createDbT7107ShinsainHoshuTankaJohoEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7107ShinsainHoshuTankaJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分);
        }

        @Test
        public void 要介護認定審査員報酬単価情報エンティティを渡すと_deleteは_要介護認定審査員報酬単価情報を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分));
            assertThat(sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_合議体長区分), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleDate 報酬単価適用開始年月日,
                FlexibleDate 報酬単価適用終了年月日,
                Code 合議体長区分) {
            DbT7107ShinsainHoshuTankaJohoEntity entity = DbT7107ShinsainHoshuTankaJohoEntityGenerator.createDbT7107ShinsainHoshuTankaJohoEntity();
            entity.setHoshuTankaTekiyoKaishiYMD(報酬単価適用開始年月日);
            entity.setHoshuTankaTekiyoShuryoYMD(報酬単価適用終了年月日);
            entity.setGogitaiChoKubunCode(合議体長区分);
            sut.insert(entity);
        }
    }
}
