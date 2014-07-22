/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
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
        entity.setToshiNo(new RString("0000000006"));
        entity.setServiceSyuruiCode(new ServiceShuruiCode(new RString("01")));
        entity.setShinsaYM(new FlexibleYearMonth("201402"));
        entity.setServiceSyuruiCode(new ServiceShuruiCode(new RString("11")));
        entity.setServiceJitsunissu(1);
        entity.setPlanTanisu(200);
        entity.setGendogakuKanriTaishoTanisu(300);
        entity.setGendogakuKanritaishogaiTanisu(400);
        entity.setTankiNyushoPlanNissu(5);
        entity.setTankiNyushoJitsunissu(6);
        entity.setHokenTanisuTotal(100);
        entity.setHokenTanisuTani(new Decimal(101));
        entity.setHokenSeikyugaku(new RString("102"));
        entity.setHokenRiyoshaFutangaku(103);
        entity.setHokenDekidakaTanisuTotal(104);
        entity.setHokenDekidakaSeikyugaku(new RString("105"));
        entity.setHokenDekidakaIryohiRiyoshaFutangaku(106);
        entity.setKohi1TanisuTotal(200);
        entity.setKohi1Seikyugaku(new RString("202"));
        entity.setKohi1HonninFutangaku(203);
        entity.setKohi1DekidakaTanisuTotal(204);
        entity.setKohi1DekidakaSeikyugaku(new RString("205"));
        entity.setKohi1DekidakaIryohiRiyoshaFutangaku(206);
        entity.setKohi2TanisuTotal(300);
        entity.setKohi2Seikyugaku(new RString("302"));
        entity.setKohi2HonninFutangaku(303);
        entity.setKohi2DekidakaTanisuTotal(304);
        entity.setKohi2DekidakaSeikyugaku(new RString("305"));
        entity.setKohi2DekidakaIryohiRiyoshaFutangaku(306);
        entity.setKohi3TanisuTotal(400);
        entity.setKohi3Seikyugaku(new RString("402"));
        entity.setKohi3HonninFutangaku(403);
        entity.setKohi3DekidakaTanisuTotal(404);
        entity.setKohi3DekidakaSeikyugaku(new RString("405"));
        entity.setKohi3DekidakaIryohiRiyoshaFutangaku(406);
        entity.setAtoTankiNyushoJitsunissu(7);
        entity.setAtoHokenTanisuTotal(110);
        entity.setAtoHokenSeikyugaku(new RString("112"));
        entity.setAtoHokenDekidakaTanisuTotal(114);
        entity.setAtoHokenDekidakaSeikyugaku(new RString("115"));
        entity.setAtoKohi1TanisuTotal(210);
        entity.setAtoKohi1Seikyugaku(new RString("212"));
        entity.setAtoKohi1DekidakaTanisuTotal(214);
        entity.setAtoKohi1DekidakaSeikyugaku(new RString("215"));
        entity.setAtoKohi2TanisuTotal(310);
        entity.setAtoKohi2Seikyugaku(new RString("312"));
        entity.setAtoKohi2DekidakaTanisuTotal(314);
        entity.setAtoKohi2DekidakaSeikyugaku(new RString("315"));
        entity.setAtoKohi3TanisuTotal(410);
        entity.setAtoKohi3Seikyugaku(new RString("412"));
        entity.setAtoKohi3DekidakaTanisuTotal(414);
        entity.setAtoKohi3DekidakaSeikyugaku(new RString("415"));
        entity.setSaishinsaKaisu(12);
        entity.setKagoKaisu(13);
        return entity;
    }
}
