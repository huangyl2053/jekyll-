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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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

    private static final RString 保存処理完了 = new RString("承認内容の保存処理が完了しました.");
    private static List<YMDHMS> 一括処理日時list;

    /**
     * 画面初期化処理です。
     *
     * @param div FutanyikkatsuShoninkekkaListDiv
     * @return ResponseData<FutanyikkatsuShoninkekkaListDiv>
     */
    public ResponseData<FutanyikkatsuShoninkekkaListDiv> onLoad(FutanyikkatsuShoninkekkaListDiv div) {
        一括処理日時list = IkkatsuShoninKekkaIchiranService.createInstance().load一括処理日時();
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
        FutangendogakuyikkatsuShoninEntity 負担限度額一括認定情報 = IkkatsuShoninKekkaIchiranService.createInstance()
                .load負担限度額一括認定情報(一括処理日時list.get(0));
        if (負担限度額一括認定情報.get承認済みフラグ() != null) {
            承認済みフラグ = 負担限度額一括認定情報.get承認済みフラグ();
        }
        RString 一括処理日時 = div.getHyojiTaisho().getDdlBatchShoriNichiji().getSelectedKey().trim();
        int ddlBatchShoriNichiji_index = Integer.parseInt(一括処理日時.replace(new RString("key"), RString.EMPTY).toString());
        List<FutanGendogakuNinteiBatchResult> 負担限度額認定バッチ結果 = IkkatsuShoninKekkaIchiranService.createInstance()
                .load一括承認結果取得(一括処理日時list.get(ddlBatchShoriNichiji_index), 承認済みフラグ);
        ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, new ArrayList<>(負担限度額認定バッチ結果));
        createhandler(div).onClick_selectbutton(負担限度額一括認定情報);
        createhandler(div).setDgShinseiIchiran_Row(負担限度額認定バッチ結果);
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
                = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, new ArrayList<>().getClass());
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
            createhandler(div).ＤＢ処理更新(画面更新用情報, 一括処理日時list);
        }
        div.getCcdKaigoKanryoMessage().setMessage(保存処理完了, RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBD1010032StateName.完了);
    }

    /**
     * 「修正を保存する」ボタンを押下のチェック処理します。
     *
     * @param div FutanyikkatsuShoninkekkaListDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<FutanyikkatsuShoninkekkaListDiv> onClick_shuseyihozonbutton(FutanyikkatsuShoninkekkaListDiv div) {
        List<FutanGendogakuNinteiBatchResult> 画面更新用情報
                = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, new ArrayList<>().getClass());
        RStringBuilder 前排他ロックキー = new RStringBuilder();
        RString 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, ShoKisaiHokenshaNo.class).value();
        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, HihokenshaNo.class).value();
        RString 履歴番号 = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, RString.class);
        前排他ロックキー.append(履歴番号);
        前排他ロックキー.append(被保険者番号);
        前排他ロックキー.append(証記載保険者番号);
        if (!RealInitialLocker.tryGetLock(new LockingKey(前排他ロックキー))) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor修正保存対象存在チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(DbdQuestionMessages.負担限度額一括認定_修正反映確認.getMessage().getCode(),
                    DbdQuestionMessages.負担限度額一括認定_修正反映確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            createhandler(div).ＤＢ更新(画面更新用情報);
        }
        RealInitialLocker.release(new LockingKey(前排他ロックキー));
        div.getCcdKaigoKanryoMessage().setMessage(保存処理完了, RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBD1010032StateName.完了);
    }

    private FutanyikkatsuShoninkekkaListHandler createhandler(FutanyikkatsuShoninkekkaListDiv div) {
        return new FutanyikkatsuShoninkekkaListHandler(div);
    }

    private FutanyikkatsuShoninkekkaListValidationHandler getValidationHandler() {
        return new FutanyikkatsuShoninkekkaListValidationHandler();
    }
}
