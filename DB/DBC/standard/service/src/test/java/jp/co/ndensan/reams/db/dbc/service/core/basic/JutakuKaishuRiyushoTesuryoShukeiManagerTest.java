/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoShukei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
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
 * {link JutakuKaishuRiyushoTesuryoShukeiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class JutakuKaishuRiyushoTesuryoShukeiManagerTest {

    private static DbT3096JutakuKaishuRiyushoTesuryoShukeiDac dac;
    private static JutakuKaishuRiyushoTesuryoShukeiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3096JutakuKaishuRiyushoTesuryoShukeiDac.class);
        sut = new JutakuKaishuRiyushoTesuryoShukeiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get住宅改修理由書作成手数料請求集計 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月;
            Decimal 主キー3 = new Decimal(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_履歴番号);
            sut.get住宅改修理由書作成手数料請求集計(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HokenshaNo 主キー1 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号;
            Decimal 主キー3 = new Decimal(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_履歴番号);
            sut.get住宅改修理由書作成手数料請求集計(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HokenshaNo 主キー1 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleYearMonth 主キー2 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月;
            sut.get住宅改修理由書作成手数料請求集計(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HokenshaNo.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(null);

            HokenshaNo 主キー1 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleYearMonth 主キー2 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月;
            Decimal 主キー3 = new Decimal(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_履歴番号);
            JutakuKaishuRiyushoTesuryoShukei result = sut.get住宅改修理由書作成手数料請求集計(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            when(dac.selectByKey(any(HokenshaNo.class), any(FlexibleYearMonth.class), any(int.class))).thenReturn(entity);

            HokenshaNo 主キー1 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleYearMonth 主キー2 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月;
            Decimal 主キー3 = new Decimal(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_履歴番号);
            JutakuKaishuRiyushoTesuryoShukei result = sut.get住宅改修理由書作成手数料請求集計(主キー1, 主キー2, 主キー3);

            assertThat(result.get証記載保険者番号().value(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get住宅改修理由書作成手数料請求集計一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<JutakuKaishuRiyushoTesuryoShukei> result = sut.get住宅改修理由書作成手数料請求集計一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity> entityList = Arrays.asList(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<JutakuKaishuRiyushoTesuryoShukei> result = sut.get住宅改修理由書作成手数料請求集計一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get証記載保険者番号().value(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    public static class save住宅改修理由書作成手数料請求集計 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class))).thenReturn(1);

            DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            JutakuKaishuRiyushoTesuryoShukei 住宅改修理由書作成手数料請求集計 = new JutakuKaishuRiyushoTesuryoShukei(entity);

            assertThat(sut.save住宅改修理由書作成手数料請求集計(住宅改修理由書作成手数料請求集計), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class))).thenReturn(0);

            DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            JutakuKaishuRiyushoTesuryoShukei 住宅改修理由書作成手数料請求集計 = new JutakuKaishuRiyushoTesuryoShukei(entity);

            assertThat(sut.save住宅改修理由書作成手数料請求集計(住宅改修理由書作成手数料請求集計), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class))).thenReturn(1);

            DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            entity.initializeMd5();
            JutakuKaishuRiyushoTesuryoShukei 住宅改修理由書作成手数料請求集計 = new JutakuKaishuRiyushoTesuryoShukei(entity);
            住宅改修理由書作成手数料請求集計 = 住宅改修理由書作成手数料請求集計.createBuilderForEdit().set介護支払方法区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save住宅改修理由書作成手数料請求集計(住宅改修理由書作成手数料請求集計), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class))).thenReturn(0);

            DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            entity.initializeMd5();
            JutakuKaishuRiyushoTesuryoShukei 住宅改修理由書作成手数料請求集計 = new JutakuKaishuRiyushoTesuryoShukei(entity);
            住宅改修理由書作成手数料請求集計 = 住宅改修理由書作成手数料請求集計.createBuilderForEdit().set介護支払方法区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save住宅改修理由書作成手数料請求集計(住宅改修理由書作成手数料請求集計), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class))).thenReturn(1);

            DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            entity.initializeMd5();
            JutakuKaishuRiyushoTesuryoShukei 住宅改修理由書作成手数料請求集計 = new JutakuKaishuRiyushoTesuryoShukei(entity);
            住宅改修理由書作成手数料請求集計 = 住宅改修理由書作成手数料請求集計.deleted();

            assertThat(sut.save住宅改修理由書作成手数料請求集計(住宅改修理由書作成手数料請求集計), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class))).thenReturn(0);

            DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            entity.initializeMd5();
            JutakuKaishuRiyushoTesuryoShukei 住宅改修理由書作成手数料請求集計 = new JutakuKaishuRiyushoTesuryoShukei(entity);
            住宅改修理由書作成手数料請求集計 = 住宅改修理由書作成手数料請求集計.deleted();

            assertThat(sut.save住宅改修理由書作成手数料請求集計(住宅改修理由書作成手数料請求集計), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            entity.initializeMd5();
            JutakuKaishuRiyushoTesuryoShukei 住宅改修理由書作成手数料請求集計 = new JutakuKaishuRiyushoTesuryoShukei(entity);

            assertThat(sut.save住宅改修理由書作成手数料請求集計(住宅改修理由書作成手数料請求集計), is(false));
        }
    }
}
