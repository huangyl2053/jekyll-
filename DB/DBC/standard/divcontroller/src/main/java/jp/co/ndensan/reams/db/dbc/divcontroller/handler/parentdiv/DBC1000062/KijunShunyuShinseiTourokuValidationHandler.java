/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000062;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.KijunShunyuShinseiTourokuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 基準収入額適用申請登録のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class KijunShunyuShinseiTourokuValidationHandler {

    private final KijunShunyuShinseiTourokuDiv div;
    private static final int NUM_1 = 1;
    private static final RString MESSAGE_控除再算出 = new RString("世帯員１人に世帯主チェックを付けて、世帯主を");
    private static final RString MESSAGE_いづれか = new RString("適用開始・算定基準額・決定年月日のいづれか");
    private static final RString MESSAGE_全て = new RString("適用開始・算定基準額・決定年月日の全て");
    private static final RString MESSAGE_XXXX = new RString("xxxx");
    private static final RString MESSAGE_YYYY = new RString("yyyy");
    private static final RString MESSAGE_処理年度 = new RString("処理年度は2015年度～xxxx年度の範囲で入力して下さい。");
    private static final RString MESSAGE_世帯員把握基準日 = new RString("世帯員把握基準日はxxxx年8月1日"
            + "～yyyy年7月31日の範囲で入力して下さい。");
    private static final RString MESSAGE_適用開始 = new RString("適用開始はxxxx年8月～yyyy年7月の範囲で入力して下さい。");
    private static final RString MESSAGE_不整合適用開始 = new RString("適用開始に不整合の年月が存在します。<br>"
            + "・同じ年月<br>" + "・登録してある年月より古い年月");
    private static final RString MESSAGE_総収入額 = new RString("総収入額に金額を設定するために"
            + "、総収入額算出ボタンを押下して下さい。");
    private static final RString MESSAGE_世帯員 = new RString("世帯員が0人の");
    private static final RString MESSAGE_世帯課税 = new RString("世帯課税が非課税の");
    private static final RString MESSAGE_宛先印字者 = new RString("世帯員１人に宛先印字者のチェックを付けて、宛先印字者を");

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public KijunShunyuShinseiTourokuValidationHandler(KijunShunyuShinseiTourokuDiv div) {
        this.div = div;
    }

    /**
     * 控除再算出ボタンの実行時チェックバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 実行時チェックValidate() {
        IValidationMessages messages = new ControlValidator(div).控除再算出Validate();
        return createDictionary().check(messages);
    }

    /**
     * 明細パネルチェックバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 明細パネルチェックValidate() {
        IValidationMessages messages = new ControlValidator(div).明細パネルValidate();
        return create明細パネルDictionary().check(messages);
    }

    /**
     * 明細Gridチェックバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 明細GridチェックValidate() {
        IValidationMessages messages = new ControlValidator(div).明細GridValidate();
        return create明細GridDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KijunShunyuShinseiTourokuValidationMessages.控除再算出チェックMessage)
                .build();
    }

    private ValidationDictionary create明細パネルDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KijunShunyuShinseiTourokuValidationMessages.適用データチェックMessage)
                .add(new IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, MESSAGE_処理年度.toString()
                                .replace(MESSAGE_XXXX, DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, RDate.getNowDate(),
                                                SubGyomuCode.DBB介護賦課))))
                .add(get入力値が不正Message(MESSAGE_世帯員把握基準日,
                                div.getMeisai().getTxtShoriNendo().getValue().getYear().toDateString(),
                                div.getMeisai().getTxtShoriNendo().getValue().getYear().plusYear(NUM_1).toDateString()))
                .add(get入力値が不正Message(MESSAGE_適用開始, div.getMeisai().getTxtShoriNendo().getValue().getYear().toDateString(),
                                div.getMeisai().getTxtShoriNendo().getValue().getYear().plusYear(NUM_1).toDateString()))
                .add(KijunShunyuShinseiTourokuValidationMessages.適用開始に不整合チェックMessage)
                .add(KijunShunyuShinseiTourokuValidationMessages.総収入額チェックMessage)
                .add(KijunShunyuShinseiTourokuValidationMessages.世帯員チェックMessage)
                .add(KijunShunyuShinseiTourokuValidationMessages.世帯課税チェックMessage)
                .build();
    }

    private ValidationDictionary create明細GridDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KijunShunyuShinseiTourokuValidationMessages.宛先印字者チェックMessage)
                .build();
    }

    private static class ControlValidator {

        private final KijunShunyuShinseiTourokuDiv div;

        public ControlValidator(KijunShunyuShinseiTourokuDiv div) {
            this.div = div;
        }

        /**
         * 控除再算出ボタンの実行時チェックバリデーションチェックです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 控除再算出Validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KijunShunyuShinseiTourokuSpec.控除再算出チェック)
                    .thenAdd(KijunShunyuShinseiTourokuValidationMessages.控除再算出チェックMessage)
                    .messages());
            return messages;
        }

        /**
         * 明細パネルのバリデーションチェックです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 明細パネルValidate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KijunShunyuShinseiTourokuSpec.適用データチェック)
                    .thenAdd(KijunShunyuShinseiTourokuValidationMessages.適用データチェックMessage)
                    .ifNot(KijunShunyuShinseiTourokuSpec.処理年度チェック)
                    .thenAdd(new IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, MESSAGE_処理年度.toString()
                                    .replace(MESSAGE_XXXX, DbBusinessConfig.get(
                                                    ConfigNameDBB.日付関連_所得年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課))))
                    .ifNot(KijunShunyuShinseiTourokuSpec.世帯員把握基準日チェック)
                    .thenAdd(get入力値が不正Message(MESSAGE_世帯員把握基準日,
                                    div.getMeisai().getTxtShoriNendo().getValue().getYear().toDateString(),
                                    div.getMeisai().getTxtShoriNendo().getValue().getYear().plusYear(NUM_1).toDateString()))
                    .ifNot(KijunShunyuShinseiTourokuSpec.適用開始チェック１)
                    .thenAdd(get入力値が不正Message(MESSAGE_適用開始,
                                    div.getMeisai().getTxtShoriNendo().getValue().getYear().toDateString(),
                                    div.getMeisai().getTxtShoriNendo().getValue().getYear().plusYear(NUM_1).toDateString()))
                    .ifNot(KijunShunyuShinseiTourokuSpec.適用開始チェック２)
                    .thenAdd(KijunShunyuShinseiTourokuValidationMessages.適用開始に不整合チェックMessage)
                    .ifNot(KijunShunyuShinseiTourokuSpec.総収入額チェック)
                    .thenAdd(KijunShunyuShinseiTourokuValidationMessages.総収入額チェックMessage)
                    .ifNot(KijunShunyuShinseiTourokuSpec.世帯員が0人)
                    .thenAdd(KijunShunyuShinseiTourokuValidationMessages.世帯員チェックMessage)
                    .ifNot(KijunShunyuShinseiTourokuSpec.世帯課税チェック)
                    .thenAdd(KijunShunyuShinseiTourokuValidationMessages.世帯課税チェックMessage)
                    .messages());
            return messages;
        }

        /**
         * 明細Gridのバリデーションチェックです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 明細GridValidate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KijunShunyuShinseiTourokuSpec.宛先印字者チェック)
                    .thenAdd(KijunShunyuShinseiTourokuValidationMessages.宛先印字者チェックMessage)
                    .messages());
            return messages;
        }
    }

    private static IdocheckMessages get入力値が不正Message(RString message, RString 開始, RString 終了) {
        return new IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, message.toString().replace(MESSAGE_XXXX, 開始)
                .replace(MESSAGE_YYYY, 終了));
    }

    private static enum KijunShunyuShinseiTourokuValidationMessages implements IValidationMessage {

        控除再算出チェックMessage(UrErrorMessages.未指定, MESSAGE_控除再算出.toString()),
        適用データチェックMessage(DbzErrorMessages.複数必須項目相関チェックエラー, MESSAGE_いづれか.toString(), MESSAGE_全て.toString()),
        適用開始に不整合チェックMessage(UrErrorMessages.入力値が不正_追加メッセージあり, MESSAGE_不整合適用開始.toString()),
        総収入額チェックMessage(UrErrorMessages.必須項目_追加メッセージあり, MESSAGE_総収入額.toString()),
        世帯員チェックMessage(UrErrorMessages.更新不可_汎用, MESSAGE_世帯員.toString()),
        世帯課税チェックMessage(UrErrorMessages.更新不可_汎用, MESSAGE_世帯課税.toString()),
        宛先印字者チェックMessage(UrErrorMessages.未指定, MESSAGE_宛先印字者.toString());

        private final Message message;

        KijunShunyuShinseiTourokuValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
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
