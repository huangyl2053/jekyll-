/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaScoreItem;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5212NinteichosahyoKihonChosaScoreItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5212NinteichosahyoKihonChosaScoreItemDac;
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
 * {link NinteichosahyoKihonChosaScoreItemManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoKihonChosaScoreItemManagerTest {

    private static DbT5212NinteichosahyoKihonChosaScoreItemDac dac;
    private static NinteichosahyoKihonChosaScoreItemManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5212NinteichosahyoKihonChosaScoreItemDac.class);
        sut = new NinteichosahyoKihonChosaScoreItemManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_基本調査素点項目 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_主キー2;
            sut.get認定調査票_基本調査素点項目(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_主キー1;
            sut.get認定調査票_基本調査素点項目(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_主キー2;
            NinteichosahyoKihonChosaScoreItem result = sut.get認定調査票_基本調査素点項目(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5212NinteichosahyoKihonChosaScoreItemEntity entity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_主キー2;
            NinteichosahyoKihonChosaScoreItem result = sut.get認定調査票_基本調査素点項目(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_基本調査素点項目一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteichosahyoKihonChosaScoreItem> result = sut.get認定調査票_基本調査素点項目一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5212NinteichosahyoKihonChosaScoreItemEntity> entityList = Arrays.asList(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteichosahyoKihonChosaScoreItem> result = sut.get認定調査票_基本調査素点項目一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save認定調査票_基本調査素点項目 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5212NinteichosahyoKihonChosaScoreItemEntity.class))).thenReturn(1);

            DbT5212NinteichosahyoKihonChosaScoreItemEntity entity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();
            NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目 = new NinteichosahyoKihonChosaScoreItem(entity);

            assertThat(sut.save認定調査票_基本調査素点項目(認定調査票_基本調査素点項目), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5212NinteichosahyoKihonChosaScoreItemEntity.class))).thenReturn(0);

            DbT5212NinteichosahyoKihonChosaScoreItemEntity entity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();
            NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目 = new NinteichosahyoKihonChosaScoreItem(entity);

            assertThat(sut.save認定調査票_基本調査素点項目(認定調査票_基本調査素点項目), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5212NinteichosahyoKihonChosaScoreItemEntity.class))).thenReturn(1);

            DbT5212NinteichosahyoKihonChosaScoreItemEntity entity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();
            entity.initializeMd5();
            NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目 = new NinteichosahyoKihonChosaScoreItem(entity);
            認定調査票_基本調査素点項目 = 認定調査票_基本調査素点項目.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save認定調査票_基本調査素点項目(認定調査票_基本調査素点項目), is(true)
            );
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5212NinteichosahyoKihonChosaScoreItemEntity.class))).thenReturn(0);

            DbT5212NinteichosahyoKihonChosaScoreItemEntity entity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();
            entity.initializeMd5();
            NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目 = new NinteichosahyoKihonChosaScoreItem(entity);
            認定調査票_基本調査素点項目 = 認定調査票_基本調査素点項目.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save認定調査票_基本調査素点項目(認定調査票_基本調査素点項目), is(false)
            );
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5212NinteichosahyoKihonChosaScoreItemEntity.class))).thenReturn(1);

            DbT5212NinteichosahyoKihonChosaScoreItemEntity entity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();
            entity.initializeMd5();
            NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目 = new NinteichosahyoKihonChosaScoreItem(entity);
            認定調査票_基本調査素点項目 = 認定調査票_基本調査素点項目.deleted();

            assertThat(sut.save認定調査票_基本調査素点項目(認定調査票_基本調査素点項目), is(true)
            );
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5212NinteichosahyoKihonChosaScoreItemEntity.class))).thenReturn(0);

            DbT5212NinteichosahyoKihonChosaScoreItemEntity entity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();
            entity.initializeMd5();
            NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目 = new NinteichosahyoKihonChosaScoreItem(entity);
            認定調査票_基本調査素点項目 = 認定調査票_基本調査素点項目.deleted();

            assertThat(sut.save認定調査票_基本調査素点項目(認定調査票_基本調査素点項目), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5212NinteichosahyoKihonChosaScoreItemEntity entity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();
            entity.initializeMd5();
            NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目 = new NinteichosahyoKihonChosaScoreItem(entity);

            assertThat(sut.save認定調査票_基本調査素点項目(認定調査票_基本調査素点項目), is(false));
        }
    }
}
