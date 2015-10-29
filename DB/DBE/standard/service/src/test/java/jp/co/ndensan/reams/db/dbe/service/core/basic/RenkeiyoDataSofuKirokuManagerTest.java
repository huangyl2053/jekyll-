/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.RenkeiyoDataSofuKiroku;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5191RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5191RenkeiyoDataSofuKirokuEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5191RenkeiyoDataSofuKirokuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link RenkeiyoDataSofuKirokuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class RenkeiyoDataSofuKirokuManagerTest {

    private static DbT5191RenkeiyoDataSofuKirokuDac dac;
    private static RenkeiyoDataSofuKirokuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5191RenkeiyoDataSofuKirokuDac.class);
        sut = new RenkeiyoDataSofuKirokuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get連携用データ送付記録 extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_資料作成日;
            sut.get連携用データ送付記録(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            ShinseishoKanriNo 主キー1 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号;
            sut.get連携用データ送付記録(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(FlexibleDate.class))).thenReturn(null);

            ShinseishoKanriNo 主キー1 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号;
            FlexibleDate 主キー2 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_資料作成日;
            RenkeiyoDataSofuKiroku result = sut.get連携用データ送付記録(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5191RenkeiyoDataSofuKirokuEntity entity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(FlexibleDate.class))).thenReturn(entity);

            ShinseishoKanriNo 主キー1 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号;
            FlexibleDate 主キー2 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_資料作成日;
            RenkeiyoDataSofuKiroku result = sut.get連携用データ送付記録(主キー1, 主キー2);

            assertThat(result.get申請書管理番号().value(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get連携用データ送付記録一覧 extends DbeTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<RenkeiyoDataSofuKiroku> result = sut.get連携用データ送付記録一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5191RenkeiyoDataSofuKirokuEntity> entityList = Arrays.asList(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<RenkeiyoDataSofuKiroku> result = sut.get連携用データ送付記録一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save連携用データ送付記録 extends DbeTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5191RenkeiyoDataSofuKirokuEntity.class))).thenReturn(1);

            DbT5191RenkeiyoDataSofuKirokuEntity entity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = new RenkeiyoDataSofuKiroku(entity);

            assertThat(sut.save連携用データ送付記録(連携用データ送付記録), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5191RenkeiyoDataSofuKirokuEntity.class))).thenReturn(0);

            DbT5191RenkeiyoDataSofuKirokuEntity entity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = new RenkeiyoDataSofuKiroku(entity);

            assertThat(sut.save連携用データ送付記録(連携用データ送付記録), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5191RenkeiyoDataSofuKirokuEntity.class))).thenReturn(1);

            DbT5191RenkeiyoDataSofuKirokuEntity entity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
            entity.initializeMd5();
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = new RenkeiyoDataSofuKiroku(entity);
            連携用データ送付記録 = 連携用データ送付記録.createBuilderForEdit().set再イメージ送付区分(new RString("再イメージ送付区分を変更")).build();

            assertThat(sut.save連携用データ送付記録(連携用データ送付記録), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5191RenkeiyoDataSofuKirokuEntity.class))).thenReturn(0);

            DbT5191RenkeiyoDataSofuKirokuEntity entity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
            entity.initializeMd5();
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = new RenkeiyoDataSofuKiroku(entity);
            連携用データ送付記録 = 連携用データ送付記録.createBuilderForEdit().set再イメージ送付区分(new RString("再イメージ送付区分を変更")).build();

            assertThat(sut.save連携用データ送付記録(連携用データ送付記録), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5191RenkeiyoDataSofuKirokuEntity.class))).thenReturn(1);

            DbT5191RenkeiyoDataSofuKirokuEntity entity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
            entity.initializeMd5();
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = new RenkeiyoDataSofuKiroku(entity);
            連携用データ送付記録 = 連携用データ送付記録.deleted();

            assertThat(sut.save連携用データ送付記録(連携用データ送付記録), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5191RenkeiyoDataSofuKirokuEntity.class))).thenReturn(0);

            DbT5191RenkeiyoDataSofuKirokuEntity entity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
            entity.initializeMd5();
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = new RenkeiyoDataSofuKiroku(entity);
            連携用データ送付記録 = 連携用データ送付記録.deleted();

            assertThat(sut.save連携用データ送付記録(連携用データ送付記録), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5191RenkeiyoDataSofuKirokuEntity entity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
            entity.initializeMd5();
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = new RenkeiyoDataSofuKiroku(entity);

            assertThat(sut.save連携用データ送付記録(連携用データ送付記録), is(false));
        }
    }
}
