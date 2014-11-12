/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
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
 * {@link DbT7115UwanoseShokanShuruiShikyuGendoGakuDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7115UwanoseShokanShuruiShikyuGendoGakuDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final ServiceShuruiCode サービス種類コード = new ServiceShuruiCode(new RString("1"));
    private static final ServiceShuruiCode サービス種類コード3 = new ServiceShuruiCode(new RString("3"));
    private static DbT7115UwanoseShokanShuruiShikyuGendoGakuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7115UwanoseShokanShuruiShikyuGendoGakuDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護状態区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
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
                    DEFAULT_要介護状態区分,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity insertedRecord = sut.selectByKey(
                    サービス種類コード3,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 上乗せ償還払い給付種類支給限度額が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 上乗せ償還払い給付種類支給限度額が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 上乗せ償還払い給付種類支給限度額エンティティを渡すと_insertは_上乗せ償還払い給付種類支給限度額を追加する() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test
        public void 上乗せ償還払い給付種類支給限度額エンティティを渡すと_updateは_上乗せ償還払い給付種類支給限度額を更新する() {
            DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity updateRecord = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
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
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時);
        }

        @Test
        public void 上乗せ償還払い給付種類支給限度額エンティティを渡すと_deleteは_上乗せ償還払い給付種類支給限度額を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_サービス種類コード,
                    DEFAULT_要介護状態区分,
                    DEFAULT_適用開始年月,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ServiceShuruiCode サービス種類コード,
                RString 要介護状態区分,
                FlexibleYearMonth 適用開始年月,
                YMDHMS 処理日時) {
            DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity entity = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity();
            entity.setServiceShuruiCode(サービス種類コード);
            entity.setYoKaigoJotaiKubun(要介護状態区分);
            entity.setTekiyoKaishiYM(適用開始年月);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
