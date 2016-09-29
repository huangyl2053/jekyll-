/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の介護特別徴収情報取込履歴の登録のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsTorikomiRirekiProcessParameter implements IBatchProcessParameter {

    private RString 処理対象月;
    private YMDHMS システム日時;

    /**
     * コンストラクタです。
     *
     * @param 処理対象月 RString
     * @param システム日時 YMDHMS
     */
    public InsTorikomiRirekiProcessParameter(RString 処理対象月, YMDHMS システム日時) {
        this.処理対象月 = 処理対象月;
        this.システム日時 = システム日時;
    }

}
