/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuGakuKeisanKekka;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {link KogakuGassanShikyuGakuKeisanKekkaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanShikyuGakuKeisanKekkaManagerTest {

    private static DbT3072KogakuGassanShikyuGakuKeisanKekkaDac dac;
    private static KogakuGassanShikyuGakuKeisanKekkaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3072KogakuGassanShikyuGakuKeisanKekkaDac.class);
        sut = new KogakuGassanShikyuGakuKeisanKekkaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算支給額計算結果 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー2 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給額計算結果(null, 主キー2, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号;
            HokenshaNo 主キー3 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給額計算結果(主キー1, null, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度;
            RString 主キー4 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給額計算結果(主キー1, 主キー2, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            Decimal 主キー5 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給額計算結果(主キー1, 主キー2, 主キー3, null, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号;
            sut.get高額合算支給額計算結果(主キー1, 主キー2, 主キー3, 主キー4, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYear.class), any(HokenshaNo.class), any(RString.class), any(Decimal.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanShikyuGakuKeisanKekka result = sut.get高額合算支給額計算結果(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYear.class), any(HokenshaNo.class), any(RString.class), any(Decimal.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号;
            RString 主キー4 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanShikyuGakuKeisanKekka result = sut.get高額合算支給額計算結果(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result.get被保険者番号().value(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算支給額計算結果一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuGassanShikyuGakuKeisanKekka> result = sut.get高額合算支給額計算結果一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> entityList = Arrays.asList(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuGassanShikyuGakuKeisanKekka> result = sut.get高額合算支給額計算結果一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save高額合算支給額計算結果 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class))).thenReturn(1);

            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            KogakuGassanShikyuGakuKeisanKekka 高額合算支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekka(entity);

            assertThat(sut.save高額合算支給額計算結果(高額合算支給額計算結果), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class))).thenReturn(0);

            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            KogakuGassanShikyuGakuKeisanKekka 高額合算支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekka(entity);

            assertThat(sut.save高額合算支給額計算結果(高額合算支給額計算結果), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class))).thenReturn(1);

            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            entity.initializeMd5();
            KogakuGassanShikyuGakuKeisanKekka 高額合算支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekka(entity);
            高額合算支給額計算結果 = 高額合算支給額計算結果.createBuilderForEdit().set70歳以上の者に係る所得区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算支給額計算結果(高額合算支給額計算結果), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class))).thenReturn(0);

            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            entity.initializeMd5();
            KogakuGassanShikyuGakuKeisanKekka 高額合算支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekka(entity);
            高額合算支給額計算結果 = 高額合算支給額計算結果.createBuilderForEdit().set70歳以上の者に係る所得区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算支給額計算結果(高額合算支給額計算結果), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class))).thenReturn(1);

            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            entity.initializeMd5();
            KogakuGassanShikyuGakuKeisanKekka 高額合算支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekka(entity);
            高額合算支給額計算結果 = 高額合算支給額計算結果.deleted();

            assertThat(sut.save高額合算支給額計算結果(高額合算支給額計算結果), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class))).thenReturn(0);

            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            entity.initializeMd5();
            KogakuGassanShikyuGakuKeisanKekka 高額合算支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekka(entity);
            高額合算支給額計算結果 = 高額合算支給額計算結果.deleted();

            assertThat(sut.save高額合算支給額計算結果(高額合算支給額計算結果), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            entity.initializeMd5();
            KogakuGassanShikyuGakuKeisanKekka 高額合算支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekka(entity);

            assertThat(sut.save高額合算支給額計算結果(高額合算支給額計算結果), is(false));
        }
    }
}
