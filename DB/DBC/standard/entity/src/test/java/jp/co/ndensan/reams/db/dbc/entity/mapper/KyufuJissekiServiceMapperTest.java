/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiService;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiServiceCollection;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbc.entity.helper.KyufujissekiShuruiDetailEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * KyufujissekiShuruiDetailEntityをKyufujissekiServiceCollectionに変換するクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class KyufuJissekiServiceMapperTest extends DbcTestBase {

    public static class toKyufuJissekiService extends DbcTestBase {

        private final DbV3016KyufujissekiShuruiDetailEntity entity
                = KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
        private final Range<ServiceTeikyoYM> サービス提供年月期間 = create年月期間();
        private KyufuJissekiService sut;

        @Before
        public void setUp() {
            sut = KyufuJissekiServiceMapper.toKyufuJissekiService(entity, サービス提供年月期間);
        }

        @Test
        public void 給付実績種類明細entityにnullを設定した時_nullを返す() {
            sut = KyufuJissekiServiceMapper.toKyufuJissekiService(null, サービス提供年月期間);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void get事業者番号の結果が_Entityの事業者番号と同一になる() {
            assertThat(sut.get事業者番号(), is(entity.getJigyoshoNo()));
        }

        @Test
        public void get利用者負担額合計の結果が_Entityの利用者負担額合計と同一になる() {
            assertThat(sut.get利用者負担額合計(), is(entity.getHokenRiyoshaFutangaku()));
        }

        @Test
        public void get単位数合計の結果が_Entityの単位数合計と同一になる() {
            assertThat(sut.get単位数合計(), is(entity.getAtoHokenTanisuTotal()));
        }

        @Test
        public void get保険請求分請求額合計の結果が_Entityの単位数合計と同一になる() {
            assertThat(sut.get保険請求分請求額合計(), is(entity.getAtoHokenSeikyugaku()));
        }

        @Test
        public void get被保番号の結果が_Entityの被保番号と同一になる() {
            assertThat(sut.get給付実績キー情報().get被保番号(), is(entity.getHiHokenshaNo()));
        }

        @Test
        public void get入力識別番号の結果が_Entityの入力識別番号と同一になる() {
            assertThat(sut.get給付実績キー情報().get入力識別番号().getCode().getColumnValue(), is(entity.getInputShikibetsuNo()));
        }

        @Test
        public void getサービス種類コードの結果が_Entityのサービス種類コードと同一になる() {
            assertThat(sut.get給付実績キー情報().getサービス種類コード(), is(entity.getServiceSyuruiCode()));
        }

        @Test
        public void getサービス提供年月の結果が_Entityのサービス提供年月と同一になる() {
            assertThat(sut.get給付実績キー情報().getサービス提供年月(), is(entity.getServiceTeikyoYM()));
        }
    }

    public static class toKyufuJissekiServiceCollection extends DbcTestBase {

        private KyufuJissekiServiceCollection sut;
        private final Range<ServiceTeikyoYM> サービス提供年月期間 = create年月期間();

        @Test
        public void 給付実績種類明細entityにnullを設定した時_空のコレクションが返る() {
            sut = KyufuJissekiServiceMapper.toKyufuJissekiServiceCollection(null, サービス提供年月期間);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void Entityを3件持つListが渡された場合_3件の要素を持つコレクションが返る() {
            final int LIST_SIZE = 3;
            sut = KyufuJissekiServiceMapper.toKyufuJissekiServiceCollection(
                    create給付実績種類明細EntityList(LIST_SIZE), サービス提供年月期間);
            assertThat(sut.size(), is(3));
        }

        private List<DbV3016KyufujissekiShuruiDetailEntity> create給付実績種類明細EntityList(int listSize) {
            List<DbV3016KyufujissekiShuruiDetailEntity> list = new ArrayList<>();
            for (int i = 0; i < listSize; i++) {
                list.add(KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity());
            }
            return list;
        }
    }

    private static Range<ServiceTeikyoYM> create年月期間() {
        return new Range<>(
                new ServiceTeikyoYM(new FlexibleYearMonth("201401")),
                new ServiceTeikyoYM(new FlexibleYearMonth("201408")));
    }
}
