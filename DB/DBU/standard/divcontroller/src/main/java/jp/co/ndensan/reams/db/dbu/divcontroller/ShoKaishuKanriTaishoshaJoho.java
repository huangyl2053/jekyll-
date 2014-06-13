/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.SearchResultShoKaishuKanriDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.ShoKaishuKanriTaishoshaDbJohoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.ShoKaishuKanriTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証回収記録管理対象者の情報を表示するDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class ShoKaishuKanriTaishoshaJoho {

    private final static RString HIHOKENSHA_DATA = new RString("DBU0500011/HihokenshaData.yml");

    /**
     * 証回収状況検索結果グリッドから、処理の対象とするデータを1つ選んだときに実行されます。<br/>
     * 処理対象者の詳細情報を表示します。
     *
     * @param taishoshaJohoDiv 対象者情報Div
     * @param searchResultDiv　証回収状況検索結果Div
     * @return レスポンス
     */
    public ResponseData onSelectBySelectButton_SearchResultShoKaishuJokyoList(ShoKaishuKanriTaishoshaJohoDiv taishoshaJohoDiv,
            SearchResultShoKaishuKanriDiv searchResultDiv) {
        ResponseData<ShoKaishuKanriTaishoshaJohoDiv> response = new ResponseData<>();

        RString hihokenshaNo = searchResultDiv.getHihokenshaNo();
        List<HashMap> yamlDataList = YamlLoader.FOR_DBU.loadAsList(HIHOKENSHA_DATA);
        for (HashMap yamlData : yamlDataList) {
            ControlGenerator generator = new ControlGenerator(yamlData);
            if (hihokenshaNo != null && hihokenshaNo.equals(generator.getAsRString("被保番号"))) {
                setTaishoshaCommonData(taishoshaJohoDiv.getShoKaishuKanriTaishoshaCommonJoho(), generator);
                setTaishoshaDbData(taishoshaJohoDiv.getShoKaishuKanriTaishoshaDbJoho(), generator);
            }
        }

        response.data = taishoshaJohoDiv;
        return response;
    }

    private void setTaishoshaCommonData(AtenaShokaiSimpleDiv taishoshaCommonJoho, ControlGenerator generator) {
        taishoshaCommonJoho.getTxtAtenaKanaMeisho().setValue(generator.getAsRString("カナ氏名"));
        taishoshaCommonJoho.getTxtAtenaMeisho().setValue(generator.getAsRString("氏名"));
        taishoshaCommonJoho.getTxtGyoseiku().setValue(generator.getAsRString("行政区"));
        taishoshaCommonJoho.getTxtJuminJotai().setValue(generator.getAsRString("住民状態"));
        taishoshaCommonJoho.getTxtNihonjinGaikokujin().setValue(generator.getAsRString("住民種別"));
        taishoshaCommonJoho.getTxtJusho().setValue(generator.getAsRString("住所"));
        taishoshaCommonJoho.getTxtKojinHojinCode().setValue(generator.getAsRString("個人法人コード"));
        taishoshaCommonJoho.getTxtNenrei().setValue(generator.getAsRString("年齢"));
        taishoshaCommonJoho.getTxtSeibetsu().setValue(generator.getAsRString("性別"));
        taishoshaCommonJoho.getTxtSeinengappiYMD().setValue(generator.getAsRDate("生年月日"));
        taishoshaCommonJoho.getTxtSetaiCode().setValue(generator.getAsRString("世帯コード"));
        taishoshaCommonJoho.getTxtShikibetsuCode().setValue(generator.getAsRString("識別コード"));
        taishoshaCommonJoho.getTxtYubinNo().setValue(new YubinNo(generator.getAsRString("郵便番号")));
    }

    private void setTaishoshaDbData(ShoKaishuKanriTaishoshaDbJohoDiv taishoshaDbJoho, ControlGenerator generator) {
        taishoshaDbJoho.getTxtHihokenshaNo().setValue(generator.getAsRString("被保番号"));
        taishoshaDbJoho.getTxtKyuHihokenshaNo().setValue(generator.getAsRString("旧被保番号"));
        taishoshaDbJoho.getTxtKyuShichoson().setValue(generator.getAsRString("旧市町村"));
        taishoshaDbJoho.getTxtNinteiKikan().setFromValue(generator.getAsRDate("認定期間開始"));
        taishoshaDbJoho.getTxtNinteiKikan().setToValue(generator.getAsRDate("認定期間終了"));
        taishoshaDbJoho.getTxtYokaigodo().setValue(generator.getAsRString("要介護度"));
    }
}
