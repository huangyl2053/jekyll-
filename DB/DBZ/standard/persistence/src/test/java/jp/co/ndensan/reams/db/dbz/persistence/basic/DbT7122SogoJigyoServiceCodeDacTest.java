/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7122SogoJigyoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7122SogoJigyoServiceCodeEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_適用開始年月;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link DbT7122SogoJigyoServiceCodeDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7122SogoJigyoServiceCodeDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final ServiceShuruiCode サービス種類コード = new ServiceShuruiCode(new RString("1"));
    private static final ServiceShuruiCode サービス種類コード3 = new ServiceShuruiCode(new RString("3"));
    private static DbT7122SogoJigyoServiceCodeDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7122SogoJigyoServiceCodeDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void サービス項目コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    null,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 適用開始年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7122SogoJigyoServiceCodeEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7122SogoJigyoServiceCodeEntity insertedRecord = sut.selectByKey(
                    サービス種類コード3,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護予防_日常生活支援総合事業サービスコードが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護予防_日常生活支援総合事業サービスコードが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護予防_日常生活支援総合事業サービスコードエンティティを渡すと_insertは_介護予防_日常生活支援総合事業サービスコードを追加する() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test
        public void 介護予防_日常生活支援総合事業サービスコードエンティティを渡すと_updateは_介護予防_日常生活支援総合事業サービスコードを更新する() {
            DbT7122SogoJigyoServiceCodeEntity updateRecord = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7122SogoJigyoServiceCodeEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test
        public void 介護予防_日常生活支援総合事業サービスコードエンティティを渡すと_deleteは_介護予防_日常生活支援総合事業サービスコードを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_サービス項目コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ServiceShuruiCode サービス種類コード,
                ServiceKomokuCode サービス項目コード,
                FlexibleYearMonth 適用開始年月,
                YMDHMS 処理日時) {
            DbT7122SogoJigyoServiceCodeEntity entity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            entity.setServiceShuruiCode(サービス種類コード);
            entity.setServiceKomokuCode(サービス項目コード);
            entity.setTekiyoKaishiYM(適用開始年月);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
