/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5208NinteichosahyoServiceJokyoFlagDac;
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
 * {link NinteichosahyoServiceJokyoFlagManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteichosahyoServiceJokyoFlagManagerTest {

    private static DbT5208NinteichosahyoServiceJokyoFlagDac dac;
    private static NinteichosahyoServiceJokyoFlagManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5208NinteichosahyoServiceJokyoFlagDac.class);
        sut = new NinteichosahyoServiceJokyoFlagManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_概況調査_サービスの状況フラグ extends DbzTestBase {

        ShinseishoKanriNo 申請書管理番号 = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.DEFAULT_申請書管理番号;
        int 認定調査依頼履歴番号 = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.DEFAULT_認定調査依頼履歴番号;
        int 連番 = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.DEFAULT_連番;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のShinseishoKanriNoにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get認定調査票_概況調査_サービスの状況フラグ(null, 認定調査依頼履歴番号, 連番);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class), any(int.class))).thenReturn(null);

            NinteichosahyoServiceJokyoFlag result = sut.get認定調査票_概況調査_サービスの状況フラグ(申請書管理番号, 認定調査依頼履歴番号, 連番);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5208NinteichosahyoServiceJokyoFlagEntity entity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class), any(int.class))).thenReturn(entity);

            NinteichosahyoServiceJokyoFlag result = sut.get認定調査票_概況調査_サービスの状況フラグ(申請書管理番号, 認定調査依頼履歴番号, 連番);

            assertThat(result.get申請書管理番号().value(), is(DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_概況調査_サービスの状況フラグ一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteichosahyoServiceJokyoFlag> result = sut.get認定調査票_概況調査_サービスの状況フラグ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> entityList = Arrays.asList(DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteichosahyoServiceJokyoFlag> result = sut.get認定調査票_概況調査_サービスの状況フラグ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save認定調査票_概況調査_サービスの状況フラグ extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5208NinteichosahyoServiceJokyoFlagEntity.class))).thenReturn(1);

            DbT5208NinteichosahyoServiceJokyoFlagEntity entity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();
            NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ = new NinteichosahyoServiceJokyoFlag(entity);

            assertThat(sut.save認定調査票_概況調査_サービスの状況フラグ(認定調査票_概況調査_サービスの状況フラグ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5208NinteichosahyoServiceJokyoFlagEntity.class))).thenReturn(0);

            DbT5208NinteichosahyoServiceJokyoFlagEntity entity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();
            NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ = new NinteichosahyoServiceJokyoFlag(entity);

            assertThat(sut.save認定調査票_概況調査_サービスの状況フラグ(認定調査票_概況調査_サービスの状況フラグ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5208NinteichosahyoServiceJokyoFlagEntity.class))).thenReturn(1);

            DbT5208NinteichosahyoServiceJokyoFlagEntity entity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();
            entity.initializeMd5();
            NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ = new NinteichosahyoServiceJokyoFlag(entity);
            認定調査票_概況調査_サービスの状況フラグ = 認定調査票_概況調査_サービスの状況フラグ.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save認定調査票_概況調査_サービスの状況フラグ(認定調査票_概況調査_サービスの状況フラグ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5208NinteichosahyoServiceJokyoFlagEntity.class))).thenReturn(0);

            DbT5208NinteichosahyoServiceJokyoFlagEntity entity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();
            entity.initializeMd5();
            NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ = new NinteichosahyoServiceJokyoFlag(entity);
            認定調査票_概況調査_サービスの状況フラグ = 認定調査票_概況調査_サービスの状況フラグ.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save認定調査票_概況調査_サービスの状況フラグ(認定調査票_概況調査_サービスの状況フラグ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5208NinteichosahyoServiceJokyoFlagEntity.class))).thenReturn(1);

            DbT5208NinteichosahyoServiceJokyoFlagEntity entity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();
            entity.initializeMd5();
            NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ = new NinteichosahyoServiceJokyoFlag(entity);
            認定調査票_概況調査_サービスの状況フラグ = 認定調査票_概況調査_サービスの状況フラグ.deleted();

            assertThat(sut.save認定調査票_概況調査_サービスの状況フラグ(認定調査票_概況調査_サービスの状況フラグ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5208NinteichosahyoServiceJokyoFlagEntity.class))).thenReturn(0);

            DbT5208NinteichosahyoServiceJokyoFlagEntity entity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();
            entity.initializeMd5();
            NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ = new NinteichosahyoServiceJokyoFlag(entity);
            認定調査票_概況調査_サービスの状況フラグ = 認定調査票_概況調査_サービスの状況フラグ.deleted();

            assertThat(sut.save認定調査票_概況調査_サービスの状況フラグ(認定調査票_概況調査_サービスの状況フラグ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5208NinteichosahyoServiceJokyoFlagEntity entity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();
            entity.initializeMd5();
            NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ = new NinteichosahyoServiceJokyoFlag(entity);

            assertThat(sut.save認定調査票_概況調査_サービスの状況フラグ(認定調査票_概況調査_サービスの状況フラグ), is(false));
        }
    }
}
