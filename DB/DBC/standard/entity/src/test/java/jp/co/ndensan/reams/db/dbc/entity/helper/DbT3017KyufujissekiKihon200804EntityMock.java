/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihon200804Entity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;

/**
 * DbT3017KyufujissekiKihon200804Entityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT3017KyufujissekiKihon200804EntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3017KyufujissekiKihon200804EntityMock() {
    }

    /**
     * DbT3017KyufujissekiKihon200804Entityを生成して返します。
     *
     * @return DbT3017KyufujissekiKihon200804Entity
     */
    public static DbT3017KyufujissekiKihon200804Entity getSpiedInstance() {
        DbT3017KyufujissekiKihon200804Entity entity = new DbT3017KyufujissekiKihon200804Entity();

        entity.setKyufuSakuseiKubunCode(new RString("1"));
        entity.setYoKaigoJotaiKubunCode(new RString("要介護１"));
        entity.setNinteiYukoKaishiYMD(new FlexibleDate("20130701"));
        entity.setNinteiYukoShuryoYMD(new FlexibleDate("20140630"));
        entity.setShinsaYM(new FlexibleYearMonth("201401"));
        entity.setKeikaiKubunCode(new RString("1"));

        entity.setKyuSochiNyushoshaTokureiCode(new RString("特例１"));
        entity.setRojinHokenShichosonNo(new RString("00000001"));
        entity.setRojinhokenJukyushaNo(new RString("00000001"));
        entity.setKokiHokenshaNo(new RString("39000002"));
        entity.setKokiHiHokenshaNo(new RString("00000002"));
        entity.setKokuhoHokenshaNo(new RString("000003"));
        entity.setKokuhoHiHokenshashoNo(new RString("00000004"));
        entity.setKokuhoKojinNo(new RString("0000000005"));

        entity.setKyotakuServicePlanSakuseiKubunCode(new RString("自己作成"));
        entity.setKyotakuKaigoShienJigyoshoNo(new JigyoshaNo(new RString("0000000001")));

        entity.setKaishiYMD(new FlexibleDate("20140101"));
        entity.setChushiYMD(new FlexibleDate("20140303"));
        entity.setChushiRiyuNyushomaeJyokyoCode(new RString("居宅"));

        entity.setNyushoYMD(new FlexibleDate("20140101"));
        entity.setTaishoYMD(new FlexibleDate("20140202"));
        entity.setNyushoJitsunissu(10);
        entity.setGaihakuNissu(30);
        entity.setTaishogoJotaiCode(new RString("医療機関入院"));

        entity.setHokenKyufuritsu(new HokenKyufuRitsu(new Decimal(90)));
        entity.setKohi1Kyufuritsu(new HokenKyufuRitsu(new Decimal(1)));
        entity.setKohi2Kyufuritsu(new HokenKyufuRitsu(new Decimal(2)));
        entity.setKohi3Kyufuritsu(new HokenKyufuRitsu(new Decimal(3)));

        entity.setKohi1FutanshaNo(new RString("0000000001"));
        entity.setKohi1JukyushaNo(new RString("1000000001"));
        entity.setKohi2FutanshaNo(new RString("0000000002"));
        entity.setKohi2JukyushaNo(new RString("1000000002"));
        entity.setKohi3FutanshaNo(new RString("0000000003"));
        entity.setKohi3JukyushaNo(new RString("1000000003"));

        return spy(entity);
    }
}
