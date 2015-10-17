/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ServiceCode;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7119ServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7119ServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7119ServiceCodeDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link ServiceCodeManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ServiceCodeManagerTest {

    private static DbT7119ServiceCodeDac dac;
    private static ServiceCodeManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7119ServiceCodeDac.class);
        sut = new ServiceCodeManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class getサービスコード extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceKomokuCode 主キー2 = DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            FlexibleYearMonth 主キー3 = DbT7119ServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7119ServiceCodeEntityGenerator.DEFAULT_履歴番号;
            sut.getサービスコード(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceShuruiCode 主キー1 = DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー3 = DbT7119ServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7119ServiceCodeEntityGenerator.DEFAULT_履歴番号;
            sut.getサービスコード(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceShuruiCode 主キー1 = DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー2 = DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            int 主キー4 = DbT7119ServiceCodeEntityGenerator.DEFAULT_履歴番号;
            sut.getサービスコード(主キー1, 主キー2, null, 主キー4);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ServiceShuruiCode.class), any(ServiceKomokuCode.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);
            ServiceShuruiCode 主キー1 = DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー2 = DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            FlexibleYearMonth 主キー3 = DbT7119ServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7119ServiceCodeEntityGenerator.DEFAULT_履歴番号;
            ServiceCode result = sut.getサービスコード(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            when(dac.selectByKey(any(ServiceShuruiCode.class), any(ServiceKomokuCode.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);
            ServiceShuruiCode 主キー1 = DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
            ServiceKomokuCode 主キー2 = DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
            FlexibleYearMonth 主キー3 = DbT7119ServiceCodeEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7119ServiceCodeEntityGenerator.DEFAULT_履歴番号;
            ServiceCode result = sut.getサービスコード(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.getサービス種類コード().value(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class getサービスコード一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ServiceCode> result = sut.getサービスコード一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7119ServiceCodeEntity> entityList = Arrays.asList(DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ServiceCode> result = sut.getサービスコード一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサービス種類コード().value(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    public static class saveサービスコード extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(1);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            ServiceCode サービスコード = new ServiceCode(entity);

            assertThat(sut.saveサービスコード(サービスコード), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(0);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            ServiceCode サービスコード = new ServiceCode(entity);

            assertThat(sut.saveサービスコード(サービスコード), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(1);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            entity.initializeMd5();
            ServiceCode サービスコード = new ServiceCode(entity);
            サービスコード = サービスコード.createBuilderForEdit().setサービス名称(new RString("任意項目1を変更")).build();

            assertThat(sut.saveサービスコード(サービスコード), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(0);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            entity.initializeMd5();
            ServiceCode サービスコード = new ServiceCode(entity);
            サービスコード = サービスコード.createBuilderForEdit().setサービス名称(new RString("任意項目1を変更")).build();

            assertThat(sut.saveサービスコード(サービスコード), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(1);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            entity.initializeMd5();
            ServiceCode サービスコード = new ServiceCode(entity);
            サービスコード = サービスコード.deleted();

            assertThat(sut.saveサービスコード(サービスコード), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(0);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            entity.initializeMd5();
            ServiceCode サービスコード = new ServiceCode(entity);
            サービスコード = サービスコード.deleted();

            assertThat(sut.saveサービスコード(サービスコード), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            entity.initializeMd5();
            ServiceCode サービスコード = new ServiceCode(entity);

            assertThat(sut.saveサービスコード(サービスコード), is(false));
        }
    }
}
