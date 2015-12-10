///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbz.service.core.basic;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
//import jp.co.ndensan.reams.db.dbz.business.core.basic.YoboKeikakuJikoSakuseiMeisai;
//import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator;
//import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3011YoboKeikakuJikoSakuseiMeisaiDac;
//import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.math.Decimal;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.nullValue;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
///**
// * {link YoboKeikakuJikoSakuseiMeisaiManager}のテストクラスです。
// */
//@Ignore
//@RunWith(Enclosed.class)
//public class YoboKeikakuJikoSakuseiMeisaiManagerTest {
//
//    private static DbT3011YoboKeikakuJikoSakuseiMeisaiDac dac;
//    private static YoboKeikakuJikoSakuseiMeisaiManager sut;
//
//    @BeforeClass
//    public static void test() {
//        dac = mock(DbT3011YoboKeikakuJikoSakuseiMeisaiDac.class);
//        sut = new YoboKeikakuJikoSakuseiMeisaiManager(dac);
//    }
//
//    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get予防給付計画自己作成明細 extends DbcTestBase {
//
//        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
//            FlexibleYearMonth 主キー2 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
//            Decimal 主キー3 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
//            RString 主キー4 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
//            JigyoshaNo 主キー5 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
//            ServiceShuruiCode 主キー6 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
//            ServiceKomokuCode 主キー7 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
//            sut.get予防給付計画自己作成明細(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
//            HihokenshaNo 主キー1 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
//            Decimal 主キー3 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
//            RString 主キー4 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
//            JigyoshaNo 主キー5 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
//            ServiceShuruiCode 主キー6 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
//            ServiceKomokuCode 主キー7 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
//            sut.get予防給付計画自己作成明細(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
//            HihokenshaNo 主キー1 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
//            RString 主キー4 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
//            JigyoshaNo 主キー5 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
//            ServiceShuruiCode 主キー6 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
//            ServiceKomokuCode 主キー7 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
//            sut.get予防給付計画自己作成明細(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6, 主キー7);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
//            HihokenshaNo 主キー1 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
//            Decimal 主キー3 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
//            JigyoshaNo 主キー5 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
//            ServiceShuruiCode 主キー6 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
//            ServiceKomokuCode 主キー7 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
//            sut.get予防給付計画自己作成明細(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6, 主キー7);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
//            HihokenshaNo 主キー1 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
//            Decimal 主キー3 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
//            RString 主キー4 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
//            ServiceShuruiCode 主キー6 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
//            ServiceKomokuCode 主キー7 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
//            sut.get予防給付計画自己作成明細(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6, 主キー7);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
//            HihokenshaNo 主キー1 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
//            Decimal 主キー3 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
//            RString 主キー4 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
//            JigyoshaNo 主キー5 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
//            ServiceKomokuCode 主キー7 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
//            sut.get予防給付計画自己作成明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null, 主キー7);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
//            HihokenshaNo 主キー1 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
//            Decimal 主キー3 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
//            RString 主キー4 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
//            JigyoshaNo 主キー5 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
//            ServiceShuruiCode 主キー6 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
//            sut.get予防給付計画自己作成明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, null);
//        }
//
//        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
//        @Test
//        public void 検索結果がnullの場合() {
//            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class), any(RString.class),
//                    any(JigyoshaNo.class), any(ServiceShuruiCode.class), any(ServiceKomokuCode.class))).thenReturn(null);
//
//            HihokenshaNo 主キー1 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
//            Decimal 主キー3 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
//            RString 主キー4 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
//            JigyoshaNo 主キー5 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
//            ServiceShuruiCode 主キー6 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
//            ServiceKomokuCode 主キー7 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
//            YoboKeikakuJikoSakuseiMeisai result = sut.get予防給付計画自己作成明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
//
//            assertThat(result, is(nullValue()));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
//            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class), any(RString.class),
//                    any(JigyoshaNo.class), any(ServiceShuruiCode.class), any(ServiceKomokuCode.class))).thenReturn(entity);
//            HihokenshaNo 主キー1 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
//            Decimal 主キー3 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
//            RString 主キー4 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
//            JigyoshaNo 主キー5 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
//            ServiceShuruiCode 主キー6 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
//            ServiceKomokuCode 主キー7 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
//            YoboKeikakuJikoSakuseiMeisai result = sut.get予防給付計画自己作成明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
//
//            assertThat(result.get被保険者番号().value(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号.value()));
//        }
//    }
//
//    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get予防給付計画自己作成明細一覧 extends DbcTestBase {
//
//        @Test
//        public void 検索結果が空の場合() {
//            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);
//
//            List<YoboKeikakuJikoSakuseiMeisai> result = sut.get予防給付計画自己作成明細一覧();
//
//            assertThat(result.isEmpty(), is(true));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            List<DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity> entityList = Arrays.asList(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity());
//            when(dac.selectAll()).thenReturn(entityList);
//
//            List<YoboKeikakuJikoSakuseiMeisai> result = sut.get予防給付計画自己作成明細一覧();
//
//            assertThat(result.size(), is(1));
//            assertThat(result.get(0).get被保険者番号().value(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号.value()));
//        }
//    }
//
//    public static class save予防給付計画自己作成明細 extends DbcTestBase {
//
//        @Test
//        public void insertに成功するとtrueが返る() {
//            when(dac.save(any(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity.class))).thenReturn(1);
//
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
//            YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細 = new YoboKeikakuJikoSakuseiMeisai(entity);
//
//            assertThat(sut.save予防給付計画自己作成明細(予防給付計画自己作成明細), is(true));
//        }
//
//        @Test
//        public void insertに失敗するとfalseが返る() {
//            when(dac.save(any(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity.class))).thenReturn(0);
//
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
//            YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細 = new YoboKeikakuJikoSakuseiMeisai(entity);
//
//            assertThat(sut.save予防給付計画自己作成明細(予防給付計画自己作成明細), is(false));
//        }
//
//        @Test
//        public void updateに成功するとtrueが返る() {
//            when(dac.save(any(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity.class))).thenReturn(1);
//
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
//            entity.initializeMd5();
//            YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細 = new YoboKeikakuJikoSakuseiMeisai(entity);
//            予防給付計画自己作成明細 = 予防給付計画自己作成明細.createBuilderForEdit().set居宅サービス区分(new RString("任意項目1を変更")).build();
//
//            assertThat(sut.save予防給付計画自己作成明細(予防給付計画自己作成明細), is(true));
//        }
//
//        @Test
//        public void updateに失敗するとfalseが返る() {
//            when(dac.save(any(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity.class))).thenReturn(0);
//
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
//            entity.initializeMd5();
//            YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細 = new YoboKeikakuJikoSakuseiMeisai(entity);
//            予防給付計画自己作成明細 = 予防給付計画自己作成明細.createBuilderForEdit().set居宅サービス区分(new RString("任意項目1を変更")).build();
//
//            assertThat(sut.save予防給付計画自己作成明細(予防給付計画自己作成明細), is(false));
//        }
//
//        @Test
//        public void deleteに成功するとtrueが返る() {
//            when(dac.save(any(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity.class))).thenReturn(1);
//
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
//            entity.initializeMd5();
//            YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細 = new YoboKeikakuJikoSakuseiMeisai(entity);
//            予防給付計画自己作成明細 = 予防給付計画自己作成明細.deleted();
//
//            assertThat(sut.save予防給付計画自己作成明細(予防給付計画自己作成明細), is(true));
//        }
//
//        @Test
//        public void deleteに失敗するとfalseが返る() {
//            when(dac.save(any(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity.class))).thenReturn(0);
//
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
//            entity.initializeMd5();
//            YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細 = new YoboKeikakuJikoSakuseiMeisai(entity);
//            予防給付計画自己作成明細 = 予防給付計画自己作成明細.deleted();
//
//            assertThat(sut.save予防給付計画自己作成明細(予防給付計画自己作成明細), is(false));
//        }
//
//        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
//            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
//            entity.initializeMd5();
//            YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細 = new YoboKeikakuJikoSakuseiMeisai(entity);
//
//            assertThat(sut.save予防給付計画自己作成明細(予防給付計画自己作成明細), is(false));
//        }
//    }
//}
