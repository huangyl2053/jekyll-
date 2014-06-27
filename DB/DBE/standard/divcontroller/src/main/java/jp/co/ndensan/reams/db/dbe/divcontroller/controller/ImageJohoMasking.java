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
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * イメージ情報マスキング処理Divの処理を表します。（DBE4050001）
 *
 * @author N1013 松本直樹
 */
public class ImageJohoMasking {

    private RString ymlData;
    private RString hokenshaMeisho;

    /**
     * イメージ情報マスキング処理Divのロード時の処理を表します。
     *
     * @param div イメージ情報マスキング処理Div
     * @return ResponseData
     */
    public ResponseData onLoadData(ImageJohoMaskingDiv div) {
        ResponseData<ImageJohoMaskingDiv> response = new ResponseData<>();

        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("DemoCity.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));
        if (cg.getAsRString("保険者番号").equalsIgnoreCase(new RString("152264"))) {
            div.getShoriTaishoshaKensakuShiji().getDdlHokensha().setSelectedItem(new RString("2"));
            hokenshaMeisho = new RString("南魚沼市");
        } else {
            div.getShoriTaishoshaKensakuShiji().getDdlHokensha().setSelectedItem(new RString("1"));
            hokenshaMeisho = new RString("電算市");
        }

        div.getShoriTaishoshaKensakuShiji().getTxtSearchStYMD().setValue(FlexibleDate.getNowDate());
        div.getShoriTaishoshaKensakuShiji().getTxtHihokenshaNo().setDisplayNone(true);

        response.data = div;
        return response;
    }

    /**
     * 画像保存ボタンを押下した時の処理を表します。
     *
     * @param div イメージ情報マスキング処理Div
     * @return ResponseData
     */
    public ResponseData onClick_btnUpdate(ImageJohoMaskingDiv div) {
        ResponseData<ImageJohoMaskingDiv> response = new ResponseData<>();

        response.addMessage(new InformationMessage("i", "保存しました。"));

        response.data = div;
        return response;
    }

    /**
     * 検索指示Div上の検索対象ddlの選択内容を変更した時の処理内容を表します。
     *
     * @param div イメージ情報マスキング処理Div
     * @return ResponseData
     */
    public ResponseData onChange_ddlKensakuTaisho(ImageJohoMaskingDiv div) {
        ResponseData<ImageJohoMaskingDiv> response = new ResponseData<>();

        if (div.getShoriTaishoshaKensakuShiji().getDdlKensakuTaisho().getSelectedValue().
                equalsIgnoreCase(new RString("被保険者番号"))) {
            div.getShoriTaishoshaKensakuShiji().getTxtSearchStYMD().setDisplayNone(true);
            div.getShoriTaishoshaKensakuShiji().getTxtSearchEdYMD().setDisplayNone(true);
            div.getShoriTaishoshaKensakuShiji().getTxtHihokenshaNo().setDisplayNone(false);
        } else {
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
     * @param div イメージ情報マスキング処理Div
     * @return ResponseData
     */
    public ResponseData onChange_txtSearchStYMD(ImageJohoMaskingDiv div) {
        ResponseData<ImageJohoMaskingDiv> response = new ResponseData<>();

        div.getShoriTaishoshaKensakuShiji().getTxtSearchEdYMD().setValue(
                div.getShoriTaishoshaKensakuShiji().getTxtSearchStYMD().getValue());
        div.getShoriTaishoshaKensakuShiji().getTxtHihokenshaNo().setDisplayNone(true);

        response.data = div;
        return response;
    }

    /**
     * 検索指示Div上の検索するボタンを押下した時の処理内容を表します。
     *
     * @param div イメージ情報マスキング処理Div
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

    /**
     * 検索結果一覧DataGrid上の処理ボタンを押下した時の処理内容を表します。
     *
     * @param div イメージ情報マスキング処理Div
     * @return ResponseData
     */
    public ResponseData onClick_btnSentaku(ImageJohoMaskingDiv div) {
        ResponseData<ImageJohoMaskingDiv> response = new ResponseData<>();

        dgImageMaskShoriTaishosha_Row dataRow = div.getShoriTaishoshaIchiran().getDgImageMaskShoriTaishosha().
                getClickedItem();

        div.getHihokenshaJoho().getTxtHokenshaNo().setValue(dataRow.get保険者番号());
        div.getHihokenshaJoho().getTxtHokenshaMeisho().setValue(dataRow.get保険者());
        div.getHihokenshaJoho().getTxtBirthDay().setValue(new RDate(dataRow.get生年月日().getValue().toString()));
        div.getHihokenshaJoho().getTxtHihokenshaKubun().setValue(dataRow.get被保険者区分());
        div.getHihokenshaJoho().getTxtHihokenshaNo().setValue(dataRow.get被保番号());
        div.getHihokenshaJoho().getTxtHihokenshaShimei().setValue(dataRow.get氏名());
        div.getHihokenshaJoho().getTxtNenrei().setValue(dataRow.get年齢());
        div.getHihokenshaJoho().getTxtNinteiShinseiYMD().setValue(dataRow.get申請日().getValue());
        div.getHihokenshaJoho().getTxtShinseiKubun().setValue(dataRow.get申請区分());
        div.getHihokenshaJoho().getTxtZenYukokikanEnd().setValue(dataRow.get前回認定期間終了日().getValue());
        div.getHihokenshaJoho().getTxtZenYukokikanStart().setValue(dataRow.get前回認定期間開始日().getValue());
        div.getHihokenshaJoho().getTxtZenkaiYokaigodo().setValue(dataRow.get前回認定結果());

        response.data = div;
        return response;
    }

    private List<dgImageMaskShoriTaishosha_Row> createRowSearchResultTestData(RString ymlData) {
        List<dgImageMaskShoriTaishosha_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(ymlData);
        for (Map info : targetSource) {
            arrayData.add(toDgImageMaskShoriTaishosha_Row(info));
        }

        return arrayData;
    }

    private dgImageMaskShoriTaishosha_Row toDgImageMaskShoriTaishosha_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        RString hihokenshaNo = cg.getAsRString("被保番号");
        RString shimei = cg.getAsRString("氏名");
        TextBoxFlexibleDate shinseiDate = cg.getAsTextBoxFlexibleDate("申請日");
        RString shinseiKubun = cg.getAsRString("申請区分");
        RString maskKubun = cg.getAsRString("マスク処理");
        TextBoxFlexibleDate ikenDate = cg.getAsTextBoxFlexibleDate("意見書受領日");
        TextBoxFlexibleDate chosaDate = cg.getAsTextBoxFlexibleDate("調査票受領日");
        TextBoxFlexibleDate shinsaDate = cg.getAsTextBoxFlexibleDate("審査予定日");
        RString hokenshaNo = cg.getAsRString("保険者番号");
        RString hihokenshaKubun = cg.getAsRString("被保険者区分");
        TextBoxFlexibleDate umareDate = cg.getAsTextBoxFlexibleDate("生年月日");
        RString nenrei = cg.getAsRString("年齢");
        RString zenkaiKekka = cg.getAsRString("前回認定結果");
        TextBoxFlexibleDate zenStartDate = cg.getAsTextBoxFlexibleDate("前回認定期間開始日");
        TextBoxFlexibleDate zenEndDate = cg.getAsTextBoxFlexibleDate("前回認定期間終了日");
        Button btn = new Button();
        dgImageMaskShoriTaishosha_Row row = new dgImageMaskShoriTaishosha_Row(btn, hokenshaMeisho, hihokenshaNo, shimei,
                shinseiDate, shinseiKubun, shinsaDate, maskKubun, ikenDate, chosaDate, hokenshaNo, hihokenshaKubun,
                umareDate, nenrei, zenkaiKekka, zenStartDate, zenEndDate);
        return row;
    }

}
