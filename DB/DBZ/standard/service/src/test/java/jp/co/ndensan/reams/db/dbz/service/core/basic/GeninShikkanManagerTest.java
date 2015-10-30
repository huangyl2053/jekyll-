/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GeninShikkan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5300GeninShikkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5300GeninShikkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5300GeninShikkanDac;
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
 * {link GeninShikkanManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class GeninShikkanManagerTest {

    private static DbT5300GeninShikkanDac dac;
    private static GeninShikkanManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5300GeninShikkanDac.class);
        sut = new GeninShikkanManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get原因疾患 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の申請書管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
            int 連番 = DbT5300GeninShikkanEntityGenerator.DEFAULT_連番;
            sut.get原因疾患(null, 連番);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(null);

            ShinseishoKanriNo 申請書管理番号 = DbT5300GeninShikkanEntityGenerator.DEFAULT_申請書管理番号;
            int 連番 = DbT5300GeninShikkanEntityGenerator.DEFAULT_連番;
            GeninShikkan result = sut.get原因疾患(申請書管理番号, 連番);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5300GeninShikkanEntity entity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(entity);

            ShinseishoKanriNo 申請書管理番号 = DbT5300GeninShikkanEntityGenerator.DEFAULT_申請書管理番号;
            int 連番 = DbT5300GeninShikkanEntityGenerator.DEFAULT_連番;
            GeninShikkan result = sut.get原因疾患(申請書管理番号, 連番);

            assertThat(result.get申請書管理番号().value(), is(DbT5300GeninShikkanEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get原因疾患一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<GeninShikkan> result = sut.get原因疾患一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5300GeninShikkanEntity> entityList = Arrays.asList(DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<GeninShikkan> result = sut.get原因疾患一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5300GeninShikkanEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save原因疾患 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5300GeninShikkanEntity.class))).thenReturn(1);

            DbT5300GeninShikkanEntity entity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
            GeninShikkan 原因疾患 = new GeninShikkan(entity);

            assertThat(sut.save原因疾患(原因疾患), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5300GeninShikkanEntity.class))).thenReturn(0);

            DbT5300GeninShikkanEntity entity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
            GeninShikkan 原因疾患 = new GeninShikkan(entity);

            assertThat(sut.save原因疾患(原因疾患), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5300GeninShikkanEntity.class))).thenReturn(1);

            DbT5300GeninShikkanEntity entity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
            entity.initializeMd5();
            GeninShikkan 原因疾患 = new GeninShikkan(entity);
            原因疾患 = 原因疾患.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save原因疾患(原因疾患), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5300GeninShikkanEntity.class))).thenReturn(0);

            DbT5300GeninShikkanEntity entity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
            entity.initializeMd5();
            GeninShikkan 原因疾患 = new GeninShikkan(entity);
            原因疾患 = 原因疾患.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save原因疾患(原因疾患), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5300GeninShikkanEntity.class))).thenReturn(1);

            DbT5300GeninShikkanEntity entity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
            entity.initializeMd5();
            GeninShikkan 原因疾患 = new GeninShikkan(entity);
            原因疾患 = 原因疾患.deleted();

            assertThat(sut.save原因疾患(原因疾患), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5300GeninShikkanEntity.class))).thenReturn(0);

            DbT5300GeninShikkanEntity entity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
            entity.initializeMd5();
            GeninShikkan 原因疾患 = new GeninShikkan(entity);
            原因疾患 = 原因疾患.deleted();

            assertThat(sut.save原因疾患(原因疾患), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5300GeninShikkanEntity entity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
            entity.initializeMd5();
            GeninShikkan 原因疾患 = new GeninShikkan(entity);

            assertThat(sut.save原因疾患(原因疾患), is(false));
        }
    }
}
