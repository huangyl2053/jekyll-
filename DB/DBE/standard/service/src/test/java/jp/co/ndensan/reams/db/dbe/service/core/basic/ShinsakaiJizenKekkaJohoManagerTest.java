/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiJizenKekkaJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5508ShinsakaiJizenKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5508ShinsakaiJizenKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5508ShinsakaiJizenKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
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
 * {link ShinsakaiJizenKekkaJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShinsakaiJizenKekkaJohoManagerTest {

    private static DbT5508ShinsakaiJizenKekkaJohoDac dac;
    private static ShinsakaiJizenKekkaJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5508ShinsakaiJizenKekkaJohoDac.class);
        sut = new ShinsakaiJizenKekkaJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護認定審査会事前審査結果情報 extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
            RString 主キー2 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会委員コード;
            int 主キー3 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会審査順;
            sut.get介護認定審査会事前審査結果情報(主キー1, null, 主キー3);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(RString.class), any(int.class))).thenReturn(null);
            RString 主キー1 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
            RString 主キー2 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会委員コード;
            int 主キー3 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会審査順;
            ShinsakaiJizenKekkaJoho result = sut.get介護認定審査会事前審査結果情報(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5508ShinsakaiJizenKekkaJohoEntity entity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();
            when(dac.selectByKey(any(RString.class), any(RString.class), any(int.class))).thenReturn(entity);
            RString 主キー1 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
            RString 主キー2 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会委員コード;
            int 主キー3 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会審査順;
            ShinsakaiJizenKekkaJoho result = sut.get介護認定審査会事前審査結果情報(主キー1, 主キー2, 主キー3);

            assertThat(result.get介護認定審査会開催番号(), is(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護認定審査会事前審査結果情報一覧 extends DbeTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShinsakaiJizenKekkaJoho> result = sut.get介護認定審査会事前審査結果情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5508ShinsakaiJizenKekkaJohoEntity> entityList = Arrays.asList(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShinsakaiJizenKekkaJoho> result = sut.get介護認定審査会事前審査結果情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get介護認定審査会開催番号(), is(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号));
        }
    }

    public static class save介護認定審査会事前審査結果情報 extends DbeTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5508ShinsakaiJizenKekkaJohoEntity.class))).thenReturn(1);

            DbT5508ShinsakaiJizenKekkaJohoEntity entity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();
            ShinsakaiJizenKekkaJoho 介護認定審査会事前審査結果情報 = new ShinsakaiJizenKekkaJoho(entity);

            assertThat(sut.save介護認定審査会事前審査結果情報(介護認定審査会事前審査結果情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5508ShinsakaiJizenKekkaJohoEntity.class))).thenReturn(0);

            DbT5508ShinsakaiJizenKekkaJohoEntity entity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();
            ShinsakaiJizenKekkaJoho 介護認定審査会事前審査結果情報 = new ShinsakaiJizenKekkaJoho(entity);

            assertThat(sut.save介護認定審査会事前審査結果情報(介護認定審査会事前審査結果情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5508ShinsakaiJizenKekkaJohoEntity.class))).thenReturn(1);

            DbT5508ShinsakaiJizenKekkaJohoEntity entity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();
            entity.initializeMd5();
            ShinsakaiJizenKekkaJoho 介護認定審査会事前審査結果情報 = new ShinsakaiJizenKekkaJoho(entity);
            介護認定審査会事前審査結果情報 = 介護認定審査会事前審査結果情報.createBuilderForEdit().set一次判定結果変更理由(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護認定審査会事前審査結果情報(介護認定審査会事前審査結果情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5508ShinsakaiJizenKekkaJohoEntity.class))).thenReturn(0);

            DbT5508ShinsakaiJizenKekkaJohoEntity entity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();
            entity.initializeMd5();
            ShinsakaiJizenKekkaJoho 介護認定審査会事前審査結果情報 = new ShinsakaiJizenKekkaJoho(entity);
            介護認定審査会事前審査結果情報 = 介護認定審査会事前審査結果情報.createBuilderForEdit().set一次判定結果変更理由(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護認定審査会事前審査結果情報(介護認定審査会事前審査結果情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5508ShinsakaiJizenKekkaJohoEntity.class))).thenReturn(1);

            DbT5508ShinsakaiJizenKekkaJohoEntity entity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();
            entity.initializeMd5();
            ShinsakaiJizenKekkaJoho 介護認定審査会事前審査結果情報 = new ShinsakaiJizenKekkaJoho(entity);
            介護認定審査会事前審査結果情報 = 介護認定審査会事前審査結果情報.deleted();

            assertThat(sut.save介護認定審査会事前審査結果情報(介護認定審査会事前審査結果情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5508ShinsakaiJizenKekkaJohoEntity.class))).thenReturn(0);

            DbT5508ShinsakaiJizenKekkaJohoEntity entity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();
            entity.initializeMd5();
            ShinsakaiJizenKekkaJoho 介護認定審査会事前審査結果情報 = new ShinsakaiJizenKekkaJoho(entity);
            介護認定審査会事前審査結果情報 = 介護認定審査会事前審査結果情報.deleted();

            assertThat(sut.save介護認定審査会事前審査結果情報(介護認定審査会事前審査結果情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5508ShinsakaiJizenKekkaJohoEntity entity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();
            entity.initializeMd5();
            ShinsakaiJizenKekkaJoho 介護認定審査会事前審査結果情報 = new ShinsakaiJizenKekkaJoho(entity);

            assertThat(sut.save介護認定審査会事前審査結果情報(介護認定審査会事前審査結果情報), is(false));
        }
    }
}
