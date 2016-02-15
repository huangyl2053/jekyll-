/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払支給（不支給）決定通知書のバッチ用パラメータクラスです。
 */
@Getter
@Setter
public class ShokanKetteiTsuchiShoSealerBatchParameter {

    private FlexibleDate hakkoYMD;
    private FlexibleDate hurikomiYMD;
    private RString chusyutuMode;
    private RString syutujunId;
    private RDate dataFrom;
    private RDate dataTo;
    private FlexibleYearMonth ketteishaUketukeYM;
    private RString shiharaiBasho;
}
