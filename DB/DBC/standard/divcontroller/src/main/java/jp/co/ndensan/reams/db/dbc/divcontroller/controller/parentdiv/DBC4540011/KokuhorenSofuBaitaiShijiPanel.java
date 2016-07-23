/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4540011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011.DBC4540011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011.DBC4540011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011.KokuhorenSofuBaitaiShijiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4540011.KokuhorenSofuBaitaiShijiPanelHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 国保連送付媒体管理Divを制御します。
 *
 * @reamsid_L DBC-3362-010 xuxin
 */
public class KokuhorenSofuBaitaiShijiPanel {

    private static final RString 前排他キー = new RString("DBCKokuhorenSoufuBaitaiKanri");

    private KokuhorenSofuBaitaiShijiPanelHandler getHandler(KokuhorenSofuBaitaiShijiPanelDiv div) {
        return new KokuhorenSofuBaitaiShijiPanelHandler(div);
    }

    /**
     * 国保連送付媒体管理作成画面初期化を処理します。
     *
     * @param div KokuhorenSofuBaitaiShijiPanelDiv
     * @return ResponseData<KokuhorenSofuBaitaiShijiPanelDiv>
     */
    public ResponseData<KokuhorenSofuBaitaiShijiPanelDiv> onLoad(KokuhorenSofuBaitaiShijiPanelDiv div) {

        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        getHandler(div).初期登録状態();
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBC4540011StateName.初期登録状態);
    }

    /**
     * 「保存する」ボタン押下時のイベントメソッドです。
     *
     * @param div KokuhorenSofuBaitaiShijiPanelDiv
     * @return ResponseData<KokuhorenSofuBaitaiShijiPanelDiv>
     */
    public ResponseData<KokuhorenSofuBaitaiShijiPanelDiv> onClick_btnSave(KokuhorenSofuBaitaiShijiPanelDiv div) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            getHandler(div).config保存();
            return ResponseData.of(div).setState(DBC4540011StateName.完了状態);
        }
        return ResponseData.of(div).setState(DBC4540011StateName.初期登録状態);
    }

    /**
     * 「メニューへ戻る」ボタン押下時のイベントメソッドです。
     *
     * @param div KokuhorenSofuBaitaiShijiPanelDiv
     * @return ResponseData<KokuhorenSofuBaitaiShijiPanelDiv>
     */
    public ResponseData<KokuhorenSofuBaitaiShijiPanelDiv> onClick_btnBack(KokuhorenSofuBaitaiShijiPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC4540011TransitionEventName.処理完了).respond();
    }

    /**
     * 「選択」ボタン押下時のイベントメソッドです。
     *
     * @param div KokuhorenSofuBaitaiShijiPanelDiv
     * @return ResponseData<KokuhorenSofuBaitaiShijiPanelDiv>
     */
    public ResponseData<KokuhorenSofuBaitaiShijiPanelDiv> onClick_btnSelect(KokuhorenSofuBaitaiShijiPanelDiv div) {

        getHandler(div).選択状態();
        getHandler(div).選択ボタン押下時();
        return ResponseData.of(div).setState(DBC4540011StateName.初期登録状態);
    }

    /**
     * 「完了する」ボタン押下時のイベントメソッドです。
     *
     * @param div KokuhorenSofuBaitaiShijiPanelDiv
     * @return ResponseData<KokuhorenSofuBaitaiShijiPanelDiv>
     */
    public ResponseData<KokuhorenSofuBaitaiShijiPanelDiv> onClick_btnComplete(KokuhorenSofuBaitaiShijiPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC4540011TransitionEventName.処理完了).respond();
    }

    /**
     * 「実行」ボタン押下時のイベントメソッドです。
     *
     * @param div KokuhorenSofuBaitaiShijiPanelDiv
     * @return ResponseData<KokuhorenSofuBaitaiShijiPanelDiv>
     */
    public ResponseData<KokuhorenSofuBaitaiShijiPanelDiv> onClick_btnSetting(KokuhorenSofuBaitaiShijiPanelDiv div) {

        getHandler(div).set入力内容反映();
        getHandler(div).初期登録状態();
        return ResponseData.of(div).setState(DBC4540011StateName.初期登録状態);
    }

    /**
     * 「取消」ボタン押下時のイベントメソッドです。
     *
     * @param div KokuhorenSofuBaitaiShijiPanelDiv
     * @return ResponseData<KokuhorenSofuBaitaiShijiPanelDiv>
     */
    public ResponseData<KokuhorenSofuBaitaiShijiPanelDiv> onClick_btnCancle(KokuhorenSofuBaitaiShijiPanelDiv div) {

        getHandler(div).set入力値破棄();
        getHandler(div).初期登録状態();
        return ResponseData.of(div).setState(DBC4540011StateName.初期登録状態);
    }

}
