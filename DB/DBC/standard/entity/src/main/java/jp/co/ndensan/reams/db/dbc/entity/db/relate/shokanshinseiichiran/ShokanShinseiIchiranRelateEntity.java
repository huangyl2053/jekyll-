/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinseiichiran;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給申請RelateEntityクラスです。
 *
 */
@lombok.Getter
@edu.umd.cs.findbugs.annotations.SuppressWarnings("CN_IDIOM")
public class ShokanShinseiIchiranRelateEntity implements Cloneable, Serializable {

    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString seiriNo;
    private FlexibleDate shinseiYMD;
    private FlexibleYearMonth sofuYM;
    private RString yoshikiNo;
    private FlexibleDate ketteiYMD;
    private FlexibleYearMonth サービス提供年月From;
    private FlexibleYearMonth サービス提供年月To;

}
