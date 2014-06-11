/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.HihokenshashoHakkoJohoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.KyotsuPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 被保険者証発行共通パネルDivを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class HihokenshashoHakkoKyotsuPanel {

    /**
     * 被保険者証発行画面-「被保険者証を発行する」ボタン制御を表します。
     *
     * @param panel KyotsuPanelDiv
     * @param panel2 HihokenshashoHakkoJohoDiv
     * @return ResponseData
     */
    public ResponseData<KyotsuPanelDiv> BtnHihokenshashoHakkoEnabelControl(KyotsuPanelDiv panel,
            HihokenshashoHakkoJohoDiv panel2) {
        ResponseData<KyotsuPanelDiv> response = new ResponseData<>();

        if (!panel2.getHihokenshashoHakkoShosaiJoho().getTxtKofuDate().getText().isEmpty()
                && !panel2.getHihokenshashoHakkoShosaiJoho().getDdlKofuJiyu().getSelectedValue().isEmpty()) {

            panel.getBtnHihokenshashoHakko().setDisabled(false);
        } else {
            panel.getBtnHihokenshashoHakko().setDisabled(true);
        }

        response.data = panel;
        return response;

    }
}
