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
 * {link FukaErrorListManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaErrorListManagerTest {

    private static DbT2010FukaErrorListDac dac;
    private static FukaErrorListManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2010FukaErrorListDac.class);
        sut = new FukaErrorListManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get賦課エラー一覧 extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT2010FukaErrorListEntityGenerator.DEFAULT_主キー2;
            sut.get賦課エラー一覧(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT2010FukaErrorListEntityGenerator.DEFAULT_主キー1;
            sut.get賦課エラー一覧(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT2010FukaErrorListEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT2010FukaErrorListEntityGenerator.DEFAULT_主キー2;
            FukaErrorList result = sut.get賦課エラー一覧(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT2010FukaErrorListEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT2010FukaErrorListEntityGenerator.DEFAULT_主キー2;
            FukaErrorList result = sut.get賦課エラー一覧(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get賦課エラー一覧一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<FukaErrorList> result = sut.get賦課エラー一覧一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT2010FukaErrorListEntity> entityList = Arrays.asList(DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<FukaErrorList> result = sut.get賦課エラー一覧一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save賦課エラー一覧 extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(1);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(0);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(1);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.initializeMd5();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);
            賦課エラー一覧 = 賦課エラー一覧.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(0);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.initializeMd5();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);
            賦課エラー一覧 = 賦課エラー一覧.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(1);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.initializeMd5();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);
            賦課エラー一覧 = 賦課エラー一覧.deleted();

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(0);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.initializeMd5();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);
            賦課エラー一覧 = 賦課エラー一覧.deleted();

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.initializeMd5();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(false));
        }
    }
}
