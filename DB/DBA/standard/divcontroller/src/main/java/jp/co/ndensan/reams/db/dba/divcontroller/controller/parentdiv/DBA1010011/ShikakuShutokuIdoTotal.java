/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1010011;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.DBA1010011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.ShikakuShutokuIdoTotalDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1010011.ShiKaKuSyuToKuIdouTotalHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 資格取得異動の対象者情報を表示するためのDivControllerです。
 *
 */
public class ShikakuShutokuIdoTotal {

    private static final LockingKey 前排他ロックキー = new LockingKey("ShikakuShutokuIdo");
    private static final RString DEFAULT = new RString("資格取得情報");
    private static final RString IRYOU = new RString("医療保険");
    private static final RString RONEN = new RString("老福年金");
    private static final RString SHISETSU = new RString("施設入退所");
    private static final RString 追加 = new RString("追加");

    /**
     * 資格取得異動の初期化します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onLoad(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();
        createHandler(div).load();
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(ShikakuShutokuIdoTotalErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        } else {
            RealInitialLocker.lock(前排他ロックキー);
        }
        response.data = div;
        return response;
    }

    /**
     * 資格取得異動タブの切替処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onChange_tabInputs(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();
        RString title = div.getShikakuShutokuJoho().getTabInputs().getSelectedItem().getTitle();
        if (DEFAULT.equals(title)) {
            createHandler(div).onOpenTplDefault();
        } else if (IRYOU.equals(title)) {
            createHandler(div).onOpenTplIryou();
        } else if (RONEN.equals(title)) {
            createHandler(div).onOpenTplRoNen();
        } else if (SHISETSU.equals(title)) {
            createHandler(div).onOpenTplShisetsu();
        }
        response.data = div;
        return response;
    }

    /**
     * 「資格情報を保存する」ボタン処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onClick_btnUpdate(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            createHandler(div).save();
            RealInitialLocker.release(前排他ロックキー);
            div.getComplete().getCcdComplete().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(div).setState(DBA1010011StateName.完了状態);
        }
        response.data = div;
        return response;
    }

    /**
     * 「完了」ボタンを押下します。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onClick_commonButtonUpdateDone(ShikakuShutokuIdoTotalDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        onLoad(div);
        return ResponseData.of(div).setState(DBA1010011StateName.初期状態);
    }

    /**
     * 「資格得喪履歴を追加する」ボタン処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onClick_btnAdd(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(true);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().setDisabled(false);
        createHandler(div).get被保番号表示有無制御();
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を修正する」ボタン処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onClick_ModifyButton(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();

        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().setDisabled(false);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(true);
        createHandler(div).get被保番号表示有無制御();

        dgShikakuShutokuRireki_Row row = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                .getCcdShikakuTokusoRireki().getDataGridSelectItem();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput()
                .getTxtHihoNo().setValue(row.getHihokenshaNo());
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput()
                .getTxtShutokuDate().setValue(row.getShutokuDate().getValue());
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput()
                .getTxtShutokuTodokedeDate().setValue(row.getShutokuTodokedeDate().getValue());
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput()
                .getDdlShikakuShutokuJiyu().setSelectedKey(row.getShutokuJiyuKey());
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を確定する」ボタン処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onClick_btnKakutei(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();

        dgShikakuShutokuRireki_Row row = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().getDataGridSelectItem();
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().getDataGridDataSource();
        Collections.sort(rowList, new ShikakuShutokuIdoTotal.ComparatorByDaNoSort());
        RString daNo = new RString("1");
        if (!rowList.isEmpty()) {
            daNo = new RString(Integer.parseInt(rowList.get(rowList.size() - 1).getDaNo().trim().toString()) + 1);
        }
        if (row != null) {
            row.getShutokuDate().setValue(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuShutokuInput().getTxtShutokuDate().getValue());
            row.getShutokuTodokedeDate().setValue(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput()
                    .getTxtShutokuTodokedeDate().getValue());
            row.setShutokuJiyu(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuShutokuInput().getDdlShikakuShutokuJiyu().getSelectedValue());
            row.setShutokuJiyuKey(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuShutokuInput().getDdlShikakuShutokuJiyu().getSelectedKey());
        } else {
            row = new dgShikakuShutokuRireki_Row();
            row.setState(追加);
            row.setDaNo(daNo);
            row.getShutokuDate().setValue(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuShutokuInput().getTxtShutokuDate().getValue());
            row.getShutokuTodokedeDate().setValue(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput()
                    .getTxtShutokuTodokedeDate().getValue());
            row.setShutokuJiyu(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuShutokuInput().getDdlShikakuShutokuJiyu().getSelectedValue());
            row.setShutokuJiyuKey(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuShutokuInput().getDdlShikakuShutokuJiyu().getSelectedKey());
            row.setHihokenshaNo(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuShutokuInput().getTxtHihoNo().getValue());

        }
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().setDataGridSelectItem(row);
        createHandler(div).資格取得情報パネルの初期化();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().setDisabled(true);
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を取消する」ボタン処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onClick_btnTorikeshi(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();
        createHandler(div).資格取得情報パネルの初期化();
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を削除する」ボタン処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onClick_btnDelete(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(false);
        response.data = div;
        return response;
    }

    /**
     * 資格得喪履歴グリッドの枝番の昇順処理です。
     *
     */
    public class ComparatorByDaNoSort implements Comparator {

        @Override
        public int compare(Object arg0, Object arg1) {
            dgShikakuShutokuRireki_Row row0 = (dgShikakuShutokuRireki_Row) arg0;
            dgShikakuShutokuRireki_Row row1 = (dgShikakuShutokuRireki_Row) arg1;
            return row0.getDaNo().compareTo(row1.getDaNo());
        }
    }

    private enum ShikakuShutokuIdoTotalErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private ShikakuShutokuIdoTotalErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private ShiKaKuSyuToKuIdouTotalHandler createHandler(ShikakuShutokuIdoTotalDiv div) {
        return new ShiKaKuSyuToKuIdouTotalHandler(div);
    }
}
