/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShikaiTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiTaishoSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 被保険者照会対象者の基本情報を表示するパネルのコントローラです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaShikaiTaishoshaJoho {

    private static final RString GAITOSHA_DATA = new RString("DBA4010011/hihokenshaShokaiDbJoho.yml");

    /**
     * 該当者一覧から、被保険者照会の対象となる被保険者を選択した際に実行されます。<br/>
     * 選択した対象者の識別コードと被保番号を元に、基本情報を表示します。
     *
     * @param johoDiv 対象者基本情報Div
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToDecide(HihokenshaShikaiTaishoshaJohoDiv johoDiv, HihokenshaShokaiTaishoSearchDiv searchDiv) {
        ResponseData<HihokenshaShikaiTaishoshaJohoDiv> response = new ResponseData<>();

        RString shikibetsuCode = (RString) ViewStateHolder.get("shikibetsuCode", RString.class);
        RString hihokenshaNo = (RString) ViewStateHolder.get("hihokenshaNo", RString.class);

        AtenaShokaiSimple.setData(johoDiv.getHihokenshaShokaiCommonJoho().getAtenaInfo(), new ShikibetsuCode(shikibetsuCode));
        setDbData(johoDiv.getHihokenshaShokaiDbJoho(), hihokenshaNo);
        response.data = johoDiv;
        return response;
    }

    private void setDbData(KaigoShikakuKihonDiv dbJoho, RString hihokenshaNo) {
        List<HashMap> yamlDbDataList = YamlLoader.DBA.loadAsList(GAITOSHA_DATA);
        for (HashMap yamlDbData : yamlDbDataList) {
            ControlGenerator generator = new ControlGenerator(yamlDbData);
            if (generator.getAsRString("被保番号").equals(hihokenshaNo)) {
                setDbJoho(dbJoho, generator);
                break;
            }
        }
    }

    private void setDbJoho(KaigoShikakuKihonDiv dbJoho, ControlGenerator generator) {
        dbJoho.getTxtHihokenshaNo().setValue(generator.getAsRString("被保番号"));
        dbJoho.getTxtShutokuYmd().setValue(generator.getAsRDate("資格取得"));
        dbJoho.getTxtShutokuJiyu().setValue(generator.getAsRString("取得事由"));
        dbJoho.getTxtSoshitsuYmd().setValue(generator.getAsRDate("資格喪失"));
        dbJoho.getTxtSoshitsuJiyu().setValue(generator.getAsRString("喪失事由"));
        dbJoho.getTxtJutokuKubun().setValue(generator.getAsRString("住特区分"));
        dbJoho.getTxtYokaigoJotaiKubun().setValue(generator.getAsRString("要介護認定"));
        dbJoho.getTxtNinteiKaishiYmd().setValue(generator.getAsRDate("認定開始"));
        dbJoho.getTxtNinteiShuryoYmd().setValue(generator.getAsRDate("認定終了"));
    }
}
