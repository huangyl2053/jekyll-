/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoikiShichosonCodeHenkanPattern;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPatternEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7024KoikiShichosonCodeHenkanPatternDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {link KoikiShichosonCodeHenkanPatternManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiShichosonCodeHenkanPatternManagerTest {

    private static DbT7024KoikiShichosonCodeHenkanPatternDac dac;
    private static KoikiShichosonCodeHenkanPatternManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7024KoikiShichosonCodeHenkanPatternDac.class);
        sut = new KoikiShichosonCodeHenkanPatternManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get広域市町村管理コード変換パターン extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 主キー2 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード;
            RString 主キー3 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分;
            sut.get広域市町村管理コード変換パターン(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号;
            RString 主キー3 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分;
            sut.get広域市町村管理コード変換パターン(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号;
            LasdecCode 主キー2 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード;
            sut.get広域市町村管理コード変換パターン(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(LasdecCode.class), any(RString.class))).thenReturn(null);

            RString 主キー1 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号;
            LasdecCode 主キー2 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード;
            RString 主キー3 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分;
            KoikiShichosonCodeHenkanPattern result = sut.get広域市町村管理コード変換パターン(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7024KoikiShichosonCodeHenkanPatternEntity entity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            when(dac.selectByKey(any(RString.class), any(LasdecCode.class), any(RString.class))).thenReturn(entity);
            RString 主キー1 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号;
            LasdecCode 主キー2 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード;
            RString 主キー3 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分;
            KoikiShichosonCodeHenkanPattern result = sut.get広域市町村管理コード変換パターン(主キー1, 主キー2, 主キー3);

            assertThat(result.get主キー1().value(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get広域市町村管理コード変換パターン一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KoikiShichosonCodeHenkanPattern> result = sut.get広域市町村管理コード変換パターン一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7024KoikiShichosonCodeHenkanPatternEntity> entityList = Arrays.asList(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KoikiShichosonCodeHenkanPattern> result = sut.get広域市町村管理コード変換パターン一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号));
        }
    }

    public static class save広域市町村管理コード変換パターン extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7024KoikiShichosonCodeHenkanPatternEntity.class))).thenReturn(1);

            DbT7024KoikiShichosonCodeHenkanPatternEntity entity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            KoikiShichosonCodeHenkanPattern 広域市町村管理コード変換パターン = new KoikiShichosonCodeHenkanPattern(entity);

            assertThat(sut.save広域市町村管理コード変換パターン(広域市町村管理コード変換パターン), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7024KoikiShichosonCodeHenkanPatternEntity.class))).thenReturn(0);

            DbT7024KoikiShichosonCodeHenkanPatternEntity entity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            KoikiShichosonCodeHenkanPattern 広域市町村管理コード変換パターン = new KoikiShichosonCodeHenkanPattern(entity);

            assertThat(sut.save広域市町村管理コード変換パターン(広域市町村管理コード変換パターン), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7024KoikiShichosonCodeHenkanPatternEntity.class))).thenReturn(1);

            DbT7024KoikiShichosonCodeHenkanPatternEntity entity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            entity.initializeMd5();
            KoikiShichosonCodeHenkanPattern 広域市町村管理コード変換パターン = new KoikiShichosonCodeHenkanPattern(entity);
            広域市町村管理コード変換パターン = 広域市町村管理コード変換パターン.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save広域市町村管理コード変換パターン(広域市町村管理コード変換パターン), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7024KoikiShichosonCodeHenkanPatternEntity.class))).thenReturn(0);

            DbT7024KoikiShichosonCodeHenkanPatternEntity entity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            entity.initializeMd5();
            KoikiShichosonCodeHenkanPattern 広域市町村管理コード変換パターン = new KoikiShichosonCodeHenkanPattern(entity);
            広域市町村管理コード変換パターン = 広域市町村管理コード変換パターン.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save広域市町村管理コード変換パターン(広域市町村管理コード変換パターン), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7024KoikiShichosonCodeHenkanPatternEntity.class))).thenReturn(1);

            DbT7024KoikiShichosonCodeHenkanPatternEntity entity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            entity.initializeMd5();
            KoikiShichosonCodeHenkanPattern 広域市町村管理コード変換パターン = new KoikiShichosonCodeHenkanPattern(entity);
            広域市町村管理コード変換パターン = 広域市町村管理コード変換パターン.deleted();

            assertThat(sut.save広域市町村管理コード変換パターン(広域市町村管理コード変換パターン), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7024KoikiShichosonCodeHenkanPatternEntity.class))).thenReturn(0);

            DbT7024KoikiShichosonCodeHenkanPatternEntity entity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            entity.initializeMd5();
            KoikiShichosonCodeHenkanPattern 広域市町村管理コード変換パターン = new KoikiShichosonCodeHenkanPattern(entity);
            広域市町村管理コード変換パターン = 広域市町村管理コード変換パターン.deleted();

            assertThat(sut.save広域市町村管理コード変換パターン(広域市町村管理コード変換パターン), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7024KoikiShichosonCodeHenkanPatternEntity entity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            entity.initializeMd5();
            KoikiShichosonCodeHenkanPattern 広域市町村管理コード変換パターン = new KoikiShichosonCodeHenkanPattern(entity);

            assertThat(sut.save広域市町村管理コード変換パターン(広域市町村管理コード変換パターン), is(false));
        }
    }
}
