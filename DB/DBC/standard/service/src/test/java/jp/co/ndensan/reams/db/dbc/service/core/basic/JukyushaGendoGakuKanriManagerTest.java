/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaGendoGakuKanri;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7116JukyushaGendoGakuKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7116JukyushaGendoGakuKanriDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link JukyushaGendoGakuKanriManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class JukyushaGendoGakuKanriManagerTest {

    private static DbT7116JukyushaGendoGakuKanriDac dac;
    private static JukyushaGendoGakuKanriManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7116JukyushaGendoGakuKanriDac.class);
        sut = new JukyushaGendoGakuKanriManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get受給者限度額管理 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分;
            FlexibleYearMonth 主キー3 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月;
            int 主キー4 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_履歴番号;
            sut.get受給者限度額管理(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー3 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月;
            int 主キー4 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_履歴番号;
            sut.get受給者限度額管理(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分;
            int 主キー4 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_履歴番号;
            sut.get受給者限度額管理(主キー1, 主キー2, null, 主キー4);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分;
            FlexibleYearMonth 主キー3 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月;
            int 主キー4 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_履歴番号;
            JukyushaGendoGakuKanri result = sut.get受給者限度額管理(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7116JukyushaGendoGakuKanriEntity entity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分;
            FlexibleYearMonth 主キー3 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月;
            int 主キー4 = DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_履歴番号;
            JukyushaGendoGakuKanri result = sut.get受給者限度額管理(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get被保険者番号().value(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get受給者限度額管理一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<JukyushaGendoGakuKanri> result = sut.get受給者限度額管理一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7116JukyushaGendoGakuKanriEntity> entityList = Arrays.asList(DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<JukyushaGendoGakuKanri> result = sut.get受給者限度額管理一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save受給者限度額管理 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7116JukyushaGendoGakuKanriEntity.class))).thenReturn(1);

            DbT7116JukyushaGendoGakuKanriEntity entity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            JukyushaGendoGakuKanri 受給者限度額管理 = new JukyushaGendoGakuKanri(entity);

            assertThat(sut.save受給者限度額管理(受給者限度額管理), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7116JukyushaGendoGakuKanriEntity.class))).thenReturn(0);

            DbT7116JukyushaGendoGakuKanriEntity entity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            JukyushaGendoGakuKanri 受給者限度額管理 = new JukyushaGendoGakuKanri(entity);

            assertThat(sut.save受給者限度額管理(受給者限度額管理), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7116JukyushaGendoGakuKanriEntity.class))).thenReturn(1);

            DbT7116JukyushaGendoGakuKanriEntity entity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            entity.initializeMd5();
            JukyushaGendoGakuKanri 受給者限度額管理 = new JukyushaGendoGakuKanri(entity);
            受給者限度額管理 = 受給者限度額管理.createBuilderForEdit().set拡大倍数(new RString("任意項目1を変更")).build();

            assertThat(sut.save受給者限度額管理(受給者限度額管理), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7116JukyushaGendoGakuKanriEntity.class))).thenReturn(0);

            DbT7116JukyushaGendoGakuKanriEntity entity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            entity.initializeMd5();
            JukyushaGendoGakuKanri 受給者限度額管理 = new JukyushaGendoGakuKanri(entity);
            受給者限度額管理 = 受給者限度額管理.createBuilderForEdit().set拡大倍数(new RString("任意項目1を変更")).build();

            assertThat(sut.save受給者限度額管理(受給者限度額管理), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7116JukyushaGendoGakuKanriEntity.class))).thenReturn(1);

            DbT7116JukyushaGendoGakuKanriEntity entity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            entity.initializeMd5();
            JukyushaGendoGakuKanri 受給者限度額管理 = new JukyushaGendoGakuKanri(entity);
            受給者限度額管理 = 受給者限度額管理.deleted();

            assertThat(sut.save受給者限度額管理(受給者限度額管理), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7116JukyushaGendoGakuKanriEntity.class))).thenReturn(0);

            DbT7116JukyushaGendoGakuKanriEntity entity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            entity.initializeMd5();
            JukyushaGendoGakuKanri 受給者限度額管理 = new JukyushaGendoGakuKanri(entity);
            受給者限度額管理 = 受給者限度額管理.deleted();

            assertThat(sut.save受給者限度額管理(受給者限度額管理), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7116JukyushaGendoGakuKanriEntity entity = DbT7116JukyushaGendoGakuKanriEntityGenerator.createDbT7116JukyushaGendoGakuKanriEntity();
            entity.initializeMd5();
            JukyushaGendoGakuKanri 受給者限度額管理 = new JukyushaGendoGakuKanri(entity);

            assertThat(sut.save受給者限度額管理(受給者限度額管理), is(false));
        }
    }
}
