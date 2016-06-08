/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7112ShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {link ShokanShuruiShikyuGendoGakuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanShuruiShikyuGendoGakuManagerTest {

    private static DbT7112ShokanShuruiShikyuGendoGakuDac dac;
    private static ShokanShuruiShikyuGendoGakuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7112ShokanShuruiShikyuGendoGakuDac.class);
        sut = new ShokanShuruiShikyuGendoGakuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払い給付種類支給限度額 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー3 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払い給付種類支給限度額(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceShuruiCode 主キー1 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
            int 主キー3 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払い給付種類支給限度額(主キー1, null, 主キー3);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ServiceShuruiCode.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);
            ServiceShuruiCode 主キー1 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー3 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            ShokanShuruiShikyuGendoGaku result = sut.get償還払い給付種類支給限度額(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7112ShokanShuruiShikyuGendoGakuEntity entity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            when(dac.selectByKey(any(ServiceShuruiCode.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);
            ServiceShuruiCode 主キー1 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
            int 主キー3 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
            ShokanShuruiShikyuGendoGaku result = sut.get償還払い給付種類支給限度額(主キー1, 主キー2, 主キー3);

            assertThat(result.getサービス種類コード().value(), is(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払い給付種類支給限度額一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanShuruiShikyuGendoGaku> result = sut.get償還払い給付種類支給限度額一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7112ShokanShuruiShikyuGendoGakuEntity> entityList = Arrays.asList(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanShuruiShikyuGendoGaku> result = sut.get償還払い給付種類支給限度額一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサービス種類コード().value(), is(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    public static class save償還払い給付種類支給限度額 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7112ShokanShuruiShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7112ShokanShuruiShikyuGendoGakuEntity entity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            ShokanShuruiShikyuGendoGaku 償還払い給付種類支給限度額 = new ShokanShuruiShikyuGendoGaku(entity);

            assertThat(sut.save償還払い給付種類支給限度額(償還払い給付種類支給限度額), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7112ShokanShuruiShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7112ShokanShuruiShikyuGendoGakuEntity entity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            ShokanShuruiShikyuGendoGaku 償還払い給付種類支給限度額 = new ShokanShuruiShikyuGendoGaku(entity);

            assertThat(sut.save償還払い給付種類支給限度額(償還払い給付種類支給限度額), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7112ShokanShuruiShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7112ShokanShuruiShikyuGendoGakuEntity entity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            entity.initializeMd5();
            ShokanShuruiShikyuGendoGaku 償還払い給付種類支給限度額 = new ShokanShuruiShikyuGendoGaku(entity);
            償還払い給付種類支給限度額 = 償還払い給付種類支給限度額.createBuilderForEdit().set支給限度単位数(new Decimal(300)).build();

            assertThat(sut.save償還払い給付種類支給限度額(償還払い給付種類支給限度額), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7112ShokanShuruiShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7112ShokanShuruiShikyuGendoGakuEntity entity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            entity.initializeMd5();
            ShokanShuruiShikyuGendoGaku 償還払い給付種類支給限度額 = new ShokanShuruiShikyuGendoGaku(entity);
            償還払い給付種類支給限度額 = 償還払い給付種類支給限度額.createBuilderForEdit().set支給限度単位数(new Decimal(300)).build();

            assertThat(sut.save償還払い給付種類支給限度額(償還払い給付種類支給限度額), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7112ShokanShuruiShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7112ShokanShuruiShikyuGendoGakuEntity entity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            entity.initializeMd5();
            ShokanShuruiShikyuGendoGaku 償還払い給付種類支給限度額 = new ShokanShuruiShikyuGendoGaku(entity);
            償還払い給付種類支給限度額 = 償還払い給付種類支給限度額.deleted();

            assertThat(sut.save償還払い給付種類支給限度額(償還払い給付種類支給限度額), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7112ShokanShuruiShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7112ShokanShuruiShikyuGendoGakuEntity entity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            entity.initializeMd5();
            ShokanShuruiShikyuGendoGaku 償還払い給付種類支給限度額 = new ShokanShuruiShikyuGendoGaku(entity);
            償還払い給付種類支給限度額 = 償還払い給付種類支給限度額.deleted();

            assertThat(sut.save償還払い給付種類支給限度額(償還払い給付種類支給限度額), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7112ShokanShuruiShikyuGendoGakuEntity entity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            entity.initializeMd5();
            ShokanShuruiShikyuGendoGaku 償還払い給付種類支給限度額 = new ShokanShuruiShikyuGendoGaku(entity);

            assertThat(sut.save償還払い給付種類支給限度額(償還払い給付種類支給限度額), is(false));
        }
    }
}
