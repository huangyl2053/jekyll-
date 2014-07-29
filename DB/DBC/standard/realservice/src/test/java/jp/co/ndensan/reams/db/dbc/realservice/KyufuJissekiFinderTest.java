/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.InputShikibetsuNo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJisseki;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiDetailKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.ServiceTeikyoYMListOfServiceShurui;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3017KyufujissekiKihonEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3018KyufujissekiMeisaiEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3025KyufujissekiKyotakuServiceEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3033KyufujissekiShukeiEntityMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.KyufujissekiShuruiDetailEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiKyotakuServiceDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiShafukuKeigenDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IKyufuJissekiShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.KyufuJissekiServiceDac;
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
        return new KyufuJissekiFinder(
                createKyufuJissekiServiceDac(flg),
                createKyufuJissekiKihonDac(flg),
                createKyufuJissekiMeisaiDac(flg),
                createKyufuJissekiShukeiDac(flg),
                createKyufuJissekiShafukuKeigenDac(flg),
                createKyufuJissekiKyotakuServiceDac(flg));
    }

    private static KyufuJissekiServiceDac createKyufuJissekiServiceDac(int flg) {
        KyufuJissekiServiceDac dac = mock(KyufuJissekiServiceDac.class);
        List<DbV3016KyufujissekiShuruiDetailEntity> entity = createDbV3016KyufujissekiShuruiDetailEntity(flg);
        when(dac.select(
                any(KaigoHihokenshaNo.class),
                any(ServiceTeikyoYM.class),
                any(ServiceTeikyoYM.class))).thenReturn(entity);
        return dac;
    }

    private static IKyufuJissekiKihonDac createKyufuJissekiKihonDac(int flg) {
        IKyufuJissekiKihonDac dac = mock(IKyufuJissekiKihonDac.class);
        DbT3017KyufujissekiKihonEntity entity = createDbT3017KyufujissekiKihonEntity(flg);
        when(dac.select(
                any(KokanShikibetsuNo.class),
                any(InputShikibetsuNoCode.class),
                any(ShoKisaiHokenshaNo.class),
                any(KaigoHihokenshaNo.class),
                any(FlexibleYearMonth.class),
                any(JigyoshaNo.class),
                any(ToshiNo.class))).thenReturn(entity);
        return dac;
    }

    private static IKyufuJissekiMeisaiDac createKyufuJissekiMeisaiDac(int flg) {
        IKyufuJissekiMeisaiDac dac = mock(IKyufuJissekiMeisaiDac.class);
        List<DbT3018KyufujissekiMeisaiEntity> entityList = createDbT3018KyufujissekiMeisaiEntityList(flg);
        when(dac.select(
                any(KokanShikibetsuNo.class),
                any(InputShikibetsuNoCode.class),
                any(ShoKisaiHokenshaNo.class),
                any(KaigoHihokenshaNo.class),
                any(FlexibleYearMonth.class),
                any(JigyoshaNo.class),
                any(ToshiNo.class))).thenReturn(entityList);
        return dac;
    }

    private static IKyufuJissekiShukeiDac createKyufuJissekiShukeiDac(int flg) {
        IKyufuJissekiShukeiDac dac = mock(IKyufuJissekiShukeiDac.class);
        List<DbT3033KyufujissekiShukeiEntity> entityList = createDbT3033KyufujissekiShukeiEntityList(flg);
        when(dac.select(
                any(KokanShikibetsuNo.class),
                any(InputShikibetsuNoCode.class),
                any(ShoKisaiHokenshaNo.class),
                any(KaigoHihokenshaNo.class),
                any(FlexibleYearMonth.class),
                any(JigyoshaNo.class),
                any(ToshiNo.class))).thenReturn(entityList);
        return dac;
    }

    private static IKyufuJissekiShafukuKeigenDac createKyufuJissekiShafukuKeigenDac(int flg) {
        IKyufuJissekiShafukuKeigenDac dac = mock(IKyufuJissekiShafukuKeigenDac.class);
        List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> entityList = createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityList(flg);
        when(dac.select(
                any(KokanShikibetsuNo.class),
                any(InputShikibetsuNoCode.class),
                any(ShoKisaiHokenshaNo.class),
                any(KaigoHihokenshaNo.class),
                any(FlexibleYearMonth.class),
                any(JigyoshaNo.class),
                any(ToshiNo.class))).thenReturn(entityList);
        return dac;
    }

    private static IKyufuJissekiKyotakuServiceDac createKyufuJissekiKyotakuServiceDac(int flg) {
        IKyufuJissekiKyotakuServiceDac dac = mock(IKyufuJissekiKyotakuServiceDac.class);
        List<DbT3025KyufujissekiKyotakuServiceEntity> entityList = createDbT3025KyufujissekiKyotakuServiceEntityList(flg);
        when(dac.select(
                any(KokanShikibetsuNo.class),
                any(InputShikibetsuNoCode.class),
                any(ShoKisaiHokenshaNo.class),
                any(KaigoHihokenshaNo.class),
                any(FlexibleYearMonth.class),
                any(JigyoshaNo.class),
                any(ToshiNo.class))).thenReturn(entityList);
        return dac;
    }

    private static List<DbV3016KyufujissekiShuruiDetailEntity> createDbV3016KyufujissekiShuruiDetailEntity(int flg) {
        return flg == AS_給付実績あり ? KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntities(flg) : null;
    }

    private static DbT3017KyufujissekiKihonEntity createDbT3017KyufujissekiKihonEntity(int flg) {
        return flg == AS_給付実績あり ? DbT3017KyufujissekiKihonEntityMock.getSpiedInstance() : null;
    }

    private static List<DbT3018KyufujissekiMeisaiEntity> createDbT3018KyufujissekiMeisaiEntityList(int flg) {
        List<DbT3018KyufujissekiMeisaiEntity> list = new ArrayList<>();
        list.add(DbT3018KyufujissekiMeisaiEntityMock.getSpiedInstance());
        return flg == AS_給付実績あり ? list : null;
    }

    private static List<DbT3033KyufujissekiShukeiEntity> createDbT3033KyufujissekiShukeiEntityList(int flg) {
        List<DbT3033KyufujissekiShukeiEntity> list = new ArrayList<>();
        list.add(DbT3033KyufujissekiShukeiEntityMock.getSpiedInstance());
        return flg == AS_給付実績あり ? list : null;
    }

    private static List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityList(int flg) {
        List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> list = new ArrayList<>();
        list.add(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityMock.getSpiedInstance());
        return flg == AS_給付実績あり ? list : null;
    }

    private static List<DbT3025KyufujissekiKyotakuServiceEntity> createDbT3025KyufujissekiKyotakuServiceEntityList(int flg) {
        List<DbT3025KyufujissekiKyotakuServiceEntity> list = new ArrayList<>();
        list.add(DbT3025KyufujissekiKyotakuServiceEntityMock.getSpiedInstance());
        return flg == AS_給付実績あり ? list : null;
    }

    private static KyufuJissekiDetailKeyInfo createKyufuJissekiDetailKeyInfo() {
        return new KyufuJissekiDetailKeyInfo(
                new KokanShikibetsuNo(new RString("0000")),
                new InputShikibetsuNo(new Code("0001"), new RString("名称"), new RString("略称")),
                new ShoKisaiHokenshaNo(new RString("00000003")),
                new KaigoHihokenshaNo(new RString("0000000004")),
                new ServiceTeikyoYM(new FlexibleYearMonth("201401")),
                new JigyoshaNo(new RString("0000000005")),
                new ToshiNo(new RString("0000000006")),
                new ArrayList<ServiceTeikyoYMListOfServiceShurui>());
    }
}
