/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuTanka;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5031NinteiChosaHoshuTankaEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5031NinteiChosaHoshuTankaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link NinteiChosaHoshuTankaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class NinteiChosaHoshuTankaManagerTest {

    private static DbT5031NinteiChosaHoshuTankaDac dac;
    private static NinteiChosaHoshuTankaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5031NinteiChosaHoshuTankaDac.class);
        sut = new NinteiChosaHoshuTankaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査報酬単価 extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー2 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_訪問種別;
            FlexibleYearMonth 主キー4 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_開始年月;
            FlexibleYearMonth 主キー5 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_終了年月;
            sut.get認定調査報酬単価(null, 主キー2, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー1 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_調査区分;
            FlexibleYearMonth 主キー4 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_開始年月;
            FlexibleYearMonth 主キー5 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_終了年月;
            sut.get認定調査報酬単価(主キー1, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー1 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_調査区分;
            Code 主キー2 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_訪問種別;
            FlexibleYearMonth 主キー5 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_終了年月;
            sut.get認定調査報酬単価(主キー1, 主キー2, null, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー1 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_調査区分;
            Code 主キー2 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_訪問種別;
            FlexibleYearMonth 主キー4 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_開始年月;
            sut.get認定調査報酬単価(主キー1, 主キー2, 主キー4, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(Code.class), any(Code.class), any(FlexibleYearMonth.class), any(FlexibleYearMonth.class))).thenReturn(null);
            Code 主キー1 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_調査区分;
            Code 主キー2 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_訪問種別;
            FlexibleYearMonth 主キー4 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_開始年月;
            FlexibleYearMonth 主キー5 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_終了年月;
            NinteiChosaHoshuTanka result = sut.get認定調査報酬単価(主キー1, 主キー2, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            when(dac.selectByKey(any(Code.class), any(Code.class), any(FlexibleYearMonth.class), any(FlexibleYearMonth.class))).thenReturn(entity);
            Code 主キー1 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_調査区分;
            Code 主キー2 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_訪問種別;

            FlexibleYearMonth 主キー4 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_開始年月;
            FlexibleYearMonth 主キー5 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_終了年月;
            NinteiChosaHoshuTanka result = sut.get認定調査報酬単価(主キー1, 主キー2, 主キー4, 主キー5);

            assertThat(result.get調査区分().value(), is(DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_調査区分.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get認定調査報酬単価一覧 extends DbeTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteiChosaHoshuTanka> result = sut.get認定調査報酬単価一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5031NinteiChosaHoshuTankaEntity> entityList = Arrays.asList(DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteiChosaHoshuTanka> result = sut.get認定調査報酬単価一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get調査区分().value(), is(DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_調査区分.value()));
        }
    }

    public static class save認定調査報酬単価 extends DbeTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(1);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(0);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(1);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.initializeMd5();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);
//            認定調査報酬単価 = 認定調査報酬単価.createBuilderForEdit().set調査区分(new Code("3")).build();

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(0);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.initializeMd5();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);
//            認定調査報酬単価 = 認定調査報酬単価.createBuilderForEdit().set調査区分(new Code("3")).build();

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(1);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.initializeMd5();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);
            認定調査報酬単価 = 認定調査報酬単価.deleted();

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5031NinteiChosaHoshuTankaEntity.class))).thenReturn(0);

            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.initializeMd5();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);
            認定調査報酬単価 = 認定調査報酬単価.deleted();

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5031NinteiChosaHoshuTankaEntity entity = DbT5031NinteiChosaHoshuTankaEntityGenerator.createDbT5031NinteiChosaHoshuTankaEntity();
            entity.initializeMd5();
            NinteiChosaHoshuTanka 認定調査報酬単価 = new NinteiChosaHoshuTanka(entity);

            assertThat(sut.save認定調査報酬単価(認定調査報酬単価), is(false));
        }
    }
}
