/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1140011;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011.DBB1140011StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011.DBB1140011TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011.ShotokuJohoTorokuTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1140011.ShotokuJohoTorokuHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1140011.ShotokuJohoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM13003_所得照会回答内容登録
 *
 * @reamsid_L DBB-1750-010 zhangrui
 */
public class ShotokuJohoTorokuTotal {

    private static final RString 処理名 = new RString("所得照会回答内容登録");

    /**
     * 画面のonLoadイベント
     *
     * @param div ShotokuJohoTorokuTotalTotalDiv
     * @return div
     */
    public ResponseData<ShotokuJohoTorokuTotalDiv> onLoad(ShotokuJohoTorokuTotalDiv div) {
        FukaTaishoshaKey viewStateData = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        getHandler(div).onload(viewStateData);
        return ResponseData.of(div).respond();
    }

    /**
     * 「再表示する」ボタンを押下する。<br/>
     *
     * @param div {@link ShotokuJohoTorokuTotalDiv 所得照会回答内容登録Div}
     * @return 所得照会回答内容登録情報Divを持つResponseData
     */
    public ResponseData<ShotokuJohoTorokuTotalDiv> onClick_btnSaiHyoji(ShotokuJohoTorokuTotalDiv div) {
        FukaTaishoshaKey viewStateData = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        ShikibetsuCode 識別コード = viewStateData.get識別コード();
        RDate kazeiNendo = new RDate(div.getSetaiShotokuInfo().getDdlSetaiIchiranKazeiNendo().getSelectedValue().toString());
        FlexibleYear 所得年度 = new FlexibleYear(kazeiNendo.getYear().toString());
        YMDHMS 所得基準日時 = YMDHMS.now();
        getHandler(div).load世帯所得情報一覧(識別コード, 所得年度, 所得基準日時, true);
        div.getSetaiShotokuInfo().getTxtSetaiIchiranKazeiNendo().setDomain(所得年度);
        div.getSetaiShotokuInfo().getChkSetaiIchiranAll().setSelectedItems(Collections.EMPTY_LIST);
        return ResponseData.of(div).respond();
    }

    /**
     * 世帯一覧Gridの行ダブルクリック処理です。
     *
     * @param div {@link ShotokuJohoTorokuTotalDiv 所得照会回答内容登録Div}
     * @return 所得照会回答内容登録情報Divを持つResponseData
     */
    public ResponseData<ShotokuJohoTorokuTotalDiv> onDoubleClick_dgSetaiShotoku(ShotokuJohoTorokuTotalDiv div) {
        getHandler(div).sync世帯一覧To内容登録();
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタンを押下する。<br/>
     *
     * @param div {@link ShotokuJohoTorokuTotalDiv 所得照会回答内容登録Div}
     * @return 所得照会回答内容登録Divを持つResponseData
     */
    public ResponseData<ShotokuJohoTorokuTotalDiv> onClick_btnKakutei(ShotokuJohoTorokuTotalDiv div) {
        ValidationMessageControlPairs messages = getValidationHandler(div).validate();
        if (!ResponseHolder.isReRequest() && messages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(messages).respond();
        }
        getHandler(div).to世帯所得情報行();
        return ResponseData.of(div).respond();
    }

    /**
     * 「やめる」ボタンを押下する。<br/>
     *
     * @param div {@link ShotokuJohoTorokuTotalDiv 所得照会回答内容登録Div}
     * @return 所得照会回答内容登録Divを持つResponseData
     */
    public ResponseData<ShotokuJohoTorokuTotalDiv> onClick_btnTorikeshi(ShotokuJohoTorokuTotalDiv div) {
        div.getSetaiShotokuInfo().setDisplayNone(false);
        div.getShotokuJohoToroku().setDisplayNone(true);
        div.getSetaiShotokuInfo().getDgSetaiShotoku().init();
        return ResponseData.of(div).respond();
    }

    /**
     * 最新の世帯員・所得状況を表示するチェックボックスのチェック状態変更。<br/>
     *
     * @param div {@link ShotokuJohoTorokuTotalDiv 所得照会回答内容登録Div}
     * @return 所得照会回答内容登録Divを持つResponseData
     */
    public ResponseData<ShotokuJohoTorokuTotalDiv> onClick_chkSetaiIchiranAll(ShotokuJohoTorokuTotalDiv div) {
        FukaTaishoshaKey viewStateData = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        ShikibetsuCode 識別コード = viewStateData.get識別コード();
        RString 所得Year = div.getDdlSetaiIchiranKazeiNendo().getSelectedValue();
        FlexibleYear 所得年度 = new FlexibleYear(new RDate(所得Year.toString()).getYear().toString());
        YMDHMS 所得基準日時 = YMDHMS.now();
        if (div.getSetaiShotokuInfo().getChkSetaiIchiranAll().isAllSelected()) {
            getHandler(div).load世帯所得情報一覧(識別コード, 所得年度, 所得基準日時, false);
        } else {
            getHandler(div).load世帯所得情報一覧(識別コード, 所得年度, 所得基準日時, true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下します。
     *
     * @param div {@link ShotokuJohoTorokuTotalDiv 所得照会回答内容登録Div}
     * @return 所得照会回答内容登録Divを持つResponseData
     */
    public ResponseData<ShotokuJohoTorokuTotalDiv> onClick_btnSave(ShotokuJohoTorokuTotalDiv div) {
        boolean success = getHandler(div).save世帯登録();
        FukaTaishoshaKey viewStateData = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        ShikibetsuCode 識別コード = viewStateData.get識別コード();
        RString 氏名又は名称 = div.getAtenaInfo().getKaigoAtenaInfo().get氏名漢字();
        div.getKanryoMessage().getCcdKaigoKanryoMessage().setMessage(処理名, 識別コード.value(), 氏名又は名称, success);
        return ResponseData.of(div).setState(DBB1140011StateName.完了状態);
    }

    /**
     * 「検索する」ボタンを押下します。
     *
     * @param div {@link ShotokuJohoTorokuTotalDiv 所得照会回答内容登録Div}
     * @return 所得照会回答内容登録Divを持つResponseData
     */
    public ResponseData<ShotokuJohoTorokuTotalDiv> onClick_saiKensaku(ShotokuJohoTorokuTotalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBB1140011TransitionEventName.再検索).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ShotokuJohoTorokuHandler getHandler(ShotokuJohoTorokuTotalDiv div) {
        return ShotokuJohoTorokuHandler.of(div);
    }

    private ShotokuJohoTorokuValidationHandler getValidationHandler(ShotokuJohoTorokuTotalDiv div) {
        return new ShotokuJohoTorokuValidationHandler(div);
    }

}
