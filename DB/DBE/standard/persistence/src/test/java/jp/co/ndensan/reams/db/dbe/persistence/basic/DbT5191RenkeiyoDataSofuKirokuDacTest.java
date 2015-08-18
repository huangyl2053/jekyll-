/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5191RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5191RenkeiyoDataSofuKirokuEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_資料作成日;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
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
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5191RenkeiyoDataSofuKirokuDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT5191RenkeiyoDataSofuKirokuDacTest extends DbeTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5191RenkeiyoDataSofuKirokuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5191RenkeiyoDataSofuKirokuDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
        }

        @Test(expected = NullPointerException.class)
        public void 資料作成日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5191RenkeiyoDataSofuKirokuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5191RenkeiyoDataSofuKirokuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 連携用データ送付記録が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 連携用データ送付記録が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 連携用データ送付記録エンティティを渡すと_insertは_連携用データ送付記録を追加する() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);

            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
        }

        @Test
        public void 連携用データ送付記録エンティティを渡すと_updateは_連携用データ送付記録を更新する() {
            DbT5191RenkeiyoDataSofuKirokuEntity updateRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT5191RenkeiyoDataSofuKirokuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
        }

        @Test
        public void 連携用データ送付記録エンティティを渡すと_deleteは_連携用データ送付記録を削除する() {
            DbT5191RenkeiyoDataSofuKirokuEntity deletedEntity = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_資料作成日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShinseishoKanriNo 申請書管理番号,
                FlexibleDate 資料作成日) {
            DbT5191RenkeiyoDataSofuKirokuEntity entity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setShiryoSakuseiYMD(資料作成日);
            sut.save(entity);
        }
    }
}
