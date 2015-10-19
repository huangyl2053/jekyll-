/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntityGenerator;
import jp.co.ndensan.reams.db.dbu.persistence.db.basic.DbT7021JigyoHokokuTokeiDataDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link JigyoHokokuTokeiDataManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JigyoHokokuTokeiDataManagerTest {

    private static DbT7021JigyoHokokuTokeiDataDac dac;
    private static JigyoHokokuTokeiDataManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7021JigyoHokokuTokeiDataDac.class);
        sut = new JigyoHokokuTokeiDataManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get事業報告統計データ extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            sut.get事業報告統計データ(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            sut.get事業報告統計データ(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            sut.get事業報告統計データ(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            sut.get事業報告統計データ(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            sut.get事業報告統計データ(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            sut.get事業報告統計データ(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            sut.get事業報告統計データ(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, null, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型8にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            sut.get事業報告統計データ(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, null, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型9にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            sut.get事業報告統計データ(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, null, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型10にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            sut.get事業報告統計データ(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, null, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型11にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            sut.get事業報告統計データ(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(RString.class), any(FlexibleYear.class), any(RString.class), any(RString.class),
                    any(LasdecCode.class), any(Code.class), any(Code.class), any(Code.class), any(Decimal.class), any(Decimal.class))).thenReturn(null);
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            JigyoHokokuTokeiData result = sut.get事業報告統計データ(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7021JigyoHokokuTokeiDataEntity entity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(RString.class), any(FlexibleYear.class), any(RString.class), any(RString.class),
                    any(LasdecCode.class), any(Code.class), any(Code.class), any(Code.class), any(Decimal.class), any(Decimal.class))).thenReturn(entity);
            FlexibleYear 主キー1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
            RString 主キー2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
            FlexibleYear 主キー3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
            RString 主キー4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
            RString 主キー5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
            LasdecCode 主キー6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
            Code 主キー7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
            Code 主キー8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
            Code 主キー9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
            Decimal 主キー10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
            Decimal 主キー11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
            JigyoHokokuTokeiData result = sut.get事業報告統計データ(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);

            assertThat(result.get報告年().toDateString(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get事業報告統計データ一覧 extends DbuTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<JigyoHokokuTokeiData> result = sut.get事業報告統計データ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7021JigyoHokokuTokeiDataEntity> entityList = Arrays.asList(DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<JigyoHokokuTokeiData> result = sut.get事業報告統計データ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get報告年().toDateString(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年.toDateString()));
        }
    }

    public static class save事業報告統計データ extends DbuTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7021JigyoHokokuTokeiDataEntity.class))).thenReturn(1);

            DbT7021JigyoHokokuTokeiDataEntity entity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            JigyoHokokuTokeiData 事業報告統計データ = new JigyoHokokuTokeiData(entity);

            assertThat(sut.save事業報告統計データ(事業報告統計データ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7021JigyoHokokuTokeiDataEntity.class))).thenReturn(0);

            DbT7021JigyoHokokuTokeiDataEntity entity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            JigyoHokokuTokeiData 事業報告統計データ = new JigyoHokokuTokeiData(entity);

            assertThat(sut.save事業報告統計データ(事業報告統計データ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7021JigyoHokokuTokeiDataEntity.class))).thenReturn(1);

            DbT7021JigyoHokokuTokeiDataEntity entity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            entity.initializeMd5();
            JigyoHokokuTokeiData 事業報告統計データ = new JigyoHokokuTokeiData(entity);
            事業報告統計データ = 事業報告統計データ.createBuilderForEdit().set統計対象区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save事業報告統計データ(事業報告統計データ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7021JigyoHokokuTokeiDataEntity.class))).thenReturn(0);

            DbT7021JigyoHokokuTokeiDataEntity entity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            entity.initializeMd5();
            JigyoHokokuTokeiData 事業報告統計データ = new JigyoHokokuTokeiData(entity);
            事業報告統計データ = 事業報告統計データ.createBuilderForEdit().set統計対象区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save事業報告統計データ(事業報告統計データ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7021JigyoHokokuTokeiDataEntity.class))).thenReturn(1);

            DbT7021JigyoHokokuTokeiDataEntity entity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            entity.initializeMd5();
            JigyoHokokuTokeiData 事業報告統計データ = new JigyoHokokuTokeiData(entity);
            事業報告統計データ = 事業報告統計データ.deleted();

            assertThat(sut.save事業報告統計データ(事業報告統計データ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7021JigyoHokokuTokeiDataEntity.class))).thenReturn(0);

            DbT7021JigyoHokokuTokeiDataEntity entity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            entity.initializeMd5();
            JigyoHokokuTokeiData 事業報告統計データ = new JigyoHokokuTokeiData(entity);
            事業報告統計データ = 事業報告統計データ.deleted();

            assertThat(sut.save事業報告統計データ(事業報告統計データ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7021JigyoHokokuTokeiDataEntity entity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            entity.initializeMd5();
            JigyoHokokuTokeiData 事業報告統計データ = new JigyoHokokuTokeiData(entity);

            assertThat(sut.save事業報告統計データ(事業報告統計データ), is(false));
        }
    }
}
