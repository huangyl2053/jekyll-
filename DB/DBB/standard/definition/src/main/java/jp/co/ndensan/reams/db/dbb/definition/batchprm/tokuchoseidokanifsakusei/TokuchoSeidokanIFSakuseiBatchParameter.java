/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoseidokanifsakusei;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT84001_特徴制度間Ｉ／Ｆ
 *
 * @reamsid_L DBB-1830-040 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoSeidokanIFSakuseiBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private FlexibleYear 処理年度;
    private RDate 特別徴収開始年月;
    private RString 遷移元メニュー;
    private RDateTime システム日時;

    /**
     * コンストラクタです。
     *
     * @param 処理年度 FlexibleYear
     * @param 特別徴収開始年月 RDate
     * @param 遷移元メニュー RString
     */
    public TokuchoSeidokanIFSakuseiBatchParameter(FlexibleYear 処理年度, RDate 特別徴収開始年月, RString 遷移元メニュー) {
        this.処理年度 = 処理年度;
        this.特別徴収開始年月 = 特別徴収開始年月;
        this.遷移元メニュー = 遷移元メニュー;
    }

    /**
     * コンストラクタです。
     */
    public TokuchoSeidokanIFSakuseiBatchParameter() {
    }

    /**
     * ProcessParameterを取得します。
     *
     * @return TokuchoSeidokanIFSakuseiDBUpdateProcessParameter
     */
    public TokuchoSeidokanIFSakuseiDBUpdateProcessParameter
            toTokuchoSeidokanIFSakuseiDBUpdateProcessParameter() {
        return new TokuchoSeidokanIFSakuseiDBUpdateProcessParameter(
                処理年度, 特別徴収開始年月, 遷移元メニュー, システム日時);
    }
}
