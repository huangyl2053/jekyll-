/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TokuteiShinryoServiceCode;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7120TokuteiShinryoServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7120TokuteiShinryoServiceCodeDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link TokuteiShinryoServiceCodeManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class TokuteiShinryoServiceCodeManagerTest {

    private static DbT7120TokuteiShinryoServiceCodeDac dac;
    private static TokuteiShinryoServiceCodeManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7120TokuteiShinryoServiceCodeDac.class);
        sut = new TokuteiShinryoServiceCodeManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get特定診療サービスコード extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のServiceShuruiCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceKomokuCode 主キー2 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            FlexibleYearMonth 主キー3 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_履歴番号;
            sut.get特定診療サービスコード(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のServiceKomokuCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceShuruiCode 主キー1 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー3 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_履歴番号;
            sut.get特定診療サービスコード(主キー1, null, 主キー3, 主キー4);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ServiceShuruiCode.class), any(ServiceKomokuCode.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);

            ServiceShuruiCode 主キー1 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー2 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            FlexibleYearMonth 主キー3 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_履歴番号;
            TokuteiShinryoServiceCode result = sut.get特定診療サービスコード(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7120TokuteiShinryoServiceCodeEntity entity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            when(dac.selectByKey(any(ServiceShuruiCode.class), any(ServiceKomokuCode.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);

            ServiceShuruiCode 主キー1 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー2 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            FlexibleYearMonth 主キー3 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_履歴番号;
            TokuteiShinryoServiceCode result = sut.get特定診療サービスコード(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.getサービス種類コード().value(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get特定診療サービスコード一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<TokuteiShinryoServiceCode> result = sut.get特定診療サービスコード一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7120TokuteiShinryoServiceCodeEntity> entityList = Arrays.asList(DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<TokuteiShinryoServiceCode> result = sut.get特定診療サービスコード一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサービス種類コード().value(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    public static class save特定診療サービスコード extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7120TokuteiShinryoServiceCodeEntity.class))).thenReturn(1);

            DbT7120TokuteiShinryoServiceCodeEntity entity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            TokuteiShinryoServiceCode 特定診療サービスコード = new TokuteiShinryoServiceCode(entity);

            assertThat(sut.save特定診療サービスコード(特定診療サービスコード), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7120TokuteiShinryoServiceCodeEntity.class))).thenReturn(0);

            DbT7120TokuteiShinryoServiceCodeEntity entity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            TokuteiShinryoServiceCode 特定診療サービスコード = new TokuteiShinryoServiceCode(entity);

            assertThat(sut.save特定診療サービスコード(特定診療サービスコード), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7120TokuteiShinryoServiceCodeEntity.class))).thenReturn(1);

            DbT7120TokuteiShinryoServiceCodeEntity entity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            entity.initializeMd5();
            TokuteiShinryoServiceCode 特定診療サービスコード = new TokuteiShinryoServiceCode(entity);
            特定診療サービスコード = 特定診療サービスコード.createBuilderForEdit().set単位数識別(new RString("任意項目1を変更")).build();

            assertThat(sut.save特定診療サービスコード(特定診療サービスコード), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7120TokuteiShinryoServiceCodeEntity.class))).thenReturn(0);

            DbT7120TokuteiShinryoServiceCodeEntity entity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            entity.initializeMd5();
            TokuteiShinryoServiceCode 特定診療サービスコード = new TokuteiShinryoServiceCode(entity);
            特定診療サービスコード = 特定診療サービスコード.createBuilderForEdit().set単位数識別(new RString("任意項目1を変更")).build();

            assertThat(sut.save特定診療サービスコード(特定診療サービスコード), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7120TokuteiShinryoServiceCodeEntity.class))).thenReturn(1);

            DbT7120TokuteiShinryoServiceCodeEntity entity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            entity.initializeMd5();
            TokuteiShinryoServiceCode 特定診療サービスコード = new TokuteiShinryoServiceCode(entity);
            特定診療サービスコード = 特定診療サービスコード.deleted();

            assertThat(sut.save特定診療サービスコード(特定診療サービスコード), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7120TokuteiShinryoServiceCodeEntity.class))).thenReturn(0);

            DbT7120TokuteiShinryoServiceCodeEntity entity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            entity.initializeMd5();
            TokuteiShinryoServiceCode 特定診療サービスコード = new TokuteiShinryoServiceCode(entity);
            特定診療サービスコード = 特定診療サービスコード.deleted();

            assertThat(sut.save特定診療サービスコード(特定診療サービスコード), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7120TokuteiShinryoServiceCodeEntity entity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            entity.initializeMd5();
            TokuteiShinryoServiceCode 特定診療サービスコード = new TokuteiShinryoServiceCode(entity);

            assertThat(sut.save特定診療サービスコード(特定診療サービスコード), is(false));
        }
    }
}
