/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kagoketteihokenshain;

import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiHokenshaInCSVHeaderEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiHokenshaInCSVMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiHokenshaInCSVShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 一時テーブルエンティティを作成する
 *
 * @reamsid_L DBC-0980-300 xupeng
 */
public class KagoKetteiHokenshaInEntityCreater {

    private static final char TRIM_MOJI = '"';

    /**
     * CSVデータより、明細一時テーブルエンティティを作成する。
     *
     * @param csvHeader CSVデータヘッダ部
     * @param csvMeisei CSVデータ明細部
     * @return KagoKetteiHokenshaInMeisaiEntity
     */
    public KagoKetteiHokenshaInMeisaiEntity createMeiseiRecord(
            KagoKetteiHokenshaInCSVHeaderEntity csvHeader,
            KagoKetteiHokenshaInCSVMeisaiEntity csvMeisei) {

        KagoKetteiHokenshaInMeisaiEntity entity
                = new KagoKetteiHokenshaInMeisaiEntity();

        entity.setKokanShikibetsuNo(trim囲み文字(csvHeader.getKokanShikibetsuNo()));
        entity.setToriatsukaiYM(new FlexibleYearMonth(trim囲み文字(csvHeader.getToriatsukaiYM())));
        entity.setShokisaiHokenshaNo(new HokenshaNo(trim囲み文字(csvHeader.getShokisaiHokenshaNo())));
        entity.setShokisaiHokenshaNa(trim囲み文字(csvHeader.getShokisaiHokenshaNa()));
        entity.setSakuseiYMD(new FlexibleDate(trim囲み文字(csvHeader.getSakuseiYMD())));
        entity.setKokukoRengoukaiNa(trim囲み文字(csvHeader.getKokukoRengoukaiNa()));
        entity.setJigyoshoNo(new JigyoshaNo(trim囲み文字(csvMeisei.getJigyoshoNo())));
        entity.setJigyoshoName(trim囲み文字(csvMeisei.getJigyoshoName()));
        entity.setHiHokenshaNo(new HihokenshaNo(trim囲み文字(csvMeisei.getHiHokenshaNo())));
        entity.setHiHokenshaSimei(trim囲み文字(csvMeisei.getHiHokenshaSimei()));
        entity.setServiceTeikyoYM(new FlexibleYearMonth(trim囲み文字(csvMeisei.getServiceTeikyoYM())));
        entity.setServiceShuruiCode(new ServiceShuruiCode(trim囲み文字(csvMeisei.getServiceShuruiCode())));
        entity.setServiceShuruiName(trim囲み文字(csvMeisei.getServiceShuruiName()));
        entity.setKagomoushitateJiyuCode(new Code(trim囲み文字(csvMeisei.getKagomoushitateJiyuCode())));
        entity.setKagomoushitateJiyu(trim囲み文字(csvMeisei.getKagomoushitateJiyu()));
        entity.setTanisu(new Decimal(trim囲み文字(csvMeisei.getTanisu()).toString()));
        entity.setHokenshaFutangaku(new Decimal(trim囲み文字(csvMeisei.getHokenshaFutangaku()).toString()));

        return entity;
    }

    /**
     * CSVデータより、集計一時テーブルエンティティを作成する。
     *
     * @param csvHeader CSVデータヘッダ部
     * @param csvShukei CSVデータ集計部
     * @return KagoKetteiHokenshaInShukeiEntity
     */
    public KagoKetteiHokenshaInShukeiEntity createShukeiRecord(
            KagoKetteiHokenshaInCSVHeaderEntity csvHeader,
            KagoKetteiHokenshaInCSVShukeiEntity csvShukei) {

        KagoKetteiHokenshaInShukeiEntity entity
                = new KagoKetteiHokenshaInShukeiEntity();
        entity.setKokanShikibetsuNo(trim囲み文字(csvHeader.getKokanShikibetsuNo()));
        entity.setToriatsukaiYM(new FlexibleYearMonth(trim囲み文字(csvHeader.getToriatsukaiYM())));
        entity.setShokisaiHokenshaNo(new HokenshaNo(trim囲み文字(csvHeader.getShokisaiHokenshaNo())));
        entity.setShokisaiHokenshaNa(trim囲み文字(csvHeader.getShokisaiHokenshaNa()));
        entity.setSakuseiYMD(new FlexibleDate(trim囲み文字(csvHeader.getSakuseiYMD())));
        entity.setKokukoRengoukaiNa(trim囲み文字(csvHeader.getKokukoRengoukaiNa()));

        entity.setKaigoKyufuhiKensu(Integer.parseInt(trim囲み文字(csvShukei.getKaigoKyufuhiKensu()).toString()));
        entity.setKaigoKyufuhiTanisu(new Decimal(trim囲み文字(csvShukei.getKaigoKyufuhiTanisu()).toString()));
        entity.setKaigoKyufuhiFutangaku(new Decimal(trim囲み文字(csvShukei.getKaigoKyufuhiFutangaku()).toString()));
        entity.setKogakuServicehiKensu(Integer.parseInt(trim囲み文字(csvShukei.getKogakuServicehiKensu()).toString()));
        entity.setKogakuServicehiTanisu(new Decimal(trim囲み文字(csvShukei.getKogakuServicehiTanisu()).toString()));
        entity.setKogakuServicehiFutangaku(new Decimal(trim囲み文字(csvShukei.getKogakuServicehiFutangaku()).toString()));
        entity.setTokuteiNyushoshaServicehiKensu(Integer.parseInt(trim囲み文字(csvShukei.
                getTokuteiNyushoshaServicehiKensu()).toString()));
        entity.setTokuteiNyushoshaServicehiTanisu(new Decimal(trim囲み文字(csvShukei.getTokuteiNyushoshaServicehiTanisu()).toString()));
        entity.setTokuteiNyushoshaServicehiFutangaku(new Decimal(trim囲み文字(csvShukei.getTokuteiNyushoshaServicehiFutangaku()).toString()));

        return entity;
    }

    private RString trim囲み文字(RString 対象文字列) {

        if (null != 対象文字列 && !RString.EMPTY.equals(対象文字列)) {
            return 対象文字列.trim(TRIM_MOJI);
        }

        return RString.EMPTY;
    }
}
