/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KakushuShinKyuNoHenkan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7028KakushuShinKyuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7028KakushuShinKyuNoHenkanDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link KakushuShinKyuNoHenkanManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KakushuShinKyuNoHenkanManagerTest {

    private static DbT7028KakushuShinKyuNoHenkanDac dac;
    private static KakushuShinKyuNoHenkanManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7028KakushuShinKyuNoHenkanDac.class);
        sut = new KakushuShinKyuNoHenkanManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get各種新旧番号変換テーブル extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分;
            RString 主キー3 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号;
            sut.get各種新旧番号変換テーブル(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号;
            sut.get各種新旧番号変換テーブル(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分;
            sut.get各種新旧番号変換テーブル(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(RString.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分;
            RString 主キー3 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号;
            KakushuShinKyuNoHenkan result = sut.get各種新旧番号変換テーブル(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7028KakushuShinKyuNoHenkanEntity entity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(RString.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分;
            RString 主キー3 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号;
            KakushuShinKyuNoHenkan result = sut.get各種新旧番号変換テーブル(主キー1, 主キー2, 主キー3);

            assertThat(result.get被保険者番号().value(), is(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get各種新旧番号変換テーブル一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KakushuShinKyuNoHenkan> result = sut.get各種新旧番号変換テーブル一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7028KakushuShinKyuNoHenkanEntity> entityList = Arrays.asList(DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KakushuShinKyuNoHenkan> result = sut.get各種新旧番号変換テーブル一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save各種新旧番号変換テーブル extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7028KakushuShinKyuNoHenkanEntity.class))).thenReturn(1);

            DbT7028KakushuShinKyuNoHenkanEntity entity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            KakushuShinKyuNoHenkan 各種新旧番号変換テーブル = new KakushuShinKyuNoHenkan(entity);

            assertThat(sut.save各種新旧番号変換テーブル(各種新旧番号変換テーブル), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7028KakushuShinKyuNoHenkanEntity.class))).thenReturn(0);

            DbT7028KakushuShinKyuNoHenkanEntity entity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            KakushuShinKyuNoHenkan 各種新旧番号変換テーブル = new KakushuShinKyuNoHenkan(entity);

            assertThat(sut.save各種新旧番号変換テーブル(各種新旧番号変換テーブル), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7028KakushuShinKyuNoHenkanEntity.class))).thenReturn(1);

            DbT7028KakushuShinKyuNoHenkanEntity entity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            entity.initializeMd5();
            KakushuShinKyuNoHenkan 各種新旧番号変換テーブル = new KakushuShinKyuNoHenkan(entity);
            各種新旧番号変換テーブル = 各種新旧番号変換テーブル.createBuilderForEdit().set新番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save各種新旧番号変換テーブル(各種新旧番号変換テーブル), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7028KakushuShinKyuNoHenkanEntity.class))).thenReturn(0);

            DbT7028KakushuShinKyuNoHenkanEntity entity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            entity.initializeMd5();
            KakushuShinKyuNoHenkan 各種新旧番号変換テーブル = new KakushuShinKyuNoHenkan(entity);
            各種新旧番号変換テーブル = 各種新旧番号変換テーブル.createBuilderForEdit().set新番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save各種新旧番号変換テーブル(各種新旧番号変換テーブル), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7028KakushuShinKyuNoHenkanEntity.class))).thenReturn(1);

            DbT7028KakushuShinKyuNoHenkanEntity entity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            entity.initializeMd5();
            KakushuShinKyuNoHenkan 各種新旧番号変換テーブル = new KakushuShinKyuNoHenkan(entity);
            各種新旧番号変換テーブル = 各種新旧番号変換テーブル.deleted();

            assertThat(sut.save各種新旧番号変換テーブル(各種新旧番号変換テーブル), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7028KakushuShinKyuNoHenkanEntity.class))).thenReturn(0);

            DbT7028KakushuShinKyuNoHenkanEntity entity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            entity.initializeMd5();
            KakushuShinKyuNoHenkan 各種新旧番号変換テーブル = new KakushuShinKyuNoHenkan(entity);
            各種新旧番号変換テーブル = 各種新旧番号変換テーブル.deleted();

            assertThat(sut.save各種新旧番号変換テーブル(各種新旧番号変換テーブル), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7028KakushuShinKyuNoHenkanEntity entity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            entity.initializeMd5();
            KakushuShinKyuNoHenkan 各種新旧番号変換テーブル = new KakushuShinKyuNoHenkan(entity);

            assertThat(sut.save各種新旧番号変換テーブル(各種新旧番号変換テーブル), is(false));
        }
    }
}
