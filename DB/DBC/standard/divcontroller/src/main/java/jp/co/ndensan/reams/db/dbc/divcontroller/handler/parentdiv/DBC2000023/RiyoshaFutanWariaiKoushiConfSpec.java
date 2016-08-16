/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000023;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023.RiyoshaFutanWariaiKoushiConfDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 「発行する」ボタンを押下時の入力チェックSpecです。
 *
 * @reamsid_L DBC-5010-012 lijian
 */
public enum RiyoshaFutanWariaiKoushiConfSpec implements IPredicate<RiyoshaFutanWariaiKoushiConfDiv> {

    /**
     * 「発行する」ボタンを押下すると、普徴開始通知書（仮算定）のチェックがオンの場合、発行日が入力されない場合、エラー
     */
    発行日未入力入力チェック {
                @Override
                public boolean apply(RiyoshaFutanWariaiKoushiConfDiv div) {
                    return div.getPanelHakko().getTxtHakkobi().getValue() != null;
                }
            },
    /**
     * 「発行する」ボタンを押下すると、普徴開始通知書（仮算定）のチェックがオンの場合、交付日が入力されない場合、エラー
     */
    交付日未入力チェック {
                @Override
                public boolean apply(RiyoshaFutanWariaiKoushiConfDiv div) {
                    return div.getPanelHakko().getTxtKofubi().getValue() != null;
                }
            },
    /**
     * 「発行する」ボタンを押下すると、普徴開始通知書（仮算定）のチェックがオンの場合、交付事由が未選択の場合、エラー
     */
    交付事由未選択チェック {
                @Override
                public boolean apply(RiyoshaFutanWariaiKoushiConfDiv div) {
                    List<KeyValueDataSource> selectedItems = div.getPanelHakko().getDdlKofuJiyu().getDataSource();
                    return selectedItems != null && !selectedItems.isEmpty();
                }
            };

}
