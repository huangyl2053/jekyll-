/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA4020011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureidaicho.OtherAddressLedgerBusiness;
import static jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4020011.DBA4020011TransitionEventName.検索条件;
import static jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4020011.DBA4020011TransitionEventName.該当者一覧;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4020011.TajutokuShokaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA4020011.TajutokuShokaiHandler;
import jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureidaicho.TashichosonJushochiTokureiDaichoFinder;
import jp.co.ndensan.reams.db.dba.service.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 他市町村住所地特例者照会クラスです。
 *
 * @reamsid_L DBA-0402-010 xuyannan
 */
public class TajutokuShokai {

    private final TaishoshaKey key;
    private final TashichosonJushochitokureishaDaichoPrintService service;
    private final TashichosonJushochiTokureiDaichoFinder finder;

    /**
     * コンストラクタです。
     */
    public TajutokuShokai() {
        key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        service = new TashichosonJushochitokureishaDaichoPrintService();
        finder = InstanceProvider.create(TashichosonJushochiTokureiDaichoFinder.class);
    }

    /**
     * 他市町村住所地特例者照会Divを初期化します。
     *
     * @param div 他市町村住所地特例者照会Div
     * @return ResponseData<TajutokuShokaiDiv> 他市町村住所地特例者照会Div
     */
    public ResponseData<TajutokuShokaiDiv> onLoad(TajutokuShokaiDiv div) {
        div.getShikakuKihonJoho().getCcdKaigoAtenaInfo().initialize(key.get識別コード());
        div.getShikakuKihonJoho().getCcdShikakuJoho().initialize(key.get識別コード());
        div.getTajutokuTekiyoJohoIchiran().getCcdTaJushochiTokureishaKanri().initialize(key.get識別コード());
        div.getJutokuJohoTeiseiIchiran().setIsOpen(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 施設情報を初期化します。
     *
     * @param div 他市町村住所地特例者照会Div
     * @return ResponseData<TajutokuShokaiDiv> 他市町村住所地特例者照会Div
     */
    public ResponseData<TajutokuShokaiDiv> onOpen(TajutokuShokaiDiv div) {
        if (RString.isNullOrEmpty(div.getHdnIsOpen())) {
            div.setHdnIsOpen(new RString("open"));
            div.getJutokuJohoTeiseiIchiran().setIsOpen(true);
            div.getJutokuJohoTeiseiIchiran().getCcdShisetsuNyushRirekiKanri().initialize(
                    key.get識別コード(), DaichoType.他市町村住所地特例者.getコード());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 処理実行の確認を発生します。
     *
     * @param div TajutokuShokaiDiv
     * @return ResponseData<TajutokuShokaiDiv>
     */
    public ResponseData<TajutokuShokaiDiv> onClick_Check(TajutokuShokaiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (!new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                || ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「他市町村住所地特例者台帳を発行する」ボタンを押下します。
     *
     * @param div TajutokuShokaiDiv
     * @return ResponseData<TajutokuShokaiDiv>
     */
    public ResponseData<SourceDataCollection> onClick_HakkouBtn(TajutokuShokaiDiv div) {
        List<OtherAddressLedgerBusiness> list = finder.getTashichosonJushochiTokureiDaicho(key.get識別コード());
        return ResponseData.of(service.print(getHandler().printTyouhyouData(list))).respond();
    }

    /**
     * 「再検索する」ボタンを押下します。
     *
     * @param div TajutokuShokaiDiv
     * @return ResponseData<TajutokuShokaiDiv>
     */
    public ResponseData<TajutokuShokaiDiv> onClick_ZaikensakuBtn(TajutokuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(検索条件).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンを押下します。
     *
     * @param div TajutokuShokaiDiv
     * @return ResponseData<TajutokuShokaiDiv>
     */
    public ResponseData<TajutokuShokaiDiv> onClick_KekkaIchiranBtn(TajutokuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(該当者一覧).respond();
    }

    private TajutokuShokaiHandler getHandler() {
        return new TajutokuShokaiHandler();
    }
}
