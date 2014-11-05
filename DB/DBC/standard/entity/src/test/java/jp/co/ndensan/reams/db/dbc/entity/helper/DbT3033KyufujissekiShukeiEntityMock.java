/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;

/**
 * DbT3033KyufujissekiShukeiEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT3033KyufujissekiShukeiEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3033KyufujissekiShukeiEntityMock() {
    }

    /**
     * DbT3033KyufujissekiShukeiEntityのSpiedInstanceを返します。
     *
     * @return DbT3033KyufujissekiShukeiEntityのSpiedInstance
     */
    public static DbT3033KyufujissekiShukeiEntity getSpiedInstance() {
        return spy(createEntity());
    }

    /**
     * DbT3033KyufujissekiShukeiEntityを生成して返します。
     *
     * @return DbT3033KyufujissekiShukeiEntity
     */
    public static DbT3033KyufujissekiShukeiEntity createEntity() {
        DbT3033KyufujissekiShukeiEntity entity = new DbT3033KyufujissekiShukeiEntity();
        entity.setKokanJohoShikibetsuNo(new KokanShikibetsuNo(new RString("1234")));
        entity.setInputShikibetsuNo(new RString("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setShokisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new KaigoHihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new ToshiNo(new RString("0000000006")));
        entity.setServiceSyuruiCode(new ServiceShuruiCode(new RString("01")));
        entity.setShinsaYM(new FlexibleYearMonth("201402"));
        entity.setServiceSyuruiCode(new ServiceShuruiCode(new RString("11")));
        entity.setServiceJitsunissu(new Integer(1));
        entity.setPlanTanisu(new Decimal(200));
        entity.setGendogakuKanriTaishoTanisu(new Decimal(300));
        entity.setGendogakuKanritaishogaiTanisu(new Decimal(400));
        entity.setTankiNyushoPlanNissu(new Integer(5));
        entity.setTankiNyushoJitsunissu(new Integer(6));
        entity.setHokenTanisuTotal(new Decimal(100));
        entity.setHokenTanisuTani(new Decimal(101));
        entity.setHokenSeikyugaku(new Decimal(102));
        entity.setHokenRiyoshaFutangaku(new Decimal(103));
        entity.setHokenDekidakaTanisuTotal(new Decimal(104));
        entity.setHokenDekidakaSeikyugaku(new Decimal(105));
        entity.setHokenDekidakaIryohiRiyoshaFutangaku(new Decimal(106));
        entity.setKohi1TanisuTotal(new Decimal(200));
        entity.setKohi1Seikyugaku(new Decimal(202));
        entity.setKohi1HonninFutangaku(new Decimal(203));
        entity.setKohi1DekidakaTanisuTotal(new Decimal(204));
        entity.setKohi1DekidakaSeikyugaku(new Decimal(205));
        entity.setKohi1DekidakaIryohiRiyoshaFutangaku(new Decimal(206));
        entity.setKohi2TanisuTotal(new Decimal(300));
        entity.setKohi2Seikyugaku(new Decimal(302));
        entity.setKohi2HonninFutangaku(new Decimal(303));
        entity.setKohi2DekidakaTanisuTotal(new Decimal(304));
        entity.setKohi2DekidakaSeikyugaku(new Decimal(305));
        entity.setKohi2DekidakaIryohiRiyoshaFutangaku(new Decimal(306));
        entity.setKohi3TanisuTotal(new Decimal(400));
        entity.setKohi3Seikyugaku(new Decimal(402));
        entity.setKohi3HonninFutangaku(new Decimal(403));
        entity.setKohi3DekidakaTanisuTotal(new Decimal(404));
        entity.setKohi3DekidakaSeikyugaku(new Decimal(405));
        entity.setKohi3DekidakaIryohiRiyoshaFutangaku(new Decimal(406));
        entity.setAtoTankiNyushoJitsunissu(new Integer(7));
        entity.setAtoHokenTanisuTotal(new Decimal(110));
        entity.setAtoHokenSeikyugaku(new Decimal(112));
        entity.setAtoHokenDekidakaTanisuTotal(new Decimal(114));
        entity.setAtoHokenDekidakaSeikyugaku(new Decimal(115));
        entity.setAtoKohi1TanisuTotal(new Decimal(210));
        entity.setAtoKohi1Seikyugaku(new Decimal(212));
        entity.setAtoKohi1DekidakaTanisuTotal(new Decimal(214));
        entity.setAtoKohi1DekidakaSeikyugaku(new Decimal(215));
        entity.setAtoKohi2TanisuTotal(new Decimal(310));
        entity.setAtoKohi2Seikyugaku(new Decimal(312));
        entity.setAtoKohi2DekidakaTanisuTotal(new Decimal(314));
        entity.setAtoKohi2DekidakaSeikyugaku(new Decimal(315));
        entity.setAtoKohi3TanisuTotal(new Decimal(410));
        entity.setAtoKohi3Seikyugaku(new Decimal(412));
        entity.setAtoKohi3DekidakaTanisuTotal(new Decimal(414));
        entity.setAtoKohi3DekidakaSeikyugaku(new Decimal(415));
        entity.setSaishinsaKaisu(new Integer(12));
        entity.setKagoKaisu(new Integer(13));
        return entity;
    }
}
