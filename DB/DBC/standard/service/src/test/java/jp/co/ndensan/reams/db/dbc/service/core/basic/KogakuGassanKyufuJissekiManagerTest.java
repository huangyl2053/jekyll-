/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3075KogakuGassanKyufuJissekiDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {link KogakuGassanKyufuJissekiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanKyufuJissekiManagerTest {

    private static DbT3075KogakuGassanKyufuJissekiDac dac;
    private static KogakuGassanKyufuJissekiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3075KogakuGassanKyufuJissekiDac.class);
        sut = new KogakuGassanKyufuJissekiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算給付実績 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー2 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー4 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー5 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算給付実績(null, 主キー2, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号;
            RString 主キー3 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー4 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー5 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算給付実績(主キー1, null, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号;
            HihokenshaNo 主キー2 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー4 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー5 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算給付実績(主キー1, 主キー2, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号;
            HihokenshaNo 主キー2 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号;
            Decimal 主キー5 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算給付実績(主キー1, 主キー2, 主キー3, null, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号;
            HihokenshaNo 主キー2 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー4 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号;
            sut.get高額合算給付実績(主キー1, 主キー2, 主キー3, 主キー4, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(KokanShikibetsuNo.class), any(HihokenshaNo.class), any(RString.class), any(RString.class), any(Decimal.class))).thenReturn(null);

            KokanShikibetsuNo 主キー1 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号;
            HihokenshaNo 主キー2 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー4 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー5 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanKyufuJisseki result = sut.get高額合算給付実績(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3075KogakuGassanKyufuJissekiEntity entity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            when(dac.selectByKey(any(KokanShikibetsuNo.class), any(HihokenshaNo.class), any(RString.class), any(RString.class), any(Decimal.class))).thenReturn(entity);

            KokanShikibetsuNo 主キー1 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号;
            HihokenshaNo 主キー2 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー3 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号;
            RString 主キー4 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー5 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanKyufuJisseki result = sut.get高額合算給付実績(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result.get交換情報識別番号().value(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算給付実績一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuGassanKyufuJisseki> result = sut.get高額合算給付実績一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3075KogakuGassanKyufuJissekiEntity> entityList = Arrays.asList(DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuGassanKyufuJisseki> result = sut.get高額合算給付実績一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get交換情報識別番号().value(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号.value()));
        }
    }

    public static class save高額合算給付実績 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3075KogakuGassanKyufuJissekiEntity.class))).thenReturn(1);

            DbT3075KogakuGassanKyufuJissekiEntity entity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            KogakuGassanKyufuJisseki 高額合算給付実績 = new KogakuGassanKyufuJisseki(entity);

            assertThat(sut.save高額合算給付実績(高額合算給付実績), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3075KogakuGassanKyufuJissekiEntity.class))).thenReturn(0);

            DbT3075KogakuGassanKyufuJissekiEntity entity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            KogakuGassanKyufuJisseki 高額合算給付実績 = new KogakuGassanKyufuJisseki(entity);

            assertThat(sut.save高額合算給付実績(高額合算給付実績), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3075KogakuGassanKyufuJissekiEntity.class))).thenReturn(1);

            DbT3075KogakuGassanKyufuJissekiEntity entity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            entity.initializeMd5();
            KogakuGassanKyufuJisseki 高額合算給付実績 = new KogakuGassanKyufuJisseki(entity);
            高額合算給付実績 = 高額合算給付実績.createBuilderForEdit().setデータ区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算給付実績(高額合算給付実績), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3075KogakuGassanKyufuJissekiEntity.class))).thenReturn(0);

            DbT3075KogakuGassanKyufuJissekiEntity entity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            entity.initializeMd5();
            KogakuGassanKyufuJisseki 高額合算給付実績 = new KogakuGassanKyufuJisseki(entity);
            高額合算給付実績 = 高額合算給付実績.createBuilderForEdit().setデータ区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算給付実績(高額合算給付実績), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3075KogakuGassanKyufuJissekiEntity.class))).thenReturn(1);

            DbT3075KogakuGassanKyufuJissekiEntity entity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            entity.initializeMd5();
            KogakuGassanKyufuJisseki 高額合算給付実績 = new KogakuGassanKyufuJisseki(entity);
            高額合算給付実績 = 高額合算給付実績.deleted();

            assertThat(sut.save高額合算給付実績(高額合算給付実績), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3075KogakuGassanKyufuJissekiEntity.class))).thenReturn(0);

            DbT3075KogakuGassanKyufuJissekiEntity entity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            entity.initializeMd5();
            KogakuGassanKyufuJisseki 高額合算給付実績 = new KogakuGassanKyufuJisseki(entity);
            高額合算給付実績 = 高額合算給付実績.deleted();

            assertThat(sut.save高額合算給付実績(高額合算給付実績), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3075KogakuGassanKyufuJissekiEntity entity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            entity.initializeMd5();
            KogakuGassanKyufuJisseki 高額合算給付実績 = new KogakuGassanKyufuJisseki(entity);

            assertThat(sut.save高額合算給付実績(高額合算給付実績), is(false));
        }
    }
}
