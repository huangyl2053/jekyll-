/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaMeisai;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiDac;
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
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KogakuKyufuTaishoshaMeisaiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuKyufuTaishoshaMeisaiManagerTest {

    private static DbT3054KogakuKyufuTaishoshaMeisaiDac dac;
    private static KogakuKyufuTaishoshaMeisaiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3054KogakuKyufuTaishoshaMeisaiDac.class);
        sut = new KogakuKyufuTaishoshaMeisaiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額介護サービス費給付対象者明細 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー3 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号;
            ServiceShuruiCode 主キー4 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            int 主キー5 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額介護サービス費給付対象者明細(null, 主キー2, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            JigyoshaNo 主キー3 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号;
            ServiceShuruiCode 主キー4 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            int 主キー5 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額介護サービス費給付対象者明細(主キー1, null, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            ServiceShuruiCode 主キー4 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            int 主キー5 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額介護サービス費給付対象者明細(主キー1, 主キー2, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー3 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号;
            int 主キー5 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額介護サービス費給付対象者明細(主キー1, 主キー2, 主キー3, null, 主キー5);
        }

//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
//            HihokenshaNo 主キー1 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月;
//            JigyoshaNo 主キー3 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号;
//            ServiceShuruiCode 主キー4 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード;
//            sut.get高額介護サービス費給付対象者明細(主キー1, 主キー2, 主キー3, 主キー4, null);
//        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(JigyoshaNo.class),
                    any(ServiceShuruiCode.class), any(int.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー3 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号;
            ServiceShuruiCode 主キー4 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            int 主キー5 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_履歴番号;
            KogakuKyufuTaishoshaMeisai result = sut.get高額介護サービス費給付対象者明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3054KogakuKyufuTaishoshaMeisaiEntity entity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(JigyoshaNo.class),
                    any(ServiceShuruiCode.class), any(int.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー3 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号;
            ServiceShuruiCode 主キー4 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード;
            int 主キー5 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_履歴番号;
            KogakuKyufuTaishoshaMeisai result = sut.get高額介護サービス費給付対象者明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result.get被保険者番号().value(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額介護サービス費給付対象者明細一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuKyufuTaishoshaMeisai> result = sut.get高額介護サービス費給付対象者明細一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3054KogakuKyufuTaishoshaMeisaiEntity> entityList = Arrays.asList(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuKyufuTaishoshaMeisai> result = sut.get高額介護サービス費給付対象者明細一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save高額介護サービス費給付対象者明細 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3054KogakuKyufuTaishoshaMeisaiEntity.class))).thenReturn(1);

            DbT3054KogakuKyufuTaishoshaMeisaiEntity entity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            KogakuKyufuTaishoshaMeisai 高額介護サービス費給付対象者明細 = new KogakuKyufuTaishoshaMeisai(entity);

            assertThat(sut.save高額介護サービス費給付対象者明細(高額介護サービス費給付対象者明細), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3054KogakuKyufuTaishoshaMeisaiEntity.class))).thenReturn(0);

            DbT3054KogakuKyufuTaishoshaMeisaiEntity entity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            KogakuKyufuTaishoshaMeisai 高額介護サービス費給付対象者明細 = new KogakuKyufuTaishoshaMeisai(entity);

            assertThat(sut.save高額介護サービス費給付対象者明細(高額介護サービス費給付対象者明細), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3054KogakuKyufuTaishoshaMeisaiEntity.class))).thenReturn(1);

            DbT3054KogakuKyufuTaishoshaMeisaiEntity entity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            entity.initializeMd5();
            KogakuKyufuTaishoshaMeisai 高額介護サービス費給付対象者明細 = new KogakuKyufuTaishoshaMeisai(entity);
            高額介護サービス費給付対象者明細 = 高額介護サービス費給付対象者明細.createBuilderForEdit().set高額給付根拠(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額介護サービス費給付対象者明細(高額介護サービス費給付対象者明細), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3054KogakuKyufuTaishoshaMeisaiEntity.class))).thenReturn(0);

            DbT3054KogakuKyufuTaishoshaMeisaiEntity entity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            entity.initializeMd5();
            KogakuKyufuTaishoshaMeisai 高額介護サービス費給付対象者明細 = new KogakuKyufuTaishoshaMeisai(entity);
            高額介護サービス費給付対象者明細 = 高額介護サービス費給付対象者明細.createBuilderForEdit().set高額給付根拠(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額介護サービス費給付対象者明細(高額介護サービス費給付対象者明細), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3054KogakuKyufuTaishoshaMeisaiEntity.class))).thenReturn(1);

            DbT3054KogakuKyufuTaishoshaMeisaiEntity entity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            entity.initializeMd5();
            KogakuKyufuTaishoshaMeisai 高額介護サービス費給付対象者明細 = new KogakuKyufuTaishoshaMeisai(entity);
            高額介護サービス費給付対象者明細 = 高額介護サービス費給付対象者明細.deleted();

            assertThat(sut.save高額介護サービス費給付対象者明細(高額介護サービス費給付対象者明細), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3054KogakuKyufuTaishoshaMeisaiEntity.class))).thenReturn(0);

            DbT3054KogakuKyufuTaishoshaMeisaiEntity entity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            entity.initializeMd5();
            KogakuKyufuTaishoshaMeisai 高額介護サービス費給付対象者明細 = new KogakuKyufuTaishoshaMeisai(entity);
            高額介護サービス費給付対象者明細 = 高額介護サービス費給付対象者明細.deleted();

            assertThat(sut.save高額介護サービス費給付対象者明細(高額介護サービス費給付対象者明細), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3054KogakuKyufuTaishoshaMeisaiEntity entity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            entity.initializeMd5();
            KogakuKyufuTaishoshaMeisai 高額介護サービス費給付対象者明細 = new KogakuKyufuTaishoshaMeisai(entity);

            assertThat(sut.save高額介護サービス費給付対象者明細(高額介護サービス費給付対象者明細), is(false));
        }
    }
}
