/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.IchijiHanteiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE3010001_一次判定処理クラスです。
 *
 * @reamsid_L DBE-1470-010 houtianpeng
 */
public class IchijiHanteiValidatisonHandler {

    private final IchijiHanteiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認対象者一覧Div
     */
    public IchijiHanteiValidatisonHandler(IchijiHanteiDiv div) {
        this.div = div;
    }

    /**
     * 抽出データの件数がNULLの場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs データ空のチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        データ空チェック(validPairs);
        return validPairs;
    }

    /**
     * 対象者一覧データの行選択チェック。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 対象者一覧データの行選択チェック() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.対象者一覧データの行選択チェック,
                    div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran()));
        }
        return validPairs;
    }

    /**
     * データ空チェック
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void データ空チェック(ValidationMessageControlPairs validPairs) {
        if (div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getDataSource() == null
                || div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.該当データなし,
                    div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran()));
        }
    }

    private static enum RRVMessages implements IValidationMessage {

        該当データなし(UrErrorMessages.該当データなし),
        対象者一覧データの行選択チェック(UrErrorMessages.対象行を選択);
        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
