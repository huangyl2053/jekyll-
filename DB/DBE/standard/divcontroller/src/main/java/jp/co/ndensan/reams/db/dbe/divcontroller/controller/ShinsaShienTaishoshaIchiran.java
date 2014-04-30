/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KaniShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaShienTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran1_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 審査会支援での審査会対象者の一覧を編集します。
 *
 * @author N1013 松本直樹
 */
public class ShinsaShienTaishoshaIchiran {

    public ResponseData onLoadData(ShinsaShienTaishoshaIchiranDiv div, KaniShinsakaiKaisaiKekkaDiv shinsaKekkaDiv) {
        ResponseData<ShinsaShienTaishoshaIchiranDiv> response = new ResponseData<>();

        div.getDgShinsaTaishoshaIchiran1().setDataSource(createRowTaishoIchiran1TestData());
//        div.getTxtShinsaJissibi().setValue(RDate.getNowDate().toDateString());
//        div.getTxtStartTime().setValue(RTime.now());
//        div.getTxtShinsaJissiShuryobi().setValue(RString.EMPTY);
//        div.getTxtEndTime().setValue(null);
//        div.getTxtShinsaJissiShuryobi().setDisabled(true);
//        div.getTxtEndTime().setDisabled(true);
        response.data = div;
        return response;
    }

    public ResponseData btnShinsaKekkaNyuryokuEndClick(ShinsaShienTaishoshaIchiranDiv taishoshaDiv,
            KaniShinsakaiKaisaiKekkaDiv shinsakaiDiv) {

        ResponseData<ShinsaShienTaishoshaIchiranDiv> response = new ResponseData<>();

        shinsakaiDiv.getTxtShinsaJissiShuryobi().setValue(FlexibleDate.getNowDate());
        shinsakaiDiv.getTxtShinsaJissiShuryobi().setDisabled(false);
        shinsakaiDiv.getTxtEndTime().setValue(RTime.now());
        shinsakaiDiv.getTxtEndTime().setDisabled(false);

        response.data = taishoshaDiv;
        return response;

    }

    private List<dgShinsaTaishoshaIchiran1_Row> createRowTaishoIchiran1TestData() {
        List<dgShinsaTaishoshaIchiran1_Row> arrayData = new ArrayList<>();
        dgShinsaTaishoshaIchiran1_Row item;

        item = createRowTaishosha1Data("更新", "在宅", "介２", "介２", "介２", "　", "24", " ");
        arrayData.add(item);
        item = createRowTaishosha1Data("新規", "　", "　", "　", "支２", "　", "　", "　");
        arrayData.add(item);
        item = createRowTaishosha1Data("変更", "在宅", "非", "支１", "支１", "　", "12", "　");
        arrayData.add(item);
        item = createRowTaishosha1Data("変更", "介３", "介３", "介３", "　", "　", "24", "　");
        arrayData.add(item);

        return arrayData;
    }

    private dgShinsaTaishoshaIchiran1_Row createRowTaishosha1Data(String 申請区分, String 状況,
            String 前回一次, String 前回二次, String 一次判定, String 二次判定, String 前回有効期間月数, String 今回有効期間月数) {

        dgShinsaTaishoshaIchiran1_Row rowTaishosha1Data = new dgShinsaTaishoshaIchiran1_Row(
                RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        rowTaishosha1Data.set申請(new RString(申請区分));
        rowTaishosha1Data.set状況(new RString(状況));
        rowTaishosha1Data.set前一次(new RString(前回一次));
        rowTaishosha1Data.set前二次(new RString(前回二次));
        rowTaishosha1Data.set一次(new RString(一次判定));
        rowTaishosha1Data.set二次(new RString(二次判定));
        rowTaishosha1Data.set前期間(new RString(前回有効期間月数));
        rowTaishosha1Data.set期間(new RString(今回有効期間月数));

        return rowTaishosha1Data;
    }

}
