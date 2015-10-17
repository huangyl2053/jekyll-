/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3104KokuhorenInterfaceKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KokuhorenInterfaceKanriManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KokuhorenInterfaceKanriManagerTest {

    private static DbT3104KokuhorenInterfaceKanriDac dac;
    private static KokuhorenInterfaceKanriManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3104KokuhorenInterfaceKanriDac.class);
        sut = new KokuhorenInterfaceKanriManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get国保連インターフェース管理 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_交換情報識別番号;
            sut.get国保連インターフェース管理(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理年月;
            sut.get国保連インターフェース管理(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(RString.class))).thenReturn(null);

            FlexibleYearMonth 主キー1 = DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理年月;
            RString 主キー2 = DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_交換情報識別番号;
            KokuhorenInterfaceKanri result = sut.get国保連インターフェース管理(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3104KokuhorenInterfaceKanriEntity entity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(RString.class))).thenReturn(entity);

            FlexibleYearMonth 主キー1 = DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理年月;
            RString 主キー2 = DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_交換情報識別番号;
            KokuhorenInterfaceKanri result = sut.get国保連インターフェース管理(主キー1, 主キー2);

            assertThat(result.get処理年月().toDateString(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理年月.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get国保連インターフェース管理一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KokuhorenInterfaceKanri> result = sut.get国保連インターフェース管理一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3104KokuhorenInterfaceKanriEntity> entityList = Arrays.asList(DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KokuhorenInterfaceKanri> result = sut.get国保連インターフェース管理一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get処理年月().toDateString(), is(DbT3104KokuhorenInterfaceKanriEntityGenerator.DEFAULT_処理年月.toDateString()));
        }
    }

    public static class save国保連インターフェース管理 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3104KokuhorenInterfaceKanriEntity.class))).thenReturn(1);

            DbT3104KokuhorenInterfaceKanriEntity entity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            KokuhorenInterfaceKanri 国保連インターフェース管理 = new KokuhorenInterfaceKanri(entity);

            assertThat(sut.save国保連インターフェース管理(国保連インターフェース管理), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3104KokuhorenInterfaceKanriEntity.class))).thenReturn(0);

            DbT3104KokuhorenInterfaceKanriEntity entity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            KokuhorenInterfaceKanri 国保連インターフェース管理 = new KokuhorenInterfaceKanri(entity);

            assertThat(sut.save国保連インターフェース管理(国保連インターフェース管理), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3104KokuhorenInterfaceKanriEntity.class))).thenReturn(1);

            DbT3104KokuhorenInterfaceKanriEntity entity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            entity.initializeMd5();
            KokuhorenInterfaceKanri 国保連インターフェース管理 = new KokuhorenInterfaceKanri(entity);
            国保連インターフェース管理 = 国保連インターフェース管理.createBuilderForEdit().set交換情報識別番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save国保連インターフェース管理(国保連インターフェース管理), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3104KokuhorenInterfaceKanriEntity.class))).thenReturn(0);

            DbT3104KokuhorenInterfaceKanriEntity entity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            entity.initializeMd5();
            KokuhorenInterfaceKanri 国保連インターフェース管理 = new KokuhorenInterfaceKanri(entity);
            国保連インターフェース管理 = 国保連インターフェース管理.createBuilderForEdit().set交換情報識別番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save国保連インターフェース管理(国保連インターフェース管理), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3104KokuhorenInterfaceKanriEntity.class))).thenReturn(1);

            DbT3104KokuhorenInterfaceKanriEntity entity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            entity.initializeMd5();
            KokuhorenInterfaceKanri 国保連インターフェース管理 = new KokuhorenInterfaceKanri(entity);
            国保連インターフェース管理 = 国保連インターフェース管理.deleted();

            assertThat(sut.save国保連インターフェース管理(国保連インターフェース管理), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3104KokuhorenInterfaceKanriEntity.class))).thenReturn(0);

            DbT3104KokuhorenInterfaceKanriEntity entity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            entity.initializeMd5();
            KokuhorenInterfaceKanri 国保連インターフェース管理 = new KokuhorenInterfaceKanri(entity);
            国保連インターフェース管理 = 国保連インターフェース管理.deleted();

            assertThat(sut.save国保連インターフェース管理(国保連インターフェース管理), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3104KokuhorenInterfaceKanriEntity entity = DbT3104KokuhorenInterfaceKanriEntityGenerator.createDbT3104KokuhorenInterfaceKanriEntity();
            entity.initializeMd5();
            KokuhorenInterfaceKanri 国保連インターフェース管理 = new KokuhorenInterfaceKanri(entity);

            assertThat(sut.save国保連インターフェース管理(国保連インターフェース管理), is(false));
        }
    }
}
