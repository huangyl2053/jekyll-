/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0400011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashoikkatsuhakko.HihokenshashoIkkatsuHakkoModel;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011.HihokenshaShoBatchPrmDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護保険被保険者証一括作成Handlerクラスです。
 *
 * @reamsid_L DBU-0420-010 duanzhanli
 */
public class HihokenshaShoBatchPrmHandler {

    private final HihokenshaShoBatchPrmDiv div;
    private static final RString JYUKYUMONO_RADIO_SENTAKU = new RString("2");
    private static final RString GAITOMONO_RADIO_SENTAKU = new RString("3");
    private static final RString JNENNREI_RADIO_SENTAKU = new RString("4");
    
    /**
     * HihokenshaShoBatchPrmHandlerの引入です。
     *
     * @param div 介護保険被保険者証一括作成Div
     */
    public HihokenshaShoBatchPrmHandler(HihokenshaShoBatchPrmDiv div) {
        this.div = div;
    }

    /**
     * 被保険者証一括発行画面初期化の設定します。
     *
     * @param resultList HihokenshashoIkkatsuHakkoModel
     */
    public void onLoad(List<HihokenshashoIkkatsuHakkoModel> resultList) {
        HihokenshashoIkkatsuHakkoModel hakkoModel;
        if (!resultList.isEmpty()) {
            hakkoModel = resultList.get(0);
        } else {
            hakkoModel = new HihokenshashoIkkatsuHakkoModel();
        }
        jyukumino(hakkoModel);
        gaitomono(hakkoModel);
        jnennrei(hakkoModel);
        div.getTxtHakkoYMD().setDisabled(true);
        div.getTxtHakkoTime().setDisabled(true);
    }

    private void sentaku(HihokenshashoIkkatsuHakkoModel hakkoModel) {
        if (hakkoModel.getTaishoKaishiTimestamp() != null) {
            div.getTxtZenkaiChushutsuFromYMD().setValue(hakkoModel.getTaishoKaishiTimestamp().getDate());
            div.getTxtZenkaiChushutsuFromTime().setValue(hakkoModel.getTaishoKaishiTimestamp().getRDateTime().getTime());
        }
        if (hakkoModel.getTaishoShuryoTimestamp() != null) {
            div.getTxtZenkaiChushutsuToYMD().setValue(hakkoModel.getTaishoShuryoTimestamp().getDate());
            div.getTxtZenkaiChushutsuToTime().setValue(hakkoModel.getTaishoShuryoTimestamp().getRDateTime().getTime());
        }
        if (hakkoModel.getKijunTimestamp() != null) {
            div.getTxtZenkaiShoriKijunYMD().setValue(hakkoModel.getKijunTimestamp().getDate());
            div.getTxtZenkaiShoriKijunTime().setValue(hakkoModel.getKijunTimestamp().getRDateTime().getTime());
            div.getTxtKonkaiChushutsuFromYMD().setValue(hakkoModel.getKijunTimestamp().getDate());
            div.getTxtKonkaiChushutsuFromTime().setValue(hakkoModel.getKijunTimestamp().getRDateTime().getTime());
        }
    }

    private void jyukumino(HihokenshashoIkkatsuHakkoModel hakkoModel) {
        if ((JYUKYUMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            div.getRadShutsuryokuJoken().setSelectedKey(JYUKYUMONO_RADIO_SENTAKU);
            sentaku(hakkoModel);
            div.getTxtKonkaiChushutsuToYMD().setValue(RDate.getNowDate());
            div.getTxtKonkaiChushutsuToYMD().setDisabled(true);
            div.getTxtKonkaiChushutsuToTime().setValue(RDate.getNowTime());
            div.getTxtKonkaiChushutsuToTime().setDisabled(true);
            div.getTxtKonkaiShoriKijunYMD().setValue(RDate.getNowDate());
            div.getTxtKonkaiShoriKijunYMD().setDisabled(true);
            div.getTxtKonkaiShoriKijunTime().setValue(RDate.getNowTime());
            div.getTxtKonkaiShoriKijunTime().setDisabled(true);
        }
    }

    private void gaitomono(HihokenshashoIkkatsuHakkoModel hakkoModel) {
        if ((GAITOMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            div.getRadShutsuryokuJoken().setSelectedKey(GAITOMONO_RADIO_SENTAKU);
            sentaku(hakkoModel);
            div.getTxtKonkaiChushutsuToYMD().setValue(RDate.getNowDate());
            div.getTxtKonkaiChushutsuToTime().setValue(RDate.getNowTime());
            div.getTxtKonkaiShoriKijunYMD().setValue(RDate.getNowDate());
            div.getTxtKonkaiShoriKijunYMD().setDisabled(true);
            div.getTxtKonkaiShoriKijunTime().setValue(RDate.getNowTime());
            div.getTxtKonkaiShoriKijunTime().setDisabled(true);
        }
    }

    private void jnennrei(HihokenshashoIkkatsuHakkoModel hakkoModel) {
        if ((JNENNREI_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            div.getRadShutsuryokuJoken().setSelectedKey(JNENNREI_RADIO_SENTAKU);
            sentaku(hakkoModel);
            div.getTxtKonkaiShoriKijunYMD().setValue(RDate.getNowDate());
            div.getTxtKonkaiShoriKijunYMD().setDisabled(true);
            div.getTxtKonkaiShoriKijunTime().setValue(RDate.getNowTime());
            div.getTxtKonkaiShoriKijunTime().setDisabled(true);
            if (div.getTxtZenkaiChushutsuToYMD().getValue().isBeforeOrEquals(div.getTxtKonkaiShoriKijunYMD().getValue())) {
                div.getTxtKonkaiChushutsuToYMD().setValue(RDate.getNowDate());
                div.getTxtKonkaiChushutsuToTime().setValue(RDate.getNowTime());
            }
            if (div.getTxtKonkaiShoriKijunYMD().getValue().isBefore(div.getTxtZenkaiChushutsuToYMD().getValue())) {
                div.getTxtKonkaiChushutsuToYMD().setValue(hakkoModel.getTaishoShuryoTimestamp().getDate());
                div.getTxtKonkaiChushutsuToTime().setValue(hakkoModel.getTaishoShuryoTimestamp().getRDateTime().getTime());
            }
        }
    }

    /**
     * 「再発行する」のselectイベントを処理します。
     *
     * @param resultList HihokenshashoIkkatsuHakkoModel
     */
    public void saihakkoSelect(List<HihokenshashoIkkatsuHakkoModel> resultList) {
        HihokenshashoIkkatsuHakkoModel hakkoModel = resultList.get(0);

        if (div.getChkSaiHakko().isAllSelected()) {
            div.getTxtKonkaiShoriKijunYMDBack().setValue(div.getTxtKonkaiShoriKijunYMD().getValue());
            div.getTxtKonkaiShoriKijunTimeBack().setValue(div.getTxtKonkaiShoriKijunTime().getValue());
            div.getTxtKonkaiChushutsuFromYMDBack().setValue(div.getTxtKonkaiChushutsuFromYMD().getValue());
            div.getTxtKonkaiChushutsuFromTimeBack().setValue(div.getTxtKonkaiChushutsuFromTime().getValue());
            div.getTxtKonkaiChushutsuToYMDBack().setValue(div.getTxtKonkaiChushutsuToYMD().getValue());
            div.getTxtKonkaiChushutsuToTimeBack().setValue(div.getTxtKonkaiChushutsuToTime().getValue());
        
            if (hakkoModel.getTaishoKaishiTimestamp() != null) {
                div.getTxtKonkaiChushutsuFromYMD().setValue(hakkoModel.getTaishoKaishiTimestamp().getDate());
                div.getTxtKonkaiChushutsuFromTime().setValue(hakkoModel.getTaishoKaishiTimestamp().getRDateTime().getTime());
            }

            div.getTxtKonkaiChushutsuFromYMD().setDisabled(true);
            div.getTxtKonkaiChushutsuFromTime().setDisabled(true);
            
            if (hakkoModel.getTaishoShuryoTimestamp() != null) {
                div.getTxtKonkaiChushutsuToYMD().setValue(hakkoModel.getTaishoShuryoTimestamp().getDate());
                div.getTxtKonkaiChushutsuToTime().setValue(hakkoModel.getTaishoShuryoTimestamp().getRDateTime().getTime());
            }

            div.getTxtKonkaiChushutsuToYMD().setDisabled(true);
            div.getTxtKonkaiChushutsuToTime().setDisabled(true);
            
            if (hakkoModel.getKijunTimestamp() != null) {
                div.getTxtKonkaiShoriKijunYMD().setValue(hakkoModel.getKijunTimestamp().getDate());
                div.getTxtKonkaiShoriKijunTime().setValue(hakkoModel.getKijunTimestamp().getRDateTime().getTime());
                div.getTxtHakkoYMD().setValue(hakkoModel.getKijunTimestamp().getDate());
                div.getTxtHakkoTime().setValue(hakkoModel.getKijunTimestamp().getRDateTime().getTime());
            }

        } else {
            
            div.getTxtKonkaiChushutsuFromYMD().setValue(div.getTxtKonkaiChushutsuFromYMDBack().getValue());
            div.getTxtKonkaiChushutsuFromTime().setValue(div.getTxtKonkaiChushutsuFromTimeBack().getValue());
            div.getTxtKonkaiChushutsuToYMD().setValue(div.getTxtKonkaiChushutsuToYMDBack().getValue());
            div.getTxtKonkaiChushutsuToTime().setValue(div.getTxtKonkaiChushutsuToTimeBack().getValue());
            div.getTxtKonkaiShoriKijunYMD().setValue(div.getTxtKonkaiShoriKijunYMDBack().getValue());
            div.getTxtKonkaiShoriKijunTime().setValue(div.getTxtKonkaiShoriKijunTimeBack().getValue());
            div.getTxtHakkoYMD().clearValue();
            div.getTxtHakkoTime().clearValue();
            
            div.getTxtKonkaiChushutsuFromYMD().setDisabled(false);
            div.getTxtKonkaiChushutsuFromTime().setDisabled(false);
            div.getTxtKonkaiChushutsuToYMD().setDisabled(false);
            div.getTxtKonkaiChushutsuToTime().setDisabled(false);
        }
    }
}
