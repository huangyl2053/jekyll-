/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002.TaishoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 対象審査会の情報を編集します。
 *
 * @author N1013 松本直樹
 */
public class TaishoShinsakai {

    /**
     * 審査会審査結果入力を行う対象となる審査会の情報を表示する画面のロード時の設定を表します。
     *
     * @param div 対象審査会情報Div
     * @return ResponseData
     */
    public ResponseData onLoadData(TaishoShinsakaiDiv div) {
        ResponseData<TaishoShinsakaiDiv> response = new ResponseData<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe5030002/ShinsaKekkaTaishoShinsakai.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));

        div.getTxtGogitai().setValue(cg.getAsRString("合議体"));
        int startTimeHour = new Integer(cg.getAsRString("開始時間時").toString());
        int startTimeMin = new Integer(cg.getAsRString("開始時間分").toString());
        div.getTxtShinsaStartTime().setValue(RTime.of(startTimeHour, startTimeMin));
        int endTimeHour = new Integer(cg.getAsRString("終了時間時").toString());
        int endTimeMin = new Integer(cg.getAsRString("終了時間分").toString());
        div.getTxtShinsaEndTime().setValue(RTime.of(endTimeHour, endTimeMin));
        div.getTxtShinsaTaishoshaSu().setValue(cg.getAsDecimal("対象人数"));
        div.getTxtShinsaTaishoMax().setValue(cg.getAsDecimal("可能人数"));
        div.getTxtShinsakaiYoteibi().setValue(cg.getAsFlexibleDate("開催予定日"));
        div.getTxtShinsakaiKaisaibi().setValue(cg.getAsFlexibleDate("開催日"));

        RString shinsakaiMeisho = (RString) ViewStateHolder.get("審査会番号", RString.class);
        div.getTxtShinsakaiNo().setValue(shinsakaiMeisho);

        response.data = div;
        return response;
    }

}
