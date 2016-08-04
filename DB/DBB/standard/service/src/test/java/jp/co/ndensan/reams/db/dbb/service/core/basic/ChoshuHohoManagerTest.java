/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {link ChoshuHohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ChoshuHohoManagerTest {

    private static DbT2001ChoshuHohoDac dac;
    private static ChoshuHohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2001ChoshuHohoDac.class);
        sut = new ChoshuHohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護徴収方法 extends DbbTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー2 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_履歴番号;
            sut.get介護徴収方法(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度;
            int 主キー3 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_履歴番号;
            sut.get介護徴収方法(主キー1, null, 主キー3);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(HihokenshaNo.class), any(int.class))).thenReturn(null);

            FlexibleYear 主キー1 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度;
            HihokenshaNo 主キー2 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_履歴番号;
            ChoshuHoho result = sut.get介護徴収方法(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT2001ChoshuHohoEntity entity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(HihokenshaNo.class), any(int.class))).thenReturn(entity);

            FlexibleYear 主キー1 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度;
            HihokenshaNo 主キー2 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_履歴番号;
            ChoshuHoho result = sut.get介護徴収方法(主キー1, 主キー2, 主キー3);

            assertThat(result.get賦課年度().toDateString(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護徴収方法一覧 extends DbbTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ChoshuHoho> result = sut.get介護徴収方法一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT2001ChoshuHohoEntity> entityList = Arrays.asList(DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ChoshuHoho> result = sut.get介護徴収方法一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get賦課年度().toDateString(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度.toDateString()));
        }
    }

    public static class save介護徴収方法 extends DbbTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2001ChoshuHohoEntity.class))).thenReturn(1);

            DbT2001ChoshuHohoEntity entity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            ChoshuHoho 介護徴収方法 = new ChoshuHoho(entity);

            assertThat(sut.save介護徴収方法(介護徴収方法), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2001ChoshuHohoEntity.class))).thenReturn(0);

            DbT2001ChoshuHohoEntity entity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            ChoshuHoho 介護徴収方法 = new ChoshuHoho(entity);

            assertThat(sut.save介護徴収方法(介護徴収方法), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2001ChoshuHohoEntity.class))).thenReturn(1);

            DbT2001ChoshuHohoEntity entity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            entity.initializeMd5();
            ChoshuHoho 介護徴収方法 = new ChoshuHoho(entity);
            介護徴収方法 = 介護徴収方法.createBuilderForEdit().set徴収方法1月(new RString("特徴")).build();

            assertThat(sut.save介護徴収方法(介護徴収方法), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2001ChoshuHohoEntity.class))).thenReturn(0);

            DbT2001ChoshuHohoEntity entity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            entity.initializeMd5();
            ChoshuHoho 介護徴収方法 = new ChoshuHoho(entity);
            介護徴収方法 = 介護徴収方法.createBuilderForEdit().set徴収方法1月(new RString("特徴")).build();

            assertThat(sut.save介護徴収方法(介護徴収方法), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2001ChoshuHohoEntity.class))).thenReturn(1);

            DbT2001ChoshuHohoEntity entity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            entity.initializeMd5();
            ChoshuHoho 介護徴収方法 = new ChoshuHoho(entity);
            介護徴収方法 = 介護徴収方法.deleted();

            assertThat(sut.save介護徴収方法(介護徴収方法), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2001ChoshuHohoEntity.class))).thenReturn(0);

            DbT2001ChoshuHohoEntity entity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            entity.initializeMd5();
            ChoshuHoho 介護徴収方法 = new ChoshuHoho(entity);
            介護徴収方法 = 介護徴収方法.deleted();

            assertThat(sut.save介護徴収方法(介護徴収方法), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2001ChoshuHohoEntity entity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            entity.initializeMd5();
            ChoshuHoho 介護徴収方法 = new ChoshuHoho(entity);

            assertThat(sut.save介護徴収方法(介護徴収方法), is(false));
        }
    }
}
