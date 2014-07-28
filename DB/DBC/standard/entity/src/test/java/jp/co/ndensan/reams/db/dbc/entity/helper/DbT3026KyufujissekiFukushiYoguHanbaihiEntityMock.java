/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        entity.setInputShikibetsuNo(new RString("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setShokisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new KaigoHihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new RString("0000000006"));
        entity.setServiceCode(new RString("000007"));
        entity.setFukushiyoguHanbaiYMD(new FlexibleDate("20140201"));
        entity.setFukushiyoguShohinName(new RString("福祉用具商品名"));
        entity.setFukushiyoguSyumokuCode(new RString("08"));
        entity.setFukushiyoguSeizoJigyoshaName(new RString("福祉用具製造事業者名"));
        entity.setFukushiyoguHanbaiJigyoshaName(new RString("福祉用具販売事業者名"));
        entity.setHanbaiKingaku(1234);
        entity.setTekiyo(new RString("適用１２３４５６７８９０"));
        entity.setShinsaYM(new FlexibleYearMonth("201403"));
        entity.setSeiriNo(new RString("0000000009"));
        entity.setTorikomiYM(new FlexibleYearMonth("201404"));
        return entity;
    }
}
