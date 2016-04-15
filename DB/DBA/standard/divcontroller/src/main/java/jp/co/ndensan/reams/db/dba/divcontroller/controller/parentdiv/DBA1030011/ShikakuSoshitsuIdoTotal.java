/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1030011;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1030011.ShikakuSoshitsuIdoTotalDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1030011.ShikakuSoshitsuIdoTotalHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
 * 資格喪失異動の対象者情報を表示するためのDivControllerです。
 *
 */
public class ShikakuSoshitsuIdoTotal {

    private static final LockingKey 前排他ロックキー = new LockingKey("ShikakuSoshitsuIdo");
    private static final RString DEFAULT = new RString("被保履歴");
    private static final RString IRYOU = new RString("医療保険");
    private static final RString RONEN = new RString("老福年金");
    private static final RString SHISETSU = new RString("施設入退所");
    private static final RString SHORUIJOKYO = new RString("証類状況");
    private static final RString 追加 = new RString("追加");

    /**
     * 資格喪失異動の初期化します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onLoad(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();
        createHandler(div).load();
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(ShikakuSoshitsuIdoErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        } else {
            RealInitialLocker.lock(前排他ロックキー);
        }

        response.data = div;
        return response;
    }

    /**
     * 資格喪失異動タブの切替処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onChange_tabInputs(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();
        RString title = div.getShikakuSoshitsuJoho().getTabInputs().getSelectedItem().getTitle();
        if (DEFAULT.equals(title)) {
            createHandler(div).onOpenTplDefault();
        } else if (IRYOU.equals(title)) {
            createHandler(div).onOpenTplIryou();
        } else if (RONEN.equals(title)) {
            createHandler(div).onOpenTplRoNen();
        } else if (SHISETSU.equals(title)) {
            createHandler(div).onOpenTplShisetsu();
        } else if (SHORUIJOKYO.equals(title)) {
            createHandler(div).onOpenTplShoruiJokyo();
        }
        response.data = div;
        return response;
    }

    /**
     * 「資格情報を保存する」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_btnUpdate(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            createHandler(div).save();
        }
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を追加する」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_btnAdd(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(true);
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().setDisabled(false);
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を修正する」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_ModifyButton(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();

        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().setDisabled(false);
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(true);

        dgShikakuShutokuRireki_Row row = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain()
                .getCcdShikakuTokusoRireki().getDataGridSelectItem();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                .getTxtShutokuDate().setValue(row.getShutokuDate().getValue());
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                .getTxtShutokuTodokedeDate().setValue(row.getShutokuTodokedeDate().getValue());
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                .getDdlShikakuShutokuJiyu().setSelectedKey(row.getShutokuJiyuKey());
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を確定する」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_btnKakutei(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();

        dgShikakuShutokuRireki_Row row = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().getDataGridSelectItem();
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().getDataGridDataSource();
        Collections.sort(rowList, new ShikakuSoshitsuIdoTotal.ComparatorByDaNoSort());
        RString daNo = new RString("1");
        if (!rowList.isEmpty()) {
            daNo = new RString(Integer.parseInt(rowList.get(rowList.size() - 1).getDaNo().trim().toString()) + 1);
        }
        if (row != null) {
            row.getShutokuDate().setValue(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuSoshitsuInput().getTxtShutokuDate().getValue());
            row.getShutokuTodokedeDate().setValue(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                    .getTxtShutokuTodokedeDate().getValue());
            row.setShutokuJiyu(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().getSelectedValue());
            row.setShutokuJiyuKey(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().getSelectedKey());
        } else {
            row = new dgShikakuShutokuRireki_Row();
            row.setState(追加);
            row.setDaNo(daNo);
            row.getShutokuDate().setValue(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuSoshitsuInput().getTxtShutokuDate().getValue());
            row.getShutokuTodokedeDate().setValue(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                    .getTxtShutokuTodokedeDate().getValue());
            row.setShutokuJiyu(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().getSelectedValue());
            row.setShutokuJiyuKey(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu().getSelectedKey());

        }
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().setDataGridSelectItem(row);
        createHandler(div).資格喪失情報パネルの初期化();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().setDisabled(true);
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を取消する」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_btnTorikeshi(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();
        createHandler(div).資格喪失情報パネルの初期化();
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を削除する」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_btnDelete(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(false);
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

    private enum ShikakuSoshitsuIdoErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private ShikakuSoshitsuIdoErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private ShikakuSoshitsuIdoTotalHandler createHandler(ShikakuSoshitsuIdoTotalDiv div) {
        return new ShikakuSoshitsuIdoTotalHandler(div);
    }
}
