/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiOnseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5512ShinsakaiOnseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5512ShinsakaiOnseiJohoDac;
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
 * {link ShinsakaiOnseiJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiOnseiJohoManagerTest {

    private static DbT5512ShinsakaiOnseiJohoDac dac;
    private static ShinsakaiOnseiJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5512ShinsakaiOnseiJohoDac.class);
        sut = new ShinsakaiOnseiJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護認定審査会音声情報 extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー2;
            sut.get介護認定審査会音声情報(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー1;
            sut.get介護認定審査会音声情報(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー2;
            ShinsakaiOnseiJoho result = sut.get介護認定審査会音声情報(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5512ShinsakaiOnseiJohoEntity entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー2;
            ShinsakaiOnseiJoho result = sut.get介護認定審査会音声情報(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護認定審査会音声情報一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShinsakaiOnseiJoho> result = sut.get介護認定審査会音声情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5512ShinsakaiOnseiJohoEntity> entityList = Arrays.asList(DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShinsakaiOnseiJoho> result = sut.get介護認定審査会音声情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save介護認定審査会音声情報 extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5512ShinsakaiOnseiJohoEntity.class))).thenReturn(1);

            DbT5512ShinsakaiOnseiJohoEntity entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
            ShinsakaiOnseiJoho 介護認定審査会音声情報 = new ShinsakaiOnseiJoho(entity);

            assertThat(sut.save介護認定審査会音声情報(介護認定審査会音声情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5512ShinsakaiOnseiJohoEntity.class))).thenReturn(0);

            DbT5512ShinsakaiOnseiJohoEntity entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
            ShinsakaiOnseiJoho 介護認定審査会音声情報 = new ShinsakaiOnseiJoho(entity);

            assertThat(sut.save介護認定審査会音声情報(介護認定審査会音声情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5512ShinsakaiOnseiJohoEntity.class))).thenReturn(1);

            DbT5512ShinsakaiOnseiJohoEntity entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
            entity.initializeMd5();
            ShinsakaiOnseiJoho 介護認定審査会音声情報 = new ShinsakaiOnseiJoho(entity);
            介護認定審査会音声情報 = 介護認定審査会音声情報.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護認定審査会音声情報(介護認定審査会音声情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5512ShinsakaiOnseiJohoEntity.class))).thenReturn(0);

            DbT5512ShinsakaiOnseiJohoEntity entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
            entity.initializeMd5();
            ShinsakaiOnseiJoho 介護認定審査会音声情報 = new ShinsakaiOnseiJoho(entity);
            介護認定審査会音声情報 = 介護認定審査会音声情報.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護認定審査会音声情報(介護認定審査会音声情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5512ShinsakaiOnseiJohoEntity.class))).thenReturn(1);

            DbT5512ShinsakaiOnseiJohoEntity entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
            entity.initializeMd5();
            ShinsakaiOnseiJoho 介護認定審査会音声情報 = new ShinsakaiOnseiJoho(entity);
            介護認定審査会音声情報 = 介護認定審査会音声情報.deleted();

            assertThat(sut.save介護認定審査会音声情報(介護認定審査会音声情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5512ShinsakaiOnseiJohoEntity.class))).thenReturn(0);

            DbT5512ShinsakaiOnseiJohoEntity entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
            entity.initializeMd5();
            ShinsakaiOnseiJoho 介護認定審査会音声情報 = new ShinsakaiOnseiJoho(entity);
            介護認定審査会音声情報 = 介護認定審査会音声情報.deleted();

            assertThat(sut.save介護認定審査会音声情報(介護認定審査会音声情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5512ShinsakaiOnseiJohoEntity entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
            entity.initializeMd5();
            ShinsakaiOnseiJoho 介護認定審査会音声情報 = new ShinsakaiOnseiJoho(entity);

            assertThat(sut.save介護認定審査会音声情報(介護認定審査会音声情報), is(false));
        }
    }
}
