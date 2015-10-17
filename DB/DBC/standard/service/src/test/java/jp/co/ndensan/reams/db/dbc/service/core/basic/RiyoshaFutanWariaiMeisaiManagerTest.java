/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3114RiyoshaFutanWariaiMeisaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * {link RiyoshaFutanWariaiMeisaiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RiyoshaFutanWariaiMeisaiManagerTest {

    private static DbT3114RiyoshaFutanWariaiMeisaiDac dac;
    private static RiyoshaFutanWariaiMeisaiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3114RiyoshaFutanWariaiMeisaiDac.class);
        sut = new RiyoshaFutanWariaiMeisaiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get利用者負担割合明細 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_履歴番号;
            Decimal 主キー4 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_枝番号;
            sut.get利用者負担割合明細(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            Decimal 主キー3 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_履歴番号;
            Decimal 主キー4 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_枝番号;
            sut.get利用者負担割合明細(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー4 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_枝番号;
            sut.get利用者負担割合明細(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_履歴番号;
            sut.get利用者負担割合明細(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(HihokenshaNo.class), any(Decimal.class), any(Decimal.class))).thenReturn(null);

            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_履歴番号;
            Decimal 主キー4 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_枝番号;
            RiyoshaFutanWariaiMeisai result = sut.get利用者負担割合明細(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3114RiyoshaFutanWariaiMeisaiEntity entity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(HihokenshaNo.class), any(Decimal.class), any(Decimal.class))).thenReturn(entity);
            FlexibleYear 主キー1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
            HihokenshaNo 主キー2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_履歴番号;
            Decimal 主キー4 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_枝番号;
            RiyoshaFutanWariaiMeisai result = sut.get利用者負担割合明細(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get年度().toDateString(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get利用者負担割合明細一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<RiyoshaFutanWariaiMeisai> result = sut.get利用者負担割合明細一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3114RiyoshaFutanWariaiMeisaiEntity> entityList = Arrays.asList(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<RiyoshaFutanWariaiMeisai> result = sut.get利用者負担割合明細一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get年度().toDateString(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度.toDateString()));
        }
    }

    public static class save利用者負担割合明細 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(1);

            DbT3114RiyoshaFutanWariaiMeisaiEntity entity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(entity);

            assertThat(sut.save利用者負担割合明細(利用者負担割合明細), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(0);

            DbT3114RiyoshaFutanWariaiMeisaiEntity entity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(entity);

            assertThat(sut.save利用者負担割合明細(利用者負担割合明細), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(1);

            DbT3114RiyoshaFutanWariaiMeisaiEntity entity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            entity.initializeMd5();
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(entity);
            利用者負担割合明細 = 利用者負担割合明細.createBuilderForEdit().set更正理由(new RString("任意項目1を変更")).build();

            assertThat(sut.save利用者負担割合明細(利用者負担割合明細), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(0);

            DbT3114RiyoshaFutanWariaiMeisaiEntity entity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            entity.initializeMd5();
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(entity);
            利用者負担割合明細 = 利用者負担割合明細.createBuilderForEdit().set更正理由(new RString("任意項目1を変更")).build();

            assertThat(sut.save利用者負担割合明細(利用者負担割合明細), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(1);

            DbT3114RiyoshaFutanWariaiMeisaiEntity entity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            entity.initializeMd5();
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(entity);
            利用者負担割合明細 = 利用者負担割合明細.deleted();

            assertThat(sut.save利用者負担割合明細(利用者負担割合明細), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3114RiyoshaFutanWariaiMeisaiEntity.class))).thenReturn(0);

            DbT3114RiyoshaFutanWariaiMeisaiEntity entity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            entity.initializeMd5();
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(entity);
            利用者負担割合明細 = 利用者負担割合明細.deleted();

            assertThat(sut.save利用者負担割合明細(利用者負担割合明細), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3114RiyoshaFutanWariaiMeisaiEntity entity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            entity.initializeMd5();
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(entity);

            assertThat(sut.save利用者負担割合明細(利用者負担割合明細), is(false));
        }
    }
}
