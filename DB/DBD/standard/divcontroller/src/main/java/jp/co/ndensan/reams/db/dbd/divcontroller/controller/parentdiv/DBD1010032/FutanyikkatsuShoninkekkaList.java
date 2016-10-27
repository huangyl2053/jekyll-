/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1010032;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.futangendogakunintei.FutanGendogakuNinteiBatchResult;
import jp.co.ndensan.reams.db.dbd.business.core.futangendogakuyikkatsushonin.FutangendogakuyikkatsuShoninEntity;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032.DBD1010032StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032.FutanyikkatsuShoninkekkaListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010032.FutanyikkatsuShoninkekkaListHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010032.FutanyikkatsuShoninkekkaListValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.IkkatsuShoninKekkaIchiranService;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.ExclusiveLock;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 一括承認結果一覧の画面
 *
 * @reamsid_L DBD-3710-030 xuejm
 */
public class FutanyikkatsuShoninkekkaList {

    private static final RString 承認保存処理完了 = new RString("承認内容の保存処理が完了しました.");
    private static final RString 修正保存処理完了 = new RString("修正内容の保存処理が完了しました.");

    /**
     * 画面初期化処理です。
     *
     * @param div FutanyikkatsuShoninkekkaListDiv
     * @return ResponseData<FutanyikkatsuShoninkekkaListDiv>
     */
    public ResponseData<FutanyikkatsuShoninkekkaListDiv> onLoad(FutanyikkatsuShoninkekkaListDiv div) {
        List<YMDHMS> 一括処理日時list = IkkatsuShoninKekkaIchiranService.createInstance().load一括処理日時();
        ViewStateHolder.put(ViewStateKeys.一括処理日時リスト, new ArrayList<>(一括処理日時list));
        createhandler(div).onLoad(一括処理日時list);
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択する」ボタンをクリックする
     *
     * @param div FutanyikkatsuShoninkekkaListDiv
     * @return ResponseData<FutanyikkatsuShoninkekkaListDiv>
     */
    public ResponseData<FutanyikkatsuShoninkekkaListDiv> onClick_selectbutton(FutanyikkatsuShoninkekkaListDiv div) {
        Boolean 承認済みフラグ = false;
        div.getDatagridhojipanel().getDgNinteiIchiran().getDataSource().clear();
        List<YMDHMS> 一括処理日時list = ViewStateHolder.get(ViewStateKeys.一括処理日時リスト, List.class);
        if (一括処理日時list != null && !一括処理日時list.isEmpty()) {
            RString 一括処理日時 = div.getHyojiTaisho().getDdlBatchShoriNichiji().getSelectedKey();
            int ddlBatchShoriNichiji_index = 0;
            if (一括処理日時 != null && !一括処理日時.isEmpty()) {
                ddlBatchShoriNichiji_index = Integer.parseInt(一括処理日時.replace(new RString("key"), RString.EMPTY).toString());
            }
            FutangendogakuyikkatsuShoninEntity 負担限度額一括認定情報 = IkkatsuShoninKekkaIchiranService.createInstance()
                    .load負担限度額一括認定情報(一括処理日時list.get(ddlBatchShoriNichiji_index));
            createhandler(div).onClick_selectbutton(負担限度額一括認定情報);
            if (負担限度額一括認定情報.get承認済みフラグ() != null) {
                承認済みフラグ = 負担限度額一括認定情報.get承認済みフラグ();
            }
            List<FutanGendogakuNinteiBatchResult> 負担限度額認定バッチ結果 = IkkatsuShoninKekkaIchiranService.createInstance()
                    .load一括承認結果取得(一括処理日時list.get(ddlBatchShoriNichiji_index), 承認済みフラグ);
            ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, new ArrayList<>(負担限度額認定バッチ結果));
            if (負担限度額認定バッチ結果 != null && !負担限度額認定バッチ結果.isEmpty()) {
                div.getDatagridhojipanel().getDgNinteiIchiran().setDataSource(
                        createhandler(div).setDgShinseiIchiran_Row(負担限度額認定バッチ結果));
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「承認を確定する」ボタンを押下のチェック処理します。
     *
     * @param div FutanyikkatsuShoninkekkaListDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<FutanyikkatsuShoninkekkaListDiv> onClick_shonintakuteyibutton(FutanyikkatsuShoninkekkaListDiv div) {
        List<FutanGendogakuNinteiBatchResult> 画面更新用情報
                = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, List.class);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor承認確定対象存在チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(DbdQuestionMessages.負担限度額一括認定_テスト結果承認確認.getMessage().getCode(),
                    DbdQuestionMessages.負担限度額一括認定_テスト結果承認確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<YMDHMS> 一括処理日時list = ViewStateHolder.get(ViewStateKeys.一括処理日時リスト, List.class);
            createhandler(div).ＤＢ処理更新(画面更新用情報, 一括処理日時list);
            div.getCcdKaigoKanryoMessage().setMessage(承認保存処理完了, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBD1010032StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「修正を保存する」ボタンを押下のチェック処理します。
     *
     * @param div FutanyikkatsuShoninkekkaListDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<FutanyikkatsuShoninkekkaListDiv> onClick_shuseyihozonbutton(FutanyikkatsuShoninkekkaListDiv div) {
        if (ExclusiveLock.isLocked(ResponseHolder.getUIContainerId())) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor修正保存対象存在チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        List<FutanGendogakuNinteiBatchResult> 画面更新用情報
                = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, List.class);
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(DbdQuestionMessages.負担限度額一括認定_修正反映確認.getMessage().getCode(),
                    DbdQuestionMessages.負担限度額一括認定_修正反映確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            createhandler(div).ＤＢ更新(画面更新用情報);
            div.getCcdKaigoKanryoMessage().setMessage(修正保存処理完了, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBD1010032StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private FutanyikkatsuShoninkekkaListHandler createhandler(FutanyikkatsuShoninkekkaListDiv div) {
        return new FutanyikkatsuShoninkekkaListHandler(div);
    }

    private FutanyikkatsuShoninkekkaListValidationHandler getValidationHandler() {
        return new FutanyikkatsuShoninkekkaListValidationHandler();
    }
}
