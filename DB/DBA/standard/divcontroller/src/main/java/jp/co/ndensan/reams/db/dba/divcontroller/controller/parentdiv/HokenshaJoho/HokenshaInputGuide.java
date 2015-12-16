/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.HokenshaJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokensha.HokenshaMapperParameter;
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

    private static RString kenCode;

    /**
     * 「保険者検索」ボタンされます。<br/>
     * 選択行の情報を明細エリアに表示します。
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
        HokenshaMapperParameter parameter = HokenshaMapperParameter.createKenCodeParam(kenCode);
        List<Hokensha> hokenjaList = HokenshaNyuryokuHojoFinder.createInstance().getHokenshaList(parameter).records();
        List<KenCodeJigyoshaInputGuide> kenCodeList = HokenshaNyuryokuHojoFinder.createInstance().getKenCodeJigyoshaInputGuide().records();
        getHandler(div).on保険者検索(hokenjaList, kenCodeList, kenCode);
        responseData.data = div;
        return responseData;
    }

    /**
     * 証回収状況Listの1行を選択した際に実行されます。<br/>
     * 選択行の情報を明細エリアに表示します。
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
     * 証回収状況Listの1行を選択した際に実行されます。<br/>
     * 選択行の情報を明細エリアに表示します。
     *
     * @param div {@link HokenshaInputGuideDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaInputGuideDiv> click_btnSearchGaitoHokensha(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaInputGuideDiv> responseData = new ResponseData<>();
        kenCode = div.getDdlHokenshaKenCode().getSelectedKey();
        HokenshaMapperParameter parameter = HokenshaMapperParameter.createKenCodeParam(kenCode);
        List<Hokensha> hokenjaList = HokenshaNyuryokuHojoFinder.createInstance().getHokenshaList(parameter).records();
        getHandler(div).on保険者を表示する(hokenjaList);
        responseData.data = div;
        return responseData;
    }

    private HokenshaInputGuideHandler getHandler(HokenshaInputGuideDiv div) {
        return new HokenshaInputGuideHandler(div);
    }
}
