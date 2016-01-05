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
 * 償還払決定一覧取得用MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyokanbaraiketteJohoMapperParameter {

    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;
    private final RString seiriNo;
    private final boolean is計画200904;
    private final boolean is計画200604;
    private final boolean is計画200004;
    private final boolean is特定入所者;
    private final boolean is償還払請求食事費用;
    private static final RString サービス計画費 = new RString("サービス計画費");
    private static final RString 特定入所者 = new RString("特定入所者");
    private static final RString 食事費用 = new RString("食事費用");

    protected SyokanbaraiketteJohoMapperParameter(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM, RString seiriNo,
            boolean is計画200904, boolean is計画200604, boolean is計画200004, boolean is特定入所者, boolean is償還払請求食事費用) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.seiriNo = seiriNo;
        this.is計画200904 = is計画200904;
        this.is計画200604 = is計画200604;
        this.is計画200004 = is計画200004;
        this.is特定入所者 = is特定入所者;
        this.is償還払請求食事費用 = is償還払請求食事費用;
    }

    public static SyokanbaraiketteJohoMapperParameter createSyokanbaraiketteJohoMapperParameter(HihokenshaNo hiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM, RString seiriNo, RString tableKbn) {

        boolean is計画200904 = false;
        boolean is計画200604 = false;
        boolean is計画200004 = false;
        boolean is特定入所者 = false;
        boolean is償還払請求食事費用 = false;

        if (サービス計画費.equals(tableKbn)) {
            if (new FlexibleYearMonth("200904").isBefore(serviceTeikyoYM)) {
                is計画200904 = true;
            } else if (serviceTeikyoYM.isBefore(new FlexibleYearMonth("200904"))
                    && new FlexibleYearMonth("200604").isBefore(serviceTeikyoYM)) {
                is計画200604 = true;
            } else if (serviceTeikyoYM.isBefore(new FlexibleYearMonth("200604"))) {
                is計画200004 = true;
            }
        } else if (特定入所者.equals(tableKbn)) {
            is特定入所者 = true;
        } else if (食事費用.equals(tableKbn)) {
            is償還払請求食事費用 = true;
        }
        return new SyokanbaraiketteJohoMapperParameter(hiHokenshaNo,
                serviceTeikyoYM, seiriNo, is計画200904, is計画200604, is計画200004, is特定入所者, is償還払請求食事費用);
    }
}
