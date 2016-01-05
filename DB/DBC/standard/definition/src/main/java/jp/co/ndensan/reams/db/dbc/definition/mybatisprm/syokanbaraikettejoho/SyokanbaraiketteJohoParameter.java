/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraikettejoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払決定一覧検索用MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyokanbaraiketteJohoParameter {

    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;
    private final RString seiriNo;

    /**
     * private
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     */
    private SyokanbaraiketteJohoParameter(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM, RString seiriNo) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.seiriNo = seiriNo;
    }

    public static SyokanbaraiketteJohoParameter createMybatisParam(HihokenshaNo hihokenshaNo, FlexibleYearMonth serviceTeikyoYM, RString seiriNo) {
        return new SyokanbaraiketteJohoParameter(hihokenshaNo, serviceTeikyoYM, seiriNo);
    }
}
