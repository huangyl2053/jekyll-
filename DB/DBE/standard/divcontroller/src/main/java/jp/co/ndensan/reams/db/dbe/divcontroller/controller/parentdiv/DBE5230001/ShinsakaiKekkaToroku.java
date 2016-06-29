/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5230001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.ShinsakaiKekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaToroku {

    private static final RString HASDATA = new RString("1");

    private final ShinsakaiKekkaTorokuManager manager;
    //private final NinteiShinseiJohoManager 要介護認定結果情報Manager;
    //private final ShinsakaiWariateJohoManager 介護認定審査会開催予定情報manager;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKekkaToroku() {
        ViewStateHolder.put(ViewStateKeys.開催番号, new RString("209007"));
        this.manager = ShinsakaiKekkaTorokuManager.createInstance();
        //this.要介護認定結果情報Manager = NinteiShinseiJohoManager.createInstance();
        //this.介護認定審査会開催予定情報manager = new ShinsakaiWariateJohoManager();
    }

    /**
     * 介護認定審査会審査結果登録Divを初期化します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv> 介護認定審査会審査結果登録Div
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onLoad(ShinsakaiKekkaTorokuDiv div) {
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        List<ShinsakaiKekkaTorokuBusiness> headList = manager.getヘッドエリア内容検索(開催番号).records();
        List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList = manager.get審査会委員一覧検索(開催番号).records();
        getHandler(div).onLoad(headList, iChiRanList);

        List<ShinsakaiWariateJoho> yoteiJohoList = manager.get審査会委員一覧検索_業務概念_1(開催番号).records();
        Models<ShinsakaiWariateJohoIdentifier, ShinsakaiWariateJoho> shinsakaiKaisaiYoteiJoho = Models.create(yoteiJohoList);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会開催予定情報, shinsakaiKaisaiYoteiJoho);

        List<NinteiShinseiJoho> shinseiJohoList = manager.get審査会委員一覧検索_業務概念_2(開催番号).records();
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho = Models.create(shinseiJohoList);
        ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, ninteiShinseiJoho);

        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員一覧Gridの「選択」ボタンを押下 ＤＢ介護認定審査会割当委員情報」より物理削除です。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_SelectButton(ShinsakaiKekkaTorokuDiv div) {
        if (HASDATA.equals(div.getKobetsuHyojiArea().getHasData()) && getHandler(div).hasChange()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).setKobetsuHyojiArea();
            }
        } else {
            getHandler(div).setKobetsuHyojiArea();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 登録ボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_KaKuTeiButton(ShinsakaiKekkaTorokuDiv div) {
        if (HASDATA.equals(div.getKobetsuHyojiArea().getHasData()) && getHandler(div).hasChange()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).設定期間Fromと設定期間Toの前後順();
                getHandler(div).有効月数チェック();
                getHandler(div).有効月数範囲チェック();
                getHandler(div).入力チェック();
                getHandler(div).setKobetsuHyojiArea();
            }
        } else {
            getHandler(div).設定期間Fromと設定期間Toの前後順();
            getHandler(div).有効月数チェック();
            getHandler(div).有効月数範囲チェック();
            getHandler(div).入力チェック();
            getHandler(div).setKobetsuHyojiArea();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_Save(ShinsakaiKekkaTorokuDiv div) {
        getHandler(div).対象者一覧件数チェック();
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            getHandler(div).setKobetsuHyojiArea();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「判定結果」ドロップダウンリストの選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_HanteiKekka(ShinsakaiKekkaTorokuDiv div) {
        if (HASDATA.equals(div.getKobetsuHyojiArea().getHasData()) && getHandler(div).hasChange()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).setKobetsuHyojiArea();
            }
        } else {
            getHandler(div).setKobetsuHyojiArea();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「二次判定」ドロップダウンリストの選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NijiHantei(ShinsakaiKekkaTorokuDiv div) {
        if (HASDATA.equals(div.getKobetsuHyojiArea().getHasData()) && getHandler(div).hasChange()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).setKobetsuHyojiArea();
            }
        } else {
            getHandler(div).setKobetsuHyojiArea();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「有効月数」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanMonth(ShinsakaiKekkaTorokuDiv div) {
        if (HASDATA.equals(div.getKobetsuHyojiArea().getHasData()) && getHandler(div).hasChange()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).setKobetsuHyojiArea();
            }
        } else {
            getHandler(div).setKobetsuHyojiArea();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * メモ定型文ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnMemoTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(new RString("5101"));
        return ResponseData.of(div).respond();
    }

    /**
     * 意見書定型文ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIkenTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(new RString("5201"));
        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定結果変更理由ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIChiTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(new RString("5103"));
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会データ空チェックを実施します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<NenreiTotatsuTorokushaListDiv>
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onClick_Check(ShinsakaiKekkaTorokuDiv div) {
//        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        return ResponseData.of(div).respond();
    }

    private ShinsakaiKekkaTorokuHandler getHandler(ShinsakaiKekkaTorokuDiv div) {
        return new ShinsakaiKekkaTorokuHandler(div);
    }
}
