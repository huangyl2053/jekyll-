/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiTuchiHosei;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3067KyufuhiTuchiHoseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3067KyufuhiTuchiHoseiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3067KyufuhiTuchiHoseiDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
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
 * {link KyufuhiTuchiHoseiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiTuchiHoseiManagerTest {

    private static DbT3067KyufuhiTuchiHoseiDac dac;
    private static KyufuhiTuchiHoseiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3067KyufuhiTuchiHoseiDac.class);
        sut = new KyufuhiTuchiHoseiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付費通知補正 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー2 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_事業所番号;
            ServiceShuruiCode 主キー5 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー6 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_履歴番号;
            sut.get給付費通知補正(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HokenshaNo 主キー1 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleYearMonth 主キー3 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_事業所番号;
            ServiceShuruiCode 主キー5 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー6 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_履歴番号;
            sut.get給付費通知補正(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HokenshaNo 主キー1 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_被保険者番号;
            JigyoshaNo 主キー4 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_事業所番号;
            ServiceShuruiCode 主キー5 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー6 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_履歴番号;
            sut.get給付費通知補正(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HokenshaNo 主キー1 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス提供年月;
            ServiceShuruiCode 主キー5 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー6 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_履歴番号;
            sut.get給付費通知補正(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HokenshaNo 主キー1 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_事業所番号;
            Decimal 主キー6 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_履歴番号;
            sut.get給付費通知補正(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            HokenshaNo 主キー1 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_事業所番号;
            ServiceShuruiCode 主キー5 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス種類コード;
            sut.get給付費通知補正(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HokenshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class),
                    any(JigyoshaNo.class), any(ServiceShuruiCode.class), any(Decimal.class))).thenReturn(null);

            HokenshaNo 主キー1 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_事業所番号;
            ServiceShuruiCode 主キー5 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー6 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_履歴番号;
            KyufuhiTuchiHosei result = sut.get給付費通知補正(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3067KyufuhiTuchiHoseiEntity entity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            when(dac.selectByKey(any(HokenshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class),
                    any(JigyoshaNo.class), any(ServiceShuruiCode.class), any(Decimal.class))).thenReturn(entity);
            HokenshaNo 主キー1 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー4 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_事業所番号;
            ServiceShuruiCode 主キー5 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー6 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_履歴番号;
            KyufuhiTuchiHosei result = sut.get給付費通知補正(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result.get証記載保険者番号().value(), is(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付費通知補正一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyufuhiTuchiHosei> result = sut.get給付費通知補正一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3067KyufuhiTuchiHoseiEntity> entityList = Arrays.asList(DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyufuhiTuchiHosei> result = sut.get給付費通知補正一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get証記載保険者番号().value(), is(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    public static class save給付費通知補正 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3067KyufuhiTuchiHoseiEntity.class))).thenReturn(1);

            DbT3067KyufuhiTuchiHoseiEntity entity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            KyufuhiTuchiHosei 給付費通知補正 = new KyufuhiTuchiHosei(entity);

            assertThat(sut.save給付費通知補正(給付費通知補正), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3067KyufuhiTuchiHoseiEntity.class))).thenReturn(0);

            DbT3067KyufuhiTuchiHoseiEntity entity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            KyufuhiTuchiHosei 給付費通知補正 = new KyufuhiTuchiHosei(entity);

            assertThat(sut.save給付費通知補正(給付費通知補正), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3067KyufuhiTuchiHoseiEntity.class))).thenReturn(1);

            DbT3067KyufuhiTuchiHoseiEntity entity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            entity.initializeMd5();
            KyufuhiTuchiHosei 給付費通知補正 = new KyufuhiTuchiHosei(entity);
            給付費通知補正 = 給付費通知補正.createBuilderForEdit().setサービス費用合計額(new Decimal(1200)).build();

            assertThat(sut.save給付費通知補正(給付費通知補正), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3067KyufuhiTuchiHoseiEntity.class))).thenReturn(0);

            DbT3067KyufuhiTuchiHoseiEntity entity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            entity.initializeMd5();
            KyufuhiTuchiHosei 給付費通知補正 = new KyufuhiTuchiHosei(entity);
            給付費通知補正 = 給付費通知補正.createBuilderForEdit().setサービス費用合計額(new Decimal(1200)).build();

            assertThat(sut.save給付費通知補正(給付費通知補正), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3067KyufuhiTuchiHoseiEntity.class))).thenReturn(1);

            DbT3067KyufuhiTuchiHoseiEntity entity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            entity.initializeMd5();
            KyufuhiTuchiHosei 給付費通知補正 = new KyufuhiTuchiHosei(entity);
            給付費通知補正 = 給付費通知補正.deleted();

            assertThat(sut.save給付費通知補正(給付費通知補正), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3067KyufuhiTuchiHoseiEntity.class))).thenReturn(0);

            DbT3067KyufuhiTuchiHoseiEntity entity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            entity.initializeMd5();
            KyufuhiTuchiHosei 給付費通知補正 = new KyufuhiTuchiHosei(entity);
            給付費通知補正 = 給付費通知補正.deleted();

            assertThat(sut.save給付費通知補正(給付費通知補正), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3067KyufuhiTuchiHoseiEntity entity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            entity.initializeMd5();
            KyufuhiTuchiHosei 給付費通知補正 = new KyufuhiTuchiHosei(entity);

            assertThat(sut.save給付費通知補正(給付費通知補正), is(false));
        }
    }
}
