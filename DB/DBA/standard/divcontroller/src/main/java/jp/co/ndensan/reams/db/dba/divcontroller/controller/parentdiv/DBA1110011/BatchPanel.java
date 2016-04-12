/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1110011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo.KayiSyuuJiyuu;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo.KouFuJiyuu;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011.BatchPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.dba1110011.BatchPanelHandler;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboFinder;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 被保険者証発行管理簿Divを制御します。
 *
 * @reamsid_L DBA-0600-010 zhangguopeng
 */
public class BatchPanel {

    private static final RString 未回収者リスト = new RString("key1");
    private static final RString 開始日と終了日両方 = new RString("開始日と終了日両方");

    /**
     * 被保険者証発行管理簿を画面初期化処理しました。
     *
     * @param div {@link BatchPanelDiv 被保険者証発行管理簿Div}
     * @return 被保険者証発行管理簿Divを持つResponseData
     */
    public ResponseData<BatchPanelDiv> onLoad(BatchPanelDiv div) {

        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        List<KouFuJiyuu> kouFuJiyuuList = HihokenshashoHakkoKanriboFinder.createInstance().getKofuJiyuInitialData(menuID).records();
        List<KayiSyuuJiyuu> kayiSyuuJiyuuList = HihokenshashoHakkoKanriboFinder.createInstance().getKaishuJiyuInitialData(menuID).records();
        if ((kouFuJiyuuList == null || kouFuJiyuuList.isEmpty())
                && (kayiSyuuJiyuuList == null || kayiSyuuJiyuuList.isEmpty())) {
            throw new ApplicationException(UrErrorMessages.コードマスタなし.getMessage());
        }
        getHandler(div).initialize(kouFuJiyuuList, kayiSyuuJiyuuList);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、入力チェックを実行します。
     *
     * @param div {@link BatchPanelDiv 被保険者証発行管理簿Div}
     * @return ResponseData<BatchPanelDiv>
     */
    public ResponseData<BatchPanelDiv> onClick_btnCheck(BatchPanelDiv div) {

        RDate koufubiFrom = div.getTxtKoufubiRange().getFromValue();
        RDate koufubiTo = div.getTxtKoufubiRange().getToValue();
        RDate kaishubiFrom = div.getTxtKaishubiRange().getFromValue();
        RDate kaishubiTo = div.getTxtKaishubiRange().getToValue();
        boolean flg = HihokenshashoHakkoKanriboFinder.createInstance().checkInput(
                koufubiFrom, koufubiTo, kaishubiFrom, kaishubiTo);
        // TODO  内部QA:924 Redmine： (必須チェックの処理は回答待ち)
        if (flg) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(
                    new BatchPanel.BatchPanelMessages(UrErrorMessages.必須, 開始日と終了日両方.toString())));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者証発行管理簿を「実行する」を押下する。<br/>
     *
     * @param div {@link BatchPanelDiv 被保険者証発行管理簿Div}
     * @return 被保険者証発行管理簿Divを持つResponseData
     */
    public ResponseData onClick_btnJikko(BatchPanelDiv div) {

        ResponseData<HihokenshashoHakkoKanriboBatchParameter> response = new ResponseData<>();
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        response.data = getHandler(div).batchParameter(div.getDgKoufuJiyu().getSelectedItems(),
                div.getDgKaishuJiyu().getSelectedItems(), menuID);
        return response;
    }

    /**
     * 被保険者証発行管理簿を「連動」する。<br/>
     *
     * @param div {@link BatchPanelDiv 被保険者証発行管理簿Div}
     * @return 被保険者証発行管理簿Divを持つResponseData
     */
    public ResponseData<BatchPanelDiv> onClick_btnChange(BatchPanelDiv div) {

        if (未回収者リスト.equals(div.getRadShutsuTaisho().getSelectedKey())) {
            div.getTxtKoufubiRange().clearFromValue();
            div.getTxtKoufubiRange().clearToValue();
            div.getTxtKaishubiRange().clearFromValue();
            div.getTxtKaishubiRange().clearToValue();
            List<RString> selectedKey = new ArrayList<>();
            div.getChkSaishinJoho().setSelectedItemsByKey(selectedKey);
            div.getTxtKaishubiRange().setReadOnly(true);
            div.getChkSaishinJoho().setReadOnly(true);
            div.getDgKaishuJiyu().setDisabled(true);
        } else {
            div.getTxtKoufubiRange().clearFromValue();
            div.getTxtKoufubiRange().clearToValue();
            div.getTxtKaishubiRange().clearFromValue();
            div.getTxtKaishubiRange().clearToValue();
            div.getTxtKaishubiRange().setReadOnly(false);
            div.getChkSaishinJoho().setReadOnly(false);
            div.getDgKaishuJiyu().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    private BatchPanelHandler getHandler(BatchPanelDiv div) {
        return new BatchPanelHandler(div);
    }

    private static final class BatchPanelMessages implements IValidationMessage {

        private final Message message;

        private BatchPanelMessages(IMessageGettable message, String... replaceParam) {
            this.message = message.getMessage().replace(replaceParam);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
