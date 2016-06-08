/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyugakuKeisanKekkaMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {link KogakuGassanShikyugakuKeisanKekkaMeisaiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuGassanShikyugakuKeisanKekkaMeisaiManagerTest {

    private static DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiDac dac;
    private static KogakuGassanShikyugakuKeisanKekkaMeisaiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiDac.class);
        sut = new KogakuGassanShikyugakuKeisanKekkaMeisaiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算支給額計算結果明細 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー2 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー5 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号;
            Decimal 主キー6 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給額計算結果明細(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            HokenshaNo 主キー3 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー5 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号;
            Decimal 主キー6 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給額計算結果明細(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度;
            RString 主キー4 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー5 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号;
            Decimal 主キー6 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給額計算結果明細(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー5 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号;
            Decimal 主キー6 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給額計算結果明細(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー6 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給額計算結果明細(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー5 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号;
            sut.get高額合算支給額計算結果明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYear.class), any(HokenshaNo.class),
                    any(RString.class), any(RString.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー5 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号;
            Decimal 主キー6 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanShikyugakuKeisanKekkaMeisai result = sut.get高額合算支給額計算結果明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYear.class), any(HokenshaNo.class),
                    any(RString.class), any(RString.class), any(Decimal.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー5 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号;
            Decimal 主キー6 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanShikyugakuKeisanKekkaMeisai result = sut.get高額合算支給額計算結果明細(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result.get被保険者番号().value(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算支給額計算結果明細一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuGassanShikyugakuKeisanKekkaMeisai> result = sut.get高額合算支給額計算結果明細一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> entityList = Arrays.asList(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuGassanShikyugakuKeisanKekkaMeisai> result = sut.get高額合算支給額計算結果明細一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save高額合算支給額計算結果明細 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class))).thenReturn(1);

            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            KogakuGassanShikyugakuKeisanKekkaMeisai 高額合算支給額計算結果明細 = new KogakuGassanShikyugakuKeisanKekkaMeisai(entity);

            assertThat(sut.save高額合算支給額計算結果明細(高額合算支給額計算結果明細), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class))).thenReturn(0);

            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            KogakuGassanShikyugakuKeisanKekkaMeisai 高額合算支給額計算結果明細 = new KogakuGassanShikyugakuKeisanKekkaMeisai(entity);

            assertThat(sut.save高額合算支給額計算結果明細(高額合算支給額計算結果明細), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class))).thenReturn(1);

            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            entity.initializeMd5();
            KogakuGassanShikyugakuKeisanKekkaMeisai 高額合算支給額計算結果明細 = new KogakuGassanShikyugakuKeisanKekkaMeisai(entity);
            高額合算支給額計算結果明細 = 高額合算支給額計算結果明細.createBuilderForEdit().setデータ区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算支給額計算結果明細(高額合算支給額計算結果明細), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class))).thenReturn(0);

            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            entity.initializeMd5();
            KogakuGassanShikyugakuKeisanKekkaMeisai 高額合算支給額計算結果明細 = new KogakuGassanShikyugakuKeisanKekkaMeisai(entity);
            高額合算支給額計算結果明細 = 高額合算支給額計算結果明細.createBuilderForEdit().setデータ区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算支給額計算結果明細(高額合算支給額計算結果明細), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class))).thenReturn(1);

            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            entity.initializeMd5();
            KogakuGassanShikyugakuKeisanKekkaMeisai 高額合算支給額計算結果明細 = new KogakuGassanShikyugakuKeisanKekkaMeisai(entity);
            高額合算支給額計算結果明細 = 高額合算支給額計算結果明細.deleted();

            assertThat(sut.save高額合算支給額計算結果明細(高額合算支給額計算結果明細), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class))).thenReturn(0);

            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            entity.initializeMd5();
            KogakuGassanShikyugakuKeisanKekkaMeisai 高額合算支給額計算結果明細 = new KogakuGassanShikyugakuKeisanKekkaMeisai(entity);
            高額合算支給額計算結果明細 = 高額合算支給額計算結果明細.deleted();

            assertThat(sut.save高額合算支給額計算結果明細(高額合算支給額計算結果明細), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            entity.initializeMd5();
            KogakuGassanShikyugakuKeisanKekkaMeisai 高額合算支給額計算結果明細 = new KogakuGassanShikyugakuKeisanKekkaMeisai(entity);

            assertThat(sut.save高額合算支給額計算結果明細(高額合算支給額計算結果明細), is(false));
        }
    }
}
