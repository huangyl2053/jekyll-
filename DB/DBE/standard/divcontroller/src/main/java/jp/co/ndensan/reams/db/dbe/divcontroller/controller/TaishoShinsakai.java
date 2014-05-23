/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.TaishoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import org.joda.time.LocalTime;

/**
 * 対象審査会の情報を編集します。
 *
 * @author N1013 松本直樹
 */
public class TaishoShinsakai {

    public ResponseData getOnloadData(TaishoShinsakaiDiv div) {
        ResponseData<TaishoShinsakaiDiv> response = new ResponseData<>();
        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("ShinsaKekkaTaishoShinsakai.yml"));
        Map map = targetSource.get(0);

        System.out.println(_toRString(map.get("合議体")));
        div.getTxtGogitai().setValue(_toRString(map.get("合議体")));
        int startTimeHour = new Integer(map.get("開始時間時").toString());
        int startTimeMin = new Integer(map.get("開始時間分").toString());
        div.getTxtShinsaStartTime().setValue(RTime.of(startTimeHour, startTimeMin));
        int endTimeHour = new Integer(map.get("終了時間時").toString());
        int endTimeMin = new Integer(map.get("終了時間分").toString());
        div.getTxtShinsaEndTime().setValue(RTime.of(endTimeHour, endTimeMin));
        div.getTxtShinsaTaishoshaSu().setValue(new Decimal(map.get("対象人数").toString()));
        div.getTxtShinsaTaishoMax().setValue(new Decimal(map.get("可能人数").toString()));
        div.getTxtShinsakaiYoteibi().setValue(new FlexibleDate(map.get("開催予定日").toString()));
        div.getTxtShinsakaiKaisaibi().setValue(new FlexibleDate(map.get("開催日").toString()));

        response.data = div;
        return response;
    }

    private static RString _toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

}
