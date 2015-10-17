/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1002TekiyoJogaishaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link TekiyoJogaishaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TekiyoJogaishaManagerTest {

    private static DbT1002TekiyoJogaishaDac dac;
    private static TekiyoJogaishaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT1002TekiyoJogaishaDac.class);
        sut = new TekiyoJogaishaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get適用除外者 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
            RString 主キー3 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_枝番;
            sut.get適用除外者(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
            RString 主キー3 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_枝番;
            sut.get適用除外者(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 主キー2 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
            sut.get適用除外者(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(FlexibleDate.class), any(RString.class))).thenReturn(null);

            ShikibetsuCode 主キー1 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 主キー2 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
            RString 主キー3 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_枝番;
            TekiyoJogaisha result = sut.get適用除外者(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT1002TekiyoJogaishaEntity entity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(FlexibleDate.class), any(RString.class))).thenReturn(entity);

            ShikibetsuCode 主キー1 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 主キー2 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
            RString 主キー3 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_枝番;
            TekiyoJogaisha result = sut.get適用除外者(主キー1, 主キー2, 主キー3);

            assertThat(result.get識別コード().value(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get適用除外者一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<TekiyoJogaisha> result = sut.get適用除外者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT1002TekiyoJogaishaEntity> entityList = Arrays.asList(DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<TekiyoJogaisha> result = sut.get適用除外者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get識別コード().value(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    public static class save適用除外者 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT1002TekiyoJogaishaEntity.class))).thenReturn(1);

            DbT1002TekiyoJogaishaEntity entity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaisha 適用除外者 = new TekiyoJogaisha(entity);

            assertThat(sut.save適用除外者(適用除外者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT1002TekiyoJogaishaEntity.class))).thenReturn(0);

            DbT1002TekiyoJogaishaEntity entity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaisha 適用除外者 = new TekiyoJogaisha(entity);

            assertThat(sut.save適用除外者(適用除外者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT1002TekiyoJogaishaEntity.class))).thenReturn(1);

            DbT1002TekiyoJogaishaEntity entity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            entity.initializeMd5();
            TekiyoJogaisha 適用除外者 = new TekiyoJogaisha(entity);
            適用除外者 = 適用除外者.createBuilderForEdit().set異動事由コード(new RString("3")).build();

            assertThat(sut.save適用除外者(適用除外者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT1002TekiyoJogaishaEntity.class))).thenReturn(0);

            DbT1002TekiyoJogaishaEntity entity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            entity.initializeMd5();
            TekiyoJogaisha 適用除外者 = new TekiyoJogaisha(entity);
            適用除外者 = 適用除外者.createBuilderForEdit().set異動事由コード(new RString("3")).build();

            assertThat(sut.save適用除外者(適用除外者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT1002TekiyoJogaishaEntity.class))).thenReturn(1);

            DbT1002TekiyoJogaishaEntity entity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            entity.initializeMd5();
            TekiyoJogaisha 適用除外者 = new TekiyoJogaisha(entity);
            適用除外者 = 適用除外者.deleted();

            assertThat(sut.save適用除外者(適用除外者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT1002TekiyoJogaishaEntity.class))).thenReturn(0);

            DbT1002TekiyoJogaishaEntity entity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            entity.initializeMd5();
            TekiyoJogaisha 適用除外者 = new TekiyoJogaisha(entity);
            適用除外者 = 適用除外者.deleted();

            assertThat(sut.save適用除外者(適用除外者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT1002TekiyoJogaishaEntity entity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            entity.initializeMd5();
            TekiyoJogaisha 適用除外者 = new TekiyoJogaisha(entity);

            assertThat(sut.save適用除外者(適用除外者), is(false));
        }
    }
}
