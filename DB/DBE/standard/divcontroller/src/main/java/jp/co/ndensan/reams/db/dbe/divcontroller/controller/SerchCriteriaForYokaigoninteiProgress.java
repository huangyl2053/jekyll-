/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.SerchCriteriaForYokaigoninteiProgressDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定進捗状況照会での検索指示画面の処理を表します。
 *
 * @author N1013 松本直樹
 */
public class SerchCriteriaForYokaigoninteiProgress {

    /**
     * 検索条件指示画面ロード時の処理を表します。
     *
     * @param div 検索条件指示Div
     * @return ResponseData
     */
    public ResponseData onLoad(SerchCriteriaForYokaigoninteiProgressDiv div) {
        ResponseData<SerchCriteriaForYokaigoninteiProgressDiv> response = new ResponseData<>();

        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("DemoCity.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));
        if (cg.getAsRString("保険者番号").equalsIgnoreCase(new RString("152264"))) {
            div.getDdlShichoson().setSelectedItem(new RString("2"));
        } else {
            div.getDdlShichoson().setSelectedItem(new RString("1"));
        }

        if (div.getRadSearchType().getSelectedItem().equalsIgnoreCase("2")) {
            div.getStateOfProgress().setDisplayNone(false);
            div.getHihokensha().setDisplayNone(true);
        } else {
            div.getStateOfProgress().setDisplayNone(true);
            div.getHihokensha().setDisplayNone(false);
        }
        div.getLatestPerson().setIsOpen(false);

        if (div.getStateOfProgress().getDateRanges().getRadDateRangeCriteriaType().
                getSelectedItem().equalsIgnoreCase("0")) {
            div.getStateOfProgress().getDateRanges().getTxtDateRangeCriteria().setDisabled(true);
        } else {
            div.getStateOfProgress().getDateRanges().getTxtDateRangeCriteria().setDisabled(false);
        }

        response.data = div;
        return response;
    }

    /**
     * 検索条件タイプを変更した際の処理を表します。
     *
     * @param div 検索条件指示Div
     * @return ResponseData
     */
    public ResponseData onChange_radSearchType(SerchCriteriaForYokaigoninteiProgressDiv div) {
        ResponseData<SerchCriteriaForYokaigoninteiProgressDiv> response = new ResponseData<>();

        if (div.getRadSearchType().getSelectedItem().equalsIgnoreCase("2")) {
            div.getStateOfProgress().setDisplayNone(false);
            div.getHihokensha().setDisplayNone(true);
            div.getHihokensha().getTxtHihokenshaNo().setValue(RString.EMPTY);
            div.getHihokensha().getTxtShikibetsuCode().setValue(RString.EMPTY);
            div.getHihokensha().getTxtHihokenshaShimei().setValue(RString.EMPTY);
        } else {
            div.getStateOfProgress().setDisplayNone(true);
            div.getHihokensha().setDisplayNone(false);
            div.getStateOfProgress().getDateRanges().getTxtDateRangeCriteria().clearFromValue();
            div.getStateOfProgress().getDateRanges().getTxtDateRangeCriteria().clearToValue();
            div.getStateOfProgress().getDateRanges().getRadDateRangeCriteriaType().setSelectedItem(new RString("0"));
            div.getStateOfProgress().getDateRanges().getTxtDateRangeCriteria().setDisabled(true);
            div.getStateOfProgress().getNinteichosa().getCheckBoxesForNinteichosa().getChkNinteichosaIrai().
                    setSelectedItems(Collections.EMPTY_LIST);
            div.getStateOfProgress().getNinteichosa().getCheckBoxesForNinteichosa().getChkNinteichosaJisshi().
                    setSelectedItems(Collections.EMPTY_LIST);
            div.getStateOfProgress().getNinteichosa().getCheckBoxesForNinteichosa().getChkNinteichosaTokki().
                    setSelectedItems(Collections.EMPTY_LIST);
            div.getStateOfProgress().getShujiiIkensho().getCheckBoxesForShujiiIkensho().getChkShujiiIkenshoIrai().
                    setSelectedItems(Collections.EMPTY_LIST);
            div.getStateOfProgress().getShujiiIkensho().getCheckBoxesForShujiiIkensho().getChkShujiiIkenshoJuryo().
                    setSelectedItems(Collections.EMPTY_LIST);
            div.getStateOfProgress().getIchijiHantei().getCheckBoxesForIchijiHantei().getChkIchijiHanteiJisshi().
                    setSelectedItems(Collections.EMPTY_LIST);
            div.getStateOfProgress().getShinsakai().getCheckBoxesForShinsakai().getChkShinsakaiJisshi().
                    setSelectedItems(Collections.EMPTY_LIST);
            div.getStateOfProgress().getShinsakai().getCheckBoxesForShinsakai().getChkShinsakaiWariate().
                    setSelectedItems(Collections.EMPTY_LIST);
        }

        response.data = div;
        return response;
    }

    /**
     * 日付範囲の検索条件ラジオボタンの選択値を変更した際の処理を表します。
     *
     * @param div 検索条件指示Div
     * @return ResponseData
     */
    public ResponseData onChange_radDateRangeCriteriaType(SerchCriteriaForYokaigoninteiProgressDiv div) {
        ResponseData<SerchCriteriaForYokaigoninteiProgressDiv> response = new ResponseData<>();

        if (div.getStateOfProgress().getDateRanges().getRadDateRangeCriteriaType().
                getSelectedItem().equalsIgnoreCase("0")) {
            div.getStateOfProgress().getDateRanges().getTxtDateRangeCriteria().setDisabled(true);
        } else {
            div.getStateOfProgress().getDateRanges().getTxtDateRangeCriteria().setDisabled(false);
        }

        response.data = div;
        return response;
    }

}
