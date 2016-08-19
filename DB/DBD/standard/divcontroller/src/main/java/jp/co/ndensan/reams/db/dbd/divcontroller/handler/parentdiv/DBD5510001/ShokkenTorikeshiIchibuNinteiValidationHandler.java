/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5510001;

import jp.co.ndensan.reams.db.dbd.business.core.shokkentorikeshiichibusoshitu.ShokkenTorikeshiNinteiJohoKonkaiBusiness;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5510001.ShokkenTorikeshiIchibuNinteiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 「職権修正/職権取消(一部)/認定結果入力(サ変・区変)」画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1320-010 zuotao
 */
public class ShokkenTorikeshiIchibuNinteiValidationHandler {

    private final ShokkenTorikeshiIchibuNinteiDiv div;
    private static final RString 履歴番号_申請中データ = new RString("0000");
    private static final RString メニュID_職権取消一部喪失 = new RString("DBDMN55004");

    /**
     * コンストラクタです。
     *
     * @param div 職権修正/職権取消(一部)/認定結果入力(サ変・区変)Div
     */
    public ShokkenTorikeshiIchibuNinteiValidationHandler(ShokkenTorikeshiIchibuNinteiDiv div) {
        this.div = div;
    }

    /**
     * 保存ボタンクリック時のバリデーションチェックです。
     *
     * @param 今回情報 今回情報
     * @return バリデーションチェック結果
     */
    public ValidationMessageControlPairs cheackLoad(ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

        if (今回情報 == null) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                            UrErrorMessages.更新不可_汎用, "認定データが存在しない")));
        } else if (履歴番号_申請中データ.equals(今回情報.get受給者台帳().get履歴番号())) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                            UrErrorMessages.更新不可_汎用, "申請中のデータが存在する")));
        }
        return validationMessages;
    }

    /**
     * 保存ボタンクリック時のバリデーションチェックです。
     *
     * @param menuId メニューID
     * @return バリデーションチェック結果
     */
    public ValidationMessageControlPairs validate(RString menuId) {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        validateResult.add(check申請日());
        validateResult.add(check認定日());
        if (メニュID_職権取消一部喪失.equals(menuId)) {
            validateResult.add(check喪失日());
        }
        validateResult.add(check要介護度());
        validateResult.add(check有効開始日());
        validateResult.add(check有効終了日());
        validateResult.add(check期間日());
        validateResult.add(check期間日());
        return validateResult;
    }

    private ValidationMessageControlPairs check申請日() {
        RDate 申請日 = div.getCcdKaigoNinteiShinseiKihonJohoInput().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (申請日 == null) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, "申請日")));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check認定日() {

        FlexibleDate 今回認定日 = div.getTxtNinteibiKonkai().getValue();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (今回認定日 == null || 今回認定日.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, "認定日")));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check喪失日() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtSoshitsubi().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, "喪失日")));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check要介護度() {

        RString 今回要介護度 = div.getTxtYokaigodoKonkai().getValue();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(今回要介護度)) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, "要介護度")));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check有効開始日() {

        FlexibleDate 今回有効開始日 = div.getTxtYukoKaishibiKonkai().getValue();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (isEmpty(今回有効開始日)) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, "有効開始日")));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check有効終了日() {

        FlexibleDate 今回有効終了日 = div.getTxtYukoShuryobiKonkai().getValue();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (isEmpty(今回有効終了日)) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, "有効終了日")));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check期間日() {

        FlexibleDate 今回有効開始日 = div.getTxtYukoKaishibiKonkai().getValue();
        FlexibleDate 今回有効終了日 = div.getTxtYukoShuryobiKonkai().getValue();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!isEmpty(今回有効開始日) && !isEmpty(今回有効終了日) && 今回有効終了日.isBefore(今回有効開始日)) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                            UrErrorMessages.期間が不正_追加メッセージあり２, "今回有効開始日", "今回有効終了日")));
        }
        FlexibleDate 前回有効終了日 = div.getTxtYukoShuryobiZenkai().getValue();
        if (!isEmpty(今回有効開始日) && !isEmpty(前回有効終了日) && 今回有効開始日.isBefore(前回有効終了日)) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                            UrErrorMessages.期間が不正_追加メッセージあり２, "有効開始日", "有効終了日")));
        }
        return validationMessages;
    }

    /**
     * 保存ボタン押下時、画面情報編集されていない場合、エラーとします。
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs checkデータに変更なし() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(
                new ShokkenTorikeshiIchibuNinteiValidationHandler.ShokkenTorikeshiIchibuNinteiMessages(
                        UrErrorMessages.編集なしで更新不可)));
        return validationMessages;
    }

    private boolean isEmpty(FlexibleDate date) {
        return date == null || date.isEmpty();
    }

    private static final class ShokkenTorikeshiIchibuNinteiMessages implements IValidationMessage {

        private final Message message;

        private ShokkenTorikeshiIchibuNinteiMessages(IMessageGettable message, String... replaceParam) {
            this.message = message.getMessage().replace(replaceParam);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
