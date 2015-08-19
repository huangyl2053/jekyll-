/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3057KogakuShikyuHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3057KogakuShikyuHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {link KogakuShikyuHanteiKekkaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuShikyuHanteiKekkaManagerTest {

    private static DbT3057KogakuShikyuHanteiKekkaDac dac;
    private static KogakuShikyuHanteiKekkaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3057KogakuShikyuHanteiKekkaDac.class);
        sut = new KogakuShikyuHanteiKekkaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額介護サービス費支給判定結果 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            Decimal 主キー4 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
            sut.get高額介護サービス費支給判定結果(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            HokenshaNo 主キー3 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            Decimal 主キー4 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
            sut.get高額介護サービス費支給判定結果(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
            Decimal 主キー4 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
            sut.get高額介護サービス費支給判定結果(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            sut.get高額介護サービス費支給判定結果(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(HokenshaNo.class), any(Decimal.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            Decimal 主キー4 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
            KogakuShikyuHanteiKekka result = sut.get高額介護サービス費支給判定結果(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3057KogakuShikyuHanteiKekkaEntity entity = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(HokenshaNo.class), any(Decimal.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
            HokenshaNo 主キー3 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            Decimal 主キー4 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
            KogakuShikyuHanteiKekka result = sut.get高額介護サービス費支給判定結果(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get主キー1().value(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額介護サービス費支給判定結果一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuShikyuHanteiKekka> result = sut.get高額介護サービス費支給判定結果一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3057KogakuShikyuHanteiKekkaEntity> entityList = Arrays.asList(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuShikyuHanteiKekka> result = sut.get高額介護サービス費支給判定結果一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save高額介護サービス費支給判定結果 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3057KogakuShikyuHanteiKekkaEntity.class))).thenReturn(1);

            DbT3057KogakuShikyuHanteiKekkaEntity entity = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity();
            KogakuShikyuHanteiKekka 高額介護サービス費支給判定結果 = new KogakuShikyuHanteiKekka(entity);

            assertThat(sut.save高額介護サービス費支給判定結果(高額介護サービス費支給判定結果), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3057KogakuShikyuHanteiKekkaEntity.class))).thenReturn(0);

            DbT3057KogakuShikyuHanteiKekkaEntity entity = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity();
            KogakuShikyuHanteiKekka 高額介護サービス費支給判定結果 = new KogakuShikyuHanteiKekka(entity);

            assertThat(sut.save高額介護サービス費支給判定結果(高額介護サービス費支給判定結果), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3057KogakuShikyuHanteiKekkaEntity.class))).thenReturn(1);

            DbT3057KogakuShikyuHanteiKekkaEntity entity = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity();
            entity.initializeMd5();
            KogakuShikyuHanteiKekka 高額介護サービス費支給判定結果 = new KogakuShikyuHanteiKekka(entity);
            高額介護サービス費支給判定結果 = 高額介護サービス費支給判定結果.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額介護サービス費支給判定結果(高額介護サービス費支給判定結果), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3057KogakuShikyuHanteiKekkaEntity.class))).thenReturn(0);

            DbT3057KogakuShikyuHanteiKekkaEntity entity = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity();
            entity.initializeMd5();
            KogakuShikyuHanteiKekka 高額介護サービス費支給判定結果 = new KogakuShikyuHanteiKekka(entity);
            高額介護サービス費支給判定結果 = 高額介護サービス費支給判定結果.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額介護サービス費支給判定結果(高額介護サービス費支給判定結果), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3057KogakuShikyuHanteiKekkaEntity.class))).thenReturn(1);

            DbT3057KogakuShikyuHanteiKekkaEntity entity = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity();
            entity.initializeMd5();
            KogakuShikyuHanteiKekka 高額介護サービス費支給判定結果 = new KogakuShikyuHanteiKekka(entity);
            高額介護サービス費支給判定結果 = 高額介護サービス費支給判定結果.deleted();

            assertThat(sut.save高額介護サービス費支給判定結果(高額介護サービス費支給判定結果), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3057KogakuShikyuHanteiKekkaEntity.class))).thenReturn(0);

            DbT3057KogakuShikyuHanteiKekkaEntity entity = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity();
            entity.initializeMd5();
            KogakuShikyuHanteiKekka 高額介護サービス費支給判定結果 = new KogakuShikyuHanteiKekka(entity);
            高額介護サービス費支給判定結果 = 高額介護サービス費支給判定結果.deleted();

            assertThat(sut.save高額介護サービス費支給判定結果(高額介護サービス費支給判定結果), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3057KogakuShikyuHanteiKekkaEntity entity = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity();
            entity.initializeMd5();
            KogakuShikyuHanteiKekka 高額介護サービス費支給判定結果 = new KogakuShikyuHanteiKekka(entity);

            assertThat(sut.save高額介護サービス費支給判定結果(高額介護サービス費支給判定結果), is(false));
        }
    }
}
