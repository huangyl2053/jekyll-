/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KibetsuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KibetsuManagerTest {

    private static DbT2003KibetsuDac dac;
    private static KibetsuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2003KibetsuDac.class);
        sut = new KibetsuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護期別 extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT2003KibetsuEntityGenerator.DEFAULT_主キー2;
            sut.get介護期別(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT2003KibetsuEntityGenerator.DEFAULT_主キー1;
            sut.get介護期別(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT2003KibetsuEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT2003KibetsuEntityGenerator.DEFAULT_主キー2;
            Kibetsu result = sut.get介護期別(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT2003KibetsuEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT2003KibetsuEntityGenerator.DEFAULT_主キー2;
            Kibetsu result = sut.get介護期別(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT2003KibetsuEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護期別一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<Kibetsu> result = sut.get介護期別一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT2003KibetsuEntity> entityList = Arrays.asList(DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<Kibetsu> result = sut.get介護期別一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT2003KibetsuEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save介護期別 extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(1);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            Kibetsu 介護期別 = new Kibetsu(entity);

            assertThat(sut.save介護期別(介護期別), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(0);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            Kibetsu 介護期別 = new Kibetsu(entity);

            assertThat(sut.save介護期別(介護期別), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(1);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護期別(介護期別), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(0);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護期別(介護期別), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(1);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.deleted();

            assertThat(sut.save介護期別(介護期別), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(0);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.deleted();

            assertThat(sut.save介護期別(介護期別), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);

            assertThat(sut.save介護期別(介護期別), is(false));
        }
    }
}
