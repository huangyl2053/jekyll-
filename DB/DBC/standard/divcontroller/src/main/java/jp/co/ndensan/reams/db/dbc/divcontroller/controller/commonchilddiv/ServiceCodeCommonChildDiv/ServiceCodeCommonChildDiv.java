/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ServiceCodeCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.servicecode.ServiceCodeModel;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeCommonChildDiv.ServiceCodeCommonChildDiv.ServiceCodeCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeCommonChildDiv.ServiceCodeCommonChildDiv.ServiceCodeCommonChildDivHandler;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.servicecode.SabisuKodoParameter;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * サービスコード検索一覧のコントローラです。
 *
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
    public ResponseData<ServiceCodeCommonChildDivDiv> initialize(ServiceCodeCommonChildDivDiv div) {
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
        ServiceCodeModel model = DataPassingConverter.deserialize(div.getServiceCodeModel(), ServiceCodeModel.class);
        FlexibleYearMonth kijunYmFlex;
        List<KaigoServiceNaiyou> list;
        if (!RString.isNullOrEmpty(div.getTxtServiceCode().getValue())
                && !RString.isNullOrEmpty(div.getTxtKomokuCode().getValue())
                && div.getTxtKijunYM().getValue() != null) {
            if (div.getTxtKijunYM().getValue() == null) {
                kijunYmFlex = FlexibleYearMonth.EMPTY;
            } else {
                kijunYmFlex = new FlexibleYearMonth(div.getTxtKijunYM().getValue().getYearMonth().toDateString());
            }
            SabisuKodoParameter param = SabisuKodoParameter.createSearchParam(div.getTxtServiceCode().getValue(),
                    div.getTxtKomokuCode().getValue(), kijunYmFlex);
            list = service.getServiceCodeList(param);
        } else {
            FlexibleYearMonth 基準年月 = FlexibleYearMonth.EMPTY;
            if (model.get基準年月() != null) {
                基準年月 = model.get基準年月();
            }
            List<RString> サービス種類リスト = new ArrayList<>();
            if (model.getサービス種類リスト() != null) {
                サービス種類リスト = model.getサービス種類リスト();
            }
            List<RString> サービス分類リスト = new ArrayList<>();
            if (model.getサービス分類リスト() != null) {
                サービス分類リスト = model.getサービス分類リスト();
            }
            RString 抽出パターン = RString.EMPTY;
            if (model.get抽出パターン() != null) {
                抽出パターン = model.get抽出パターン();
            }
            if (!サービス種類リスト.isEmpty()
                    || (サービス分類リスト.isEmpty() && RString.isNullOrEmpty(抽出パターン))) {
                list = service.getServiceCodeList2(基準年月, サービス種類リスト).records();
            } else if (!RString.isNullOrEmpty(抽出パターン)) {
                list = service.getServiceCodeList3(基準年月, 抽出パターン).records();
            } else {
                list = service.getServiceCodeList4(基準年月, サービス分類リスト).records();
            }
        }
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
