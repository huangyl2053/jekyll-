/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseServiceShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7114UwanoseServiceShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
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
 * {link UwanoseServiceShuruiShikyuGendoGakuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class UwanoseServiceShuruiShikyuGendoGakuManagerTest {

    private static DbT7114UwanoseServiceShuruiShikyuGendoGakuDac dac;
    private static UwanoseServiceShuruiShikyuGendoGakuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7114UwanoseServiceShuruiShikyuGendoGakuDac.class);
        sut = new UwanoseServiceShuruiShikyuGendoGakuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get上乗せサービス種類支給限度額 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のServiceShuruiCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            FlexibleYearMonth 主キー3 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get上乗せサービス種類支給限度額(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のRStringにnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceShuruiCode 主キー1 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー3 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get上乗せサービス種類支給限度額(主キー1, null, 主キー3, 主キー4);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ServiceShuruiCode.class), any(RString.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);

            ServiceShuruiCode 主キー1 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
            RString 主キー2 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            FlexibleYearMonth 主キー3 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            UwanoseServiceShuruiShikyuGendoGaku result = sut.get上乗せサービス種類支給限度額(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            when(dac.selectByKey(any(ServiceShuruiCode.class), any(RString.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);

            ServiceShuruiCode 主キー1 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
            RString 主キー2 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
            FlexibleYearMonth 主キー3 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー4 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            UwanoseServiceShuruiShikyuGendoGaku result = sut.get上乗せサービス種類支給限度額(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.getサービス種類コード().value(), is(DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get上乗せサービス種類支給限度額一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<UwanoseServiceShuruiShikyuGendoGaku> result = sut.get上乗せサービス種類支給限度額一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity> entityList = Arrays.asList(DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<UwanoseServiceShuruiShikyuGendoGaku> result = sut.get上乗せサービス種類支給限度額一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサービス種類コード().value(), is(DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    public static class save上乗せサービス種類支給限度額 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            UwanoseServiceShuruiShikyuGendoGaku 上乗せサービス種類支給限度額 = new UwanoseServiceShuruiShikyuGendoGaku(entity);

            assertThat(sut.save上乗せサービス種類支給限度額(上乗せサービス種類支給限度額), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            UwanoseServiceShuruiShikyuGendoGaku 上乗せサービス種類支給限度額 = new UwanoseServiceShuruiShikyuGendoGaku(entity);

            assertThat(sut.save上乗せサービス種類支給限度額(上乗せサービス種類支給限度額), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            entity.initializeMd5();
            UwanoseServiceShuruiShikyuGendoGaku 上乗せサービス種類支給限度額 = new UwanoseServiceShuruiShikyuGendoGaku(entity);
            上乗せサービス種類支給限度額 = 上乗せサービス種類支給限度額.createBuilderForEdit().set要介護状態区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save上乗せサービス種類支給限度額(上乗せサービス種類支給限度額), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            entity.initializeMd5();
            UwanoseServiceShuruiShikyuGendoGaku 上乗せサービス種類支給限度額 = new UwanoseServiceShuruiShikyuGendoGaku(entity);
            上乗せサービス種類支給限度額 = 上乗せサービス種類支給限度額.createBuilderForEdit().set要介護状態区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save上乗せサービス種類支給限度額(上乗せサービス種類支給限度額), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            entity.initializeMd5();
            UwanoseServiceShuruiShikyuGendoGaku 上乗せサービス種類支給限度額 = new UwanoseServiceShuruiShikyuGendoGaku(entity);
            上乗せサービス種類支給限度額 = 上乗せサービス種類支給限度額.deleted();

            assertThat(sut.save上乗せサービス種類支給限度額(上乗せサービス種類支給限度額), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            entity.initializeMd5();
            UwanoseServiceShuruiShikyuGendoGaku 上乗せサービス種類支給限度額 = new UwanoseServiceShuruiShikyuGendoGaku(entity);
            上乗せサービス種類支給限度額 = 上乗せサービス種類支給限度額.deleted();

            assertThat(sut.save上乗せサービス種類支給限度額(上乗せサービス種類支給限度額), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity entity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            entity.initializeMd5();
            UwanoseServiceShuruiShikyuGendoGaku 上乗せサービス種類支給限度額 = new UwanoseServiceShuruiShikyuGendoGaku(entity);

            assertThat(sut.save上乗せサービス種類支給限度額(上乗せサービス種類支給限度額), is(false));
        }
    }
}
