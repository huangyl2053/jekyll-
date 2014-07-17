/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbc.business.InputShikibetsuNo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJisseki;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiDetailKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.ServiceTeikyoYMListOfServiceShurui;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3017KyufujissekiKihonEntityMock;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiKihonDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.InputShikibetsuNoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 給付実績情報を取得するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuJissekiFinderTest extends DbcTestBase {

    private static final int AS_給付実績あり = 1;
    private static final int AS_給付実績なし = 0;

    public KyufuJissekiFinderTest() {
    }

    public static class get給付実績 extends DbcTestBase {

        @Test
        public void 給付実績ありの時_get給付実績は_該当の給付実績を返す() {
            assertThat(createKyufuJissekiFinder(AS_給付実績あり).get給付実績(createKyufuJissekiDetailKeyInfo()), instanceOf(KyufuJisseki.class));
        }

        @Test
        public void 給付実績なしの時_get給付実績は_NULLを返す() {
            assertThat(createKyufuJissekiFinder(AS_給付実績なし).get給付実績(createKyufuJissekiDetailKeyInfo()).get基本(), nullValue());
        }
    }

    private static KyufuJissekiFinder createKyufuJissekiFinder(int flg) {
        return new KyufuJissekiFinder(createKyufuJissekiKihonDac(flg));
    }

    private static IKyufuJissekiKihonDac createKyufuJissekiKihonDac(int flg) {
        IKyufuJissekiKihonDac dac = mock(IKyufuJissekiKihonDac.class);
        DbT3017KyufujissekiKihonEntity entity = createDbT3017KyufujissekiKihonEntity(flg);
        when(dac.select(
                any(KokanShikibetsuNo.class),
                any(InputShikibetsuNoCode.class),
                any(RString.class),
                any(RString.class),
                any(ShoKisaiHokenshaNo.class),
                any(KaigoHihokenshaNo.class),
                any(FlexibleYearMonth.class),
                any(RString.class),
                any(JigyoshaNo.class),
                any(RString.class))).thenReturn(entity);
        return dac;
    }

    private static DbT3017KyufujissekiKihonEntity createDbT3017KyufujissekiKihonEntity(int flg) {
        return flg == AS_給付実績あり ? DbT3017KyufujissekiKihonEntityMock.getSpiedInstance() : null;
    }

    private static KyufuJissekiDetailKeyInfo createKyufuJissekiDetailKeyInfo() {
        return new KyufuJissekiDetailKeyInfo(
                new KokanShikibetsuNo(new RString("0000000000")),
                new InputShikibetsuNo(new Code("1111111111"), new RString("名称"), new RString("略称")),
                new RString("2222222222"),
                new ShoKisaiHokenshaNo(new RString("3333333333")),
                new KaigoHihokenshaNo(new RString("4444444444")),
                new ServiceTeikyoYM(new FlexibleYearMonth("201401")),
                new JigyoshaNo(new RString("5555555555")),
                KyufuSakuseiKubun.新規,
                KyufuJissekiKubun.償還,
                new ToshiNo(new RString("6666666666")),
                new ArrayList<ServiceTeikyoYMListOfServiceShurui>());
    }
}
