/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;

/**
 * DbT3027KyufujissekiJutakuKaishuhiEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT3027KyufujissekiJutakuKaishuhiEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3027KyufujissekiJutakuKaishuhiEntityMock() {
    }

    /**
     * DbT3027KyufujissekiJutakuKaishuhiEntityのSpiedInstanceを返します。
     *
     * @return DbT3027KyufujissekiJutakuKaishuhiEntityのSpiedInstance
     */
    public static DbT3027KyufujissekiJutakuKaishuhiEntity getSpiedInstance() {
        return spy(createEntity());
    }

    /**
     * DbT3027KyufujissekiJutakuKaishuhiEntityを生成して返します。
     *
     * @return DbT3027KyufujissekiJutakuKaishuhiEntity
     */
    public static DbT3027KyufujissekiJutakuKaishuhiEntity createEntity() {
        DbT3027KyufujissekiJutakuKaishuhiEntity entity = new DbT3027KyufujissekiJutakuKaishuhiEntity();
        entity.setKokanJohoShikibetsuNo(new KokanShikibetsuNo(new RString("1234")));
        entity.setInputShikibetsuNo(new RString("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setShokisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new KaigoHihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new ToshiNo(new RString("0000000006")));
        entity.setMeisaiNo(new RString("1"));
        entity.setServiceCode(new RString("000007"));
        entity.setJutakuKaishuchakkoYMD(new FlexibleDate("20140201"));
        entity.setJutakuKaishuJigyoshaName(new RString("住宅改修事業者名"));
        entity.setJuutakukaishuJyutakuAdress(new RString("住宅改修住宅住所"));
        entity.setKaishuKingaku(new Decimal(1234));
        entity.setShinsaYM(new FlexibleYearMonth("201403"));
        entity.setSeiriNo(new RString("0000000008"));
        entity.setTorikomiYM(new FlexibleYearMonth("201404"));
        return entity;
    }
}
