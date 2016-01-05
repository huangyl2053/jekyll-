/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.DBU0210011;

import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyo.ChushutsuKikanJohoData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0210011.KobetsuJikoRenkeiInfoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * 介護住民票個別事項連携情報作成【他社住基】ハンドラクラスです。
 */
public class KobetsuJikoRenkeiInfoSakuseiHandler {

    private final KobetsuJikoRenkeiInfoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護住民票個別事項連携情報作成【他社住基】情報Div
     */
    public KobetsuJikoRenkeiInfoSakuseiHandler(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param chushutsuKikanJohoData 抽出期間情報Entity
     */
    public void initialize(ChushutsuKikanJohoData chushutsuKikanJohoData) {

        if (chushutsuKikanJohoData != null) {
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().setValue(chushutsuKikanJohoData.get対象開始日時().getDate());
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().setValue(chushutsuKikanJohoData.get対象開始日時().getRDateTime().getTime());
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromYMD().setValue(chushutsuKikanJohoData.get対象終了日時().getDate());
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime().setValue(chushutsuKikanJohoData.get対象開始日時().getRDateTime().getTime());
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuToYMD().setValue(chushutsuKikanJohoData.get対象終了日時().getDate());
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuToTime().setValue(chushutsuKikanJohoData.get対象開始日時().getRDateTime().getTime());
        } else {
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromYMD().setValue(RDate.getNowDate());
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime().setValue(RDate.getNowTime());
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuToYMD().setValue(RDate.getNowDate());
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuToTime().setValue(RDate.getNowTime());
        }
    }
}
