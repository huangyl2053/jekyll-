/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0050041;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031TransitionEventName;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031TransitionEventName.検索に戻る;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041.DBU0050041StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041.DBU0050041TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041.YoshikiYonnosanDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0050041.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 介護保険特別会計経理状況登録_様式４の３情報Divを制御します。
 */
public class YoshikiYonnosan {

    private static final RString 内部処理モード_修正新規 = new RString("修正新規");
    private static final RString 内部処理モード_修正 = new RString("修正");
    private static final RString 内部処理モード_追加 = new RString("追加");
    private static final RString 内部処理モード_削除 = new RString("削除");
    private static final RString 画面表示_修正 = new RString("修正");
    private static final RString 画面表示_追加 = new RString("追加");
    private static final RString 前年度以前データ = new RString("前年度以前データ");
    private static final RString 今年度データ = new RString("今年度データ");
    private static final RString 実質的な収支についてデータ = new RString("実質的な収支についてデータ");

    /**
     * 介護保険特別会計経理状況登録_様式４の３を画面初期化処理しました。
     *
     * @param div {@link YoshikiYonnosanDiv 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<YoshikiYonnosanDiv> onload(YoshikiYonnosanDiv div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
        handler.onload();
        if (画面表示_追加.equals(handler.get画面表示())) {
            return ResponseData.of(div).setState(DBU0050041StateName.追加状態);
        } else if (画面表示_修正.equals(handler.get画面表示())) {
            return ResponseData.of(div).setState(DBU0050041StateName.修正状態);
        } else {
            return ResponseData.of(div).setState(DBU0050041StateName.削除状態);
        }
    }

    /**
     * 「様式４」ボタンを押下する。<br/>
     *
     * @param div {@link YoshikiYonnosanDiv 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<YoshikiYonnosanDiv> onClick_btnYoshikiyonno(YoshikiYonnosanDiv div) {
        ResponseData<YoshikiYonnosanDiv> responseData = null;
        if (!ResponseHolder.isReRequest()) {
            responseData = getResponseData_btnYoshikiyonno(div);
        }
        if (responseData != null) {
            return responseData;
        }
        RString state = ResponseHolder.getState();
        if (DBU0050031StateName.追加状態.getName().equals(state)) {
            return ResponseData.of(div).forwardWithEventName(DBU0050041TransitionEventName.様式４).parameter(内部処理モード_追加);
        }
        if (DBU0050031StateName.修正状態.getName().equals(state)) {
            return ResponseData.of(div).forwardWithEventName(DBU0050041TransitionEventName.様式４).parameter(内部処理モード_修正);
        }
        if (DBU0050031StateName.削除状態.getName().equals(state)) {
            return ResponseData.of(div).forwardWithEventName(DBU0050041TransitionEventName.様式４).parameter(内部処理モード_削除);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<YoshikiYonnosanDiv> getResponseData_btnYoshikiyonno(
            YoshikiYonnosanDiv div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
        RString 内部処理モード = handler.get内部処理モード();
        QuestionMessage message = new QuestionMessage(
                UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
        if (内部処理モード_修正新規.equals(内部処理モード)
                || 内部処理モード_追加.equals(内部処理モード)) {
            return handler.is画面詳細エリア入力有(
                    handler.get各部分画面入力データ(前年度以前データ),
                    handler.get各部分画面入力データ(今年度データ),
                    handler.get各部分画面入力データ(実質的な収支についてデータ))
                    ? ResponseData.of(div).addMessage(message).respond() : null;
        } else if (内部処理モード_修正.equals(内部処理モード)) {
            return handler.is修正データ有(handler.get修正データ()) ? ResponseData.of(div).addMessage(message).respond() : null;
        }
        return null;
    }

    /**
     * 「様式４の２」ボタンを押下する。<br/>
     *
     * @param div {@link YoshikiYonnosanDiv 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<YoshikiYonnosanDiv> onClick_btnYoshikiyonnoni(
            YoshikiYonnosanDiv div) {
        ResponseData<YoshikiYonnosanDiv> responseData = null;
        if (!ResponseHolder.isReRequest()) {
            responseData = getResponseData_btnYoshikiyonnoni(div);
        }
        if (responseData != null) {
            return responseData;
        }
        RString state = ResponseHolder.getState();
        if (DBU0050031StateName.追加状態.getName().equals(state)) {
            return ResponseData.of(div).forwardWithEventName(DBU0050041TransitionEventName.様式４の２).parameter(内部処理モード_追加);
        }
        if (DBU0050031StateName.修正状態.getName().equals(state)) {
            return ResponseData.of(div).forwardWithEventName(DBU0050041TransitionEventName.様式４の２).parameter(内部処理モード_修正);
        }
        if (DBU0050031StateName.削除状態.getName().equals(state)) {
            return ResponseData.of(div).forwardWithEventName(DBU0050041TransitionEventName.様式４の２).parameter(内部処理モード_削除);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<YoshikiYonnosanDiv> getResponseData_btnYoshikiyonnoni(
            YoshikiYonnosanDiv div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
        RString 内部処理モード = handler.get内部処理モード();
        QuestionMessage message = new QuestionMessage(
                UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
        if (内部処理モード_修正新規.equals(内部処理モード)
                || 内部処理モード_追加.equals(内部処理モード)) {
            return handler.is画面詳細エリア入力有(
                    handler.get各部分画面入力データ(前年度以前データ),
                    handler.get各部分画面入力データ(今年度データ),
                    handler.get各部分画面入力データ(実質的な収支についてデータ))
                    ? ResponseData.of(div).addMessage(message).respond() : null;
        } else if (内部処理モード_修正.equals(内部処理モード)) {
            return 内部処理モード_修正.equals(内部処理モード)
                    ? ResponseData.of(div).addMessage(message).respond() : null;
        }
        return null;
    }

    /**
     * 「報告年度」フォーカスロスト処理する。<br/>
     *
     * @param div {@link YoshikiYonnosanDiv 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<YoshikiYonnosanDiv> lostFocus(YoshikiYonnosanDiv div) {
        getHandler(div).lostFocus();
        return ResponseData.of(div).respond();
    }

    /**
     * 「報告年度を確定する」ボタンを押下する。<br/>
     *
     * @param div {@link YoshikiYonnosanDiv 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<YoshikiYonnosanDiv> onClick_btnConfirm(YoshikiYonnosanDiv div) {
        getHandler(div).onClick_btnConfirm();
        return ResponseData.of(div).respond();
    }

    /**
     * 「追加をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link YoshikiYonnosanDiv 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<YoshikiYonnosanDiv> onClick_btnAddUpdate(YoshikiYonnosanDiv div) {
        ResponseData<YoshikiYonnosanDiv> responseData = null;
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            responseData = handler.is画面詳細エリア入力有(
                    handler.get各部分画面入力データ(前年度以前データ),
                    handler.get各部分画面入力データ(今年度データ),
                    handler.get各部分画面入力データ(実質的な収支についてデータ))
                    ? ResponseData.of(div).addMessage(message).respond() : null;
        }
        if (responseData != null) {
            return responseData;
        }
        return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
    }

    /**
     * 「修正をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link YoshikiYonnosanDiv 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<YoshikiYonnosanDiv> onClick_btnModUpdate(YoshikiYonnosanDiv div) {
        ResponseData<YoshikiYonnosanDiv> responseData = null;
        if (!ResponseHolder.isReRequest()) {
            responseData = getResponseData_btnModUpdate(div);
        }
        if (responseData != null) {
            return responseData;
        }
        return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
    }

    private ResponseData<YoshikiYonnosanDiv> getResponseData_btnModUpdate(
            YoshikiYonnosanDiv div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
        RString 内部処理モード = handler.get内部処理モード();
        QuestionMessage message = new QuestionMessage(
                UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
        if (内部処理モード_修正新規.equals(内部処理モード)) {
            return handler.is画面詳細エリア入力有(
                    handler.get各部分画面入力データ(前年度以前データ),
                    handler.get各部分画面入力データ(今年度データ),
                    handler.get各部分画面入力データ(実質的な収支についてデータ))
                    ? ResponseData.of(div).addMessage(message).respond() : null;
        } else if (内部処理モード_修正.equals(内部処理モード)) {
            return handler.is修正データ有(handler.get修正データ()) ? ResponseData.of(div).addMessage(message).respond() : null;
        }
        return null;
    }

    /**
     * 「削除をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link YoshikiYonnosanDiv 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<YoshikiYonnosanDiv> onClick_btnDelUpdate(YoshikiYonnosanDiv div) {
        return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
    }

    /**
     * 「保存する」ボタンを押下する。<br/>
     *
     * @param div {@link YoshikiYonnosanDiv 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<YoshikiYonnosanDiv> onClick_btnSave(YoshikiYonnosanDiv div) {
        ResponseData<YoshikiYonnosanDiv> responseData = null;
        if (!ResponseHolder.isReRequest()) {
            responseData = throwException_btnSave(div);
        }
        if (responseData != null) {
            return responseData;
        }
        getHandler(div).onClick_btnSave();
        return ResponseData.of(div).setState(DBU0050041StateName.完了状態);
    }

    private ResponseData<YoshikiYonnosanDiv> throwException_btnSave(YoshikiYonnosanDiv div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
        RString 内部処理モード = handler.get内部処理モード();
        ApplicationException exception = null;
        if (内部処理モード_修正新規.equals(内部処理モード)
                || 内部処理モード_追加.equals(内部処理モード)) {
            exception = !handler.is画面詳細エリア入力有(
                    handler.get各部分画面入力データ(前年度以前データ),
                    handler.get各部分画面入力データ(今年度データ),
                    handler.get各部分画面入力データ(実質的な収支についてデータ))
                    ? new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage()) : null;
        } else if (内部処理モード_修正.equals(内部処理モード)) {
            exception = !handler.is修正データ有(handler.get修正データ())
                    ? new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage()) : null;
        }
        if (exception != null) {
            throw exception;
        }
        QuestionMessage message = new QuestionMessage(
                UrQuestionMessages.処理実行の確認.getMessage().getCode(), UrQuestionMessages.処理実行の確認.getMessage().evaluate());
        return ResponseData.of(div).addMessage(message).respond();
    }

    /**
     * 「完了する」ボタンを押下する。<br/>
     *
     * @param div {@link YoshikiYonnosanDiv 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<YoshikiYonnosanDiv> onClick_btnComplete(YoshikiYonnosanDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.処理完了).respond();
    }

    private KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler getHandler(YoshikiYonnosanDiv div) {
        return new KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler(div);
    }

}
