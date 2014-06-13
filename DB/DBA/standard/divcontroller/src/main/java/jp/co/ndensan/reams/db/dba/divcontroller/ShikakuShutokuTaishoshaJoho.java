/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuShutokuTaishoshaDbJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuShutokuTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.tblAtenaSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8178 城間篤人
 */
public class ShikakuShutokuTaishoshaJoho {

    private static final RString SHIKAKU_KANRI_TAISHOSHA = new RString("DBA1010011/ShikakuKanriTaishoshaData.yml");

    /**
     * 資格取得処理を行う際に実行されます。<br/>
     * 被保険者検索親Divで選択された、処理対象の識別コードを受けとり、それを元に被保険者の情報を表示します。
     *
     * @param taishoshaJohoDiv 資格関連処理対象者情報
     * @return レスポンス
     */
    public ResponseData onLoad(ShikakuShutokuTaishoshaJohoDiv taishoshaJohoDiv) {
        ResponseData<ShikakuShutokuTaishoshaJohoDiv> response = new ResponseData<>();
        setTaishoshaData(taishoshaJohoDiv);
        response.data = taishoshaJohoDiv;
        return response;
    }

    private void setTaishoshaData(ShikakuShutokuTaishoshaJohoDiv taishoshaJohoDiv) {
        RString shikibetsuCode = (RString) ViewStateHolder.get("shikibetsuCode", RString.class);
        List<HashMap> taishoshaDataList = YamlLoader.FOR_DBA.loadAsList(SHIKAKU_KANRI_TAISHOSHA);
        for (HashMap taishoshaData : taishoshaDataList) {
            if (taishoshaData.get("識別コード").equals(shikibetsuCode.toString())) {
                setAtenaJoho(taishoshaJohoDiv, taishoshaData);
                setDbJoho(taishoshaJohoDiv, taishoshaData);
            }
        }
    }

    private void setAtenaJoho(ShikakuShutokuTaishoshaJohoDiv taishoshaJohoDiv, HashMap taishoshaData) {
        AtenaShokaiSimpleDiv commonJoho = taishoshaJohoDiv.getShikakuShutokuTaishoshaCommonJoho();
        commonJoho.getTxtAtenaKanaMeisho().setValue(new RString(taishoshaData.get("カナ氏名").toString()));
        commonJoho.getTxtAtenaMeisho().setValue(new RString(taishoshaData.get("氏名").toString()));
        commonJoho.getTxtGyoseiku().setValue(new RString(taishoshaData.get("行政区").toString()));
        commonJoho.getTxtJuminJotai().setValue(new RString(taishoshaData.get("住民状態").toString()));
        commonJoho.getTxtNihonjinGaikokujin().setValue(new RString(taishoshaData.get("住民種別").toString()));
        commonJoho.getTxtJusho().setValue(new RString(taishoshaData.get("住所").toString()));
        commonJoho.getTxtKojinHojinCode().setValue(new RString(taishoshaData.get("個人法人コード").toString()));
        commonJoho.getTxtNenrei().setValue(new RString(taishoshaData.get("年齢").toString()));
        commonJoho.getTxtSeibetsu().setValue(new RString(taishoshaData.get("性別").toString()));
        commonJoho.getTxtSeinengappiYMD().setValue(new RDate(taishoshaData.get("生年月日").toString()));
        commonJoho.getTxtSetaiCode().setValue(new RString(taishoshaData.get("世帯コード").toString()));
        commonJoho.getTxtShikibetsuCode().setValue(new RString(taishoshaData.get("識別コード").toString()));
        commonJoho.getTxtYubinNo().setValue(new YubinNo(taishoshaData.get("郵便番号").toString()));
    }

    private void setDbJoho(ShikakuShutokuTaishoshaJohoDiv taishoshaJohoDiv, HashMap taishoshaData) throws IllegalArgumentException {
        ShikakuShutokuTaishoshaDbJohoDiv dbJohoDiv = taishoshaJohoDiv.getShikakuShutokuTaishoshaDbJoho();
        dbJohoDiv.getTxtHihokenshaNo().setValue(new RString(taishoshaData.get("被保番号").toString()));
        dbJohoDiv.getTxtKyuShichoson().setValue(new RString(taishoshaData.get("旧市町村").toString()));
        dbJohoDiv.getTxtNinteiKikan().setFromValue(new RDate(taishoshaData.get("認定期間開始").toString()));
        if (taishoshaData.get("認定期間終了") != null) {
            dbJohoDiv.getTxtNinteiKikan().setToValue(new RDate(taishoshaData.get("認定期間終了").toString()));
        }
        dbJohoDiv.getTxtYokaigodo().setValue(new RString(taishoshaData.get("要介護度").toString()));
    }

}
