/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;

/**
 * DbT3017KyufujissekiKihonEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT3017KyufujissekiKihonEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3017KyufujissekiKihonEntityMock() {
    }

    /**
     * DbT3017KyufujissekiKihonEntityのSpiedInstanceを返します。
     *
     * @return DbT3017KyufujissekiKihonEntityのSpiedInstance
     */
    public static DbT3017KyufujissekiKihonEntity getSpiedInstance() {
        return spy(createEntity());
    }

    /**
     * DbT3017KyufujissekiKihonEntityを生成して返します。
     *
     * @return DbT3017KyufujissekiKihonEntity
     */
    public static DbT3017KyufujissekiKihonEntity createEntity() {
        DbT3017KyufujissekiKihonEntity entity = new DbT3017KyufujissekiKihonEntity();

        entity.setKokanShikibetsuNo(new KokanShikibetsuNo(new RString("1234")));
        entity.setInputShikibetsuNo(new RString("0001"));
        entity.setRecodeShubetsuCode(new RString("02"));
        entity.setKyufuSakuseiKubunCode(new RString("1"));
        entity.setHokenshaNo(new ShoKisaiHokenshaNo(new RString("00000003")));
        entity.setHiHokenshaNo(new KaigoHihokenshaNo(new RString("0000000004")));
        entity.setServiceTeikyoYM(new FlexibleYearMonth("201401"));
        entity.setKyufuJissekiKubunCode(new RString("2"));
        entity.setJigyoshoNo(new JigyoshaNo(new RString("0000000005")));
        entity.setToshiNo(new ToshiNo(new RString("0000000006")));
        entity.setShinsaYM(new FlexibleYearMonth("201402"));

        entity.setSeibetsuCode(new RString("2"));
        entity.setUmareYMD(new FlexibleDate("20010101"));
        entity.setSeiriNo(new RString("0000000007"));

        entity.setKyufuSakuseiKubunCode(new RString("1"));
        entity.setYoKaigoJotaiKubunCode(new RString("01"));
        entity.setNinteiYukoKaishiYMD(new FlexibleDate("20130701"));
        entity.setNinteiYukoShuryoYMD(new FlexibleDate("20140630"));
        entity.setShinsaYM(new FlexibleYearMonth("201401"));
        entity.setKeikaiKubunCode(new RString("1"));

        entity.setKyuSochiNyushoshaTokureiCode(new RString("1"));
        entity.setRojinHokenShichosonNo(new RString("00000001"));
        entity.setRojinhokenJukyushaNo(new RString("0000001"));
        entity.setKokiHokenshaNo(new RString("39000002"));
        entity.setKokiHiHokenshaNo(new RString("00000002"));
        entity.setKokuhoHokenshaNo(new RString("000003"));
        entity.setKokuhoHiHokenshashoNo(new RString("00000004"));
        entity.setKokuhoKojinNo(new RString("0000000005"));

        entity.setKyotakuServiceSakuseiKubunCode(new RString("1"));
        entity.setKyotakuKaigoShienJigyoshoNo(new JigyoshaNo(new RString("0000000001")));

        entity.setKaishiYMD(new FlexibleDate("20140101"));
        entity.setChushiYMD(new FlexibleDate("20140303"));
        entity.setChushiRiyuNyushomaeJyokyoCode(new RString("2"));

        entity.setNyushoYMD(new FlexibleDate("20140101"));
        entity.setTaishoYMD(new FlexibleDate("20140202"));
        entity.setNyushoJitsunissu(10);
        entity.setGaihakuNissu(30);
        entity.setTaishogoJotaiCode(new RString("3"));

        entity.setHokenKyufuritsu(new HokenKyufuRitsu(new Decimal(90)));
        entity.setKohi1Kyufuritsu(new HokenKyufuRitsu(new Decimal(1)));
        entity.setKohi2Kyufuritsu(new HokenKyufuRitsu(new Decimal(2)));
        entity.setKohi3Kyufuritsu(new HokenKyufuRitsu(new Decimal(3)));

        entity.setKohi1FutanshaNo(new RString("00000001"));
        entity.setKohi1JukyushaNo(new RString("1000001"));
        entity.setKohi2FutanshaNo(new RString("00000002"));
        entity.setKohi2JukyushaNo(new RString("1000002"));
        entity.setKohi3FutanshaNo(new RString("00000003"));
        entity.setKohi3JukyushaNo(new RString("1000003"));

        entity.setMaeHokenServiceTanisu(new Decimal(100));
        entity.setMaeHokenSeikyugaku(new Decimal(200));
        entity.setMaeHokenRiyoshaFutangaku(new Decimal(300));
        entity.setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(new Decimal(400));
        entity.setMaeHokenTokuteiShinryohiSeikyugaku(new Decimal(500));
        entity.setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(new Decimal(600));

        return entity;
    }
}
