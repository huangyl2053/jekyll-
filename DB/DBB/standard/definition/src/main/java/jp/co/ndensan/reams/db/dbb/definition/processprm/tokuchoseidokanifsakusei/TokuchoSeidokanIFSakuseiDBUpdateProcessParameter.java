/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * TokuchoSeidokanIFSakuseiDBUpdateProcessParameterのクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokuchoSeidokanIFSakuseiDBUpdateProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 処理年度;
    private RDate 特別徴収開始年月;
    private RString 遷移元メニュー;

    /**
     * コンストラクタです。
     */
    public TokuchoSeidokanIFSakuseiDBUpdateProcessParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 処理年度 FlexibleYear
     * @param 特別徴収開始年月 RDate
     * @param 遷移元メニュー RString
     */
    public TokuchoSeidokanIFSakuseiDBUpdateProcessParameter(FlexibleYear 処理年度, RDate 特別徴収開始年月, RString 遷移元メニュー) {
        this.処理年度 = 処理年度;
        this.特別徴収開始年月 = 特別徴収開始年月;
        this.遷移元メニュー = 遷移元メニュー;
    }
}
