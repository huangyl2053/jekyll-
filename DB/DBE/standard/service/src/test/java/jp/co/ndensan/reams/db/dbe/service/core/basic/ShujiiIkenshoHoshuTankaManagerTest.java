/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShujiiIkenshoHoshuTanka;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5032ShujiiIkenshoHoshuTankaEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5032ShujiiIkenshoHoshuTankaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {link ShujiiIkenshoHoshuTankaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoHoshuTankaManagerTest {

    private static DbT5032ShujiiIkenshoHoshuTankaDac dac;
    private static ShujiiIkenshoHoshuTankaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5032ShujiiIkenshoHoshuTankaDac.class);
        sut = new ShujiiIkenshoHoshuTankaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get意見書作成報酬単価 extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー2 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_意見書作成回数区分;
            FlexibleYearMonth 主キー3 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_開始年月;
            sut.get意見書作成報酬単価(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー1 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_在宅施設区分;
            FlexibleYearMonth 主キー3 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_開始年月;
            sut.get意見書作成報酬単価(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー1 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_在宅施設区分;
            Code 主キー2 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_意見書作成回数区分;
            sut.get意見書作成報酬単価(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(Code.class), any(Code.class), any(FlexibleYearMonth.class))).thenReturn(null);
            Code 主キー1 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_在宅施設区分;
            Code 主キー2 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_意見書作成回数区分;
            FlexibleYearMonth 主キー3 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_開始年月;
            ShujiiIkenshoHoshuTanka result = sut.get意見書作成報酬単価(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5032ShujiiIkenshoHoshuTankaEntity entity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
            when(dac.selectByKey(any(Code.class), any(Code.class), any(FlexibleYearMonth.class))).thenReturn(entity);
            Code 主キー1 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_在宅施設区分;
            Code 主キー2 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_意見書作成回数区分;
            FlexibleYearMonth 主キー3 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_開始年月;
            ShujiiIkenshoHoshuTanka result = sut.get意見書作成報酬単価(主キー1, 主キー2, 主キー3);

            assertThat(result.get在宅施設区分().value(), is(DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_在宅施設区分.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get意見書作成報酬単価一覧 extends DbeTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShujiiIkenshoHoshuTanka> result = sut.get意見書作成報酬単価一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5032ShujiiIkenshoHoshuTankaEntity> entityList = Arrays.asList(DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShujiiIkenshoHoshuTanka> result = sut.get意見書作成報酬単価一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get在宅施設区分().value(), is(DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_在宅施設区分.value()));
        }
    }

    public static class save意見書作成報酬単価 extends DbeTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5032ShujiiIkenshoHoshuTankaEntity.class))).thenReturn(1);

            DbT5032ShujiiIkenshoHoshuTankaEntity entity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
            ShujiiIkenshoHoshuTanka 意見書作成報酬単価 = new ShujiiIkenshoHoshuTanka(entity);

            assertThat(sut.save意見書作成報酬単価(意見書作成報酬単価), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5032ShujiiIkenshoHoshuTankaEntity.class))).thenReturn(0);

            DbT5032ShujiiIkenshoHoshuTankaEntity entity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
            ShujiiIkenshoHoshuTanka 意見書作成報酬単価 = new ShujiiIkenshoHoshuTanka(entity);

            assertThat(sut.save意見書作成報酬単価(意見書作成報酬単価), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5032ShujiiIkenshoHoshuTankaEntity.class))).thenReturn(1);

            DbT5032ShujiiIkenshoHoshuTankaEntity entity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
            entity.initializeMd5();
            ShujiiIkenshoHoshuTanka 意見書作成報酬単価 = new ShujiiIkenshoHoshuTanka(entity);
            意見書作成報酬単価 = 意見書作成報酬単価.createBuilderForEdit().set単価(new Decimal(1000)).build();

            assertThat(sut.save意見書作成報酬単価(意見書作成報酬単価), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5032ShujiiIkenshoHoshuTankaEntity.class))).thenReturn(0);

            DbT5032ShujiiIkenshoHoshuTankaEntity entity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
            entity.initializeMd5();
            ShujiiIkenshoHoshuTanka 意見書作成報酬単価 = new ShujiiIkenshoHoshuTanka(entity);
            意見書作成報酬単価 = 意見書作成報酬単価.createBuilderForEdit().set単価(new Decimal(1000)).build();

            assertThat(sut.save意見書作成報酬単価(意見書作成報酬単価), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5032ShujiiIkenshoHoshuTankaEntity.class))).thenReturn(1);

            DbT5032ShujiiIkenshoHoshuTankaEntity entity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
            entity.initializeMd5();
            ShujiiIkenshoHoshuTanka 意見書作成報酬単価 = new ShujiiIkenshoHoshuTanka(entity);
            意見書作成報酬単価 = 意見書作成報酬単価.deleted();

            assertThat(sut.save意見書作成報酬単価(意見書作成報酬単価), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5032ShujiiIkenshoHoshuTankaEntity.class))).thenReturn(0);

            DbT5032ShujiiIkenshoHoshuTankaEntity entity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
            entity.initializeMd5();
            ShujiiIkenshoHoshuTanka 意見書作成報酬単価 = new ShujiiIkenshoHoshuTanka(entity);
            意見書作成報酬単価 = 意見書作成報酬単価.deleted();

            assertThat(sut.save意見書作成報酬単価(意見書作成報酬単価), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5032ShujiiIkenshoHoshuTankaEntity entity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
            entity.initializeMd5();
            ShujiiIkenshoHoshuTanka 意見書作成報酬単価 = new ShujiiIkenshoHoshuTanka(entity);

            assertThat(sut.save意見書作成報酬単価(意見書作成報酬単価), is(false));
        }
    }
}
