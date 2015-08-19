/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseKubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7113UwanoseKubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.basic.DbT7113UwanoseKubunShikyuGendoGakuDac;
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
 * {link UwanoseKubunShikyuGendoGakuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class UwanoseKubunShikyuGendoGakuManagerTest {

    private static DbT7113UwanoseKubunShikyuGendoGakuDac dac;
    private static UwanoseKubunShikyuGendoGakuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7113UwanoseKubunShikyuGendoGakuDac.class);
        sut = new UwanoseKubunShikyuGendoGakuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get上乗せ居宅サービス区分支給限度額 extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.DEFAULT_主キー2;
            sut.get上乗せ居宅サービス区分支給限度額(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.DEFAULT_主キー1;
            sut.get上乗せ居宅サービス区分支給限度額(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.DEFAULT_主キー2;
            UwanoseKubunShikyuGendoGaku result = sut.get上乗せ居宅サービス区分支給限度額(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7113UwanoseKubunShikyuGendoGakuEntity entity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.DEFAULT_主キー2;
            UwanoseKubunShikyuGendoGaku result = sut.get上乗せ居宅サービス区分支給限度額(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get上乗せ居宅サービス区分支給限度額一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<UwanoseKubunShikyuGendoGaku> result = sut.get上乗せ居宅サービス区分支給限度額一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7113UwanoseKubunShikyuGendoGakuEntity> entityList = Arrays.asList(DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<UwanoseKubunShikyuGendoGaku> result = sut.get上乗せ居宅サービス区分支給限度額一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save上乗せ居宅サービス区分支給限度額 extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7113UwanoseKubunShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7113UwanoseKubunShikyuGendoGakuEntity entity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            UwanoseKubunShikyuGendoGaku 上乗せ居宅サービス区分支給限度額 = new UwanoseKubunShikyuGendoGaku(entity);

            assertThat(sut.save上乗せ居宅サービス区分支給限度額(上乗せ居宅サービス区分支給限度額), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7113UwanoseKubunShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7113UwanoseKubunShikyuGendoGakuEntity entity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            UwanoseKubunShikyuGendoGaku 上乗せ居宅サービス区分支給限度額 = new UwanoseKubunShikyuGendoGaku(entity);

            assertThat(sut.save上乗せ居宅サービス区分支給限度額(上乗せ居宅サービス区分支給限度額), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7113UwanoseKubunShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7113UwanoseKubunShikyuGendoGakuEntity entity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            UwanoseKubunShikyuGendoGaku 上乗せ居宅サービス区分支給限度額 = new UwanoseKubunShikyuGendoGaku(entity);
            上乗せ居宅サービス区分支給限度額 = 上乗せ居宅サービス区分支給限度額.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save上乗せ居宅サービス区分支給限度額(上乗せ居宅サービス区分支給限度額), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7113UwanoseKubunShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7113UwanoseKubunShikyuGendoGakuEntity entity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            UwanoseKubunShikyuGendoGaku 上乗せ居宅サービス区分支給限度額 = new UwanoseKubunShikyuGendoGaku(entity);
            上乗せ居宅サービス区分支給限度額 = 上乗せ居宅サービス区分支給限度額.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save上乗せ居宅サービス区分支給限度額(上乗せ居宅サービス区分支給限度額), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7113UwanoseKubunShikyuGendoGakuEntity.class))).thenReturn(1);

            DbT7113UwanoseKubunShikyuGendoGakuEntity entity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            UwanoseKubunShikyuGendoGaku 上乗せ居宅サービス区分支給限度額 = new UwanoseKubunShikyuGendoGaku(entity);
            上乗せ居宅サービス区分支給限度額 = 上乗せ居宅サービス区分支給限度額.deleted();

            assertThat(sut.save上乗せ居宅サービス区分支給限度額(上乗せ居宅サービス区分支給限度額), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7113UwanoseKubunShikyuGendoGakuEntity.class))).thenReturn(0);

            DbT7113UwanoseKubunShikyuGendoGakuEntity entity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            UwanoseKubunShikyuGendoGaku 上乗せ居宅サービス区分支給限度額 = new UwanoseKubunShikyuGendoGaku(entity);
            上乗せ居宅サービス区分支給限度額 = 上乗せ居宅サービス区分支給限度額.deleted();

            assertThat(sut.save上乗せ居宅サービス区分支給限度額(上乗せ居宅サービス区分支給限度額), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7113UwanoseKubunShikyuGendoGakuEntity entity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            entity.initializeMd5();
            UwanoseKubunShikyuGendoGaku 上乗せ居宅サービス区分支給限度額 = new UwanoseKubunShikyuGendoGaku(entity);

            assertThat(sut.save上乗せ居宅サービス区分支給限度額(上乗せ居宅サービス区分支給限度額), is(false));
        }
    }
}
