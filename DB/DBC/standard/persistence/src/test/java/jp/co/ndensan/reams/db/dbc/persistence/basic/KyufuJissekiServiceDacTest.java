/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * KyufuJissekiServiceのデータアクセスクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class KyufuJissekiServiceDacTest extends DbcTestDacBase {

    private static KyufuJissekiServiceDac sut;
    private static final KaigoHihokenshaNo found被保番号 = new KaigoHihokenshaNo(new RString("0000000034"));
    private static final KaigoHihokenshaNo notFound被保番号 = new KaigoHihokenshaNo(new RString("0000000099"));
    private static final ServiceTeikyoYM foundサービス提供年月_データ4件 = new ServiceTeikyoYM(new FlexibleYearMonth("200511"));
    private static final ServiceTeikyoYM foundサービス提供年月_データ1件 = new ServiceTeikyoYM(new FlexibleYearMonth("200704"));
    private static final Range<ServiceTeikyoYM> notFoundサービス提供期間
            = new Range<>(new ServiceTeikyoYM(new FlexibleYearMonth("201301")), new ServiceTeikyoYM(new FlexibleYearMonth("201306")));
    private static final Range<ServiceTeikyoYM> foundサービス提供期間_データ5件
            = new Range<>(new ServiceTeikyoYM(new FlexibleYearMonth("200501")), new ServiceTeikyoYM(new FlexibleYearMonth("200712")));
    private static final Range<ServiceTeikyoYM> foundサービス提供期間_データ1件
            = new Range<>(new ServiceTeikyoYM(new FlexibleYearMonth("200703")), new ServiceTeikyoYM(new FlexibleYearMonth("200705")));

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KyufuJissekiServiceDac.class);
    }

    public static class select_被保番号_サービス提供年月 extends DbcTestDacBase {

        @Test
        public void 該当の給付実績基本が存在しない時_selectは_空のコレクションを返す() {
            List<DbV3016KyufujissekiShuruiDetailEntity> result = sut.select(notFound被保番号, foundサービス提供年月_データ1件);
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void データが1件あるサービス提供年月を指定した時_selectは_1件のデータが入ったentityListを返す() {
            List<DbV3016KyufujissekiShuruiDetailEntity> result = sut.select(found被保番号, foundサービス提供年月_データ1件);
            assertThat(result.size(), is(1));
        }

        @Test
        public void データが4件あるサービス提供年月を指定した時_selectは_4件のデータが入ったentityListを返す() {
            List<DbV3016KyufujissekiShuruiDetailEntity> result = sut.select(found被保番号, foundサービス提供年月_データ4件);
            assertThat(result.size(), is(4));
        }
    }

    public static class select_被保番号_サービス提供期間 extends DbcTestDacBase {

        @Test
        public void 該当の給付実績基本が存在しない時_selectは_空のコレクションを返す() {
            List<DbV3016KyufujissekiShuruiDetailEntity> result = sut.select(
                    found被保番号, notFoundサービス提供期間.getFrom(), notFoundサービス提供期間.getTo());
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void データが1件あるサービス提供期間を指定した時_selectは_1件のデータが入ったentityListを返す() {
            List<DbV3016KyufujissekiShuruiDetailEntity> result = sut.select(
                    found被保番号, foundサービス提供期間_データ1件.getFrom(), foundサービス提供期間_データ1件.getTo());
            assertThat(result.size(), is(1));
        }

        @Test
        public void データが5件あるサービス提供期間を指定した時_selectは_5件のデータが入ったentityListを返す() {
            List<DbV3016KyufujissekiShuruiDetailEntity> result = sut.select(
                    found被保番号, foundサービス提供期間_データ5件.getFrom(), foundサービス提供期間_データ5件.getTo());
            assertThat(result.size(), is(5));
        }
    }
}
