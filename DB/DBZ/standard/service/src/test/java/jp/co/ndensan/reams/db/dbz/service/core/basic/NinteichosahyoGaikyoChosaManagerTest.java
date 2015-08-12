/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5202NinteichosahyoGaikyoChosaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5202NinteichosahyoGaikyoChosaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link NinteichosahyoGaikyoChosaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoGaikyoChosaManagerTest {

    private static DbT5202NinteichosahyoGaikyoChosaDac dac;
    private static NinteichosahyoGaikyoChosaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5202NinteichosahyoGaikyoChosaDac.class);
        sut = new NinteichosahyoGaikyoChosaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_概況調査_子 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_主キー2;
            sut.get認定調査票_概況調査_子(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_主キー1;
            sut.get認定調査票_概況調査_子(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_主キー2;
            NinteichosahyoGaikyoChosa result = sut.get認定調査票_概況調査_子(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5202NinteichosahyoGaikyoChosaEntity entity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_主キー2;
            NinteichosahyoGaikyoChosa result = sut.get認定調査票_概況調査_子(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_概況調査_子一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteichosahyoGaikyoChosa> result = sut.get認定調査票_概況調査_子一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5202NinteichosahyoGaikyoChosaEntity> entityList = Arrays.asList(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteichosahyoGaikyoChosa> result = sut.get認定調査票_概況調査_子一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save認定調査票_概況調査_子 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5202NinteichosahyoGaikyoChosaEntity.class))).thenReturn(1);

            DbT5202NinteichosahyoGaikyoChosaEntity entity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();
            NinteichosahyoGaikyoChosa 認定調査票_概況調査_子 = new NinteichosahyoGaikyoChosa(entity);

            assertThat(sut.save認定調査票_概況調査_子(認定調査票_概況調査_子), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5202NinteichosahyoGaikyoChosaEntity.class))).thenReturn(0);

            DbT5202NinteichosahyoGaikyoChosaEntity entity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();
            NinteichosahyoGaikyoChosa 認定調査票_概況調査_子 = new NinteichosahyoGaikyoChosa(entity);

            assertThat(sut.save認定調査票_概況調査_子(認定調査票_概況調査_子), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5202NinteichosahyoGaikyoChosaEntity.class))).thenReturn(1);

            DbT5202NinteichosahyoGaikyoChosaEntity entity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();
            entity.initializeMd5();
            NinteichosahyoGaikyoChosa 認定調査票_概況調査_子 = new NinteichosahyoGaikyoChosa(entity);
            認定調査票_概況調査_子 = 認定調査票_概況調査_子.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save認定調査票_概況調査_子(認定調査票_概況調査_子), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5202NinteichosahyoGaikyoChosaEntity.class))).thenReturn(0);

            DbT5202NinteichosahyoGaikyoChosaEntity entity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();
            entity.initializeMd5();
            NinteichosahyoGaikyoChosa 認定調査票_概況調査_子 = new NinteichosahyoGaikyoChosa(entity);
            認定調査票_概況調査_子 = 認定調査票_概況調査_子.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save認定調査票_概況調査_子(認定調査票_概況調査_子), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5202NinteichosahyoGaikyoChosaEntity.class))).thenReturn(1);

            DbT5202NinteichosahyoGaikyoChosaEntity entity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();
            entity.initializeMd5();
            NinteichosahyoGaikyoChosa 認定調査票_概況調査_子 = new NinteichosahyoGaikyoChosa(entity);
            認定調査票_概況調査_子 = 認定調査票_概況調査_子.deleted();

            assertThat(sut.save認定調査票_概況調査_子(認定調査票_概況調査_子), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5202NinteichosahyoGaikyoChosaEntity.class))).thenReturn(0);

            DbT5202NinteichosahyoGaikyoChosaEntity entity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();
            entity.initializeMd5();
            NinteichosahyoGaikyoChosa 認定調査票_概況調査_子 = new NinteichosahyoGaikyoChosa(entity);
            認定調査票_概況調査_子 = 認定調査票_概況調査_子.deleted();

            assertThat(sut.save認定調査票_概況調査_子(認定調査票_概況調査_子), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5202NinteichosahyoGaikyoChosaEntity entity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();
            entity.initializeMd5();
            NinteichosahyoGaikyoChosa 認定調査票_概況調査_子 = new NinteichosahyoGaikyoChosa(entity);

            assertThat(sut.save認定調査票_概況調査_子(認定調査票_概況調査_子), is(false));
        }
    }
}
