/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBCommonInfoPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaInfoPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaSearchGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ReamsCommonInfoPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 被保険者照会画面上部の、被保険者情報を表示するパネルを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaInfoPanel {
    //TODO n8178 城間篤人 検索画面ができた後、そこから遷移するように修正予定。現在は決めうちでテストデータを用意している。 2014年5月

    /**
     * Panelに表示される情報に対して値を設定します。
     *
     * @param infoPanel 被保険者情報パネル
     * @param gaitoshaPanel 被保険者検索該当者パネル
     * @return response
     */
    public ResponseData<HihokenshaInfoPanelDiv> getOnLoadDivData(HihokenshaInfoPanelDiv infoPanel, HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        ResponseData<HihokenshaInfoPanelDiv> response = new ResponseData<>();

        setReamsCommonInfoData(infoPanel.getReamsCommonInfoPanel(), gaitoshaPanel);
        setDBCommonInfoData(infoPanel.getDBCommonInfoPanel(), gaitoshaPanel);
        response.data = infoPanel;

        return response;
    }

    private void setReamsCommonInfoData(ReamsCommonInfoPanelDiv reamsCommonData, HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        dgHihokenshaSearchGaitosha_Row gaitoshaGrid = get該当者情報(gaitoshaPanel);

        reamsCommonData.getTxtAge().setValue(gaitoshaGrid.getAge());
        reamsCommonData.getTxtDateOfBirth().setValue(new FlexibleDate("19600914"));
        reamsCommonData.getTxtGender().setValue(gaitoshaGrid.getGender());
        reamsCommonData.getTxtGyoseiku().setValue(gaitoshaGrid.getGyoseiku());
        reamsCommonData.getTxtShimei().setValue(gaitoshaGrid.getShimei());
        reamsCommonData.getTxtHurikana().setValue(gaitoshaGrid.getHurikana());
        reamsCommonData.getTxtJuminhyoCode().setValue(gaitoshaGrid.getJuminhyoCode());
        reamsCommonData.getTxtJushoCode().setValue(gaitoshaGrid.getJushoCode());
        reamsCommonData.getTxtJusho().setValue(gaitoshaGrid.getJusho());
        reamsCommonData.getTxtKumiai().setValue(gaitoshaGrid.getKumiai());
        reamsCommonData.getTxtRenrakusaki1().setValue(gaitoshaGrid.getRenrakusaki1());
        reamsCommonData.getTxtRenrakusaki2().setValue(gaitoshaGrid.getRenrakusaki2());
        reamsCommonData.getTxtSetaiCode().setValue(gaitoshaGrid.getSetaiCode());
    }

    private void setDBCommonInfoData(DBCommonInfoPanelDiv dbCommonData, HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        dgHihokenshaSearchGaitosha_Row gaitoshaGrid = get該当者情報(gaitoshaPanel);

        dbCommonData.getTxtHihokenshaNo().setValue(gaitoshaGrid.getHihokenshaNo());
        dbCommonData.getTxtYokaigodo().setValue(gaitoshaGrid.getYokaigodo());
        dbCommonData.getTxtNinteiKikan().setFromValue(new RDate("19990101"));
        dbCommonData.getTxtNinteiKikan().setToValue(null);
        dbCommonData.getTxtKyuHihokenshaNo().setValue(gaitoshaGrid.getKyuHihokenshaNo());
        dbCommonData.getTxtKyuShichosonCode().setValue(gaitoshaGrid.getKyuShichosonCode());
        dbCommonData.getTxtKyuShichoson().setValue(gaitoshaGrid.getKyuShichoson());
    }

    private dgHihokenshaSearchGaitosha_Row get該当者情報(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        dgHihokenshaSearchGaitosha_Row gaitoshaGrid;
        if (check未選択(gaitoshaPanel)) {
            gaitoshaGrid = gaitoshaPanel.getDgHihokenshaSearchGaitosha().getDataSource().get(0);
        } else {
            gaitoshaGrid = gaitoshaPanel.getDgHihokenshaSearchGaitosha().getSelectedItems().get(0);
        }
        return gaitoshaGrid;
    }

    private boolean check未選択(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        return gaitoshaPanel.getDgHihokenshaSearchGaitosha().getSelectedItems().isEmpty();
    }

}
