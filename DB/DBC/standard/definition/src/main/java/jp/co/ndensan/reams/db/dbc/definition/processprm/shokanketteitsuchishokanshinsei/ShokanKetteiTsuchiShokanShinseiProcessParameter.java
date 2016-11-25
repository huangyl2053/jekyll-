/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.shokanketteitsuchishokanshinsei;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC030010.DBC030010_ShokanShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払い支給（不支給）償還払支給申請DB更新処理のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanKetteiTsuchiShokanShinseiProcessParameter implements IBatchProcessParameter {

    private RString 支払場所;
    private RDate 支払期間From;
    private RDate 支払期間To;
    private RTime 開始時間;
    private RTime 終了時間;
    private RString 決定日一括更新区分;

    private ShokanKetteiTsuchiShokanShinseiProcessParameter(RString 支払場所, RDate 支払期間From,
            RDate 支払期間To, RTime 開始時間, RTime 終了時間, RString 決定日一括更新区分) {
        this.支払場所 = 支払場所;
        this.支払期間From = 支払期間From;
        this.支払期間To = 支払期間To;
        this.開始時間 = 開始時間;
        this.終了時間 = 終了時間;
        this.決定日一括更新区分 = 決定日一括更新区分;
    }

    /**
     * 償還払い支給（不支給）償還払支給申請DB更新処理のProcess用パラメータを作成します。
     *
     * @param batchParamter バッチパラメータ
     * @return Process用パラメータ
     */
    public static ShokanKetteiTsuchiShokanShinseiProcessParameter
            createProcessParam(DBC030010_ShokanShikyuKetteiTsuchishoParameter batchParamter) {
        return new ShokanKetteiTsuchiShokanShinseiProcessParameter(
                batchParamter.get支払場所() == null ? RString.EMPTY : batchParamter.get支払場所(),
                batchParamter.get支払期間From() == null ? null : batchParamter.get支払期間From(),
                batchParamter.get支払期間To() == null ? null : batchParamter.get支払期間To(),
                batchParamter.get開始時間() == null ? null : batchParamter.get開始時間(),
                batchParamter.get終了時間() == null ? null : batchParamter.get終了時間(),
                batchParamter.get決定日一括更新区分() == null ? RString.EMPTY : batchParamter.get決定日一括更新区分()
        );
    }

}
