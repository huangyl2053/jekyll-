/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5211NinteichosahyoChosaItemEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5211NinteichosahyoChosaItemDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link NinteichosahyoChosaItemManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteichosahyoChosaItemManagerTest {

    private static DbT5211NinteichosahyoChosaItemDac dac;
    private static NinteichosahyoChosaItemManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5211NinteichosahyoChosaItemDac.class);
        sut = new NinteichosahyoChosaItemManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_基本調査_調査項目 extends DbzTestBase {

        ShinseishoKanriNo 申請書管理番号 = DbT5211NinteichosahyoChosaItemEntityGenerator.DEFAULT_申請書管理番号;
        int 要介護認定調査履歴番号 = DbT5211NinteichosahyoChosaItemEntityGenerator.DEFAULT_要介護認定調査履歴番号;
        int 連番 = DbT5211NinteichosahyoChosaItemEntityGenerator.DEFAULT_連番;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の申請書管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get認定調査票_基本調査_調査項目(null, 要介護認定調査履歴番号, 連番);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class), any(int.class))).thenReturn(null);

            NinteichosahyoChosaItem result = sut.get認定調査票_基本調査_調査項目(申請書管理番号, 要介護認定調査履歴番号, 連番);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5211NinteichosahyoChosaItemEntity entity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class), any(int.class))).thenReturn(entity);

            NinteichosahyoChosaItem result = sut.get認定調査票_基本調査_調査項目(申請書管理番号, 要介護認定調査履歴番号, 連番);

            assertThat(result.get申請書管理番号().value(), is(DbT5211NinteichosahyoChosaItemEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_基本調査_調査項目一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteichosahyoChosaItem> result = sut.get認定調査票_基本調査_調査項目一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5211NinteichosahyoChosaItemEntity> entityList = Arrays.asList(DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteichosahyoChosaItem> result = sut.get認定調査票_基本調査_調査項目一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5211NinteichosahyoChosaItemEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save認定調査票_基本調査_調査項目 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5211NinteichosahyoChosaItemEntity.class))).thenReturn(1);

            DbT5211NinteichosahyoChosaItemEntity entity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();
            NinteichosahyoChosaItem 認定調査票_基本調査_調査項目 = new NinteichosahyoChosaItem(entity);

            assertThat(sut.save認定調査票_基本調査_調査項目(認定調査票_基本調査_調査項目), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5211NinteichosahyoChosaItemEntity.class))).thenReturn(0);

            DbT5211NinteichosahyoChosaItemEntity entity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();
            NinteichosahyoChosaItem 認定調査票_基本調査_調査項目 = new NinteichosahyoChosaItem(entity);

            assertThat(sut.save認定調査票_基本調査_調査項目(認定調査票_基本調査_調査項目), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5211NinteichosahyoChosaItemEntity.class))).thenReturn(1);

            DbT5211NinteichosahyoChosaItemEntity entity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();
            entity.initializeMd5();
            NinteichosahyoChosaItem 認定調査票_基本調査_調査項目 = new NinteichosahyoChosaItem(entity);
            認定調査票_基本調査_調査項目 = 認定調査票_基本調査_調査項目.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save認定調査票_基本調査_調査項目(認定調査票_基本調査_調査項目), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5211NinteichosahyoChosaItemEntity.class))).thenReturn(0);

            DbT5211NinteichosahyoChosaItemEntity entity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();
            entity.initializeMd5();
            NinteichosahyoChosaItem 認定調査票_基本調査_調査項目 = new NinteichosahyoChosaItem(entity);
            認定調査票_基本調査_調査項目 = 認定調査票_基本調査_調査項目.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save認定調査票_基本調査_調査項目(認定調査票_基本調査_調査項目), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5211NinteichosahyoChosaItemEntity.class))).thenReturn(1);

            DbT5211NinteichosahyoChosaItemEntity entity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();
            entity.initializeMd5();
            NinteichosahyoChosaItem 認定調査票_基本調査_調査項目 = new NinteichosahyoChosaItem(entity);
            認定調査票_基本調査_調査項目 = 認定調査票_基本調査_調査項目.deleted();

            assertThat(sut.save認定調査票_基本調査_調査項目(認定調査票_基本調査_調査項目), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5211NinteichosahyoChosaItemEntity.class))).thenReturn(0);

            DbT5211NinteichosahyoChosaItemEntity entity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();
            entity.initializeMd5();
            NinteichosahyoChosaItem 認定調査票_基本調査_調査項目 = new NinteichosahyoChosaItem(entity);
            認定調査票_基本調査_調査項目 = 認定調査票_基本調査_調査項目.deleted();

            assertThat(sut.save認定調査票_基本調査_調査項目(認定調査票_基本調査_調査項目), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5211NinteichosahyoChosaItemEntity entity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();
            entity.initializeMd5();
            NinteichosahyoChosaItem 認定調査票_基本調査_調査項目 = new NinteichosahyoChosaItem(entity);

            assertThat(sut.save認定調査票_基本調査_調査項目(認定調査票_基本調査_調査項目), is(false));
        }
    }
}
