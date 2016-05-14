/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.shokanketteitsuchishoikkatsu;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.shoukanbaraisuuchishoikkatsusakusei.ShoukanBaraiSuuchiShoIkatsuBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給（不支給）決定通知書一括作成のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter implements IBatchProcessParameter {

    private FlexibleDate hurikomiYoteiYMD;
    private FlexibleDate dataFrom;
    private FlexibleDate dataTo;
    private FlexibleDate hakkoYMD;
    private FlexibleYearMonth ketteishaUketsukeYM;
    private RString chusyuMode;
    private RString insho;

    private ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter(FlexibleDate hurikomiYoteiYMD,
            FlexibleDate dataFrom, FlexibleDate dataTo, FlexibleDate hakkoYMD, FlexibleYearMonth ketteishaUketsukeYM,
            RString chusyuMode, RString insho) {

        this.hurikomiYoteiYMD = hurikomiYoteiYMD;
        this.dataFrom = dataFrom;
        this.dataTo = dataTo;
        this.hakkoYMD = hakkoYMD;
        this.ketteishaUketsukeYM = ketteishaUketsukeYM;
        this.chusyuMode = chusyuMode;
        this.insho = insho;
    }

    /**
     * 償還払い支給（不支給）決定通知書一括作成のProcess用パラメータを作成します。
     *
     * @param batchParamter バッチパラメータ
     * @return Process用パラメータ
     */
    public static ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter
            createProcessParam(ShoukanBaraiSuuchiShoIkatsuBatchParamter batchParamter) {

        FlexibleDate dataFrom = FlexibleDate.EMPTY;
        FlexibleDate dataTo = FlexibleDate.EMPTY;
        if (new RString("1").equals(batchParamter.get抽出モード())) {
            dataFrom = new FlexibleDate(batchParamter.get受付日付From().toDateString());
            dataTo = new FlexibleDate(batchParamter.get受付日付To().toDateString());
        } else if (new RString("2").equals(batchParamter.get抽出モード())) {
            dataFrom = new FlexibleDate(batchParamter.get決定日付From().toDateString());
            dataTo = new FlexibleDate(batchParamter.get決定日付To().toDateString());
        }
        return new ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter(
                batchParamter.get振込予定日() == null ? null : new FlexibleDate(batchParamter.get振込予定日().toDateString()),
                dataFrom, dataTo,
                batchParamter.get発行日() == null ? null : new FlexibleDate(batchParamter.get発行日().toDateString()),
                batchParamter.get決定者受付年月() == null ? null : new FlexibleYearMonth(batchParamter.get発行日().getYearMonth().toDateString()),
                batchParamter.get抽出モード(), batchParamter.get印書());
    }
}
