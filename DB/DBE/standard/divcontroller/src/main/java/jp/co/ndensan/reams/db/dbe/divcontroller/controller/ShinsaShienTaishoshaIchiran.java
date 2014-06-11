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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.KaniShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.ShinsaShienTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.dgShinsaTaishoshaIchiran1_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査会支援での審査会対象者の一覧を編集します。
 *
 * @author N1013 松本直樹
 */
public class ShinsaShienTaishoshaIchiran {

    static final int SELECT_IDX = 0;

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
     * 審査結果入力詳細Divの一覧に戻るボタン押下時の処理を表します。
     *
     * @param div 審査会対象者一覧Div（自身）
     * @param shinsaKekkaDiv 簡易審査会開催結果Div
     * @return ResponseData
     */
    public ResponseData onClick_btnBackIchiran(ShinsaShienTaishoshaIchiranDiv div, KaniShinsakaiKaisaiKekkaDiv shinsaKekkaDiv) {
        ResponseData<ShinsaShienTaishoshaIchiranDiv> response = new ResponseData<>();

        RString nijiHantei = (RString) ViewStateHolder.get("判定結果", RString.class);
        RString yukoTsukisu = (RString) ViewStateHolder.get("有効月数", RString.class);
        div.getDgShinsaTaishoshaIchiran1().getSelectedItems().get(SELECT_IDX).set二次(nijiHantei);
        div.getDgShinsaTaishoshaIchiran1().getSelectedItems().get(SELECT_IDX).set期間(yukoTsukisu);
        response.data = div;

        return response;
    }

    private static List<dgShinsaTaishoshaIchiran1_Row> createRowTaishoIchiran1TestData() {
        List<dgShinsaTaishoshaIchiran1_Row> arrayData = new ArrayList<>();

        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("ShinsakaiShinsaTaishoshaList.yml"));
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
        RString nenrei = _toRString(map.get("年齢"));
        RString sex = _toRString(map.get("性別"));
        RString hihoKubun = _toRString(map.get("被保険者区分"));
        RString shinseibi = _toRString(map.get("申請日"));
        RString ninteiStartDay = _toRString(map.get("認定有効期間開始日"));

        dgShinsaTaishoshaIchiran1_Row row = new dgShinsaTaishoshaIchiran1_Row(shinseiKubun,
                jokyo, zenIchiji, zenNiji, ichijiHantei, nijiHantei, zenKikan, kikan,
                nenrei, sex, hihoKubun, shinseibi, ninteiStartDay);
        return row;
    }

    private static RString _toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

}
