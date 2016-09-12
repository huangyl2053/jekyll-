/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0140001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 「実行する」ボタンを押下時の入力チェックSpecです。
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public enum FuchoKarisanteiFukaMenuPanelSpec implements IPredicate<FuchoKarisanteiFukaMenuPanelDiv> {

    /**
     * 「実行する」ボタンを押下すると、普徴開始通知書（仮算定）のチェックがオンの場合、発行日が入力されない場合、エラー
     */
    発行日未入力入力チェック {
                @Override
                public boolean apply(FuchoKarisanteiFukaMenuPanelDiv div) {
                    return div.getMainPanelBatchParameter()
                    .getFuchoKarisanteiChohyoHakko2().getFuchoTsuchiKobetsuJoho().getTxtHakkoYMD().getValue() != null;
                }
            },
    /**
     * 「実行する」ボタンを押下すると、普徴開始通知書（仮算定）のチェックがオンの場合、対象者が選択されない場合、エラー
     */
    対象者未選択チェック {
                @Override
                public boolean apply(FuchoKarisanteiFukaMenuPanelDiv div) {
                    List<KeyValueDataSource> selectedItems = div.getMainPanelBatchParameter()
                    .getFuchoKarisanteiChohyoHakko2().getFuchoTsuchiKobetsuJoho().getChkNotsuTaishosha2().getSelectedItems();
                    return selectedItems != null && !selectedItems.isEmpty();
                }
            },
    /**
     * 「実行する」ボタンを押下すると、保険料納入通知書（仮算定）のチェックがオンの場合、納入通知書の型が「0:なし」の場合、エラーとする
     */
    帳票IDのチェック_型0 {
                @Override
                public boolean apply(FuchoKarisanteiFukaMenuPanelDiv div) {
                    return false;
                }
            },
    /**
     * 「実行する」ボタンを押下すると、保険料納入通知書（仮算定）のチェックがオンの場合、納入通知書の型が「2:銀振型5期タイプ」の場合、エラーとする
     */
    帳票IDのチェック_型2 {
                @Override
                public boolean apply(FuchoKarisanteiFukaMenuPanelDiv div) {
                    return false;
                }
            };
}
