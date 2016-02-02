/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0050021;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0050011.TaishokensakuJyouken;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.DBU0050021StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.DBU0050021TransitionEventName;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.DBU0050021TransitionEventName.様式４の２;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div;
import static jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031TransitionEventName.検索に戻る;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0050021.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpoEntity;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 介護保険特別会計経理状況登録_様式４情報Divを制御します。
 */
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1 {

    /**
     * 介護保険特別会計経理状況登録_様式４を画面初期化処理しました。
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onload(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
        handler.onload();
        if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.画面表示_追加.equals(handler.get画面表示())) {
            return ResponseData.of(div).setState(DBU0050021StateName.add);
        } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.画面表示_修正.equals(handler.get画面表示())) {
            return ResponseData.of(div).setState(DBU0050021StateName.mod);
        } else {
            return ResponseData.of(div).setState(DBU0050021StateName.del);
        }
    }

    /**
     * 「報告年度」フォーカスロスト処理しました。
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> lostFocus(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        getHandler(div).lostFocus();
        return ResponseData.of(div).respond();
    }

    /**
     * 「様式４の２」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnYoshikiyonnoni(
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_修正.equals(handler.get内部処理モード())) {
                KaigoHokenJigyoHokokuNenpoEntity 修正データ = handler.get修正データ();
                if (修正データ != null && !修正データ.get詳細データエリア().isEmpty()) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_修正追加.equals(handler.get内部処理モード())
                    || KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_追加.equals(handler.get内部処理モード())) {
                if (handler.is画面詳細エリア入力有(handler.get画面入力データ())) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            }
        }
        return ResponseData.of(div).forwardWithEventName(様式４の２).respond();
    }

    /**
     * 「様式４の３」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_bntYoskiyonosan(
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_修正.equals(handler.get内部処理モード())) {
                KaigoHokenJigyoHokokuNenpoEntity 修正データ = handler.get修正データ();
                if (修正データ != null && !修正データ.get詳細データエリア().isEmpty()) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_修正追加.equals(handler.get内部処理モード())
                    || KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_追加.equals(handler.get内部処理モード())) {
                if (handler.is画面詳細エリア入力有(handler.get画面入力データ())) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            }
        }
        KaigoHokenShoriDateKanriEntity 処理日付管理マスタ = getHandler(div).get処理日付管理マスタ();
        ViewStateHolder.put(TaishokensakuJyouken.ViewStateKey.様式４の３, (Serializable) 処理日付管理マスタ);
        return ResponseData.of(div).forwardWithEventName(DBU0050021TransitionEventName.様式４の３).respond();
    }

    /**
     * 「追加をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnAddUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
            if (handler.is画面詳細エリア入力有(handler.get画面入力データ())) {
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
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnModUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.入力内容の破棄.getMessage().getCode(), UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_修正.equals(handler.get内部処理モード())) {
                KaigoHokenJigyoHokokuNenpoEntity 修正データ = handler.get修正データ();
                if (修正データ != null && !修正データ.get詳細データエリア().isEmpty()) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_修正追加.equals(handler.get内部処理モード())) {
                if (handler.is画面詳細エリア入力有(handler.get画面入力データ())) {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            }
        }
        return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
    }

    /**
     * 「削除をやめる」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnDelUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
    }

    /**
     * 「保存する」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnSave(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler = getHandler(div);
            KaigoHokenJigyoHokokuNenpoEntity 画面入力データ = handler.get画面入力データ();
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.処理実行の確認.getMessage().getCode(), UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_追加.equals(handler.get内部処理モード())) {
                if (!handler.is画面詳細エリア入力有(画面入力データ)) {
                    throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
                } else {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_修正.equals(handler.get内部処理モード())) {
                KaigoHokenJigyoHokokuNenpoEntity 修正データ = handler.get修正データ();
                if (修正データ != null && !修正データ.get詳細データエリア().isEmpty()) {
                    return ResponseData.of(div).addMessage(message).respond();
                } else {
                    throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
                }
            } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_修正追加.equals(handler.get内部処理モード())) {
                if (!handler.is画面詳細エリア入力有(画面入力データ)) {
                    throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
                } else {
                    return ResponseData.of(div).addMessage(message).respond();
                }
            } else if (KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler.内部処理モード_削除.equals(handler.get内部処理モード())) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        getHandler(div).onClick_btnSave();
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnComplete(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        return ResponseData.of(div).forwardWithEventName(DBU0050021TransitionEventName.処理完了).respond();
    }

    /**
     * 「報告年度を確定する」ボタンを押下する。<br/>
     *
     * @param div {@link KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div 介護保険特別会計経理状況登録_様式４情報Div}
     * @return 介護保険特別会計経理状況登録_様式４情報Divを持つResponseData
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> onClick_btnConfirm(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        getHandler(div).onClick_btnConfirm();
        return ResponseData.of(div).respond();
    }

    private KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler getHandler(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        return new KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler(div);
    }

}
