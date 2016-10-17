/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1320001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト出力(介護受給共通)のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3930-011 liwul
 */
public class HanyoListParamValidationHandler {

    private final HanyoListParamDiv div;

    /**
     * コンストラクタです
     *
     * @param div ドメインオブジェクトを取り出したい{@link HanyoListParamDiv}
     */
    public HanyoListParamValidationHandler(HanyoListParamDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタンクリックのバリデーション
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate実行するボタンクリック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _HanyoListParamValidator validator = new _HanyoListParamValidator(div);
        validateResult.add(createDictionary実行するボタンクリック().check(validator.validate()));
        validateResult = 範囲From_Toの大小Check(validateResult);
        return validateResult;

    }

    /**
     * 帳票出力項目チェックのバリデーション
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate帳票出力項目チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _HanyoListParamValidator validator = new _HanyoListParamValidator(div);
        validateResult.add(createDictionary帳票出力項目チェック().check(validator.validate帳票出力項目チェック()));
        validateResult.add(createDictionary実行するボタンクリック().check(validator.validate()));
        validateResult = 範囲From_Toの大小Check(validateResult);
        return validateResult;

    }

    /**
     * 表題のバリデーション
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate表題() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _HanyoListParamValidator validator = new _HanyoListParamValidator(div);
        validateResult.add(new ValidationMessageControlDictionaryBuilder()
                .add(HanyoListParamValidationMessage.帳票出力項目チェック１, div.getTxtHyodaiMeisho()).build().check(validator.validate表題()));
        return validateResult;

    }

    private ValidationMessageControlDictionary createDictionary実行するボタンクリック() {
        return new ValidationMessageControlDictionaryBuilder()
                .add(HanyoListParamValidationMessage.実行するボタンクリック1, div.getDdlKijunNendo())
                .add(HanyoListParamValidationMessage.実行するボタンクリック2, div.getTxtKijunDateA())
                .add(HanyoListParamValidationMessage.実行するボタンクリック3, div.getTxtKijunDateB())
                .add(HanyoListParamValidationMessage.実行するボタンクリック7, div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getTxtNenrei())
                .build();
    }

    private ValidationMessageControlDictionary createDictionary帳票出力項目チェック() {
        return new ValidationMessageControlDictionaryBuilder()
                .add(HanyoListParamValidationMessage.帳票出力項目チェック２, div)
                .add(HanyoListParamValidationMessage.帳票出力項目チェック３, div)
                .build();
    }

    private ValidationMessageControlPairs 範囲From_Toの大小Check(ValidationMessageControlPairs validateResult) {
        if (!check範囲()) {
            validateResult.add(new ValidationMessageControlPair(new ReplaceErrorMessage(
                    div.getTxtChushutsuHani().getToValue().toDateString().toString(),
                    div.getTxtChushutsuHani().getFromValue().toDateString().toString()),
                    div.getTxtChushutsuHani()));
        }
        if (!check生年月日()) {
            validateResult.add(new ValidationMessageControlPair(new ReplaceErrorMessage(
                    div.getCcdHanyoListAtenaSelect().get生年月日開始().toDateString().toString(),
                    div.getCcdHanyoListAtenaSelect().get生年月日終了().toDateString().toString()),
                    div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getTxtSeinengappi()));
        }
        return validateResult;
    }

    private boolean check範囲() {
        if (div.getTxtChushutsuHani().getFromValue() != null && div.getTxtChushutsuHani().getToValue() != null) {
            return div.getTxtChushutsuHani().getFromValue().isBeforeOrEquals(div.getTxtChushutsuHani().getToValue());
        }
        return true;
    }

    private boolean check生年月日() {
        if (div.getCcdHanyoListAtenaSelect().get年齢層抽出方法().getコード().equals(NenreiSoChushutsuHoho.生年月日範囲.getコード())
                && div.getCcdHanyoListAtenaSelect().get生年月日開始() != null
                && div.getCcdHanyoListAtenaSelect().get生年月日終了() != null) {
            return div.getCcdHanyoListAtenaSelect().get生年月日開始().isBeforeOrEquals(div.getCcdHanyoListAtenaSelect().get生年月日終了());
        }
        return true;
    }

    private static class ReplaceErrorMessage implements IValidationMessage {

        private final Message message;

        @Override
        public Message getMessage() {
            return message;
        }

        public ReplaceErrorMessage(String... replacements) {
            this.message = UrErrorMessages.期間が不正_追加メッセージあり１.getMessage().replace(replacements);
        }
    }

}
