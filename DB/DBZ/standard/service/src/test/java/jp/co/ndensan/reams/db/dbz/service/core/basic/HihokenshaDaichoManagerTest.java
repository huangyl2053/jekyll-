/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link HihokenshaDaichoManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class HihokenshaDaichoManagerTest {

    private static DbT1001HihokenshaDaichoDac dac;
    private static HihokenshaDaichoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT1001HihokenshaDaichoDac.class);
        sut = new HihokenshaDaichoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get被保険者台帳管理 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
            RString 主キー3 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番;
            sut.get被保険者台帳管理(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番;
            sut.get被保険者台帳管理(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
            HihokenshaNo 主キー1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
            sut.get被保険者台帳管理(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleDate.class), any(RString.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
            RString 主キー3 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番;
            HihokenshaDaicho result = sut.get被保険者台帳管理(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleDate.class), any(RString.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
            RString 主キー3 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番;
            HihokenshaDaicho result = sut.get被保険者台帳管理(主キー1, 主キー2, 主キー3);

            assertThat(result.get被保険者番号().value(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get被保険者台帳管理一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<HihokenshaDaicho> result = sut.get被保険者台帳管理一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT1001HihokenshaDaichoEntity> entityList = Arrays.asList(DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<HihokenshaDaicho> result = sut.get被保険者台帳管理一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save被保険者台帳管理 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(1);

            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaicho 被保険者台帳管理 = new HihokenshaDaicho(entity);

            assertThat(sut.save被保険者台帳管理(被保険者台帳管理), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(0);

            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaicho 被保険者台帳管理 = new HihokenshaDaicho(entity);

            assertThat(sut.save被保険者台帳管理(被保険者台帳管理), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(1);

            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.initializeMd5();
            HihokenshaDaicho 被保険者台帳管理 = new HihokenshaDaicho(entity);
            被保険者台帳管理 = 被保険者台帳管理.createBuilderForEdit().set被保険者区分コード(new RString("5")).build();

            assertThat(sut.save被保険者台帳管理(被保険者台帳管理), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(0);

            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.initializeMd5();
            HihokenshaDaicho 被保険者台帳管理 = new HihokenshaDaicho(entity);
            被保険者台帳管理 = 被保険者台帳管理.createBuilderForEdit().set被保険者区分コード(new RString("5")).build();

            assertThat(sut.save被保険者台帳管理(被保険者台帳管理), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(1);

            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.initializeMd5();
            HihokenshaDaicho 被保険者台帳管理 = new HihokenshaDaicho(entity);
            被保険者台帳管理 = 被保険者台帳管理.deleted();

            assertThat(sut.save被保険者台帳管理(被保険者台帳管理), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(0);

            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.initializeMd5();
            HihokenshaDaicho 被保険者台帳管理 = new HihokenshaDaicho(entity);
            被保険者台帳管理 = 被保険者台帳管理.deleted();

            assertThat(sut.save被保険者台帳管理(被保険者台帳管理), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.initializeMd5();
            HihokenshaDaicho 被保険者台帳管理 = new HihokenshaDaicho(entity);

            assertThat(sut.save被保険者台帳管理(被保険者台帳管理), is(false));
        }
    }
}
