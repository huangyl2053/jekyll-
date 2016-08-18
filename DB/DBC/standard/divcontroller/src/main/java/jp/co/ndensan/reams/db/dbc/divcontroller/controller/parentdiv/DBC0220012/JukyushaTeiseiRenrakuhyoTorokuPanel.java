/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0220012;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushateiseirenrakuhyotorokumanager.JukyushaTeiseiRenrakuhyoTorokuManagerResult;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012.DBC0220012StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012.JukyushaTeiseiRenrakuhyoTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220012.JukyushaTeiseiRenrakuhyoTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220012.JukyushaTeiseiRenrakuhyoTorokuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyotorokumanager.JukyushaTeiseiRenrakuhyoTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN81002_受給者訂正連絡票登録
 *
 * @reamsid_L DBC-2101-020 quxiaodong
 */
public class JukyushaTeiseiRenrakuhyoTorokuPanel {

    private static final RString 引き継ぎ情報なし = new RString("引き継ぎ情報なし");
    private static final RString 訂正モード = new RString("訂正モード");
    private static final RString 照会モード = new RString("照会モード");
    private static final RString 修正モード_TWO = new RString("修正モード2");
    private static final RString 修正モード_THREE = new RString("修正モード3");
    private static final RString 修正済 = new RString("修正済");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");

    /**
     * 画面初期化です。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> onLoad(JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        KyodoJukyushaTaishoshaEntity 引き継ぎ情報 = ViewStateHolder.get(
                ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        if (引き継ぎ情報 == null || ((引き継ぎ情報.get被保番号() == null || 引き継ぎ情報.get被保番号().isEmpty())
                && (引き継ぎ情報.get異動日() == null || 引き継ぎ情報.get異動日().isEmpty()))) {
            throw new ApplicationException(
                    DbzErrorMessages.理由付き登録不可.getMessage().replace(引き継ぎ情報なし.toString()));
        }
        if (!getHandler(div).is前排他キーのセット(引き継ぎ情報.get被保番号())) {
            throw new PessimisticLockingException();
        }
        if (!引き継ぎ情報.is論理削除フラグ()) {
            div.getJukyushaIdoRenrakuhyo().initialize(訂正モード, ShikibetsuCode.EMPTY,
                    引き継ぎ情報.get被保番号(), 引き継ぎ情報.get履歴番号(), false, 引き継ぎ情報.get異動日());
            ViewStateHolder.put(ViewStateKeys.モード, 訂正モード);
        } else {
            div.getJukyushaIdoRenrakuhyo().initialize(照会モード, ShikibetsuCode.EMPTY,
                    引き継ぎ情報.get被保番号(), 引き継ぎ情報.get履歴番号(), true, 引き継ぎ情報.get異動日());
            ViewStateHolder.put(ViewStateKeys.モード, 照会モード);
        }
        //TODO
        AccessLogger.log(AccessLogType.照会,
                getHandler(div).toPersonalData(new ShikibetsuCode("0000000010"),
                        引き継ぎ情報.get被保番号().getColumnValue()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡票を保存する」ボタンです。
     *
     * @param div JukyushaTeiseiRenrakuhyoTorokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> onClick_btnUpdate(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).get入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            KyodoJukyushaTaishoshaEntity 引き継ぎ情報 = ViewStateHolder.get(
                    ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div = div.getJukyushaIdoRenrakuhyo().get受給者異動送付();
            JukyushaTeiseiRenrakuhyoTorokuManagerResult result = JukyushaTeiseiRenrakuhyoTorokuManager.
                    createInstance().regJukyushaTeiseiJoho(引き継ぎ情報.get履歴番号(),
                            引き継ぎ情報.is論理削除フラグ(), 受給者訂正連絡票登録画面Div);
            if (0 == result.get登録件数()) {
                return get更新状態遷移(div, 受給者訂正連絡票登録画面Div, 引き継ぎ情報);
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private ResponseData<JukyushaTeiseiRenrakuhyoTorokuPanelDiv> get更新状態遷移(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div,
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            KyodoJukyushaTaishoshaEntity 引き継ぎ情報) {
        int 登録件数 = 0;
        if (!引き継ぎ情報.is論理削除フラグ()) {
            登録件数 = get登録件数(受給者訂正連絡票登録画面Div, div);
        } else {
            登録件数 = getHandler(div).save受給者訂正連絡票(
                    受給者訂正連絡票登録画面Div, 修正モード_TWO);
        }
        //TODO
        if (登録件数 == 1 && ViewStateHolder.get(ViewStateKeys.モード, RString.class).equals(訂正モード)) {
            div.getCcdKanryoMessage().setMessage(
                    UrInformationMessages.保存終了,
                    受給者訂正連絡票登録画面Div.get被保険者番号().value(),
                    受給者訂正連絡票登録画面Div.get被保険者氏名カナ(), true);
            return ResponseData.of(div).setState(DBC0220012StateName.完了メッセージ);
        } else if (登録件数 == 0) {
            div.getCcdKanryoMessage().setMessage(
                    UrErrorMessages.異常終了,
                    受給者訂正連絡票登録画面Div.get被保険者番号().value(),
                    受給者訂正連絡票登録画面Div.get被保険者氏名カナ(), false);
            return ResponseData.of(div).setState(DBC0220012StateName.完了メッセージ);
        }
        return ResponseData.of(div).respond();
    }

    private int get登録件数(JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        int 登録件数 = 0;
        JukyushaIdoRenrakuhyo 初期化データ = ViewStateHolder.get(
                ViewStateKeys.受給者異動送付, JukyushaIdoRenrakuhyo.class);
        boolean flag = getHandler(div).is受給者異動連絡票内容変更状態(
                初期化データ, 受給者訂正連絡票登録画面Div);
        if (TWO.equals(受給者訂正連絡票登録画面Div.get訂正区分コード())) {
            if (!flag) {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            } else {
                登録件数 = getHandler(div).save受給者訂正連絡票(
                        受給者訂正連絡票登録画面Div, 修正モード_THREE);
            }
        } else if (THREE.equals(受給者訂正連絡票登録画面Div.get訂正区分コード())) {
            if (flag) {
                throw new ApplicationException(
                        DbzErrorMessages.理由付き登録不可.getMessage().replace(修正済.toString()));
            } else {
                登録件数 = getHandler(div).save受給者訂正連絡票(
                        受給者訂正連絡票登録画面Div, 修正モード_TWO);
            }
        }
        return 登録件数;
    }

    private JukyushaTeiseiRenrakuhyoTorokuPanelHandler getHandler(JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        return new JukyushaTeiseiRenrakuhyoTorokuPanelHandler(div);
    }

    private JukyushaTeiseiRenrakuhyoTorokuPanelValidationHandler getCheckHandler(
            JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        return new JukyushaTeiseiRenrakuhyoTorokuPanelValidationHandler(div);
    }

}
