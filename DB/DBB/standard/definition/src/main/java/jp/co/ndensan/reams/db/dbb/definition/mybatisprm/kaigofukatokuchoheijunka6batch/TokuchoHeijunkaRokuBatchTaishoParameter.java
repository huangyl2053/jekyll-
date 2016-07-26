/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者データTempEntity
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuchoHeijunkaRokuBatchTaishoParameter implements Serializable {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private YMDHMS 調定日時;
    private FlexibleYear 調定前年度;
    private RString 出力順;

    /**
     * コンストラクタです。
     */
    public TokuchoHeijunkaRokuBatchTaishoParameter() {
        this.調定年度 = null;
        this.賦課年度 = null;
        this.調定日時 = null;
        this.調定前年度 = null;
        this.出力順 = null;
    }

    /**
     * コンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 調定前年度 FlexibleYear
     * @param 出力順 RString
     */
    public TokuchoHeijunkaRokuBatchTaishoParameter(FlexibleYear 調定年度, FlexibleYear 賦課年度, YMDHMS 調定日時, FlexibleYear 調定前年度,
            RString 出力順) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.調定前年度 = 調定前年度;
        this.出力順 = 出力順;
    }
}
