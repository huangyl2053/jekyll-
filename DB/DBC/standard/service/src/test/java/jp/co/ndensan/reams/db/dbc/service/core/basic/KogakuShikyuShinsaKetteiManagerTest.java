/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsaKettei;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3112KogakuShikyuShinsaKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3112KogakuShikyuShinsaKetteiDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link KogakuShikyuShinsaKetteiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuShikyuShinsaKetteiManagerTest {

    private static DbT3112KogakuShikyuShinsaKetteiDac dac;
    private static KogakuShikyuShinsaKetteiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3112KogakuShikyuShinsaKetteiDac.class);
        sut = new KogakuShikyuShinsaKetteiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get事業高額介護サービス費支給審査決定 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HokenshaNo 主キー2 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー3 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー4 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー5 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号;
            sut.get事業高額介護サービス費支給審査決定(null, 主キー2, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月;
            HihokenshaNo 主キー3 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー4 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー5 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号;
            sut.get事業高額介護サービス費支給審査決定(主キー1, null, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月;
            HokenshaNo 主キー2 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleYearMonth 主キー4 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー5 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号;
            sut.get事業高額介護サービス費支給審査決定(主キー1, 主キー2, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月;
            HokenshaNo 主キー2 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー3 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー5 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号;
            sut.get事業高額介護サービス費支給審査決定(主キー1, 主キー2, 主キー3, null, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月;
            HokenshaNo 主キー2 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー3 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー4 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月;
            sut.get事業高額介護サービス費支給審査決定(主キー1, 主キー2, 主キー3, 主キー4, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(HokenshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class))).thenReturn(null);
            FlexibleYearMonth 主キー1 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月;
            HokenshaNo 主キー2 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー3 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー4 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー5 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号;
            KogakuShikyuShinsaKettei result = sut.get事業高額介護サービス費支給審査決定(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3112KogakuShikyuShinsaKetteiEntity entity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(HokenshaNo.class), any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class))).thenReturn(entity);
            FlexibleYearMonth 主キー1 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月;
            HokenshaNo 主キー2 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー3 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー4 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー5 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号;
            KogakuShikyuShinsaKettei result = sut.get事業高額介護サービス費支給審査決定(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result.get主キー1().toDateString(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get事業高額介護サービス費支給審査決定一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuShikyuShinsaKettei> result = sut.get事業高額介護サービス費支給審査決定一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3112KogakuShikyuShinsaKetteiEntity> entityList = Arrays.asList(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuShikyuShinsaKettei> result = sut.get事業高額介護サービス費支給審査決定一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().toDateString(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月.toDateString()));
        }
    }

    public static class save事業高額介護サービス費支給審査決定 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3112KogakuShikyuShinsaKetteiEntity.class))).thenReturn(1);

            DbT3112KogakuShikyuShinsaKetteiEntity entity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            KogakuShikyuShinsaKettei 事業高額介護サービス費支給審査決定 = new KogakuShikyuShinsaKettei(entity);

            assertThat(sut.save事業高額介護サービス費支給審査決定(事業高額介護サービス費支給審査決定), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3112KogakuShikyuShinsaKetteiEntity.class))).thenReturn(0);

            DbT3112KogakuShikyuShinsaKetteiEntity entity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            KogakuShikyuShinsaKettei 事業高額介護サービス費支給審査決定 = new KogakuShikyuShinsaKettei(entity);

            assertThat(sut.save事業高額介護サービス費支給審査決定(事業高額介護サービス費支給審査決定), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3112KogakuShikyuShinsaKetteiEntity.class))).thenReturn(1);

            DbT3112KogakuShikyuShinsaKetteiEntity entity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            entity.initializeMd5();
            KogakuShikyuShinsaKettei 事業高額介護サービス費支給審査決定 = new KogakuShikyuShinsaKettei(entity);
            事業高額介護サービス費支給審査決定 = 事業高額介護サービス費支給審査決定.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save事業高額介護サービス費支給審査決定(事業高額介護サービス費支給審査決定), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3112KogakuShikyuShinsaKetteiEntity.class))).thenReturn(0);

            DbT3112KogakuShikyuShinsaKetteiEntity entity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            entity.initializeMd5();
            KogakuShikyuShinsaKettei 事業高額介護サービス費支給審査決定 = new KogakuShikyuShinsaKettei(entity);
            事業高額介護サービス費支給審査決定 = 事業高額介護サービス費支給審査決定.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save事業高額介護サービス費支給審査決定(事業高額介護サービス費支給審査決定), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3112KogakuShikyuShinsaKetteiEntity.class))).thenReturn(1);

            DbT3112KogakuShikyuShinsaKetteiEntity entity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            entity.initializeMd5();
            KogakuShikyuShinsaKettei 事業高額介護サービス費支給審査決定 = new KogakuShikyuShinsaKettei(entity);
            事業高額介護サービス費支給審査決定 = 事業高額介護サービス費支給審査決定.deleted();

            assertThat(sut.save事業高額介護サービス費支給審査決定(事業高額介護サービス費支給審査決定), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3112KogakuShikyuShinsaKetteiEntity.class))).thenReturn(0);

            DbT3112KogakuShikyuShinsaKetteiEntity entity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            entity.initializeMd5();
            KogakuShikyuShinsaKettei 事業高額介護サービス費支給審査決定 = new KogakuShikyuShinsaKettei(entity);
            事業高額介護サービス費支給審査決定 = 事業高額介護サービス費支給審査決定.deleted();

            assertThat(sut.save事業高額介護サービス費支給審査決定(事業高額介護サービス費支給審査決定), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3112KogakuShikyuShinsaKetteiEntity entity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            entity.initializeMd5();
            KogakuShikyuShinsaKettei 事業高額介護サービス費支給審査決定 = new KogakuShikyuShinsaKettei(entity);

            assertThat(sut.save事業高額介護サービス費支給審査決定(事業高額介護サービス費支給審査決定), is(false));
        }
    }
}
