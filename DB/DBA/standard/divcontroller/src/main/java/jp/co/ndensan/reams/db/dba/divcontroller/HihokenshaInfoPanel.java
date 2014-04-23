/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBCommonInfoPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaInfoPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaSearchGaitoshaGrid_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaSearchGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ReamsCommonInfoPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.DateRoundingType;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Wareki;

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
        HihokenshaSearchGaitoshaGrid_Row gaitoshaGrid = get該当者情報(gaitoshaPanel);

        reamsCommonData.getAgeText().setValue(gaitoshaGrid.getAge());
        reamsCommonData.getDateOfBirthText().setValue(gaitoshaGrid.getDateOfBirth());
        reamsCommonData.getGenderText().setValue(gaitoshaGrid.getGender());
        reamsCommonData.getGyoseikuText().setValue(gaitoshaGrid.getGyoseiku());
        reamsCommonData.getShimeiText().setValue(gaitoshaGrid.getShimei());
        reamsCommonData.getHurikanaText().setValue(gaitoshaGrid.getHurikana());
        reamsCommonData.getJuminhyoCodeText().setValue(gaitoshaGrid.getJuminhyoCode());
        reamsCommonData.getJushoCodeText().setValue(gaitoshaGrid.getJushoCode());
        reamsCommonData.getJushoText().setValue(gaitoshaGrid.getJusho());
        reamsCommonData.getKumiaiText().setValue(gaitoshaGrid.getKumiai());
        reamsCommonData.getRenrakusaki1Text().setValue(gaitoshaGrid.getRenrakusaki1());
        reamsCommonData.getRenrakusaki2Text().setValue(gaitoshaGrid.getRenrakusaki2());
        reamsCommonData.getSetaiCodeText().setValue(gaitoshaGrid.getSetaiCode());
    }

    private void setDBCommonInfoData(DBCommonInfoPanelDiv dbCommonData, HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        HihokenshaSearchGaitoshaGrid_Row gaitoshaGrid = get該当者情報(gaitoshaPanel);

        dbCommonData.getHihokenshaNoText().setValue(gaitoshaGrid.getHihokenshaNo());
        dbCommonData.getYokaigodoText().setValue(gaitoshaGrid.getYokaigodo());
        dbCommonData.getNinteiKikanText().setFromValue(gaitoshaGrid.getNinteiKikanKaishi());
        dbCommonData.getNinteiKikanText().setToValue(gaitoshaGrid.getNinteiKikanShuryo());
        dbCommonData.getKyuHihokenshaNoText().setValue(gaitoshaGrid.getKyuHihokenshaNo());
        dbCommonData.getKyuShichosonCodeText().setValue(gaitoshaGrid.getKyuShichosonCode());
        dbCommonData.getKyuShichosonText().setValue(gaitoshaGrid.getKyuShichoson());
    }

    private HihokenshaSearchGaitoshaGrid_Row get該当者情報(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        HihokenshaSearchGaitoshaGrid_Row gaitoshaGrid;
        if (check未選択(gaitoshaPanel)) {
            gaitoshaGrid = gaitoshaPanel.getHihokenshaSearchGaitoshaGrid().getDataSource().get(0);
        } else {
            gaitoshaGrid = gaitoshaPanel.getHihokenshaSearchGaitoshaGrid().getSelectedItems().get(0);
        }
        return gaitoshaGrid;
    }

    private boolean check未選択(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        return gaitoshaPanel.getHihokenshaSearchGaitoshaGrid().getSelectedItems().isEmpty();
    }

}
