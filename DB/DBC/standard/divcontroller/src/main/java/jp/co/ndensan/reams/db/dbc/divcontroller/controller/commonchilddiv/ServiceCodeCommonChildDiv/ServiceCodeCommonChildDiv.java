/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ServiceCodeCommonChildDiv;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeCommonChildDiv.ServiceCodeCommonChildDiv.ServiceCodeCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeCommonChildDiv.ServiceCodeCommonChildDiv.ServiceCodeCommonChildDivHandler;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.definition.mybatis.param.servicecode.SabisuKodoParameter;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 *
 * サービスコード検索一覧のコントローラです。
 * @reamsid_L DBA-0060-010 dongyabin
 */
public class ServiceCodeCommonChildDiv {

    private final KaigoServiceNaiyouManager service;

    /**
     * コンストラクタです。
     */
    public ServiceCodeCommonChildDiv() {
        service = KaigoServiceNaiyouManager.createInstance();
    }

    /**
     * サービスコード検索一覧初期化の設定します。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<ServiceCodeCommonChildDivDiv>  initialize(ServiceCodeCommonChildDivDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービスコードを検索する」ボタンをクリックの設定します。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<ServiceCodeCommonChildDivDiv> onClick_Kensaku(ServiceCodeCommonChildDivDiv div) {
        FlexibleYearMonth kijunYmFlex = FlexibleYearMonth.EMPTY;
        if (div.getTxtKijunYM().getValue() != null) {
            kijunYmFlex = new FlexibleYearMonth(div.getTxtKijunYM().getValue().getYearMonth().toDateString());
            kijunYmFlex.wareki().fillType(FillType.NONE);
        }
        SabisuKodoParameter param = SabisuKodoParameter.createSearchParam(div.getTxtServiceCode().getValue(),
                div.getTxtKomokuCode().getValue(), kijunYmFlex);
        List<KaigoServiceNaiyou> list = service.getServiceCodeList(param);
        getHandler(div).initialize(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 「やめる」ボタンをクリック場合、画面が閉じるします。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<ServiceCodeCommonChildDivDiv> onClick_btnYameru(ServiceCodeCommonChildDivDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }
    /**
     * 「確定する」ボタンをクリック場合、画面遷移が表示します。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<ServiceCodeCommonChildDivDiv> onClick_btnKakutei(ServiceCodeCommonChildDivDiv div) {
        if (div.getDgCodeIchiran().getClickedItem() == null) {
            return ResponseData.of(div).addValidationMessages(getHandler(div).addMessage()).respond();
        }
        getHandler(div).onClick_btnKakutei();
        return ResponseData.of(div).dialogOKClose();
    }

    private ServiceCodeCommonChildDivHandler getHandler(ServiceCodeCommonChildDivDiv div) {
        return new ServiceCodeCommonChildDivHandler(div);
    }
}
