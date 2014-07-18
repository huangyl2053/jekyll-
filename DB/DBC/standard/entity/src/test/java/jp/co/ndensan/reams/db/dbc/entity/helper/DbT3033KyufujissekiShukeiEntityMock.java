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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        entity.setServiceSyuruiCode(new ServiceShuruiCode(new Code("01")));
        entity.setShinsaYM(new FlexibleYearMonth("201402"));
        return entity;
    }
}
