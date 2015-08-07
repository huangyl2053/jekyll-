/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoikiGaijiHenkanErrorLog;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7034KoikiGaijiHenkanErrorLogEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7034KoikiGaijiHenkanErrorLogDac;
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
 * {link KoikiGaijiHenkanErrorLogManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiGaijiHenkanErrorLogManagerTest {

    private static DbT7034KoikiGaijiHenkanErrorLogDac dac;
    private static KoikiGaijiHenkanErrorLogManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7034KoikiGaijiHenkanErrorLogDac.class);
        sut = new KoikiGaijiHenkanErrorLogManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get広域外字変換エラーログ extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー2;
            sut.get広域外字変換エラーログ(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー1;
            sut.get広域外字変換エラーログ(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー2;
            KoikiGaijiHenkanErrorLog result = sut.get広域外字変換エラーログ(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7034KoikiGaijiHenkanErrorLogEntity entity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー2;
            KoikiGaijiHenkanErrorLog result = sut.get広域外字変換エラーログ(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get広域外字変換エラーログ一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KoikiGaijiHenkanErrorLog> result = sut.get広域外字変換エラーログ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7034KoikiGaijiHenkanErrorLogEntity> entityList = Arrays.asList(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KoikiGaijiHenkanErrorLog> result = sut.get広域外字変換エラーログ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save広域外字変換エラーログ extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7034KoikiGaijiHenkanErrorLogEntity.class))).thenReturn(1);

            DbT7034KoikiGaijiHenkanErrorLogEntity entity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            KoikiGaijiHenkanErrorLog 広域外字変換エラーログ = new KoikiGaijiHenkanErrorLog(entity);

            assertThat(sut.save広域外字変換エラーログ(広域外字変換エラーログ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7034KoikiGaijiHenkanErrorLogEntity.class))).thenReturn(0);

            DbT7034KoikiGaijiHenkanErrorLogEntity entity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            KoikiGaijiHenkanErrorLog 広域外字変換エラーログ = new KoikiGaijiHenkanErrorLog(entity);

            assertThat(sut.save広域外字変換エラーログ(広域外字変換エラーログ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7034KoikiGaijiHenkanErrorLogEntity.class))).thenReturn(1);

            DbT7034KoikiGaijiHenkanErrorLogEntity entity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            entity.initializeMd5();
            KoikiGaijiHenkanErrorLog 広域外字変換エラーログ = new KoikiGaijiHenkanErrorLog(entity);
            広域外字変換エラーログ = 広域外字変換エラーログ.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save広域外字変換エラーログ(広域外字変換エラーログ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7034KoikiGaijiHenkanErrorLogEntity.class))).thenReturn(0);

            DbT7034KoikiGaijiHenkanErrorLogEntity entity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            entity.initializeMd5();
            KoikiGaijiHenkanErrorLog 広域外字変換エラーログ = new KoikiGaijiHenkanErrorLog(entity);
            広域外字変換エラーログ = 広域外字変換エラーログ.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save広域外字変換エラーログ(広域外字変換エラーログ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7034KoikiGaijiHenkanErrorLogEntity.class))).thenReturn(1);

            DbT7034KoikiGaijiHenkanErrorLogEntity entity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            entity.initializeMd5();
            KoikiGaijiHenkanErrorLog 広域外字変換エラーログ = new KoikiGaijiHenkanErrorLog(entity);
            広域外字変換エラーログ = 広域外字変換エラーログ.deleted();

            assertThat(sut.save広域外字変換エラーログ(広域外字変換エラーログ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7034KoikiGaijiHenkanErrorLogEntity.class))).thenReturn(0);

            DbT7034KoikiGaijiHenkanErrorLogEntity entity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            entity.initializeMd5();
            KoikiGaijiHenkanErrorLog 広域外字変換エラーログ = new KoikiGaijiHenkanErrorLog(entity);
            広域外字変換エラーログ = 広域外字変換エラーログ.deleted();

            assertThat(sut.save広域外字変換エラーログ(広域外字変換エラーログ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7034KoikiGaijiHenkanErrorLogEntity entity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            entity.initializeMd5();
            KoikiGaijiHenkanErrorLog 広域外字変換エラーログ = new KoikiGaijiHenkanErrorLog(entity);

            assertThat(sut.save広域外字変換エラーログ(広域外字変換エラーログ), is(false));
        }
    }
}
