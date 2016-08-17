/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0430011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020020.DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011.DBC0430011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011.KogakuShikyuShinseishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0430011.KogakuShikyuShinseishoIkkatsuHakkoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費給付お知らせ通知書作成です。
 *
 * @reamsid_L DBC-4770-010 zhengshenlei
 */
public class KogakuShikyuShinseishoIkkatsuHakko {

    private static final RString メニューID_DBCMN43001 = new RString("DBCMN43001");
    private static final RString メニューID_DBCMNL3001 = new RString("DBCMNL3001");
    private static final RString 高額サービス費給付お知らせ通知書作成 = new RString("高額サービス費給付お知らせ通知書作成");
    private static final RString 事業高額サービス費給付お知らせ通知書作成 = new RString("事業高額サービス費給付お知らせ通知書作成");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDivselectControlID
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> onLoad(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        getHandler(div).initialize(menuID);
        if (メニューID_DBCMN43001.equals(menuID)) {
            return ResponseData.of(ResponseData.of(div).setState(DBC0430011StateName.NoChange).data)
                    .rootTitle(高額サービス費給付お知らせ通知書作成).respond();
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            return ResponseData.of(ResponseData.of(div).setState(DBC0430011StateName.NoChange).data)
                    .rootTitle(事業高額サービス費給付お知らせ通知書作成).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタン「審査年月RAD」のメソッドです
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> btnOnClick_shinsaYM(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        div.getShinseishoHakkoParameters().getTxtShinsaYM().setReadOnly(false);
        div.getShinseishoHakkoParameters().getBtnHihokenshaSearch().setDisabled(true);
        div.getShinseishoHakkoParameters().getDdlServiceYM().setReadOnly(true);
        div.getShinseishoHakkoParameters().getRadHihokenshaNo().clearSelectedItem();
        div.getShinseishoHakkoParameters().getRadHakushiInsatsu().clearSelectedItem();

        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタン「被保険者番号RAD」のメソッドです
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> btnOnClick_radHihokenshaNo(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        div.getShinseishoHakkoParameters().getTxtShinsaYM().setReadOnly(true);
        div.getShinseishoHakkoParameters().getBtnHihokenshaSearch().setDisabled(false);
        div.getShinseishoHakkoParameters().getDdlServiceYM().setReadOnly(false);
        div.getShinseishoHakkoParameters().getRadShinsaYM().clearSelectedItem();
        div.getShinseishoHakkoParameters().getRadHakushiInsatsu().clearSelectedItem();
        getHandler(div).setサービス年月DDL(menuID);
        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタン「白紙印刷RAD」のメソッドです。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> btnOnClick_radHakushiInsatsu(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        div.getShinseishoHakkoParameters().getTxtShinsaYM().setReadOnly(true);
        div.getShinseishoHakkoParameters().getBtnHihokenshaSearch().setDisabled(false);
        div.getShinseishoHakkoParameters().getDdlServiceYM().setReadOnly(true);
        div.getShinseishoHakkoParameters().getRadShinsaYM().clearSelectedItem();
        div.getShinseishoHakkoParameters().getRadHihokenshaNo().clearSelectedItem();
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者番号入力ガイドのメソッドです
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> onCancelClose(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        if (div.getShinseishoHakkoParameters().getTxtHihokenshaNo().getValue().isEmpty()) {
            throw new ApplicationException(DbcErrorMessages.被保険者の高額介護サービス支給申請情報が無い.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onBeforeOpenDialogのメソッドです。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> onBeforeOpenDialog(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        if (div.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen().getValue().isEmpty()) {
            return ResponseData.of(div).addMessage(DbcWarningMessages.申請書提出期限未入力.getMessage()).respond();
        } else {
            return ResponseData.of(div).addMessage(DbcWarningMessages.自動償還確認.getMessage()).respond();
        }
    }

    /**
     * 「確定処理を実行する（バッチ用）」ボタンのメソッドです。
     *
     * @param div HeijunkaKakuteiDiv
     * @return ResponseData
     */
    public ResponseData<DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter> onclick_btBatch(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
        boolean gotLock = RealInitialLocker.tryGetLock(排他キー);
        if (!gotLock) {
            throw new PessimisticLockingException();
        }
        DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter parameter = getHandler(div).createBatchParameter(menuID);
        RealInitialLocker.release(排他キー);
        return ResponseData.of(parameter).respond();
    }

    private KogakuShikyuShinseishoIkkatsuHakkoHandler getHandler(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        return new KogakuShikyuShinseishoIkkatsuHakkoHandler(div);
    }

}
