/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SaishinsaMoshitate;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3062SaishinsaMoshitateEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3062SaishinsaMoshitateDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
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
 * {link SaishinsaMoshitateManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SaishinsaMoshitateManagerTest {

    private static DbT3062SaishinsaMoshitateDac dac;
    private static SaishinsaMoshitateManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3062SaishinsaMoshitateDac.class);
        sut = new SaishinsaMoshitateManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get再審査申立 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー2 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月;
            ServiceShuruiCode 主キー4 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー5 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード;
            Decimal 主キー6 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号;
            sut.get再審査申立(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            JigyoshaNo 主キー1 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号;
            FlexibleYearMonth 主キー3 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月;
            ServiceShuruiCode 主キー4 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー5 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード;
            Decimal 主キー6 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号;
            sut.get再審査申立(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            JigyoshaNo 主キー1 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号;
            HihokenshaNo 主キー2 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号;
            ServiceShuruiCode 主キー4 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー5 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード;
            Decimal 主キー6 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号;
            sut.get再審査申立(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            JigyoshaNo 主キー1 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号;
            HihokenshaNo 主キー2 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月;
            ServiceKomokuCode 主キー5 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード;
            Decimal 主キー6 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号;
            sut.get再審査申立(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            JigyoshaNo 主キー1 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号;
            HihokenshaNo 主キー2 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月;
            ServiceShuruiCode 主キー4 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード;
            Decimal 主キー6 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号;
            sut.get再審査申立(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            JigyoshaNo 主キー1 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号;
            HihokenshaNo 主キー2 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月;
            ServiceShuruiCode 主キー4 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー5 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード;
            sut.get再審査申立(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(JigyoshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class),
                    any(ServiceShuruiCode.class), any(ServiceKomokuCode.class), any(Decimal.class))).thenReturn(null);
            JigyoshaNo 主キー1 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号;
            HihokenshaNo 主キー2 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月;
            ServiceShuruiCode 主キー4 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー5 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード;
            Decimal 主キー6 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号;
            SaishinsaMoshitate result = sut.get再審査申立(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3062SaishinsaMoshitateEntity entity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            when(dac.selectByKey(any(JigyoshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class),
                    any(ServiceShuruiCode.class), any(ServiceKomokuCode.class), any(Decimal.class))).thenReturn(entity);
            JigyoshaNo 主キー1 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号;
            HihokenshaNo 主キー2 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月;
            ServiceShuruiCode 主キー4 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー5 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード;
            Decimal 主キー6 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号;
            SaishinsaMoshitate result = sut.get再審査申立(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result.get主キー1().value(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get再審査申立一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<SaishinsaMoshitate> result = sut.get再審査申立一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3062SaishinsaMoshitateEntity> entityList = Arrays.asList(DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<SaishinsaMoshitate> result = sut.get再審査申立一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号.value()));
        }
    }

    public static class save再審査申立 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3062SaishinsaMoshitateEntity.class))).thenReturn(1);

            DbT3062SaishinsaMoshitateEntity entity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            SaishinsaMoshitate 再審査申立 = new SaishinsaMoshitate(entity);

            assertThat(sut.save再審査申立(再審査申立), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3062SaishinsaMoshitateEntity.class))).thenReturn(0);

            DbT3062SaishinsaMoshitateEntity entity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            SaishinsaMoshitate 再審査申立 = new SaishinsaMoshitate(entity);

            assertThat(sut.save再審査申立(再審査申立), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3062SaishinsaMoshitateEntity.class))).thenReturn(1);

            DbT3062SaishinsaMoshitateEntity entity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            entity.initializeMd5();
            SaishinsaMoshitate 再審査申立 = new SaishinsaMoshitate(entity);
            再審査申立 = 再審査申立.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save再審査申立(再審査申立), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3062SaishinsaMoshitateEntity.class))).thenReturn(0);

            DbT3062SaishinsaMoshitateEntity entity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            entity.initializeMd5();
            SaishinsaMoshitate 再審査申立 = new SaishinsaMoshitate(entity);
            再審査申立 = 再審査申立.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save再審査申立(再審査申立), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3062SaishinsaMoshitateEntity.class))).thenReturn(1);

            DbT3062SaishinsaMoshitateEntity entity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            entity.initializeMd5();
            SaishinsaMoshitate 再審査申立 = new SaishinsaMoshitate(entity);
            再審査申立 = 再審査申立.deleted();

            assertThat(sut.save再審査申立(再審査申立), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3062SaishinsaMoshitateEntity.class))).thenReturn(0);

            DbT3062SaishinsaMoshitateEntity entity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            entity.initializeMd5();
            SaishinsaMoshitate 再審査申立 = new SaishinsaMoshitate(entity);
            再審査申立 = 再審査申立.deleted();

            assertThat(sut.save再審査申立(再審査申立), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3062SaishinsaMoshitateEntity entity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            entity.initializeMd5();
            SaishinsaMoshitate 再審査申立 = new SaishinsaMoshitate(entity);

            assertThat(sut.save再審査申立(再審査申立), is(false));
        }
    }
}
