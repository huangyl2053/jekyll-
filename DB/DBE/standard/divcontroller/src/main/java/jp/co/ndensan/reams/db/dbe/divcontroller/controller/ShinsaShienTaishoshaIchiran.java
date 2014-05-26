/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KaniShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaShienTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran1_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
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
    public ResponseData onClick_btnShinsaKekkaNyuryokuEnd(ShinsaShienTaishoshaIchiranDiv taishoshaDiv,
            KaniShinsakaiKaisaiKekkaDiv shinsakaiDiv) {

        ResponseData<KaniShinsakaiKaisaiKekkaDiv> response = new ResponseData<>();

        shinsakaiDiv.getTxtShinsaJissiShuryobi().setValue(FlexibleDate.getNowDate());
        shinsakaiDiv.getTxtShinsaJissiShuryobi().setDisabled(false);
        shinsakaiDiv.getTxtEndTime().setValue(RTime.now());
        shinsakaiDiv.getTxtEndTime().setDisabled(false);

        response.data = shinsakaiDiv;
        return response;

    }

    private static List<dgShinsaTaishoshaIchiran1_Row> createRowTaishoIchiran1TestData() {
        List<dgShinsaTaishoshaIchiran1_Row> arrayData = new ArrayList<>();

        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("ShinsakaiShinsaTaishoshaList.yml"));
        for (Map info : targetSource) {
            arrayData.add(toDgShinsaTaishoshaIchiran1_Row(info));
        }

        return arrayData;
    }

    private static dgShinsaTaishoshaIchiran1_Row toDgShinsaTaishoshaIchiran1_Row(Map map) {
        RString shinseiKubun = _toRString(map.get("申請区分"));
        RString jokyo = _toRString(map.get("状況"));
        RString zenIchiji = _toRString(map.get("前回一次"));
        RString zenNiji = _toRString(map.get("前回二次"));
        RString ichijiHantei = _toRString(map.get("一次判定"));
        RString nijiHantei = _toRString(map.get("二次判定"));
        RString zenKikan = _toRString(map.get("前回期間"));
        RString kikan = _toRString(map.get("今回期間"));

        dgShinsaTaishoshaIchiran1_Row row = new dgShinsaTaishoshaIchiran1_Row(shinseiKubun,
                jokyo, zenIchiji, zenNiji, ichijiHantei, nijiHantei, zenKikan, kikan);
        return row;
    }

    private static RString _toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

}
