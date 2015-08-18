/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5206GaikyoTokkiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5206GaikyoTokkiDac;
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
 * {link GaikyoTokkiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GaikyoTokkiManagerTest {

    private static DbT5206GaikyoTokkiDac dac;
    private static GaikyoTokkiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5206GaikyoTokkiDac.class);
        sut = new GaikyoTokkiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_概況特記 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            int 主キー2 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_認定調査依頼履歴番号;
            sut.get認定調査票_概況特記(null, 主キー2);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(null);

            ShinseishoKanriNo 主キー1 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_申請書管理番号;
            int 主キー2 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_認定調査依頼履歴番号;
            GaikyoTokki result = sut.get認定調査票_概況特記(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5206GaikyoTokkiEntity entity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(entity);
            ShinseishoKanriNo 主キー1 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_申請書管理番号;
            int 主キー2 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_認定調査依頼履歴番号;
            GaikyoTokki result = sut.get認定調査票_概況特記(主キー1, 主キー2);

            assertThat(result.get申請書管理番号().value(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_概況特記一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<GaikyoTokki> result = sut.get認定調査票_概況特記一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5206GaikyoTokkiEntity> entityList = Arrays.asList(DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<GaikyoTokki> result = sut.get認定調査票_概況特記一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save認定調査票_概況特記 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5206GaikyoTokkiEntity.class))).thenReturn(1);

            DbT5206GaikyoTokkiEntity entity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
            GaikyoTokki 認定調査票_概況特記 = new GaikyoTokki(entity);

            assertThat(sut.save認定調査票_概況特記(認定調査票_概況特記), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5206GaikyoTokkiEntity.class))).thenReturn(0);

            DbT5206GaikyoTokkiEntity entity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
            GaikyoTokki 認定調査票_概況特記 = new GaikyoTokki(entity);

            assertThat(sut.save認定調査票_概況特記(認定調査票_概況特記), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5206GaikyoTokkiEntity.class))).thenReturn(1);

            DbT5206GaikyoTokkiEntity entity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
            entity.initializeMd5();
            GaikyoTokki 認定調査票_概況特記 = new GaikyoTokki(entity);
            認定調査票_概況特記 = 認定調査票_概況特記.createBuilderForEdit().set概況特記事項_主訴(new RString("任意項目1を変更")).build();

            assertThat(sut.save認定調査票_概況特記(認定調査票_概況特記), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5206GaikyoTokkiEntity.class))).thenReturn(0);

            DbT5206GaikyoTokkiEntity entity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
            entity.initializeMd5();
            GaikyoTokki 認定調査票_概況特記 = new GaikyoTokki(entity);
            認定調査票_概況特記 = 認定調査票_概況特記.createBuilderForEdit().set概況特記事項_主訴(new RString("任意項目1を変更")).build();

            assertThat(sut.save認定調査票_概況特記(認定調査票_概況特記), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5206GaikyoTokkiEntity.class))).thenReturn(1);

            DbT5206GaikyoTokkiEntity entity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
            entity.initializeMd5();
            GaikyoTokki 認定調査票_概況特記 = new GaikyoTokki(entity);
            認定調査票_概況特記 = 認定調査票_概況特記.deleted();

            assertThat(sut.save認定調査票_概況特記(認定調査票_概況特記), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5206GaikyoTokkiEntity.class))).thenReturn(0);

            DbT5206GaikyoTokkiEntity entity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
            entity.initializeMd5();
            GaikyoTokki 認定調査票_概況特記 = new GaikyoTokki(entity);
            認定調査票_概況特記 = 認定調査票_概況特記.deleted();

            assertThat(sut.save認定調査票_概況特記(認定調査票_概況特記), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5206GaikyoTokkiEntity entity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
            entity.initializeMd5();
            GaikyoTokki 認定調査票_概況特記 = new GaikyoTokki(entity);

            assertThat(sut.save認定調査票_概況特記(認定調査票_概況特記), is(false));
        }
    }
}
