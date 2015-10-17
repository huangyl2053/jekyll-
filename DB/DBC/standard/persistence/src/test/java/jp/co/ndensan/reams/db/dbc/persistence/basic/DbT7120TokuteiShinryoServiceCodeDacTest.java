
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7120TokuteiShinryoServiceCodeDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7120TokuteiShinryoServiceCodeEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用開始年月;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
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
 * {@link DbT7120TokuteiShinryoServiceCodeDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7120TokuteiShinryoServiceCodeDacTest extends DbcTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7120TokuteiShinryoServiceCodeDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7120TokuteiShinryoServiceCodeDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void サービス項目コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 適用開始年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7120TokuteiShinryoServiceCodeEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7120TokuteiShinryoServiceCodeEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 特定診療サービスコードが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 特定診療サービスコードが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 特定診療サービスコードエンティティを渡すと_insertは_特定診療サービスコードを追加する() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 特定診療サービスコードエンティティを渡すと_updateは_特定診療サービスコードを更新する() {
            DbT7120TokuteiShinryoServiceCodeEntity updateRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7120TokuteiShinryoServiceCodeEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 特定診療サービスコードエンティティを渡すと_deleteは_特定診療サービスコードを削除する() {
            DbT7120TokuteiShinryoServiceCodeEntity deletedEntity = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ServiceShuruiCode サービス種類コード,
                ServiceKomokuCode サービス項目コード,
                FlexibleYearMonth 適用開始年月,
                int 履歴番号) {
            DbT7120TokuteiShinryoServiceCodeEntity entity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            entity.setServiceShuruiCode(サービス種類コード);
            entity.setServiceKomokuCode(サービス項目コード);
            entity.setTekiyoKaishiYM(適用開始年月);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
