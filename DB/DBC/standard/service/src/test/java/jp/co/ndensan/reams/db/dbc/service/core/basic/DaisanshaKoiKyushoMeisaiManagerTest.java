/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.DaisanshaKoiKyushoMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3083DaisanshaKoiKyushoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3083DaisanshaKoiKyushoMeisaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link DaisanshaKoiKyushoMeisaiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyushoMeisaiManagerTest {

    private static DbT3083DaisanshaKoiKyushoMeisaiDac dac;
    private static DaisanshaKoiKyushoMeisaiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3083DaisanshaKoiKyushoMeisaiDac.class);
        sut = new DaisanshaKoiKyushoMeisaiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護第三者行為求償明細 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号;
            FlexibleYearMonth 主キー4 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー5 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー7 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為求償明細(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号;
            FlexibleYearMonth 主キー4 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー5 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー7 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為求償明細(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号;
            FlexibleYearMonth 主キー4 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー5 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー7 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為求償明細(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号;
            JigyoshaNo 主キー5 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー7 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為求償明細(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号;
            FlexibleYearMonth 主キー4 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            ServiceShuruiCode 主キー6 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー7 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為求償明細(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号;
            FlexibleYearMonth 主キー4 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー5 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
            Decimal 主キー7 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為求償明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null, 主キー7);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号;
            FlexibleYearMonth 主キー4 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー5 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            sut.get介護第三者行為求償明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(RString.class), any(FlexibleYearMonth.class),
                    any(JigyoshaNo.class), any(ServiceShuruiCode.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号;
            FlexibleYearMonth 主キー4 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー5 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー7 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号;
            DaisanshaKoiKyushoMeisai result = sut.get介護第三者行為求償明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3083DaisanshaKoiKyushoMeisaiEntity entity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(RString.class), any(FlexibleYearMonth.class),
                    any(JigyoshaNo.class), any(ServiceShuruiCode.class), any(Decimal.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号;
            FlexibleYearMonth 主キー4 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー5 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
            ServiceShuruiCode 主キー6 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー7 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号;
            DaisanshaKoiKyushoMeisai result = sut.get介護第三者行為求償明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7);

            assertThat(result.get被保険者番号().value(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護第三者行為求償明細一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<DaisanshaKoiKyushoMeisai> result = sut.get介護第三者行為求償明細一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3083DaisanshaKoiKyushoMeisaiEntity> entityList = Arrays.asList(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<DaisanshaKoiKyushoMeisai> result = sut.get介護第三者行為求償明細一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save介護第三者行為求償明細 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3083DaisanshaKoiKyushoMeisaiEntity.class))).thenReturn(1);

            DbT3083DaisanshaKoiKyushoMeisaiEntity entity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            DaisanshaKoiKyushoMeisai 介護第三者行為求償明細 = new DaisanshaKoiKyushoMeisai(entity);

            assertThat(sut.save介護第三者行為求償明細(介護第三者行為求償明細), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3083DaisanshaKoiKyushoMeisaiEntity.class))).thenReturn(0);

            DbT3083DaisanshaKoiKyushoMeisaiEntity entity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            DaisanshaKoiKyushoMeisai 介護第三者行為求償明細 = new DaisanshaKoiKyushoMeisai(entity);

            assertThat(sut.save介護第三者行為求償明細(介護第三者行為求償明細), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3083DaisanshaKoiKyushoMeisaiEntity.class))).thenReturn(1);

            DbT3083DaisanshaKoiKyushoMeisaiEntity entity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            entity.initializeMd5();
            DaisanshaKoiKyushoMeisai 介護第三者行為求償明細 = new DaisanshaKoiKyushoMeisai(entity);
            介護第三者行為求償明細 = 介護第三者行為求償明細.createBuilderForEdit().set第三者行為届出管理番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護第三者行為求償明細(介護第三者行為求償明細), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3083DaisanshaKoiKyushoMeisaiEntity.class))).thenReturn(0);

            DbT3083DaisanshaKoiKyushoMeisaiEntity entity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            entity.initializeMd5();
            DaisanshaKoiKyushoMeisai 介護第三者行為求償明細 = new DaisanshaKoiKyushoMeisai(entity);
            介護第三者行為求償明細 = 介護第三者行為求償明細.createBuilderForEdit().set第三者行為届出管理番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護第三者行為求償明細(介護第三者行為求償明細), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3083DaisanshaKoiKyushoMeisaiEntity.class))).thenReturn(1);

            DbT3083DaisanshaKoiKyushoMeisaiEntity entity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            entity.initializeMd5();
            DaisanshaKoiKyushoMeisai 介護第三者行為求償明細 = new DaisanshaKoiKyushoMeisai(entity);
            介護第三者行為求償明細 = 介護第三者行為求償明細.deleted();

            assertThat(sut.save介護第三者行為求償明細(介護第三者行為求償明細), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3083DaisanshaKoiKyushoMeisaiEntity.class))).thenReturn(0);

            DbT3083DaisanshaKoiKyushoMeisaiEntity entity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            entity.initializeMd5();
            DaisanshaKoiKyushoMeisai 介護第三者行為求償明細 = new DaisanshaKoiKyushoMeisai(entity);
            介護第三者行為求償明細 = 介護第三者行為求償明細.deleted();

            assertThat(sut.save介護第三者行為求償明細(介護第三者行為求償明細), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3083DaisanshaKoiKyushoMeisaiEntity entity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            entity.initializeMd5();
            DaisanshaKoiKyushoMeisai 介護第三者行為求償明細 = new DaisanshaKoiKyushoMeisai(entity);

            assertThat(sut.save介護第三者行為求償明細(介護第三者行為求償明細), is(false));
        }
    }
}
