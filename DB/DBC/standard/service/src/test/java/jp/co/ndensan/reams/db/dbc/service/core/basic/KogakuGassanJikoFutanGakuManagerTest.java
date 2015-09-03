/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3070KogakuGassanJikoFutanGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3070KogakuGassanJikoFutanGakuDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
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
 * {link KogakuGassanJikoFutanGakuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanJikoFutanGakuManagerTest {

    private static DbT3070KogakuGassanJikoFutanGakuDac dac;
    private static KogakuGassanJikoFutanGakuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3070KogakuGassanJikoFutanGakuDac.class);
        sut = new KogakuGassanJikoFutanGakuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算自己負担額 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー2 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算自己負担額(null, 主キー2, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号;
            HokenshaNo 主キー3 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算自己負担額(主キー1, null, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度;
            RString 主キー4 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算自己負担額(主キー1, 主キー2, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号;
            Decimal 主キー5 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算自己負担額(主キー1, 主キー2, 主キー3, null, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号;
            sut.get高額合算自己負担額(主キー1, 主キー2, 主キー3, 主キー4, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYear.class), any(HokenshaNo.class), any(RString.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanJikoFutanGaku result = sut.get高額合算自己負担額(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3070KogakuGassanJikoFutanGakuEntity entity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYear.class), any(HokenshaNo.class), any(RString.class), any(Decimal.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanJikoFutanGaku result = sut.get高額合算自己負担額(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result.get被保険者番号().value(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算自己負担額一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuGassanJikoFutanGaku> result = sut.get高額合算自己負担額一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3070KogakuGassanJikoFutanGakuEntity> entityList = Arrays.asList(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuGassanJikoFutanGaku> result = sut.get高額合算自己負担額一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save高額合算自己負担額 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3070KogakuGassanJikoFutanGakuEntity.class))).thenReturn(1);

            DbT3070KogakuGassanJikoFutanGakuEntity entity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            KogakuGassanJikoFutanGaku 高額合算自己負担額 = new KogakuGassanJikoFutanGaku(entity);

            assertThat(sut.save高額合算自己負担額(高額合算自己負担額), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3070KogakuGassanJikoFutanGakuEntity.class))).thenReturn(0);

            DbT3070KogakuGassanJikoFutanGakuEntity entity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            KogakuGassanJikoFutanGaku 高額合算自己負担額 = new KogakuGassanJikoFutanGaku(entity);

            assertThat(sut.save高額合算自己負担額(高額合算自己負担額), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3070KogakuGassanJikoFutanGakuEntity.class))).thenReturn(1);

            DbT3070KogakuGassanJikoFutanGakuEntity entity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            entity.initializeMd5();
            KogakuGassanJikoFutanGaku 高額合算自己負担額 = new KogakuGassanJikoFutanGaku(entity);
            高額合算自己負担額 = 高額合算自己負担額.createBuilderForEdit().set保険者名(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算自己負担額(高額合算自己負担額), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3070KogakuGassanJikoFutanGakuEntity.class))).thenReturn(0);

            DbT3070KogakuGassanJikoFutanGakuEntity entity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            entity.initializeMd5();
            KogakuGassanJikoFutanGaku 高額合算自己負担額 = new KogakuGassanJikoFutanGaku(entity);
            高額合算自己負担額 = 高額合算自己負担額.createBuilderForEdit().set保険者名(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算自己負担額(高額合算自己負担額), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3070KogakuGassanJikoFutanGakuEntity.class))).thenReturn(1);

            DbT3070KogakuGassanJikoFutanGakuEntity entity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            entity.initializeMd5();
            KogakuGassanJikoFutanGaku 高額合算自己負担額 = new KogakuGassanJikoFutanGaku(entity);
            高額合算自己負担額 = 高額合算自己負担額.deleted();

            assertThat(sut.save高額合算自己負担額(高額合算自己負担額), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3070KogakuGassanJikoFutanGakuEntity.class))).thenReturn(0);

            DbT3070KogakuGassanJikoFutanGakuEntity entity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            entity.initializeMd5();
            KogakuGassanJikoFutanGaku 高額合算自己負担額 = new KogakuGassanJikoFutanGaku(entity);
            高額合算自己負担額 = 高額合算自己負担額.deleted();

            assertThat(sut.save高額合算自己負担額(高額合算自己負担額), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3070KogakuGassanJikoFutanGakuEntity entity = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity();
            entity.initializeMd5();
            KogakuGassanJikoFutanGaku 高額合算自己負担額 = new KogakuGassanJikoFutanGaku(entity);

            assertThat(sut.save高額合算自己負担額(高額合算自己負担額), is(false));
        }
    }
}
