/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.HokenshaJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaInputGuide.HokenshaInputGuideDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaInputGuide.HokenshaInputGuideHandler;
import jp.co.ndensan.reams.db.dba.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 保険者入力補助のダイアログのDivControllerです
 */
public class HokenshaInputGuide {

    private RString kenCode;

    /**
     * 「保険者検索」ボタン保険者一覧Grid更新します。
     *
     * @param div {@link HokenshaInputGuideDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaInputGuideDiv> click_btnHokenshaSelect(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaInputGuideDiv> responseData = new ResponseData<>();
        if (div.getHokenshaNo().isEmpty()) {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            kenCode = new RString(association.get地方公共団体コード().toString().substring(0, 2));
        } else {
            kenCode = new RString(div.getHokenshaNo().toString().substring(0, 2));
        }
        List<Hokensha> hokenshaList = HokenshaNyuryokuHojoFinder.createInstance().getHokenshaList(kenCode).records();
        List<KenCodeJigyoshaInputGuide> kenCodeList = HokenshaNyuryokuHojoFinder.createInstance().getKenCodeJigyoshaInputGuide().records();
        getHandler(div).on保険者検索(hokenshaList, kenCodeList, kenCode);
        responseData.data = div;
        return responseData;
    }

    /**
     * 「選択」ボタン保険者コードと保険者名がセットします。
     *
     * @param div {@link HokenshaInputGuideDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaInputGuideDiv> click_btnSenTakuHokensha(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaInputGuideDiv> responseData = new ResponseData<>();
        getHandler(div).on選択(div);
        responseData.data = div;
        return responseData;
    }

    /**
     * 「保険者を表示する」ボタン保険者一覧Grid更新します。
     *
     * @param div {@link HokenshaInputGuideDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaInputGuideDiv> click_btnSearchGaitoHokensha(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaInputGuideDiv> responseData = new ResponseData<>();
        kenCode = div.getDdlHokenshaKenCode().getSelectedKey();
        List<Hokensha> hokenshaList = HokenshaNyuryokuHojoFinder.createInstance().getHokenshaList(kenCode).records();
        getHandler(div).on保険者を表示する(hokenshaList);
        responseData.data = div;
        return responseData;
    }

    private HokenshaInputGuideHandler getHandler(HokenshaInputGuideDiv div) {
        return new HokenshaInputGuideHandler(div);
    }
}
