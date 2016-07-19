/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManeger;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7064CareManegerEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7064CareManegerDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link CareManegerManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class CareManegerManagerTest {

    private static DbT7064CareManegerDac dac;
    private static CareManegerManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7064CareManegerDac.class);
        sut = new CareManegerManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護支援専門員 extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数の介護支援専門員番号にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員番号;
            sut.get介護支援専門員(null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class))).thenReturn(null);

            RString 主キー1 = DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員番号;
            CareManeger result = sut.get介護支援専門員(主キー1);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7064CareManegerEntity entity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            when(dac.selectByKey(any(RString.class))).thenReturn(entity);

            RString 主キー1 = DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員番号;
            CareManeger result = sut.get介護支援専門員(主キー1);

            assertThat(result.get介護支援専門員番号(), is(DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員番号));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護支援専門員一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<CareManeger> result = sut.get介護支援専門員一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7064CareManegerEntity> entityList = Arrays.asList(DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<CareManeger> result = sut.get介護支援専門員一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get介護支援専門員番号(), is(DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員番号));
        }
    }

    public static class save介護支援専門員 extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7064CareManegerEntity.class))).thenReturn(1);

            DbT7064CareManegerEntity entity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            CareManeger 介護支援専門員 = new CareManeger(entity);

            assertThat(sut.save介護支援専門員(介護支援専門員), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7064CareManegerEntity.class))).thenReturn(0);

            DbT7064CareManegerEntity entity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            CareManeger 介護支援専門員 = new CareManeger(entity);

            assertThat(sut.save介護支援専門員(介護支援専門員), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7064CareManegerEntity.class))).thenReturn(1);

            DbT7064CareManegerEntity entity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            entity.initializeMd5();
            CareManeger 介護支援専門員 = new CareManeger(entity);
            介護支援専門員 = 介護支援専門員.createBuilderForEdit().set介護支援専門員番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護支援専門員(介護支援専門員), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7064CareManegerEntity.class))).thenReturn(0);

            DbT7064CareManegerEntity entity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            entity.initializeMd5();
            CareManeger 介護支援専門員 = new CareManeger(entity);
            介護支援専門員 = 介護支援専門員.createBuilderForEdit().set有効終了年月日(new FlexibleDate("20150909")).build();

            assertThat(sut.save介護支援専門員(介護支援専門員), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7064CareManegerEntity.class))).thenReturn(1);

            DbT7064CareManegerEntity entity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            entity.initializeMd5();
            CareManeger 介護支援専門員 = new CareManeger(entity);
            介護支援専門員 = 介護支援専門員.deleted();

            assertThat(sut.save介護支援専門員(介護支援専門員), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7064CareManegerEntity.class))).thenReturn(0);

            DbT7064CareManegerEntity entity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            entity.initializeMd5();
            CareManeger 介護支援専門員 = new CareManeger(entity);
            介護支援専門員 = 介護支援専門員.deleted();

            assertThat(sut.save介護支援専門員(介護支援専門員), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7064CareManegerEntity entity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            entity.initializeMd5();
            CareManeger 介護支援専門員 = new CareManeger(entity);

            assertThat(sut.save介護支援専門員(介護支援専門員), is(false));
        }
    }
}
