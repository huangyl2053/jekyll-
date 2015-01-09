/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.shikakuhenkorireki;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus.Add;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus.Delete;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus.Modify;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShikakuHenkoRirekiValidationHelper;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.ShikakuHenkoMapper;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.ShikakuHenkoRirekiHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.dgHenko_Row;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.ShikakuHenkoRirekiKanriContext;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.DivcontrollerMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICallbackMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.SingleButtonType;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共有子Div「資格変更履歴」のイベントを定義したDivControllerです。
 *
 * @author n8235 船山洋介
 */
public class ShikakuHenkoRireki {

    /**
     * 引数から渡されたキーを元に被保険者台帳を検索し、その結果をグリッドに設定します。
     *
     * @param henkoRirekiDiv 資格変更Div
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> load(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        ShikakuHenkoRirekiHandler handler = new ShikakuHenkoRirekiHandler(henkoRirekiDiv);
        LasdecCode lasdecCode = new LasdecCode("123456");

        handler.load(lasdecCode, new HihokenshaNo("1234567892"));
        handler.initialize(lasdecCode);
        return createSettingData(henkoRirekiDiv);

    }

    /**
     * 追加ボタンを押下した際に実行します。<br/>
     * 追加処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnAdd(ShikakuHenkoRirekiDiv henkoRirekiDiv) {

        ShikakuHenkoRirekiHandler handler = new ShikakuHenkoRirekiHandler(henkoRirekiDiv);

        henkoRirekiDiv.getBtnAdd().setDisabled(true);
        henkoRirekiDiv.getDgHenko().setReadOnly(true);
        henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
        henkoRirekiDiv.setInputMode(ViewExecutionStatus.Add.getValue());
        handler.setExecutionStatus(ViewExecutionStatus.Add);
        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 資格変更履歴上の一行が押下された際に実行します。<br/>
     * 選択行の状態に応じて、修正・照会などの処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelect_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {

        ShikakuHenkoRirekiHandler handler = new ShikakuHenkoRirekiHandler(henkoRirekiDiv);
        henkoRirekiDiv.getBtnAdd().setDisabled(true);
        henkoRirekiDiv.getDgHenko().setReadOnly(true);
        handler.showSelectedData();

        if (henkoRirekiDiv.getDgHenko().getSelectedItems().get(0).getState().equals(new RString("追加"))) {
            henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
        }

        if (henkoRirekiDiv.getDgHenko().getSelectedItems().get(0).getState().equals(new RString("修正"))) {
            henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
        }

        if (henkoRirekiDiv.getDgHenko().getSelectedItems().get(0).getState().equals(new RString(""))) {
            henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.shokai);

        }

        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 資格変更履歴上の修正アイコンが押下された際に実行します。<br/>
     * 修正・変更処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelectByModifyButton_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        ShikakuHenkoRirekiHandler handler = new ShikakuHenkoRirekiHandler(henkoRirekiDiv);
        henkoRirekiDiv.getBtnAdd().setDisabled(true);
        henkoRirekiDiv.getDgHenko().setReadOnly(true);
        handler.showSelectedData();
        henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
        handler.setExecutionStatus(ViewExecutionStatus.Modify);
        henkoRirekiDiv.setInputMode(ViewExecutionStatus.Modify.getValue());
        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 資格変更履歴上の削除アイコンが押下された際に実行します。<br/>
     * 削除処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelectByDeleteButton_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        //TODO
        ShikakuHenkoRirekiHandler handler = new ShikakuHenkoRirekiHandler(henkoRirekiDiv);

        createHandlerOf(henkoRirekiDiv).showSelectedData();
        henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.sakujo);
        henkoRirekiDiv.setInputMode(ViewExecutionStatus.Delete.getValue());
        handler.setExecutionStatus(ViewExecutionStatus.Delete);
        henkoRirekiDiv.getHenkoHokenshaJoho().setReadOnly(true);
        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 明細エリアの取消ボタンが押下された際に実行します。<br/>
     * 入力した情報を破棄してもよいかの確認メッセージを表示します。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnHenkoTorikeshi(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        ResponseData<ShikakuHenkoRirekiDiv> response = new ResponseData<>();

        ShikakuHenkoRirekiHandler handler = new ShikakuHenkoRirekiHandler(henkoRirekiDiv);
        if (!handler.hasChangedInMeisai()) {
            return this.onClick_btnHenkoTorikeshi_onYes(henkoRirekiDiv);
        }
        ICallbackMethod methodYes = DivcontrollerMethod.method(SingleButtonType.Free, "onClick_btnHenkoTorikeshi_onYes");
        QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                UrQuestionMessages.入力内容の破棄.getMessage().toString(), "はい", "いいえ");

        ICallbackMethod[] methods = {methodYes};
        message.addInvokeMethod(methods);
        response.addMessage(message);

        boolean flg = Boolean.FALSE;
        RString rowState = new RString(henkoRirekiDiv.getInputMode().toString());
        switch (ViewExecutionStatus.toValue(rowState)) {

            case Add:

                if (!henkoRirekiDiv.getHenkoInput().getTxtHenkoDate().getValue().isEmpty()) {
                    flg = Boolean.TRUE;
                } else if (!henkoRirekiDiv.getHenkoInput().getTxtHenkoTodokedeDate().getValue().isEmpty()) {
                    flg = Boolean.TRUE;
                } else if (henkoRirekiDiv.getHenkoInput().getDdlHenkoJiyu().toString().isEmpty()) {
                    flg = Boolean.TRUE;
                }
                break;

            case Modify:
                int rowIndex = Integer.valueOf(henkoRirekiDiv.getDgHenko().getClickedItem().getId()).intValue();
                dgHenko_Row 選択行 = henkoRirekiDiv.getDgHenko().getDataSource().get(rowIndex);

                RString 変更日 = composeNulltoStr(new RString(henkoRirekiDiv.getHenkoInput().getTxtHenkoDate().getValue().toString()));
                RString 変更届出日 = composeNulltoStr(new RString(henkoRirekiDiv.getHenkoInput().getTxtHenkoTodokedeDate().getValue().toString()));
                RString 変更事由Value = composeNulltoStr(new RString(henkoRirekiDiv.getHenkoInput().getDdlHenkoJiyu().getSelectedValue().toString()));
                RString 変更事由Key = composeNulltoStr(new RString(henkoRirekiDiv.getHenkoInput().getDdlHenkoJiyu().getSelectedKey().toString()));

                RString 旧保険者 = composeNulltoStr(new RString(henkoRirekiDiv.getHenkoInput().getDdlHenkoKyuHokensha().toString()));
                RString 処理日 = composeNulltoStr(new RString(henkoRirekiDiv.getHenkoInput().getHenkojiShoriDatetime().toString()));
                RString 措置元保険者 = composeNulltoStr(new RString(henkoRirekiDiv.getHenkoInput().getDdlHenkoSochimotoHokensha().toString()));

                if (!変更日.equals(composeNulltoStr(new RString(選択行.getHenkoDate().getValue().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!変更届出日.equals(composeNulltoStr(new RString(選択行.getHenkoTodokedeDate().getValue().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!変更事由Value.equals(composeNulltoStr(new RString(選択行.getHenkoJiyu().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!変更事由Key.equals(composeNulltoStr(new RString(選択行.getHenkoJiyuKey().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!旧保険者.equals(composeNulltoStr(new RString(選択行.getKyuHokensha().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!処理日.equals(composeNulltoStr(new RString(選択行.getShoriDate().getValue().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!措置元保険者.equals(composeNulltoStr(new RString(選択行.getSochimotoHokensha().toString())))) {
                    flg = Boolean.TRUE;
                }

                break;

            case Delete:

                break;
            default:
                break;
        }
        if (!flg) {
            return this.onClick_btnHenkoTorikeshi_onYes(henkoRirekiDiv);
        }

        message.addInvokeMethod(methods);

        response.addMessage(message);
        response.data = henkoRirekiDiv;
        return response;
    }

    /**
     * 取消ボタンを押下した際に表示されるダイアログで、はいを選択した際に実行されます。<br/>
     * 明細エリアに入力した情報を破棄し、追加・修正・削除が可能な状態に戻します。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnHenkoTorikeshi_onYes(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        ShikakuHenkoRirekiHandler handler = new ShikakuHenkoRirekiHandler(henkoRirekiDiv);

        handler.clearInputData();
        henkoRirekiDiv.getBtnAdd().setDisabled(false);
        henkoRirekiDiv.getDgHenko().setReadOnly(false);
        handler.setExecutionStatus(ViewExecutionStatus.None);

        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 確定ボタンを押下した際に、onClick処理の前に実行されます。<br/>
     * 入力した情報について、バリデーションチェックを行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onBeforeClick_btnHenkoKakutei(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();

        RString rowState = henkoRirekiDiv.getInputMode();

        IOptional<HihokenshaDaichoModel> 前履歴;
        IOptional<HihokenshaDaichoModel> 次履歴;
        IItemList<HihokenshaDaichoModel> 全履歴;
        HihokenshaDaichoModel select最終更新被保険者 = new HihokenshaDaichoModel();
        FlexibleDate selected資格取得日 = FlexibleDate.EMPTY;
        FlexibleDate selected資格喪失日 = FlexibleDate.EMPTY;
        switch (ViewExecutionStatus.toValue(rowState)) {

            case Add:
                前履歴 = DbOptional.empty();
                次履歴 = DbOptional.empty();
                全履歴 = createHandlerOf(henkoRirekiDiv).get被保険者台帳情報();
                break;
            case Modify:
                int rowIndex = Integer.valueOf(henkoRirekiDiv.getSelectRow().toString()).intValue();

                if (rowIndex != 0) {
                    int rdx = rowIndex - 1;
                    dgHenko_Row row = henkoRirekiDiv.getDgHenko().getDataSource().get(rdx);
                    次履歴 = createHandlerOf(henkoRirekiDiv).get被保険者台帳情報()
                            .filter(ShikakuHenkoMapper.createKey(row))
                            .findJustOne();
                } else {
                    次履歴 = DbOptional.empty();
                }

                if (rowIndex + 1 <= henkoRirekiDiv.getDgHenko().getDataSource().size() - 1) {
                    int rdx = rowIndex + 1;
                    dgHenko_Row row = henkoRirekiDiv.getDgHenko().getDataSource().get(rdx);
                    前履歴 = createHandlerOf(henkoRirekiDiv).get被保険者台帳情報()
                            .filter(ShikakuHenkoMapper.createKey(row))
                            .findJustOne();
                } else {
                    前履歴 = DbOptional.empty();
                }

                全履歴 = ItemList.empty();
                select最終更新被保険者 = createHandlerOf(henkoRirekiDiv).get更新前選択被保険者台帳();
                selected資格取得日 = select最終更新被保険者.get資格取得年月日();
                selected資格喪失日 = select最終更新被保険者.get資格喪失年月日();

                break;
            case Delete:
            default:
                前履歴 = DbOptional.empty();
                次履歴 = DbOptional.empty();
                全履歴 = ItemList.empty();
                break;
        }

        ShikakuHenkoRirekiKanriContext context = new ShikakuHenkoRirekiKanriContext(ViewExecutionStatus.toValue(rowState), 前履歴, 次履歴, 全履歴);

        //TODO テストのため、代入
        henkoRirekiDiv.setLatestSoshitsubi(new RString(""));
        henkoRirekiDiv.setLatestShutokubi(new RString("20140103"));
        henkoRirekiDiv.setLatestKoshinbi(new RString("20190101"));
        henkoRirekiDiv.setIchigoShikakuShutokubi(new RString("20190101"));
        RString 最新喪失日 = henkoRirekiDiv.getLatestSoshitsubi();
        RString 最新取得日 = henkoRirekiDiv.getLatestShutokubi();
        RString 最新更新日 = henkoRirekiDiv.getLatestKoshinbi();
        RString 一号資格取得日 = henkoRirekiDiv.getIchigoShikakuShutokubi();

        pairs.add(ShikakuHenkoRirekiValidationHelper.validate資格変更(
                henkoRirekiDiv.getTxtHenkoDate(), henkoRirekiDiv.getTxtHenkoTodokedeDate(), selected資格取得日, selected資格喪失日,
                最新取得日, 最新喪失日, 最新更新日, 一号資格取得日, henkoRirekiDiv.getDdlHenkoJiyu(), context));

        ResponseData<ShikakuHenkoRirekiDiv> response = new ResponseData<>();

        response.addValidationMessages(pairs);
        response.data = henkoRirekiDiv;
        return response;
    }

    private static RString composeNulltoStr(RString str) {
        RString afterStr;
        if (str == null) {
            afterStr = RString.EMPTY;
        } else {
            afterStr = str;
        }
        return afterStr;
    }

    /**
     * 確定ボタンを押下した時に実行されます。<br/>
     * 明細エリアの入力内容を資格変更履歴一覧に反映します。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnHenkoKakutei(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        ShikakuHenkoRirekiHandler handler = new ShikakuHenkoRirekiHandler(henkoRirekiDiv);
        handler.updateEntryData();
        handler.clearInputData();
        handler.setupToAfterInput();
        handler.setExecutionStatus(ViewExecutionStatus.None);
        return createSettingData(henkoRirekiDiv);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }

    private ShikakuHenkoRirekiHandler createHandlerOf(ShikakuHenkoRirekiDiv requestDiv) {
        return new ShikakuHenkoRirekiHandler(requestDiv);
    }

}
