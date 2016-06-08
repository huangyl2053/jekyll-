/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TandokuJoseiShurui;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3099TandokuJoseiShuruiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
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
 * {link TandokuJoseiShuruiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class TandokuJoseiShuruiManagerTest {

    private static DbT3099TandokuJoseiShuruiDac dac;
    private static TandokuJoseiShuruiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3099TandokuJoseiShuruiDac.class);
        sut = new TandokuJoseiShuruiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get市町村単独助成種類 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            ServiceShuruiCode 主キー2 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード;
            FlexibleYearMonth 主キー3 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用開始年月;
            Decimal 主キー4 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_履歴番号;
            sut.get市町村単独助成種類(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類;
            FlexibleYearMonth 主キー3 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用開始年月;
            Decimal 主キー4 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_履歴番号;
            sut.get市町村単独助成種類(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類;
            ServiceShuruiCode 主キー2 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード;
            Decimal 主キー4 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_履歴番号;
            sut.get市町村単独助成種類(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類;
            ServiceShuruiCode 主キー2 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード;
            FlexibleYearMonth 主キー3 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用開始年月;
            sut.get市町村単独助成種類(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(ServiceShuruiCode.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(null);
            RString 主キー1 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類;
            ServiceShuruiCode 主キー2 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード;
            FlexibleYearMonth 主キー3 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用開始年月;
            Decimal 主キー4 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_履歴番号;
            TandokuJoseiShurui result = sut.get市町村単独助成種類(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3099TandokuJoseiShuruiEntity entity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            when(dac.selectByKey(any(RString.class), any(ServiceShuruiCode.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(entity);
            RString 主キー1 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類;
            ServiceShuruiCode 主キー2 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード;
            FlexibleYearMonth 主キー3 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_適用開始年月;
            Decimal 主キー4 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_履歴番号;
            TandokuJoseiShurui result = sut.get市町村単独助成種類(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get市町村単独助成種類(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get市町村単独助成種類一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<TandokuJoseiShurui> result = sut.get市町村単独助成種類一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3099TandokuJoseiShuruiEntity> entityList = Arrays.asList(DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<TandokuJoseiShurui> result = sut.get市町村単独助成種類一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村単独助成種類(), is(DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類));
        }
    }

    public static class save市町村単独助成種類 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3099TandokuJoseiShuruiEntity.class))).thenReturn(1);

            DbT3099TandokuJoseiShuruiEntity entity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            TandokuJoseiShurui 市町村単独助成種類 = new TandokuJoseiShurui(entity);

            assertThat(sut.save市町村単独助成種類(市町村単独助成種類), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3099TandokuJoseiShuruiEntity.class))).thenReturn(0);

            DbT3099TandokuJoseiShuruiEntity entity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            TandokuJoseiShurui 市町村単独助成種類 = new TandokuJoseiShurui(entity);

            assertThat(sut.save市町村単独助成種類(市町村単独助成種類), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3099TandokuJoseiShuruiEntity.class))).thenReturn(1);

            DbT3099TandokuJoseiShuruiEntity entity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            entity.initializeMd5();
            TandokuJoseiShurui 市町村単独助成種類 = new TandokuJoseiShurui(entity);
            市町村単独助成種類 = 市町村単独助成種類.createBuilderForEdit().set助成サービス種類名称(new RString("任意項目1を変更")).build();

            assertThat(sut.save市町村単独助成種類(市町村単独助成種類), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3099TandokuJoseiShuruiEntity.class))).thenReturn(0);

            DbT3099TandokuJoseiShuruiEntity entity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            entity.initializeMd5();
            TandokuJoseiShurui 市町村単独助成種類 = new TandokuJoseiShurui(entity);
            市町村単独助成種類 = 市町村単独助成種類.createBuilderForEdit().set助成サービス種類名称(new RString("任意項目1を変更")).build();

            assertThat(sut.save市町村単独助成種類(市町村単独助成種類), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3099TandokuJoseiShuruiEntity.class))).thenReturn(1);

            DbT3099TandokuJoseiShuruiEntity entity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            entity.initializeMd5();
            TandokuJoseiShurui 市町村単独助成種類 = new TandokuJoseiShurui(entity);
            市町村単独助成種類 = 市町村単独助成種類.deleted();

            assertThat(sut.save市町村単独助成種類(市町村単独助成種類), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3099TandokuJoseiShuruiEntity.class))).thenReturn(0);

            DbT3099TandokuJoseiShuruiEntity entity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            entity.initializeMd5();
            TandokuJoseiShurui 市町村単独助成種類 = new TandokuJoseiShurui(entity);
            市町村単独助成種類 = 市町村単独助成種類.deleted();

            assertThat(sut.save市町村単独助成種類(市町村単独助成種類), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3099TandokuJoseiShuruiEntity entity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            entity.initializeMd5();
            TandokuJoseiShurui 市町村単独助成種類 = new TandokuJoseiShurui(entity);

            assertThat(sut.save市町村単独助成種類(市町村単独助成種類), is(false));
        }
    }
}
