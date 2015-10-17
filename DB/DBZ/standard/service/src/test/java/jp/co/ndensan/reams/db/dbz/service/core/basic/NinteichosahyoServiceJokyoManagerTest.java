/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5207NinteichosahyoServiceJokyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5207NinteichosahyoServiceJokyoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link NinteichosahyoServiceJokyoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoServiceJokyoManagerTest {

    private static DbT5207NinteichosahyoServiceJokyoDac dac;
    private static NinteichosahyoServiceJokyoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5207NinteichosahyoServiceJokyoDac.class);
        sut = new NinteichosahyoServiceJokyoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_概況調査_サービスの状況 extends DbzTestBase {

        ShinseishoKanriNo 申請書管理番号 = DbT5207NinteichosahyoServiceJokyoEntityGenerator.DEFAULT_申請書管理番号;
        int 認定調査依頼履歴番号 = DbT5207NinteichosahyoServiceJokyoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
        int 連番 = DbT5207NinteichosahyoServiceJokyoEntityGenerator.DEFAULT_連番;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のShinseishoKanriNoにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get認定調査票_概況調査_サービスの状況(null, 認定調査依頼履歴番号, 連番);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class), any(int.class))).thenReturn(null);

            NinteichosahyoServiceJokyo result = sut.get認定調査票_概況調査_サービスの状況(申請書管理番号, 認定調査依頼履歴番号, 連番);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5207NinteichosahyoServiceJokyoEntity entity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class), any(int.class))).thenReturn(entity);

            NinteichosahyoServiceJokyo result = sut.get認定調査票_概況調査_サービスの状況(申請書管理番号, 認定調査依頼履歴番号, 連番);

            assertThat(result.get申請書管理番号().value(), is(DbT5207NinteichosahyoServiceJokyoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_概況調査_サービスの状況一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteichosahyoServiceJokyo> result = sut.get認定調査票_概況調査_サービスの状況一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5207NinteichosahyoServiceJokyoEntity> entityList = Arrays.asList(DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteichosahyoServiceJokyo> result = sut.get認定調査票_概況調査_サービスの状況一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5207NinteichosahyoServiceJokyoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save認定調査票_概況調査_サービスの状況 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5207NinteichosahyoServiceJokyoEntity.class))).thenReturn(1);

            DbT5207NinteichosahyoServiceJokyoEntity entity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();
            NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況 = new NinteichosahyoServiceJokyo(entity);

            assertThat(sut.save認定調査票_概況調査_サービスの状況(認定調査票_概況調査_サービスの状況), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5207NinteichosahyoServiceJokyoEntity.class))).thenReturn(0);

            DbT5207NinteichosahyoServiceJokyoEntity entity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();
            NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況 = new NinteichosahyoServiceJokyo(entity);

            assertThat(sut.save認定調査票_概況調査_サービスの状況(認定調査票_概況調査_サービスの状況), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5207NinteichosahyoServiceJokyoEntity.class))).thenReturn(1);

            DbT5207NinteichosahyoServiceJokyoEntity entity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();
            entity.initializeMd5();
            NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況 = new NinteichosahyoServiceJokyo(entity);
            認定調査票_概況調査_サービスの状況 = 認定調査票_概況調査_サービスの状況.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save認定調査票_概況調査_サービスの状況(認定調査票_概況調査_サービスの状況), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5207NinteichosahyoServiceJokyoEntity.class))).thenReturn(0);

            DbT5207NinteichosahyoServiceJokyoEntity entity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();
            entity.initializeMd5();
            NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況 = new NinteichosahyoServiceJokyo(entity);
            認定調査票_概況調査_サービスの状況 = 認定調査票_概況調査_サービスの状況.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save認定調査票_概況調査_サービスの状況(認定調査票_概況調査_サービスの状況), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5207NinteichosahyoServiceJokyoEntity.class))).thenReturn(1);

            DbT5207NinteichosahyoServiceJokyoEntity entity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();
            entity.initializeMd5();
            NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況 = new NinteichosahyoServiceJokyo(entity);
            認定調査票_概況調査_サービスの状況 = 認定調査票_概況調査_サービスの状況.deleted();

            assertThat(sut.save認定調査票_概況調査_サービスの状況(認定調査票_概況調査_サービスの状況), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5207NinteichosahyoServiceJokyoEntity.class))).thenReturn(0);

            DbT5207NinteichosahyoServiceJokyoEntity entity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();
            entity.initializeMd5();
            NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況 = new NinteichosahyoServiceJokyo(entity);
            認定調査票_概況調査_サービスの状況 = 認定調査票_概況調査_サービスの状況.deleted();

            assertThat(sut.save認定調査票_概況調査_サービスの状況(認定調査票_概況調査_サービスの状況), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5207NinteichosahyoServiceJokyoEntity entity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();
            entity.initializeMd5();
            NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況 = new NinteichosahyoServiceJokyo(entity);

            assertThat(sut.save認定調査票_概況調査_サービスの状況(認定調査票_概況調査_サービスの状況), is(false));
        }
    }
}
