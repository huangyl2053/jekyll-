/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinseiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給申請RelateEntityクラスです。
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShinseiIchiranRelateEntity {

    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString seiriNo;
    private FlexibleDate shinseiYMD;
    private FlexibleYearMonth sofuYM;
    private RString yoshikiNo;
    private FlexibleDate ketteiYMD;
    private FlexibleYearMonth サービス提供年月From;
    private FlexibleYearMonth サービス提供年月To;

    public ShokanShinseiIchiranRelateEntity(
            HihokenshaNo hiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM,
            RString seiriNo,
            FlexibleDate shinseiYMD,
            FlexibleYearMonth sofuYM,
            RString yoshikiNo,
            FlexibleDate ketteiYMD,
            FlexibleYearMonth サービス提供年月From,
            FlexibleYearMonth サービス提供年月To) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.seiriNo = seiriNo;
        this.shinseiYMD = shinseiYMD;
        this.sofuYM = sofuYM;
        this.yoshikiNo = yoshikiNo;
        this.ketteiYMD = ketteiYMD;
        this.サービス提供年月From = サービス提供年月From;
        this.サービス提供年月To = サービス提供年月To;
    }

}
