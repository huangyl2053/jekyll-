/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.henreihoryuin;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.henreihoryuin.HenreiHoryuInCsvFileHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.henreihoryuin.HenreiHoryuInCsvFileMeisaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.henreihoryuin.DbWT7411SeikyuuMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.henreihoryuin.DbWT7411SeikyuuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求明細・給付管理票返戻（保留）一覧表取込のbusinessです。
 *
 * @reamsid_L DBC-2830-010 yaodongsheng
 */
public class HenreiHoryuInResult {

    /**
     * 請求一時TBLのセット。
     *
     * @param 履歴番号 履歴番号
     * @param headEntity headEntity
     * @return 請求一時TBL
     */
    public DbWT7411SeikyuuTempEntity 請求一時TBLに登録(int 履歴番号, HenreiHoryuInCsvFileHeadEntity headEntity) {
        DbWT7411SeikyuuTempEntity 請求一時TBL = new DbWT7411SeikyuuTempEntity();
        請求一時TBL.setRirekiNo(履歴番号);
        請求一時TBL.setHokenshaNo(headEntity.get事業所保険者番号());
        請求一時TBL.setHokenshaName(headEntity.get事業所保険者名());
        請求一時TBL.setShinsaYM(set年月(headEntity.get審査年月()));
        請求一時TBL.setKokuhorenName(headEntity.get国保連合会名());
        return 請求一時TBL;
    }

    /**
     * 請求明細一時TBLのセット。
     *
     * @param 連番 連番
     * @param 履歴番号 履歴番号
     * @param meisaEntity meisaEntity
     * @return 請求明細一時Entity
     */
    public DbWT7411SeikyuuMeisaiTempEntity 請求明細一時TBLに登録(int 連番, int 履歴番号, HenreiHoryuInCsvFileMeisaEntity meisaEntity) {
        DbWT7411SeikyuuMeisaiTempEntity 請求明細一時Entity = new DbWT7411SeikyuuMeisaiTempEntity();
        請求明細一時Entity.setRenban(連番);
        請求明細一時Entity.setMeisaiRirekiNo(履歴番号);
        請求明細一時Entity.setJigyoshaNo(meisaEntity.get保険者事業所番号());
        請求明細一時Entity.setJigyoshaName(meisaEntity.get保険者事業所名());
        請求明細一時Entity.setShubetsu(meisaEntity.get種別());
        請求明細一時Entity.setServiceTeikyoYM(meisaEntity.getサービス提供年月());
        請求明細一時Entity.setServiceShuruiCode(meisaEntity.getサービス種類コード());
        請求明細一時Entity.setServiceKoumokuCode(meisaEntity.getサービス項目コード等());
        請求明細一時Entity.setTanisu(meisaEntity.get単位数());
        請求明細一時Entity.setJiyu(meisaEntity.get事由());
        請求明細一時Entity.setNaiyo(meisaEntity.get内容());
        請求明細一時Entity.setBiko(meisaEntity.get備考());
        return 請求明細一時Entity;

    }

    /**
     * 被保険者一時TBLのセット。
     *
     * @param 連番 連番
     * @param meisaEntity meisaEntity
     * @return 被保険者一時entity
     */
    public DbWT0001HihokenshaIchijiEntity 被保険者一時TBLに登録(int 連番, HenreiHoryuInCsvFileMeisaEntity meisaEntity) {
        DbWT0001HihokenshaIchijiEntity 被保険者一時entity = new DbWT0001HihokenshaIchijiEntity();
        被保険者一時entity.setMeisaiRenban(連番);
        被保険者一時entity.setShoHokenshaNo(ShoKisaiHokenshaNo.EMPTY);
        被保険者一時entity.setOrgHihokenshaNo(new HihokenshaNo(set字符(meisaEntity.get被保険者番号())));
        被保険者一時entity.setServiceTeikyoYmd(get末日(meisaEntity.getサービス提供年月()));
        被保険者一時entity.setOrgHihokenshaKanaShimei(meisaEntity.get被保険者カナ氏名());
        被保険者一時entity.setOrgHihokenshaShimei(RString.EMPTY);
        被保険者一時entity.setOldShichosonCode(LasdecCode.EMPTY);
        被保険者一時entity.setHenkanHihokenshaNo(new HihokenshaNo(set字符(meisaEntity.get被保険者番号())));
        被保険者一時entity.setHihokenshaNo(new HihokenshaNo(set字符(meisaEntity.get被保険者番号())));
        被保険者一時entity.setShichosonCode(LasdecCode.EMPTY);
        被保険者一時entity.setKannaiKangaiKubun(RString.EMPTY);
        被保険者一時entity.setYubinNo(RString.EMPTY);
        被保険者一時entity.setChoikiCode(RString.EMPTY);
        被保険者一時entity.setGyoseikuCode(RString.EMPTY);
        被保険者一時entity.setGyoseikuMei(RString.EMPTY);
        被保険者一時entity.setJusho(RString.EMPTY);
        被保険者一時entity.setBanchi(RString.EMPTY);
        被保険者一時entity.setKatagaki(RString.EMPTY);
        被保険者一時entity.setKanaMeisho(RString.EMPTY);
        被保険者一時entity.setMeisho(RString.EMPTY);
        被保険者一時entity.setShimei50onKana(RString.EMPTY);
        被保険者一時entity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        被保険者一時entity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        被保険者一時entity.setShikakuShutokuJiyuCode(RString.EMPTY);
        被保険者一時entity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        被保険者一時entity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        被保険者一時entity.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
        return 被保険者一時entity;
    }

    /**
     * 処理結果リスト一時のセット。
     *
     * @return DbWT0002KokuhorenTorikomiErrorEntity
     */
    public DbWT0002KokuhorenTorikomiErrorEntity 処理結果リスト一時に登録() {
        DbWT0002KokuhorenTorikomiErrorEntity 処理結果リスト一時entity = new DbWT0002KokuhorenTorikomiErrorEntity();
        処理結果リスト一時entity.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード());
        処理結果リスト一時entity.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
        処理結果リスト一時entity.setHihokenshaNo(HihokenshaNo.EMPTY);
        処理結果リスト一時entity.setKey1(RString.EMPTY);
        処理結果リスト一時entity.setKey2(RString.EMPTY);
        処理結果リスト一時entity.setKey3(RString.EMPTY);
        処理結果リスト一時entity.setKey4(RString.EMPTY);
        処理結果リスト一時entity.setKey5(RString.EMPTY);
        処理結果リスト一時entity.setHihokenshaKanaShimei(RString.EMPTY);
        処理結果リスト一時entity.setHihokenshaShimei(RString.EMPTY);
        処理結果リスト一時entity.setBiko(RString.EMPTY);
        return 処理結果リスト一時entity;
    }

    private FlexibleDate get末日(FlexibleYearMonth yearMonth) {
        if (yearMonth == null || yearMonth.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        int lastDay = yearMonth.getLastDay();
        return new FlexibleDate(yearMonth.toDateString().concat(new RString(lastDay)));
    }

    private RString set字符(RString str) {
        if (RString.isNullOrEmpty(str)) {
            return RString.EMPTY;
        } else {
            return str;
        }
    }

    private FlexibleYearMonth set年月(RString yearMonth) {
        if (RString.isNullOrEmpty(yearMonth)) {
            return FlexibleYearMonth.EMPTY;
        }
        return new FlexibleYearMonth(yearMonth);
    }
}
