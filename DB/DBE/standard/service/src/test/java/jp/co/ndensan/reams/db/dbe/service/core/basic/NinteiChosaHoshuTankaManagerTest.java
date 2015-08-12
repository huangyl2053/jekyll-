/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuTanka;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5031NinteiChosaHoshuTankaEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5031NinteiChosaHoshuTankaDac;
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
 * {link NinteiChosaHoshuTankaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiChosaHoshuTankaManagerTest {

    private static DbT5031NinteiChosaHoshuTankaDac dac;
    private static NinteiChosaHoshuTankaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5031NinteiChosaHoshuTankaDac.class);
        sut = new NinteiChosaHoshuTankaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査報酬単価 extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_主キー2;
            sut.get認定調査報酬単価(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_主キー1;
            sut.get認定調査報酬単価(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_主キー2;
            NinteiChosaHoshuTanka result = sut.get認定調査報酬単価(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_主キー2;
            NinteiChosaHoshuTanka result = sut.get認定調査報酬単価(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査報酬単価一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteiChosaHoshuTanka> result = sut.get認定調査報酬単価一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5031NinteiChosaHoshuTankaEntity> entityList = Arrays.asList(DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteiChosaHoshuTanka> result = sut.get認定調査報酬単価一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save認定調査報酬単価 extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(1);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(0);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(1);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.initializeMd5();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);
            認定調査報酬単価 = 認定調査報酬単価.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(0);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.initializeMd5();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);
            認定調査報酬単価 = 認定調査報酬単価.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(1);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.initializeMd5();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);
            認定調査報酬単価 = 認定調査報酬単価.deleted();

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(0);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.initializeMd5();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);
            認定調査報酬単価 = 認定調査報酬単価.deleted();

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.initializeMd5();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(false));
        }
    }
}
