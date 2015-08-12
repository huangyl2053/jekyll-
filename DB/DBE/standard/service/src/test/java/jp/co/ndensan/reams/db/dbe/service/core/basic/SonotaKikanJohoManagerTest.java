/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.SonotaKikanJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5914SonotaKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5914SonotaKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
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
 * {link SonotaKikanJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SonotaKikanJohoManagerTest {

    private static DbT5914SonotaKikanJohoDac dac;
    private static SonotaKikanJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5914SonotaKikanJohoDac.class);
        sut = new SonotaKikanJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class getその他機関情報 extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_その他機関コード;
            sut.getその他機関情報(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            ShoKisaiHokenshaNo 主キー1 = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_証記載保険者番号;
            sut.getその他機関情報(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(null);
            ShoKisaiHokenshaNo 主キー1 = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー2 = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_その他機関コード;
            SonotaKikanJoho result = sut.getその他機関情報(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5914SonotaKikanJohoEntity entity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();
            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(entity);
            ShoKisaiHokenshaNo 主キー1 = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー2 = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_その他機関コード;
            SonotaKikanJoho result = sut.getその他機関情報(主キー1, 主キー2);

            assertThat(result.get証記載保険者番号().value(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class getその他機関情報一覧 extends DbeTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<SonotaKikanJoho> result = sut.getその他機関情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5914SonotaKikanJohoEntity> entityList = Arrays.asList(DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<SonotaKikanJoho> result = sut.getその他機関情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get証記載保険者番号().value(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    public static class saveその他機関情報 extends DbeTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5914SonotaKikanJohoEntity.class))).thenReturn(1);

            DbT5914SonotaKikanJohoEntity entity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();
            SonotaKikanJoho その他機関情報 = new SonotaKikanJoho(entity);

            assertThat(sut.saveその他機関情報(その他機関情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5914SonotaKikanJohoEntity.class))).thenReturn(0);

            DbT5914SonotaKikanJohoEntity entity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();
            SonotaKikanJoho その他機関情報 = new SonotaKikanJoho(entity);

            assertThat(sut.saveその他機関情報(その他機関情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5914SonotaKikanJohoEntity.class))).thenReturn(1);

            DbT5914SonotaKikanJohoEntity entity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();
            entity.initializeMd5();
            SonotaKikanJoho その他機関情報 = new SonotaKikanJoho(entity);
            その他機関情報 = その他機関情報.createBuilderForEdit().set機関名称(new RString("任意項目1を変更")).build();

            assertThat(sut.saveその他機関情報(その他機関情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5914SonotaKikanJohoEntity.class))).thenReturn(0);

            DbT5914SonotaKikanJohoEntity entity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();
            entity.initializeMd5();
            SonotaKikanJoho その他機関情報 = new SonotaKikanJoho(entity);
            その他機関情報 = その他機関情報.createBuilderForEdit().set機関名称(new RString("任意項目1を変更")).build();

            assertThat(sut.saveその他機関情報(その他機関情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5914SonotaKikanJohoEntity.class))).thenReturn(1);

            DbT5914SonotaKikanJohoEntity entity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();
            entity.initializeMd5();
            SonotaKikanJoho その他機関情報 = new SonotaKikanJoho(entity);
            その他機関情報 = その他機関情報.deleted();

            assertThat(sut.saveその他機関情報(その他機関情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5914SonotaKikanJohoEntity.class))).thenReturn(0);

            DbT5914SonotaKikanJohoEntity entity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();
            entity.initializeMd5();
            SonotaKikanJoho その他機関情報 = new SonotaKikanJoho(entity);
            その他機関情報 = その他機関情報.deleted();

            assertThat(sut.saveその他機関情報(その他機関情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5914SonotaKikanJohoEntity entity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();
            entity.initializeMd5();
            SonotaKikanJoho その他機関情報 = new SonotaKikanJoho(entity);

            assertThat(sut.saveその他機関情報(その他機関情報), is(false));
        }
    }
}
