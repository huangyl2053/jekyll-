/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1008IryohokenKanyuJokyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1008IryohokenKanyuJokyoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {link IryohokenKanyuJokyoManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IryohokenKanyuJokyoManagerTest {

    private static DbT1008IryohokenKanyuJokyoDac dac;
    private static IryohokenKanyuJokyoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT1008IryohokenKanyuJokyoDac.class);
        sut = new IryohokenKanyuJokyoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護保険医療保険加入状況 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            int 主キー2 = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_履歴番号;
            sut.get介護保険医療保険加入状況(null, 主キー2);
        }

//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
//            ShikibetsuCode 主キー1 = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード;
//            sut.get介護保険医療保険加入状況(主キー1, null);
//        }
        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(int.class))).thenReturn(null);

            ShikibetsuCode 主キー1 = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード;
            int 主キー2 = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_履歴番号;
            IryohokenKanyuJokyo result = sut.get介護保険医療保険加入状況(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT1008IryohokenKanyuJokyoEntity entity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(int.class))).thenReturn(entity);

            ShikibetsuCode 主キー1 = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード;
            int 主キー2 = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_履歴番号;
            IryohokenKanyuJokyo result = sut.get介護保険医療保険加入状況(主キー1, 主キー2);

            assertThat(result.get識別コード().value(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護保険医療保険加入状況一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<IryohokenKanyuJokyo> result = sut.get介護保険医療保険加入状況一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT1008IryohokenKanyuJokyoEntity> entityList = Arrays.asList(DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<IryohokenKanyuJokyo> result = sut.get介護保険医療保険加入状況一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get識別コード().value(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    public static class save介護保険医療保険加入状況 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT1008IryohokenKanyuJokyoEntity.class))).thenReturn(1);

            DbT1008IryohokenKanyuJokyoEntity entity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            IryohokenKanyuJokyo 介護保険医療保険加入状況 = new IryohokenKanyuJokyo(entity);

            assertThat(sut.save介護保険医療保険加入状況(介護保険医療保険加入状況), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT1008IryohokenKanyuJokyoEntity.class))).thenReturn(0);

            DbT1008IryohokenKanyuJokyoEntity entity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            IryohokenKanyuJokyo 介護保険医療保険加入状況 = new IryohokenKanyuJokyo(entity);

            assertThat(sut.save介護保険医療保険加入状況(介護保険医療保険加入状況), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT1008IryohokenKanyuJokyoEntity.class))).thenReturn(1);

            DbT1008IryohokenKanyuJokyoEntity entity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            entity.initializeMd5();
            IryohokenKanyuJokyo 介護保険医療保険加入状況 = new IryohokenKanyuJokyo(entity);
            介護保険医療保険加入状況 = 介護保険医療保険加入状況.createBuilderForEdit().set医療保険者名称(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護保険医療保険加入状況(介護保険医療保険加入状況), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT1008IryohokenKanyuJokyoEntity.class))).thenReturn(0);

            DbT1008IryohokenKanyuJokyoEntity entity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            entity.initializeMd5();
            IryohokenKanyuJokyo 介護保険医療保険加入状況 = new IryohokenKanyuJokyo(entity);
            介護保険医療保険加入状況 = 介護保険医療保険加入状況.createBuilderForEdit().set医療保険者名称(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護保険医療保険加入状況(介護保険医療保険加入状況), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT1008IryohokenKanyuJokyoEntity.class))).thenReturn(1);

            DbT1008IryohokenKanyuJokyoEntity entity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            entity.initializeMd5();
            IryohokenKanyuJokyo 介護保険医療保険加入状況 = new IryohokenKanyuJokyo(entity);
            介護保険医療保険加入状況 = 介護保険医療保険加入状況.deleted();

            assertThat(sut.save介護保険医療保険加入状況(介護保険医療保険加入状況), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT1008IryohokenKanyuJokyoEntity.class))).thenReturn(0);

            DbT1008IryohokenKanyuJokyoEntity entity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            entity.initializeMd5();
            IryohokenKanyuJokyo 介護保険医療保険加入状況 = new IryohokenKanyuJokyo(entity);
            介護保険医療保険加入状況 = 介護保険医療保険加入状況.deleted();

            assertThat(sut.save介護保険医療保険加入状況(介護保険医療保険加入状況), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT1008IryohokenKanyuJokyoEntity entity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            entity.initializeMd5();
            IryohokenKanyuJokyo 介護保険医療保険加入状況 = new IryohokenKanyuJokyo(entity);

            assertThat(sut.save介護保険医療保険加入状況(介護保険医療保険加入状況), is(false));
        }
    }
}
