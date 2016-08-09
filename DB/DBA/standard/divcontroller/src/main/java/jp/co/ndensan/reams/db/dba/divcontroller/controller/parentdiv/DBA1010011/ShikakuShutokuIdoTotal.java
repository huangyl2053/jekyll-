/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1010011;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.DBA1010011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.DBA1010011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.ShikakuShutokuIdoTotalDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1010011.ShiKaKuSyuToKuIdouTotalHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 資格取得異動の対象者情報を表示するためのDivControllerです。
 *
 * @reamsid_L DBA-0520-030 wangkun
 */
public class ShikakuShutokuIdoTotal {

    private LockingKey 前排他ロックキー;
    private static final RString DEFAULT = new RString("資格取得情報");
    private static final RString IRYOU = new RString("医療保険");
    private static final RString RONEN = new RString("老福年金");
    private static final RString SHISETSU = new RString("施設入退所");
    private static final RString 追加 = new RString("追加");

    private static final RString COMMON_BUTTON_RESEARCH = new RString("btnUpdate");

    /**
     * 資格取得異動の初期化します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onLoad(ShikakuShutokuIdoTotalDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }

        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode shikibetsuCode = key.get識別コード();

        if (validateShikibetsuCode(shikibetsuCode)) {
            div.setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_RESEARCH, true);
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }

        前排他ロックキー = new LockingKey(createHandler(div).get前排他キー());
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }

        ShiKaKuSyuToKuIdouTotalHandler handler = createHandler(div);
        handler.load(ViewStateHolder.get(ViewStateKeys.資格取得異動_状態_被保履歴タブ, RString.class));

        if (handler.is資格取得中()) {
            前排他ロックキー = new LockingKey(createHandler(div).get前排他キー());
            RealInitialLocker.release(前排他ロックキー);
            div.setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_RESEARCH, true);
            //実行不可(19, "?ため?できません。"),
            return ResponseData.of(div).addMessage(DbzInformationMessages.資格取得済み.getMessage()).respond();
        }

        return ResponseData.of(div).respond();
    }

    private boolean validateShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        return (shikibetsuCode == null || shikibetsuCode.isEmpty());
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
            ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_被保履歴タブ, createHandler(div)
                    .onOpenTplDefault(ViewStateHolder.get(ViewStateKeys.資格取得異動_状態_被保履歴タブ, RString.class)));
        } else if (IRYOU.equals(title)) {
            ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_医療保険タブ, createHandler(div)
                    .onOpenTplIryou(ViewStateHolder.get(ViewStateKeys.資格取得異動_状態_医療保険タブ, RString.class)));
        } else if (RONEN.equals(title)) {
            ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_老福年金タブ, createHandler(div)
                    .onOpenTplRoNen(ViewStateHolder.get(ViewStateKeys.資格取得異動_状態_老福年金タブ, RString.class)));
        } else if (SHISETSU.equals(title)) {
            ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_施設入退所タブ, createHandler(div)
                    .onOpenTplShisetsu(ViewStateHolder.get(ViewStateKeys.資格取得異動_状態_施設入退所タブ, RString.class)));
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
        if (!ResponseHolder.isReRequest()) {
            if (!isSavable(div)) {
                throw new ApplicationException(UrErrorMessages.保存データなし.getMessage());
            }

            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            createHandler(div).save();
            前排他ロックキー = new LockingKey(createHandler(div).get前排他キー());
            RealInitialLocker.release(前排他ロックキー);
            div.getComplete().getCcdComplete().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(div).setState(DBA1010011StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    private boolean isSavable(ShikakuShutokuIdoTotalDiv div) {
        return createHandler(div).isSavable();
    }

    /**
     * 「完了」ボタンを押下します。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onClick_commonButtonUpdateDone(ShikakuShutokuIdoTotalDiv div) {
        前排他ロックキー = new LockingKey(createHandler(div).get前排他キー());
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).setState(DBA1010011StateName.初期状態);
    }

    /**
     * 「再検索する」ボタンを押下します。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onClick_btnBack(ShikakuShutokuIdoTotalDiv div) {
        前排他ロックキー = new LockingKey(createHandler(div).get前排他キー());
        RealInitialLocker.release(前排他ロックキー);
        ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_被保履歴タブ, null);
        ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_医療保険タブ, null);
        ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_老福年金タブ, null);
        ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_施設入退所タブ, null);
        return ResponseData.of(div).forwardWithEventName(DBA1010011TransitionEventName.再検索).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンを押下します。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onClick_btnSearchResult(ShikakuShutokuIdoTotalDiv div) {
        前排他ロックキー = new LockingKey(createHandler(div).get前排他キー());
        RealInitialLocker.release(前排他ロックキー);
        ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_被保履歴タブ, null);
        ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_医療保険タブ, null);
        ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_老福年金タブ, null);
        ViewStateHolder.put(ViewStateKeys.資格取得異動_状態_施設入退所タブ, null);
        return ResponseData.of(div).forwardWithEventName(DBA1010011TransitionEventName.検索結果一覧).respond();
    }

    /**
     * 「資格情報を詳細」ボタン処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onClick_btnSyouHoSo(ShikakuShutokuIdoTotalDiv div) {
        前排他ロックキー = new LockingKey(createHandler(div).get前排他キー());
        RealInitialLocker.release(前排他ロックキー);
        createHandler(div).setパラメータ();
        return ResponseData.of(div).forwardWithEventName(DBA1010011TransitionEventName.詳細へ).respond();
    }

    /**
     * 「資格得喪履歴を追加する」ボタン処理します。
     *
     * @param div ShikakuShutokuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuShutokuIdoTotalDiv> onClick_btnAdd(ShikakuShutokuIdoTotalDiv div) {
        ResponseData<ShikakuShutokuIdoTotalDiv> response = new ResponseData<>();
        createHandler(div).資格取得情報パネルの初期化();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().setReadOnly(false);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(true);
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

        createHandler(div).資格取得情報パネルの初期化();
        createHandler(div).get被保番号表示有無制御();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().setReadOnly(false);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(true);

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
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                .getCcdShikakuTokusoRireki().getDataGridDataSource();
        if (row != null && !RString.isNullOrEmpty(row.getState())) {
            row.getShutokuDate().setValue(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuShutokuInput().getTxtShutokuDate().getValue());
            row.getShutokuTodokedeDate().setValue(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput()
                    .getTxtShutokuTodokedeDate().getValue());
            row.setShutokuJiyu(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuShutokuInput().getDdlShikakuShutokuJiyu().getSelectedValue());
            row.setShutokuJiyuKey(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                    .getShikakuShutokuInput().getDdlShikakuShutokuJiyu().getSelectedKey());
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().setDataGridSelectItem(row);
        } else {
            Collections.sort(rowList, new ShikakuShutokuIdoTotal.ComparatorByDaNoSort());
            RString daNo = new RString("1");
            if (!rowList.isEmpty()) {
                daNo = new RString(Integer.parseInt(rowList.get(rowList.size() - 1).getDaNo().trim().toString()) + 1);
            }
            row = new dgShikakuShutokuRireki_Row();
            row.setState(追加);
            row.setDaNo(daNo);
            row.getShutokuDate().setValue(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().
                    getShikakuShutokuInput().getTxtShutokuDate().getValue());
            row.getShutokuTodokedeDate().setValue(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().
                    getTxtShutokuTodokedeDate().getValue());
            row.setShutokuJiyu(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().
                    getShikakuShutokuInput().getDdlShikakuShutokuJiyu().getSelectedValue());
            row.setShutokuJiyuKey(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().
                    getShikakuShutokuInput().getDdlShikakuShutokuJiyu().getSelectedKey());
            row.setHihokenshaNo(div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().
                    getShikakuShutokuInput().getTxtHihoNo().getValue());
            rowList.add(row);
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().setDataGridDataSource(rowList);
        }

        List<dgShikakuShutokuRireki_Row> sortList = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki()
                .getDataGridDataSource();
        Collections.sort(sortList, new ShikakuShutokuIdoTotal.ComparatorByShutokuDateSort());
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().setDataGridDataSource(sortList);
        createHandler(div).資格取得情報パネルの初期化();
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().setReadOnly(true);
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
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(false);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getShikakuShutokuInput().setReadOnly(true);
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
        List<dgShikakuShutokuRireki_Row> rowList = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                .getCcdShikakuTokusoRireki().getDataGridDataSource();
        dgShikakuShutokuRireki_Row item = div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                .getCcdShikakuTokusoRireki().getDataGridSelectItem();
        rowList.remove(item);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain()
                .getCcdShikakuTokusoRireki().setDataGridDataSource(rowList);
        div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().set追加するボタン(false);
        response.data = div;
        return response;
    }

    /**
     * 資格得喪履歴グリッドの枝番の降順処理です。
     */
    public static class ComparatorByDaNoSort implements Comparator, Serializable {

        private static final long serialVersionUID = -4360646115909064130L;

        @Override
        public int compare(Object arg0, Object arg1) {
            dgShikakuShutokuRireki_Row row0 = (dgShikakuShutokuRireki_Row) arg0;
            dgShikakuShutokuRireki_Row row1 = (dgShikakuShutokuRireki_Row) arg1;
            return row0.getDaNo().compareTo(row1.getDaNo());
        }

    }

    /**
     * 資格得喪履歴グリッドの枝番の昇順処理です。
     */
    public static class ComparatorByShutokuDateSort implements Comparator, Serializable {

        private static final long serialVersionUID = 3584310998233164268L;

        @Override
        public int compare(Object arg0, Object arg1) {
            dgShikakuShutokuRireki_Row row0 = (dgShikakuShutokuRireki_Row) arg0;
            dgShikakuShutokuRireki_Row row1 = (dgShikakuShutokuRireki_Row) arg1;

            if (changeStringToInt(row0.getShutokuDate().getValue().toString()) > changeStringToInt(row1.getShutokuDate().getValue().toString())) {
                return -1;
            } else {
                if (changeStringToInt(row0.getShutokuDate().getValue().toString()).compareTo(changeStringToInt(row1.
                        getShutokuDate().getValue().toString())) == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }

        /**
         * StringをIntegerに変更する。
         *
         * @param str String
         * @return Integer Integer
         */
        public Integer changeStringToInt(String str) {
            return Integer.valueOf(str);
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
        return new ShiKaKuSyuToKuIdouTotalHandler(div,
                ViewStateHolder.get(jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class));
    }
}
