/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE9030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.DBE9030001ErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.DBE9030001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.DBE9030001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.NinteichosaItakusakiMasterDivSpec;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9030001.NinteichosaItakusakiMasterHandler;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査委託先マスタのクラスです
 */
public class NinteichosaItakusakiMaster {

    private static final RString CSV出力完了 = new RString("CSV出力");
    private static final RString 削除状態 = new RString("削除");

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onLoad(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE9030001StateName.検索);
    }

    /**
     * 検索条件入力項目をクリアする。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnClearKensakuJoken(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).clearKensakuJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件に従い、調査委託先情報を検索する。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnSearchShujii(NinteichosaItakusakiMasterDiv div) {
        List<KoseiShichosonMaster> list = getHandler(div).searchShujii();
        if (list.isEmpty()) {
            return ResponseData.of(div).addMessage(UrErrorMessages.該当データなし.getMessage()).respond();
        }
        getHandler(div).setDataSource(list);
        return ResponseData.of(div).setState(DBE9030001StateName.一覧);
    }

    /**
     * 追加ボタンが押下された場合、明細エリアを空白で表示する
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnInsert(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).set追加状態();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * 修正アイコンを押下した場合、明細エリアに選択行の内容を表示し、項目を入力可能にする
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByModifyButton_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).set修正状態();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * 削除アイコンを押下した場合、明細エリアに選択行の内容を表示し、項目を入力不可にする
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByDeleteButton_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).set削除状態();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * 選択行の内容を、明細エリアに表示
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onSelectByDlbClick_dgChosainIchiran(NinteichosaItakusakiMasterDiv div) {
        getHandler(div).onSelectByDlbClick_dgChosainIchiran();
        return ResponseData.of(div).setState(DBE9030001StateName.詳細);
    }

    /**
     * ＣＳＶを出力する
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnOutputCsv(NinteichosaItakusakiMasterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先一覧データの存在チェック)
                    .thenAdd(DBE9030001ErrorMessages.対象データなし).messages());
            messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先一覧データの編集しないチェック)
                    .thenAdd(DbzErrorMessages.編集後更新指示).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    DBE9030001ErrorMessages.対象データなし,
                    div.getChosaitakusakiJohoInput()).build().check(messages));
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    DbzErrorMessages.編集後更新指示,
                    div.getChosaitakusakiJohoInput()).build().check(messages));
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        } else {
            getHandler(div).outputCsv();
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(CSV出力完了.toString())).respond();
        }
    }

//TODO DBZ.JigyoshaInputGuideが未作成
//    public ResponseData<NinteichosaItakusakiMasterDiv> onBeforeClick_btnToSearchjigyosha(NinteichosaItakusakiMasterDiv div) {
//        return ResponseData.of(div).respond();
//    }
    /**
     * 割付地区選択ダイアログを表示する。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onBeforeClick_btnToSearchchiku(NinteichosaItakusakiMasterDiv div) {
        div.setHdnTxtCode(div.getChosaitakusakiJohoInput().getTxtChiku().getValue());
        div.getChosaitakusakiJohoInput().getTxtChikuMei().clearValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 割付地区選択ダイアログを表示する。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onOkClose_btnToSearchchiku(NinteichosaItakusakiMasterDiv div) {
        div.getChosaitakusakiJohoInput().getTxtChikuMei().setValue(div.getHdnTxtCodeMeisho());
        return ResponseData.of(div).respond();
    }

    /**
     * 口座情報画面へ遷移する。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnKoza(NinteichosaItakusakiMasterDiv div) {
        //TODO 口座情報画面?
        return ResponseData.of(div).forwardWithEventName(null).respond();
    }

    /**
     * 調査員情報管理「DBE9040001」へ遷移する。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnChosaininsert(NinteichosaItakusakiMasterDiv div) {
        ViewStateHolder.put(SaibanHanyokeyName.調査委託先コード, div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
        return ResponseData.of(div).forwardWithEventName(DBE9030001TransitionEventName.認定調査員へ遷移).respond();
    }

    /**
     * 入力明細エリアの入力内容を破棄し、調査委託先一覧エリアへ戻る
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnTorikeshi(NinteichosaItakusakiMasterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (getHandler(div).is調査委託先情報登録エリア編集有り()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            } else {
                div.getChosaitakusakiJohoInput().clear();
                return ResponseData.of(div).setState(DBE9030001StateName.一覧);
            }
        } else {
            div.getChosaitakusakiJohoInput().clear();
            return ResponseData.of(div).setState(DBE9030001StateName.一覧);
        }
    }

    /**
     * 入力明細エリアの入力内容を調査委託先一覧に反映させる。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnKakutei(NinteichosaItakusakiMasterDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先情報登録エリアの編集状態チェック)
                .thenAdd(DBE9030001ErrorMessages.編集なしで更新不可).messages());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.市町村の合法性チェック)
                .thenAdd(DBE9030001ErrorMessages.入力値が不正_追加メッセージあり).messages());
        messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先コードの重複チェック)
                .thenAdd(DBE9030001ErrorMessages.既に登録済).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                DBE9030001ErrorMessages.編集なしで更新不可,
                div.getChosaitakusakiJohoInput()).build().check(messages));
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                DBE9030001ErrorMessages.入力値が不正_追加メッセージあり,
                div.getChosaitakusakiJohoInput().getTxtShichoson()).build().check(messages));
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                DBE9030001ErrorMessages.既に登録済,
                div.getChosaitakusakiJohoInput().getTxtChosaItakusaki()).build().check(messages));
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).onClick_btnKakutei();
        return ResponseData.of(div).setState(DBE9030001StateName.一覧);
    }

    /**
     * 調査委託先検索へ戻る
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnReSearch(NinteichosaItakusakiMasterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (getHandler(div).is調査委託先情報登録エリア編集有り()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
            } else {
                div.getChosaitakusakiJohoInput().clear();
                return onLoad(div);
            }
        } else {
            div.getChosaitakusakiJohoInput().clear();
            return onLoad(div);
        }
    }

    /**
     * 入力データをＤＢに保存する
     *
     * @param div
     * @return
     */
    public ResponseData<NinteichosaItakusakiMasterDiv> onClick_btnUpdate(NinteichosaItakusakiMasterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div).ifNot(NinteichosaItakusakiMasterDivSpec.調査委託先一覧データの編集中チェック)
                    .thenAdd(DBE9030001ErrorMessages.編集なしで更新不可).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    DBE9030001ErrorMessages.編集なしで更新不可,
                    div.getChosaitakusakiJohoInput()).build().check(messages));
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            } else {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
        } else {
            for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
                if (削除状態.equals(row.getJotai())) {
                    if (!getHandler(div).削除行データの整合性チェック(
                            new LasdecCode(row.getShichosonCode().getColumnValue()), row.getChosaItakusakiCode().getValue())) {
                        return ResponseData.of(div).addMessage(DbeErrorMessages.他の情報で使用している為削除不可.getMessage()).respond();
                    }
                }
            }
            getHandler(div).save調査委託先一覧データ();
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
    }

    private NinteichosaItakusakiMasterHandler getHandler(NinteichosaItakusakiMasterDiv div) {
        return new NinteichosaItakusakiMasterHandler(div);
    }
}
