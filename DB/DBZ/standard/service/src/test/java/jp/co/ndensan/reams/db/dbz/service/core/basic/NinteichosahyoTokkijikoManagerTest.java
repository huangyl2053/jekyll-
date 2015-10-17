/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5205NinteichosahyoTokkijikoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5205NinteichosahyoTokkijikoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * {link NinteichosahyoTokkijikoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoTokkijikoManagerTest {

    private static DbT5205NinteichosahyoTokkijikoDac dac;
    private static NinteichosahyoTokkijikoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5205NinteichosahyoTokkijikoDac.class);
        sut = new NinteichosahyoTokkijikoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_特記情報 extends DbzTestBase {

        ShinseishoKanriNo 申請書管理番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_申請書管理番号;
        int 認定調査依頼履歴番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
        RString 認定調査特記事項番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査特記事項番号;
        RString 認定調査特記事項連番 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査特記事項連番;
        RString 特記事項テキスト_イメージ区分 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_特記事項テキスト_イメージ区分;
        Code 原本マスク区分 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_原本マスク区分;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の申請書管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get認定調査票_特記情報(null, 認定調査依頼履歴番号, 認定調査特記事項番号, 認定調査特記事項連番, 特記事項テキスト_イメージ区分, 原本マスク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の認定調査特記事項番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get認定調査票_特記情報(申請書管理番号, 認定調査依頼履歴番号, null, 認定調査特記事項連番, 特記事項テキスト_イメージ区分, 原本マスク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の認定調査特記事項連番にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get認定調査票_特記情報(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号, null, 特記事項テキスト_イメージ区分, 原本マスク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の特記事項テキスト_イメージ区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get認定調査票_特記情報(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号, 認定調査特記事項連番, null, 原本マスク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の原本マスク区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get認定調査票_特記情報(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号, 認定調査特記事項連番, 特記事項テキスト_イメージ区分, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class), any(RString.class), any(RString.class), any(RString.class), any(Code.class))).thenReturn(null);

            ShinseishoKanriNo 申請書管理番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_申請書管理番号;
            int 認定調査依頼履歴番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
            NinteichosahyoTokkijiko result = sut.get認定調査票_特記情報(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号, 認定調査特記事項連番, 特記事項テキスト_イメージ区分, 原本マスク区分);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5205NinteichosahyoTokkijikoEntity entity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class), any(RString.class), any(RString.class), any(RString.class), any(Code.class))).thenReturn(entity);

            ShinseishoKanriNo 申請書管理番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_申請書管理番号;
            int 認定調査依頼履歴番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
            NinteichosahyoTokkijiko result = sut.get認定調査票_特記情報(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号, 認定調査特記事項連番, 特記事項テキスト_イメージ区分, 原本マスク区分);

            assertThat(result.get申請書管理番号().value(), is(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査票_特記情報一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteichosahyoTokkijiko> result = sut.get認定調査票_特記情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5205NinteichosahyoTokkijikoEntity> entityList = Arrays.asList(DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteichosahyoTokkijiko> result = sut.get認定調査票_特記情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save認定調査票_特記情報 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5205NinteichosahyoTokkijikoEntity.class))).thenReturn(1);

            DbT5205NinteichosahyoTokkijikoEntity entity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();
            NinteichosahyoTokkijiko 認定調査票_特記情報 = new NinteichosahyoTokkijiko(entity);

            assertThat(sut.save認定調査票_特記情報(認定調査票_特記情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5205NinteichosahyoTokkijikoEntity.class))).thenReturn(0);

            DbT5205NinteichosahyoTokkijikoEntity entity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();
            NinteichosahyoTokkijiko 認定調査票_特記情報 = new NinteichosahyoTokkijiko(entity);

            assertThat(sut.save認定調査票_特記情報(認定調査票_特記情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5205NinteichosahyoTokkijikoEntity.class))).thenReturn(1);

            DbT5205NinteichosahyoTokkijikoEntity entity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();
            entity.initializeMd5();
            NinteichosahyoTokkijiko 認定調査票_特記情報 = new NinteichosahyoTokkijiko(entity);
            認定調査票_特記情報 = 認定調査票_特記情報.createBuilderForEdit().set認定調査特記事項番号(new RString("認定調査特記事項番号を変更")).build();

            assertThat(sut.save認定調査票_特記情報(認定調査票_特記情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5205NinteichosahyoTokkijikoEntity.class))).thenReturn(0);

            DbT5205NinteichosahyoTokkijikoEntity entity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();
            entity.initializeMd5();
            NinteichosahyoTokkijiko 認定調査票_特記情報 = new NinteichosahyoTokkijiko(entity);
            認定調査票_特記情報 = 認定調査票_特記情報.createBuilderForEdit().set認定調査特記事項番号(new RString("認定調査特記事項番号を変更")).build();

            assertThat(sut.save認定調査票_特記情報(認定調査票_特記情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5205NinteichosahyoTokkijikoEntity.class))).thenReturn(1);

            DbT5205NinteichosahyoTokkijikoEntity entity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();
            entity.initializeMd5();
            NinteichosahyoTokkijiko 認定調査票_特記情報 = new NinteichosahyoTokkijiko(entity);
            認定調査票_特記情報 = 認定調査票_特記情報.deleted();

            assertThat(sut.save認定調査票_特記情報(認定調査票_特記情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5205NinteichosahyoTokkijikoEntity.class))).thenReturn(0);

            DbT5205NinteichosahyoTokkijikoEntity entity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();
            entity.initializeMd5();
            NinteichosahyoTokkijiko 認定調査票_特記情報 = new NinteichosahyoTokkijiko(entity);
            認定調査票_特記情報 = 認定調査票_特記情報.deleted();

            assertThat(sut.save認定調査票_特記情報(認定調査票_特記情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5205NinteichosahyoTokkijikoEntity entity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();
            entity.initializeMd5();
            NinteichosahyoTokkijiko 認定調査票_特記情報 = new NinteichosahyoTokkijiko(entity);

            assertThat(sut.save認定調査票_特記情報(認定調査票_特記情報), is(false));
        }
    }
}
