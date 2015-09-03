/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ChiikiMitchakuServiceCode;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7121ChiikiMitchakuServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7121ChiikiMitchakuServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.basic.DbT7121ChiikiMitchakuServiceCodeDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ChiikiMitchakuServiceCodeManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChiikiMitchakuServiceCodeManagerTest {

    private static DbT7121ChiikiMitchakuServiceCodeDac dac;
    private static ChiikiMitchakuServiceCodeManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7121ChiikiMitchakuServiceCodeDac.class);
        sut = new ChiikiMitchakuServiceCodeManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get地域密着型介護サービスコード extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceKomokuCode 主キー2 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            FlexibleYearMonth 主キー3 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_履歴番号;
            sut.get地域密着型介護サービスコード(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceShuruiCode 主キー1 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー3 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_履歴番号;
            sut.get地域密着型介護サービスコード(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceShuruiCode 主キー1 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー2 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            int 主キー4 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_履歴番号;
            sut.get地域密着型介護サービスコード(主キー1, 主キー2, null, 主キー4);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ServiceShuruiCode.class), any(ServiceKomokuCode.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);
            ServiceShuruiCode 主キー1 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー2 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            FlexibleYearMonth 主キー3 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_履歴番号;
            ChiikiMitchakuServiceCode result = sut.get地域密着型介護サービスコード(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7121ChiikiMitchakuServiceCodeEntity entity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            when(dac.selectByKey(any(ServiceShuruiCode.class), any(ServiceKomokuCode.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);
            ServiceShuruiCode 主キー1 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー2 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            FlexibleYearMonth 主キー3 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_履歴番号;
            ChiikiMitchakuServiceCode result = sut.get地域密着型介護サービスコード(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.getサービス種類コード().value(), is(DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get地域密着型介護サービスコード一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ChiikiMitchakuServiceCode> result = sut.get地域密着型介護サービスコード一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7121ChiikiMitchakuServiceCodeEntity> entityList = Arrays.asList(DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ChiikiMitchakuServiceCode> result = sut.get地域密着型介護サービスコード一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサービス種類コード().value(), is(DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    public static class save地域密着型介護サービスコード extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7121ChiikiMitchakuServiceCodeEntity.class))).thenReturn(1);

            DbT7121ChiikiMitchakuServiceCodeEntity entity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            ChiikiMitchakuServiceCode 地域密着型介護サービスコード = new ChiikiMitchakuServiceCode(entity);

            assertThat(sut.save地域密着型介護サービスコード(地域密着型介護サービスコード), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7121ChiikiMitchakuServiceCodeEntity.class))).thenReturn(0);

            DbT7121ChiikiMitchakuServiceCodeEntity entity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            ChiikiMitchakuServiceCode 地域密着型介護サービスコード = new ChiikiMitchakuServiceCode(entity);

            assertThat(sut.save地域密着型介護サービスコード(地域密着型介護サービスコード), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7121ChiikiMitchakuServiceCodeEntity.class))).thenReturn(1);

            DbT7121ChiikiMitchakuServiceCodeEntity entity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            entity.initializeMd5();
            ChiikiMitchakuServiceCode 地域密着型介護サービスコード = new ChiikiMitchakuServiceCode(entity);
            地域密着型介護サービスコード = 地域密着型介護サービスコード.createBuilderForEdit().setサービス名称(new RString("任意項目1を変更")).build();

            assertThat(sut.save地域密着型介護サービスコード(地域密着型介護サービスコード), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7121ChiikiMitchakuServiceCodeEntity.class))).thenReturn(0);

            DbT7121ChiikiMitchakuServiceCodeEntity entity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            entity.initializeMd5();
            ChiikiMitchakuServiceCode 地域密着型介護サービスコード = new ChiikiMitchakuServiceCode(entity);
            地域密着型介護サービスコード = 地域密着型介護サービスコード.createBuilderForEdit().setサービス名称(new RString("任意項目1を変更")).build();

            assertThat(sut.save地域密着型介護サービスコード(地域密着型介護サービスコード), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7121ChiikiMitchakuServiceCodeEntity.class))).thenReturn(1);

            DbT7121ChiikiMitchakuServiceCodeEntity entity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            entity.initializeMd5();
            ChiikiMitchakuServiceCode 地域密着型介護サービスコード = new ChiikiMitchakuServiceCode(entity);
            地域密着型介護サービスコード = 地域密着型介護サービスコード.deleted();

            assertThat(sut.save地域密着型介護サービスコード(地域密着型介護サービスコード), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7121ChiikiMitchakuServiceCodeEntity.class))).thenReturn(0);

            DbT7121ChiikiMitchakuServiceCodeEntity entity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            entity.initializeMd5();
            ChiikiMitchakuServiceCode 地域密着型介護サービスコード = new ChiikiMitchakuServiceCode(entity);
            地域密着型介護サービスコード = 地域密着型介護サービスコード.deleted();

            assertThat(sut.save地域密着型介護サービスコード(地域密着型介護サービスコード), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7121ChiikiMitchakuServiceCodeEntity entity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            entity.initializeMd5();
            ChiikiMitchakuServiceCode 地域密着型介護サービスコード = new ChiikiMitchakuServiceCode(entity);

            assertThat(sut.save地域密着型介護サービスコード(地域密着型介護サービスコード), is(false));
        }
    }
}
