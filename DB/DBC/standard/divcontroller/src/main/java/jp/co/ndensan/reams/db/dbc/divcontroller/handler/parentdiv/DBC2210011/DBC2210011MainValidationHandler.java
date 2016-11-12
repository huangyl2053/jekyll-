/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011MainDivSpec;
import jp.co.ndensan.reams.db.dbc.service.core.tokubetsukyufujigyosha.TokubetsuKyufuJigyoshaService;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitFactory;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitKind;
import jp.co.ndensan.reams.uz.uza.math.ICheckDigit;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 市町村特別給付・サービス事業者のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBC-3430-010 liuwei2
 */
public class DBC2210011MainValidationHandler {

    private static final int FOUR = 4;
    private static final RString 情報存在 = new RString("1");

    /**
     * 特別給付サービス重複チェック
     *
     * @param pairs ValidationMessageControlPairs
     * @param div DBC2210011MainDiv
     * @return pairs
     */
    public ValidationMessageControlPairs 特別給付サービス重複チェック(ValidationMessageControlPairs pairs, DBC2210011MainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBC2210011MainDivSpec.特別給付サービス重複チェック)
                .thenAdd(NoInputMessages.特別給付サービス重複チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.特別給付サービス重複チェック, div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList(),
                div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList())
                .build().check(messages));
        return pairs;
    }

    /**
     * 登録終了日チェックを行います。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div DBC2210011MainDiv
     * @return pairs
     */
    public ValidationMessageControlPairs 登録終了日チェック(ValidationMessageControlPairs pairs, DBC2210011MainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBC2210011MainDivSpec.登録終了日チェック)
                .thenAdd(NoInputMessages.登録終了日チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.登録終了日チェック, div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD(), div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 事業者コード重複チェック
     *
     * @param pairs ValidationMessageControlPairs
     * @param div DBC2210011MainDiv
     * @return pairs
     */
    public ValidationMessageControlPairs 事業者コード重複チェック(ValidationMessageControlPairs pairs, DBC2210011MainDiv div) {
        RString 県コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getDdlSearchKenCode().getSelectedKey();
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchJigyoshaKubun().getValue();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchGunshiCode().getValue();
        RString cd = RString.EMPTY;
        RString 連番 = RString.EMPTY;
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue() != null) {
            連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchRenban().getValue().padLeft("0", FOUR);
        }
        if (div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getValue() != null) {
            cd = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuSearchJigyoshaCode().getTxtSearchCheckDigit().getValue();
        }
        ICheckDigit icheckgigit = CheckDigitFactory.getInstance(CheckDigitKind.Modulus10);
        RString 入力された事業者コード = icheckgigit.appendModulus(県コード.concat(事業者区分).concat(郡市コード).concat(連番).concat(cd));
        TokubetsuKyufuJigyoshaService service = TokubetsuKyufuJigyoshaService.createTokubetsuKyufuJigyoshaService();
        if (0 < service.count事業者情報(入力された事業者コード)) {
            div.set事業者情報件数(情報存在);
        }
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBC2210011MainDivSpec.事業者コード重複チェック)
                .thenAdd(NoInputMessages.事業者コード重複チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.事業者コード重複チェック)
                .build().check(messages));
        return pairs;
    }

    /**
     * サービス情報作成チェックを行います。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div DBC2210011MainDiv
     * @return pairs
     */
    public ValidationMessageControlPairs サービス情報作成チェック(ValidationMessageControlPairs pairs, DBC2210011MainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBC2210011MainDivSpec.サービス情報作成チェック)
                .thenAdd(NoInputMessages.サービス情報作成チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.サービス情報作成チェック, div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList(),
                div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList())
                .build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        特別給付サービス重複チェック(UrErrorMessages.既に存在, "そのサービス種類"),
        登録終了日チェック(UrErrorMessages.大小関係が不正, "登録終了日"),
        事業者コード重複チェック(DbzErrorMessages.重複あり, "事業者コード"),
        サービス情報作成チェック(DbcErrorMessages.サービス情報作成必要);
        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
