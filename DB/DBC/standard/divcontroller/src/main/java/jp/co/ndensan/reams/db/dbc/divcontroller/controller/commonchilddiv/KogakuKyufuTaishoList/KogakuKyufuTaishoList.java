/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.KogakuKyufuTaishoList;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuKyufuTaishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuKyufuTaishoListHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuKyufuTaishoListValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.ServiceJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ServiceTypeModel;
import jp.co.ndensan.reams.db.dbz.definition.core.kaigojigyoshano.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.jigyosha.JigyoshaInputGuideParameter;
import jp.co.ndensan.reams.db.dbz.service.core.jigyosha.JigyoshaInputGuideFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBCKD00006_高額給付対象一覧共有子Div
 *
 * @reamsid_L DBC-2020-030 quxiaodong
 */
public class KogakuKyufuTaishoList {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString ONE_RS = new RString("1");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final int INT_10 = 10;

    /**
     * 「「追加する」ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onClick_btnTsuika(
            KogakuKyufuTaishoListDiv div) {
        getHandler(div).画面制御(false);
        getHandler(div).set追加制御();
        getHandler(div).set明細合計区分制御();
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        getHandler(div).set追加修正制御(サービス提供年月);
        ViewStateHolder.put(ViewStateKeys.処理モード, 追加);
        return createResponse(div);
    }

    /**
     * データグリッドの修正ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onClick_modify(
            KogakuKyufuTaishoListDiv div) {
        getHandler(div).clear高額明細合計データ編集エリア();
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        getHandler(div).set高額明細合計データ編集エリア(サービス提供年月);
        getHandler(div).画面制御(false);
        getHandler(div).set追加修正制御(サービス提供年月);
        getHandler(div).set明細合計区分制御();
        if (ONE_RS.equals(div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().getSelectedKey())) {
            div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().setDisabled(true);
            div.getMeisaiGokeiHenshuPanel().getBtnJgyosha().setDisabled(true);
            div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().setDisabled(true);
            div.getMeisaiGokeiHenshuPanel().getBtnServiceSyurui().setDisabled(true);
        }
        div.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun().setDisabled(true);
        ViewStateHolder.put(ViewStateKeys.処理モード, 修正);
        return createResponse(div);
    }

    /**
     * データグリッドの削除ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onClick_delete(
            KogakuKyufuTaishoListDiv div) {
        getHandler(div).clear高額明細合計データ編集エリア();
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        getHandler(div).set高額明細合計データ編集エリア(サービス提供年月);
        getHandler(div).画面制御(true);
        getHandler(div).削除制御();
        getHandler(div).set明細合計区分制御();
        ViewStateHolder.put(ViewStateKeys.処理モード, 削除);
        return createResponse(div);
    }

    /**
     * 「事業者入力ガイド」ボタンを押した後のメソッドです。
     *
     * @param div KogakuKyufuTaishoListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onBeforeOpenDialog_btnJgyosha(
            KogakuKyufuTaishoListDiv div) {
        JigyoshaMode jigyoshaMode = new JigyoshaMode();
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
        jigyoshaMode.setJigyoshaNo(div.getTxtJgyoshaCode().getValue() == null || INT_10 != div.getTxtJgyoshaCode().getValue().length()
                ? jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo.EMPTY
                : new jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo(div.getTxtJgyoshaCode().getValue()));
        div.setJigyoshaMode(DataPassingConverter.serialize(jigyoshaMode));
        return createResponse(div);
    }

    /**
     * 「事業者入力ガイド」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onOkClose_btnJgyosha(
            KogakuKyufuTaishoListDiv div) {
        JigyoshaMode jigyoshaMode = DataPassingConverter.deserialize(div.
                getJigyoshaMode(), JigyoshaMode.class);
        if (jigyoshaMode.getJigyoshaNo() != null) {
            div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().setValue(jigyoshaMode.getJigyoshaNo().value());
        }
        if (jigyoshaMode.getJigyoshaName() != null) {
            div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().setValue(jigyoshaMode.getJigyoshaName().value());
        }
        return createResponse(div);
    }

    /**
     * 「サービス種類入力補助ボタン」ボタンを押した後のメソッドです。
     *
     * @param div KogakuKyufuTaishoListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onBeforeOpenDialog_btnServiceSyurui(
            KogakuKyufuTaishoListDiv div) {
        ServiceTypeModel serviceTypemodel = new ServiceTypeModel();
        serviceTypemodel.setサービス種類コード(div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue());
        div.setHdnServiceModel(DataPassingConverter.serialize(serviceTypemodel));
        return createResponse(div);
    }

    /**
     * 「事業者」ボタンを押した後のメソッドです。
     *
     * @param div KogakuKyufuTaishoListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onBlur_txtJgyoshaCode(
            KogakuKyufuTaishoListDiv div) {
        if (div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue() != null
                && !div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue().isEmpty()) {
            SearchResult<ServiceJigyoshaInputGuide> jigyosha = JigyoshaInputGuideFinder.
                    createInstance().getServiceJigyoshaInputGuide(
                            JigyoshaInputGuideParameter.createParam_ServiceJigyoshaInputGuide(new KaigoJigyoshaNo(
                                            div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue()),
                                    FlexibleDate.EMPTY, FlexibleDate.EMPTY, new AtenaMeisho(RString.EMPTY),
                                    new YubinNo(RString.EMPTY), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                                    RString.EMPTY, FlexibleDate.getNowDate(), RString.EMPTY, 0));
            if (jigyosha.records() != null && !jigyosha.records().isEmpty()
                    && jigyosha.records().get(0).get事業者名称() != null
                    && !jigyosha.records().get(0).get事業者名称().isEmpty()) {
                div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().setValue(
                        jigyosha.records().get(0).get事業者名称().value());
            } else {
                div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().clearValue();
            }
        } else {
            div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().clearValue();
        }
        return createResponse(div);
    }

    /**
     * 「サービス種類」ボタンを押した後のメソッドです。
     *
     * @param div KogakuKyufuTaishoListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onBlur_txtServiceSyurui(
            KogakuKyufuTaishoListDiv div) {
        if (div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue() != null
                && !div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue().isEmpty()) {
            SearchResult<KaigoServiceShurui> kalist = KaigoServiceShuruiManager.createInstance().
                    getServiceTypeList(KaigoServiceShuruiMapperParameter.createSelectByKeyParam(
                                    new ServiceShuruiCode(div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue()),
                                    new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString())));
            if (kalist.records() != null && !kalist.records().isEmpty()) {
                div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().setValue(
                        kalist.records().get(0).getサービス種類略称());
            } else {
                div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().clearValue();
            }
        } else {
            div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().clearValue();
        }
        return createResponse(div);
    }

    /**
     * 「サービス種類入力補助ボタン」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onOkClose_btnServiceSyurui(
            KogakuKyufuTaishoListDiv div) {
        RString 種類コード = div.getHdnServiceType();
        RString 種類 = div.getHdnServiceRyakusho();
        div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().setValue(種類コード);
        div.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName().setValue(種類);
        return createResponse(div);
    }

    /**
     * データグリッドの取消ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onClick_btnTorikeshi(
            KogakuKyufuTaishoListDiv div) {
        getHandler(div).画面制御(true);
        return createResponse(div);
    }

    /**
     * 明細合計区分ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onChange_rdbMisaiGkeiKbun(
            KogakuKyufuTaishoListDiv div) {
        getHandler(div).set明細合計区分制御();
        return createResponse(div);
    }

    /**
     * 老齢福祉年金ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onChange_rdbRoreiFukushiNenkin(
            KogakuKyufuTaishoListDiv div) {
        if (KEY0.equals(div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().getSelectedKey())) {
            div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().setSelectedKey(KEY1);
            div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setSelectedKey(KEY0);
        }
        return createResponse(div);
    }

    /**
     * 利用者負担第２段階ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onChange_rdbRiyoshafutanDai2dankai(
            KogakuKyufuTaishoListDiv div) {
        if (KEY0.equals(div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().getSelectedKey())) {
            div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setSelectedKey(KEY1);
            div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().setSelectedKey(KEY0);
        }
        return createResponse(div);
    }

    /**
     * 激変緩和区分ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onChange_rdbGekihenkanwaKubun(
            KogakuKyufuTaishoListDiv div) {
        if (!KEY0.equals(div.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun().getSelectedKey())) {
            div.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin().setSelectedKey(KEY1);
            div.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai().setSelectedKey(KEY1);
        }
        return createResponse(div);
    }

    /**
     * 確定するタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onClick_btnkakutei(
            KogakuKyufuTaishoListDiv div) {
        RString モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (!削除.equals(モード)) {
            validPairs = getCheckHandler(div).確定チェック(モード);
        }
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        dgTaishoshaIchiran_Row row;
        if (追加.equals(モード)) {
            row = new dgTaishoshaIchiran_Row();
        } else {
            row = getHandler(div).selectRow();
        }
        if (!ResponseHolder.isReRequest()) {
            if (削除.equals(モード)) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if ((new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                || new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()))
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).modifyRow(row, モード, サービス提供年月);
        } else {
            return createResponse(div);
        }
        getHandler(div).clear高額明細合計データ編集エリア();
        return createResponse(div);
    }

    private ResponseData<KogakuKyufuTaishoListDiv> createResponse(KogakuKyufuTaishoListDiv div) {
        return ResponseData.of(div).respond();
    }

    private KogakuKyufuTaishoListHandler getHandler(KogakuKyufuTaishoListDiv div) {
        return new KogakuKyufuTaishoListHandler(div);
    }

    private KogakuKyufuTaishoListValidationHandler getCheckHandler(KogakuKyufuTaishoListDiv div) {
        return new KogakuKyufuTaishoListValidationHandler(div);
    }

}
