/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.DaisanshaKoiSongaiBaishoKinJuryo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3079DaisanshaKoiSongaiBaishoKinJuryoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {link DaisanshaKoiSongaiBaishoKinJuryoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DaisanshaKoiSongaiBaishoKinJuryoManagerTest {

    private static DbT3079DaisanshaKoiSongaiBaishoKinJuryoDac dac;
    private static DaisanshaKoiSongaiBaishoKinJuryoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3079DaisanshaKoiSongaiBaishoKinJuryoDac.class);
        sut = new DaisanshaKoiSongaiBaishoKinJuryoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護第三者行為損害賠償金受領 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号;
            Decimal 主キー4 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為損害賠償金受領(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号;
            Decimal 主キー4 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為損害賠償金受領(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号;
            Decimal 主キー4 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為損害賠償金受領(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号;
            sut.get介護第三者行為損害賠償金受領(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(RString.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号;
            Decimal 主キー4 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_履歴番号;
            DaisanshaKoiSongaiBaishoKinJuryo result = sut.get介護第三者行為損害賠償金受領(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(RString.class), any(Decimal.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号;
            RString 主キー3 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号;
            Decimal 主キー4 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_履歴番号;
            DaisanshaKoiSongaiBaishoKinJuryo result = sut.get介護第三者行為損害賠償金受領(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get被保険者番号().value(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護第三者行為損害賠償金受領一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<DaisanshaKoiSongaiBaishoKinJuryo> result = sut.get介護第三者行為損害賠償金受領一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity> entityList = Arrays.asList(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<DaisanshaKoiSongaiBaishoKinJuryo> result = sut.get介護第三者行為損害賠償金受領一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save介護第三者行為損害賠償金受領 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity.class))).thenReturn(1);

            DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            DaisanshaKoiSongaiBaishoKinJuryo 介護第三者行為損害賠償金受領 = new DaisanshaKoiSongaiBaishoKinJuryo(entity);

            assertThat(sut.save介護第三者行為損害賠償金受領(介護第三者行為損害賠償金受領), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity.class))).thenReturn(0);

            DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            DaisanshaKoiSongaiBaishoKinJuryo 介護第三者行為損害賠償金受領 = new DaisanshaKoiSongaiBaishoKinJuryo(entity);

            assertThat(sut.save介護第三者行為損害賠償金受領(介護第三者行為損害賠償金受領), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity.class))).thenReturn(1);

            DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            entity.initializeMd5();
            DaisanshaKoiSongaiBaishoKinJuryo 介護第三者行為損害賠償金受領 = new DaisanshaKoiSongaiBaishoKinJuryo(entity);
            介護第三者行為損害賠償金受領 = 介護第三者行為損害賠償金受領.createBuilderForEdit().set第三者行為届出管理番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護第三者行為損害賠償金受領(介護第三者行為損害賠償金受領), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity.class))).thenReturn(0);

            DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            entity.initializeMd5();
            DaisanshaKoiSongaiBaishoKinJuryo 介護第三者行為損害賠償金受領 = new DaisanshaKoiSongaiBaishoKinJuryo(entity);
            介護第三者行為損害賠償金受領 = 介護第三者行為損害賠償金受領.createBuilderForEdit().set第三者行為届出管理番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護第三者行為損害賠償金受領(介護第三者行為損害賠償金受領), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity.class))).thenReturn(1);

            DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            entity.initializeMd5();
            DaisanshaKoiSongaiBaishoKinJuryo 介護第三者行為損害賠償金受領 = new DaisanshaKoiSongaiBaishoKinJuryo(entity);
            介護第三者行為損害賠償金受領 = 介護第三者行為損害賠償金受領.deleted();

            assertThat(sut.save介護第三者行為損害賠償金受領(介護第三者行為損害賠償金受領), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity.class))).thenReturn(0);

            DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            entity.initializeMd5();
            DaisanshaKoiSongaiBaishoKinJuryo 介護第三者行為損害賠償金受領 = new DaisanshaKoiSongaiBaishoKinJuryo(entity);
            介護第三者行為損害賠償金受領 = 介護第三者行為損害賠償金受領.deleted();

            assertThat(sut.save介護第三者行為損害賠償金受領(介護第三者行為損害賠償金受領), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            entity.initializeMd5();
            DaisanshaKoiSongaiBaishoKinJuryo 介護第三者行為損害賠償金受領 = new DaisanshaKoiSongaiBaishoKinJuryo(entity);

            assertThat(sut.save介護第三者行為損害賠償金受領(介護第三者行為損害賠償金受領), is(false));
        }
    }
}
