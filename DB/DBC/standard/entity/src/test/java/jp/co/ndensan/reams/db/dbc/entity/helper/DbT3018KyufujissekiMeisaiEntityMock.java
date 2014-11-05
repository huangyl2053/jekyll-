/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;

/**
 * DbT3018KyufujissekiMeisaiEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT3018KyufujissekiMeisaiEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3018KyufujissekiMeisaiEntityMock() {
    }

    /**
     * DbT3018KyufujissekiMeisaiEntityのSpiedInstanceを返します。
     *
     * @return DbT3018KyufujissekiMeisaiEntityのSpiedInstance
     */
    public static DbT3018KyufujissekiMeisaiEntity getSpiedInstance() {
        return spy(createEntity());
    }

    /**
     * DbT3018KyufujissekiMeisaiEntityを生成して返します。
     *
     * @return DbT3017KyufujissekiKihonEntity
     */
    public static DbT3018KyufujissekiMeisaiEntity createEntity() {
        DbT3018KyufujissekiMeisaiEntity entity = new DbT3018KyufujissekiMeisaiEntity();
        entity.setKokanJohoShikibetsuNo(new KokanShikibetsuNo(new RString("1234")));
        entity.setInputShikibetsuNo(new RString("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setShokisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new KaigoHihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new ToshiNo(new RString("0000000006")));
        entity.setServiceShuruiCode(new ServiceShuruiCode(new RString("01")));
        entity.setServiceKomokuCode(new ServiceKomokuCode(new RString("0002")));
        entity.setShinsaYM(new FlexibleYearMonth("201402"));
        entity.setServiceShuruiCode(new ServiceShuruiCode(new RString("11")));
        entity.setTekiyo(new RString("概要"));
        entity.setTanisu(new Decimal(1000));
        entity.setNissuKaisu(new Integer(4));
        entity.setKohi1TaishoNissuKaisu(new Integer(1));
        entity.setKohi2TaishoNissuKaisu(new Integer(2));
        entity.setKohi3TaishoNissuKaisu(new Integer(3));
        entity.setServiceTanisu(new Decimal(1500));
        entity.setKohi1TaishoServiceTanisu(new Decimal(1));
        entity.setKohi2TaishoServiceTanisu(new Decimal(2));
        entity.setKohi3TaishoServiceTanisu(new Decimal(3));
        entity.setAtoTanisu(new Decimal(1001));
        entity.setAtoNissuKaisu(new Integer(41));
        entity.setAtoKohi1TaishoNissuKaisu(new Integer(11));
        entity.setAtoKohi2TaishoNissukaisu(new Integer(21));
        entity.setAtoKohi3TaishoNissuKaisu(new Integer(31));
        entity.setAtoKohi1TaishoServiceTanisu(new Decimal(11));
        entity.setAtoKohi2TaishoServiceTanisu(new Decimal(21));
        entity.setAtoKohi3TaishoServiceTanisu(new Decimal(31));
        entity.setSaishinsaKaisu(new Integer(1500));
        entity.setKagoKaisu(new Integer(2));
        return entity;
    }
}
