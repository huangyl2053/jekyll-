/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7056GappeiShichosonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link GappeiShichosonManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiShichosonManagerTest {

    private static DbT7056GappeiShichosonDac dac;
    private static GappeiShichosonManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7056GappeiShichosonDac.class);
        sut = new GappeiShichosonManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get合併市町村 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_地域番号;
            LasdecCode 主キー3 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード;
            sut.get合併市町村(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー1 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日;
            LasdecCode 主キー3 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード;
            sut.get合併市町村(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー1 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日;
            RString 主キー2 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_地域番号;
            sut.get合併市町村(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleDate.class), any(RString.class), any(LasdecCode.class))).thenReturn(null);
            FlexibleDate 主キー1 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日;
            RString 主キー2 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_地域番号;
            LasdecCode 主キー3 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード;
            GappeiShichoson result = sut.get合併市町村(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
            when(dac.selectByKey(any(FlexibleDate.class), any(RString.class), any(LasdecCode.class))).thenReturn(entity);
            FlexibleDate 主キー1 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日;
            RString 主キー2 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_地域番号;
            LasdecCode 主キー3 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード;
            GappeiShichoson result = sut.get合併市町村(主キー1, 主キー2, 主キー3);

            assertThat(result.get合併年月日().toString(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日.toString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get合併市町村一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<GappeiShichoson> result = sut.get合併市町村一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7056GappeiShichosonEntity> entityList = Arrays.asList(DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<GappeiShichoson> result = sut.get合併市町村一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get合併年月日().toString(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日.toString()));
        }
    }

    public static class save合併市町村 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7056GappeiShichosonEntity.class))).thenReturn(1);

            DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
            GappeiShichoson 合併市町村 = new GappeiShichoson(entity);

            assertThat(sut.save合併市町村(合併市町村), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7056GappeiShichosonEntity.class))).thenReturn(0);

            DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
            GappeiShichoson 合併市町村 = new GappeiShichoson(entity);

            assertThat(sut.save合併市町村(合併市町村), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7056GappeiShichosonEntity.class))).thenReturn(1);

            DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
            entity.initializeMd5();
            GappeiShichoson 合併市町村 = new GappeiShichoson(entity);
            合併市町村 = 合併市町村.createBuilderForEdit().set老人保健市町村番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save合併市町村(合併市町村), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7056GappeiShichosonEntity.class))).thenReturn(0);

            DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
            entity.initializeMd5();
            GappeiShichoson 合併市町村 = new GappeiShichoson(entity);
            合併市町村 = 合併市町村.createBuilderForEdit().set老人保健市町村番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save合併市町村(合併市町村), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7056GappeiShichosonEntity.class))).thenReturn(1);

            DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
            entity.initializeMd5();
            GappeiShichoson 合併市町村 = new GappeiShichoson(entity);
            合併市町村 = 合併市町村.deleted();

            assertThat(sut.save合併市町村(合併市町村), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7056GappeiShichosonEntity.class))).thenReturn(0);

            DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
            entity.initializeMd5();
            GappeiShichoson 合併市町村 = new GappeiShichoson(entity);
            合併市町村 = 合併市町村.deleted();

            assertThat(sut.save合併市町村(合併市町村), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
            entity.initializeMd5();
            GappeiShichoson 合併市町村 = new GappeiShichoson(entity);

            assertThat(sut.save合併市町村(合併市町村), is(false));
        }
    }
}
