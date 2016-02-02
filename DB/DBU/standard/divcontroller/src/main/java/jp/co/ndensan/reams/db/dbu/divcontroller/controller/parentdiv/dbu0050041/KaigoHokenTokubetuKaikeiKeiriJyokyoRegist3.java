/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0050041;

import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.DBU0050021TransitionEventName.様式４の２;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031TransitionEventName;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031TransitionEventName.検索に戻る;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041.DBU0050041StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0050041.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
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
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3 {

    /**
     * 介護保険特別会計経理状況登録_様式４の３を画面初期化処理しました。
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div> onload(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
        handler.onload();
        if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.画面表示_追加.equals(handler.get画面表示())) {
            return ResponseData.of(div).setState(DBU0050041StateName.add);
        } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.画面表示_修正.equals(handler.get画面表示())) {
            return ResponseData.of(div).setState(DBU0050041StateName.mod);
        } else {
            return ResponseData.of(div).setState(DBU0050041StateName.del);
        }
    }

    /**
     * 「様式４」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div> onClick_btnYoshikiyonno(
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
            RString 内部処理モード = handler.get内部処理モード();
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_修正新規.equals(内部処理モード)
                    || KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_追加.equals(内部処理モード)) {
                if (handler.is画面詳細エリア入力有(
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.前年度以前データ),
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.今年度データ),
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.実質的な収支についてデータ))) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_修正.equals(内部処理モード)) {
                if (handler.is修正データ有(handler.get修正データ())) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            }
        }
        return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４).respond();
    }

    /**
     * 「様式４の２」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div> onClick_btnYoshikiyonnoni(
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
            RString 内部処理モード = handler.get内部処理モード();
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_修正新規.equals(内部処理モード)
                    || KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_追加.equals(内部処理モード)) {
                if (handler.is画面詳細エリア入力有(
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.前年度以前データ),
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.今年度データ),
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.実質的な収支についてデータ))) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_修正.equals(内部処理モード)) {
                if (handler.is修正データ有(handler.get修正データ())) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            }
        }
        return ResponseData.of(div).forwardWithEventName(様式４の２).respond();
    }

    /**
     * 「報告年度」フォーカスロスト処理する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div> lostFocus(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        getHandler(div).lostFocus();
        return ResponseData.of(div).respond();
    }

    /**
     * 「報告年度を確定する」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div> onClick_btnConfirm(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        getHandler(div).onClick_btnConfirm();
        return ResponseData.of(div).respond();
    }

    /**
     * 「追加をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div> onClick_btnAddUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
            if (handler.is画面詳細エリア入力有(
                    handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.前年度以前データ),
                    handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.今年度データ),
                    handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.実質的な収支についてデータ))) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
    }

    /**
     * 「修正をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div> onClick_btnModUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
            RString 内部処理モード = handler.get内部処理モード();
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_修正新規.equals(内部処理モード)) {
                if (handler.is画面詳細エリア入力有(
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.前年度以前データ),
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.今年度データ),
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.実質的な収支についてデータ))) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_修正.equals(内部処理モード)) {
                if (handler.is修正データ有(handler.get修正データ())) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            }
        }
        return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
    }

    /**
     * 「削除をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div> onClick_btnDelUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
    }

    /**
     * 「保存する」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div> onClick_btnSave(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler = getHandler(div);
            RString 内部処理モード = handler.get内部処理モード();
            if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_修正新規.equals(内部処理モード)
                    || KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_追加.equals(内部処理モード)) {
                if (!handler.is画面詳細エリア入力有(
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.前年度以前データ),
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.今年度データ),
                        handler.get各部分画面入力データ(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.実質的な収支についてデータ))) {
                    throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
                }
            } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler.内部処理モード_修正.equals(内部処理モード)) {
                if (!handler.is修正データ有(handler.get修正データ())) {
                    throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
                }
            }
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.処理実行の確認.getMessage().getCode(), UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        getHandler(div).onClick_btnSave();
        return ResponseData.of(div).setState(DBU0050041StateName.com);
    }

    /**
     * 「完了する」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div 介護保険特別会計経理状況登録_様式４の３情報Div}
     * @return 介護保険特別会計経理状況登録_様式４の３情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div> onClick_btnComplete(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.処理完了).respond();
    }

    private KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler getHandler(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div div) {
        return new KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler(div);
    }

}
