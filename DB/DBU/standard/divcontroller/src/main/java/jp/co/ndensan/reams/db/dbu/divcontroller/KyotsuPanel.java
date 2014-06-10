/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011.KyotsuPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011.IkkatsuHakkoTaishoListDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 被保険者証一括発行共通パネルDivを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class KyotsuPanel {

    /**
     * 被保険者証一括発行画面-「被保険者証を発行する」ボタン制御を表します。
     *
     * @param panel KyotsuPanelDiv
     * @param panel2 IkkatsuHakkoTaishoListDiv
     * @return ResponseData
     */
    public ResponseData<KyotsuPanelDiv> onClick_BtnSearchHakkoTaisho(KyotsuPanelDiv panel,
            IkkatsuHakkoTaishoListDiv panel2) {
        ResponseData<KyotsuPanelDiv> response = new ResponseData<>();

        panel.getBtnBatch().setDisabled(true);
        response.data = panel;
        return response;

    }

    /**
     * 被保険者証一括発行画面-「被保険者証出力順パネル」Close時のボタン制御を表します。
     *
     * @param panel KyotsuPanelDiv
     * @param panel2 IkkatsuHakkoTaishoListDiv
     * @return ResponseData
     */
    public ResponseData<KyotsuPanelDiv> onClose_HihokenshashoIkkatsuHakko(KyotsuPanelDiv panel,
            IkkatsuHakkoTaishoListDiv panel2) {
        ResponseData<KyotsuPanelDiv> response = new ResponseData<>();

        panel.getBtnBatch().setDisabled(true);

        response.data = panel;
        return response;

    }

    /**
     * 被保険者証一括発行画面-「被保険者証を発行する」ボタン制御を表します。
     *
     * @param panel KyotsuPanelDiv
     * @param panel2 IkkatsuHakkoTaishoListDiv
     * @return ResponseData
     */
    public ResponseData<KyotsuPanelDiv> setBtnBatchControl(KyotsuPanelDiv panel,
            IkkatsuHakkoTaishoListDiv panel2) {

        ResponseData<KyotsuPanelDiv> response = new ResponseData<>();

        panel.getBtnBatch().setDisabled(true);

        if (panel2.getDgIkkatsuHakkoTaisho().getSelectedItems().isEmpty()) {

            panel.getBtnBatch().setDisabled(true);

        } else if (panel2.getHihokenshashoIkkatsuHakko().isIsPublish() == false) {

            panel.getBtnBatch().setDisabled(true);
        } else {

            panel.getBtnBatch().setDisabled(false);
        }

        response.data = panel;
        return response;

    }
}
