/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;

/**
 * DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityMock() {
    }

    /**
     * DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのSpiedInstanceを返します。
     *
     * @return
     * DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのSpiedInstance
     */
    public static DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity getSpiedInstance() {
        return spy(createEntity());
    }

    /**
     * DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityを生成して返します。
     *
     * @return DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity
     */
    public static DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity createEntity() {
        DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity = new DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
        entity.setKokanJohoShikibetsuNo(new KokanShikibetsuNo(new RString("1234")));
        entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setShokisaiHokenshaNo(new HokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new HihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new RString("0000000006"));
        entity.setServiceSyuruiCode(new ServiceShuruiCode(new RString("01")));
        entity.setShinsaYM(new FlexibleYearMonth("201402"));
        entity.setKeigenritsu(new Decimal("10"));
        entity.setRiyoshaFutanTotal(new Decimal(200));
        entity.setKeigengaku(new Decimal(300));
        entity.setKeigengoRiyoshaFutangaku(new Decimal(400));
        entity.setAtoRiyoshaFutanTotal(new Decimal(210));
        entity.setAtoKeigengaku(new Decimal(310));
        entity.setAtoKeigengoRiyoshaFutangaku(new Decimal(410));
        entity.setBiko(new RString("備考"));
        entity.setSaishinsaKaisu(new Decimal(5));
        entity.setKagoKaisu(new Decimal(6));
        return entity;
    }
}
