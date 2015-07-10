/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.controller.helper.DemoKojin;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuShutokuSearchDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuShutokuTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.commonchilddiv.atenashokaisimple.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 資格取得処理の対象者情報を表示するためのDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuShutokuTaishoshaJoho {

    private static final RString SHIKAKU_KANRI_TAISHOSHA = new RString("DBA1010011/hihokenshaShokaiDbJoho.yml");

    /**
     * 資格取得処理を行う際に実行されます。<br/>
     * 対象者検索で選択された個人の情報を元に、被保険者の基本情報を表示します。
     *
     * @param taishoshaJohoDiv 資格関連処理対象者情報
     * @param searchDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnToDecide(ShikakuShutokuTaishoshaJohoDiv taishoshaJohoDiv, ShikakuShutokuSearchDiv searchDiv) {
        ResponseData<ShikakuShutokuTaishoshaJohoDiv> response = new ResponseData<>();

        DemoKojin demoKojin = new DemoKojin("第2号");
        RString shikibetsuCode = demoKojin.getShikibetsuCode();
        RString hihokenshaNo = demoKojin.getHihokenshaNo();
//        AtenaShokaiSimple.setData(taishoshaJohoDiv.getShikakuShutokuCommonJoho().getAtenaInfo(), new ShikibetsuCode(shikibetsuCode));
        setTaishoshaData(taishoshaJohoDiv, hihokenshaNo);

        response.data = taishoshaJohoDiv;
        return response;
    }

    private void setTaishoshaData(ShikakuShutokuTaishoshaJohoDiv taishoshaJohoDiv, RString hihokenshaNo) {
        List< HashMap> taishoshaDataList = YamlLoader.DBA.loadAsList(SHIKAKU_KANRI_TAISHOSHA);
        for (HashMap taishoshaData : taishoshaDataList) {
            if (taishoshaData.get("被保番号").equals(hihokenshaNo.toString())) {
                setDbJoho(taishoshaJohoDiv.getShikakuShutokuDbJoho(), new ControlGenerator(taishoshaData));
            }
        }
    }

    private void setDbJoho(KaigoShikakuKihonDiv dbJoho, ControlGenerator generator) {
        dbJoho.getTxtHihokenshaNo().setValue(generator.getAsRString("被保番号"));
        dbJoho.getTxtShutokuYmd().setValue(generator.getAsFlexibleDate("資格取得"));
        dbJoho.getTxtShutokuJiyu().setValue(generator.getAsRString("取得事由"));
        dbJoho.getTxtSoshitsuYmd().setValue(generator.getAsFlexibleDate("資格喪失"));
        dbJoho.getTxtSoshitsuJiyu().setValue(generator.getAsRString("喪失事由"));
        dbJoho.getTxtJutokuKubun().setValue(generator.getAsRString("住特区分"));
        dbJoho.getTxtYokaigoJotaiKubun().setValue(generator.getAsRString("要介護認定"));
        dbJoho.getTxtNinteiKaishiYmd().setValue(generator.getAsRDate("認定開始"));
        dbJoho.getTxtNinteiShuryoYmd().setValue(generator.getAsRDate("認定終了"));
    }

}
