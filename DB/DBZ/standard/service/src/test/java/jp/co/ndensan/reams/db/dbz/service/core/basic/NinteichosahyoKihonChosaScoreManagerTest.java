/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaScore;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5204NinteichosahyoKihonChosaScoreEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5204NinteichosahyoKihonChosaScoreDac;
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
 * {link NinteichosahyoKihonChosaScoreManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoKihonChosaScoreManagerTest {

    private static DbT5204NinteichosahyoKihonChosaScoreDac dac;
    private static NinteichosahyoKihonChosaScoreManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5204NinteichosahyoKihonChosaScoreDac.class);
        sut = new NinteichosahyoKihonChosaScoreManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_基本調査素点 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の申請書管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
            int 要介護認定調査履歴番号 = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_要介護認定調査履歴番号;
            sut.get認定調査票_基本調査素点(null, 要介護認定調査履歴番号);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(null);

            ShinseishoKanriNo 申請書管理番号 = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_申請書管理番号;
            int 要介護認定調査履歴番号 = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_要介護認定調査履歴番号;
            NinteichosahyoKihonChosaScore result = sut.get認定調査票_基本調査素点(申請書管理番号, 要介護認定調査履歴番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5204NinteichosahyoKihonChosaScoreEntity entity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(entity);

            ShinseishoKanriNo 申請書管理番号 = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_申請書管理番号;
            int 要介護認定調査履歴番号 = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_要介護認定調査履歴番号;
            NinteichosahyoKihonChosaScore result = sut.get認定調査票_基本調査素点(申請書管理番号, 要介護認定調査履歴番号);

            assertThat(result.get申請書管理番号().value(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_基本調査素点一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteichosahyoKihonChosaScore> result = sut.get認定調査票_基本調査素点一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5204NinteichosahyoKihonChosaScoreEntity> entityList = Arrays.asList(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteichosahyoKihonChosaScore> result = sut.get認定調査票_基本調査素点一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save認定調査票_基本調査素点 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5204NinteichosahyoKihonChosaScoreEntity.class))).thenReturn(1);

            DbT5204NinteichosahyoKihonChosaScoreEntity entity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();
            NinteichosahyoKihonChosaScore 認定調査票_基本調査素点 = new NinteichosahyoKihonChosaScore(entity);

            assertThat(sut.save認定調査票_基本調査素点(認定調査票_基本調査素点), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5204NinteichosahyoKihonChosaScoreEntity.class))).thenReturn(0);

            DbT5204NinteichosahyoKihonChosaScoreEntity entity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();
            NinteichosahyoKihonChosaScore 認定調査票_基本調査素点 = new NinteichosahyoKihonChosaScore(entity);

            assertThat(sut.save認定調査票_基本調査素点(認定調査票_基本調査素点), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5204NinteichosahyoKihonChosaScoreEntity.class))).thenReturn(1);

            DbT5204NinteichosahyoKihonChosaScoreEntity entity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();
            entity.initializeMd5();
            NinteichosahyoKihonChosaScore 認定調査票_基本調査素点 = new NinteichosahyoKihonChosaScore(entity);
            認定調査票_基本調査素点 = 認定調査票_基本調査素点.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save認定調査票_基本調査素点(認定調査票_基本調査素点), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5204NinteichosahyoKihonChosaScoreEntity.class))).thenReturn(0);

            DbT5204NinteichosahyoKihonChosaScoreEntity entity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();
            entity.initializeMd5();
            NinteichosahyoKihonChosaScore 認定調査票_基本調査素点 = new NinteichosahyoKihonChosaScore(entity);
            認定調査票_基本調査素点 = 認定調査票_基本調査素点.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save認定調査票_基本調査素点(認定調査票_基本調査素点), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5204NinteichosahyoKihonChosaScoreEntity.class))).thenReturn(1);

            DbT5204NinteichosahyoKihonChosaScoreEntity entity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();
            entity.initializeMd5();
            NinteichosahyoKihonChosaScore 認定調査票_基本調査素点 = new NinteichosahyoKihonChosaScore(entity);
            認定調査票_基本調査素点 = 認定調査票_基本調査素点.deleted();

            assertThat(sut.save認定調査票_基本調査素点(認定調査票_基本調査素点), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5204NinteichosahyoKihonChosaScoreEntity.class))).thenReturn(0);

            DbT5204NinteichosahyoKihonChosaScoreEntity entity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();
            entity.initializeMd5();
            NinteichosahyoKihonChosaScore 認定調査票_基本調査素点 = new NinteichosahyoKihonChosaScore(entity);
            認定調査票_基本調査素点 = 認定調査票_基本調査素点.deleted();

            assertThat(sut.save認定調査票_基本調査素点(認定調査票_基本調査素点), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5204NinteichosahyoKihonChosaScoreEntity entity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();
            entity.initializeMd5();
            NinteichosahyoKihonChosaScore 認定調査票_基本調査素点 = new NinteichosahyoKihonChosaScore(entity);

            assertThat(sut.save認定調査票_基本調査素点(認定調査票_基本調査素点), is(false));
        }
    }
}
