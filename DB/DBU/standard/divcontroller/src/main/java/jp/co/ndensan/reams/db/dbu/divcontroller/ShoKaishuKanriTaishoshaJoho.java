/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.SearchShoKaishuKanriDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.ShoKaishuKanriTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証回収記録管理対象者の情報を表示するDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class ShoKaishuKanriTaishoshaJoho {

    private final static RString HIHOKENSHA_DATA = new RString("dbu0500011/HihokenshaData.yml");

    /**
     * 証回収状況検索結果グリッドから、処理の対象とするデータを1つ選んだときに実行されます。<br/>
     * 処理対象者の詳細情報を表示します。
     *
     * @param taishoshaJohoDiv 対象者情報Div
     * @param searchDiv　証回収状況検索Div
     * @return レスポンス
     */
    public ResponseData onSelectBySelectButton_SearchResultShoKaishuJokyoList(ShoKaishuKanriTaishoshaJohoDiv taishoshaJohoDiv,
            SearchShoKaishuKanriDiv searchDiv) {
        ResponseData<ShoKaishuKanriTaishoshaJohoDiv> response = new ResponseData<>();

//        RString hihokenshaNo = searchResultDiv.getHihokenshaNo();
        HashMap yamlData = YamlLoader.DBU.loadAsList(HIHOKENSHA_DATA).get(0);
        ControlGenerator generator = new ControlGenerator(yamlData);

        //宛名照会 識別コード設定
//        AtenaShokaiSimple.setData(taishoshaJohoDiv.getShoKaishuKanriTaishoshaCommonJoho().getAtenaInfo(),
//                new ShikibetsuCode(generator.getAsRString("識別番号")));
//        
        setTaishoshaDbData(taishoshaJohoDiv.getCcdKaigoShikakuKihon(), generator, searchDiv);

//        List<HashMap> yamlDataList = YamlLoader.DBU.loadAsList(HIHOKENSHA_DATA);
//
//        for (HashMap yamlData : yamlDataList) {
//            ControlGenerator generator = new ControlGenerator(yamlData);
//            if (hihokenshaNo != null && hihokenshaNo.equals(generator.getAsRString("被保番号"))) {
//                //setTaishoshaCommonData(taishoshaJohoDiv.getShoKaishuKanriTaishoshaCommonJoho(), generator);
//                setTaishoshaDbData(taishoshaJohoDiv.getCcdKaigoShikakuKihon(), generator);
//            }
//        }
        response.data = taishoshaJohoDiv;
        return response;
    }

//    private void setTaishoshaCommonData(AtenaShokaiSimpleDiv taishoshaCommonJoho, ControlGenerator generator) {
//        taishoshaCommonJoho.getTxtAtenaKanaMeisho().setValue(generator.getAsRString("カナ氏名"));
//        taishoshaCommonJoho.getTxtAtenaMeisho().setValue(generator.getAsRString("氏名"));
//        taishoshaCommonJoho.getTxtGyoseiku().setValue(generator.getAsRString("行政区"));
//        taishoshaCommonJoho.getTxtJuminJotai().setValue(generator.getAsRString("住民状態"));
//        taishoshaCommonJoho.getTxtJusho().setValue(generator.getAsRString("住所"));
//        taishoshaCommonJoho.getTxtKojinHojinCode().setValue(generator.getAsRString("個人法人コード"));
//        taishoshaCommonJoho.getTxtNenrei().setValue(generator.getAsRString("年齢"));
//        taishoshaCommonJoho.getTxtSeibetsu().setValue(generator.getAsRString("性別"));
//        taishoshaCommonJoho.getTxtSeinengappiYMD().setValue(generator.getAsRDate("生年月日"));
//        taishoshaCommonJoho.getTxtSetaiCode().setValue(generator.getAsRString("世帯コード"));
//        taishoshaCommonJoho.getTxtShikibetsuCode().setValue(generator.getAsRString("識別番号"));
//        taishoshaCommonJoho.getTxtYubinNo().setValue(new YubinNo(generator.getAsRString("郵便番号")));
//    }
    private void setTaishoshaDbData(KaigoShikakuKihonDiv shikakuKihonJoho, ControlGenerator generator,
            SearchShoKaishuKanriDiv searchDiv) {

        shikakuKihonJoho.getTxtHihokenshaNo().setValue(searchDiv.getTxtSearchHihokenshaNo().getValue());
        shikakuKihonJoho.getTxtShutokuYmd().setValue(generator.getAsRDate("資格取得日"));
        shikakuKihonJoho.getTxtShutokuJiyu().setValue(generator.getAsRString("取得事由"));
        shikakuKihonJoho.getTxtSoshitsuYmd().setValue(generator.getAsRDate("資格喪失日"));
        shikakuKihonJoho.getTxtSoshitsuJiyu().setValue(generator.getAsRString("喪失事由"));
        shikakuKihonJoho.getTxtJutokuKubun().setValue(generator.getAsRString("住特区分"));
        shikakuKihonJoho.getTxtYokaigoJotaiKubun().setValue(generator.getAsRString("要介護度"));
        shikakuKihonJoho.getTxtNinteiKaishiYmd().setValue(generator.getAsRDate("認定期間開始"));
        shikakuKihonJoho.getTxtNinteiShuryoYmd().setValue(generator.getAsRDate("認定期間終了"));

    }
}
