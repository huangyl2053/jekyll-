/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.TsuchishoHakkoJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5122TsuchishoHakkoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5122TsuchishoHakkoJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
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
 * {link TsuchishoHakkoJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TsuchishoHakkoJohoManagerTest {

    private static DbT5122TsuchishoHakkoJohoDac dac;
    private static TsuchishoHakkoJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5122TsuchishoHakkoJohoDac.class);
        sut = new TsuchishoHakkoJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get通知書発行情報 extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get通知書発行情報(null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(null);
            ShinseishoKanriNo 主キー1 = DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_申請書管理番号;
            TsuchishoHakkoJoho result = sut.get通知書発行情報(主キー1);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5122TsuchishoHakkoJohoEntity entity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(entity);
            ShinseishoKanriNo 主キー1 = DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_申請書管理番号;
            TsuchishoHakkoJoho result = sut.get通知書発行情報(主キー1);

            assertThat(result.get申請書管理番号().value(), is(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get通知書発行情報一覧 extends DbeTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<TsuchishoHakkoJoho> result = sut.get通知書発行情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5122TsuchishoHakkoJohoEntity> entityList = Arrays.asList(DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<TsuchishoHakkoJoho> result = sut.get通知書発行情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save通知書発行情報 extends DbeTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5122TsuchishoHakkoJohoEntity.class))).thenReturn(1);

            DbT5122TsuchishoHakkoJohoEntity entity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
            TsuchishoHakkoJoho 通知書発行情報 = new TsuchishoHakkoJoho(entity);

            assertThat(sut.save通知書発行情報(通知書発行情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5122TsuchishoHakkoJohoEntity.class))).thenReturn(0);

            DbT5122TsuchishoHakkoJohoEntity entity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
            TsuchishoHakkoJoho 通知書発行情報 = new TsuchishoHakkoJoho(entity);

            assertThat(sut.save通知書発行情報(通知書発行情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5122TsuchishoHakkoJohoEntity.class))).thenReturn(1);

            DbT5122TsuchishoHakkoJohoEntity entity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
            entity.initializeMd5();
            TsuchishoHakkoJoho 通知書発行情報 = new TsuchishoHakkoJoho(entity);
            通知書発行情報 = 通知書発行情報.createBuilderForEdit().set通知理由(new RString("任意項目1を変更")).build();

            assertThat(sut.save通知書発行情報(通知書発行情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5122TsuchishoHakkoJohoEntity.class))).thenReturn(0);

            DbT5122TsuchishoHakkoJohoEntity entity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
            entity.initializeMd5();
            TsuchishoHakkoJoho 通知書発行情報 = new TsuchishoHakkoJoho(entity);
            通知書発行情報 = 通知書発行情報.createBuilderForEdit().set通知理由(new RString("任意項目1を変更")).build();

            assertThat(sut.save通知書発行情報(通知書発行情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5122TsuchishoHakkoJohoEntity.class))).thenReturn(1);

            DbT5122TsuchishoHakkoJohoEntity entity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
            entity.initializeMd5();
            TsuchishoHakkoJoho 通知書発行情報 = new TsuchishoHakkoJoho(entity);
            通知書発行情報 = 通知書発行情報.deleted();

            assertThat(sut.save通知書発行情報(通知書発行情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5122TsuchishoHakkoJohoEntity.class))).thenReturn(0);

            DbT5122TsuchishoHakkoJohoEntity entity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
            entity.initializeMd5();
            TsuchishoHakkoJoho 通知書発行情報 = new TsuchishoHakkoJoho(entity);
            通知書発行情報 = 通知書発行情報.deleted();

            assertThat(sut.save通知書発行情報(通知書発行情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5122TsuchishoHakkoJohoEntity entity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
            entity.initializeMd5();
            TsuchishoHakkoJoho 通知書発行情報 = new TsuchishoHakkoJoho(entity);

            assertThat(sut.save通知書発行情報(通知書発行情報), is(false));
        }
    }
}
