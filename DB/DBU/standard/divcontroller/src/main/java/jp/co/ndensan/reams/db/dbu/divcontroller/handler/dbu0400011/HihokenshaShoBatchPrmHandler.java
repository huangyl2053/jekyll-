/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0400011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashoikkatsuhakko.HihokenshashoIkkatsuHakkoModel;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011.HihokenshaShoBatchPrmDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護保険被保険者証一括作成Handlerクラスです。
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
        jyukumino(resultList);
        gaitomono(resultList);
        jnennrei(resultList);
    }

    private void sentaku(List<HihokenshashoIkkatsuHakkoModel> resultList) {
        div.getTxtZenkaiChushutsuFromYMD().setValue(new RDate(resultList.get(0).getTaishoKaishiTimestamp().getDate().wareki().toString()));
        div.getTxtZenkaiChushutsuFromTime().setValue(resultList.get(0).getTaishoKaishiTimestamp().getRDateTime().getTime());
        div.getTxtZenkaiChushutsuToYMD().setValue(new RDate(resultList.get(0).getTaishoShuryoTimestamp().getDate().wareki().toString()));
        div.getTxtZenkaiChushutsuToTime().setValue(resultList.get(0).getTaishoShuryoTimestamp().getRDateTime().getTime());
        div.getTxtZenkaiShoriKijunYMD().setValue(new RDate(resultList.get(0).getKijunTimestamp().getDate().wareki().toString()));
        div.getTxtZenkaiShoriKijunTime().setValue(resultList.get(0).getKijunTimestamp().getRDateTime().getTime());
        div.getTxtKonkaiChushutsuFromYMD().setValue(resultList.get(0).getKijunTimestamp().getDate());
        div.getTxtKonkaiChushutsuFromTime().setValue(resultList.get(0).getKijunTimestamp().getRDateTime().getTime());
    }

    private void jyukumino(List<HihokenshashoIkkatsuHakkoModel> resultList) {
        if ((JYUKYUMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            div.getRadShutsuryokuJoken().setSelectedKey(JYUKYUMONO_RADIO_SENTAKU);
            sentaku(resultList);
            div.getTxtKonkaiChushutsuToYMD().setValue(new RDate(RDate.getNowDate().wareki().toString()));
            div.getTxtKonkaiChushutsuToYMD().setDisabled(true);
            div.getTxtKonkaiChushutsuToTime().setValue(RDate.getNowTime());
            div.getTxtKonkaiChushutsuToTime().setDisabled(true);
            div.getTxtKonkaiShoriKijunYMD().setValue(new RDate(RDate.getNowDate().toString()));
            div.getTxtKonkaiShoriKijunYMD().setDisabled(true);
            div.getTxtKonkaiShoriKijunTime().setValue(RDate.getNowTime());
            div.getTxtKonkaiShoriKijunTime().setDisabled(true);
        }
    }

    private void gaitomono(List<HihokenshashoIkkatsuHakkoModel> resultList) {
        if ((GAITOMONO_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            div.getRadShutsuryokuJoken().setSelectedKey(GAITOMONO_RADIO_SENTAKU);
            sentaku(resultList);
            div.getTxtKonkaiChushutsuToYMD().setValue(new RDate(RDate.getNowDate().toString()));
            div.getTxtKonkaiChushutsuToTime().setValue(RDate.getNowTime());
            div.getTxtKonkaiShoriKijunYMD().setValue(new RDate(RDate.getNowDate().wareki().toString()));
            div.getTxtKonkaiShoriKijunYMD().setDisabled(true);
            div.getTxtKonkaiShoriKijunTime().setValue(RDate.getNowTime());
            div.getTxtKonkaiShoriKijunTime().setDisabled(true);
        }
    }

    private void jnennrei(List<HihokenshashoIkkatsuHakkoModel> resultList) {
        if ((JNENNREI_RADIO_SENTAKU).equals(div.getRadShutsuryokuJoken().getSelectedKey())) {
            div.getRadShutsuryokuJoken().setSelectedKey(JNENNREI_RADIO_SENTAKU);
            sentaku(resultList);
            if (div.getTxtZenkaiChushutsuToYMD().getValue().isBeforeOrEquals(div.getTxtKonkaiShoriKijunYMD().getValue())) {
                div.getTxtKonkaiChushutsuToYMD().setValue(new RDate(RDate.getNowDate().wareki().toString()));
                div.getTxtKonkaiChushutsuToTime().setValue(RDate.getNowTime());
            }
            //TODO QA345張紅麗　まで12/29　今回の終了日と今回の時分秒（未満）の処理確認
            if (div.getTxtKonkaiShoriKijunYMD().getValue().isBefore(div.getTxtZenkaiChushutsuToYMD().getValue())) {
                div.getTxtKonkaiChushutsuToYMD().setValue(new RDate(resultList.get(0).getTaishoShuryoTimestamp().getDate().wareki().toString()));
                div.getTxtKonkaiChushutsuToTime().setValue(resultList.get(0).getTaishoShuryoTimestamp().getRDateTime().getTime());
            }
            div.getTxtKonkaiShoriKijunYMD().setValue(new RDate(RDate.getNowDate().wareki().toString()));
            div.getTxtKonkaiShoriKijunYMD().setDisabled(true);
            div.getTxtKonkaiShoriKijunTime().setValue(RDate.getNowTime());
            div.getTxtKonkaiShoriKijunTime().setDisabled(true);
        }
    }

    /**
     * 「再発行する」のselectイベントを処理します。
     *
     * @param resultList HihokenshashoIkkatsuHakkoModel
     */
    public void saihakkoSelect(List<HihokenshashoIkkatsuHakkoModel> resultList) {
        div.getRadShutsuryokuJoken().setDisabled(true);
        div.getTxtZenkaiChushutsuFromYMD().setValue(new RDate(resultList.get(0).getTaishoKaishiTimestamp().getDate().wareki().toString()));
        div.getTxtZenkaiChushutsuFromYMD().setDisabled(true);
        div.getTxtZenkaiChushutsuFromTime().setValue(resultList.get(0).getTaishoKaishiTimestamp().getRDateTime().getTime());
        div.getTxtZenkaiChushutsuFromTime().setDisabled(true);
        div.getTxtZenkaiChushutsuToYMD().setValue(new RDate(resultList.get(0).getTaishoShuryoTimestamp().getDate().toString()));
        div.getTxtZenkaiChushutsuToTime().setValue(resultList.get(0).getTaishoShuryoTimestamp().getRDateTime().getTime());
        div.getTxtZenkaiShoriKijunYMD().setDisabled(true);
        div.getTxtZenkaiShoriKijunTime().setValue(resultList.get(0).getKijunTimestamp().getRDateTime().getTime());
        div.getTxtZenkaiShoriKijunTime().setDisabled(true);
        div.getTxtKonkaiChushutsuFromYMD().setValue(new RDate(resultList.get(0).getTaishoKaishiTimestamp().getDate().wareki().toString()));
        div.getTxtKonkaiChushutsuFromYMD().setDisabled(true);
        div.getTxtKonkaiChushutsuFromTime().setValue(resultList.get(0).getTaishoKaishiTimestamp().getRDateTime().getTime());
        div.getTxtKonkaiChushutsuFromTime().setDisabled(true);
        div.getTxtKonkaiChushutsuToYMD().setValue(new RDate(resultList.get(0).getTaishoShuryoTimestamp().getDate().toString()));
        div.getTxtKonkaiChushutsuToYMD().setDisabled(true);
        div.getTxtKonkaiChushutsuToTime().setValue(resultList.get(0).getTaishoShuryoTimestamp().getRDateTime().getTime());
        div.getTxtKonkaiChushutsuToTime().setDisabled(true);
        div.getTxtKonkaiShoriKijunYMD().setValue(new RDate(resultList.get(0).getKijunTimestamp().getDate().toString()));
        div.getTxtKonkaiShoriKijunYMD().setDisabled(true);
        div.getTxtKonkaiShoriKijunTime().setValue(resultList.get(0).getKijunTimestamp().getRDateTime().getTime());
        div.getTxtKonkaiShoriKijunTime().setDisabled(true);
    }
}
