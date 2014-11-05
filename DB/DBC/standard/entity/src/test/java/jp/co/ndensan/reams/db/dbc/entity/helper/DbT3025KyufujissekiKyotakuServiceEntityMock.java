/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;

/**
 * DbT3025KyufujissekiKyotakuServiceEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT3025KyufujissekiKyotakuServiceEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3025KyufujissekiKyotakuServiceEntityMock() {
    }

    /**
     * DbT3025KyufujissekiKyotakuServiceEntityのSpiedInstanceを返します。
     *
     * @return DbT3025KyufujissekiKyotakuServiceEntityのSpiedInstance
     */
    public static DbT3025KyufujissekiKyotakuServiceEntity getSpiedInstance() {
        return spy(createEntity());
    }

    /**
     * DbT3025KyufujissekiKyotakuServiceEntityを生成して返します。
     *
     * @return DbT3025KyufujissekiKyotakuServiceEntity
     */
    public static DbT3025KyufujissekiKyotakuServiceEntity createEntity() {
        DbT3025KyufujissekiKyotakuServiceEntity entity = new DbT3025KyufujissekiKyotakuServiceEntity();
        entity.setKokanJohoShikibetsuNo(new KokanShikibetsuNo(new RString("1234")));
        entity.setInputShikibetsuNo(new RString("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setShokisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new KaigoHihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new ToshiNo(new RString("0000000006")));
        entity.setShiteiKijunGaitoJigyoshaKubunCode(new RString("1"));
        entity.setTanisuTanka(new Decimal("2340"));
        entity.setKyotakuServiceSakuseiIraiYMD(new FlexibleDate("20120101"));
        entity.setServicePlanhiMeisaiLineNo(new RString("45"));
        entity.setServiceCode(new ServiceCode(new RString("2")));
        entity.setTanisu(new Decimal(3));
        entity.setKaisu(2);
        entity.setServiceTanisu(new Decimal(3));
        entity.setServiceTanisuTotal(new Decimal(6));
        entity.setSeikyuKingaku(new Decimal(34000));
        entity.setTantouKaigoShienSemmoninNo(new RString("87654321"));
        entity.setTekiyo(new RString("てきようじょうほうてきすと"));
        entity.setAtoTanisu(new Decimal(2));
        entity.setAtoKaisu(3);
        entity.setAtoServiceTanisu(new Decimal(5));
        entity.setAtoServiceTanisuTotal(new Decimal(7));
        entity.setAtoSeikyuKingaku(new Decimal(42000));
        entity.setSaishinsaKaisu(10);
        entity.setKagoKaisu(9);
        entity.setShinsaYM(new FlexibleYearMonth("201202"));
        entity.setSeiriNo(new RString("0000000001"));
        entity.setTorikomiYM(new FlexibleYearMonth("201203"));
        return entity;
    }
}
