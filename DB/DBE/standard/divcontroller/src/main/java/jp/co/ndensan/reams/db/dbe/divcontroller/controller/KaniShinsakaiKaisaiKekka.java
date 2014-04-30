/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KaniShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgKaniKaisaiKekka_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 審査会支援において、審査会開催結果を簡易入力します。
 *
 * @author N1013 松本直樹
 */
public class KaniShinsakaiKaisaiKekka {

    public ResponseData onLoadData(KaniShinsakaiKaisaiKekkaDiv div) {
        ResponseData<KaniShinsakaiKaisaiKekkaDiv> response = new ResponseData<>();

        div.getDgKaniKaisaiKekka().setDataSource(createRowKaisaiKekkaTestData());
        div.getTxtShinsaJissibi().setValue(FlexibleDate.getNowDate());
        div.getTxtStartTime().setValue(RTime.now());
        div.getTxtShinsaJissiShuryobi().setValue(FlexibleDate.EMPTY);
        div.getTxtEndTime().setValue(null);
        div.getTxtShinsaJissiShuryobi().setDisabled(true);
        div.getTxtEndTime().setDisabled(true);

        response.data = div;
        return response;
    }

    private List<dgKaniKaisaiKekka_Row> createRowKaisaiKekkaTestData() {
        List<dgKaniKaisaiKekka_Row> arrayData = new ArrayList<>();
        dgKaniKaisaiKekka_Row item;

        item = createRowKaisaiKekkaData(false, false, "審査員Ａ", "医師");
        arrayData.add(item);
        item = createRowKaisaiKekkaData(false, false, "審査員Ｂ", "保健師");
        arrayData.add(item);
        item = createRowKaisaiKekkaData(false, false, "審査員Ｃ", "作業療法士");
        arrayData.add(item);
        item = createRowKaisaiKekkaData(false, false, "審査員Ｄ", "医師");
        arrayData.add(item);

        return arrayData;
    }

    private dgKaniKaisaiKekka_Row createRowKaisaiKekkaData(boolean 委員長区分, boolean 出欠区分, String 氏名, String 資格) {

        dgKaniKaisaiKekka_Row rowKaisaiKekkaData = new dgKaniKaisaiKekka_Row(
                false, false, RString.HALF_SPACE, RString.HALF_SPACE);

        rowKaisaiKekkaData.set委員長(委員長区分);
        rowKaisaiKekkaData.set出欠(出欠区分);
        rowKaisaiKekkaData.set氏名(new RString(氏名));
        rowKaisaiKekkaData.set資格(new RString(資格));

        return rowKaisaiKekkaData;
    }

}
