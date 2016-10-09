/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020005;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 給付制限対象者一覧CSVの入力チェックです。
 *
 * @reamsid_L DBD-4300-010 xuejm
 */
public enum KyufuSeigenTaishoshaIchiranPanelBatchParameterDivSpec implements IPredicate<KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv> {

    出力対象選択なしの入力チェック {
                /**
                 * 出力対象選択なしの入力チェック .
                 *
                 * @param div KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv
                 * @return true:出力対象選択です、false:出力対象選択なしの場合。
                 */
                @Override
                public boolean apply(KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div) {
                    return !div.getChkKobetushitei().getSelectedItems().isEmpty();
                }
            },
    出力順未設定の入力チェック {
                /**
                 * 出力順未設定の入力チェック .
                 *
                 * @param div KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv
                 * @return true:出力順設定です、false:出力順未設定の場合。
                 */
                @Override
                public boolean apply(KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div) {
                    return div.getCcdShuturyokujun().get出力順ID() != null;
                }
            };

}
