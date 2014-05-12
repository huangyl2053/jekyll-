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

    /**
     * 審査会支援、審査会審査対象者一覧画面ロード時の動作を表します。
     *
     * @param div 審査会審査対象者一覧Div
     * @param shinsaKekkaDiv 審査結果入力Div
     * @return ResponseData
     */
    public ResponseData onLoadData(ShinsaShienTaishoshaIchiranDiv div, KaniShinsakaiKaisaiKekkaDiv shinsaKekkaDiv) {
        ResponseData<ShinsaShienTaishoshaIchiranDiv> response = new ResponseData<>();

        div.getDgShinsaTaishoshaIchiran1().setDataSource(createRowTaishoIchiran1TestData());
        response.data = div;
        return response;
    }

    /**
     * 審査会終了ボタンクリック時の動作を表します。
     *
     * @param taishoshaDiv 審査会審査対象者一覧Div
     * @param shinsakaiDiv 審査結果入力Div
     * @return ResponseData
     */
    public ResponseData btnShinsaKekkaNyuryokuEndClick(ShinsaShienTaishoshaIchiranDiv taishoshaDiv,
            KaniShinsakaiKaisaiKekkaDiv shinsakaiDiv) {

        ResponseData<KaniShinsakaiKaisaiKekkaDiv> response = new ResponseData<>();

        shinsakaiDiv.getTxtShinsaJissiShuryobi().setValue(FlexibleDate.getNowDate());
        shinsakaiDiv.getTxtShinsaJissiShuryobi().setDisabled(false);
        shinsakaiDiv.getTxtEndTime().setValue(RTime.now());
        shinsakaiDiv.getTxtEndTime().setDisabled(false);

        response.data = shinsakaiDiv;
        return response;

    }

    private List<dgShinsaTaishoshaIchiran1_Row> createRowTaishoIchiran1TestData() {
        List<dgShinsaTaishoshaIchiran1_Row> arrayData = new ArrayList<>();
        dgShinsaTaishoshaIchiran1_Row item;

        item = createRowTaishosha1Data("更新", "在宅", "要介護２", "要介護２", "要介護２", "", "２４", "");
        arrayData.add(item);
        item = createRowTaishosha1Data("新規", "在宅", "", "", "要支援２", "", "", "");
        arrayData.add(item);
        item = createRowTaishosha1Data("変更", "在宅", "非該当", "要支援１", "要支援１", "", "１２", "");
        arrayData.add(item);
        item = createRowTaishosha1Data("変更", "施設", "要介護３", "要介護３", "要介護３", "", "２４", "");
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
