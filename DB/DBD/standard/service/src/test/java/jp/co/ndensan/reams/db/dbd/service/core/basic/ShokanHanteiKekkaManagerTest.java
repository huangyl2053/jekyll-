/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import jp.co.ndensan.reams.db.dbd.service.core.basic.ShokanHanteiKekkaManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3036ShokanHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {link ShokanHanteiKekkaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanHanteiKekkaManagerTest {

    private static DbT3036ShokanHanteiKekkaDac dac;
    private static ShokanHanteiKekkaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3036ShokanHanteiKekkaDac.class);
        sut = new ShokanHanteiKekkaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払支給判定結果 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号;
            sut.get償還払支給判定結果(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号;
            sut.get償還払支給判定結果(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
            sut.get償還払支給判定結果(主キー1, 主キー2, null);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号;
            sut.get償還払支給判定結果(主キー1, 主キー2, 主キー3);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号;
            ShokanHanteiKekka result = sut.get償還払支給判定結果(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3036ShokanHanteiKekkaEntity entity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号;
            ShokanHanteiKekka result = sut.get償還払支給判定結果(主キー1, 主キー2, 主キー3);

            assertThat(result.get被保険者番号().value(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払支給判定結果一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanHanteiKekka> result = sut.get償還払支給判定結果一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3036ShokanHanteiKekkaEntity> entityList = Arrays.asList(DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanHanteiKekka> result = sut.get償還払支給判定結果一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save償還払支給判定結果 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3036ShokanHanteiKekkaEntity.class))).thenReturn(1);

            DbT3036ShokanHanteiKekkaEntity entity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            ShokanHanteiKekka 償還払支給判定結果 = new ShokanHanteiKekka(entity);

            assertThat(sut.save償還払支給判定結果(償還払支給判定結果), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3036ShokanHanteiKekkaEntity.class))).thenReturn(0);

            DbT3036ShokanHanteiKekkaEntity entity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            ShokanHanteiKekka 償還払支給判定結果 = new ShokanHanteiKekka(entity);

            assertThat(sut.save償還払支給判定結果(償還払支給判定結果), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3036ShokanHanteiKekkaEntity.class))).thenReturn(1);

            DbT3036ShokanHanteiKekkaEntity entity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            entity.initializeMd5();
            ShokanHanteiKekka 償還払支給判定結果 = new ShokanHanteiKekka(entity);
            償還払支給判定結果 = 償還払支給判定結果.createBuilderForEdit().set整理番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払支給判定結果(償還払支給判定結果), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3036ShokanHanteiKekkaEntity.class))).thenReturn(0);

            DbT3036ShokanHanteiKekkaEntity entity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            entity.initializeMd5();
            ShokanHanteiKekka 償還払支給判定結果 = new ShokanHanteiKekka(entity);
            償還払支給判定結果 = 償還払支給判定結果.createBuilderForEdit().set整理番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払支給判定結果(償還払支給判定結果), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3036ShokanHanteiKekkaEntity.class))).thenReturn(1);

            DbT3036ShokanHanteiKekkaEntity entity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            entity.initializeMd5();
            ShokanHanteiKekka 償還払支給判定結果 = new ShokanHanteiKekka(entity);
            償還払支給判定結果 = 償還払支給判定結果.deleted();

            assertThat(sut.save償還払支給判定結果(償還払支給判定結果), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3036ShokanHanteiKekkaEntity.class))).thenReturn(0);

            DbT3036ShokanHanteiKekkaEntity entity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            entity.initializeMd5();
            ShokanHanteiKekka 償還払支給判定結果 = new ShokanHanteiKekka(entity);
            償還払支給判定結果 = 償還払支給判定結果.deleted();

            assertThat(sut.save償還払支給判定結果(償還払支給判定結果), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3036ShokanHanteiKekkaEntity entity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            entity.initializeMd5();
            ShokanHanteiKekka 償還払支給判定結果 = new ShokanHanteiKekka(entity);

            assertThat(sut.save償還払支給判定結果(償還払支給判定結果), is(false));
        }
    }
}
