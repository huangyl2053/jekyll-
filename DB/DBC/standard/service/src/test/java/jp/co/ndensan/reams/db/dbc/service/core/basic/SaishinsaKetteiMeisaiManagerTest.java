/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SaishinsaKetteiMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3064SaishinsaKetteiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3064SaishinsaKetteiMeisaiDac;
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
 * {link SaishinsaKetteiMeisaiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class SaishinsaKetteiMeisaiManagerTest {

    private static DbT3064SaishinsaKetteiMeisaiDac dac;
    private static SaishinsaKetteiMeisaiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3064SaishinsaKetteiMeisaiDac.class);
        sut = new SaishinsaKetteiMeisaiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get再審査決定明細 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_保険者区分;
            Decimal 主キー3 = new Decimal(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_履歴番号);
            sut.get再審査決定明細(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取扱年月;
            Decimal 主キー3 = new Decimal(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_履歴番号);
            sut.get再審査決定明細(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取扱年月;
            RString 主キー2 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_保険者区分;
            sut.get再審査決定明細(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(RString.class), any(int.class))).thenReturn(null);
            FlexibleYearMonth 主キー1 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取扱年月;
            RString 主キー2 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_保険者区分;
            Decimal 主キー3 = new Decimal(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_履歴番号);
            SaishinsaKetteiMeisai result = sut.get再審査決定明細(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3064SaishinsaKetteiMeisaiEntity entity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(RString.class), any(int.class))).thenReturn(entity);
            FlexibleYearMonth 主キー1 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取扱年月;
            RString 主キー2 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_保険者区分;
            Decimal 主キー3 = new Decimal(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_履歴番号);
            SaishinsaKetteiMeisai result = sut.get再審査決定明細(主キー1, 主キー2, 主キー3);

            assertThat(result.get取扱年月().toDateString(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取扱年月.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get再審査決定明細一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<SaishinsaKetteiMeisai> result = sut.get再審査決定明細一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3064SaishinsaKetteiMeisaiEntity> entityList = Arrays.asList(DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<SaishinsaKetteiMeisai> result = sut.get再審査決定明細一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get取扱年月().toDateString(), is(DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取扱年月.toDateString()));
        }
    }

    public static class save再審査決定明細 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3064SaishinsaKetteiMeisaiEntity.class))).thenReturn(1);

            DbT3064SaishinsaKetteiMeisaiEntity entity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            SaishinsaKetteiMeisai 再審査決定明細 = new SaishinsaKetteiMeisai(entity);

            assertThat(sut.save再審査決定明細(再審査決定明細), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3064SaishinsaKetteiMeisaiEntity.class))).thenReturn(0);

            DbT3064SaishinsaKetteiMeisaiEntity entity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            SaishinsaKetteiMeisai 再審査決定明細 = new SaishinsaKetteiMeisai(entity);

            assertThat(sut.save再審査決定明細(再審査決定明細), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3064SaishinsaKetteiMeisaiEntity.class))).thenReturn(1);

            DbT3064SaishinsaKetteiMeisaiEntity entity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            entity.initializeMd5();
            SaishinsaKetteiMeisai 再審査決定明細 = new SaishinsaKetteiMeisai(entity);
            再審査決定明細 = 再審査決定明細.createBuilderForEdit().set保険者区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save再審査決定明細(再審査決定明細), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3064SaishinsaKetteiMeisaiEntity.class))).thenReturn(0);

            DbT3064SaishinsaKetteiMeisaiEntity entity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            entity.initializeMd5();
            SaishinsaKetteiMeisai 再審査決定明細 = new SaishinsaKetteiMeisai(entity);
            再審査決定明細 = 再審査決定明細.createBuilderForEdit().set保険者区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save再審査決定明細(再審査決定明細), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3064SaishinsaKetteiMeisaiEntity.class))).thenReturn(1);

            DbT3064SaishinsaKetteiMeisaiEntity entity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            entity.initializeMd5();
            SaishinsaKetteiMeisai 再審査決定明細 = new SaishinsaKetteiMeisai(entity);
            再審査決定明細 = 再審査決定明細.deleted();

            assertThat(sut.save再審査決定明細(再審査決定明細), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3064SaishinsaKetteiMeisaiEntity.class))).thenReturn(0);

            DbT3064SaishinsaKetteiMeisaiEntity entity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            entity.initializeMd5();
            SaishinsaKetteiMeisai 再審査決定明細 = new SaishinsaKetteiMeisai(entity);
            再審査決定明細 = 再審査決定明細.deleted();

            assertThat(sut.save再審査決定明細(再審査決定明細), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3064SaishinsaKetteiMeisaiEntity entity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            entity.initializeMd5();
            SaishinsaKetteiMeisai 再審査決定明細 = new SaishinsaKetteiMeisai(entity);

            assertThat(sut.save再審査決定明細(再審査決定明細), is(false));
        }
    }
}
