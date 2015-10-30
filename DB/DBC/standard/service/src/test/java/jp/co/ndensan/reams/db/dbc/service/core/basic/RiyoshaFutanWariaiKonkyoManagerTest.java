/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiKonkyo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3115RiyoshaFutanWariaiKonkyoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * {link RiyoshaFutanWariaiKonkyoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class RiyoshaFutanWariaiKonkyoManagerTest {

    private static DbT3115RiyoshaFutanWariaiKonkyoDac dac;
    private static RiyoshaFutanWariaiKonkyoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3115RiyoshaFutanWariaiKonkyoDac.class);
        sut = new RiyoshaFutanWariaiKonkyoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get利用者負担割合世帯員 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー2 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_履歴番号;
            Decimal 主キー4 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_枝番号;
            HihokenshaNo 主キー5 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員被保険者番号;
            sut.get利用者負担割合世帯員(null, 主キー2, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度;
            Decimal 主キー3 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_履歴番号;
            Decimal 主キー4 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_枝番号;
            HihokenshaNo 主キー5 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員被保険者番号;
            sut.get利用者負担割合世帯員(主キー1, null, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー4 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_枝番号;
            HihokenshaNo 主キー5 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員被保険者番号;
            sut.get利用者負担割合世帯員(主キー1, 主キー2, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_履歴番号;
            HihokenshaNo 主キー5 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員被保険者番号;
            sut.get利用者負担割合世帯員(主キー1, 主キー2, 主キー3, null, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_履歴番号;
            Decimal 主キー4 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_枝番号;
            sut.get利用者負担割合世帯員(主キー1, 主キー2, 主キー3, 主キー4, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(HihokenshaNo.class), any(Decimal.class), any(Decimal.class), any(HihokenshaNo.class))).thenReturn(null);
            FlexibleYear 主キー1 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_履歴番号;
            Decimal 主キー4 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_枝番号;
            HihokenshaNo 主キー5 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員被保険者番号;
            RiyoshaFutanWariaiKonkyo result = sut.get利用者負担割合世帯員(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3115RiyoshaFutanWariaiKonkyoEntity entity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(HihokenshaNo.class), any(Decimal.class), any(Decimal.class), any(HihokenshaNo.class))).thenReturn(entity);
            FlexibleYear 主キー1 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_履歴番号;
            Decimal 主キー4 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_枝番号;
            HihokenshaNo 主キー5 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員被保険者番号;
            RiyoshaFutanWariaiKonkyo result = sut.get利用者負担割合世帯員(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result.get年度().toDateString(), is(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get利用者負担割合世帯員一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<RiyoshaFutanWariaiKonkyo> result = sut.get利用者負担割合世帯員一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3115RiyoshaFutanWariaiKonkyoEntity> entityList = Arrays.asList(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<RiyoshaFutanWariaiKonkyo> result = sut.get利用者負担割合世帯員一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get年度().toDateString(), is(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度.toDateString()));
        }
    }

    public static class save利用者負担割合世帯員 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3115RiyoshaFutanWariaiKonkyoEntity.class))).thenReturn(1);

            DbT3115RiyoshaFutanWariaiKonkyoEntity entity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            RiyoshaFutanWariaiKonkyo 利用者負担割合世帯員 = new RiyoshaFutanWariaiKonkyo(entity);

            assertThat(sut.save利用者負担割合世帯員(利用者負担割合世帯員), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3115RiyoshaFutanWariaiKonkyoEntity.class))).thenReturn(0);

            DbT3115RiyoshaFutanWariaiKonkyoEntity entity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            RiyoshaFutanWariaiKonkyo 利用者負担割合世帯員 = new RiyoshaFutanWariaiKonkyo(entity);

            assertThat(sut.save利用者負担割合世帯員(利用者負担割合世帯員), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3115RiyoshaFutanWariaiKonkyoEntity.class))).thenReturn(1);

            DbT3115RiyoshaFutanWariaiKonkyoEntity entity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            entity.initializeMd5();
            RiyoshaFutanWariaiKonkyo 利用者負担割合世帯員 = new RiyoshaFutanWariaiKonkyo(entity);
            利用者負担割合世帯員 = 利用者負担割合世帯員.createBuilderForEdit().set枝番号(new Decimal(100)).build();

            assertThat(sut.save利用者負担割合世帯員(利用者負担割合世帯員), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3115RiyoshaFutanWariaiKonkyoEntity.class))).thenReturn(0);

            DbT3115RiyoshaFutanWariaiKonkyoEntity entity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            entity.initializeMd5();
            RiyoshaFutanWariaiKonkyo 利用者負担割合世帯員 = new RiyoshaFutanWariaiKonkyo(entity);
            利用者負担割合世帯員 = 利用者負担割合世帯員.createBuilderForEdit().set枝番号(new Decimal(100)).build();

            assertThat(sut.save利用者負担割合世帯員(利用者負担割合世帯員), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3115RiyoshaFutanWariaiKonkyoEntity.class))).thenReturn(1);

            DbT3115RiyoshaFutanWariaiKonkyoEntity entity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            entity.initializeMd5();
            RiyoshaFutanWariaiKonkyo 利用者負担割合世帯員 = new RiyoshaFutanWariaiKonkyo(entity);
            利用者負担割合世帯員 = 利用者負担割合世帯員.deleted();

            assertThat(sut.save利用者負担割合世帯員(利用者負担割合世帯員), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3115RiyoshaFutanWariaiKonkyoEntity.class))).thenReturn(0);

            DbT3115RiyoshaFutanWariaiKonkyoEntity entity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            entity.initializeMd5();
            RiyoshaFutanWariaiKonkyo 利用者負担割合世帯員 = new RiyoshaFutanWariaiKonkyo(entity);
            利用者負担割合世帯員 = 利用者負担割合世帯員.deleted();

            assertThat(sut.save利用者負担割合世帯員(利用者負担割合世帯員), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3115RiyoshaFutanWariaiKonkyoEntity entity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            entity.initializeMd5();
            RiyoshaFutanWariaiKonkyo 利用者負担割合世帯員 = new RiyoshaFutanWariaiKonkyo(entity);

            assertThat(sut.save利用者負担割合世帯員(利用者負担割合世帯員), is(false));
        }
    }
}
