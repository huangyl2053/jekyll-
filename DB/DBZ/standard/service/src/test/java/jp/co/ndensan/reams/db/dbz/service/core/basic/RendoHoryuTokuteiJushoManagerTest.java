/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoHoryuTokuteiJusho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7023RendoHoryuTokuteiJushoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7023RendoHoryuTokuteiJushoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link RendoHoryuTokuteiJushoManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class RendoHoryuTokuteiJushoManagerTest {

    private static DbT7023RendoHoryuTokuteiJushoDac dac;
    private static RendoHoryuTokuteiJushoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7023RendoHoryuTokuteiJushoDac.class);
        sut = new RendoHoryuTokuteiJushoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get連動保留特定住所マスタ extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 市町村コード = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_市町村コード;
            sut.get連動保留特定住所マスタ(null, 市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            RString 管理番号 = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号;
            sut.get連動保留特定住所マスタ(管理番号, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(LasdecCode.class))).thenReturn(null);

            RString 管理番号 = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号;
            LasdecCode 市町村コード = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_市町村コード;
            RendoHoryuTokuteiJusho result = sut.get連動保留特定住所マスタ(管理番号, 市町村コード);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7023RendoHoryuTokuteiJushoEntity entity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            when(dac.selectByKey(any(RString.class), any(LasdecCode.class))).thenReturn(entity);

            RString 管理番号 = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号;
            LasdecCode 市町村コード = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_市町村コード;
            RendoHoryuTokuteiJusho result = sut.get連動保留特定住所マスタ(管理番号, 市町村コード);

            assertThat(result.get管理番号(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get連動保留特定住所マスタ一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<RendoHoryuTokuteiJusho> result = sut.get連動保留特定住所マスタ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7023RendoHoryuTokuteiJushoEntity> entityList = Arrays.asList(DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<RendoHoryuTokuteiJusho> result = sut.get連動保留特定住所マスタ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get管理番号(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号));
        }
    }

    public static class save連動保留特定住所マスタ extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7023RendoHoryuTokuteiJushoEntity.class))).thenReturn(1);

            DbT7023RendoHoryuTokuteiJushoEntity entity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            RendoHoryuTokuteiJusho 連動保留特定住所マスタ = new RendoHoryuTokuteiJusho(entity);

            assertThat(sut.save連動保留特定住所マスタ(連動保留特定住所マスタ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7023RendoHoryuTokuteiJushoEntity.class))).thenReturn(0);

            DbT7023RendoHoryuTokuteiJushoEntity entity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            RendoHoryuTokuteiJusho 連動保留特定住所マスタ = new RendoHoryuTokuteiJusho(entity);

            assertThat(sut.save連動保留特定住所マスタ(連動保留特定住所マスタ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7023RendoHoryuTokuteiJushoEntity.class))).thenReturn(1);

            DbT7023RendoHoryuTokuteiJushoEntity entity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            entity.initializeMd5();
            RendoHoryuTokuteiJusho 連動保留特定住所マスタ = new RendoHoryuTokuteiJusho(entity);
            連動保留特定住所マスタ = 連動保留特定住所マスタ.createBuilderForEdit().set管理番号(new RString("管理番号を変更")).build();

            assertThat(sut.save連動保留特定住所マスタ(連動保留特定住所マスタ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7023RendoHoryuTokuteiJushoEntity.class))).thenReturn(0);

            DbT7023RendoHoryuTokuteiJushoEntity entity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            entity.initializeMd5();
            RendoHoryuTokuteiJusho 連動保留特定住所マスタ = new RendoHoryuTokuteiJusho(entity);
            連動保留特定住所マスタ = 連動保留特定住所マスタ.createBuilderForEdit().set管理番号(new RString("管理番号を変更")).build();

            assertThat(sut.save連動保留特定住所マスタ(連動保留特定住所マスタ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7023RendoHoryuTokuteiJushoEntity.class))).thenReturn(1);

            DbT7023RendoHoryuTokuteiJushoEntity entity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            entity.initializeMd5();
            RendoHoryuTokuteiJusho 連動保留特定住所マスタ = new RendoHoryuTokuteiJusho(entity);
            連動保留特定住所マスタ = 連動保留特定住所マスタ.deleted();

            assertThat(sut.save連動保留特定住所マスタ(連動保留特定住所マスタ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7023RendoHoryuTokuteiJushoEntity.class))).thenReturn(0);

            DbT7023RendoHoryuTokuteiJushoEntity entity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            entity.initializeMd5();
            RendoHoryuTokuteiJusho 連動保留特定住所マスタ = new RendoHoryuTokuteiJusho(entity);
            連動保留特定住所マスタ = 連動保留特定住所マスタ.deleted();

            assertThat(sut.save連動保留特定住所マスタ(連動保留特定住所マスタ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7023RendoHoryuTokuteiJushoEntity entity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            entity.initializeMd5();
            RendoHoryuTokuteiJusho 連動保留特定住所マスタ = new RendoHoryuTokuteiJusho(entity);

            assertThat(sut.save連動保留特定住所マスタ(連動保留特定住所マスタ), is(false));
        }
    }
}
