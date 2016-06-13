/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.KogakuKyufuTaishoList;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuKyufuTaishoListCheckHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuKyufuTaishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuKyufuTaishoListHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
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

    /**
     * 「「追加する」ボタン
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoListDiv> onClick_btnTsuika(
            KogakuKyufuTaishoListDiv div) {
        getHandler(div).高額明細合計データ編集非活性(false);
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
        getHandler(div).高額明細合計データ編集非活性(false);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        getHandler(div).set高額明細合計データ編集エリア(サービス提供年月);
        getHandler(div).制御(サービス提供年月);
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
        getHandler(div).高額明細合計データ編集非活性(true);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        getHandler(div).set高額明細合計データ編集エリア(サービス提供年月);
        getHandler(div).制御(サービス提供年月);
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
        div.setJigyoshaCode(DataPassingConverter.serialize(
                div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().getValue()));
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
        RString jigyoshaCode = DataPassingConverter.deserialize(div.getJigyoshaCode(), RString.class);
        RString jigyoshaMeisho = DataPassingConverter.deserialize(div.getJigyoshaMeisho(), RString.class);
        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode().setValue(jigyoshaCode);
        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().setValue(jigyoshaMeisho);
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
        div.setJigyoshaCode(DataPassingConverter.serialize(
                div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().getValue()));
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
        RString serviceCode = DataPassingConverter.deserialize(div.getServiceCode(), RString.class);
        RString serviceMeisho = DataPassingConverter.deserialize(div.getServiceMeisho(), RString.class);
        div.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui().setValue(serviceCode);
        div.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName().setValue(serviceMeisho);
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
        getHandler(div).高額明細合計データ編集非活性(true);
        getHandler(div).clear高額明細合計データ編集エリア();
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
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (!削除.equals(モード)) {
            validPairs = getCheckHandler(div).確定チェック();
        }
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).高額明細合計データ編集非活性(false);
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
            RString state = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
            getHandler(div).modifyRow(row, state);
        }
        return createResponse(div);
    }

    private ResponseData<KogakuKyufuTaishoListDiv> createResponse(KogakuKyufuTaishoListDiv div) {
        return ResponseData.of(div).respond();
    }

    private KogakuKyufuTaishoListHandler getHandler(KogakuKyufuTaishoListDiv div) {
        return new KogakuKyufuTaishoListHandler(div);
    }

    private KogakuKyufuTaishoListCheckHandler getCheckHandler(KogakuKyufuTaishoListDiv div) {
        return new KogakuKyufuTaishoListCheckHandler(div);
    }

}
