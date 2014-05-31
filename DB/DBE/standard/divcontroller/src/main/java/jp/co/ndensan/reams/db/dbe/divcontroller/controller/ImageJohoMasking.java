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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001.ImageJohoMaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001.dgImageMaskShoriTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * イメージ情報マスキング処理Divの処理を表します。（DBE4050001）
 *
 * @author N1013 松本直樹
 */
public class ImageJohoMasking {

    RString ymlData;
    RString hokenshaMeisho;

    /**
     * 審査会予定登録Divのロード時の処理を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onLoadData(ImageJohoMaskingDiv div) {
        ResponseData<ImageJohoMaskingDiv> response = new ResponseData<>();

        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("DemoCity.yml"));
        Map map = targetSource.get(0);
        if (_toRString(map.get("保険者番号")).equalsIgnoreCase(new RString("152264"))) {
            div.getShoriTaishoshaKensakuShiji().getDdlHokensha().setSelectedItem(new RString("2"));
            hokenshaMeisho = new RString("南魚沼市");
        } else {
            div.getShoriTaishoshaKensakuShiji().getDdlHokensha().setSelectedItem(new RString("1"));
            hokenshaMeisho = new RString("電算市");
        }

        div.getShoriTaishoshaKensakuShiji().getTxtHihokenshaNo().setDisplayNone(true);

        response.data = div;
        return response;
    }

    /**
     * 検索指示Div上の検索対象ddlの選択内容を変更した時の処理内容を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onChange_ddlKensakuTaisho(ImageJohoMaskingDiv div) {
        ResponseData<ImageJohoMaskingDiv> response = new ResponseData<>();

        if (div.getShoriTaishoshaKensakuShiji().getDdlKensakuTaisho().getSelectedValue().
                equalsIgnoreCase(new RString("被保険者番号"))) {
            div.getShoriTaishoshaKensakuShiji().getLblKara1().setDisplayNone(true);
            div.getShoriTaishoshaKensakuShiji().getTxtSearchStYMD().setDisplayNone(true);
            div.getShoriTaishoshaKensakuShiji().getTxtSearchEdYMD().setDisplayNone(true);
            div.getShoriTaishoshaKensakuShiji().getTxtHihokenshaNo().setDisplayNone(false);
        } else {
            div.getShoriTaishoshaKensakuShiji().getLblKara1().setDisplayNone(false);
            div.getShoriTaishoshaKensakuShiji().getTxtSearchStYMD().setDisplayNone(false);
            div.getShoriTaishoshaKensakuShiji().getTxtSearchEdYMD().setDisplayNone(false);
            div.getShoriTaishoshaKensakuShiji().getTxtHihokenshaNo().setDisplayNone(true);
        }

        List<dgImageMaskShoriTaishosha_Row> arrayData = new ArrayList<>();
        div.getShoriTaishoshaIchiran().getDgImageMaskShoriTaishosha().setDataSource(arrayData);

        response.data = div;
        return response;
    }

    /**
     * 検索指示Div上の検索日付の開始日の内容を変更した時の処理内容を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onChange_txtSearchStYMD(ImageJohoMaskingDiv div) {
        ResponseData<ImageJohoMaskingDiv> response = new ResponseData<>();

        div.getShoriTaishoshaKensakuShiji().getTxtSearchEdYMD().setValue(
                div.getShoriTaishoshaKensakuShiji().getTxtSearchStYMD().getValue());

        response.data = div;
        return response;
    }

    /**
     * 検索指示Div上の検索するボタンを押下した時の処理内容を表します。
     *
     * @param div 審査会開催予定登録Div
     * @return ResponseData
     */
    public ResponseData onClick_btnTaishoKensaku(ImageJohoMaskingDiv div) {
        ResponseData<ImageJohoMaskingDiv> response = new ResponseData<>();

        hokenshaMeisho = div.getShoriTaishoshaKensakuShiji().getDdlHokensha().getSelectedValue();
        if (div.getShoriTaishoshaKensakuShiji().getDdlKensakuTaisho().getSelectedValue().
                equalsIgnoreCase(new RString("被保険者番号"))) {
            ymlData = new RString("dbe4050001/hihokenshaShiji.yml");
        } else {
            ymlData = new RString("dbe4050001/hizukeShiji.yml");
        }
        div.getShoriTaishoshaIchiran().getDgImageMaskShoriTaishosha().setDataSource(createRowSearchResultTestData(ymlData));

        response.data = div;
        return response;
    }

    private List<dgImageMaskShoriTaishosha_Row> createRowSearchResultTestData(RString ymlData) {
        List<dgImageMaskShoriTaishosha_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(ymlData);
        for (Map info : targetSource) {
            arrayData.add(toDgImageMaskShoriTaishosha_Row(info));
        }

        return arrayData;
    }

    private dgImageMaskShoriTaishosha_Row toDgImageMaskShoriTaishosha_Row(Map map) {
        RString hihokenshaNo = _toRString(map.get("被保番号"));
        RString shimei = _toRString(map.get("氏名"));
        TextBoxFlexibleDate shinseiDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("申請日").toString()));
        RString shinseiKubun = _toRString(map.get("申請区分"));
        RString maskKubun = _toRString(map.get("マスク処理"));
        TextBoxFlexibleDate ikenDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("意見書受領日").toString()));
        TextBoxFlexibleDate chosaDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("調査票受領日").toString()));
        TextBoxFlexibleDate shinsaDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("審査予定日").toString()));
        Button btn = new Button();
        dgImageMaskShoriTaishosha_Row row = new dgImageMaskShoriTaishosha_Row(btn, hokenshaMeisho, hihokenshaNo, shimei,
                shinseiDate, shinseiKubun, shinsaDate, maskKubun, ikenDate, chosaDate);
        return row;
    }

    private RString _toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

    private TextBoxFlexibleDate toTextBoxFlexibleDate(FlexibleDate date) {
        TextBoxFlexibleDate txtBox = new TextBoxFlexibleDate();
        txtBox.setValue(date);
        return txtBox;
    }

}
