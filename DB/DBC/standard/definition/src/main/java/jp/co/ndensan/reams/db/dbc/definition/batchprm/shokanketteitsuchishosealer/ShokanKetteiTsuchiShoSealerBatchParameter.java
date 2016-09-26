/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC030010.DBC030010_ShokanShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払支給（不支給）決定通知書のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-1000-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanKetteiTsuchiShoSealerBatchParameter implements IBatchProcessParameter {

    private FlexibleDate hakkoYMD;
    private FlexibleDate hurikomiYMD;
    private RString chusyutuMode;
    private RString syutujunId;
    private RDate dataFrom;
    private RDate dataTo;
    private FlexibleYearMonth ketteishaUketukeYM;
    private RString shiharaiBasho;
    private RString 受領委任者向け決定通知書フラグ;

    private ShokanKetteiTsuchiShoSealerBatchParameter(FlexibleDate hakkoYMD, FlexibleDate hurikomiYMD, RString chusyutuMode,
            RString syutujunId, RDate dataFrom, RDate dataTo, FlexibleYearMonth ketteishaUketukeYM,
            RString shiharaiBasho, RString 受領委任者向け決定通知書フラグ) {

        this.hakkoYMD = hakkoYMD;
        this.hurikomiYMD = hurikomiYMD;
        this.chusyutuMode = chusyutuMode;
        this.syutujunId = syutujunId;
        this.dataFrom = dataFrom;
        this.dataTo = dataTo;
        this.ketteishaUketukeYM = ketteishaUketukeYM;
        this.shiharaiBasho = shiharaiBasho;
        this.受領委任者向け決定通知書フラグ = 受領委任者向け決定通知書フラグ;
    }

    /**
     * 償還払い支給（不支給）決定通知書一括作成のProcess用パラメータを作成します。
     *
     * @param batchParamter バッチパラメータ
     * @return Process用パラメータ
     */
    public static ShokanKetteiTsuchiShoSealerBatchParameter
            createProcessParam(DBC030010_ShokanShikyuKetteiTsuchishoParameter batchParamter) {

        RDate dataFrom = null;
        RDate dataTo = null;
        if (new RString("1").equals(batchParamter.get抽出モード())) {
            dataFrom = batchParamter.get受付日付From();
            dataTo = batchParamter.get受付日付To();
        } else if (new RString("2").equals(batchParamter.get抽出モード())) {
            dataFrom = batchParamter.get決定日付From();
            dataTo = batchParamter.get決定日付To();
        }

        return new ShokanKetteiTsuchiShoSealerBatchParameter(
                batchParamter.get発行日() == null ? null : new FlexibleDate(batchParamter.get発行日().toDateString()),
                batchParamter.get振込予定日() == null ? null : new FlexibleDate(batchParamter.get振込予定日().toDateString()),
                batchParamter.get抽出モード(), batchParamter.get出力順ID(), dataFrom, dataTo,
                batchParamter.get決定者受付年月() == null ? null : new FlexibleYearMonth(batchParamter.get決定者受付年月().toDateString()),
                batchParamter.get支払場所(), batchParamter.get受領委任者向け決定通知書フラグ());
    }
}
