/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KijunShunyugakuTekiyoKanri;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3116KijunShunyugakuTekiyoKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3116KijunShunyugakuTekiyoKanriDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {link KijunShunyugakuTekiyoKanriManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KijunShunyugakuTekiyoKanriManagerTest {

    private static DbT3116KijunShunyugakuTekiyoKanriDac dac;
    private static KijunShunyugakuTekiyoKanriManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3116KijunShunyugakuTekiyoKanriDac.class);
        sut = new KijunShunyugakuTekiyoKanriManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get基準収入額適用管理 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー2 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_年度;
            Decimal 主キー3 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_履歴番号;
            HokenshaNo 主キー4 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_被保険者番号;
            sut.get基準収入額適用管理(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            SetaiCode 主キー1 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_世帯コード;
            Decimal 主キー3 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_履歴番号;
            HokenshaNo 主キー4 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_被保険者番号;
            sut.get基準収入額適用管理(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            SetaiCode 主キー1 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_世帯コード;
            FlexibleYear 主キー2 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_年度;
            HokenshaNo 主キー4 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_被保険者番号;
            sut.get基準収入額適用管理(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            SetaiCode 主キー1 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_世帯コード;
            FlexibleYear 主キー2 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_年度;
            Decimal 主キー3 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_履歴番号;
            sut.get基準収入額適用管理(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(SetaiCode.class), any(FlexibleYear.class), any(Decimal.class), any(HokenshaNo.class))).thenReturn(null);
            SetaiCode 主キー1 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_世帯コード;
            FlexibleYear 主キー2 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_年度;
            Decimal 主キー3 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_履歴番号;
            HokenshaNo 主キー4 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_被保険者番号;
            KijunShunyugakuTekiyoKanri result = sut.get基準収入額適用管理(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3116KijunShunyugakuTekiyoKanriEntity entity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            when(dac.selectByKey(any(SetaiCode.class), any(FlexibleYear.class), any(Decimal.class), any(HokenshaNo.class))).thenReturn(entity);
            SetaiCode 主キー1 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_世帯コード;
            FlexibleYear 主キー2 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_年度;
            Decimal 主キー3 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_履歴番号;
            HokenshaNo 主キー4 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_被保険者番号;
            KijunShunyugakuTekiyoKanri result = sut.get基準収入額適用管理(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get世帯コード().value(), is(DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_世帯コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get基準収入額適用管理一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KijunShunyugakuTekiyoKanri> result = sut.get基準収入額適用管理一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3116KijunShunyugakuTekiyoKanriEntity> entityList = Arrays.asList(DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KijunShunyugakuTekiyoKanri> result = sut.get基準収入額適用管理一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get世帯コード().value(), is(DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_世帯コード.value()));
        }
    }

    public static class save基準収入額適用管理 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3116KijunShunyugakuTekiyoKanriEntity.class))).thenReturn(1);

            DbT3116KijunShunyugakuTekiyoKanriEntity entity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            KijunShunyugakuTekiyoKanri 基準収入額適用管理 = new KijunShunyugakuTekiyoKanri(entity);

            assertThat(sut.save基準収入額適用管理(基準収入額適用管理), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3116KijunShunyugakuTekiyoKanriEntity.class))).thenReturn(0);

            DbT3116KijunShunyugakuTekiyoKanriEntity entity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            KijunShunyugakuTekiyoKanri 基準収入額適用管理 = new KijunShunyugakuTekiyoKanri(entity);

            assertThat(sut.save基準収入額適用管理(基準収入額適用管理), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3116KijunShunyugakuTekiyoKanriEntity.class))).thenReturn(1);

            DbT3116KijunShunyugakuTekiyoKanriEntity entity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            entity.initializeMd5();
            KijunShunyugakuTekiyoKanri 基準収入額適用管理 = new KijunShunyugakuTekiyoKanri(entity);
            基準収入額適用管理 = 基準収入額適用管理.createBuilderForEdit().setその他の収入額(new Decimal(100000)).build();

            assertThat(sut.save基準収入額適用管理(基準収入額適用管理), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3116KijunShunyugakuTekiyoKanriEntity.class))).thenReturn(0);

            DbT3116KijunShunyugakuTekiyoKanriEntity entity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            entity.initializeMd5();
            KijunShunyugakuTekiyoKanri 基準収入額適用管理 = new KijunShunyugakuTekiyoKanri(entity);
            基準収入額適用管理 = 基準収入額適用管理.createBuilderForEdit().setその他の収入額(new Decimal(100000)).build();

            assertThat(sut.save基準収入額適用管理(基準収入額適用管理), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3116KijunShunyugakuTekiyoKanriEntity.class))).thenReturn(1);

            DbT3116KijunShunyugakuTekiyoKanriEntity entity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            entity.initializeMd5();
            KijunShunyugakuTekiyoKanri 基準収入額適用管理 = new KijunShunyugakuTekiyoKanri(entity);
            基準収入額適用管理 = 基準収入額適用管理.deleted();

            assertThat(sut.save基準収入額適用管理(基準収入額適用管理), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3116KijunShunyugakuTekiyoKanriEntity.class))).thenReturn(0);

            DbT3116KijunShunyugakuTekiyoKanriEntity entity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            entity.initializeMd5();
            KijunShunyugakuTekiyoKanri 基準収入額適用管理 = new KijunShunyugakuTekiyoKanri(entity);
            基準収入額適用管理 = 基準収入額適用管理.deleted();

            assertThat(sut.save基準収入額適用管理(基準収入額適用管理), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3116KijunShunyugakuTekiyoKanriEntity entity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            entity.initializeMd5();
            KijunShunyugakuTekiyoKanri 基準収入額適用管理 = new KijunShunyugakuTekiyoKanri(entity);

            assertThat(sut.save基準収入額適用管理(基準収入額適用管理), is(false));
        }
    }
}
