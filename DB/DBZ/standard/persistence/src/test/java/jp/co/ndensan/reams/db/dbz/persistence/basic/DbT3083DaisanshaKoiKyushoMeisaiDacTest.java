/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3083DaisanshaKoiKyushoMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号;
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
 * {@link DbT3083DaisanshaKoiKyushoMeisaiDac}のテストです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DbT3083DaisanshaKoiKyushoMeisaiDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3083DaisanshaKoiKyushoMeisaiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3083DaisanshaKoiKyushoMeisaiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new HihokenshaNo(キー_01),
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 第三者行為届出管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    null,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 第三者行為求償請求番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    null,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    null,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    null,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3083DaisanshaKoiKyushoMeisaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3083DaisanshaKoiKyushoMeisaiEntity insertedRecord = sut.selectByKey(
                    new HihokenshaNo(キー_03),
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護第三者行為求償明細が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new HihokenshaNo(キー_01),
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護第三者行為求償明細が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護第三者行為求償明細エンティティを渡すと_insertは_介護第三者行為求償明細を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
        }

        @Test
        public void 介護第三者行為求償明細エンティティを渡すと_updateは_介護第三者行為求償明細を更新する() {
            DbT3083DaisanshaKoiKyushoMeisaiEntity updateRecord = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            //TODO  主キー以外の項目を変更してください
//   updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3083DaisanshaKoiKyushoMeisaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);

            //TODO  主キー以外の項目を変更してください
// assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時);
        }

        @Test
        public void 介護第三者行為求償明細エンティティを渡すと_deleteは_介護第三者行為求償明細を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_第三者行為届出管理番号,
                    DEFAULT_第三者行為求償請求番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                RString 第三者行為届出管理番号,
                RString 第三者行為求償請求番号,
                FlexibleYearMonth サービス提供年月,
                JigyoshaNo サービス提供事業者番号,
                ServiceShuruiCode サービス種類コード,
                YMDHMS 処理日時) {
            DbT3083DaisanshaKoiKyushoMeisaiEntity entity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setTodokedeKanriNo(第三者行為届出管理番号);
            entity.setKyushoSeikyuNo(第三者行為求償請求番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
            entity.setServiceShuruiCode(サービス種類コード);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
