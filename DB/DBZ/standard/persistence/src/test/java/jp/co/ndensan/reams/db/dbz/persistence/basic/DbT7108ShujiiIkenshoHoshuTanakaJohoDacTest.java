/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7108ShujiiIkenshoHoshuTanakaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_医師区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_報酬単価適用終了年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_報酬単価適用開始年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_意見書作成回数;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.DEFAULT_意見書作成料種別;
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
 * {@link DbT7108ShujiiIkenshoHoshuTanakaJohoDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7108ShujiiIkenshoHoshuTanakaJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final FlexibleDate 報酬単価適用開始年月日 = new FlexibleDate("20140401");
    private static final FlexibleDate 報酬単価適用開始年月日20140403 = new FlexibleDate("20140403");
    private static DbT7108ShujiiIkenshoHoshuTanakaJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7108ShujiiIkenshoHoshuTanakaJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
            TestSupport.insert(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
        }

        @Test(expected = NullPointerException.class)
        public void 報酬単価適用開始年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
        }

        @Test(expected = NullPointerException.class)
        public void 報酬単価適用終了年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    null,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
        }

        @Test(expected = NullPointerException.class)
        public void 医師区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    null,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書作成料種別がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7108ShujiiIkenshoHoshuTanakaJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7108ShujiiIkenshoHoshuTanakaJohoEntity insertedRecord = sut.selectByKey(
                    報酬単価適用開始年月日20140403,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 要介護認定主治医意見書報酬単価情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
            TestSupport.insert(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 要介護認定主治医意見書報酬単価情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 要介護認定主治医意見書報酬単価情報エンティティを渡すと_insertは_要介護認定主治医意見書報酬単価情報を追加する() {
            TestSupport.insert(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);

            assertThat(sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
        }

        @Test
        public void 要介護認定主治医意見書報酬単価情報エンティティを渡すと_updateは_要介護認定主治医意見書報酬単価情報を更新する() {
            DbT7108ShujiiIkenshoHoshuTanakaJohoEntity updateRecord = DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.createDbT7108ShujiiIkenshoHoshuTanakaJohoEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7108ShujiiIkenshoHoshuTanakaJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別);
        }

        @Test
        public void 要介護認定主治医意見書報酬単価情報エンティティを渡すと_deleteは_要介護認定主治医意見書報酬単価情報を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別));
            assertThat(sut.selectByKey(
                    DEFAULT_報酬単価適用開始年月日,
                    DEFAULT_報酬単価適用終了年月日,
                    DEFAULT_医師区分,
                    DEFAULT_意見書作成回数,
                    DEFAULT_意見書作成料種別), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleDate 報酬単価適用開始年月日,
                FlexibleDate 報酬単価適用終了年月日,
                Code 医師区分,
                int 意見書作成回数,
                RString 意見書作成料種別) {
            DbT7108ShujiiIkenshoHoshuTanakaJohoEntity entity = DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator.createDbT7108ShujiiIkenshoHoshuTanakaJohoEntity();
            entity.setHoshuTankaTekiyoKaishiYMD(報酬単価適用開始年月日);
            entity.setHoshuTankaTekiyoShuryoYMD(報酬単価適用終了年月日);
            entity.setIshiKubunCode(医師区分);
            entity.setIkenshoSakuseiKaisu(意見書作成回数);
            entity.setIkenshoSakuseiryoShubetsu(意見書作成料種別);
            sut.insert(entity);
        }
    }
}
