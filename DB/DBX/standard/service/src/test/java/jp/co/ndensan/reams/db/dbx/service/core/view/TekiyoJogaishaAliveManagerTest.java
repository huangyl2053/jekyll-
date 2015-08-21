/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.view.TekiyoJogaishaAlive;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbV1002TekiyoJogaishaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1002TekiyoJogaishaAliveDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link TekiyoJogaishaAliveManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TekiyoJogaishaAliveManagerTest {

    private static DbV1002TekiyoJogaishaAliveDac dac;
    private static TekiyoJogaishaAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV1002TekiyoJogaishaAliveDac.class);
        sut = new TekiyoJogaishaAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get適用除外者台帳管理Alive extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のShikibetsuCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbV1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
            sut.get適用除外者台帳管理Alive(null, 主キー2, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のFlexibleDateにnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbV1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
            sut.get適用除外者台帳管理Alive(主キー1, null, RString.EMPTY);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(FlexibleDate.class), any(RString.class))).thenReturn(null);

            ShikibetsuCode 主キー1 = DbV1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 主キー2 = DbV1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
            TekiyoJogaishaAlive result = sut.get適用除外者台帳管理Alive(主キー1, 主キー2, RString.EMPTY);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV1002TekiyoJogaishaEntity entity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(FlexibleDate.class), any(RString.class))).thenReturn(entity);

            ShikibetsuCode 主キー1 = DbV1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 主キー2 = DbV1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
            TekiyoJogaishaAlive result = sut.get適用除外者台帳管理Alive(主キー1, 主キー2, RString.EMPTY);

            assertThat(result.get識別コード().value(), is(DbV1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get適用除外者台帳管理Alive一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<TekiyoJogaishaAlive> result = sut.get適用除外者台帳管理Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV1002TekiyoJogaishaEntity> entityList = Arrays.asList(DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<TekiyoJogaishaAlive> result = sut.get適用除外者台帳管理Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get識別コード().value(), is(DbV1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    public static class save適用除外者台帳管理Alive extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV1002TekiyoJogaishaEntity.class))).thenReturn(1);

            DbV1002TekiyoJogaishaEntity entity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            TekiyoJogaishaAlive 適用除外者台帳管理Alive = new TekiyoJogaishaAlive(entity);

            assertThat(sut.save適用除外者台帳管理Alive(適用除外者台帳管理Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV1002TekiyoJogaishaEntity.class))).thenReturn(0);

            DbV1002TekiyoJogaishaEntity entity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            TekiyoJogaishaAlive 適用除外者台帳管理Alive = new TekiyoJogaishaAlive(entity);

            assertThat(sut.save適用除外者台帳管理Alive(適用除外者台帳管理Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV1002TekiyoJogaishaEntity.class))).thenReturn(1);

            DbV1002TekiyoJogaishaEntity entity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            entity.initializeMd5();
            TekiyoJogaishaAlive 適用除外者台帳管理Alive = new TekiyoJogaishaAlive(entity);
            適用除外者台帳管理Alive = 適用除外者台帳管理Alive.createBuilderForEdit().set適用届出年月日(new FlexibleDate("20150908")).build();

            assertThat(sut.save適用除外者台帳管理Alive(適用除外者台帳管理Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV1002TekiyoJogaishaEntity.class))).thenReturn(0);

            DbV1002TekiyoJogaishaEntity entity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            entity.initializeMd5();
            TekiyoJogaishaAlive 適用除外者台帳管理Alive = new TekiyoJogaishaAlive(entity);
            適用除外者台帳管理Alive = 適用除外者台帳管理Alive.createBuilderForEdit().set適用届出年月日(new FlexibleDate("20150908")).build();

            assertThat(sut.save適用除外者台帳管理Alive(適用除外者台帳管理Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV1002TekiyoJogaishaEntity.class))).thenReturn(1);

            DbV1002TekiyoJogaishaEntity entity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            entity.initializeMd5();
            TekiyoJogaishaAlive 適用除外者台帳管理Alive = new TekiyoJogaishaAlive(entity);
            適用除外者台帳管理Alive = 適用除外者台帳管理Alive.deleted();

            assertThat(sut.save適用除外者台帳管理Alive(適用除外者台帳管理Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV1002TekiyoJogaishaEntity.class))).thenReturn(0);

            DbV1002TekiyoJogaishaEntity entity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            entity.initializeMd5();
            TekiyoJogaishaAlive 適用除外者台帳管理Alive = new TekiyoJogaishaAlive(entity);
            適用除外者台帳管理Alive = 適用除外者台帳管理Alive.deleted();

            assertThat(sut.save適用除外者台帳管理Alive(適用除外者台帳管理Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV1002TekiyoJogaishaEntity entity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            entity.initializeMd5();
            TekiyoJogaishaAlive 適用除外者台帳管理Alive = new TekiyoJogaishaAlive(entity);

            assertThat(sut.save適用除外者台帳管理Alive(適用除外者台帳管理Alive), is(false));
        }
    }
}
