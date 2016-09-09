/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050021;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行画面の入力チェックです
 *
 * @reamsid_L DBD-3810-010 xuejm
 */
public enum SFKTishoshaIchiranPanelBatchParameterDivSpec implements IPredicate<SFKTishoshaIchiranPanelBatchParameterDiv> {

    出力順未設定チェック {
                /**
                 * 基準日が未入力チェック .
                 *
                 * @param div RiyoshaFutanGenmenListDiv
                 * @return true:基準日が非空です、false:基準日が空白の場合。
                 */

                @Override
                public boolean apply(SFKTishoshaIchiranPanelBatchParameterDiv div) {
                    return div.getChushutsuSetsumei().getCcdChohyoShutsuryokuJun().get出力順ID() != null;
                }
            }
}
