/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5115ImageEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5115ImageDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {link ImageManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ImageManagerTest {

    private static DbT5115ImageDac dac;
    private static ImageManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5115ImageDac.class);
        sut = new ImageManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class getイメージ情報 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            Decimal 主キー2 = DbT5115ImageEntityGenerator.DEFAULT_取込ページ番号;
            Code 主キー3 = DbT5115ImageEntityGenerator.DEFAULT_原本マスク分;
            sut.getイメージ情報(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            ShinseishoKanriNo 主キー1 = DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号;
            Code 主キー3 = DbT5115ImageEntityGenerator.DEFAULT_原本マスク分;
            sut.getイメージ情報(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            ShinseishoKanriNo 主キー1 = DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号;
            Decimal 主キー2 = DbT5115ImageEntityGenerator.DEFAULT_取込ページ番号;
            sut.getイメージ情報(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(Decimal.class), any(Code.class))).thenReturn(null);
            ShinseishoKanriNo 主キー1 = DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号;
            Decimal 主キー2 = DbT5115ImageEntityGenerator.DEFAULT_取込ページ番号;
            Code 主キー3 = DbT5115ImageEntityGenerator.DEFAULT_原本マスク分;
            Image result = sut.getイメージ情報(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5115ImageEntity entity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(Decimal.class), any(Code.class))).thenReturn(entity);
            ShinseishoKanriNo 主キー1 = DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号;
            Decimal 主キー2 = DbT5115ImageEntityGenerator.DEFAULT_取込ページ番号;
            Code 主キー3 = DbT5115ImageEntityGenerator.DEFAULT_原本マスク分;
            Image result = sut.getイメージ情報(主キー1, 主キー2, 主キー3);

            assertThat(result.get申請書管理番号().value(), is(DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class getイメージ情報一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<Image> result = sut.getイメージ情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5115ImageEntity> entityList = Arrays.asList(DbT5115ImageEntityGenerator.createDbT5115ImageEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<Image> result = sut.getイメージ情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class saveイメージ情報 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5115ImageEntity.class))).thenReturn(1);

            DbT5115ImageEntity entity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
            Image イメージ情報 = new Image(entity);

            assertThat(sut.saveイメージ情報(イメージ情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5115ImageEntity.class))).thenReturn(0);

            DbT5115ImageEntity entity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
            Image イメージ情報 = new Image(entity);

            assertThat(sut.saveイメージ情報(イメージ情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5115ImageEntity.class))).thenReturn(1);

            DbT5115ImageEntity entity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
            entity.initializeMd5();
            Image イメージ情報 = new Image(entity);
            イメージ情報 = イメージ情報.createBuilderForEdit().set原本マスク分(new Code("3")).build();

            assertThat(sut.saveイメージ情報(イメージ情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5115ImageEntity.class))).thenReturn(0);

            DbT5115ImageEntity entity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
            entity.initializeMd5();
            Image イメージ情報 = new Image(entity);
            イメージ情報 = イメージ情報.createBuilderForEdit().set原本マスク分(new Code("3")).build();

            assertThat(sut.saveイメージ情報(イメージ情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5115ImageEntity.class))).thenReturn(1);

            DbT5115ImageEntity entity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
            entity.initializeMd5();
            Image イメージ情報 = new Image(entity);
            イメージ情報 = イメージ情報.deleted();

            assertThat(sut.saveイメージ情報(イメージ情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5115ImageEntity.class))).thenReturn(0);

            DbT5115ImageEntity entity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
            entity.initializeMd5();
            Image イメージ情報 = new Image(entity);
            イメージ情報 = イメージ情報.deleted();

            assertThat(sut.saveイメージ情報(イメージ情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5115ImageEntity entity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
            entity.initializeMd5();
            Image イメージ情報 = new Image(entity);

            assertThat(sut.saveイメージ情報(イメージ情報), is(false));
        }
    }
}
