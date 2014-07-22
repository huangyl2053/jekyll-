/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiServiceCollection;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiServiceCollections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbc.entity.helper.KyufujissekiShuruiDetailEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.basic.KyufuJissekiServiceDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 給付実績照会一覧を表示するためのFinderのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class KyufuJissekiServiceFinderTest extends DbcTestBase {

    private static KyufuJissekiServiceFinder sut;
    private static final int AS_給付実績なし = 0;
    private static final int AS_給付実績あり = 1;

    public static class get給付実績月別 extends DbcTestBase {

        @Test
        public void 給付実績なしの時_get給付実績月別は_空のCollectionが返る() {
            sut = createFinder(AS_給付実績なし);
            KyufuJissekiServiceCollection result = sut.get給付実績月別(
                    new KaigoHihokenshaNo(new RString("1234567890")),
                    new ServiceTeikyoYM(new FlexibleYearMonth("201405")),
                    createサービス提供年月期間());
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 給付実績ありの時_get給付実績月別は_該当の１か月分の給付実績情報が返る() {
            sut = createFinder(AS_給付実績あり);
            KyufuJissekiServiceCollection result = sut.get給付実績月別(
                    new KaigoHihokenshaNo(new RString("1234567890")),
                    new ServiceTeikyoYM(new FlexibleYearMonth("201405")),
                    createサービス提供年月期間());
            assertThat(result, instanceOf(KyufuJissekiServiceCollection.class));
        }

        @Test
        public void 給付実績サービスデータを３件積んだ時_get給付実績月別は_３件のデータが入っている給付実績情報を返す() {
            sut = createFinder(AS_給付実績あり);
            KyufuJissekiServiceCollection result = sut.get給付実績月別(
                    new KaigoHihokenshaNo(new RString("1234567890")),
                    new ServiceTeikyoYM(new FlexibleYearMonth("201405")),
                    createサービス提供年月期間());
            assertThat(result.size(), is(3));
        }
    }

    public static class get給付実績一覧 extends DbcTestBase {

        @Test
        public void 給付実績ありの時_get給付実績一覧は_該当の給付実績情報が返る() {
            sut = createFinder(AS_給付実績あり);
            KyufuJissekiServiceCollections result = sut.get給付実績一覧(
                    new KaigoHihokenshaNo(new RString("1234567890")),
                    createサービス提供年月期間());
            assertThat(result, instanceOf(KyufuJissekiServiceCollections.class));
        }
    }

    private static KyufuJissekiServiceFinder createFinder(int flg) {
        return new KyufuJissekiServiceFinder(createDac(flg));
    }

    private static KyufuJissekiServiceDac createDac(int flg) {
        List<DbV3016KyufujissekiShuruiDetailEntity> entities = createEntities(flg);

        KyufuJissekiServiceDac dac = mock(KyufuJissekiServiceDac.class);
        when(dac.select(
                any(KaigoHihokenshaNo.class),
                any(ServiceTeikyoYM.class))).thenReturn(entities);
        return dac;
    }

    private static List<DbV3016KyufujissekiShuruiDetailEntity> createEntities(int flg) {
        int entitiesSize = 3;
        return flg == 0 ? null
                : KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntities(entitiesSize);
    }

    private static Range<ServiceTeikyoYM> createサービス提供年月期間() {
        return new Range<>(new ServiceTeikyoYM(new FlexibleYearMonth("201405")),
                new ServiceTeikyoYM(new FlexibleYearMonth("201407")));
    }
}
