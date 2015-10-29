/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiDac;
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
 * {link ShokanJutakuKaishuJizenShinseiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanJutakuKaishuJizenShinseiManagerTest {

    private static DbT3035ShokanJutakuKaishuJizenShinseiDac dac;
    private static ShokanJutakuKaishuJizenShinseiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3035ShokanJutakuKaishuJizenShinseiDac.class);
        sut = new ShokanJutakuKaishuJizenShinseiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払支給住宅改修事前申請 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー4 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払支給住宅改修事前申請(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー4 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払支給住宅改修事前申請(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス提供年月;
            Decimal 主キー4 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_履歴番号;
            sut.get償還払支給住宅改修事前申請(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_整理番号;
            sut.get償還払支給住宅改修事前申請(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー4 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_履歴番号;
            ShokanJutakuKaishuJizenShinsei result = sut.get償還払支給住宅改修事前申請(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(RString.class), any(Decimal.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー3 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー4 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_履歴番号;
            ShokanJutakuKaishuJizenShinsei result = sut.get償還払支給住宅改修事前申請(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get被保険者番号().value(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払支給住宅改修事前申請一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanJutakuKaishuJizenShinsei> result = sut.get償還払支給住宅改修事前申請一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3035ShokanJutakuKaishuJizenShinseiEntity> entityList = Arrays.asList(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanJutakuKaishuJizenShinsei> result = sut.get償還払支給住宅改修事前申請一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save償還払支給住宅改修事前申請 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3035ShokanJutakuKaishuJizenShinseiEntity.class))).thenReturn(1);

            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請 = new ShokanJutakuKaishuJizenShinsei(entity);

            assertThat(sut.save償還払支給住宅改修事前申請(償還払支給住宅改修事前申請), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3035ShokanJutakuKaishuJizenShinseiEntity.class))).thenReturn(0);

            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請 = new ShokanJutakuKaishuJizenShinsei(entity);

            assertThat(sut.save償還払支給住宅改修事前申請(償還払支給住宅改修事前申請), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3035ShokanJutakuKaishuJizenShinseiEntity.class))).thenReturn(1);

            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            entity.initializeMd5();
            ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請 = new ShokanJutakuKaishuJizenShinsei(entity);
            償還払支給住宅改修事前申請 = 償還払支給住宅改修事前申請.createBuilderForEdit().set事業者名称カナ(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払支給住宅改修事前申請(償還払支給住宅改修事前申請), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3035ShokanJutakuKaishuJizenShinseiEntity.class))).thenReturn(0);

            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            entity.initializeMd5();
            ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請 = new ShokanJutakuKaishuJizenShinsei(entity);
            償還払支給住宅改修事前申請 = 償還払支給住宅改修事前申請.createBuilderForEdit().set事業者名称カナ(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払支給住宅改修事前申請(償還払支給住宅改修事前申請), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3035ShokanJutakuKaishuJizenShinseiEntity.class))).thenReturn(1);

            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            entity.initializeMd5();
            ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請 = new ShokanJutakuKaishuJizenShinsei(entity);
            償還払支給住宅改修事前申請 = 償還払支給住宅改修事前申請.deleted();

            assertThat(sut.save償還払支給住宅改修事前申請(償還払支給住宅改修事前申請), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3035ShokanJutakuKaishuJizenShinseiEntity.class))).thenReturn(0);

            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            entity.initializeMd5();
            ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請 = new ShokanJutakuKaishuJizenShinsei(entity);
            償還払支給住宅改修事前申請 = 償還払支給住宅改修事前申請.deleted();

            assertThat(sut.save償還払支給住宅改修事前申請(償還払支給住宅改修事前申請), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            entity.initializeMd5();
            ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請 = new ShokanJutakuKaishuJizenShinsei(entity);

            assertThat(sut.save償還払支給住宅改修事前申請(償還払支給住宅改修事前申請), is(false));
        }
    }
}
