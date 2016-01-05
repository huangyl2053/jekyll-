/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;

/**
 * DbT3026KyufujissekiFukushiYoguHanbaihiEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT3026KyufujissekiFukushiYoguHanbaihiEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3026KyufujissekiFukushiYoguHanbaihiEntityMock() {
    }

    /**
     * DbT3026KyufujissekiFukushiYoguHanbaihiEntityのSpiedInstanceを返します。
     *
     * @return DbT3026KyufujissekiFukushiYoguHanbaihiEntityのSpiedInstance
     */
    public static DbT3026KyufujissekiFukushiYoguHanbaihiEntity getSpiedInstance() {
        return spy(createEntity());
    }

    /**
     * DbT3026KyufujissekiFukushiYoguHanbaihiEntityを生成して返します。
     *
     * @return DbT3026KyufujissekiFukushiYoguHanbaihiEntity
     */
    public static DbT3026KyufujissekiFukushiYoguHanbaihiEntity createEntity() {
        DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity = new DbT3026KyufujissekiFukushiYoguHanbaihiEntity();
        entity.setKokanJohoShikibetsuNo(new KokanShikibetsuNo(new RString("1234")));
        entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setShokisaiHokenshaNo(new HokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new HihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new RString("0000000006"));
        entity.setMeisaiNo(new RString("1"));
        entity.setServiceCode(new ServiceCode("000007"));
        entity.setFukushiyoguHanbaiYMD(new FlexibleDate("20140201"));
        entity.setFukushiyoguShohinName(new RString("福祉用具商品名"));
        entity.setFukushiyoguSyumokuCode(new RString("08"));
        entity.setFukushiyoguSeizoJigyoshaName(new RString("福祉用具製造事業者名"));
        entity.setFukushiyoguHanbaiJigyoshaName(new RString("福祉用具販売事業者名"));
        entity.setHanbaiKingaku(new Decimal(1234));
        entity.setTekiyo(new RString("適用１２３４５６７８９０"));
        entity.setShinsaYM(new FlexibleYearMonth("201403"));
        entity.setSeiriNo(new RString("0000000009"));
        entity.setTorikomiYM(new FlexibleYearMonth("201404"));
        return entity;
    }
}
