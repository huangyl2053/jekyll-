/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.TaishoShinsakaiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.joda.time.LocalTime;

/**
 * 対象審査会の情報を編集します。
 *
 * @author N1013 松本直樹
 */
public class TaishoShinsakai {

    public ResponseData getOnloadData(TaishoShinsakaiDiv div) {
        ResponseData<TaishoShinsakaiDiv> response = new ResponseData<>();

        div.getTxtGogitai().setValue(new RString("合議体２"));
        div.getTxtShinsaStartTime().setValue(RTime.of(15, 00));
        div.getTxtShinsaEndTime().setValue(RTime.of(16, 30));
        div.getTxtShinsaTaishoshaSu().setValue(new Decimal(10));
        div.getTxtShinsaTaishoMax().setValue(new Decimal(40));
        div.getTxtShinsakaiYoteibi().setValue(new RDate("2014/04/25"));
        div.getTxtShinsakaiKaisaibi().setValue(new RDate("2014/04/25"));

        response.data = div;
        return response;
    }

}
