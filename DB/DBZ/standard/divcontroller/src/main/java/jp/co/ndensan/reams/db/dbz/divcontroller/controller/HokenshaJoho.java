/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hokenshajoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8178 城間篤人
 */
public class HokenshaJoho {

    private static final RString HOKENSHA_DATA = new RString("hokenshaData/hokenshaData.yml");

    /**
     * 措置元の保険者番号が入力された際、その情報に一致する保険者が存在した場合に、一致した保険者の名称を表示します。
     *
     * @param johoDiv 保険者情報Div
     * @return レスポンス
     */
    public ResponseData onBlur_txtHokenshaNo(HokenshaJohoDiv johoDiv) {
        ResponseData<HokenshaJohoDiv> response = new ResponseData<>();

        RString hokenshaMeisho = getMatchHokensha(johoDiv);
        johoDiv.getTxtHokenshaMeisho().setValue(hokenshaMeisho);

        response.data = johoDiv;
        return response;
    }

    private RString getMatchHokensha(HokenshaJohoDiv johoDiv) {
        List<HashMap> kenList = YamlLoader.DBZ.loadAsList(HOKENSHA_DATA);
        RString 保険者番号 = johoDiv.getTxtHokenshaNo().getValue();
        RString 保険者名称 = RString.EMPTY;

        for (HashMap kenDetail : kenList) {
            保険者名称 = getMatchHokenshaMeisho(kenDetail, 保険者番号, 保険者名称);
        }

        return 保険者名称;
    }

    private RString getMatchHokenshaMeisho(HashMap kenDetail, RString 保険者番号, RString 保険者名称) {
        List<HashMap> hokenshaList = (List<HashMap>) kenDetail.get("保険者");
        for (HashMap hokenshaDetail : hokenshaList) {
            if (hokenshaDetail.get("保険者番号").toString().equals(保険者番号.toString())) {
                return new RString(hokenshaDetail.get("保険者名称").toString());
            }
        }
        return 保険者名称;
    }
}
