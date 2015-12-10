///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbz.persistence.db.basic;
//
//import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3011YoboKeikakuJikoSakuseiMeisaiDac;
//import java.util.Collections;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
//import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
//import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.math.Decimal;
//import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
//import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.hamcrest.CoreMatchers.nullValue;
//import static org.junit.Assert.assertThat;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//
///**
// * {@link DbT3011YoboKeikakuJikoSakuseiMeisaiDac}のテストです。
// */
//@Ignore
//@RunWith(Enclosed.class)
//public class DbT3011YoboKeikakuJikoSakuseiMeisaiDacTest extends DbcTestDacBase {
//
//    private static final RString キー_02 = new RString("02");
//    private static final RString キー_03 = new RString("03");
//    private static DbT3011YoboKeikakuJikoSakuseiMeisaiDac sut;
//
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceProvider.create(DbT3011YoboKeikakuJikoSakuseiMeisaiDac.class);
//    }
//
//    public static class selectByKeyのテスト extends DbcTestDacBase {
//
//        @Before
//        public void setUp() {
//            TestSupport.insert(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//            TestSupport.insert(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 対象年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 居宅サービス区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void サービス提供事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void サービス項目コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//        }
//
//        @Test
//        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity insertedRecord = sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//            assertThat(insertedRecord, is(notNullValue()));
//        }
//
//        @Test
//        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity insertedRecord = sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//            assertThat(insertedRecord, is(nullValue()));
//        }
//    }
//
//    public static class selectAllのテスト extends DbcTestDacBase {
//
//        @Test
//        public void 予防給付計画自己作成明細が存在する場合_selectAllは_全件を返す() {
//            TestSupport.insert(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//            TestSupport.insert(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//            assertThat(sut.selectAll().size(), is(2));
//        }
//
//        @Test
//        public void 予防給付計画自己作成明細が存在しない場合_selectAllは_空のリストを返す() {
//            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
//        }
//    }
//
//    public static class insertのテスト extends DbcTestDacBase {
//
//        @Test
//        public void 予防給付計画自己作成明細エンティティを渡すと_insertは_予防給付計画自己作成明細を追加する() {
//            TestSupport.insert(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//
//            assertThat(sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード), is(notNullValue()));
//        }
//    }
//
//    public static class updateのテスト extends DbcTestDacBase {
//
//        @Before
//        public void setUp() {
//            TestSupport.insert(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//        }
//
//        @Test
//        public void 予防給付計画自己作成明細エンティティを渡すと_updateは_予防給付計画自己作成明細を更新する() {
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity updateRecord = sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//            updateRecord.setKaisu_Nissu(new Decimal(75));
//
//            sut.save(updateRecord);
//
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity updatedRecord = sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//
//            assertThat(updateRecord.getKaisu_Nissu(), is(updatedRecord.getKaisu_Nissu()));
//        }
//    }
//
//    public static class deleteのテスト extends DbcTestDacBase {
//
//        @Before
//        public void setUp() {
//            TestSupport.insert(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//        }
//
//        @Test
//        public void 予防給付計画自己作成明細エンティティを渡すと_deleteは_予防給付計画自己作成明細を削除する() {
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity deletedEntity = sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード);
//            deletedEntity.setState(EntityDataState.Deleted);
//
//            sut.save(deletedEntity);
//
//            assertThat(sut.selectByKey(
//                    DEFAULT_被保険者番号,
//                    DEFAULT_対象年月,
//                    DEFAULT_履歴番号,
//                    DEFAULT_居宅サービス区分,
//                    DEFAULT_サービス提供事業者番号,
//                    DEFAULT_サービス種類コード,
//                    DEFAULT_サービス項目コード), is(nullValue()));
//        }
//    }
//
//    private static class TestSupport {
//
//        public static void insert(
//                HihokenshaNo 被保険者番号,
//                FlexibleYearMonth 対象年月,
//                Decimal 履歴番号,
//                RString 居宅サービス区分,
//                JigyoshaNo サービス提供事業者番号,
//                ServiceShuruiCode サービス種類コード,
//                ServiceKomokuCode サービス項目コード) {
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
//            entity.setHihokenshaNo(被保険者番号);
//            entity.setTaishoYM(対象年月);
//            entity.setRirekiNo(履歴番号);
//            entity.setKyotakuServiceKubun(居宅サービス区分);
//            entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
//            entity.setServiceShuruiCode(サービス種類コード);
//            entity.setServiceKomokuCode(サービス項目コード);
//            sut.save(entity);
//        }
//    }
//}
