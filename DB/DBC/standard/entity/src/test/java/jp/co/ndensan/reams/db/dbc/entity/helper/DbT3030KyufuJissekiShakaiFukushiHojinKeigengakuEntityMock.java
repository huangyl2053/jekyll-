/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
     * @return DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのSpiedInstance
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
        entity.setInputShikibetsuNo(new RString("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setShokisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new KaigoHihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new RString("0000000006"));
        entity.setServiceSyuruiCode(new ServiceShuruiCode(new RString("01")));
        entity.setShinsaYM(new FlexibleYearMonth("201402"));
        return entity;
    }
}
