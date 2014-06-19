/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011.TajutokuTaishosaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011.TajutokuTaishoshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8178 城間篤人
 */
public class TajutokuTaishosaJoho {

    private static final RString SHIKAKU_KANRI_TAISHOSHA = new RString("DBA2040011/hihokenshaShokaiDbJoho.yml");

    /**
     * 資格取得処理を行う際に実行されます。<br/>
     * 対象者検索で選択された個人の情報を元に、被保険者の基本情報を表示します。
     *
     * @param taishoshaJohoDiv 資格関連処理対象者情報
     * @param searchDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnToDecide(TajutokuTaishosaJohoDiv taishoshaJohoDiv, TajutokuTaishoshaSearchDiv searchDiv) {
        ResponseData<TajutokuTaishosaJohoDiv> response = new ResponseData<>();

        RString shikibetsuCode = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getShikibetsuCode();
        AtenaShokaiSimple.setData(taishoshaJohoDiv.getAtenaJoho(), new ShikibetsuCode(shikibetsuCode));

        RString hihokenshaNo = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getHihokenshaNo();
        setTaishoshaData(taishoshaJohoDiv, hihokenshaNo);

        response.data = taishoshaJohoDiv;
        return response;
    }

    private void setTaishoshaData(TajutokuTaishosaJohoDiv taishoshaJohoDiv, RString hihokenshaNo) {
        List< HashMap> taishoshaDataList = YamlLoader.DBA.loadAsList(SHIKAKU_KANRI_TAISHOSHA);
        for (HashMap taishoshaData : taishoshaDataList) {
            if (taishoshaData.get("被保番号").equals(hihokenshaNo.toString())) {
                setDbJoho(taishoshaJohoDiv.getKaigoShikakuJoho(), new ControlGenerator(taishoshaData));
            }
        }
    }

    private void setDbJoho(KaigoShikakuKihonDiv dbJoho, ControlGenerator generator) {
        dbJoho.getTxtHihokenshaNo().setValue(generator.getAsRString("被保番号"));
        dbJoho.getTxtShikakuJotai().setValue(generator.getAsRString("資格状態"));
        dbJoho.getTxtShutokuYmd().setValue(generator.getAsRDate("資格取得"));
        dbJoho.getTxtShutokuJiyu().setValue(generator.getAsRString("取得事由"));
        dbJoho.getTxtSoshitsuYmd().setValue(generator.getAsRDate("資格喪失"));
        dbJoho.getTxtSoshitsuJiyu().setValue(generator.getAsRString("喪失事由"));
        dbJoho.getTxtKyuSochiNyusho().setValue(generator.getAsRString("旧措置入所"));
        dbJoho.getTxtJutokuTekiyo().setValue(generator.getAsRDate("住特開始"));
        dbJoho.getTxtJutokuKaijo().setValue(generator.getAsRDate("住特終了"));
        dbJoho.getTxtYokaigoJotaiKubun().setValue(generator.getAsRString("要介護認定"));
        dbJoho.getTxtNinteiKikan().setFromValue(generator.getAsRDate("認定開始"));
        dbJoho.getTxtNinteiKikan().setToValue(generator.getAsRDate("認定終了"));
    }

}
