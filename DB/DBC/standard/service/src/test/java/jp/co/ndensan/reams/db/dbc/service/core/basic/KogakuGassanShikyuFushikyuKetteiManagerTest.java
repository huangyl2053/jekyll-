/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link KogakuGassanShikyuFushikyuKetteiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuGassanShikyuFushikyuKetteiManagerTest {

    private static DbT3074KogakuGassanShikyuFushikyuKetteiDac dac;
    private static KogakuGassanShikyuFushikyuKetteiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3074KogakuGassanShikyuFushikyuKetteiDac.class);
        sut = new KogakuGassanShikyuFushikyuKetteiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算支給不支給決定 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー2 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号;
            int 主キー5 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給不支給決定(null, 主キー2, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号;
            HokenshaNo 主キー3 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号;
            int 主キー5 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給不支給決定(主キー1, null, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度;
            RString 主キー4 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号;
            int 主キー5 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給不支給決定(主キー1, 主キー2, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号;
            int 主キー5 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算支給不支給決定(主キー1, 主キー2, 主キー3, null, 主キー5);
        }

//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
//            HihokenshaNo 主キー1 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYear 主キー2 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度;
//            HokenshaNo 主キー3 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号;
//            RString 主キー4 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号;
//            sut.get高額合算支給不支給決定(主キー1, 主キー2, 主キー3, 主キー4, null);
//        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYear.class), any(HokenshaNo.class), any(RString.class), any(int.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号;
            int 主キー5 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanShikyuFushikyuKettei result = sut.get高額合算支給不支給決定(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYear.class), any(HokenshaNo.class), any(RString.class), any(int.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号;
            int 主キー5 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanShikyuFushikyuKettei result = sut.get高額合算支給不支給決定(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result.get被保険者番号().value(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算支給不支給決定一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuGassanShikyuFushikyuKettei> result = sut.get高額合算支給不支給決定一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> entityList = Arrays.asList(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuGassanShikyuFushikyuKettei> result = sut.get高額合算支給不支給決定一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save高額合算支給不支給決定 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class))).thenReturn(1);

            DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = new KogakuGassanShikyuFushikyuKettei(entity);

            assertThat(sut.save高額合算支給不支給決定(高額合算支給不支給決定), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class))).thenReturn(0);

            DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = new KogakuGassanShikyuFushikyuKettei(entity);

            assertThat(sut.save高額合算支給不支給決定(高額合算支給不支給決定), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class))).thenReturn(1);

            DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            entity.initializeMd5();
            KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = new KogakuGassanShikyuFushikyuKettei(entity);
            高額合算支給不支給決定 = 高額合算支給不支給決定.createBuilderForEdit().set保険制度コード(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算支給不支給決定(高額合算支給不支給決定), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class))).thenReturn(0);

            DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            entity.initializeMd5();
            KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = new KogakuGassanShikyuFushikyuKettei(entity);
            高額合算支給不支給決定 = 高額合算支給不支給決定.createBuilderForEdit().set保険制度コード(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算支給不支給決定(高額合算支給不支給決定), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class))).thenReturn(1);

            DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            entity.initializeMd5();
            KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = new KogakuGassanShikyuFushikyuKettei(entity);
            高額合算支給不支給決定 = 高額合算支給不支給決定.deleted();

            assertThat(sut.save高額合算支給不支給決定(高額合算支給不支給決定), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class))).thenReturn(0);

            DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            entity.initializeMd5();
            KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = new KogakuGassanShikyuFushikyuKettei(entity);
            高額合算支給不支給決定 = 高額合算支給不支給決定.deleted();

            assertThat(sut.save高額合算支給不支給決定(高額合算支給不支給決定), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            entity.initializeMd5();
            KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定 = new KogakuGassanShikyuFushikyuKettei(entity);

            assertThat(sut.save高額合算支給不支給決定(高額合算支給不支給決定), is(false));
        }
    }
}
