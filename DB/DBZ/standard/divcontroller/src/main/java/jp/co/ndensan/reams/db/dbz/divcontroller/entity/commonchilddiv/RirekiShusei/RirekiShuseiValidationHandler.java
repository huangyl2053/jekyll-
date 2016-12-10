/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RirekiShusei;

import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbz.business.core.rirekishusei.RirekiShuseiDataPass;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div「履歴修正」のValidationHandlerクラスです
 *
 * @reamsid_L DBZ-1330-030 chengsanyuan
 */
public class RirekiShuseiValidationHandler {

    private final RirekiShuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 履歴修正Div
     */
    public RirekiShuseiValidationHandler(RirekiShuseiDiv div) {
        this.div = div;
    }

    /**
     * 認定情報にて、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validate認定情報() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RDate ninteiValue = div.getCcdNinteiJohoInput().getNaiyo().get認定年月日();
        RDate fromValue = div.getCcdNinteiJohoInput().getNaiyo().get有効開始年月日();
        RDate toValue = div.getCcdNinteiJohoInput().getNaiyo().get有効終了年月日();
        RString 要介護度 = div.getCcdNinteiJohoInput().getNaiyo().get要介護度コード();
        if (isNullOrEmpty(ninteiValue)) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須,
                            "認定日")));
        }
        if (RString.isNullOrEmpty(要介護度)) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須,
                            "要介護度")));
        }
        if (isNullOrEmpty(fromValue)) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrWarningMessages.未入力,
                            "開始日")));
        }
        if (isNullOrEmpty(toValue)) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrWarningMessages.未入力,
                            "終了日")));
        }
        if (!isNullOrEmpty(fromValue) && !isNullOrEmpty(toValue) && toValue.isBefore(fromValue)) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.期間が不正_追加メッセージあり１,
                            "開始日", "終了日")));
        }
        return validPairs;
    }

    /**
     * 認定期間が重複バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validate認定期間が重複() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RDate konkaiFromValue = div.getCcdNinteiJohoInput().getNaiyo().get有効開始年月日();
        RDate konkaiToValue = div.getCcdNinteiJohoInput().getNaiyo().get有効終了年月日();
        FlexibleDate zenkaiToValue = div.getCcdZenkaiNinteiKekka().getTxtYukoKikanTo().getValue();
        RirekiShuseiDataPass jikai = DataPassingConverter.deserialize(div.getHdnJikaiJohoSerialized(),
                RirekiShuseiDataPass.class);

        if (!isNullOrEmpty(konkaiFromValue) && !isNullOrEmptyFlexibleDate(zenkaiToValue) && konkaiFromValue.isBefore(new RDate(zenkaiToValue.toString()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.期間が不正_追加メッセージあり１,
                            "前回の有効終了日", "今回の有効開始日")));
        }
        if (jikai != null && !isNullOrEmpty(jikai.get認定有効開始年月日())
                && !isNullOrEmpty(konkaiToValue) && jikai.get認定有効開始年月日().isBefore(konkaiToValue)) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.期間が不正_追加メッセージあり１,
                            "今回の有効終了日", "次回の有効開始日")));
        }
        return validPairs;
    }

    /**
     * みなし更新の整合性チェックバリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateみなし更新の整合性チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        boolean みなし更新 = div.getCcdNinteiJohoInput().getNaiyo().getみなし更新認定().isEmpty();
        RString 申請種別 = div.getCcdKaigoNinteiShinseiKihonJohoInput().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiShubetsu().getSelectedKey();
        if (!みなし更新 && !JukyuShinseiJiyu.要介護度変更申請.getコード().equals(申請種別)) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.更新不可_汎用,
                            "申請種別が変更申請・新規支援以外である")));
        }
        return validPairs;
    }

    /**
     * 削除事由必須のチェックバリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validate削除事由必須のチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString deleteKey = div.getHdnDeleteKey();
        RirekiShuseiDataPass zenkai = DataPassingConverter.deserialize(div.getHdnKonkaiJohoSerialized(),
                RirekiShuseiDataPass.class);
        RString 削除事由コード = div.getCcdShinseiSonotaJohoInput().get削除事由();
        if ((!RString.isNullOrEmpty(deleteKey) || (zenkai.get削除事由コード() != null && !zenkai.get削除事由コード().isEmpty()))
                && RString.isNullOrEmpty(削除事由コード)) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.選択されていない,
                            "削除事由")));
        }
        return validPairs;
    }

    private boolean isNullOrEmpty(RDate flexDate) {
        return !(flexDate != null);
    }

    private boolean isNullOrEmptyFlexibleDate(FlexibleDate flexDate) {
        return !(flexDate != null && !flexDate.isEmpty());
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
