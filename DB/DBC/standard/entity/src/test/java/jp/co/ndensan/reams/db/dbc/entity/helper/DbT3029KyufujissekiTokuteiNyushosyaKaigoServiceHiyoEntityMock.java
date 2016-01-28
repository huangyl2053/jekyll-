/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;

/**
 * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityMock() {
    }

    /**
     * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのSpiedInstanceを返します。
     *
     * @return
     * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのSpiedInstance
     */
    public static DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity getSpiedInstance() {
        return spy(createEntity());
    }

    /**
     * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityを生成して返します。
     *
     * @return DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity
     */
    public static DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity createEntity() {
        DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity = new DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
        entity.setKokanJohoShikibetsuNo(new KokanShikibetsuNo(new RString("1234")));
        entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setShokisaiHokenshaNo(new HokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new HihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new RString("0000000006"));
        entity.setServiceSyuruiCode(new ServiceShuruiCode(new RString("12")));
        entity.setServiceKomokuCode(new ServiceKomokuCode(new RString("3456")));
        entity.setFutanGendogaku(new Decimal(100));
        entity.setHiyoTanka(new Decimal(110));
        entity.setNissu(new Decimal(10));
        entity.setHiyogaku(new Decimal(120));
        entity.setHokenbunSeikyugaku(new Decimal(130));
        entity.setRiyoshaFutangaku(new Decimal(140));
        entity.setKohi1Nissu(new Decimal(11));
        entity.setKohi1Futangaku(new Decimal(150));
        entity.setKohi1Seikyugaku(new Decimal(160));
        entity.setKohi1HonninFutanGetsugaku(new Decimal(170));
        entity.setKohi2Nissu(new Decimal(12));
        entity.setKohi2Futangaku(new Decimal(180));
        entity.setKohi2Seikyugaku(new Decimal(190));
        entity.setKohi2HonninFutanGetsugaku(new Decimal(200));
        entity.setKohi3Nissu(new Decimal(13));
        entity.setKohi3Futangaku(new Decimal(210));
        entity.setKohi3Seikyugaku(new Decimal(220));
        entity.setKohi3HonninFutanGetsugaku(new Decimal(230));
        entity.setSaishinsaKaisu(new Decimal(14));
        entity.setKagoKaisu(new Decimal(15));
        entity.setShinsaYM(new FlexibleYearMonth("201401"));
        return entity;
    }
}
