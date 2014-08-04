/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
     * @return DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのSpiedInstance
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
        entity.setInputShikibetsuNo(new RString("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setShokisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new KaigoHihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new RString("0000000006"));
        return entity;
    }
}
